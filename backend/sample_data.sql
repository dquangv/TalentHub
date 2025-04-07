-- create
-- database job_e_commerce_platform;

use job_e_commerce_platform;

INSERT INTO school (school_name) VALUES ('Đại học Bách Khoa TP.HCM'),
       ('Đại học Khoa học Tự nhiên TP.HCM'),
       ('Đại học Khoa học Xã hội và Nhân văn TP.HCM'),
       ('Đại học Công nghệ Thông tin TP.HCM'),
       ('Đại học Quốc tế TP.HCM'),
       ('Đại học Kinh tế - Luật TP.HCM'),
       ('Đại học Sư phạm Kỹ thuật TP.HCM'),
       ('Đại học Sư phạm TP.HCM'),
       ('Đại học Y Dược TP.HCM'),
       ('Đại học Ngoại thương - Cơ sở TP.HCM'),
       ('Đại học Ngân hàng TP.HCM'),
       ('Đại học Công nghiệp TP.HCM'),
       ('Đại học Giao thông Vận tải - Cơ sở TP.HCM'),
       ('Đại học Kiến trúc TP.HCM'),
       ('Đại học Văn Lang'),
       ('Đại học Hoa Sen'),
       ('Đại học HUTECH'),
       ('Đại học Nguyễn Tất Thành'),
       ('Đại học Tôn Đức Thắng'),
       ('Đại học FPT TP.HCM');

INSERT INTO major (major_name) VALUES ('Lập trình viên (Software Developer)'),
       ('Thiết kế đồ họa (Graphic Design)'),
       ('Chỉnh sửa video (Video Editing)'),
       ('Marketing kỹ thuật số (Digital Marketing)'),
       ('SEO & Content Marketing'),
       ('Viết nội dung (Content Writing)'),
       ('Dịch thuật & Biên tập (Translation & Editing)'),
       ('Thiết kế UI/UX'),
       ('Nhiếp ảnh & Chỉnh sửa ảnh (Photography & Photo Editing)'),
       ('Giảng dạy trực tuyến (Online Tutoring)'),
       ('Phát triển Web (Web Development)'),
       ('Phát triển ứng dụng di động (Mobile App Development)'),
       ('Lập trình game (Game Development)'),
       ('Kinh doanh & Tư vấn tài chính cá nhân'),
       ('Hỗ trợ khách hàng từ xa (Remote Customer Support)'),
       ('Quản lý dự án tự do (Freelance Project Management)'),
       ('Âm nhạc & Sản xuất âm thanh (Music & Audio Production)'),
       ('Kỹ thuật viên CAD (CAD Technician)'),
       ('Chuyên gia an ninh mạng (Cybersecurity Specialist)'),
       ('Quay phim & Dựng phim tự do');

INSERT INTO degree (degree_title) VALUES ('Cử nhân'),
       ('Kỹ sư'),
       ('Thạc sĩ'),
       ('Tiến sĩ'),
       ('Cao đẳng'),
       ('Chứng chỉ');

-- pass 123
INSERT INTO account (email, password, role, created_at, updated_at, status, lat, lng) VALUES ('tungvtps27852@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'ADMIN', NOW(),
        null, 0, null, null),
       ('quangvdps36680@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER',
        NOW(), null, 0, null, null),
       ('quangbmps28437@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 1, null, null),
       ('tiendqpc07858@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(),
        null, 0, null, null),
       ('huydqpc07859@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 0, null, null),
       ('hoanganhps34567@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER',
        NOW(), null, 0, null, null),
       ('minhthanhps12345@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 0, null, null),
       ('ngoclanps56789@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER',
        NOW(), null, 2, null, null),
       ('vietanhps98765@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'ADMIN', NOW(),
        null, 0, null, null),
       ('thanhsonps43210@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 1, null, null),
       ('lananhps88888@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(),
        null, 0, null, null),
       ('hoanglongps77777@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 0, null, null),
       ('kimnganps66666@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER',
        NOW(), null, 0, null, null),
       ('minhtrietps55555@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(),
        null, 1, null, null),
       ('hieunguyenps44444@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER',
        NOW(), null, 2, null, null);

INSERT INTO users (first_name, last_name, phone_number, province, country, title, introduction, image, account_id)
VALUES ('Tùng', 'Võ', '0976543210', 'Đống Đa', 'Hà Nội', 'Frontend Developer',
        'Chuyên gia ReactJS, VueJS với nhiều dự án UI/UX hiện đại.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/Huy.jpg', 1),
       ('Quang', 'Vũ', '0987654321', 'Tân Phú', 'Hồ Chí Minh', 'Backend Developer',
        'Lập trình viên backend với 3 năm kinh nghiệm trong Java Spring Boot.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/QuangV.jpg', 2),
       ('Quang', 'Bùi', '0965432109', 'Bình Thạnh', 'Đà Nẵng', 'CEO', 'Chủ doanh nghiệp công ty công nghệ.',
        'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/QuangB.jpg', 3),
       ('Tiến', 'Đinh', '0954321098', 'Gò Vấp', 'Cần Thơ', 'Digital Marketer',
        'Chuyên gia SEO, quảng cáo Google Ads và Facebook Ads.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/Tien.jpg', 4),
       ('Huy', 'Đinh', '0943210987', 'Gò Vấp', 'Cần Thơ', 'Tech Lead',
        '10 năm kinh nghiệm với vai trò Back-end Development.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/Tung.jpg', 5),
       ('Hoàng Anh', 'Phạm', '0912345678', 'Cầu Giấy', 'Hà Nội', 'Mobile Developer',
        'Phát triển ứng dụng Android/iOS với Flutter và React Native.', 'hoanganhpham.png', 6),
       ('Minh Thành', 'Nguyễn', '0923456789', 'Thủ Đức', 'Hồ Chí Minh', 'Project Manager',
        'Quản lý và điều phối các dự án phần mềm quy mô lớn.', 'minhthanhnguyen.png', 7),
       ('Ngọc Lan', 'Trần', '0934567890', 'Ninh Kiều', 'Cần Thơ', 'Data Analyst',
        'Phân tích dữ liệu và trực quan hóa với Power BI và Tableau.', 'ngoclantran.png', 8),
       ('Việt Anh', 'Lê', '0945678901', 'Thanh Xuân', 'Hà Nội', 'System Administrator',
        'Quản trị hệ thống mạng, server, bảo mật hạ tầng CNTT.', 'vietanhle.png', 9),
       ('Thành Sơn', 'Đỗ', '0956789012', 'Liên Chiểu', 'Đà Nẵng', 'Business Analyst',
        'Phân tích nghiệp vụ, đưa ra giải pháp cho các hệ thống phần mềm.', 'thanhsondo.png', 10),
       ('Lan Anh', 'Nguyễn', '0901234567', 'Ba Đình', 'Hà Nội', 'Video Editor',
        'Chuyên gia chỉnh sửa video quảng cáo, hậu kỳ chuyên nghiệp cho các sự kiện và phim ngắn.', 'lananhnguyen.png',
        11),
       ('Hoàng Long', 'Trần', '0912345678', 'Quận 1', 'Hồ Chí Minh', 'Agency Manager',
        'Đại diện công ty thiết kế đồ họa, chuyên tìm kiếm đối tác freelancer tài năng.', 'hoanglongtran.png', 12),
       ('Kim Ngân', 'Phạm', '0923456789', 'Nha Trang', 'Khánh Hòa', 'Translator & Editor',
        'Phiên dịch và biên tập viên chuyên nghiệp cho các tài liệu kỹ thuật, pháp lý và sáng tạo.', 'kimnganpham.png',
        13),
       ('Minh Triết', 'Lê', '0934567890', 'Thanh Xuân', 'Hà Nội', 'Studio Owner',
        'Chủ studio chụp ảnh cưới, thời trang và sản phẩm, cần hợp tác với freelancer chỉnh sửa ảnh.',
        'minhtrietle.png', 14),
       ('Hiếu', 'Nguyễn', '0945678901', 'Thủ Dầu Một', 'Bình Dương', 'Online Tutor',
        'Giảng viên trực tuyến, chuyên đào tạo kỹ năng Digital Marketing và Content Writing.', 'hieunguyen.png', 15);


INSERT INTO chat_messages (sender_id, receiver_id, content, sent_at, is_read)
VALUES
    -- Admin (1) with Freelancer Quang Vũ (2) - Account verification issue
    (2, 1, 'Chào admin, tôi gặp vấn đề khi xác minh tài khoản. Tôi đã gửi CMND nhưng chưa nhận được phản hồi sau 3 ngày.', NOW() - INTERVAL 10 DAY, true),
    (1, 2, 'Chào anh Quang Vũ, cảm ơn đã liên hệ. Tôi sẽ kiểm tra ngay tình trạng xác minh tài khoản của anh.', NOW() - INTERVAL 10 DAY, true),
    (1, 2, 'Tôi đã kiểm tra và thấy có vấn đề kỹ thuật với hình ảnh CMND của anh. Anh có thể gửi lại tài liệu để chúng tôi xử lý không?', NOW() - INTERVAL 9 DAY, true),
    (2, 1, 'Cảm ơn admin. Tôi sẽ gửi lại ngay. CMND của tôi có bị mờ không?', NOW() - INTERVAL 9 DAY, true),
    (1, 2, 'Đúng vậy, hình ảnh hơi mờ và bị cắt một phần. Vui lòng chụp rõ và đảm bảo cả 4 góc CMND đều hiển thị trong ảnh.', NOW() - INTERVAL 8 DAY, true),

-- Admin (1) with Client Quang Bùi (3) - Payment issue
    (3, 1, 'Chào admin, tôi gặp vấn đề khi thanh toán cho gói dịch vụ Bạc. Hệ thống báo lỗi giao dịch.', NOW() - INTERVAL 15 DAY, true),
    (1, 3, 'Chào anh Quang Bùi, tôi rất tiếc về vấn đề này. Anh có thể cho tôi biết mã giao dịch và thời gian thực hiện không?', NOW() - INTERVAL 15 DAY, true),
    (3, 1, 'Mã giao dịch là TX789023, tôi thực hiện vào lúc 10:30 sáng nay qua Visa.', NOW() - INTERVAL 15 DAY, true),
    (1, 3, 'Cảm ơn thông tin. Tôi đã kiểm tra và thấy giao dịch của anh đã được ghi nhận nhưng chưa được kích hoạt. Tôi sẽ kích hoạt gói dịch vụ Bạc cho anh ngay bây giờ.', NOW() - INTERVAL 14 DAY, true),
    (3, 1, 'Tuyệt vời, cảm ơn admin đã xử lý nhanh chóng. Tôi đã thấy gói dịch vụ được kích hoạt.', NOW() - INTERVAL 14 DAY, true),

-- Admin (1) with Freelancer Tiến Đinh (4) - Report inappropriate job
    (4, 1, 'Chào admin, tôi muốn báo cáo một công việc có nội dung không phù hợp. Job ID là JOB2023145, có yêu cầu thiết kế nội dung vi phạm bản quyền.', NOW() - INTERVAL 20 DAY, true),
    (1, 4, 'Chào anh Tiến, cảm ơn đã báo cáo. Tôi sẽ kiểm tra công việc này ngay lập tức.', NOW() - INTERVAL 20 DAY, true),
    (1, 4, 'Tôi đã xem xét và đồng ý rằng công việc này có yêu cầu vi phạm bản quyền. Chúng tôi đã gỡ bỏ công việc và gửi cảnh báo đến client. Cảm ơn anh đã giúp duy trì tiêu chuẩn cộng đồng.', NOW() - INTERVAL 19 DAY, true),
    (4, 1, 'Cảm ơn admin đã xử lý nhanh chóng. Tôi rất vui khi nền tảng chú trọng đến vấn đề bản quyền.', NOW() - INTERVAL 19 DAY, true),
    (1, 4, 'Đây là ưu tiên của chúng tôi. Nếu anh phát hiện thêm trường hợp tương tự, đừng ngần ngại báo cáo nhé.', NOW() - INTERVAL 18 DAY, true),

-- Admin (1) with Client Huy Đinh (5) - Technical issue with posting job
    (5, 1, 'Chào admin, tôi không thể đăng công việc mới. Hệ thống cứ báo lỗi khi tôi nhấn nút "Đăng tin".', NOW() - INTERVAL 7 DAY, true),
    (1, 5, 'Chào anh Huy, tôi rất tiếc về trải nghiệm này. Anh gặp lỗi cụ thể như thế nào?', NOW() - INTERVAL 7 DAY, true),
    (5, 1, 'Hệ thống hiển thị thông báo "Không thể xử lý yêu cầu vào lúc này" và tôi không thể tiếp tục.', NOW() - INTERVAL 7 DAY, true),
    (1, 5, 'Cảm ơn thông tin. Chúng tôi vừa cập nhật hệ thống và có thể đã gây ra vấn đề này. Tôi sẽ chuyển ngay cho đội kỹ thuật.', NOW() - INTERVAL 6 DAY, true),
    (1, 5, 'Đội kỹ thuật đã khắc phục lỗi. Anh có thể thử đăng tin lại được không? Nếu vẫn gặp vấn đề, tôi sẽ hỗ trợ đăng tin thủ công cho anh.', NOW() - INTERVAL 5 DAY, true),
    (5, 1, 'Đã hoạt động! Cảm ơn admin đã hỗ trợ nhanh chóng.', NOW() - INTERVAL 5 DAY, true),
    (1, 5, 'Rất vui khi nghe điều đó! Chúng tôi luôn sẵn sàng hỗ trợ anh khi cần.', NOW() - INTERVAL 5 DAY, true),

-- Admin (1) with Freelancer Hoàng Anh (6) - Account suspension issue
    (6, 1, 'Chào admin, tài khoản của tôi bị tạm khóa nhưng tôi không hiểu lý do. Tôi không vi phạm quy định nào cả.', NOW() - INTERVAL 25 DAY, true),
    (1, 6, 'Chào anh Hoàng Anh, tôi sẽ kiểm tra ngay tình trạng tài khoản của anh.', NOW() - INTERVAL 25 DAY, true),
    (1, 6, 'Tôi đã xem xét và thấy tài khoản của anh bị tạm khóa do hệ thống phát hiện hoạt động bất thường từ IP của anh. Có vẻ như đây là cảnh báo giả.', NOW() - INTERVAL 24 DAY, true),
    (6, 1, 'Tôi hiểu rồi. Gần đây tôi đi công tác và đăng nhập từ nhiều địa điểm khác nhau, có thể đó là nguyên nhân.', NOW() - INTERVAL 24 DAY, true),
    (1, 6, 'Đúng vậy, đó chính là nguyên nhân. Tôi đã mở khóa tài khoản của anh. Trong tương lai, nếu anh biết mình sẽ đăng nhập từ nơi khác, anh có thể thông báo trước để tránh tình trạng tương tự.', NOW() - INTERVAL 23 DAY, true),
    (6, 1, 'Cảm ơn admin rất nhiều. Tôi sẽ lưu ý điều này.', NOW() - INTERVAL 23 DAY, true),

-- Admin (1) with Freelancer Ngọc Lan (8) - Profile visibility issue
    (8, 1, 'Chào admin, tôi nhận thấy profile của mình không xuất hiện trong kết quả tìm kiếm mặc dù tôi đã hoàn thiện đầy đủ.', NOW() - INTERVAL 12 DAY, true),
    (1, 8, 'Chào chị Ngọc Lan, cảm ơn đã thông báo. Tôi sẽ kiểm tra vấn đề này.', NOW() - INTERVAL 12 DAY, true),
    (1, 8, 'Tôi đã kiểm tra và thấy có vấn đề với cài đặt hiển thị profile của chị. Tài khoản của chị đang ở chế độ "Ẩn" trong phần cài đặt.', NOW() - INTERVAL 11 DAY, true),
    (8, 1, 'Ồ, tôi không biết về cài đặt này. Làm thế nào để thay đổi nó?', NOW() - INTERVAL 11 DAY, true),
    (1, 8, 'Chị có thể vào phần "Cài đặt tài khoản" > "Quyền riêng tư" và chọn "Hiển thị với tất cả". Tôi có thể thay đổi giúp chị nếu chị muốn.', NOW() - INTERVAL 10 DAY, true),
    (8, 1, 'Vâng, tôi đã tìm thấy và thay đổi rồi. Cảm ơn admin đã hỗ trợ!', NOW() - INTERVAL 10 DAY, true),

-- Admin (1) with Client Thành Sơn (10) - Dispute with freelancer
    (10, 1, 'Chào admin, tôi đang gặp vấn đề với freelancer ID F2023076. Anh ta không hoàn thành công việc đúng hạn nhưng vẫn yêu cầu thanh toán đầy đủ.', NOW() - INTERVAL 30 DAY, true),
    (1, 10, 'Chào anh Thành Sơn, tôi rất tiếc khi nghe điều này. Tôi sẽ xem xét tình huống và liên hệ với cả hai bên.', NOW() - INTERVAL 30 DAY, true),
    (10, 1, 'Cảm ơn admin. Tôi đã trả trước 50% và deadline là tuần trước, nhưng freelancer mới hoàn thành 60% công việc.', NOW() - INTERVAL 30 DAY, true),
    (1, 10, 'Tôi đã liên hệ với freelancer và xem xét tiến độ dự án. Freelancer cho biết có sự chậm trễ do yêu cầu bổ sung không nằm trong thỏa thuận ban đầu.', NOW() - INTERVAL 29 DAY, true),
    (10, 1, 'Đúng là có một số yêu cầu bổ sung, nhưng chúng tôi đã thảo luận và đồng ý về thời hạn mới.', NOW() - INTERVAL 29 DAY, true),
    (1, 10, 'Sau khi xem xét tin nhắn giữa hai bên, tôi thấy chưa có thỏa thuận rõ ràng về thời hạn mới. Tôi đề xuất gia hạn thêm 5 ngày và không tính phí bổ sung. Anh thấy phương án này thế nào?', NOW() - INTERVAL 28 DAY, true),
    (10, 1, 'Tôi đồng ý với đề xuất này. Cảm ơn admin đã xử lý công bằng.', NOW() - INTERVAL 28 DAY, true),

-- Admin (1) with Freelancer Lan Anh (11) - Report client for harassment
    (11, 1, 'Chào admin, tôi muốn báo cáo một client có hành vi quấy rối. Client ID C2023089 liên tục gửi tin nhắn cá nhân không liên quan đến công việc.', NOW() - INTERVAL 18 DAY, true),
    (1, 11, 'Chào chị Lan Anh, cảm ơn đã báo cáo. Chúng tôi rất coi trọng vấn đề này. Tôi sẽ kiểm tra ngay các tin nhắn liên quan.', NOW() - INTERVAL 18 DAY, true),
    (11, 1, 'Cảm ơn admin. Tôi đã cố gắng từ chối lịch sự nhưng client vẫn tiếp tục.', NOW() - INTERVAL 18 DAY, true),
    (1, 11, 'Tôi đã xem xét các tin nhắn và đồng ý rằng đây là hành vi không phù hợp. Chúng tôi đã cảnh báo client và sẽ giám sát chặt chẽ. Nếu tình trạng tiếp tục, chúng tôi sẽ khóa tài khoản client.', NOW() - INTERVAL 17 DAY, true),
    (11, 1, 'Tôi rất cảm kích vì phản hồi nhanh chóng và chuyên nghiệp. Điều này giúp tôi cảm thấy an toàn hơn khi làm việc trên nền tảng.', NOW() - INTERVAL 17 DAY, true),
    (1, 11, 'Đảm bảo môi trường làm việc an toàn, tôn trọng là ưu tiên của chúng tôi. Chị có thể chặn client này và chúng tôi sẽ đảm bảo họ không thể liên hệ với chị nữa.', NOW() - INTERVAL 16 DAY, true),
    (11, 1, 'Vâng, tôi đã chặn họ. Cảm ơn admin rất nhiều vì sự hỗ trợ!', NOW() - INTERVAL 16 DAY, true),

-- Admin (1) with Client Hoàng Long (12) - Feature suggestion
    (12, 1, 'Chào admin, tôi có đề xuất về tính năng mới cho nền tảng: cho phép lọc freelancer theo khu vực địa lý cụ thể.', NOW() - INTERVAL 9 DAY, true),
    (1, 12, 'Chào anh Hoàng Long, cảm ơn về đề xuất này. Đây là một ý tưởng rất hữu ích.', NOW() - INTERVAL 9 DAY, true),
    (12, 1, 'Công ty tôi thường cần freelancer có thể gặp trực tiếp tại TP.HCM, nên tính năng này sẽ rất có ích.', NOW() - INTERVAL 9 DAY, true),
    (1, 12, 'Tôi hiểu nhu cầu của anh. Tôi sẽ chuyển đề xuất này đến đội phát triển sản phẩm. Thực tế, chúng tôi đang cân nhắc tính năng tương tự cho bản cập nhật sắp tới.', NOW() - INTERVAL 8 DAY, true),
    (12, 1, 'Tuyệt vời! Tôi rất vui khi nghe điều đó. Các bạn có thể chia sẻ thời gian dự kiến không?', NOW() - INTERVAL 8 DAY, true),
    (1, 12, 'Theo kế hoạch hiện tại, tính năng này sẽ được triển khai trong quý tới. Tôi sẽ thông báo cho anh khi có thông tin cập nhật.', NOW() - INTERVAL 7 DAY, true),
    (12, 1, 'Cảm ơn admin. Tôi rất mong đợi bản cập nhật này!', NOW() - INTERVAL 7 DAY, true),

-- Admin (1) with Freelancer Kim Ngân (13) - Payout problem
    (13, 1, 'Chào admin, tôi gặp vấn đề với việc rút tiền về tài khoản ngân hàng. Giao dịch đã được xác nhận 5 ngày nhưng tôi chưa nhận được tiền.', NOW() - INTERVAL 22 DAY, true),
    (1, 13, 'Chào chị Kim Ngân, tôi rất tiếc về vấn đề này. Tôi sẽ kiểm tra ngay giao dịch của chị.', NOW() - INTERVAL 22 DAY, true),
    (13, 1, 'Mã giao dịch là WD20230517, số tiền 5.000.000 VNĐ vào ngày 17/05.', NOW() - INTERVAL 22 DAY, true),
    (1, 13, 'Cảm ơn thông tin. Tôi đã kiểm tra và thấy giao dịch đã được xử lý bên phía chúng tôi, nhưng có vấn đề xác nhận từ ngân hàng. Tôi sẽ liên hệ bộ phận tài chính và ngân hàng để xử lý gấp.', NOW() - INTERVAL 21 DAY, true),
    (1, 13, 'Chị Kim Ngân, tôi đã xác nhận với ngân hàng. Họ gặp trục trặc kỹ thuật và đã khắc phục. Tiền sẽ được chuyển đến tài khoản của chị trong vòng 24 giờ tới. Chúng tôi xin lỗi vì sự bất tiện này.', NOW() - INTERVAL 20 DAY, true),
    (13, 1, 'Cảm ơn admin đã theo dõi vấn đề. Tôi sẽ kiểm tra và thông báo lại khi nhận được tiền.', NOW() - INTERVAL 20 DAY, true),
    (13, 1, 'Tôi đã nhận được tiền. Cảm ơn admin rất nhiều vì đã hỗ trợ!', NOW() - INTERVAL 19 DAY, true),
    (1, 13, 'Rất vui khi vấn đề đã được giải quyết. Cảm ơn chị đã thông báo!', NOW() - INTERVAL 19 DAY, true),

-- Admin (1) with Client Minh Triết (14) - Help with finding right freelancer
    (14, 1, 'Chào admin, tôi đang gặp khó khăn trong việc tìm kiếm freelancer phù hợp cho dự án chỉnh sửa ảnh chuyên nghiệp cho studio.', NOW() - INTERVAL 16 DAY, true),
    (1, 14, 'Chào anh Minh Triết, tôi rất vui được hỗ trợ anh. Anh có thể chia sẻ thêm về yêu cầu cụ thể không?', NOW() - INTERVAL 16 DAY, true),
    (14, 1, 'Tôi cần người có kinh nghiệm chỉnh sửa ảnh cưới và thời trang, đặc biệt là kỹ năng blend màu tự nhiên và retouch da chuyên nghiệp.', NOW() - INTERVAL 16 DAY, true),
    (1, 14, 'Hiểu rồi. Tôi sẽ giúp anh tìm các freelancer phù hợp. Anh có yêu cầu về thời gian và ngân sách không?', NOW() - INTERVAL 15 DAY, true),
    (14, 1, 'Tôi cần trong 3 tháng tới, ngân sách khoảng 5-8 triệu/tháng. Quan trọng nhất là chất lượng và khả năng đáp ứng deadline nhanh.', NOW() - INTERVAL 15 DAY, true),
    (1, 14, 'Tôi đã tìm được 5 freelancer phù hợp với yêu cầu của anh. Tôi sẽ gửi thông tin qua email để anh xem xét. Họ đều có portfolio ấn tượng và đánh giá cao từ các dự án tương tự.', NOW() - INTERVAL 14 DAY, true),
    (14, 1, 'Cảm ơn admin rất nhiều! Điều này giúp tôi tiết kiệm thời gian tìm kiếm. Tôi sẽ xem thông tin và liên hệ với họ.', NOW() - INTERVAL 14 DAY, true),
    (1, 14, 'Rất vui được giúp đỡ! Đừng ngần ngại liên hệ tôi nếu anh cần thêm hỗ trợ hoặc có câu hỏi về các freelancer được đề xuất.', NOW() - INTERVAL 13 DAY, true),

-- Admin (1) with Freelancer Hiếu Nguyễn (15) - Account upgrade request
    (15, 1, 'Chào admin, tôi muốn nâng cấp tài khoản lên Pro để tiếp cận nhiều client hơn. Làm thế nào để thực hiện?', NOW() - INTERVAL 28 DAY, true),
    (1, 15, 'Chào anh Hiếu, cảm ơn anh đã quan tâm đến tài khoản Pro. Tôi rất vui được hướng dẫn anh.', NOW() - INTERVAL 28 DAY, true),
    (15, 1, 'Tôi đã là freelancer trên nền tảng hơn 6 tháng và muốn mở rộng dịch vụ giảng dạy online.', NOW() - INTERVAL 28 DAY, true),
    (1, 15, 'Tuyệt vời! Anh có thể nâng cấp bằng cách vào "Cài đặt tài khoản" > "Nâng cấp gói" và chọn gói Pro. Chi phí là 500.000 VNĐ/tháng hoặc 5.000.000 VNĐ/năm. Gói này sẽ giúp profile của anh được ưu tiên hiển thị và tiếp cận nhiều client hơn.', NOW() - INTERVAL 27 DAY, true),
    (15, 1, 'Cảm ơn thông tin. Tôi có được thử nghiệm trước không hay phải cam kết ngay?', NOW() - INTERVAL 27 DAY, true),
    (1, 15, 'Chúng tôi có gói dùng thử Pro 7 ngày với giá 100.000 VNĐ. Anh có thể trải nghiệm đầy đủ tính năng trong thời gian này trước khi quyết định nâng cấp dài hạn.', NOW() - INTERVAL 26 DAY, true),
    (15, 1, 'Tuyệt vời! Tôi sẽ đăng ký gói dùng thử trước. Cảm ơn admin vì thông tin hữu ích.', NOW() - INTERVAL 26 DAY, true),
    (1, 15, 'Rất vui được hỗ trợ anh! Sau khi anh nâng cấp, tôi sẽ gửi hướng dẫn để tối ưu hóa profile và tiếp cận client hiệu quả nhất.', NOW() - INTERVAL 25 DAY, true),

-- Conversation between Client Quang Bùi (ID: 3) and Freelancer Quang Vũ (ID: 2)
    (3, 2, 'Chào anh, tôi đang tìm kiếm một backend developer cho dự án của tôi.', NOW() - INTERVAL 5 DAY, true),
    (2, 3, 'Chào anh, tôi rất vui khi nhận được tin nhắn của anh. Tôi có thể giúp gì cho dự án của anh?',
     NOW() - INTERVAL 5 DAY, true),
    (3, 2,
     'Dự án của tôi cần một hệ thống backend với Spring Boot và MySQL, bạn có kinh nghiệm về các công nghệ này không?',
     NOW() - INTERVAL 5 DAY, true),
    (2, 3,
     'Vâng, tôi có 3 năm kinh nghiệm với Spring Boot và làm việc thường xuyên với MySQL. Anh có thể chia sẻ thêm về yêu cầu cụ thể không?',
     NOW() - INTERVAL 5 DAY, true),
    (3, 2, 'Tuyệt vời! Tôi sẽ gửi cho bạn mô tả chi tiết qua email. Bạn có thể cho tôi biết mức giá dự kiến không?',
     NOW() - INTERVAL 4 DAY, true),
    (2, 3,
     'Dạ, tùy thuộc vào phạm vi dự án, mức giá của tôi dao động từ 300.000 đến 500.000 VND/giờ. Sau khi xem yêu cầu chi tiết, tôi sẽ đưa ra báo giá chính xác hơn.',
     NOW() - INTERVAL 4 DAY, true),
    (3, 2, 'OK, tôi đã gửi email cho bạn. Hãy kiểm tra và cho tôi biết sớm nhé.', NOW() - INTERVAL 3 DAY, true),
    (2, 3,
     'Tôi đã nhận được email và đang xem xét. Sẽ phản hồi chi tiết trong ngày hôm nay. Cảm ơn anh đã quan tâm đến dịch vụ của tôi.',
     NOW() - INTERVAL 3 DAY, true),
    (3, 2, 'Bạn đã xem qua yêu cầu dự án chưa? Tôi muốn bắt đầu sớm nếu có thể.', NOW() - INTERVAL 1 DAY, true),
    (2, 3,
     'Tôi đã xem qua và rất hứng thú với dự án. Có thể chúng ta sắp xếp một cuộc họp để thảo luận chi tiết hơn không?',
     NOW() - INTERVAL 1 DAY, false),

-- Conversation between Client Huy Đinh (ID: 5) and Freelancer Tiến Đinh (ID: 4)
    (5, 4, 'Chào Tiến, tôi cần tư vấn về chiến dịch digital marketing cho công ty mới của tôi.', NOW() - INTERVAL 7 DAY,
     true),
    (4, 5, 'Chào anh Huy, rất vui được kết nối. Anh có thể chia sẻ thêm về công ty và mục tiêu marketing không?',
     NOW() - INTERVAL 7 DAY, true),
    (5, 4,
     'Công ty tôi hoạt động trong lĩnh vực fintech, cần tiếp cận khách hàng doanh nghiệp. Chúng tôi muốn tăng lượng lead 30% trong 3 tháng tới.',
     NOW() - INTERVAL 6 DAY, true),
    (4, 5,
     'Đó là mục tiêu khả thi. Tôi đề xuất kết hợp SEO, Google Ads và LinkedIn Marketing. Anh có ngân sách dự kiến cho chiến dịch không?',
     NOW() - INTERVAL 6 DAY, true),
    (5, 4, 'Chúng tôi có ngân sách khoảng 50 triệu/tháng cho marketing. Bạn nghĩ sao về con số này?',
     NOW() - INTERVAL 5 DAY, true),
    (4, 5,
     'Với ngân sách đó, chúng ta có thể triển khai chiến lược khá toàn diện. Tôi sẽ gửi đề xuất chi tiết vào ngày mai, bao gồm phân bổ ngân sách và KPIs.',
     NOW() - INTERVAL 5 DAY, true),
    (5, 4, 'Tuyệt vời! Tôi sẽ chờ đề xuất của bạn. Bạn có thể cho tôi biết phí tư vấn của bạn là bao nhiêu không?',
     NOW() - INTERVAL 4 DAY, true),
    (4, 5,
     'Phí tư vấn của tôi là 15 triệu/tháng, bao gồm xây dựng chiến lược, giám sát và báo cáo hiệu quả hàng tuần. Nếu anh muốn tôi trực tiếp quản lý quảng cáo, sẽ có phí bổ sung.',
     NOW() - INTERVAL 4 DAY, true),
    (5, 4, 'OK, tôi đã nhận được đề xuất của bạn. Còn vài câu hỏi, chúng ta có thể gọi điện được không?',
     NOW() - INTERVAL 2 DAY, true),
    (4, 5,
     'Dạ được, anh có thể gọi cho tôi vào lúc 14h chiều nay được không? Hoặc cho tôi biết thời gian thuận tiện của anh.',
     NOW() - INTERVAL 2 DAY, false),

-- Conversation between Client Minh Thành (ID: 7) and Freelancer Hoàng Anh (ID: 6)
    (7, 6, 'Chào Hoàng Anh, tôi quan tâm đến dịch vụ phát triển ứng dụng di động của bạn.', NOW() - INTERVAL 10 DAY,
     true),
    (6, 7, 'Chào anh Minh Thành, cảm ơn anh đã liên hệ. Anh đang có ý tưởng gì cho ứng dụng di động vậy?',
     NOW() - INTERVAL 10 DAY, true),
    (7, 6, 'Tôi muốn xây dựng một ứng dụng đặt lịch hẹn cho spa. Bạn đã từng làm dự án tương tự chưa?',
     NOW() - INTERVAL 9 DAY, true),
    (6, 7,
     'Vâng, tôi đã từng phát triển 2 ứng dụng đặt lịch cho salon tóc và phòng khám. Anh muốn phát triển cho iOS, Android hay cả hai?',
     NOW() - INTERVAL 9 DAY, true),
    (7, 6, 'Tôi muốn phát triển cho cả iOS và Android. Bạn sẽ dùng công nghệ gì?', NOW() - INTERVAL 8 DAY, true),
    (6, 7,
     'Tôi đề xuất sử dụng Flutter để phát triển cùng lúc cho cả hai nền tảng, tiết kiệm chi phí và thời gian. Ứng dụng sẽ cần tích hợp thanh toán không?',
     NOW() - INTERVAL 8 DAY, true),
    (7, 6, 'Đúng vậy, chúng tôi cần tích hợp VNPay và Momo. Bạn có thể ước tính thời gian và chi phí không?',
     NOW() - INTERVAL 7 DAY, true),
    (6, 7,
     'Với các tính năng đặt lịch, thông báo, quản lý tài khoản và tích hợp thanh toán, dự án sẽ mất khoảng 2-3 tháng. Chi phí ước tính 80-100 triệu, tùy vào chi tiết yêu cầu cụ thể.',
     NOW() - INTERVAL 7 DAY, true),
    (7, 6,
     'Cảm ơn thông tin. Tôi muốn trao đổi thêm về quy trình làm việc. Bạn có thể gửi portfolio và quy trình phát triển không?',
     NOW() - INTERVAL 6 DAY, true),
    (6, 7,
     'Dạ, tôi vừa gửi email chứa portfolio và quy trình làm việc chi tiết. Anh kiểm tra giúp tôi nhé. Nếu anh hài lòng, chúng ta có thể sắp xếp một cuộc họp để thảo luận chi tiết hơn.',
     NOW() - INTERVAL 6 DAY, true),
    (7, 6,
     'Tôi đã xem qua portfolio, ấn tượng với ứng dụng đặt lịch salon tóc. Chúng ta có thể họp vào thứ 2 tuần sau được không?',
     NOW() - INTERVAL 3 DAY, true),
    (6, 7, 'Cảm ơn anh. Thứ 2 tuần sau tôi rảnh, anh chọn giờ thuận tiện nhé.', NOW() - INTERVAL 3 DAY, false),

-- Conversation between Client Thành Sơn (ID: 10) and Freelancer Ngọc Lan (ID: 8)
    (10, 8, 'Chào chị, tôi đang tìm kiếm một chuyên gia data analyst cho dự án phân tích dữ liệu khách hàng.',
     NOW() - INTERVAL 8 DAY, true),
    (8, 10,
     'Chào anh Thành Sơn, tôi rất vui khi nhận được tin nhắn của anh. Anh có thể chia sẻ thêm về dự án và mục tiêu phân tích không?',
     NOW() - INTERVAL 8 DAY, true),
    (10, 8,
     'Chúng tôi cần phân tích hành vi mua hàng của khách hàng trong 2 năm qua, tìm ra các pattern và đề xuất chiến lược marketing mới.',
     NOW() - INTERVAL 7 DAY, true),
    (8, 10, 'Tôi hiểu rồi. Anh đang có dữ liệu ở dạng nào? Và anh mong muốn output là báo cáo, dashboard hay cả hai?',
     NOW() - INTERVAL 7 DAY, true),
    (10, 8,
     'Chúng tôi có dữ liệu ở dạng CSV, xuất từ hệ thống CRM. Tôi muốn có cả báo cáo phân tích chi tiết và dashboard để theo dõi các KPI.',
     NOW() - INTERVAL 6 DAY, true),
    (8, 10,
     'Tốt lắm. Tôi có thể sử dụng R hoặc Python cho phân tích và Power BI cho dashboard trực quan. Anh có thể chia sẻ một phần dữ liệu mẫu để tôi hiểu rõ hơn cấu trúc không?',
     NOW() - INTERVAL 6 DAY, true),
    (10, 8, 'Tôi sẽ gửi cho bạn mẫu dữ liệu qua email. Bạn có thể cho tôi biết thời gian và chi phí dự kiến không?',
     NOW() - INTERVAL 5 DAY, true),
    (8, 10,
     'Dựa trên mô tả ban đầu, dự án có thể mất khoảng 3-4 tuần. Chi phí ước tính khoảng 25-30 triệu, tùy vào khối lượng dữ liệu và độ phức tạp của phân tích.',
     NOW() - INTERVAL 5 DAY, true),
    (10, 8, 'Cảm ơn thông tin. Tôi đã gửi email với dữ liệu mẫu. Khi nào bạn có thể bắt đầu nếu chúng ta thống nhất?',
     NOW() - INTERVAL 4 DAY, true),
    (8, 10,
     'Tôi có thể bắt đầu từ đầu tháng sau. Tôi sẽ xem qua dữ liệu mẫu và phản hồi với đề xuất chi tiết trong 2 ngày tới. Cảm ơn anh đã quan tâm đến dịch vụ của tôi!',
     NOW() - INTERVAL 4 DAY, false),

-- Conversation between Client Hoàng Long (ID: 12) and Freelancer Lan Anh (ID: 11)
    (12, 11,
     'Chào Lan Anh, tôi là đại diện Agency Thiết kế Đồ họa LT. Chúng tôi đang tìm kiếm freelancer video editor cho một dự án lớn.',
     NOW() - INTERVAL 6 DAY, true),
    (11, 12, 'Chào anh Hoàng Long, rất vui được kết nối. Anh có thể chia sẻ thêm về dự án không?',
     NOW() - INTERVAL 6 DAY,
     true),
    (12, 11,
     'Chúng tôi cần biên tập 10 video quảng cáo ngắn (30-60s) cho một thương hiệu thời trang. Deadline khoảng 3 tuần.',
     NOW() - INTERVAL 5 DAY, true),
    (11, 12,
     'Dự án nghe rất thú vị. Anh có thể cho tôi biết thêm về phong cách, tông màu mong muốn và liệu tôi có cần tham gia quay phim không?',
     NOW() - INTERVAL 5 DAY, true),
    (12, 11,
     'Chúng tôi đã có footage, bạn chỉ cần biên tập. Phong cách trẻ trung, hiện đại, tông màu ấm. Tôi có thể gửi cho bạn mood board và references.',
     NOW() - INTERVAL 4 DAY, true),
    (11, 12,
     'Tuyệt vời. Tôi đã có kinh nghiệm với các dự án tương tự. Mức giá của tôi là 3-5 triệu/video tùy độ phức tạp. Anh có thể chia sẻ timeline cụ thể không?',
     NOW() - INTERVAL 4 DAY, true),
    (12, 11,
     'Mức giá chấp nhận được. Timeline dự kiến: nhận footage tuần sau, bản draft đầu tiên sau 10 ngày, và hoàn thiện trong vòng 3 tuần.',
     NOW() - INTERVAL 3 DAY, true),
    (11, 12,
     'Tôi có thể đáp ứng timeline này. Tôi sẽ cần hợp đồng và đặt cọc 30% để bắt đầu. Anh có thể gửi cho tôi một video mẫu để tôi hiểu rõ hơn về yêu cầu không?',
     NOW() - INTERVAL 3 DAY, true),
    (12, 11,
     'Đã gửi email với video mẫu và mood board. Hãy xem và cho tôi biết suy nghĩ của bạn. Về hợp đồng, tôi sẽ gửi bản nháp vào đầu tuần sau.',
     NOW() - INTERVAL 2 DAY, true),
    (11, 12,
     'Đã nhận được email. Tôi rất thích phong cách và concept. Sẽ đợi bản nháp hợp đồng từ anh. Cảm ơn vì cơ hội hợp tác!',
     NOW() - INTERVAL 2 DAY, false),
-- Quang Vũ (2) with Huy Đinh (5)
    (2, 5, 'Chào anh Huy, tôi là Quang Vũ. Tôi thấy dự án backend của anh rất phù hợp với kinh nghiệm của tôi.',
     NOW() - INTERVAL 16 DAY, true),
    (5, 2, 'Chào Quang, cảm ơn vì đã liên hệ. Bạn có thể chia sẻ thêm về kinh nghiệm với Spring Boot không?',
     NOW() - INTERVAL 16 DAY, true),
    (2, 5,
     'Tôi có 3 năm kinh nghiệm với Spring Boot, từng xây dựng hệ thống thanh toán và quản lý người dùng cho nhiều doanh nghiệp.',
     NOW() - INTERVAL 15 DAY, true),
    (5, 2,
     'Ấn tượng đấy. Dự án của tôi cần một hệ thống backend an toàn với khả năng mở rộng cao. Bạn đã từng làm việc với microservices chưa?',
     NOW() - INTERVAL 15 DAY, true),
    (2, 5,
     'Vâng, tôi có kinh nghiệm với kiến trúc microservices và Docker. Tôi có thể chia sẻ portfolio để anh xem chi tiết hơn.',
     NOW() - INTERVAL 14 DAY, true),

-- Quang Vũ (2) with Kim Ngân (13)
    (2, 13, 'Chào chị Kim Ngân, tôi là Quang Vũ. Tôi đang phát triển một ứng dụng cần dịch sang tiếng Anh.',
     NOW() - INTERVAL 12 DAY, true),
    (13, 2, 'Chào Quang, rất vui được biết đến dự án của bạn. Bạn cần dịch những tài liệu gì vậy?',
     NOW() - INTERVAL 12 DAY, true),
    (2, 13, 'Tôi cần dịch UI, thông báo và tài liệu hướng dẫn sử dụng, khoảng 20 trang.', NOW() - INTERVAL 11 DAY,
     true),
    (13, 2, 'Tôi có thể hỗ trợ bạn với nội dung này. Thời hạn dự kiến là khi nào?', NOW() - INTERVAL 11 DAY, true),
    (2, 13, 'Tôi cần trong vòng 2 tuần. Có khả thi không ạ?', NOW() - INTERVAL 10 DAY, true),

-- Quang Vũ (2) with Hoàng Anh (6)
    (2, 6, 'Chào Hoàng Anh, tôi là Quang Vũ. Tôi thấy bạn chuyên về Mobile Development.', NOW() - INTERVAL 20 DAY,
     true),
    (6, 2, 'Chào Quang, đúng vậy. Tôi chuyên về Flutter và React Native. Có gì tôi có thể giúp được không?',
     NOW() - INTERVAL 20 DAY, true),
    (2, 6,
     'Tôi đang xây dựng backend cho một ứng dụng mobile, cần trao đổi để hiểu rõ hơn về RESTful API phù hợp cho mobile.',
     NOW() - INTERVAL 19 DAY, true),
    (6, 2, 'Tôi rất sẵn lòng chia sẻ kinh nghiệm. Ứng dụng của bạn có yêu cầu đặc biệt gì không?',
     NOW() - INTERVAL 19 DAY, true),
    (2, 6,
     'Chủ yếu là về authentication, push notification và offline caching. Bạn có kinh nghiệm với các vấn đề này không?',
     NOW() - INTERVAL 18 DAY, true),

-- Quang Vũ (2) with Lan Anh (11)
    (2, 11, 'Chào chị Lan Anh, tôi là Quang. Tôi đang tìm người chỉnh sửa video demo cho ứng dụng của tôi.',
     NOW() - INTERVAL 8 DAY, true),
    (11, 2, 'Chào Quang, rất vui được biết đến dự án của bạn. Bạn có thể chia sẻ thêm về yêu cầu video không?',
     NOW() - INTERVAL 8 DAY, true),
    (2, 11, 'Tôi cần một video ngắn khoảng 2-3 phút giới thiệu tính năng chính của ứng dụng backend.',
     NOW() - INTERVAL 7 DAY, true),
    (11, 2, 'Tôi có thể giúp bạn với điều này. Bạn đã có footage hay tôi cần quay screen recording?',
     NOW() - INTERVAL 7 DAY, true),
    (2, 11, 'Tôi có sẵn screen recording, chỉ cần chỉnh sửa và thêm hiệu ứng, âm thanh để trông chuyên nghiệp hơn.',
     NOW() - INTERVAL 6 DAY, true),

-- Quang Vũ (2) with Hiếu Nguyễn (15)
    (2, 15, 'Chào anh Hiếu, tôi là Quang Vũ. Tôi quan tâm đến khóa học Digital Marketing của anh.',
     NOW() - INTERVAL 25 DAY, true),
    (15, 2, 'Chào Quang, cảm ơn vì sự quan tâm. Bạn muốn tìm hiểu về nội dung gì trong Digital Marketing?',
     NOW() - INTERVAL 25 DAY, true),
    (2, 15, 'Tôi muốn học cách quảng bá dịch vụ freelance của mình hiệu quả hơn trên các nền tảng số.',
     NOW() - INTERVAL 24 DAY, true),
    (15, 2,
     'Đó là chủ đề rất phù hợp với khóa học của tôi. Tôi có một module dành riêng cho freelancer xây dựng thương hiệu cá nhân.',
     NOW() - INTERVAL 24 DAY, true),
    (2, 15, 'Tuyệt vời! Khi nào khóa học bắt đầu và học phí là bao nhiêu vậy anh?', NOW() - INTERVAL 23 DAY, true),

-- Quang Vũ (2) with Minh Thành (7)
    (2, 7, 'Chào anh Minh Thành, tôi là Quang Vũ. Tôi thấy anh đang tìm backend developer cho dự án của mình.',
     NOW() - INTERVAL 18 DAY, true),
    (7, 2,
     'Chào Quang, đúng vậy. Tôi cần một hệ thống quản lý dự án nội bộ. Bạn có kinh nghiệm với loại hệ thống này không?',
     NOW() - INTERVAL 18 DAY, true),
    (2, 7,
     'Tôi đã từng xây dựng 2 hệ thống tương tự bằng Spring Boot với các tính năng quản lý người dùng, phân quyền và theo dõi tiến độ.',
     NOW() - INTERVAL 17 DAY, true),
    (7, 2, 'Nghe có vẻ phù hợp với yêu cầu của tôi. Bạn có thể gửi cho tôi portfolio và báo giá được không?',
     NOW() - INTERVAL 17 DAY, true),
    (2, 7, 'Dạ vâng, tôi sẽ gửi email chi tiết cho anh trong ngày hôm nay. Cảm ơn anh đã quan tâm!',
     NOW() - INTERVAL 16 DAY, true),

-- Additional conversations for User 3 (Quang Bùi - Client)
-- Quang Bùi (3) with Tiến Đinh (4)
    (3, 4, 'Chào anh Tiến, tôi là Quang Bùi. Tôi cần một chiến dịch digital marketing cho công ty của tôi.',
     NOW() - INTERVAL 22 DAY, true),
    (4, 3, 'Chào anh Quang, rất vui được kết nối. Công ty anh hoạt động trong lĩnh vực gì vậy?',
     NOW() - INTERVAL 22 DAY, true),
    (3, 4, 'Công ty tôi trong lĩnh vực phần mềm B2B, cần tăng lượng lead từ các doanh nghiệp vừa và nhỏ.',
     NOW() - INTERVAL 21 DAY, true),
    (4, 3,
     'Tôi hiểu rồi. Tôi có kinh nghiệm với thị trường B2B và có thể giúp anh xây dựng chiến dịch phù hợp. Ngân sách dự kiến của anh là bao nhiêu?',
     NOW() - INTERVAL 21 DAY, true),
    (3, 4, 'Chúng tôi có ngân sách khoảng 30-40 triệu/tháng cho marketing. Anh nghĩ sao về con số này?',
     NOW() - INTERVAL 20 DAY, true),

-- Quang Bùi (3) with Ngọc Lan (8)
    (3, 8, 'Chào chị Ngọc Lan, tôi là Quang Bùi. Tôi cần hỗ trợ phân tích dữ liệu khách hàng.', NOW() - INTERVAL 14 DAY,
     true),
    (8, 3, 'Chào anh Quang, rất vui được kết nối. Anh cần phân tích dữ liệu gì vậy?', NOW() - INTERVAL 14 DAY, true),
    (3, 8,
     'Tôi có dữ liệu khách hàng và giao dịch trong 2 năm qua, cần phân tích để hiểu hành vi và tối ưu chiến lược bán hàng.',
     NOW() - INTERVAL 13 DAY, true),
    (8, 3, 'Tôi có thể giúp anh với việc này. Dữ liệu của anh được lưu trữ ở định dạng nào và có bao nhiêu bản ghi?',
     NOW() - INTERVAL 13 DAY, true),
    (3, 8,
     'Dữ liệu được xuất từ hệ thống CRM dưới dạng Excel, khoảng 50.000 bản ghi. Tôi cần một dashboard để theo dõi KPI.',
     NOW() - INTERVAL 12 DAY, true),

-- Quang Bùi (3) with Hoàng Anh (6)
    (3, 6, 'Chào Hoàng Anh, tôi là Quang Bùi. Tôi cần phát triển ứng dụng mobile cho hệ thống quản lý của công ty.',
     NOW() - INTERVAL 30 DAY, true),
    (6, 3, 'Chào anh Quang, cảm ơn anh đã liên hệ. Anh có thể chia sẻ thêm về yêu cầu của ứng dụng không?',
     NOW() - INTERVAL 30 DAY, true),
    (3, 6, 'Chúng tôi cần một ứng dụng cho nhân viên xem báo cáo, quản lý lịch làm việc và gửi yêu cầu nghỉ phép.',
     NOW() - INTERVAL 29 DAY, true),
    (6, 3, 'Tôi hiểu rồi. Anh muốn phát triển cho iOS, Android hay cả hai?', NOW() - INTERVAL 29 DAY, true),
    (3, 6, 'Chúng tôi cần cả hai nền tảng. Anh có kiến nghị gì về công nghệ không?', NOW() - INTERVAL 28 DAY, true),

-- Quang Bùi (3) with Lan Anh (11)
    (3, 11, 'Chào chị Lan Anh, tôi là Quang Bùi. Tôi cần một video quảng cáo ngắn cho sản phẩm mới.',
     NOW() - INTERVAL 25 DAY, true),
    (11, 3, 'Chào anh Quang, rất vui được biết đến dự án của anh. Anh có thể chia sẻ thêm về sản phẩm không?',
     NOW() - INTERVAL 25 DAY, true),
    (3, 11,
     'Đó là một phần mềm quản lý dự án dành cho các doanh nghiệp vừa và nhỏ. Tôi cần video khoảng 1-2 phút giới thiệu tính năng chính.',
     NOW() - INTERVAL 24 DAY, true),
    (11, 3, 'Tôi có thể hỗ trợ anh với dự án này. Anh đã có kịch bản và footage chưa?', NOW() - INTERVAL 24 DAY, true),
    (3, 11, 'Tôi có ý tưởng nhưng chưa có kịch bản chi tiết. Tôi mong chị có thể hỗ trợ cả phần sáng tạo nội dung.',
     NOW() - INTERVAL 23 DAY, true),

-- Quang Bùi (3) with Kim Ngân (13)
    (3, 13,
     'Chào chị Kim Ngân, tôi là Quang Bùi. Tôi cần dịch tài liệu kỹ thuật sang tiếng Anh cho đối tác nước ngoài.',
     NOW() - INTERVAL 17 DAY, true),
    (13, 3, 'Chào anh Quang, rất vui được kết nối. Anh có thể cho tôi biết thêm về loại tài liệu và độ dài không?',
     NOW() - INTERVAL 17 DAY, true),
    (3, 13,
     'Đó là tài liệu mô tả kỹ thuật của một hệ thống phần mềm, khoảng 40 trang với nhiều thuật ngữ chuyên ngành.',
     NOW() - INTERVAL 16 DAY, true),
    (13, 3, 'Tôi có kinh nghiệm với các tài liệu kỹ thuật và có thể hỗ trợ anh. Thời hạn dự kiến là khi nào?',
     NOW() - INTERVAL 16 DAY, true),
    (3, 13, 'Tôi cần trong vòng 3 tuần. Chị có thể đáp ứng được không?', NOW() - INTERVAL 15 DAY, true),

-- Quang Bùi (3) with Hiếu Nguyễn (15)
    (3, 15, 'Chào anh Hiếu, tôi là Quang Bùi. Tôi muốn đào tạo đội ngũ marketing của công ty về content writing.',
     NOW() - INTERVAL 35 DAY, true),
    (15, 3, 'Chào anh Quang, cảm ơn anh đã liên hệ. Đội ngũ của anh có bao nhiêu người và mục tiêu đào tạo là gì?',
     NOW() - INTERVAL 35 DAY, true),
    (3, 15, 'Chúng tôi có 5 nhân viên marketing cần nâng cao kỹ năng viết content chuẩn SEO và quảng cáo.',
     NOW() - INTERVAL 34 DAY, true),
    (15, 3, 'Tôi có thể thiết kế khóa học phù hợp cho đội ngũ của anh. Anh muốn đào tạo online hay trực tiếp?',
     NOW() - INTERVAL 34 DAY, true),
    (3, 15,
     'Chúng tôi ưu tiên đào tạo trực tiếp kết hợp với bài tập thực hành. Anh có thể thiết kế khóa học 2 ngày được không?',
     NOW() - INTERVAL 33 DAY, true),

-- Additional conversations for User 4 (Tiến Đinh - Freelancer)
-- Tiến Đinh (4) with Minh Thành (7)
    (4, 7, 'Chào anh Minh Thành, tôi là Tiến Đinh. Tôi thấy anh đang tìm digital marketer cho dự án của mình.',
     NOW() - INTERVAL 20 DAY, true),
    (7, 4, 'Chào Tiến, đúng vậy. Chúng tôi cần một chiến dịch marketing cho sản phẩm mới.', NOW() - INTERVAL 20 DAY,
     true),
    (4, 7, 'Tôi có kinh nghiệm với nhiều chiến dịch ra mắt sản phẩm. Anh có thể chia sẻ thêm về sản phẩm không?',
     NOW() - INTERVAL 19 DAY, true),
    (7, 4, 'Đó là một ứng dụng quản lý tài chính cá nhân, đối tượng mục tiêu là người trẻ 25-35 tuổi.',
     NOW() - INTERVAL 19 DAY, true),
    (4, 7,
     'Tôi hiểu rồi. Tôi có kinh nghiệm tiếp cận đối tượng này thông qua TikTok, Instagram và YouTube. Anh có ý tưởng riêng về kênh marketing không?',
     NOW() - INTERVAL 18 DAY, true),

-- Tiến Đinh (4) with Thành Sơn (10)
    (4, 10, 'Chào anh Thành Sơn, tôi là Tiến Đinh. Tôi thấy anh đang cần hỗ trợ marketing cho công ty tư vấn.',
     NOW() - INTERVAL 15 DAY, true),
    (10, 4, 'Chào Tiến, đúng vậy. Chúng tôi cần quảng bá dịch vụ tư vấn phân tích kinh doanh.', NOW() - INTERVAL 15 DAY,
     true),
    (4, 10, 'Tôi đã từng làm việc với nhiều công ty tư vấn B2B. Đối tượng khách hàng mục tiêu của anh là gì?',
     NOW() - INTERVAL 14 DAY, true),
    (10, 4, 'Chúng tôi nhắm đến các doanh nghiệp vừa trong lĩnh vực sản xuất và logistics.', NOW() - INTERVAL 14 DAY,
     true),
    (4, 10,
     'Tôi có thể giúp anh với chiến lược content marketing và LinkedIn Ads, rất hiệu quả với B2B. Anh có ngân sách dự kiến không?',
     NOW() - INTERVAL 13 DAY, true),

-- Tiến Đinh (4) with Hoàng Long (12)
    (4, 12, 'Chào anh Hoàng Long, tôi là Tiến Đinh. Tôi thấy agency của anh đang cần hỗ trợ digital marketing.',
     NOW() - INTERVAL 22 DAY, true),
    (12, 4, 'Chào Tiến, đúng vậy. Chúng tôi cần một chiến dịch quảng cáo Google và Facebook cho khách hàng.',
     NOW() - INTERVAL 22 DAY, true),
    (4, 12, 'Tôi chuyên về hai nền tảng này. Khách hàng của anh thuộc lĩnh vực nào?', NOW() - INTERVAL 21 DAY, true),
    (12, 4, 'Đó là một thương hiệu thời trang local brand mới, cần tăng nhận diện và doanh số online.',
     NOW() - INTERVAL 21 DAY, true),
    (4, 12,
     'Tôi đã từng làm việc với nhiều thương hiệu thời trang, có thể chia sẻ portfolio và case study nếu anh quan tâm.',
     NOW() - INTERVAL 20 DAY, true),

-- Tiến Đinh (4) with Ngọc Lan (8)
    (4, 8, 'Chào chị Ngọc Lan, tôi là Tiến Đinh. Tôi thấy chị chuyên về phân tích dữ liệu.', NOW() - INTERVAL 28 DAY,
     true),
    (8, 4, 'Chào Tiến, đúng vậy. Tôi chuyên phân tích dữ liệu và tạo dashboard. Có gì tôi có thể giúp được không?',
     NOW() - INTERVAL 28 DAY, true),
    (4, 8,
     'Tôi cần phân tích hiệu quả các chiến dịch marketing. Hiện tôi có dữ liệu từ Google Analytics và Facebook Ads.',
     NOW() - INTERVAL 27 DAY, true),
    (8, 4, 'Tôi có thể giúp bạn với việc này. Bạn muốn tập trung vào những KPI nào?', NOW() - INTERVAL 27 DAY, true),
    (4, 8, 'Tôi quan tâm đến conversion rate, chi phí mỗi conversion, và customer journey từ các kênh khác nhau.',
     NOW() - INTERVAL 26 DAY, true),

-- Tiến Đinh (4) with Lan Anh (11)
    (4, 11, 'Chào chị Lan Anh, tôi là Tiến Đinh. Tôi cần hỗ trợ chỉnh sửa video cho chiến dịch marketing.',
     NOW() - INTERVAL 18 DAY, true),
    (11, 4, 'Chào Tiến, rất vui được kết nối. Bạn cần loại video như thế nào?', NOW() - INTERVAL 18 DAY, true),
    (4, 11, 'Tôi cần một video quảng cáo ngắn 30 giây và 5 video ngắn cho social media.', NOW() - INTERVAL 17 DAY,
     true),
    (11, 4, 'Tôi có thể giúp bạn với cả hai. Bạn đã có footage hoặc storyboard chưa?', NOW() - INTERVAL 17 DAY, true),
    (4, 11, 'Tôi có storyboard nhưng chưa có footage. Chị có thể hỗ trợ quay không, hoặc giới thiệu đơn vị quay phim?',
     NOW() - INTERVAL 16 DAY, true),
-- Conversation between Client Minh Triết (ID: 14) and Freelancer Kim Ngân (ID: 13)
    (14, 13,
     'Chào Kim Ngân, tôi cần dịch một số tài liệu marketing cho studio ảnh của tôi từ tiếng Việt sang tiếng Anh.',
     NOW() - INTERVAL 9 DAY, true),
    (13, 14, 'Chào anh Minh Triết, tôi rất vui được hỗ trợ anh. Anh có thể cho tôi biết loại tài liệu và độ dài không?',
     NOW() - INTERVAL 9 DAY, true),
    (14, 13, 'Chúng tôi có website, brochure và một số bài viết blog với tổng cộng khoảng 30 trang.',
     NOW() - INTERVAL 8 DAY, true),
    (13, 14,
     'Tôi hiểu rồi. Tôi có kinh nghiệm dịch nội dung marketing và sáng tạo. Thời hạn dự kiến của anh là khi nào?',
     NOW() - INTERVAL 8 DAY, true),
    (14, 13, 'Tôi cần trong vòng 2 tuần. Bạn có thể đáp ứng được không?', NOW() - INTERVAL 7 DAY, true),
    (13, 14,
     'Với khối lượng 30 trang, tôi có thể hoàn thành trong 2 tuần. Mức giá của tôi là 200.000 VND/trang tiêu chuẩn. Anh có yêu cầu gì đặc biệt về phong cách không?',
     NOW() - INTERVAL 7 DAY, true),
    (14, 13,
     'Tôi muốn giữ tone sáng tạo nhưng chuyên nghiệp, phù hợp với khách hàng quốc tế. Mức giá OK, tôi sẽ gửi tài liệu qua email.',
     NOW() - INTERVAL 6 DAY, true),
    (13, 14,
     'Tôi sẽ đảm bảo tone phù hợp với đối tượng khách hàng quốc tế. Sau khi nhận tài liệu, tôi sẽ gửi bản dịch mẫu 1 trang để anh xem xét trước khi tiếp tục.',
     NOW() - INTERVAL 6 DAY, true),
    (14, 13, 'Tôi đã gửi tài liệu qua email. Mong bạn xác nhận đã nhận được.', NOW() - INTERVAL 5 DAY, true),
    (13, 14,
     'Tôi đã nhận được tài liệu và đang xem qua. Sẽ gửi bản dịch mẫu cho anh vào ngày mai. Cảm ơn anh đã tin tưởng!',
     NOW() - INTERVAL 5 DAY, false),
    -- Tiến Đinh (4) with Kim Ngân (13)
    (4, 13, 'Chào chị Kim Ngân, tôi là Tiến Đinh. Tôi cần dịch một số nội dung marketing sang tiếng Anh.',
     NOW() - INTERVAL 32 DAY, true),
    (13, 4, 'Chào Tiến, rất vui được kết nối. Bạn cần dịch nội dung gì vậy?', NOW() - INTERVAL 32 DAY, true),
    (4, 13, 'Tôi cần dịch các bài viết blog, caption mạng xã hội và một số email marketing.', NOW() - INTERVAL 31 DAY,
     true),
    (13, 4, 'Tôi có thể hỗ trợ bạn. Tổng cộng khoảng bao nhiêu từ và thời hạn dự kiến là khi nào?',
     NOW() - INTERVAL 31 DAY, true),
    (4, 13, 'Khoảng 5000 từ và tôi cần trong vòng 1 tuần. Có khả thi không chị?', NOW() - INTERVAL 30 DAY, true),

-- Additional conversations for User 5 (Huy Đinh - Client)
-- Huy Đinh (5) with Hoàng Anh (6)
    (5, 6, 'Chào anh Hoàng Anh, tôi là Huy Đinh. Tôi cần phát triển một ứng dụng mobile cho doanh nghiệp của tôi.',
     NOW() - INTERVAL 25 DAY, true),
    (6, 5, 'Chào anh Huy, cảm ơn anh đã liên hệ. Anh có thể chia sẻ thêm về yêu cầu ứng dụng không?',
     NOW() - INTERVAL 25 DAY, true),
    (5, 6, 'Tôi cần một ứng dụng cho phép khách hàng đặt lịch dịch vụ và nhận thông báo.', NOW() - INTERVAL 24 DAY,
     true),
    (6, 5, 'Tôi hiểu rồi. Anh muốn phát triển cho iOS, Android hay cả hai?', NOW() - INTERVAL 24 DAY, true),
    (5, 6, 'Chúng tôi cần cả hai nền tảng. Và tôi muốn tích hợp thanh toán qua ví điện tử nữa.',
     NOW() - INTERVAL 23 DAY, true),

-- Huy Đinh (5) with Ngọc Lan (8)
    (5, 8, 'Chào chị Ngọc Lan, tôi là Huy Đinh. Tôi cần phân tích dữ liệu kinh doanh để đưa ra quyết định đầu tư.',
     NOW() - INTERVAL 28 DAY, true),
    (8, 5, 'Chào anh Huy, rất vui được kết nối. Anh có dữ liệu gì và muốn phân tích những gì?', NOW() - INTERVAL 28 DAY,
     true),
    (5, 8,
     'Tôi có dữ liệu doanh thu, chi phí và lợi nhuận của 5 chi nhánh trong 3 năm qua. Cần phân tích hiệu quả để quyết định mở rộng.',
     NOW() - INTERVAL 27 DAY, true),
    (8, 5,
     'Tôi có thể giúp anh phân tích và tạo dashboard để so sánh hiệu quả các chi nhánh. Anh đang có dữ liệu ở định dạng nào?',
     NOW() - INTERVAL 27 DAY, true),
    (5, 8, 'Tôi có file Excel. Chị có thể tạo các biểu đồ so sánh và dự báo tăng trưởng không?',
     NOW() - INTERVAL 26 DAY, true),

-- Huy Đinh (5) with Lan Anh (11)
    (5, 11, 'Chào chị Lan Anh, tôi là Huy Đinh. Tôi cần một video giới thiệu công ty cho website mới.',
     NOW() - INTERVAL 30 DAY, true),
    (11, 5, 'Chào anh Huy, rất vui được kết nối. Anh có thể chia sẻ thêm về công ty và mong muốn cho video không?',
     NOW() - INTERVAL 30 DAY, true),
    (5, 11, 'Công ty tôi hoạt động trong lĩnh vực công nghệ, cần video khoảng 2-3 phút giới thiệu văn hóa và dịch vụ.',
     NOW() - INTERVAL 29 DAY, true),
    (11, 5, 'Tôi có thể hỗ trợ anh. Anh muốn video theo phong cách nào? Chuyên nghiệp, trẻ trung hay sáng tạo?',
     NOW() - INTERVAL 29 DAY, true),
    (5, 11, 'Tôi muốn theo phong cách chuyên nghiệp nhưng vẫn hiện đại. Chị cần những gì để bắt đầu?',
     NOW() - INTERVAL 28 DAY, true),

-- Huy Đinh (5) with Kim Ngân (13)
    (5, 13,
     'Chào chị Kim Ngân, tôi là Huy Đinh. Tôi cần dịch tài liệu giới thiệu công ty sang tiếng Anh và tiếng Nhật.',
     NOW() - INTERVAL 21 DAY, true),
    (13, 5,
     'Chào anh Huy, cảm ơn anh đã liên hệ. Tôi có thể hỗ trợ tiếng Anh, và tôi có đồng nghiệp chuyên tiếng Nhật.',
     NOW() - INTERVAL 21 DAY, true),
    (5, 13, 'Tuyệt vời! Tôi có khoảng 15 trang giới thiệu công ty, sản phẩm và dịch vụ.', NOW() - INTERVAL 20 DAY,
     true),
    (13, 5, 'Vâng, tôi có thể xử lý tài liệu này. Anh cần trong thời gian bao lâu?', NOW() - INTERVAL 20 DAY, true),
    (5, 13, 'Tôi cần trong vòng 2 tuần. Giá cả thế nào vậy chị?', NOW() - INTERVAL 19 DAY, true),

-- Huy Đinh (5) with Hiếu Nguyễn (15)
    (5, 15, 'Chào anh Hiếu, tôi là Huy Đinh. Tôi muốn tìm hiểu về khóa học Digital Marketing của anh.',
     NOW() - INTERVAL 35 DAY, true),
    (15, 5, 'Chào anh Huy, cảm ơn anh đã quan tâm. Anh muốn học cho cá nhân hay cho đội ngũ?', NOW() - INTERVAL 35 DAY,
     true),
    (5, 15,
     'Tôi muốn học cho bản thân để quản lý team marketing hiệu quả hơn. Tôi đặc biệt quan tâm đến phần đo lường và phân tích.',
     NOW() - INTERVAL 34 DAY, true),
    (15, 5,
     'Tôi có khóa học Digital Marketing Analytics rất phù hợp với nhu cầu của anh. Khóa học bao gồm Google Analytics, Facebook Insights và các công cụ báo cáo.',
     NOW() - INTERVAL 34 DAY, true),
    (5, 15, 'Khóa học diễn ra trong bao lâu và lịch học thế nào vậy anh?', NOW() - INTERVAL 33 DAY, true),

-- Huy Đinh (5) with Minh Thành (7)
    (5, 7, 'Chào anh Minh Thành, tôi là Huy Đinh. Tôi đang tìm Project Manager cho dự án phần mềm của công ty.',
     NOW() - INTERVAL 18 DAY, true),
    (7, 5, 'Chào anh Huy, rất vui được kết nối. Anh có thể chia sẻ thêm về dự án không?', NOW() - INTERVAL 18 DAY,
     true),
    (5, 7,
     'Chúng tôi đang phát triển một hệ thống ERP nội bộ, cần người quản lý tiến độ và phối hợp với đội phát triển.',
     NOW() - INTERVAL 17 DAY, true),
    (7, 5,
     'Tôi có kinh nghiệm quản lý các dự án phần mềm quy mô lớn và làm việc theo Agile/Scrum. Dự án của anh dự kiến kéo dài bao lâu?',
     NOW() - INTERVAL 17 DAY, true),
    (5, 7,
     'Dự án sẽ kéo dài khoảng 6 tháng, nhưng chúng tôi cần người quản lý lâu dài để tiếp tục phát triển tính năng mới.',
     NOW() - INTERVAL 16 DAY, true);


INSERT INTO client (from_price, to_price, type_price, user_id)
VALUES (500000, 2000000, 'VNĐ', 3),
       (1000000, 3000000, 'VNĐ', 5),
       (1500000, 3500000, 'VNĐ', 7),
       (2000000, 5000000, 'VNĐ', 10),
       (2500000, 6000000, 'VNĐ', 12),
       (1800000, 4500000, 'VNĐ', 14);


INSERT INTO company (company_name, phone_contact, address, industry, client_id)
VALUES ('Công ty Công nghệ IBM', '0911001100', 'Đà Nẵng', 'Công nghệ phần mềm', 1),
       ('Công ty Phát triển NVIDIA', '0911002200', 'Cần Thơ', 'Giải pháp phần mềm & Backend', 2),
       ('Tập đoàn Dự án MT', '0911003300', 'Hồ Chí Minh', 'Quản lý dự án CNTT', 3),
       ('Công ty Tư vấn Giải pháp SD', '0911004400', 'Đà Nẵng', 'Tư vấn phân tích nghiệp vụ', 4),
       ('Agency Thiết kế Đồ họa LT', '0911005500', 'Hồ Chí Minh', 'Thiết kế đồ họa & Agency', 5),
       ('Studio Ảnh Minh Triết', '0911006600', 'Hà Nội', 'Studio ảnh cưới và thời trang', 6);

INSERT INTO category (category_title)
VALUES ('Lập trình & Phát triển phần mềm'),
       ('Thiết kế đồ họa & Multimedia'),
       ('Viết lách & Dịch thuật'),
       ('Marketing & Quảng cáo'),
       ('SEO & Phát triển nội dung'),
       ('Dịch vụ khách hàng & Hỗ trợ kỹ thuật'),
       ('Tư vấn kinh doanh & Tài chính'),
       ('Quản lý dự án & Điều hành'),
       ('Sản xuất video & Chỉnh sửa phim'),
       ('Nhập liệu & Hành chính văn phòng');

INSERT INTO skill (skill_name)
VALUES ('Java'),
       ('Spring Boot'),
       ('ReactJS'),
       ('Vue.js'),
       ('Angular'),
       ('Node.js'),
       ('Express.js'),
       ('Python'),
       ('Django'),
       ('Flask'),
       ('Ruby on Rails'),
       ('PHP'),
       ('Laravel'),
       ('C#'),
       ('.NET Core'),
       ('C++'),
       ('Swift'),
       ('Kotlin'),
       ('Flutter'),
       ('React Native'),
       ('SQL'),
       ('MySQL'),
       ('PostgreSQL'),
       ('MongoDB'),
       ('Firebase'),
       ('Data Analysis'),
       ('Data Science'),
       ('Machine Learning'),
       ('Deep Learning'),
       ('TensorFlow'),
       ('PyTorch'),
       ('AWS'),
       ('Azure'),
       ('Google Cloud Platform'),
       ('Docker'),
       ('Kubernetes'),
       ('Jenkins'),
       ('CI/CD Pipelines'),
       ('UI/UX Design'),
       ('Adobe Photoshop'),
       ('Adobe Illustrator'),
       ('Figma'),
       ('Sketch'),
       ('Canva'),
       ('Blender 3D'),
       ('Maya'),
       ('Cinema 4D'),
       ('SEO Optimization'),
       ('Copywriting'),
       ('Content Writing'),
       ('Blog Writing'),
       ('Technical Writing'),
       ('Email Marketing'),
       ('Social Media Marketing'),
       ('Affiliate Marketing'),
       ('Google Ads'),
       ('Facebook Ads'),
       ('TikTok Ads'),
       ('Video Editing'),
       ('Adobe Premiere Pro'),
       ('Final Cut Pro'),
       ('After Effects'),
       ('Animation'),
       ('3D Modeling'),
       ('Music Production'),
       ('Podcast Editing'),
       ('Data Entry'),
       ('Virtual Assistant'),
       ('Project Management'),
       ('Business Consulting'),
       ('Customer Support'),
       ('Sales'),
       ('Lead Generation'),
       ('Accounting'),
       ('Bookkeeping'),
       ('English Translation'),
       ('Chinese Translation'),
       ('Japanese Translation'),
       ('Korean Translation'),
       ('Spanish Translation'),
       ('French Translation'),
       ('German Translation'),
       ('Proofreading'),
       ('Transcription');

INSERT INTO freelancer (hourly_rate, description, category_id, user_id)
VALUES (20.00, 'Backend Developer chuyên về Java Spring Boot, xây dựng API và quản lý cơ sở dữ liệu.', 1, 2),
       (15.00, 'Digital Marketer với chuyên môn SEO, Google Ads và Facebook Ads, giúp tăng trưởng doanh thu.', 4, 4),
       (18.00, 'Mobile Developer chuyên phát triển ứng dụng đa nền tảng với Flutter và React Native.', 1, 6),
       (22.00, 'Data Analyst với kinh nghiệm phân tích và trực quan hóa dữ liệu bằng Power BI và Tableau.', 7, 8),
       (17.00, 'Video Editor chuyên hậu kỳ cho các video sự kiện, quảng cáo và phim ngắn.', 9, 11),
       (14.00, 'Phiên dịch viên và biên tập viên chuyên xử lý tài liệu kỹ thuật và sáng tạo.', 3, 13),
       (16.00, 'Online Tutor chuyên đào tạo kỹ năng viết nội dung chuẩn SEO và Digital Marketing.', 5, 15);

INSERT INTO projects (title, tech, description, link, image, freelancer_id)
VALUES ('API Payment Integration', 'Java Spring Boot, REST API, MySQL',
        'Tích hợp hệ thống thanh toán trực tuyến qua VNPay cho một ứng dụng thương mại điện tử.',
        'https://github.com/quangvu/api-payment-integration', 'payment-integration.png', 1),
       ('User Management System', 'Java Spring Boot, JWT, PostgreSQL',
        'Xây dựng hệ thống quản lý người dùng với tính năng phân quyền và bảo mật JWT.',
        'https://github.com/quangvu/user-management-system', 'user-management.png', 1),
       ('SEO Growth Campaign', 'SEO, Google Analytics, Ahrefs',
        'Tối ưu hóa công cụ tìm kiếm cho website thương mại điện tử, tăng lượng truy cập tự nhiên 200% trong 3 tháng.',
        'https://behance.net/tienSEOcampaign', 'seo-growth.png', 2),
       ('Facebook Ads for Fashion Brand', 'Facebook Ads Manager, Canva, Copywriting',
        'Chạy chiến dịch Facebook Ads giúp thương hiệu thời trang tăng doanh thu lên 150% trong mùa sale.',
        'https://behance.net/tienfacebookads', 'fashion-ads.png', 2),
       ('E-Commerce Mobile App', 'Flutter, Firebase, Provider',
        'Ứng dụng mua sắm đa nền tảng với thanh toán trực tuyến và theo dõi đơn hàng.',
        'https://github.com/hoanganhpham/ecommerce-app', 'ecommerce-app.png', 3),
       ('Fitness Tracker App', 'React Native, Redux, NodeJS',
        'Ứng dụng theo dõi sức khỏe và luyện tập, tích hợp đồng bộ với đồng hồ thông minh.',
        'https://github.com/hoanganhpham/fitness-tracker', 'fitness-tracker.png', 3),
       ('Sales Dashboard', 'Power BI, DAX, Excel',
        'Dashboard trực quan hóa số liệu bán hàng giúp doanh nghiệp theo dõi doanh thu và lợi nhuận theo thời gian thực.',
        'https://datavizworld.com/sales-dashboard', 'sales-dashboard.png', 4),
       ('Customer Behavior Analysis', 'Tableau, SQL Server, Python',
        'Phân tích hành vi người dùng từ dữ liệu CRM, đưa ra insight để tối ưu chiến dịch marketing.',
        'https://datavizworld.com/customer-analysis', 'customer-analysis.png', 4),
       ('Event Highlight Video', 'Adobe Premiere, After Effects',
        'Dựng video highlight sự kiện hội nghị khách hàng chuyên nghiệp, thời lượng 3 phút.',
        'https://vimeo.com/lananh/event-highlight', 'event-highlight.png', 5),
       ('Product Commercial Video', 'Adobe Premiere, Photoshop',
        'Video quảng cáo sản phẩm chăm sóc da, thiết kế hình ảnh sinh động và hấp dẫn.',
        'https://vimeo.com/lananh/product-commercial', 'product-commercial.png', 5),
       ('Technical Document Translation', 'SDL Trados, Microsoft Word',
        'Dịch tài liệu kỹ thuật phần mềm từ tiếng Anh sang tiếng Việt cho công ty CNTT.',
        'https://drive.google.com/tech-doc-translation', 'tech-doc.png', 6),
       ('Creative Content Editing', 'Grammarly, Google Docs',
        'Biên tập nội dung sáng tạo cho chiến dịch marketing, đảm bảo ngữ pháp và phong cách thu hút.',
        'https://drive.google.com/creative-editing', 'creative-editing.png', 6),
       ('SEO Copywriting Course', 'Zoom, Google Meet, Miro',
        'Khóa học trực tuyến hướng dẫn viết bài chuẩn SEO, tăng khả năng tiếp cận khách hàng.',
        'https://hieunguyen.com/seo-copywriting-course', 'seo-course.png', 7),
       ('Digital Marketing Masterclass', 'Google Classroom, Canva, Facebook Ads',
        'Đào tạo chuyên sâu về quảng cáo Google và Facebook, thực hành trực tiếp trên các chiến dịch thật.',
        'https://hieunguyen.com/digital-marketing-masterclass', 'digital-marketing.png', 7);

INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id, image)
VALUES ('2015-09-01', '2019-06-30', 'Tốt nghiệp loại giỏi chuyên ngành Kỹ thuật phần mềm.', 1, 2, 1, 1, null),
       ('2016-09-01', '2020-06-30', 'Hoàn thành chương trình đào tạo chuyên ngành Marketing kỹ thuật số.', 5, 1, 4, 2,
        null),
       ('2017-09-01', '2021-06-30', 'Nghiên cứu và phát triển các ứng dụng di động trong các dự án sinh viên.', 4, 2,
        12, 3, null),
       ('2014-09-01', '2018-06-30', 'Tốt nghiệp xuất sắc chuyên ngành Phân tích dữ liệu và Khoa học máy tính.', 2, 1, 7,
        4, null),
       ('2015-09-01', '2019-06-30', 'Tham gia nhiều dự án phim ngắn và video quảng cáo cho các câu lạc bộ.', 14, 1, 3,
        5, null),
       ('2013-09-01', '2017-06-30', 'Đào tạo chuyên sâu về Biên - Phiên dịch và Ngôn ngữ học.', 3, 1, 7, 6, null),
       ('2012-09-01', '2016-06-30', 'Đạt chứng chỉ Content Marketing và đào tạo SEO thực chiến.', 16, 6, 5, 7, null);

INSERT INTO experiences (company_name, position, start_date, end_date, description, status, freelancer_id)
VALUES ('TechCorp Solutions', 'Backend Developer', '2020-01-01', '2022-06-30',
        'Phát triển và bảo trì hệ thống backend với Java Spring Boot, xây dựng RESTful API cho các ứng dụng web.', true,
        1),
       ('Fintech Pro', 'Senior Backend Developer', '2022-07-01', '2024-12-31',
        'Thiết kế và phát triển hệ thống thanh toán, đảm bảo hiệu suất và bảo mật cao.', true, 1),
       ('Marketing Plus', 'Digital Marketing Specialist', '2019-05-01', '2021-12-31',
        'Quản lý chiến dịch SEO và quảng cáo Google/Facebook, giúp khách hàng tăng trưởng doanh thu 150%.', true, 2),
       ('Creative Ads Agency', 'Digital Marketing Lead', '2022-01-01', '2024-12-31',
        'Lãnh đạo đội ngũ marketing triển khai các chiến dịch đa kênh cho thương hiệu thời trang và giáo dục.', true,
        2),
       ('AppDev Studio', 'Mobile Developer', '2018-09-01', '2021-03-31',
        'Phát triển ứng dụng Android/iOS với Flutter, tích hợp các API thanh toán và bản đồ.', true, 3),
       ('NextGen Mobile', 'Senior Mobile Developer', '2021-04-01', '2024-12-31',
        'Dẫn dắt nhóm phát triển app thể thao và thương mại điện tử bằng React Native.', true, 3),
       ('Data Insights Co.', 'Junior Data Analyst', '2017-07-01', '2019-12-31',
        'Xử lý và phân tích dữ liệu khách hàng, tạo dashboard và báo cáo bằng Power BI.', true, 4),
       ('Smart Data Group', 'Senior Data Analyst', '2020-01-01', '2024-12-31',
        'Phân tích dữ liệu kinh doanh và xây dựng các báo cáo chiến lược giúp doanh nghiệp đưa ra quyết định.', true,
        4),
       ('Creative Studio', 'Video Editor', '2016-05-01', '2019-10-31',
        'Chỉnh sửa video sự kiện và TVC quảng cáo, đảm bảo chất lượng hình ảnh và âm thanh.', true, 5),
       ('Vision Media', 'Senior Video Editor', '2020-01-01', '2024-12-31',
        'Chịu trách nhiệm hậu kỳ các video viral, phim ngắn cho khách hàng lớn trong ngành thời trang và giải trí.',
        true, 5),
       ('Global Translations Ltd.', 'Technical Translator', '2018-03-01', '2020-06-30',
        'Dịch tài liệu kỹ thuật trong lĩnh vực phần mềm và viễn thông từ Anh sang Việt.', true, 6),
       ('Freelance Projects', 'Editor & Translator', '2020-07-01', '2024-12-31',
        'Biên dịch và hiệu đính tài liệu pháp lý, sáng tạo, đảm bảo nội dung chính xác và trôi chảy.', true, 6),
       ('EduTech Vietnam', 'Online Tutor', '2019-01-01', '2021-06-30',
        'Giảng dạy kỹ năng Digital Marketing và viết nội dung SEO cho sinh viên và doanh nghiệp vừa và nhỏ.', true, 7),
       ('Self-employed', 'Freelance Online Trainer', '2021-07-01', '2024-12-31',
        'Đào tạo trực tuyến các khóa học chuyên sâu về Content Writing và chiến lược Marketing số.', true, 7);

INSERT INTO job (title, scope, hour_work, duration, job_opportunity,
                 from_price, to_price, type_price, description,
                 type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
-- 1
('Phát triển Website thương mại điện tử', 'LARGE', 40, 60, true, 5000000, 15000000, 'VNĐ',
 'Cần phát triển một website thương mại điện tử hoàn chỉnh, tích hợp thanh toán online và giao diện thân thiện với người dùng.',
 'FULL', 'CLOSED', NOW(), NULL, 1, 1, NOW() - INTERVAL 15 DAY),
-- 2
('Lập trình viên ReactJS hỗ trợ UI/UX', 'MEDIUM', 20, 30, false, 3000000, 8000000, 'VNĐ',
 'Tìm kiếm một lập trình viên ReactJS giúp tối ưu hóa UI/UX cho hệ thống CRM.',
 'HOURLY', 'OPEN', NOW(), NULL, 1, 1, NOW() + INTERVAL 14 DAY),
-- 3
('Backend Developer Java Spring Boot', 'LARGE', 30, 90, true, 7000000, 20000000, 'VNĐ',
 'Cần backend developer có kinh nghiệm với Java Spring Boot, tối ưu hóa hiệu suất và bảo mật.',
 'FULL', 'OPEN', NOW(), NULL, 2, 1, NOW() + INTERVAL 14 DAY),
-- 4
('Kiểm thử và kiểm tra bảo mật hệ thống backend', 'MEDIUM', 25, 45, false, 5000000, 12000000, 'VNĐ',
 'Cần tester chuyên kiểm tra bảo mật hệ thống và viết báo cáo lỗi chi tiết.',
 'HOURLY', 'OPEN', NOW(), NULL, 2, 1, NOW() + INTERVAL 14 DAY),
-- 5
('Quản lý dự án phần mềm', 'LARGE', 40, 120, true, 10000000, 25000000, 'VNĐ',
 'Tìm kiếm freelancer có kinh nghiệm quản lý dự án Agile/Scrum cho ứng dụng di động.',
 'FULL', 'OPEN', NOW(), NULL, 3, 8, NOW() + INTERVAL 30 DAY),
-- 6
('Hỗ trợ lập kế hoạch và giám sát tiến độ dự án', 'MEDIUM', 15, 30, false, 0, 7000000, 'VNĐ',
 'Phụ trách lập kế hoạch chi tiết và báo cáo tiến độ cho dự án.',
 'HOURLY', 'OPEN', NOW(), NULL, 3, 8, NOW() + INTERVAL 30 DAY),
-- 7
('Phân tích nghiệp vụ hệ thống ERP', 'MEDIUM', 35, 60, true, 8000000, 18000000, 'VNĐ',
 'Cần BA có kinh nghiệm ERP để tư vấn và phân tích yêu cầu nghiệp vụ.',
 'FULL', 'OPEN', NOW(), NULL, 4, 7, NOW() + INTERVAL 14 DAY),
-- 8
('Viết tài liệu SRS và Use Case', 'SMALL', 20, 30, false, 5000000, 10000000, 'VNĐ',
 'Cần người có kinh nghiệm viết tài liệu phân tích nghiệp vụ, SRS và Use Case.',
 'HOURLY', 'OPEN', NOW(), NULL, 4, 7, NOW() + INTERVAL 14 DAY),
-- 9
('Thiết kế logo thương hiệu', 'SMALL', 10, 14, false, 2000000, 5000000, 'VNĐ',
 'Cần freelancer thiết kế logo sáng tạo và chuyên nghiệp cho công ty khởi nghiệp.',
 'HOURLY', 'OPEN', NOW(), NULL, 5, 2, NOW() + INTERVAL 30 DAY),
-- 10
('Thiết kế giao diện website UX/UI', 'MEDIUM', 30, 45, true, 5000000, 12000000, 'VNĐ',
 'Cần designer có kinh nghiệm thiết kế UX/UI cho ngành thời trang, ưu tiên có portfolio.',
 'FULL', 'OPEN', NOW(), NULL, 5, 2, NOW() + INTERVAL 30 DAY),
-- 11
('Chỉnh sửa ảnh cưới chuyên nghiệp', 'SMALL', 15, 30, true, 3000000, 7000000, 'VNĐ',
 'Cần freelancer chỉnh sửa ảnh cưới, blend màu sáng tạo theo yêu cầu studio.',
 'HOURLY', 'DRAFT', NOW(), NULL, 6, 9, NOW() + INTERVAL 14 DAY),
-- 12
('Biên tập video highlight đám cưới', 'SMALL', 20, 21, false, 4000000, 8000000, 'VNĐ',
 'Biên tập video cưới, thêm hiệu ứng và âm thanh phù hợp.',
 'HOURLY', 'OPEN', NOW(), NULL, 6, 9, NOW() + INTERVAL 14 DAY),
-- 13
('Phát triển Website bán hàng đa kênh', 'LARGE', 50, 75, true, 6000000, 16000000, 'VNĐ',
 'Cần xây dựng một website bán hàng đa kênh tích hợp quản lý kho và đồng bộ hóa đơn hàng từ các nền tảng TMĐT.',
 'FULL', 'BANNED', NOW(), NULL, 1, 1, NOW() + INTERVAL 14 DAY),
-- 14
('Phát triển API cho hệ thống quản lý khách hàng', 'LARGE', 35, 60, true, 8000000, 18000000, 'VNĐ',
 'Tuyển backend developer chuyên phát triển RESTful API với Java Spring Boot và tối ưu hóa bảo mật.',
 'FULL', 'CLOSED', NOW(), NULL, 2, 1, NOW() - INTERVAL 14 DAY),
-- 15
('Scrum Master cho dự án phát triển app mobile', 'LARGE', 30, 90, false, 9000000, 22000000, 'VNĐ',
 'Tuyển Scrum Master để điều phối nhóm phát triển ứng dụng di động, theo dõi tiến độ và đảm bảo chất lượng.',
 'FULL', 'OPEN', NOW(), NULL, 3, 8, NOW() + INTERVAL 30 DAY),
-- 16
('Thiết kế UX/UI cho sàn thương mại điện tử', 'MEDIUM', 40, 60, true, 7000000, 15000000, 'VNĐ',
 'Cần UI/UX designer thiết kế giao diện thân thiện, tối ưu trải nghiệm người dùng cho sàn thương mại điện tử.',
 'FULL', 'OPEN', NOW(), NULL, 5, 2, NOW() + INTERVAL 30 DAY),
-- 17
('Chỉnh sửa ảnh sự kiện chuyên nghiệp', 'SMALL', 12, 20, false, 2500000, 6000000, 'VNĐ',
 'Tuyển freelancer chỉnh sửa ảnh sự kiện hội nghị và lễ khai trương, yêu cầu chỉnh màu và blend tự nhiên.',
 'HOURLY', 'OPEN', NOW(), NULL, 6, 9, NOW() + INTERVAL 14 DAY);



INSERT INTO freelancer_skill (freelancer_id, skill_id)
VALUES (1, 1),
       (1, 2),
       (1, 21),
       (1, 22),
       (2, 48),
       (2, 56),
       (2, 57),
       (2, 50),
       (3, 19),
       (3, 20),
       (4, 26),
       (4, 21),
       (4, 22),
       (5, 59),
       (5, 60),
       (5, 62),
       (6, 76),
       (6, 83),
       (6, 84),
       (7, 50),
       (7, 49),
       (7, 48);


INSERT INTO job_skill (job_id, skill_id)
VALUES (1, 12),
       (1, 13),
       (1, 21),
       (1, 41),
       (2, 3),
       (2, 41),
       (2, 44),
       (3, 1),
       (3, 2),
       (3, 21),
       (3, 22),
       (3, 33),
       (4, 8),
       (4, 26),
       (5, 71),
       (5, 73),
       (6, 71),
       (6, 69),
       (6, 70),
       (7, 73),
       (7, 26),
       (7, 71),
       (8, 54),
       (8, 73),
       (8, 71),
       (9, 42),
       (9, 43),
       (9, 41),
       (9, 45),
       (10, 41),
       (10, 44),
       (10, 42),
       (10, 3),
       (11, 42),
       (11, 43),
       (11, 45),
       (12, 60),
       (12, 61),
       (12, 63),
       (13, 3),
       (13, 12),
       (13, 13),
       (13, 21),
       (13, 22),
       (13, 25),
       (13, 33),
       (13, 36),
       (14, 1),
       (14, 2),
       (14, 21),
       (14, 22),
       (14, 33),
       (14, 36),
       (15, 71),
       (15, 73),
       (15, 74),
       (15, 33),
       (15, 36),
       (16, 41),
       (16, 44),
       (16, 43),
       (17, 42),
       (17, 43),
       (17, 45);

INSERT INTO freelancer_review (rating, note)
VALUES (4.5,
        'Freelancer hoàn thành website thương mại điện tử đúng tiến độ, tích hợp thanh toán và giao diện chuyên nghiệp.'),
       (4.6,
        'Freelancer xây dựng hệ thống API chuyên nghiệp, hiệu năng ổn định và đáp ứng yêu cầu bảo mật cao. Giao tiếp dễ dàng, luôn cập nhật tiến độ kịp thời.'),
       (4.7, 'Freelancer backend Java Spring Boot làm việc chuyên nghiệp, tối ưu hệ thống hiệu quả.'),
       (4.8, 'Thiết kế UX/UI sáng tạo, đúng định hướng thương hiệu và chuyên nghiệp.'),
       (4.2, 'Freelancer quản lý dự án tốt, giám sát tiến độ team hiệu quả và có kỹ năng giao tiếp tốt.');


INSERT INTO client_review (rating, note)
VALUES (4.0, 'Client cung cấp tài liệu và yêu cầu đầy đủ, thanh toán đúng hẹn.'),
       (4.7,
        'Client cung cấp yêu cầu rõ ràng, phản hồi nhanh chóng trong suốt quá trình phát triển. Thanh toán đúng hạn, rất chuyên nghiệp.'),
       (4.5,
        'Dự án có quy mô rõ ràng, tài liệu chi tiết và hỗ trợ kịp thời khi cần làm rõ yêu cầu. Hợp tác mượt mà, rất đáng làm việc cùng.'),
       (4.3, 'Client rõ ràng về quy trình quản lý dự án, thanh toán kịp thời.'),
       (4.5, 'Client có tầm nhìn rõ ràng về thiết kế UX/UI, feedback rất chi tiết.');



INSERT INTO cv (title, url, status, freelancer_id)
VALUES
-- Freelancer 1: Backend Developer
('Senior Backend Developer', 'cv-sample1.pdf', TRUE, 1),
('Java Spring Boot Expert', 'cv-sample2.pdf', TRUE, 1),

-- Freelancer 2: Digital Marketer (ID 4 in the freelancer table)
('Digital Marketing Specialist', 'cv-sample3.pdf', TRUE, 2),
('SEO & Google Ads Expert', 'cv-sample4.pdf', FALSE, 2),

-- Freelancer 3: Mobile Developer (ID 6 in the freelancer table)
('Mobile App Developer', 'cv-sample5.pdf', TRUE, 3),
('Cross-Platform Developer', 'cv-sample6.pdf', TRUE, 3),

-- Freelancer 4: Data Analyst (ID 8 in the freelancer table)
('Data Analyst', 'cv-sample7.pdf', TRUE, 4),
('Business Intelligence Specialist', 'cv-sample8.pdf', FALSE, 4),

-- Freelancer 5: Video Editor (ID 11 in the freelancer table)
('Professional Video Editor', 'cv-sample9.pdf', TRUE, 5),
('Motion Graphics Designer', 'cv-sample10.pdf', TRUE, 5),

-- Freelancer 6: Translator & Editor (ID 13 in the freelancer table)
('Technical Translator', 'cv-sample11.pdf', TRUE, 6),
('Content Editor & Proofreader', 'cv-sample12.pdf', FALSE, 6),

-- Freelancer 7: Online Tutor (ID 15 in the freelancer table)
('Digital Marketing Tutor', 'cv-sample13.pdf', TRUE, 7);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, freelancer_review_id, client_review_id,
                            applied_date)
VALUES
-- Freelancer 1: Backend Developer (Category 1)
(false, 'APPROVED', 1, 1, 1, 1, 1, NOW() + INTERVAL 15 DAY),
(false, 'APPLIED', 1, 1, 3, NULL, NULL, NOW() + INTERVAL 10 DAY),
(false, 'APPLIED', 2, 1, 4, NULL, NULL, NOW() + INTERVAL 8 DAY),
(false, 'CANCELLED', 2, 1, 13, NULL, NULL, NOW() + INTERVAL 2 DAY),
(false, 'APPROVED', 1, 1, 14, 2, 2, NOW() + INTERVAL 3 DAY),

-- Freelancer 2: Digital Marketer (Category 4)
(false, 'APPLIED', 3, 2, 9, NULL, NULL, NOW() + INTERVAL 5 DAY),
(false, 'APPROVED', 3, 2, 10, 4, 5, NOW() + INTERVAL 2 DAY),
(false, 'VIEWED', 4, 2, 16, NULL, NULL, NOW() + INTERVAL 3 DAY),

-- Freelancer 3: Mobile Developer (Category 1)
(false, 'APPLIED', 5, 3, 2, NULL, NULL, NOW() + INTERVAL 7 DAY),
(false, 'APPLIED', 6, 3, 15, NULL, NULL, NOW() + INTERVAL 4 DAY),
(false, 'APPLIED', 5, 3, 3, NULL, NULL, NOW() + INTERVAL 6 DAY),

-- Freelancer 4: Data Analyst (Category 7)
(false, 'VIEWED', 7, 4, 7, NULL, NULL, NOW() + INTERVAL 2 DAY),
(false, 'APPLIED', 8, 4, 8, NULL, NULL, NOW() + INTERVAL 9 DAY),
(false, 'APPLIED', 7, 4, 3, NULL, NULL, NOW() + INTERVAL 11 DAY),

-- Freelancer 5: Video Editor (Category 9)
(false, 'VIEWED', 9, 5, 12, NULL, NULL, NOW() + INTERVAL 1 DAY),
(false, 'APPLIED', 10, 5, 17, NULL, NULL, NOW() + INTERVAL 5 DAY),
(false, 'APPROVED', 9, 5, 11, 3, 3, NOW() + INTERVAL 14 DAY),

-- Freelancer 6: Translator & Editor (Category 3)
(false, 'APPLIED', 11, 6, 8, NULL, NULL, NOW() + INTERVAL 3 DAY),
(false, 'VIEWED', 12, 6, 4, NULL, NULL, NOW() + INTERVAL 2 DAY),

-- Freelancer 7: Online Tutor (Category 5)
(false, 'APPLIED', 13, 7, 6, NULL, NULL, NOW() + INTERVAL 5 DAY),
(false, 'APPROVED', 13, 7, 15, 5, 4, NOW() + INTERVAL 25 DAY);

INSERT INTO reported_job (reason_freelancer, reason_admin, description, status, image, created_at, updated_at,
                          freelancer_id, job_id)
VALUES ('Công việc không rõ ràng về yêu cầu và phạm vi.', 'Đang xem xét thêm bằng chứng từ hai phía.',
        'Freelancer cho rằng thông tin công việc mơ hồ và client không phản hồi rõ ràng sau khi trao đổi.', 1,
        'https://example.com/images/report1.png', NOW(), NULL, 1, 13);

INSERT INTO appointments (topic, start_time, duration, description, link, client_id, freelancer_job_id)
VALUES ('Phỏng vấn công việc: Phát triển Website thương mại điện tử', NOW() + INTERVAL 1 DAY, 60,
        'Thảo luận chi tiết về yêu cầu và mong đợi dự án.', 'https://meet.example.com/1-1', 1, 1),
       ('Phỏng vấn công việc: Backend Developer Java Spring Boot', NOW() + INTERVAL 3 DAY, 60,
        'Cuộc trao đổi chi tiết về yêu cầu backend.', 'https://meet.example.com/2-1', 2, 2),
       ('Phỏng vấn công việc: Kiểm thử và kiểm tra bảo mật hệ thống backend', NOW() + INTERVAL 1 DAY, 60,
        'Phỏng vấn kỹ năng quản kiểm thử hệ thống.', 'https://meet.example.com/3-1', 2, 3),
       ('Phỏng vấn công việc: Phát triển Website bán hàng đa kênh', NOW() + INTERVAL 2 DAY, 30,
        'Thảo luận lập kế hoạch chi tiết và timeline.', 'https://meet.example.com/3-2', 1, 4),
       ('Phỏng vấn công việc: Phát triển API cho hệ thống quản lý khách hàng', NOW() + INTERVAL 3 DAY, 45,
        'Cuộc phỏng vấn kiểm tra kinh nghiệm làm việc với API.', 'https://meet.example.com/4-1', 2, 5),
       ('Phỏng vấn công việc: Lập trình viên ReactJS hỗ trợ UI/UX', NOW() + INTERVAL 4 DAY, 30,
        'Đánh giá kỹ năng Front-end.', 'https://meet.example.com/4-2', 1, 6),
       ('Phỏng vấn công việc: Scrum Master cho dự án phát triển app mobile', NOW() + INTERVAL 1 DAY, 30,
        'Phỏng vấn ý tưởng phát triển app.', 'https://meet.example.com/5-1', 3, 7),
       ('Phỏng vấn công việc: Viết tài liệu SRS và Use Case', NOW() + INTERVAL 2 DAY, 45, 'Trao đổi về Use Case.',
        'https://meet.example.com/5-2', 4, 9),
       ('Phỏng vấn công việc: Chỉnh sửa ảnh cưới chuyên nghiệp', NOW() + INTERVAL 1 DAY, 30,
        'Phỏng vấn về kỹ năng chỉnh sửa ảnh.', 'https://meet.example.com/6-1', 6, 11);

INSERT INTO voucher_packages (name, price, duration, number_post, type_package, status, created_at, updated_at, account)
VALUES ('Gói thường', 0, 7, 1, 0, true, NOW(), NULL, 1),
       ('Gói bạc', 90000, 14, 5, 1, true, NOW(), NULL, 1),
       ('Gói vàng', 290000, 14, 10, 2, true, NOW(), NULL, 1),
       ('Gói kim cương', 390000, 30, 10, 3, true, NOW(), NULL, 1);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 200000, 10, 3, true, 3, 1),
       (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 3, true, 2, 2),
       (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 3),
       (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 2, true, 2, 4),
       (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 5),
       (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 2, true, 2, 6);
INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 90000, 5, 5, false, 2, 1),
    (DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_SUB(NOW(), INTERVAL 5 DAY), 290000, 10, 7, false, 3, 1);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 0, 1, 1, false, 1, 2),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 15 DAY), 90000, 5, 5, false, 2, 2);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 90000, 5, 4, false, 2, 3),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 5 DAY), 290000, 10, 8, false, 3, 3);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 90000, 5, 3, false, 2, 4),
    (DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_SUB(NOW(), INTERVAL 5 DAY), 90000, 5, 4, false, 2, 4);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 290000, 10, 9, false, 3, 5),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 5 DAY), 290000, 10, 8, false, 3, 5);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 90000, 5, 3, false, 2, 6),
    (DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_SUB(NOW(), INTERVAL 5 DAY), 90000, 5, 4, false, 2, 6);

INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
    ('Lập trình viên Backend Java', 'MEDIUM', 30, 45, true, 4500000, 12000000, 'VNĐ', 'Phát triển các API và dịch vụ backend cho ứng dụng thương mại điện tử bằng Java Spring Boot.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 55 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Phát triển cơ sở dữ liệu', 'SMALL', 20, 30, false, 3000000, 8000000, 'VNĐ', 'Thiết kế và tối ưu hóa cơ sở dữ liệu MySQL cho ứng dụng web có lưu lượng truy cập cao.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 50 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Tích hợp thanh toán online', 'MEDIUM', 25, 35, true, 4000000, 9000000, 'VNĐ', 'Tích hợp các cổng thanh toán như VNPay, Momo vào hệ thống website hiện có.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 45 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Phát triển API Authentication', 'SMALL', 15, 25, false, 2500000, 6000000, 'VNĐ', 'Xây dựng hệ thống xác thực người dùng bằng JWT và OAuth2.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 40 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Thiết kế UI Dashboard', 'SMALL', 20, 30, false, 3000000, 7000000, 'VNĐ', 'Thiết kế giao diện dashboard quản trị cho website bán hàng bằng ReactJS.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 35 DAY), NULL, 1, 2, DATE_SUB(NOW(), INTERVAL 35 DAY));

INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
    ('Phát triển ứng dụng mobile Cross-platform', 'LARGE', 40, 60, true, 8000000, 20000000, 'VNĐ', 'Phát triển ứng dụng mobile đa nền tảng sử dụng Flutter hoặc React Native.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 25 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Thiết kế UI/UX cho ứng dụng mobile', 'MEDIUM', 30, 45, true, 6000000, 15000000, 'VNĐ', 'Thiết kế giao diện người dùng và trải nghiệm cho ứng dụng di động thương mại điện tử.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 20 DAY), NULL, 1, 2, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Phát triển backend cho ứng dụng di động', 'LARGE', 45, 60, true, 9000000, 22000000, 'VNĐ', 'Xây dựng hệ thống backend cho ứng dụng di động, bao gồm API và hệ thống đồng bộ dữ liệu.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 18 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Xây dựng hệ thống thông báo push', 'SMALL', 20, 30, false, 3500000, 8000000, 'VNĐ', 'Xây dựng hệ thống thông báo đẩy cho ứng dụng di động sử dụng Firebase Cloud Messaging.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 15 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Tích hợp Analytics và Tracking', 'SMALL', 15, 25, false, 3000000, 7000000, 'VNĐ', 'Tích hợp các công cụ phân tích dữ liệu như Google Analytics, Firebase Analytics vào ứng dụng.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 10 DAY), NULL, 1, 1, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Thiết kế logo và bộ nhận diện', 'SMALL', 10, 20, false, 2000000, 5000000, 'VNĐ', 'Thiết kế logo và bộ nhận diện thương hiệu cho ứng dụng di động.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 8 DAY), NULL, 1, 2, DATE_SUB(NOW(), INTERVAL 5 DAY)),
    ('Viết nội dung cho ứng dụng', 'SMALL', 15, 20, false, 2000000, 4500000, 'VNĐ', 'Viết nội dung giới thiệu, hướng dẫn sử dụng và các thông tin khác cho ứng dụng di động.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 7 DAY), NULL, 1, 3, DATE_SUB(NOW(), INTERVAL 5 DAY));

INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
    ('Nhập liệu sản phẩm lên website', 'SMALL', 10, 15, false, 1000000, 2000000, 'VNĐ', 'Nhập thông tin sản phẩm lên hệ thống website bán hàng.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 80 DAY), NULL, 2, 10, DATE_SUB(NOW(), INTERVAL 65 DAY)),
    ('Thiết kế banner quảng cáo', 'SMALL', 15, 20, false, 2000000, 4500000, 'VNĐ', 'Thiết kế các banner quảng cáo cho website và mạng xã hội.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 55 DAY), NULL, 2, 2, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Viết bài blog về công nghệ', 'SMALL', 10, 15, false, 1500000, 3500000, 'VNĐ', 'Viết các bài blog về công nghệ và xu hướng kỹ thuật mới.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 50 DAY), NULL, 2, 3, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Chỉnh sửa video giới thiệu', 'MEDIUM', 25, 30, true, 4000000, 9000000, 'VNĐ', 'Chỉnh sửa video giới thiệu sản phẩm và công ty, độ dài 2-3 phút.', 'FULL', 'CLOSED', DATE_SUB(NOW(), INTERVAL 45 DAY), NULL, 2, 9, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Tối ưu SEO cho website', 'MEDIUM', 20, 25, false, 3500000, 8000000, 'VNĐ', 'Tối ưu hóa website để cải thiện thứ hạng tìm kiếm trên Google.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 40 DAY), NULL, 2, 4, DATE_SUB(NOW(), INTERVAL 35 DAY)),
    ('Quản lý fanpage Facebook', 'SMALL', 15, 30, false, 3000000, 6000000, 'VNĐ', 'Quản lý fanpage Facebook của công ty, tạo nội dung và tương tác với khách hàng.', 'HOURLY', 'CLOSED', DATE_SUB(NOW(), INTERVAL 20 DAY), NULL, 2, 4, DATE_SUB(NOW(), INTERVAL 15 DAY));

INSERT INTO job_skill (job_id, skill_id)
VALUES
    ((SELECT id FROM job WHERE title = 'Lập trình viên Backend Java'), 1),
    ((SELECT id FROM job WHERE title = 'Lập trình viên Backend Java'), 2),
    ((SELECT id FROM job WHERE title = 'Lập trình viên Backend Java'), 21),
    ((SELECT id FROM job WHERE title = 'Lập trình viên Backend Java'), 22),
    ((SELECT id FROM job WHERE title = 'Phát triển cơ sở dữ liệu'), 21),
    ((SELECT id FROM job WHERE title = 'Phát triển cơ sở dữ liệu'), 22),
    ((SELECT id FROM job WHERE title = 'Phát triển cơ sở dữ liệu'), 23),
    ((SELECT id FROM job WHERE title = 'Tích hợp thanh toán online'), 1),
    ((SELECT id FROM job WHERE title = 'Tích hợp thanh toán online'), 2),
    ((SELECT id FROM job WHERE title = 'Tích hợp thanh toán online'), 6),
    ((SELECT id FROM job WHERE title = 'Tích hợp thanh toán online'), 25),
    ((SELECT id FROM job WHERE title = 'Phát triển API Authentication'), 1),
    ((SELECT id FROM job WHERE title = 'Phát triển API Authentication'), 2),
    ((SELECT id FROM job WHERE title = 'Phát triển API Authentication'), 6),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI Dashboard'), 3),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI Dashboard'), 39),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI Dashboard'), 41);

INSERT INTO job_skill (job_id, skill_id)
VALUES
    ((SELECT id FROM job WHERE title = 'Phát triển ứng dụng mobile Cross-platform'), 19),
    ((SELECT id FROM job WHERE title = 'Phát triển ứng dụng mobile Cross-platform'), 20),
    ((SELECT id FROM job WHERE title = 'Phát triển ứng dụng mobile Cross-platform'), 25),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI/UX cho ứng dụng mobile'), 39),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI/UX cho ứng dụng mobile'), 41),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI/UX cho ứng dụng mobile'), 42),
    ((SELECT id FROM job WHERE title = 'Thiết kế UI/UX cho ứng dụng mobile'), 43),
    ((SELECT id FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'), 1),
    ((SELECT id FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'), 2),
    ((SELECT id FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'), 21),
    ((SELECT id FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'), 22),
    ((SELECT id FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'), 33),
    ((SELECT id FROM job WHERE title = 'Xây dựng hệ thống thông báo push'), 1),
    ((SELECT id FROM job WHERE title = 'Xây dựng hệ thống thông báo push'), 6),
    ((SELECT id FROM job WHERE title = 'Xây dựng hệ thống thông báo push'), 25);

INSERT INTO job_skill (job_id, skill_id)
VALUES
    ((SELECT id FROM job WHERE title = 'Thiết kế banner quảng cáo'), 40),
    ((SELECT id FROM job WHERE title = 'Thiết kế banner quảng cáo'), 41),
    ((SELECT id FROM job WHERE title = 'Thiết kế banner quảng cáo'), 42),
    ((SELECT id FROM job WHERE title = 'Viết bài blog về công nghệ'), 49),
    ((SELECT id FROM job WHERE title = 'Viết bài blog về công nghệ'), 50),
    ((SELECT id FROM job WHERE title = 'Viết bài blog về công nghệ'), 51),
    ((SELECT id FROM job WHERE title = 'Chỉnh sửa video giới thiệu'), 59),
    ((SELECT id FROM job WHERE title = 'Chỉnh sửa video giới thiệu'), 60),
    ((SELECT id FROM job WHERE title = 'Chỉnh sửa video giới thiệu'), 61),
    ((SELECT id FROM job WHERE title = 'Tối ưu SEO cho website'), 48),
    ((SELECT id FROM job WHERE title = 'Tối ưu SEO cho website'), 49),
    ((SELECT id FROM job WHERE title = 'Tối ưu SEO cho website'), 50),
    ((SELECT id FROM job WHERE title = 'Quản lý fanpage Facebook'), 54),
    ((SELECT id FROM job WHERE title = 'Quản lý fanpage Facebook'), 55),
    ((SELECT id FROM job WHERE title = 'Quản lý fanpage Facebook'), 56);

INSERT INTO client_review (rating, note)
VALUES
    (4.0, 'Client đánh giá cao về kỹ năng và tiến độ làm việc.'),
    (4.5, 'Ứng viên hoàn thành công việc xuất sắc, đúng yêu cầu.'),
    (4.2, 'Chất lượng công việc tốt, giao tiếp hiệu quả.'),
    (4.6, 'Đáp ứng tốt yêu cầu, giao nộp đúng hạn.'),
    (4.3, 'Freelancer có kỹ năng chuyên môn tốt, dễ hợp tác.'),
    (4.1, 'Hoàn thành công việc tốt, đáp ứng mọi yêu cầu.'),
    (4.7, 'Làm việc chuyên nghiệp, kết quả xuất sắc.'),
    (4.4, 'Phản hồi nhanh chóng, chất lượng công việc cao.'),
    (4.8, 'Rất hài lòng với kết quả và cách làm việc.'),
    (4.2, 'Kỹ năng tốt, giao tiếp hiệu quả.');

INSERT INTO freelancer_review (rating, note)
VALUES
    (4.2, 'Client hỗ trợ tốt, yêu cầu rõ ràng.'),
    (4.5, 'Dự án thú vị, client dễ làm việc cùng.'),
    (4.0, 'Yêu cầu rõ ràng, thanh toán đúng hạn.'),
    (4.6, 'Client chuyên nghiệp, cung cấp feedback kịp thời.'),
    (4.3, 'Hợp tác tốt, dự án được quản lý hiệu quả.'),
    (4.1, 'Client thân thiện, yêu cầu hợp lý.'),
    (4.7, 'Rất tốt, mong được hợp tác lần sau.'),
    (4.4, 'Giao tiếp thuận lợi, yêu cầu rõ ràng.'),
    (4.8, 'Trải nghiệm làm việc tuyệt vời.'),
    (4.2, 'Client hỗ trợ nhiệt tình, dễ hợp tác.');

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 1, 1, id, DATE_SUB(NOW(), INTERVAL 54 DAY), 6, 6
FROM job WHERE title = 'Lập trình viên Backend Java'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 1 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 2, 1, id, DATE_SUB(NOW(), INTERVAL 49 DAY), 7, 7
FROM job WHERE title = 'Phát triển cơ sở dữ liệu'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 1 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 1, 1, id, DATE_SUB(NOW(), INTERVAL 44 DAY), 8, 8
FROM job WHERE title = 'Tích hợp thanh toán online'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 1 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'REJECTED', 5, 3, id, DATE_SUB(NOW(), INTERVAL 53 DAY), NULL, NULL
FROM job WHERE title = 'Lập trình viên Backend Java'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 3 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 5, 3, id, DATE_SUB(NOW(), INTERVAL 39 DAY), 9, 9
FROM job WHERE title = 'Phát triển API Authentication'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 3 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 3, 2, id, DATE_SUB(NOW(), INTERVAL 34 DAY), NULL, NULL
FROM job WHERE title = 'Thiết kế UI Dashboard'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 6, 3, id, DATE_SUB(NOW(), INTERVAL 24 DAY), 10, 10
FROM job WHERE title = 'Phát triển ứng dụng mobile Cross-platform'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 3 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 3, 2, id, DATE_SUB(NOW(), INTERVAL 19 DAY), 11, 11
FROM job WHERE title = 'Thiết kế UI/UX cho ứng dụng mobile'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 1, 1, id, DATE_SUB(NOW(), INTERVAL 17 DAY), 12, 12
FROM job WHERE title = 'Phát triển backend cho ứng dụng di động'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 1 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 5, 3, id, DATE_SUB(NOW(), INTERVAL 14 DAY), 13, 13
FROM job WHERE title = 'Xây dựng hệ thống thông báo push'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 3 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 9, 5, id, DATE_SUB(NOW(), INTERVAL 7 DAY), NULL, NULL
FROM job WHERE title = 'Thiết kế logo và bộ nhận diện'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 5 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 3, 2, id, DATE_SUB(NOW(), INTERVAL 6 DAY), 14, 14
FROM job WHERE title = 'Viết nội dung cho ứng dụng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 3, 2, id, DATE_SUB(NOW(), INTERVAL 39 DAY), 15, 15
FROM job WHERE title = 'Tối ưu SEO cho website'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 4, 2, id, DATE_SUB(NOW(), INTERVAL 49 DAY), null, null
FROM job WHERE title = 'Viết bài blog về công nghệ'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 9, 5, id, DATE_SUB(NOW(), INTERVAL 54 DAY), null, null
FROM job WHERE title = 'Thiết kế banner quảng cáo'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 5 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPROVED', 10, 5, id, DATE_SUB(NOW(), INTERVAL 44 DAY), null, null
FROM job WHERE title = 'Chỉnh sửa video giới thiệu'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 5 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 4, 2, id, DATE_SUB(NOW(), INTERVAL 19 DAY), NULL, NULL
FROM job WHERE title = 'Quản lý fanpage Facebook'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);

INSERT INTO banner (title, image, status, vendor, duration, created_at, updated_at, price, start_time, end_time, logo)
VALUES ('Grand Opening - Ưu đãi khai trương', '/images/opening_banner.jpg', true, 'TalentHub', 30, NOW(), NULL, 0,
        NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), NULL),
       ('Khuyến mãi Mùa Hè cùng VinFast', '/images/vinfast_summer.jpg', true, 'VinFast', 15, NOW(), NULL, 5000000,
        NOW(), DATE_ADD(NOW(), INTERVAL 15 DAY), NULL),
       ('Viettel - Internet tốc độ cao ưu đãi lớn', '/images/viettel_internet.jpg', true, 'Viettel', 20, NOW(), NULL,
        2000000, NOW(), DATE_ADD(NOW(), INTERVAL 20 DAY), NULL),
       ('FPT Play - Xem phim thả ga', '/images/fptplay_promo.jpg', true, 'FPT Telecom', 10, NOW(), NULL, 1500000, NOW(),
        DATE_ADD(NOW(), INTERVAL 10 DAY), NULL),
       ('Highlands Coffee - Giảm giá 50% thức uống', '/images/highlands_discount.jpg', true, 'Highlands Coffee', 7,
        NOW(), NULL, 1000000, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), NULL),
       ('Thế Giới Di Động - Mua sắm công nghệ giá sốc', '/images/tgdd_sale.jpg', true, 'Thế Giới Di Động', 14, NOW(),
        NULL, 3000000, NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), NULL);
