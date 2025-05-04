from flask import Flask, request, jsonify
from flask_cors import CORS
import base64
import cv2
import numpy as np
import face_recognition
import os
from datetime import datetime

app = Flask(__name__)
FRONTEND_ORIGIN = os.getenv("FRONTEND_ORIGIN", "http://localhost:5173/")
# FRONTEND_ORIGIN = os.getenv("FRONTEND_ORIGIN", "https://talenthub.io.vn/")
UPLOAD_FOLDER = os.getenv("UPLOAD_FOLDER", "faces")

CORS(app, resources={r"/api/*": {"origins": FRONTEND_ORIGIN}})
os.makedirs(UPLOAD_FOLDER, exist_ok=True)

def base64_to_image(base64_str):
    if "," in base64_str:
        base64_data = base64_str.split(",")[1]
    else:
        base64_data = base64_str


    # ✨ Bổ sung padding nếu thiếu
    missing_padding = len(base64_data) % 4
    if missing_padding != 0:
        base64_data += '=' * (4 - missing_padding)

    try:
        img_data = base64.b64decode(base64_data)
        nparr = np.frombuffer(img_data, np.uint8)
        return cv2.imdecode(nparr, cv2.IMREAD_COLOR)
    except Exception as e:
        print("Failed to decode base64 image:", str(e))
        return None


@app.route("/api/register-face", methods=["POST"])
def register_face():
    data = request.json
    user_id = data["userId"]
    images_by_dir = data["images"]  # {'front': [...], 'left': [...], 'right': [...]}
    user_folder = os.path.join(UPLOAD_FOLDER, user_id)
    os.makedirs(user_folder, exist_ok=True)

    saved = []
    skipped = []
    idx = 0  # global index

    for direction in ["front", "left", "right"]:
        images = images_by_dir.get(direction, [])
        for base64_img in images:
            image = base64_to_image(base64_img)
            if image is None:
                print(f"Image {idx} is None")
                skipped.append(idx)
                idx += 1
                continue

            timestamp = datetime.now().strftime("%Y%m%d_%H%M%S_%f")
            filename = f"{direction}_{timestamp}_{idx}.jpg"
            path = os.path.join(user_folder, filename)
            success = cv2.imwrite(path, image)
            if success:
                saved.append(filename)
            else:
                skipped.append(idx)
            idx += 1

    total_images = sum(len(imgs) for imgs in images_by_dir.values())
    success = len(saved) == total_images

    return jsonify({
        "success": success,
        "message": f"{len(saved)} images saved, {len(skipped)} skipped.",
        "saved": saved,
        "skipped_indices": skipped
    }), 200


@app.route("/api/verify-face", methods=["POST"])
def verify_face():
    data = request.json
    user_id = data["userId"]
    image = base64_to_image(data["image"])
    
    # Lưu ảnh xác thực vào thư mục user
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    user_folder = os.path.join(UPLOAD_FOLDER, user_id)
    os.makedirs(user_folder, exist_ok=True)
    verify_path = os.path.join(user_folder, f"verify_{timestamp}.jpg")
    cv2.imwrite(verify_path, image)

    try:
        # Load all training images
        if not os.path.exists(user_folder):
            return jsonify({"success": False, "message": "No registered face found"})

        encodings = []
        for file in os.listdir(user_folder):
            # if file.startswith("verify_"):
            #     continue  # bỏ qua ảnh xác thực cũ
            img_path = os.path.join(user_folder, file)
            img = face_recognition.load_image_file(img_path)
            faces = face_recognition.face_encodings(img)
            if faces:
                encodings.append(faces[0])

        if not encodings:
            print("🔥 ERROR: ", traceback.format_exc())
            return jsonify({"success": False, "message": "No encodings found"})

        # Xử lý ảnh xác thực
        img_check = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        check_encoding = face_recognition.face_encodings(img_check)
        if not check_encoding:
            return jsonify({"success": False, "message": "No face detected in verification image"})

        encode_check = check_encoding[0]

        # So sánh
        results = face_recognition.compare_faces(encodings, encode_check)
        distances = face_recognition.face_distance(encodings, encode_check)

        success = any(results)
        min_distance = float(min(distances)) if distances.any() else None

        return jsonify({
            "success": success,
            "distance": min_distance,
            "verify_image": verify_path
        })
    except Exception as e:
        return jsonify({"success": False, "error": str(e)}), 500


@app.route("/api/check-face-registered")
def check_face_registered():
    user_id = request.args.get("userId")
    user_folder = os.path.join(UPLOAD_FOLDER, user_id)

    if not os.path.exists(user_folder):
        return jsonify({"registered": False})

    files = [f for f in os.listdir(user_folder) if not f.startswith("verify_")]
    return jsonify({"registered": len(files) >= 1})


if __name__ == "__main__":
    app.run(debug=True)
