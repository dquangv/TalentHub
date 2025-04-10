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
        'Chuyên gia ReactJS, VueJS với nhiều dự án UI/UX hiện đại.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/Tung.jpg', 1),
       ('Quang', 'Vũ', '0987654321', 'Tân Phú', 'Hồ Chí Minh', 'Backend Developer',
        'Lập trình viên backend với 3 năm kinh nghiệm trong Java Spring Boot.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/QuangV.jpg', 2),
       ('Quang', 'Bùi', '0965432109', 'Bình Thạnh', 'Đà Nẵng', 'CEO', 'Chủ doanh nghiệp công ty công nghệ.',
        'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/QuangB.jpg', 3),
       ('Tiến', 'Đinh', '0954321098', 'Gò Vấp', 'Cần Thơ', 'Digital Marketer',
        'Chuyên gia SEO, quảng cáo Google Ads và Facebook Ads.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/Tien.jpg', 4),
       ('Huy', 'Đinh', '0943210987', 'Gò Vấp', 'Cần Thơ', 'Tech Lead',
        '10 năm kinh nghiệm với vai trò Back-end Development.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/Huy.jpg', 5),
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
       ('Transcription'),
       ('Podcast Editing'),
       ('3D Modeling'),
       ('Music Production'),
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
VALUES

    ('Khuyến mãi Mùa Hè cùng VinFast', 'https://raw.githubusercontent.com/quangbm0807/static-assets/main/banner/vinfast.jpg', true, 'VinFast', 15, NOW(), NULL, 5000000,
     NOW(), DATE_ADD(NOW(), INTERVAL 15 DAY), NULL),

    ('Viettel - Internet tốc độ cao ưu đãi lớn', 'https://raw.githubusercontent.com/quangbm0807/static-assets/main/banner/viettel.jpg', true, 'Viettel', 20, NOW(), NULL,
     2000000, NOW(), DATE_ADD(NOW(), INTERVAL 20 DAY), NULL),

    ('FPT Play - Xem phim thả ga', 'https://raw.githubusercontent.com/quangbm0807/static-assets/main/banner/fptshop.webp', true, 'FPT Telecom', 10, NOW(), NULL, 1500000, NOW(),
     DATE_ADD(NOW(), INTERVAL 10 DAY), NULL),

    ('Highlands Coffee - Giảm giá 50% thức uống', 'https://raw.githubusercontent.com/quangbm0807/static-assets/main/banner/highlands.jpg', true, 'Highlands Coffee', 7,
     NOW(), NULL, 1000000, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), NULL),

    ('Thế Giới Di Động - Mua sắm công nghệ giá sốc', 'https://raw.githubusercontent.com/quangbm0807/static-assets/main/banner/thegioididong.png', true, 'Thế Giới Di Động', 14, NOW(),
     NULL, 3000000, NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), NULL);


INSERT INTO account (email, password, role, created_at, updated_at, status, lat, lng)
VALUES
    ('hanhpps12345@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, null, null),
    ('duylps23456@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, null, null),
    ('thunps34567@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, null, null),
    ('baotps45678@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, null, null),
    ('mailyps56789@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, null, null);

INSERT INTO users (first_name, last_name, phone_number, province, country, title, introduction, image, account_id)
VALUES
    ('Hạnh', 'Phạm', '0912345678', 'Hải Phòng', 'Việt Nam', 'UI/UX Designer', 'Chuyên thiết kế giao diện cho các ứng dụng di động và website với 5 năm kinh nghiệm.', 'hanhpham.png', 16),
    ('Duy', 'Lê', '0923456789', 'Bình Dương', 'Việt Nam', 'DevOps Engineer', 'Chuyên gia triển khai hệ thống CI/CD, Docker và Kubernetes với kinh nghiệm quốc tế.', 'duyle.png', 17),
    ('Thu', 'Nguyễn', '0934567890', 'Huế', 'Việt Nam', 'Content Writer', 'Nhà văn sáng tạo với khả năng viết nội dung marketing hấp dẫn và tối ưu SEO.', 'thunguyen.png', 18),
    ('Bảo', 'Trần', '0945678901', 'Đà Lạt', 'Việt Nam', 'Game Developer', 'Lập trình viên game với chuyên môn Unity và Unreal Engine, từng phát hành nhiều game indie.', 'baotran.png', 19),
    ('Mai', 'Lý', '0956789012', 'Vũng Tàu', 'Việt Nam', 'Digital Illustrator', 'Họa sĩ kỹ thuật số chuyên vẽ minh họa cho sách, truyện tranh và ứng dụng.', 'maily.png', 20);
INSERT INTO freelancer (hourly_rate, description, category_id, user_id)
VALUES
    (19.00, 'UI/UX Designer với 5 năm kinh nghiệm thiết kế giao diện người dùng cho website và ứng dụng di động.', 2, 16),
    (25.00, 'DevOps Engineer chuyên triển khai CI/CD, Docker, Kubernetes và AWS.', 1, 17),
    (16.00, 'Digital Illustrator chuyên vẽ minh họa kỹ thuật số cho sách, truyện tranh và ứng dụng.', 2, 20);

INSERT INTO client (from_price, to_price, type_price, user_id)
VALUES
    (1500000, 4000000, 'VNĐ', 18),
    (2000000, 6000000, 'VNĐ', 19);

INSERT INTO company (company_name, phone_contact, address, industry, client_id)
VALUES
    ('Thu Content Creation', '0934567890', 'Huế', 'Content Writing & Marketing', 7),
    ('GameVerse Studio', '0945678901', 'Đà Lạt', 'Game Development', 8);
INSERT INTO cv (title, url, status, freelancer_id)
VALUES
    ('Content Marketing Expert', 'cv-sample14.pdf', TRUE, 7),
    ('SEO Specialist', 'cv-sample15.pdf', TRUE, 7),
    ('Full Stack Developer', 'cv-sample16.pdf', TRUE, 1),
    ('React Native Developer', 'cv-sample17.pdf', TRUE, 3),
    ('Data Visualization Expert', 'cv-sample18.pdf', TRUE, 4),
    ('Advanced Video Production', 'cv-sample19.pdf', TRUE, 5),
    ('IELTS Translation Specialist', 'cv-sample20.pdf', TRUE, 6);
INSERT INTO cv (title, url, status, freelancer_id)
VALUES
    ('UI/UX Professional Portfolio', 'cv-sample21.pdf', TRUE, 8),
    ('Mobile Design Expert', 'cv-sample22.pdf', TRUE, 8),
    ('DevOps Infrastructure Specialist', 'cv-sample23.pdf', TRUE, 9),
    ('Cloud Architecture Expert', 'cv-sample24.pdf', TRUE, 9),
    ('Digital Illustration Portfolio', 'cv-sample25.pdf', TRUE, 10),
    ('Character Design Specialist', 'cv-sample26.pdf', TRUE, 10);

INSERT INTO freelancer_skill (freelancer_id, skill_id)
VALUES
(8, 39), -- UI/UX Design
(8, 41), -- Figma
(8, 42), -- Sketch
(8, 40), -- Adobe Photoshop
(8, 43), -- Canva

(9, 34), -- Docker
(9, 35), -- Kubernetes
(9, 36), -- Jenkins
(9, 37), -- CI/CD Pipelines
(9, 32), -- AWS
(9, 33), -- Azure

(10, 40), -- Adobe Photoshop
(10, 41), -- Adobe Illustrator
(10, 43), -- Canva
(10, 44), -- Blender 3D
(10, 62); -- Animation

INSERT INTO projects (title, tech, description, link, image, freelancer_id)
VALUES
-- UI/UX Designer (ID: 8)
('E-commerce App Redesign', 'Figma, Adobe XD, Sketch', 'Thiết kế lại giao diện và trải nghiệm người dùng cho ứng dụng thương mại điện tử, tăng tỷ lệ chuyển đổi 40%.', 'https://behance.net/hanhpham/ecommerce-redesign', 'ecommerce-redesign.png', 8),
('Banking App UI Kit', 'Figma, Sketch, Principle', 'Bộ UI kit cho ứng dụng ngân hàng di động với hơn 200 components và 50 màn hình mẫu.', 'https://behance.net/hanhpham/banking-ui-kit', 'banking-ui-kit.png', 8),

-- DevOps Engineer (ID: 9)
('Microservices CI/CD Pipeline', 'Jenkins, Docker, Kubernetes, AWS', 'Xây dựng quy trình CI/CD tự động hóa hoàn toàn cho hệ thống microservices với zero-downtime deployment.', 'https://github.com/duyle/microservices-cicd', 'cicd-pipeline.png', 9),
('Cloud Infrastructure Automation', 'Terraform, AWS, Azure, Ansible', 'Tự động hóa việc triển khai hạ tầng đám mây đa nền tảng với Terraform và Ansible.', 'https://github.com/duyle/cloud-automation', 'cloud-automation.png', 9),

-- Digital Illustrator (ID: 10)
('Children Book Illustrations', 'Adobe Photoshop, Adobe Illustrator', 'Bộ minh họa cho sách truyện thiếu nhi "Cuộc phiêu lưu trong rừng", gồm 25 hình vẽ.', 'https://behance.net/maily/childrens-book', 'children-book.png', 10),
('Game Character Designs', 'Adobe Photoshop, Blender 3D', 'Thiết kế nhân vật cho game mobile RPG với 15 nhân vật chính và phụ.', 'https://behance.net/maily/game-characters', 'game-characters.png', 10);

INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id, image)
VALUES
    ('2014-09-01', '2018-06-30', 'Tốt nghiệp loại xuất sắc chuyên ngành Thiết kế Đồ họa.', 15, 1, 2, 8, null),
    ('2012-09-01', '2016-06-30', 'Chuyên ngành Khoa học Máy tính với chứng chỉ chuyên sâu về DevOps và Cloud Computing.', 1, 2, 1, 9, null),
    ('2015-09-01', '2019-06-30', 'Tốt nghiệp khoa Mỹ thuật Ứng dụng, chuyên ngành Minh họa Kỹ thuật số.', 14, 1, 2, 10, null);

INSERT INTO experiences (company_name, position, start_date, end_date, description, status, freelancer_id)
VALUES
-- UI/UX Designer (ID: 8)
('Design Innovation Studio', 'Junior UI Designer', '2018-07-01', '2020-06-30', 'Thiết kế giao diện người dùng cho các ứng dụng web và mobile, làm việc trong nhóm 5 designer.', true, 8),
('UX Solutions Agency', 'Senior UI/UX Designer', '2020-07-01', '2024-12-31', 'Dẫn dắt nhóm thiết kế UX/UI cho các dự án lớn, phối hợp với product manager và developer để tạo ra trải nghiệm người dùng tốt nhất.', true, 8),

-- DevOps Engineer (ID: 9)
('Tech Solutions Inc.', 'System Administrator', '2016-07-01', '2019-05-31', 'Quản trị hệ thống máy chủ, đảm bảo uptime và bảo mật cho hạ tầng CNTT của công ty.', true, 9),
('Cloud Partners', 'DevOps Engineer', '2019-06-01', '2022-12-31', 'Triển khai và quản lý hạ tầng đám mây trên AWS và Azure, xây dựng pipeline CI/CD cho các dự án phần mềm.', true, 9),
('Global Tech Corp', 'Senior DevOps Engineer', '2023-01-01', '2024-12-31', 'Thiết kế và triển khai kiến trúc microservices, tối ưu hóa quy trình phát triển và vận hành.', true, 9),

-- Digital Illustrator (ID: 10)
('Creative Publishing House', 'Illustrator', '2019-07-01', '2021-08-31', 'Minh họa cho sách thiếu nhi và tạp chí, tạo ra hơn 100 hình minh họa trong 2 năm.', true, 10),
('Game Art Studio', 'Digital Artist', '2021-09-01', '2024-12-31', 'Thiết kế nhân vật và môi trường cho game mobile và PC, làm việc với các studio game trong và ngoài nước.', true, 10);

INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
-- Client 7 (Thu Content Creation)
('Viết nội dung blog về công nghệ AI', 'MEDIUM', 25, 45, true, 5000000, 12000000, 'VNĐ', 'Cần freelancer viết 15 bài blog chuyên sâu về AI và Machine Learning, mỗi bài khoảng 1500-2000 từ, tối ưu SEO.', 'FULL', 'OPEN', NOW(), NULL, 7, 3, NOW() + INTERVAL 21 DAY),
('Copywriting cho landing page', 'SMALL', 10, 15, false, 3000000, 5000000, 'VNĐ', 'Cần copywriter có kinh nghiệm viết nội dung cho 5 landing page về các khóa học online, đảm bảo tỷ lệ chuyển đổi cao.', 'HOURLY', 'OPEN', NOW(), NULL, 7, 3, NOW() + INTERVAL 14 DAY),
('Biên tập sách kỹ năng', 'LARGE', 40, 60, true, 15000000, 25000000, 'VNĐ', 'Cần biên tập viên chuyên nghiệp cho cuốn sách kỹ năng mềm dài khoảng 200 trang, yêu cầu kinh nghiệm trong lĩnh vực xuất bản.', 'FULL', 'OPEN', NOW(), NULL, 7, 3, NOW() + INTERVAL 30 DAY),

-- Client 8 (GameVerse Studio)
('Thiết kế nhân vật game mobile', 'MEDIUM', 30, 45, true, 8000000, 20000000, 'VNĐ', 'Cần thiết kế 10 nhân vật cho game mobile thể loại RPG với phong cách anime, bao gồm concept art và các animation cơ bản.', 'FULL', 'OPEN', NOW(), NULL, 8, 2, NOW() + INTERVAL 21 DAY),
('Lập trình Unity game 2D', 'LARGE', 50, 75, true, 25000000, 50000000, 'VNĐ', 'Tuyển lập trình viên Unity có kinh nghiệm phát triển game 2D platformer, từ prototype đến hoàn thiện, bao gồm cả tích hợp IAP và Ads.', 'FULL', 'OPEN', NOW(), NULL, 8, 1, NOW() + INTERVAL 30 DAY),
('Sáng tác nhạc nền cho game', 'SMALL', 15, 30, false, 5000000, 12000000, 'VNĐ', 'Cần nhà soạn nhạc sáng tác 5-7 bản nhạc nền và các hiệu ứng âm thanh cho game mobile thể loại phiêu lưu.', 'HOURLY', 'OPEN', NOW(), NULL, 8, 9, NOW() + INTERVAL 14 DAY);

-- Thêm job_skill cho các job mới
INSERT INTO job_skill (job_id, skill_id)
VALUES
-- Viết nội dung blog về công nghệ AI
((SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'), 49), -- Copywriting
((SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'), 50), -- Content Writing
((SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'), 48), -- SEO Optimization
((SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'), 51), -- Blog Writing
((SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'), 28), -- Machine Learning

-- Copywriting cho landing page
((SELECT id FROM job WHERE title = 'Copywriting cho landing page'), 49), -- Copywriting
((SELECT id FROM job WHERE title = 'Copywriting cho landing page'), 48), -- SEO Optimization
((SELECT id FROM job WHERE title = 'Copywriting cho landing page'), 54), -- Email Marketing
((SELECT id FROM job WHERE title = 'Copywriting cho landing page'), 55), -- Social Media Marketing

-- Biên tập sách kỹ năng
((SELECT id FROM job WHERE title = 'Biên tập sách kỹ năng'), 50), -- Content Writing
((SELECT id FROM job WHERE title = 'Biên tập sách kỹ năng'), 84), -- Proofreading
((SELECT id FROM job WHERE title = 'Biên tập sách kỹ năng'), 85), -- Transcription
((SELECT id FROM job WHERE title = 'Biên tập sách kỹ năng'), 51), -- Blog Writing

-- Thiết kế nhân vật game mobile
((SELECT id FROM job WHERE title = 'Thiết kế nhân vật game mobile'), 40), -- Adobe Photoshop
((SELECT id FROM job WHERE title = 'Thiết kế nhân vật game mobile'), 41), -- Adobe Illustrator
((SELECT id FROM job WHERE title = 'Thiết kế nhân vật game mobile'), 62), -- Animation
((SELECT id FROM job WHERE title = 'Thiết kế nhân vật game mobile'), 64), -- 3D Modeling

-- Lập trình Unity game 2D
((SELECT id FROM job WHERE title = 'Lập trình Unity game 2D'), 13), -- C#
((SELECT id FROM job WHERE title = 'Lập trình Unity game 2D'), 25), -- Firebase
((SELECT id FROM job WHERE title = 'Lập trình Unity game 2D'), 62), -- Animation
((SELECT id FROM job WHERE title = 'Lập trình Unity game 2D'), 63), -- 3D Modeling

-- Sáng tác nhạc nền cho game
((SELECT id FROM job WHERE title = 'Sáng tác nhạc nền cho game'), 65), -- Music Production
((SELECT id FROM job WHERE title = 'Sáng tác nhạc nền cho game'), 66), -- Podcast Editing
((SELECT id FROM job WHERE title = 'Sáng tác nhạc nền cho game'), 59); -- Video Editing

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 2, true, 2, 7),
    (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 8),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 290000, 10, 8, false, 3, 7),
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 90000, 5, 5, false, 2, 8);

-- Thêm dữ liệu cho bảng freelancer_job
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 13, 7, id, NOW() - INTERVAL 2 DAY
FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 7 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'VIEWED', 13, 7, id, NOW() - INTERVAL 1 DAY
FROM job WHERE title = 'Copywriting cho landing page'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 7 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 25, 10, id, NOW() - INTERVAL 3 DAY
FROM job WHERE title = 'Thiết kế nhân vật game mobile'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 10 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 4, 2, id, NOW() - INTERVAL 1 DAY
FROM job WHERE title = 'Biên tập sách kỹ năng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 2 AND job_id = job.id);


-- Thêm đánh giá client và freelancer
INSERT INTO client_review (rating, note)
VALUES
    (4.9, 'Freelancer làm việc chuyên nghiệp, tuyệt vời trong giao tiếp và đáp ứng mọi yêu cầu.'),
    (4.7, 'Chất lượng thiết kế rất cao, sáng tạo và đúng theo yêu cầu. Sẽ hợp tác lần sau.'),
    (4.8, 'Kỹ năng kỹ thuật tốt, giải quyết vấn đề hiệu quả, đáp ứng deadline.'),
    (4.6, 'Minh họa rất đẹp và sáng tạo, đúng phong cách yêu cầu.');

INSERT INTO freelancer_review (rating, note)
VALUES
    (4.9, 'Client rất rõ ràng về yêu cầu, phản hồi nhanh chóng và thanh toán đúng hẹn.'),
    (4.8, 'Dự án thú vị, client hỗ trợ tốt trong quá trình làm việc.'),
    (4.7, 'Client chuyên nghiệp, yêu cầu rõ ràng và thanh toán đúng hạn.'),
    (4.6, 'Trải nghiệm hợp tác tuyệt vời, feedback xây dựng và rõ ràng.');

-- Thêm dữ liệu cho bảng appointments
INSERT INTO appointments (topic, start_time, duration, description, link, client_id, freelancer_job_id)
VALUES
    ('Phỏng vấn cho dự án thiết kế nhân vật game', NOW() + INTERVAL 2 DAY, 45, 'Thảo luận về phong cách thiết kế và timeline dự án', 'https://meet.example.com/game-character', 8,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 10 AND job_id = (SELECT id FROM job WHERE title = 'Thiết kế nhân vật game mobile'))),

    ('Thảo luận về nội dung blog AI', NOW() + INTERVAL 3 DAY, 60, 'Phỏng vấn và thảo luận về các chủ đề blog và đối tượng độc giả', 'https://meet.example.com/blog-content', 7,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 7 AND job_id = (SELECT id FROM job WHERE title = 'Viết nội dung blog về công nghệ AI'))),

    ('Trao đổi về landing page', NOW() + INTERVAL 1 DAY, 30, 'Thảo luận về các mẫu landing page và tone-and-manner', 'https://meet.example.com/landing-page', 7,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 7 AND job_id = (SELECT id FROM job WHERE title = 'Copywriting cho landing page'))),

    ('Phỏng vấn biên tập sách', NOW() + INTERVAL 4 DAY, 60, 'Thảo luận về kinh nghiệm biên tập và quy trình làm việc', 'https://meet.example.com/book-editing', 7,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 2 AND job_id = (SELECT id FROM job WHERE title = 'Biên tập sách kỹ năng')));

-- Thêm tin nhắn chat
INSERT INTO chat_messages (sender_id, receiver_id, content, sent_at, is_read)
VALUES
-- Thu Nguyễn (client) với Hiếu Nguyễn (freelancer)
(18, 15, 'Chào anh Hiếu, tôi đã xem profile của anh và thấy rất phù hợp với dự án blog về AI của chúng tôi.', NOW() - INTERVAL 5 DAY, true),
(15, 18, 'Chào chị Thu, cảm ơn chị đã quan tâm. Tôi rất hứng thú với dự án này và có kinh nghiệm viết về AI.', NOW() - INTERVAL 5 DAY, true),
(18, 15, 'Tuyệt vời! Anh có thể chia sẻ một số mẫu bài viết trước đây về chủ đề tương tự không?', NOW() - INTERVAL 4 DAY, true),
(15, 18, 'Dạ, tôi sẽ gửi cho chị portfolio của tôi qua email. Chị có thể cho tôi biết thêm về đối tượng độc giả mục tiêu không?', NOW() - INTERVAL 4 DAY, true),
(18, 15, 'Đối tượng của chúng tôi là các chuyên gia công nghệ và người dùng quan tâm đến AI ứng dụng trong doanh nghiệp.', NOW() - INTERVAL 3 DAY, true),
(15, 18, 'Tôi hiểu rồi. Tôi có kinh nghiệm viết cho đối tượng này. Chúng ta có thể sắp xếp một cuộc họp để thảo luận chi tiết hơn không?', NOW() - INTERVAL 3 DAY, true),
(18, 15, 'Được, chúng ta có thể họp vào thứ 5 tuần này lúc 10h sáng. Anh thấy thế nào?', NOW() - INTERVAL 2 DAY, true),
(15, 18, 'Thời gian đó phù hợp với tôi. Tôi sẽ chuẩn bị một số ý tưởng cho các bài viết. Cảm ơn chị!', NOW() - INTERVAL 2 DAY, false),

-- Bảo Trần (client) với Mai Lý (freelancer)
(19, 20, 'Chào Mai Lý, tôi rất ấn tượng với portfolio thiết kế nhân vật của bạn. Đang có một dự án game RPG cần thiết kế nhân vật.', NOW() - INTERVAL 7 DAY, true),
(20, 19, 'Chào anh Bảo, cảm ơn anh đã liên hệ. Em rất vui khi anh thích portfolio của em. Anh có thể chia sẻ thêm về phong cách game không?', NOW() - INTERVAL 7 DAY, true),
(19, 20, 'Game của chúng tôi có phong cách anime Nhật Bản, nhưng hiện đại hơn. Chúng tôi cần 10 nhân vật với đầy đủ biểu cảm và pose.', NOW() - INTERVAL 6 DAY, true),
(20, 19, 'Em hiểu rồi. Em có nhiều kinh nghiệm với phong cách này. Anh có concept sẵn cho các nhân vật hay em sẽ thiết kế từ đầu?', NOW() - INTERVAL 6 DAY, true),
(19, 20, 'Chúng tôi có concept cơ bản về tính cách và vai trò, nhưng cần bạn thiết kế hình dáng và tạo hình chi tiết.', NOW() - INTERVAL 5 DAY, true),
(20, 19, 'Vâng, em có thể làm việc từ concept đó. Anh có thể chia sẻ tài liệu qua email không? Và anh cần thời gian hoàn thành là bao lâu?', NOW() - INTERVAL 5 DAY, true),
(19, 20, 'Tôi sẽ gửi tài liệu ngay hôm nay. Dự kiến chúng tôi cần trong vòng 6 tuần. Bạn có thể đáp ứng được không?', NOW() - INTERVAL 4 DAY, true),
(20, 19, 'Dạ, em có thể hoàn thành trong 6 tuần. Em sẽ gửi báo giá chi tiết sau khi xem tài liệu. Cảm ơn anh đã quan tâm!', NOW() - INTERVAL 4 DAY, false),

-- Hạnh Phạm (freelancer) với Bảo Trần (client)
(16, 19, 'Chào anh Bảo, tôi là Hạnh - UI/UX Designer. Tôi thấy công ty anh đang cần người thiết kế giao diện cho game.', NOW() - INTERVAL 3 DAY, true),
(19, 16, 'Chào Hạnh, cảm ơn vì đã liên hệ. Đúng vậy, chúng tôi đang cần một UI/UX designer cho game mobile.', NOW() - INTERVAL 3 DAY, true),
(16, 19, 'Tôi có nhiều kinh nghiệm thiết kế UI cho game mobile. Anh có thể cho tôi biết thêm về yêu cầu cụ thể không?', NOW() - INTERVAL 2 DAY, true),
(19, 16, 'Chúng tôi cần thiết kế UI cho game RPG, bao gồm menu chính, inventory, battle screen và các popup khác nhau.', NOW() - INTERVAL 2 DAY, true),
(16, 19, 'Tôi hiểu rồi. Tôi đã từng làm UI cho nhiều game RPG trước đây. Tôi có thể gửi cho anh portfolio với các dự án tương tự.', NOW() - INTERVAL 1 DAY, true),
(19, 16, 'Tuyệt vời! Hãy gửi portfolio của bạn qua email. Nếu phù hợp, chúng tôi sẽ mời bạn phỏng vấn.', NOW() - INTERVAL 1 DAY, false);

-- Thêm người dùng mới
INSERT INTO account (email, password, role, created_at, updated_at, status, lat, lng)
VALUES
    ('tuannv123@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 10.762622, 106.660172),
    ('minhnq456@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 10.853954, 106.627283),
    ('linhdt789@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, 16.054407, 108.202164),
    ('phuongnt567@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, 21.027763, 105.834160),
    ('hientt890@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 10.823099, 106.629662);

-- Thêm thông tin người dùng
INSERT INTO users (first_name, last_name, phone_number, province, country, title, introduction, image, account_id)
VALUES
    ('Tuấn', 'Nguyễn Văn', '0901234567', 'Hồ Chí Minh', 'Việt Nam', 'Full-stack Developer', 'Chuyên gia phát triển ứng dụng web với 8 năm kinh nghiệm, sử dụng MERN stack và .NET Core.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user1.jpg', 21),
    ('Minh', 'Nguyễn Quang', '0912345678', 'Hồ Chí Minh', 'Việt Nam', 'AI Engineer', 'Kỹ sư AI với nền tảng vững chắc về Machine Learning và Deep Learning, 5 năm kinh nghiệm.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user2.jpg', 22),
    ('Linh', 'Đặng Thị', '0923456789', 'Đà Nẵng', 'Việt Nam', 'Marketing Director', 'Giám đốc Marketing với hơn 10 năm kinh nghiệm trong lĩnh vực thương mại điện tử và bán lẻ.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user3.jpg', 23),
    ('Phương', 'Nguyễn Thanh', '0934567890', 'Hà Nội', 'Việt Nam', 'Product Manager', 'Quản lý sản phẩm với chuyên môn về các ứng dụng di động và phân tích người dùng.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user4.jpg', 24),
    ('Hiền', 'Trần Thị', '0945678901', 'Hồ Chí Minh', 'Việt Nam', 'UX Researcher', 'Chuyên gia nghiên cứu trải nghiệm người dùng với 6 năm kinh nghiệm, chuyên về thiết kế lấy người dùng làm trung tâm.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user5.jpg', 25);

-- Thêm freelancer
INSERT INTO freelancer (hourly_rate, description, category_id, user_id)
VALUES
    (30.00, 'Full-stack Developer với 8 năm kinh nghiệm phát triển web và mobile, thành thạo MERN stack, .NET Core và microservices architecture.', 1, 21),
    (35.00, 'AI Engineer chuyên về phát triển các giải pháp Machine Learning và Deep Learning cho nhiều lĩnh vực khác nhau từ fintech đến y tế.', 1, 22),
    (28.00, 'UX Researcher với kinh nghiệm thiết kế tập trung vào người dùng, thành thạo các phương pháp nghiên cứu định tính và định lượng.', 2, 25);

-- Thêm client
INSERT INTO client (from_price, to_price, type_price, user_id)
VALUES
    (3000000, 10000000, 'VNĐ', 23),
    (5000000, 15000000, 'VNĐ', 24);

-- Thêm company
INSERT INTO company (company_name, phone_contact, address, industry, client_id)
VALUES
    ('VIDA Digital', '0923456789', 'Đà Nẵng', 'E-commerce & Digital Marketing', 9),
    ('TechFlow Solutions', '0934567890', 'Hà Nội', 'Software Development & IT Services', 10);

-- Thêm CV cho freelancer
INSERT INTO cv (title, url, status, freelancer_id)
VALUES
    ('Senior Full-stack Developer', 'cv-sample26.pdf', TRUE, 11),
    ('JavaScript & React Expert', 'cv-sample27.pdf', TRUE, 11),
    ('AI & Machine Learning Specialist', 'cv-sample28.pdf', TRUE, 12),
    ('NLP & Computer Vision Expert', 'cv-sample29.pdf', TRUE, 12),
    ('UX Design & Research Portfolio', 'cv-sample30.pdf', TRUE, 13),
    ('User Research Specialist', 'cv-sample31.pdf', TRUE, 13);

-- Thêm kỹ năng cho freelancer
INSERT INTO freelancer_skill (freelancer_id, skill_id)
VALUES
-- Full-stack Developer (ID: 11)
(11, 1),  -- Java
(11, 3),  -- ReactJS
(11, 6),  -- Node.js
(11, 7),  -- Express.js
(11, 14), -- C#
(11, 15), -- .NET Core
(11, 21), -- SQL
(11, 25), -- Firebase
(11, 34), -- Docker
(11, 35), -- Kubernetes

-- AI Engineer (ID: 12)
(12, 8),  -- Python
(12, 26), -- Data Analysis
(12, 27), -- Data Science
(12, 28), -- Machine Learning
(12, 29), -- Deep Learning
(12, 30), -- TensorFlow
(12, 31), -- PyTorch
(12, 32), -- AWS
(12, 33), -- Azure
(12, 21), -- SQL

-- UX Researcher (ID: 13)
(13, 39), -- UI/UX Design
(13, 41), -- Figma
(13, 42), -- Sketch
(13, 26), -- Data Analysis
(13, 69), -- Virtual Assistant
(13, 70); -- Project Management

-- Thêm dự án cho freelancer
INSERT INTO projects (title, tech, description, link, image, freelancer_id)
VALUES
-- Full-stack Developer (ID: 11)
('E-commerce Platform', 'React, Node.js, MongoDB, AWS', 'Nền tảng thương mại điện tử đa kênh với khả năng quản lý sản phẩm, đơn hàng và thanh toán trực tuyến.', 'https://github.com/tuannv/ecommerce-platform', 'ecommerce-platform.png', 11),
('HR Management System', '.NET Core, SQL Server, Azure', 'Hệ thống quản lý nhân sự toàn diện với các tính năng theo dõi hiệu suất, quản lý phân quyền và tích hợp báo cáo.', 'https://github.com/tuannv/hr-management', 'hr-management.png', 11),

-- AI Engineer (ID: 12)
('Fraud Detection System', 'Python, TensorFlow, AWS SageMaker', 'Hệ thống phát hiện gian lận cho ngân hàng, sử dụng mô hình học máy với độ chính xác 97%.', 'https://github.com/minhnq/fraud-detection', 'fraud-detection.png', 12),
('Medical Image Diagnosis', 'Python, PyTorch, Computer Vision', 'Giải pháp chẩn đoán hình ảnh y tế tự động sử dụng Deep Learning, hỗ trợ phát hiện bệnh từ X-quang.', 'https://github.com/minhnq/medical-imaging', 'medical-imaging.png', 12),

-- UX Researcher (ID: 13)
('Banking App Redesign', 'Figma, User Research, Wireframing', 'Nghiên cứu và thiết kế lại trải nghiệm người dùng cho ứng dụng ngân hàng, tăng 40% tỷ lệ chuyển đổi.', 'https://behance.net/hientt/banking-app', 'banking-app.png', 13),
('E-learning Platform UX', 'Sketch, User Testing, Prototyping', 'Nghiên cứu và thiết kế trải nghiệm người dùng cho nền tảng học trực tuyến, tối ưu hóa quá trình học tập.', 'https://behance.net/hientt/elearning', 'elearning-platform.png', 13);

-- Thêm giáo dục cho freelancer
INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id, image)
VALUES
    ('2011-09-01', '2015-06-30', 'Tốt nghiệp chuyên ngành Khoa học Máy tính với chứng chỉ xuất sắc về phát triển phần mềm.', 1, 2, 1, 11, null),
    ('2013-09-01', '2017-06-30', 'Tốt nghiệp ngành Khoa học Dữ liệu và Trí tuệ Nhân tạo, đạt giải nhất cuộc thi AI Challenge.', 4, 2, 1, 12, null),
    ('2012-09-01', '2016-06-30', 'Tốt nghiệp ngành Thiết kế Đồ họa và Truyền thông Kỹ thuật số, chuyên về UX/UI.', 15, 1, 2, 13, null);

-- Thêm kinh nghiệm làm việc cho freelancer
INSERT INTO experiences (company_name, position, start_date, end_date, description, status, freelancer_id)
VALUES
-- Full-stack Developer (ID: 11)
('TechVision Inc.', 'Junior Developer', '2015-07-01', '2017-12-31', 'Phát triển các ứng dụng web sử dụng PHP, MySQL và JavaScript. Tham gia vào các dự án phát triển CMS cho khách hàng doanh nghiệp.', true, 11),
('GlobalSoft Solutions', 'Software Engineer', '2018-01-01', '2020-06-30', 'Phát triển ứng dụng doanh nghiệp với .NET Core và Angular. Thiết kế và triển khai kiến trúc microservices cho các hệ thống quy mô lớn.', true, 11),
('Innovate Technologies', 'Senior Full-stack Developer', '2020-07-01', '2024-12-31', 'Dẫn dắt nhóm phát triển ứng dụng web và mobile sử dụng React, Node.js và React Native. Tối ưu hóa hiệu suất và triển khai CI/CD.', true, 11),

-- AI Engineer (ID: 12)
('DataSense Analytics', 'Data Scientist', '2017-07-01', '2019-08-31', 'Phân tích dữ liệu và phát triển mô hình dự đoán cho các khách hàng tài chính và bán lẻ. Sử dụng scikit-learn và TensorFlow.', true, 12),
('AI Solutions Co.', 'Machine Learning Engineer', '2019-09-01', '2022-12-31', 'Phát triển và triển khai các mô hình học máy cho các ứng dụng thực tế. Tối ưu hóa hiệu suất mô hình và xây dựng pipeline ML.', true, 12),
('FutureTech Labs', 'Senior AI Engineer', '2023-01-01', '2024-12-31', 'Lãnh đạo nhóm AI nghiên cứu và phát triển các giải pháp học sâu cho các vấn đề thị giác máy tính và xử lý ngôn ngữ tự nhiên.', true, 12),

-- UX Researcher (ID: 13)
('DesignFirst Agency', 'UI/UX Designer', '2016-07-01', '2018-06-30', 'Thiết kế giao diện người dùng và trải nghiệm cho các ứng dụng web và di động. Thực hiện nghiên cứu người dùng cơ bản.', true, 13),
('UserCentric Design', 'Senior UX Designer', '2018-07-01', '2021-12-31', 'Dẫn dắt quá trình thiết kế UX cho các dự án lớn, thực hiện nghiên cứu người dùng và phát triển user personas và hành trình người dùng.', true, 13),
('Innovation Lab', 'UX Research Lead', '2022-01-01', '2024-12-31', 'Lãnh đạo nhóm nghiên cứu UX, xây dựng phương pháp nghiên cứu, thực hiện nghiên cứu định tính và định lượng về trải nghiệm người dùng.', true, 13);

-- Thêm công việc mới
INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
-- Client 9 (VIDA Digital - Digital Marketing)
('Xây dựng chiến lược SEO toàn diện', 'LARGE', 60, 90, true, 20000000, 35000000, 'VNĐ', 'Cần chuyên gia SEO xây dựng chiến lược toàn diện cho trang thương mại điện tử, bao gồm nghiên cứu từ khóa, tối ưu on-page và off-page, link building và theo dõi KPI.', 'FULL', 'OPEN', NOW(), NULL, 9, 4, NOW() + INTERVAL 30 DAY),
('Thiết kế UX/UI cho ứng dụng di động thương mại điện tử', 'MEDIUM', 40, 60, true, 15000000, 25000000, 'VNĐ', 'Tìm chuyên gia UX/UI thiết kế giao diện người dùng cho ứng dụng di động thương mại điện tử, tập trung vào tối ưu hóa trải nghiệm mua sắm và thanh toán.', 'FULL', 'OPEN', NOW(), NULL, 9, 2, NOW() + INTERVAL 21 DAY),
('Phát triển chatbot hỗ trợ khách hàng', 'MEDIUM', 35, 50, false, 12000000, 20000000, 'VNĐ', 'Cần xây dựng chatbot thông minh tích hợp vào website và ứng dụng di động, có khả năng trả lời câu hỏi thường gặp, hỗ trợ đặt hàng, và chuyển tiếp đến nhân viên khi cần.', 'HOURLY', 'OPEN', NOW(), NULL, 9, 1, NOW() + INTERVAL 14 DAY),

-- Client 10 (TechFlow Solutions - IT Services)
('Xây dựng hệ thống quản lý dự án nội bộ', 'LARGE', 80, 120, true, 30000000, 50000000, 'VNĐ', 'Cần phát triển hệ thống quản lý dự án nội bộ toàn diện, bao gồm theo dõi tiến độ, quản lý tài nguyên, báo cáo thời gian, và tích hợp với các công cụ khác như Slack và Google Calendar.', 'FULL', 'OPEN', NOW(), NULL, 10, 1, NOW() + INTERVAL 30 DAY),
('Phát triển hệ thống phân tích dữ liệu khách hàng', 'LARGE', 70, 90, true, 25000000, 45000000, 'VNĐ', 'Cần xây dựng hệ thống phân tích dữ liệu khách hàng sử dụng Machine Learning để dự đoán hành vi, phân khúc khách hàng, và đề xuất các chiến lược tiếp thị phù hợp.', 'FULL', 'OPEN', NOW(), NULL, 10, 7, NOW() + INTERVAL 25 DAY),
('Kiểm thử bảo mật và đánh giá lỗ hổng', 'MEDIUM', 40, 60, false, 18000000, 30000000, 'VNĐ', 'Tìm chuyên gia bảo mật thực hiện đánh giá toàn diện về hệ thống, tìm kiếm lỗ hổng, thực hiện kiểm thử xâm nhập, và đề xuất các biện pháp khắc phục để bảo vệ dữ liệu.', 'HOURLY', 'OPEN', NOW(), NULL, 10, 1, NOW() + INTERVAL 14 DAY);

-- Thêm kỹ năng cho các công việc mới
INSERT INTO job_skill (job_id, skill_id)
VALUES
-- Xây dựng chiến lược SEO toàn diện
((SELECT id FROM job WHERE title = 'Xây dựng chiến lược SEO toàn diện'), 48), -- SEO Optimization
((SELECT id FROM job WHERE title = 'Xây dựng chiến lược SEO toàn diện'), 49), -- Copywriting
((SELECT id FROM job WHERE title = 'Xây dựng chiến lược SEO toàn diện'), 50), -- Content Writing
((SELECT id FROM job WHERE title = 'Xây dựng chiến lược SEO toàn diện'), 26), -- Data Analysis

-- Thiết kế UX/UI cho ứng dụng di động thương mại điện tử
((SELECT id FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'), 39), -- UI/UX Design
((SELECT id FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'), 41), -- Figma
((SELECT id FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'), 42), -- Sketch
((SELECT id FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'), 40), -- Adobe Photoshop

-- Phát triển chatbot hỗ trợ khách hàng
((SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'), 6),  -- Node.js
((SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'), 8),  -- Python
((SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'), 28), -- Machine Learning
((SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'), 29), -- Deep Learning
((SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'), 25), -- Firebase

-- Xây dựng hệ thống quản lý dự án nội bộ
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 1),  -- Java
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 2),  -- Spring Boot
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 3),  -- ReactJS
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 21), -- SQL
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 34), -- Docker
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'), 35), -- Kubernetes

-- Phát triển hệ thống phân tích dữ liệu khách hàng
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 8),  -- Python
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 26), -- Data Analysis
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 27), -- Data Science
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 28), -- Machine Learning
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 30), -- TensorFlow
((SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'), 31), -- PyTorch

-- Kiểm thử bảo mật và đánh giá lỗ hổng
((SELECT id FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'), 14), -- C#
((SELECT id FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'), 16), -- C++
((SELECT id FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'), 8),  -- Python
((SELECT id FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'), 32), -- AWS
((SELECT id FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'), 33); -- Azure

-- Thêm đánh giá client và freelancer
INSERT INTO client_review (rating, note)
VALUES
    (4.9, 'Freelancer có kỹ năng kỹ thuật xuất sắc, giải quyết vấn đề phức tạp rất hiệu quả.'),
    (4.8, 'Làm việc chuyên nghiệp, giao tiếp rõ ràng và đáp ứng mọi yêu cầu kỹ thuật.'),
    (4.7, 'Hiểu rõ yêu cầu và đề xuất giải pháp tối ưu, chủ động cập nhật tiến độ.'),
    (4.6, 'Kỹ thuật tốt, làm việc đúng deadline, phản hồi nhanh khi có thắc mắc.'),
    (4.5, 'Tích cực đề xuất các cải tiến, chất lượng công việc cao.');

INSERT INTO freelancer_review (rating, note)
VALUES
    (4.9, 'Client rất rõ ràng về mục tiêu dự án, cung cấp tài liệu đầy đủ và phản hồi nhanh chóng.'),
    (4.8, 'Giao tiếp chuyên nghiệp, yêu cầu hợp lý và thanh toán đúng hạn.'),
    (4.7, 'Dự án thú vị, client hỗ trợ tốt và tạo điều kiện để hoàn thành công việc.'),
    (4.6, 'Quy trình làm việc hiệu quả, feedback xây dựng và tôn trọng chuyên môn.'),
    (4.5, 'Client chuyên nghiệp, yêu cầu rõ ràng và có tầm nhìn tốt về sản phẩm.');

-- Thêm dữ liệu cho bảng freelancer_job
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 13, 5, id, NOW() - INTERVAL 3 DAY, NULL, NULL
FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 5 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 26, 11, id, NOW() - INTERVAL 2 DAY, NULL, NULL
FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 11 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'VIEWED', 27, 11, id, NOW() - INTERVAL 3 DAY, NULL, NULL
FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 11 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 28, 12, id, NOW() - INTERVAL 4 DAY, NULL, NULL
FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 12 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 29, 12, id, NOW() - INTERVAL 3 DAY, NULL, NULL
FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 12 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date, freelancer_review_id, client_review_id)
SELECT false, 'APPLIED', 30, 13, id, NOW() - INTERVAL 2 DAY, NULL, NULL
FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 13 AND job_id = job.id);

-- Thêm dữ liệu cho bảng sold_packages
INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 290000, 10, 3, true, 3, 9),
    (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 10),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 290000, 10, 8, false, 3, 9),
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 90000, 5, 5, false, 2, 10);

-- Thêm thông báo
INSERT INTO notification (message, user_id, is_read, url, created_at)
VALUES
    ('Ứng viên mới đã ứng tuyển vào công việc "Xây dựng hệ thống quản lý dự án nội bộ"', 24, false, '/jobs/details', NOW() - INTERVAL 2 DAY),
    ('Bạn đã được chọn cho cuộc phỏng vấn công việc "Phát triển hệ thống phân tích dữ liệu khách hàng"', 22, false, '/interview/details', NOW() - INTERVAL 1 DAY),
    ('Gói dịch vụ của bạn sẽ hết hạn trong 3 ngày', 23, false, '/packages', NOW()),
    ('Ứng viên mới đã ứng tuyển vào công việc "Thiết kế UX/UI cho ứng dụng di động thương mại điện tử"', 23, true, '/jobs/details', NOW() - INTERVAL 2 DAY),
    ('Công việc mới phù hợp với kỹ năng của bạn đã được đăng tải', 21, false, '/jobs/matching', NOW() - INTERVAL 1 DAY),
    ('Đánh giá mới từ khách hàng về dự án đã hoàn thành', 22, true, '/reviews', NOW() - INTERVAL 3 DAY),
    ('Thanh toán cho dự án "E-commerce Platform" đã được xử lý', 21, false, '/payments', NOW()),
    ('Cuộc phỏng vấn với "TechFlow Solutions" đã được xác nhận', 25, false, '/interview/schedule', NOW() - INTERVAL 1 DAY),
    ('Bạn có thông báo mới từ hệ thống hỗ trợ', 24, true, '/support', NOW() - INTERVAL 2 DAY),
    ('Cập nhật chính sách thanh toán mới', 23, false, '/policy', NOW() - INTERVAL 5 DAY);

-- Thêm dữ liệu cho bảng Payment
INSERT INTO payment (balance, created_at, updated_at, account_id)
VALUES
    (1500000.00, NOW() - INTERVAL 60 DAY, NOW() - INTERVAL 1 DAY, 1),
    (2300000.00, NOW() - INTERVAL 90 DAY, NOW() - INTERVAL 2 DAY, 2),
    (0.00, NOW() - INTERVAL 45 DAY, NOW() - INTERVAL 3 DAY, 3),
    (5000000.00, NOW() - INTERVAL 30 DAY, NOW() - INTERVAL 1 DAY, 4),
    (3500000.00, NOW() - INTERVAL 75 DAY, NOW() - INTERVAL 5 DAY, 5),
    (1200000.00, NOW() - INTERVAL 60 DAY, NOW() - INTERVAL 2 DAY, 6),
    (800000.00, NOW() - INTERVAL 45 DAY, NOW() - INTERVAL 7 DAY, 7),
    (2100000.00, NOW() - INTERVAL 80 DAY, NOW() - INTERVAL 3 DAY, 8),
    (0.00, NOW() - INTERVAL 65 DAY, NOW() - INTERVAL 1 DAY, 9),
    (3000000.00, NOW() - INTERVAL 70 DAY, NOW() - INTERVAL 4 DAY, 10),
    (2700000.00, NOW() - INTERVAL 55 DAY, NOW() - INTERVAL 2 DAY, 11),
    (0.00, NOW() - INTERVAL 40 DAY, NOW() - INTERVAL 1 DAY, 12),
    (1800000.00, NOW() - INTERVAL 85 DAY, NOW() - INTERVAL 6 DAY, 13),
    (0.00, NOW() - INTERVAL 50 DAY, NOW() - INTERVAL 3 DAY, 14),
    (4200000.00, NOW() - INTERVAL 75 DAY, NOW() - INTERVAL 2 DAY, 15),
    (1500000.00, NOW() - INTERVAL 30 DAY, NOW() - INTERVAL 1 DAY, 16),
    (2800000.00, NOW() - INTERVAL 60 DAY, NOW() - INTERVAL 5 DAY, 17),
    (0.00, NOW() - INTERVAL 45 DAY, NOW() - INTERVAL 2 DAY, 18),
    (0.00, NOW() - INTERVAL 70 DAY, NOW() - INTERVAL 3 DAY, 19),
    (3200000.00, NOW() - INTERVAL 55 DAY, NOW() - INTERVAL 1 DAY, 20),
    (5500000.00, NOW() - INTERVAL 40 DAY, NOW() - INTERVAL 2 DAY, 21),
    (4800000.00, NOW() - INTERVAL 65 DAY, NOW() - INTERVAL 4 DAY, 22),
    (0.00, NOW() - INTERVAL 50 DAY, NOW() - INTERVAL 3 DAY, 23),
    (0.00, NOW() - INTERVAL 75 DAY, NOW() - INTERVAL 1 DAY, 24),
    (2900000.00, NOW() - INTERVAL 35 DAY, NOW() - INTERVAL 2 DAY, 25);

-- Thêm giao dịch cho client mua gói dịch vụ
INSERT INTO transactions (money, activity, created_at, description, status, payment_id)
VALUES
    -- Client ID 1 (Quang Bùi - User ID 3) - Gói Vàng
    (290000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 3)),

    -- Client ID 1 (Quang Bùi) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 3)),
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 1 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 3)),

    -- Client ID 2 (Huy Đinh - User ID 5) - Gói Bạc
    (90000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 5)),

    -- Client ID 2 (Huy Đinh) - Lịch sử gói đã hết hạn
    (0.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Thường', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 5)),
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 5)),

    -- Client ID 3 (Minh Thành - User ID 7) - Gói Kim Cương
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Kim Cương', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 7)),

    -- Client ID 3 (Minh Thành) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 7)),
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 7)),

    -- Client ID 4 (Thành Sơn - User ID 10) - Gói Bạc
    (90000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 10)),

    -- Client ID 4 (Thành Sơn) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 10)),
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 1 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 10)),

    -- Client ID 5 (Hoàng Long - User ID 12) - Gói Kim Cương
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Kim Cương', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 12)),

    -- Client ID 5 (Hoàng Long) - Lịch sử gói đã hết hạn
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 12)),
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 12)),

    -- Client ID 6 (Minh Triết - User ID 14) - Gói Bạc
    (90000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 14)),

    -- Client ID 6 (Minh Triết) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 14)),
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 1 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 14)),

    -- Client ID 7 (Thu Nguyễn - User ID 18) - Gói Bạc
    (90000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 18)),

    -- Client ID 7 (Thu Nguyễn) - Lịch sử gói đã hết hạn
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 18)),

    -- Client ID 8 (Bảo Trần - User ID 19) - Gói Kim Cương
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Kim Cương', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 19)),

    -- Client ID 8 (Bảo Trần) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 19)),

    -- Client ID 9 (Linh Đặng - User ID 23) - Gói Vàng
    (290000.00, 'WITHDRAW', NOW() - INTERVAL 14 DAY, 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 23)),

    -- Client ID 9 (Linh Đặng) - Lịch sử gói đã hết hạn
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 23)),

    -- Client ID 10 (Phương Nguyễn - User ID 24) - Gói Kim Cương
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Kim Cương', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 24)),

    -- Client ID 10 (Phương Nguyễn) - Lịch sử gói đã hết hạn
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 24));

-- Thêm giao dịch nạp tiền cho client
INSERT INTO transactions (money, activity, created_at, description, status, payment_id)
VALUES
    -- Client ID 1 (Quang Bùi - User ID 3)
    (1000000.00, 'DEPOSIT', NOW() - INTERVAL 20 DAY, 'Nạp tiền qua ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 3)),

    -- Client ID 2 (Huy Đinh - User ID 5)
    (500000.00, 'DEPOSIT', NOW() - INTERVAL 25 DAY, 'Nạp tiền qua VNPay', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 5)),

    -- Client ID 3 (Minh Thành - User ID 7)
    (1500000.00, 'DEPOSIT', NOW() - INTERVAL 35 DAY, 'Nạp tiền qua Momo', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 7)),

    -- Client ID 4 (Thành Sơn - User ID 10)
    (800000.00, 'DEPOSIT', NOW() - INTERVAL 18 DAY, 'Nạp tiền qua ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 10)),

    -- Client ID 5 (Hoàng Long - User ID 12)
    (2000000.00, 'DEPOSIT', NOW() - INTERVAL 40 DAY, 'Nạp tiền qua VNPay', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 12)),

    -- Client ID 6 (Minh Triết - User ID 14)
    (500000.00, 'DEPOSIT', NOW() - INTERVAL 20 DAY, 'Nạp tiền qua Momo', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 14)),

    -- Client ID 7 (Thu Nguyễn - User ID 18)
    (1000000.00, 'DEPOSIT', NOW() - INTERVAL 18 DAY, 'Nạp tiền qua ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 18)),

    -- Client ID 8 (Bảo Trần - User ID 19)
    (1500000.00, 'DEPOSIT', NOW() - INTERVAL 35 DAY, 'Nạp tiền qua VNPay', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 19)),

    -- Client ID 9 (Linh Đặng - User ID 23)
    (1000000.00, 'DEPOSIT', NOW() - INTERVAL 20 DAY, 'Nạp tiền qua Momo', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 23)),

    -- Client ID 10 (Phương Nguyễn - User ID 24)
    (2000000.00, 'DEPOSIT', NOW() - INTERVAL 32 DAY, 'Nạp tiền qua ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 24));

-- Thêm một số giao dịch thanh toán đang chờ xử lý
INSERT INTO transactions (money, activity, created_at, description, status, payment_id)
VALUES
    (290000.00, 'WITHDRAW', NOW() - INTERVAL 1 DAY, 'Đăng ký gói Vàng', 'PENDING',
     (SELECT id FROM payment WHERE account_id = 5)),
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 2 DAY, 'Đăng ký gói Kim Cương', 'PENDING',
     (SELECT id FROM payment WHERE account_id = 14)),
    (500000.00, 'DEPOSIT', NOW() - INTERVAL 1 DAY, 'Nạp tiền qua VNPay', 'PENDING',
     (SELECT id FROM payment WHERE account_id = 18));

-- Thêm dữ liệu cho appointments (cuộc hẹn phỏng vấn)
INSERT INTO appointments (topic, start_time, duration, description, link, client_id, freelancer_job_id)
VALUES
    ('Phỏng vấn dự án Phân tích dữ liệu khách hàng', NOW() + INTERVAL 5 DAY, 60, 'Thảo luận về yêu cầu kỹ thuật và kinh nghiệm với ML/AI', 'https://meet.example.com/data-analysis', 10,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 12 AND job_id = (SELECT id FROM job WHERE title = 'Phát triển hệ thống phân tích dữ liệu khách hàng'))),

    ('Trao đổi về UX/UI cho ứng dụng thương mại điện tử', NOW() + INTERVAL 3 DAY, 45, 'Phỏng vấn và thảo luận về portfolio, phong cách thiết kế', 'https://meet.example.com/ux-ecommerce', 9,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 13 AND job_id = (SELECT id FROM job WHERE title = 'Thiết kế UX/UI cho ứng dụng di động thương mại điện tử'))),

    ('Thảo luận dự án Chatbot', NOW() + INTERVAL 2 DAY, 60, 'Phỏng vấn về kinh nghiệm phát triển chatbot và công nghệ NLP', 'https://meet.example.com/chatbot', 9,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 12 AND job_id = (SELECT id FROM job WHERE title = 'Phát triển chatbot hỗ trợ khách hàng'))),

    ('Phỏng vấn dự án hệ thống quản lý', NOW() + INTERVAL 4 DAY, 90, 'Thảo luận chi tiết về kinh nghiệm full-stack và microservices', 'https://meet.example.com/management-system', 10,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 11 AND job_id = (SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý dự án nội bộ')));

-- Thêm tin nhắn chat mới
INSERT INTO chat_messages (sender_id, receiver_id, content, sent_at, is_read)
VALUES
-- Linh (client) với Tuấn (freelancer)
(23, 21, 'Chào anh Tuấn, tôi đã xem qua hồ sơ của anh và rất ấn tượng với các dự án full-stack anh đã thực hiện.', NOW() - INTERVAL 5 DAY, true),
(21, 23, 'Chào chị Linh, cảm ơn chị đã liên hệ. Tôi rất vui khi chị quan tâm đến kinh nghiệm của tôi.', NOW() - INTERVAL 5 DAY, true),
(23, 21, 'Công ty chúng tôi đang cần một hệ thống quản lý nội dung cho website thương mại điện tử. Anh đã từng làm dự án tương tự chưa?', NOW() - INTERVAL 4 DAY, true),
(21, 23, 'Vâng, tôi đã phát triển 3 hệ thống CMS cho các website TMĐT, sử dụng React/Node.js và cả .NET Core. Chị có yêu cầu cụ thể về công nghệ không?', NOW() - INTERVAL 4 DAY, true),
(23, 21, 'Chúng tôi ưu tiên sử dụng MERN stack vì đội ngũ hiện tại đang quen thuộc với công nghệ này. Anh có thể gửi portfolio chi tiết hơn được không?', NOW() - INTERVAL 3 DAY, true),
(21, 23, 'Dạ, tôi sẽ gửi ngay cho chị qua email. MERN stack là thế mạnh của tôi, tôi có thể chia sẻ cả mã nguồn demo để chị tham khảo.', NOW() - INTERVAL 3 DAY, true),
(23, 21, 'Tuyệt vời! Chúng tôi muốn hệ thống có khả năng mở rộng cao và hiệu suất tốt. Anh có kinh nghiệm tối ưu hóa cho website có lưu lượng truy cập lớn không?', NOW() - INTERVAL 2 DAY, true),
(21, 23, 'Có, tôi đã từng tối ưu hệ thống cho website có 50,000+ người dùng đồng thời. Tôi sử dụng các kỹ thuật như caching, lazy loading, và microservices để đảm bảo khả năng mở rộng.', NOW() - INTERVAL 2 DAY, true),
(23, 21, 'Anh có thể tham gia vào cuộc họp với team kỹ thuật của chúng tôi vào thứ 5 tuần này không? Chúng tôi muốn thảo luận chi tiết hơn về dự án.', NOW() - INTERVAL 1 DAY, true),
(21, 23, 'Vâng, tôi rất sẵn lòng. Thứ 5 này tôi có thể họp bất kỳ thời điểm nào từ 9h sáng đến 5h chiều. Chị có thể gửi lịch cụ thể cho tôi không?', NOW() - INTERVAL 1 DAY, false),

-- Phương (client) với Minh (freelancer)
(24, 22, 'Chào anh Minh, tôi là Phương từ TechFlow Solutions. Chúng tôi đang tìm kiếm một AI Engineer cho dự án phân tích dữ liệu khách hàng.', NOW() - INTERVAL 7 DAY, true),
(22, 24, 'Chào chị Phương, rất vui được làm quen. Tôi đã xem qua thông tin dự án của công ty chị và rất quan tâm.', NOW() - INTERVAL 7 DAY, true),
(24, 22, 'Dự án của chúng tôi cần xây dựng mô hình dự đoán hành vi khách hàng từ dữ liệu giao dịch lịch sử. Anh có kinh nghiệm về lĩnh vực này không?', NOW() - INTERVAL 6 DAY, true),
(22, 24, 'Có, tôi đã từng phát triển hệ thống tương tự cho một ngân hàng lớn, sử dụng kết hợp các mô hình regression và deep learning để dự đoán khả năng churn và cross-selling.', NOW() - INTERVAL 6 DAY, true),
(24, 22, 'Đó là kinh nghiệm rất phù hợp. Chúng tôi có khoảng 2TB dữ liệu từ 3 năm gần đây. Anh có kinh nghiệm xử lý dữ liệu lớn không?', NOW() - INTERVAL 5 DAY, true),
(22, 24, 'Vâng, tôi thường xuyên làm việc với dữ liệu lớn sử dụng Spark và các công cụ trên AWS/Azure. Tôi có thể giúp xây dựng pipeline xử lý dữ liệu hiệu quả cho dự án này.', NOW() - INTERVAL 5 DAY, true),
(24, 22, 'Tuyệt vời! Chúng tôi muốn hệ thống không chỉ dự đoán mà còn đưa ra các đề xuất phù hợp cho từng phân khúc khách hàng. Anh nghĩ gì về yêu cầu này?', NOW() - INTERVAL 4 DAY, true),
(22, 24, 'Đó là yêu cầu hoàn toàn hợp lý. Tôi sẽ thiết kế hệ thống sử dụng collaborative filtering kết hợp với content-based recommendation để tạo ra đề xuất cá nhân hóa cho từng khách hàng.', NOW() - INTERVAL 4 DAY, true),
(24, 22, 'Nghe rất hứa hẹn. Chúng tôi muốn mời anh tham gia cuộc phỏng vấn kỹ thuật vào tuần sau. Anh có thể sắp xếp được không?', NOW() - INTERVAL 3 DAY, true),
(22, 24, 'Rất sẵn lòng. Tuần sau tôi có thể sắp xếp vào các ngày thứ 2, thứ 4 hoặc thứ 6. Chị có thể gửi email thông tin chi tiết về cuộc phỏng vấn không?', NOW() - INTERVAL 3 DAY, false);

-- Thêm các bản ghi cho quản lý danh sách yêu thích (is_saved = true)
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 11, id, NULL
FROM job WHERE title = 'Kiểm thử bảo mật và đánh giá lỗ hổng'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 11 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 12, id, NULL
FROM job WHERE title = 'Xây dựng chiến lược SEO toàn diện'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 12 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 13, id, NULL
FROM job WHERE title = 'Phát triển ứng dụng mobile Cross-platform'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 13 AND job_id = job.id);

-- Thêm account mới
INSERT INTO account (email, password, role, created_at, updated_at, status, lat, lng)
VALUES
    ('hoangvt123@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 10.780901, 106.682295),
    ('trangnt456@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 20.991236, 105.831002),
    ('ducnv789@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, 11.940418, 108.458313),
    ('anhnt567@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), null, 0, 16.468446, 107.584489),
    ('hailt890@gmail.com', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), null, 0, 10.045162, 105.746857);

-- Thêm thông tin user
INSERT INTO users (first_name, last_name, phone_number, province, country, title, introduction, image, account_id)
VALUES
    ('Hoàng', 'Vũ Trọng', '0912345678', 'Hồ Chí Minh', 'Việt Nam', 'DevOps & Cloud Architect', 'Kiến trúc sư Cloud với 10 năm kinh nghiệm xây dựng hạ tầng quy mô lớn, chuyên AWS/GCP và Kubernetes.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user6.jpg', 26),
    ('Trang', 'Nguyễn Thị', '0923456789', 'Hà Nội', 'Việt Nam', 'Blockchain Developer', 'Nhà phát triển Blockchain với 5 năm kinh nghiệm xây dựng DApps, Smart Contracts và giải pháp Web3.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user7.jpg', 27),
    ('Đức', 'Nguyễn Văn', '0934567890', 'Đà Lạt', 'Việt Nam', 'Startup Founder', 'Nhà sáng lập startup công nghệ trong lĩnh vực du lịch, tìm kiếm đối tác phát triển sản phẩm.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user8.jpg', 28),
    ('Anh', 'Nguyễn Tuấn', '0945678901', 'Huế', 'Việt Nam', 'E-commerce Director', 'Giám đốc thương mại điện tử với 8 năm kinh nghiệm quản lý và phát triển các nền tảng bán lẻ trực tuyến.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user9.jpg', 29),
    ('Hải', 'Lê Thanh', '0956789012', 'Cần Thơ', 'Việt Nam', 'Data Engineer', 'Kỹ sư dữ liệu với chuyên môn về xây dựng data pipeline, ETL và data warehouse trên các nền tảng cloud.', 'https://raw.githubusercontent.com/quangbm0807/static-assets/refs/heads/main/avatar/user10.jpg', 30);


-- Thêm freelancer
INSERT INTO freelancer (hourly_rate, description, category_id, user_id)
VALUES
    (40.00, 'DevOps & Cloud Architect với kinh nghiệm điều phối và tự động hóa hạ tầng CNTT cho các doanh nghiệp từ khởi nghiệp đến tập đoàn lớn. Chuyên AWS, GCP, Azure, Kubernetes, Docker, CI/CD.', 1, 26),
    (38.00, 'Blockchain Developer với kinh nghiệm phát triển smart contracts, dapps và các giải pháp tài chính phi tập trung. Thông thạo Solidity, Web3.js, Ethereum, và các blockchain khác.', 1, 27),
    (32.00, 'Data Engineer với chuyên môn xây dựng hệ thống xử lý dữ liệu quy mô lớn, ETL pipeline và data warehouse. Thành thạo Apache Spark, Airflow, Kafka và các công cụ dữ liệu Big Data.', 1, 30);

-- Thêm client
INSERT INTO client (from_price, to_price, type_price, user_id)
VALUES
    (8000000, 25000000, 'VNĐ', 28),
    (10000000, 30000000, 'VNĐ', 29);

-- Thêm company
INSERT INTO company (company_name, phone_contact, address, industry, client_id)
VALUES
    ('TravelTech Innovations', '0934567890', 'Đà Lạt', 'Travel Technology & Online Booking', 11),
    ('NextGen Commerce', '0945678901', 'Huế', 'E-commerce & Digital Retail', 12);
-- Thêm CV mới
INSERT INTO cv (title, url, status, freelancer_id)
VALUES
    ('AWS Solutions Architect', 'cv-sample32.pdf', TRUE, 14),
    ('Kubernetes & Cloud Native Expert', 'cv-sample33.pdf', TRUE, 14),
    ('Blockchain Development Portfolio', 'cv-sample34.pdf', TRUE, 15),
    ('Smart Contract & DeFi Specialist', 'cv-sample35.pdf', TRUE, 15),
    ('Data Pipeline Architecture', 'cv-sample36.pdf', TRUE, 16),
    ('Big Data Processing Specialist', 'cv-sample37.pdf', TRUE, 16);
-- Thêm kỹ năng
INSERT INTO freelancer_skill (freelancer_id, skill_id)
VALUES
-- DevOps Engineer (ID: 14)
(14, 32), -- AWS
(14, 33), -- Azure
(14, 34), -- Docker
(14, 35), -- Kubernetes
(14, 36), -- Jenkins
(14, 37), -- CI/CD Pipelines
(14, 1),  -- Java (for infrastructure as code)
(14, 8),  -- Python (for automation)
(14, 25), -- Firebase
(14, 21), -- SQL

-- Blockchain Developer (ID: 15)
(15, 3),  -- ReactJS (for dApps frontend)
(15, 6),  -- Node.js (for blockchain backend)
(15, 8),  -- Python (for scripts and testing)
(15, 12), -- PHP
(15, 14), -- C# (for blockchain integration)
(15, 16), -- C++ (for performance-critical blockchain components)
(15, 21), -- SQL
(15, 25), -- Firebase
(15, 32), -- AWS (for hosting blockchain nodes)
(15, 34), -- Docker (for blockchain development environment)

-- Data Engineer (ID: 16)
(16, 8),  -- Python
(16, 21), -- SQL
(16, 22), -- MySQL
(16, 23), -- PostgreSQL
(16, 24), -- MongoDB
(16, 26), -- Data Analysis
(16, 27), -- Data Science
(16, 32), -- AWS
(16, 33), -- Azure
(16, 34); -- Docker

-- Thêm projects
INSERT INTO projects (title, tech, description, link, image, freelancer_id)
VALUES
-- DevOps Engineer (ID: 14)
('Enterprise Cloud Migration', 'AWS, Terraform, Docker, Kubernetes', 'Dự án di chuyển hạ tầng On-premise của một tập đoàn tài chính lên AWS, giảm 40% chi phí vận hành và tăng 99.99% uptime.', 'https://github.com/hoangvt/cloud-migration', 'cloud-migration.png', 14),
('CI/CD Pipeline Automation', 'Jenkins, GitLab CI, Docker, Kubernetes', 'Xây dựng và tối ưu hóa quy trình CI/CD cho một hệ thống microservices với 30+ services, giảm thời gian triển khai từ hàng giờ xuống còn vài phút.', 'https://github.com/hoangvt/cicd-automation', 'cicd-automation.png', 14),

-- Blockchain Developer (ID: 15)
('DeFi Lending Platform', 'Solidity, React, Web3.js, Ethereum', 'Nền tảng cho vay phi tập trung (DeFi) với các hợp đồng thông minh an toàn, hỗ trợ đa đồng tiền và lãi suất động.', 'https://github.com/trangnt/defi-lending', 'defi-lending.png', 15),
('NFT Marketplace', 'Solidity, React, IPFS, Polygon', 'Sàn giao dịch NFT trên blockchain Polygon với phí giao dịch thấp, tích hợp ví và hỗ trợ đa định dạng media.', 'https://github.com/trangnt/nft-marketplace', 'nft-marketplace.png', 15),

-- Data Engineer (ID: 16)
('Real-time Analytics Platform', 'Apache Kafka, Spark, Airflow, AWS', 'Xây dựng hệ thống phân tích dữ liệu thời gian thực cho công ty viễn thông, xử lý hàng triệu sự kiện mỗi giây.', 'https://github.com/hailt/realtime-analytics', 'realtime-analytics.png', 16),
('Data Lake Architecture', 'AWS S3, Glue, Athena, Redshift, Spark', 'Thiết kế và triển khai data lake cho tập đoàn bán lẻ, tích hợp dữ liệu từ nhiều nguồn và hỗ trợ phân tích nâng cao.', 'https://github.com/hailt/data-lake-architecture', 'data-lake.png', 16);

-- Thêm education
INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id, image)
VALUES
    ('2009-09-01', '2013-06-30', 'Tốt nghiệp ngành Khoa học Máy tính với chuyên sâu về công nghệ cloud và hệ thống phân tán.', 1, 2, 1, 14, null),
    ('2014-09-01', '2016-06-30', 'Thạc sĩ Khoa học Máy tính chuyên ngành Hệ thống phân tán và Cloud Computing.', 1, 3, 1, 14, null),
    ('2013-09-01', '2017-06-30', 'Tốt nghiệp ngành Kỹ thuật phần mềm, nghiên cứu về các công nghệ blockchain và phát triển ứng dụng phi tập trung.', 4, 2, 1, 15, null),
    ('2014-09-01', '2018-06-30', 'Tốt nghiệp ngành Khoa học dữ liệu, chuyên sâu về kỹ thuật xử lý dữ liệu lớn và phân tích dữ liệu.', 2, 2, 1, 16, null);

-- Thêm experiences
INSERT INTO experiences (company_name, position, start_date, end_date, description, status, freelancer_id)
VALUES
-- DevOps Engineer (ID: 14)
('CloudEra Technologies', 'System Administrator', '2013-07-01', '2015-12-31', 'Quản trị hệ thống máy chủ và mạng, triển khai các giải pháp ảo hóa và bảo mật.', true, 14),
('GlobalTech Solutions', 'Cloud Engineer', '2016-01-01', '2019-06-30', 'Thiết kế và triển khai các giải pháp cloud trên AWS và Azure, tối ưu hóa chi phí và hiệu suất.', true, 14),
('Enterprise DevOps', 'Senior DevOps Architect', '2019-07-01', '2024-12-31', 'Thiết kế kiến trúc DevOps cho các doanh nghiệp lớn, xây dựng chiến lược tự động hóa và triển khai liên tục.', true, 14),

-- Blockchain Developer (ID: 15)
('FinTech Innovations', 'Software Developer', '2017-07-01', '2019-06-30', 'Phát triển các ứng dụng web và mobile trong lĩnh vực tài chính, tích hợp công nghệ blockchain.', true, 15),
('Blockchain Lab', 'Blockchain Developer', '2019-07-01', '2021-12-31', 'Phát triển các smart contracts và ứng dụng phi tập trung (DApps) trên nền tảng Ethereum.', true, 15),
('DeFi Ventures', 'Senior Blockchain Engineer', '2022-01-01', '2024-12-31', 'Thiết kế và triển khai các giải pháp DeFi và NFT, tối ưu hóa gas fee và bảo mật cho smart contracts.', true, 15),

-- Data Engineer (ID: 16)
('Data Insights Co.', 'Data Analyst', '2018-07-01', '2020-06-30', 'Phân tích dữ liệu kinh doanh, xây dựng dashboard và báo cáo phân tích.', true, 16),
('Big Data Solutions', 'Data Engineer', '2020-07-01', '2022-12-31', 'Xây dựng và quản lý các pipeline ETL, thiết kế data warehouse và data lake.', true, 16),
('Analytics Cloud', 'Senior Data Engineer', '2023-01-01', '2024-12-31', 'Thiết kế kiến trúc dữ liệu quy mô lớn, xây dựng các giải pháp phân tích thời gian thực và machine learning.', true, 16);

-- Thêm job mới
INSERT INTO job (title, scope, hour_work, duration, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id, end_date)
VALUES
-- Client 11 (TravelTech Innovations)
('Xây dựng nền tảng đặt phòng trực tuyến', 'LARGE', 120, 180, true, 50000000, 80000000, 'VNĐ', 'Phát triển nền tảng đặt phòng trực tuyến toàn diện với tích hợp thanh toán, đánh giá, và hệ thống quản lý đặt chỗ. Yêu cầu kinh nghiệm với các API của nhà cung cấp dịch vụ lưu trú.', 'FULL', 'OPEN', NOW(), NULL, 11, 1, NOW() + INTERVAL 45 DAY),
('Thiết kế ứng dụng di động du lịch', 'MEDIUM', 80, 120, true, 30000000, 50000000, 'VNĐ', 'Thiết kế và phát triển ứng dụng di động cho nền tảng du lịch, tích hợp bản đồ, gợi ý địa điểm, đặt tour và phòng. Ưu tiên người có kinh nghiệm với React Native hoặc Flutter.', 'FULL', 'OPEN', NOW(), NULL, 11, 1, NOW() + INTERVAL 30 DAY),
('Phát triển hệ thống đề xuất thông minh cho du lịch', 'LARGE', 100, 150, true, 40000000, 70000000, 'VNĐ', 'Xây dựng hệ thống đề xuất thông minh sử dụng AI để gợi ý điểm đến, khách sạn, và tour du lịch phù hợp với sở thích và ngân sách của người dùng.', 'FULL', 'OPEN', NOW(), NULL, 11, 7, NOW() + INTERVAL 60 DAY),

-- Client 12 (NextGen Commerce)
('Phát triển hệ thống CRM cho thương mại điện tử', 'LARGE', 90, 150, true, 60000000, 100000000, 'VNĐ', 'Xây dựng hệ thống CRM toàn diện cho nền tảng thương mại điện tử, tích hợp với các kênh bán hàng, quản lý khách hàng và tự động hóa marketing.', 'FULL', 'OPEN', NOW(), NULL, 12, 1, NOW() + INTERVAL 60 DAY),
('Tích hợp AI vào nền tảng thương mại điện tử', 'LARGE', 80, 120, true, 50000000, 80000000, 'VNĐ', 'Tích hợp các giải pháp AI vào nền tảng thương mại điện tử, bao gồm search thông minh, cá nhân hóa sản phẩm, chatbot hỗ trợ khách hàng và phân tích dữ liệu hành vi.', 'FULL', 'OPEN', NOW(), NULL, 12, 7, NOW() + INTERVAL 45 DAY),
('Xây dựng hệ thống quản lý kho đa kênh', 'MEDIUM', 60, 90, false, 35000000, 60000000, 'VNĐ', 'Phát triển hệ thống quản lý kho thông minh, tích hợp với nhiều kênh bán hàng online và offline, tự động hóa theo dõi tồn kho, đặt hàng và dự báo nhu cầu.', 'HOURLY', 'OPEN', NOW(), NULL, 12, 1, NOW() + INTERVAL 30 DAY);

-- Thêm job_skill
INSERT INTO job_skill (job_id, skill_id)
VALUES
-- Xây dựng nền tảng đặt phòng trực tuyến
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 1),  -- Java
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 2),  -- Spring Boot
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 3),  -- ReactJS
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 6),  -- Node.js
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 21), -- SQL
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 22), -- MySQL
((SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'), 32), -- AWS

-- Thiết kế ứng dụng di động du lịch
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 19), -- Flutter
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 20), -- React Native
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 17), -- Swift
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 18), -- Kotlin
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 25), -- Firebase
((SELECT id FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'), 39), -- UI/UX Design

-- Phát triển hệ thống đề xuất thông minh cho du lịch
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 8),  -- Python
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 26), -- Data Analysis
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 27), -- Data Science
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 28), -- Machine Learning
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 29), -- Deep Learning
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 30), -- TensorFlow
((SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'), 32), -- AWS

-- Phát triển hệ thống CRM cho thương mại điện tử
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 1),  -- Java
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 2),  -- Spring Boot
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 3),  -- ReactJS
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 21), -- SQL
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 22), -- MySQL
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 26), -- Data Analysis
((SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'), 32), -- AWS

-- Tích hợp AI vào nền tảng thương mại điện tử
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 8),  -- Python
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 27), -- Data Science
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 28), -- Machine Learning
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 29), -- Deep Learning
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 30), -- TensorFlow
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 31), -- PyTorch
((SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'), 32), -- AWS

-- Xây dựng hệ thống quản lý kho đa kênh
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 1),  -- Java
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 2),  -- Spring Boot
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 3),  -- ReactJS
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 6),  -- Node.js
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 21), -- SQL
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 26), -- Data Analysis
((SELECT id FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'), 32); -- AWS

-- Thêm freelancer_job
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 32, 14, id, NOW() - INTERVAL 2 DAY
FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 14 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'VIEWED', 33, 14, id, NOW() - INTERVAL 3 DAY
FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 14 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 34, 15, id, NOW() - INTERVAL 5 DAY
FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 15 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 36, 16, id, NOW() - INTERVAL 4 DAY
FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 16 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT false, 'APPLIED', 37, 16, id, NOW() - INTERVAL 2 DAY
FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 16 AND job_id = job.id);

-- Thêm job đã lưu (saved)
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 14, id, NULL
FROM job WHERE title = 'Xây dựng hệ thống quản lý kho đa kênh'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 14 AND job_id = job.id);

INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 15, id, NULL
FROM job WHERE title = 'Thiết kế ứng dụng di động du lịch'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 15 AND job_id = job.id);
INSERT INTO freelancer_job (is_saved, status, cv_id, freelancer_id, job_id, applied_date)
SELECT true, NULL, NULL, 16, id, NULL
FROM job WHERE title = 'Xây dựng hệ thống CRM cho thương mại điện tử'
           AND NOT EXISTS (SELECT 1 FROM freelancer_job WHERE freelancer_id = 16 AND job_id = job.id AND is_saved = true);

-- Gói dịch vụ cho client mới
INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
    (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 11),
    (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 290000, 10, 3, true, 3, 12),
    (DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_SUB(NOW(), INTERVAL 2 MONTH), 90000, 5, 5, false, 2, 11),
    (DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_SUB(NOW(), INTERVAL 1 MONTH), 290000, 10, 8, false, 3, 12);

-- Thêm client_review
INSERT INTO client_review (rating, note)
VALUES
    (5.0, 'Freelancer có kiến thức chuyên môn xuất sắc về DevOps và Cloud, giải quyết các vấn đề phức tạp một cách hiệu quả. Giao tiếp rõ ràng và luôn đúng hạn.'),
    (4.9, 'Kiến thức về Blockchain rất ấn tượng, code sạch và dễ bảo trì. Luôn đưa ra các giải pháp tối ưu và bảo mật cao.'),
    (4.8, 'Kỹ năng xử lý dữ liệu lớn rất xuất sắc, giúp tối ưu hóa hiệu suất hệ thống. Chuyên nghiệp và đáng tin cậy.'),
    (4.7, 'Rất hài lòng với kinh nghiệm và kỹ năng AI/ML. Khả năng phân tích dữ liệu tuyệt vời và đề xuất giải pháp hiệu quả.');

-- Thêm freelancer_review
INSERT INTO freelancer_review (rating, note)
VALUES
    (5.0, 'Khách hàng chuyên nghiệp, yêu cầu rõ ràng và cung cấp tài liệu đầy đủ. Phản hồi nhanh chóng và thanh toán đúng hạn.'),
    (4.9, 'Dự án thú vị với phạm vi rõ ràng. Khách hàng thực sự hiểu về công nghệ và có tầm nhìn rõ ràng về sản phẩm.'),
    (4.8, 'Trải nghiệm làm việc tuyệt vời. Khách hàng tôn trọng chuyên môn và luôn sẵn sàng lắng nghe đề xuất kỹ thuật.'),
    (4.7, 'Khách hàng rất hợp tác, cung cấp phản hồi kịp thời và có quy trình làm việc hiệu quả. Mong muốn hợp tác lâu dài.');

-- Thêm notification
INSERT INTO notification (message, user_id, is_read, url, created_at)
VALUES
    ('Ứng viên mới đã ứng tuyển vào công việc "Xây dựng nền tảng đặt phòng trực tuyến"', 28, false, '/jobs/details', NOW() - INTERVAL 2 DAY),
    ('Ứng viên mới đã ứng tuyển vào công việc "Phát triển hệ thống CRM cho thương mại điện tử"', 29, false, '/jobs/details', NOW() - INTERVAL 5 DAY),
    ('Bạn đã được chọn cho cuộc phỏng vấn công việc "Tích hợp AI vào nền tảng thương mại điện tử"', 30, false, '/interview/details', NOW() - INTERVAL 1 DAY),
    ('Gói dịch vụ của bạn sẽ hết hạn trong 5 ngày', 28, true, '/packages', NOW() - INTERVAL 3 DAY),
    ('Công việc mới phù hợp với kỹ năng của bạn đã được đăng tải', 26, false, '/jobs/matching', NOW() - INTERVAL 2 DAY),
    ('Bạn có 3 công việc phù hợp mới trong tuần này', 27, true, '/jobs/matching', NOW() - INTERVAL 4 DAY),
    ('Đánh giá mới từ khách hàng về dự án "Enterprise Cloud Migration"', 26, false, '/reviews', NOW() - INTERVAL 2 DAY),
    ('Công việc của bạn đã được duyệt thành công', 29, true, '/jobs/details', NOW() - INTERVAL 5 DAY),
    ('Thanh toán cho gói dịch vụ Kim Cương đã được xác nhận', 28, false, '/payments', NOW() - INTERVAL 6 DAY),
    ('Lời mời tham gia cuộc phỏng vấn từ "NextGen Commerce"', 27, false, '/interview/schedule', NOW() - INTERVAL 2 DAY);


-- Thêm payment cho tài khoản mới
INSERT INTO payment (balance, created_at, updated_at, account_id)
VALUES
    (3800000.00, NOW() - INTERVAL 60 DAY, NOW() - INTERVAL 2 DAY, 26),
    (5200000.00, NOW() - INTERVAL 90 DAY, NOW() - INTERVAL 1 DAY, 27),
    (0.00, NOW() - INTERVAL 45 DAY, NOW() - INTERVAL 3 DAY, 28),
    (0.00, NOW() - INTERVAL 30 DAY, NOW() - INTERVAL 1 DAY, 29),
    (2700000.00, NOW() - INTERVAL 75 DAY, NOW() - INTERVAL 2 DAY, 30);

-- Thêm transactions
INSERT INTO transactions (money, activity, created_at, description, status, payment_id)
VALUES
    -- Client ID 11 (Đức - User ID 28)
    (2000000.00, 'DEPOSIT', NOW() - INTERVAL 50 DAY, 'Nạp tiền qua ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 28)),
    (390000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Kim Cương', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 28)),
    (90000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 3 MONTH), 'Thanh toán gói Bạc', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 28)),

    -- Client ID 12 (Anh - User ID 29)
    (1500000.00, 'DEPOSIT', NOW() - INTERVAL 45 DAY, 'Nạp tiền qua VNPay', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 29)),
    (290000.00, 'WITHDRAW', NOW() - INTERVAL 30 DAY, 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 29)),
    (290000.00, 'WITHDRAW', DATE_SUB(NOW(), INTERVAL 2 MONTH), 'Thanh toán gói Vàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 29)),

    -- Freelancer ID 14 (Hoàng - User ID 26)
    (1200000.00, 'DEPOSIT', NOW() - INTERVAL 90 DAY, 'Thanh toán từ dự án: Enterprise Cloud Migration', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 26)),
    (1500000.00, 'DEPOSIT', NOW() - INTERVAL 60 DAY, 'Thanh toán từ dự án: CI/CD Pipeline Automation', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 26)),
    (1100000.00, 'DEPOSIT', NOW() - INTERVAL 30 DAY, 'Thanh toán từ dự án: AWS Deployment Optimization', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 26)),
    (800000.00, 'WITHDRAW', NOW() - INTERVAL 20 DAY, 'Rút tiền về tài khoản ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 26)),

    -- Freelancer ID 15 (Trang - User ID 27)
    (1800000.00, 'DEPOSIT', NOW() - INTERVAL 85 DAY, 'Thanh toán từ dự án: DeFi Lending Platform', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 27)),
    (2000000.00, 'DEPOSIT', NOW() - INTERVAL 55 DAY, 'Thanh toán từ dự án: NFT Marketplace', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 27)),
    (1600000.00, 'DEPOSIT', NOW() - INTERVAL 25 DAY, 'Thanh toán từ dự án: Smart Contract Audit', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 27)),
    (1000000.00, 'WITHDRAW', NOW() - INTERVAL 15 DAY, 'Rút tiền về tài khoản ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 27)),

    -- Freelancer ID 16 (Hải - User ID 30)
    (1400000.00, 'DEPOSIT', NOW() - INTERVAL 70 DAY, 'Thanh toán từ dự án: Real-time Analytics Platform', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 30)),
    (1800000.00, 'DEPOSIT', NOW() - INTERVAL 40 DAY, 'Thanh toán từ dự án: Data Lake Architecture', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 30)),
    (1200000.00, 'DEPOSIT', NOW() - INTERVAL 20 DAY, 'Thanh toán từ dự án: ETL Pipeline Optimization', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 30)),
    (1700000.00, 'WITHDRAW', NOW() - INTERVAL 10 DAY, 'Rút tiền về tài khoản ngân hàng', 'SUCCESS',
     (SELECT id FROM payment WHERE account_id = 30));

-- Thêm appointments cho công việc mới
INSERT INTO appointments (topic, start_time, duration, description, link, client_id, freelancer_job_id)
VALUES
    ('Phỏng vấn dự án Xây dựng nền tảng đặt phòng trực tuyến', NOW() + INTERVAL 5 DAY, 90, 'Thảo luận chi tiết về kinh nghiệm và phương pháp triển khai dự án đặt phòng online', 'https://meet.example.com/booking-platform', 11,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 14 AND job_id = (SELECT id FROM job WHERE title = 'Xây dựng nền tảng đặt phòng trực tuyến'))),

    ('Thảo luận yêu cầu hệ thống CRM', NOW() + INTERVAL 3 DAY, 60, 'Phỏng vấn và thảo luận về kinh nghiệm blockchain và hợp đồng thông minh', 'https://meet.example.com/crm-system', 12,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 15 AND job_id = (SELECT id FROM job WHERE title = 'Phát triển hệ thống CRM cho thương mại điện tử'))),

    ('Phỏng vấn dự án AI cho thương mại điện tử', NOW() + INTERVAL 7 DAY, 75, 'Thảo luận về kinh nghiệm AI/ML và phương pháp tích hợp vào nền tảng hiện có', 'https://meet.example.com/ai-ecommerce', 12,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 16 AND job_id = (SELECT id FROM job WHERE title = 'Tích hợp AI vào nền tảng thương mại điện tử'))),

    ('Thảo luận dự án Hệ thống đề xuất du lịch thông minh', NOW() + INTERVAL 4 DAY, 60, 'Phỏng vấn và trao đổi về kinh nghiệm xây dựng hệ thống đề xuất dựa trên AI', 'https://meet.example.com/travel-recommendation', 11,
     (SELECT id FROM freelancer_job WHERE freelancer_id = 16 AND job_id = (SELECT id FROM job WHERE title = 'Phát triển hệ thống đề xuất thông minh cho du lịch')));

-- Thêm chat_messages
INSERT INTO chat_messages (sender_id, receiver_id, content, sent_at, is_read)
VALUES
-- Đức (client) với Hoàng (freelancer)
(28, 26, 'Chào anh Hoàng, tôi đã xem qua hồ sơ của anh và rất ấn tượng với kinh nghiệm DevOps và Cloud của anh.', NOW() - INTERVAL 7 DAY, true),
(26, 28, 'Chào anh Đức, cảm ơn anh đã liên hệ. Tôi rất vui khi anh quan tâm đến kinh nghiệm của tôi.', NOW() - INTERVAL 7 DAY, true),
(28, 26, 'Chúng tôi đang xây dựng nền tảng đặt phòng trực tuyến và cần một kiến trúc sư cloud để thiết kế hạ tầng. Anh đã từng làm dự án tương tự chưa?', NOW() - INTERVAL 6 DAY, true),
(26, 28, 'Vâng, tôi đã từng làm việc với 2 dự án tương tự trong lĩnh vực du lịch. Tôi có kinh nghiệm xây dựng hạ tầng cloud có tính sẵn sàng cao và khả năng mở rộng tốt trên AWS và GCP.', NOW() - INTERVAL 6 DAY, true),
(28, 26, 'Tuyệt vời! Chúng tôi đang cân nhắc giữa AWS và Azure. Anh có thể chia sẻ quan điểm về điểm mạnh của từng nền tảng cho dự án đặt phòng không?', NOW() - INTERVAL 5 DAY, true),
(26, 28, 'Cả hai đều có ưu điểm riêng. AWS có các dịch vụ quản lý cơ sở dữ liệu và cân bằng tải rất tốt, phù hợp với các ứng dụng cần xử lý nhiều giao dịch. Azure có tích hợp tốt với hệ sinh thái Microsoft và các công cụ DevOps. Tôi nghĩ với dự án đặt phòng, AWS có thể phù hợp hơn nhờ các dịch vụ như ElastiCache, DynamoDB và API Gateway.', NOW() - INTERVAL 5 DAY, true),
(28, 26, 'Anh có thể cho tôi biết về cách anh thiết kế hạ tầng để đảm bảo khả năng chịu tải cao trong mùa cao điểm du lịch không?', NOW() - INTERVAL 4 DAY, true),
(26, 28, 'Tôi thường sử dụng cấu trúc multi-AZ và auto-scaling groups để đảm bảo hệ thống có thể mở rộng theo nhu cầu. Kết hợp với CDN cho content tĩnh, caching layer cho database queries và việc tối ưu hóa frontend để giảm tải cho server. Ngoài ra, tôi cũng thiết kế các hệ thống queue để xử lý các tác vụ nặng như xử lý thanh toán và gửi email.', NOW() - INTERVAL 4 DAY, true),
(28, 26, 'Nghe rất chuyên nghiệp. Chúng tôi muốn mời anh tham gia phỏng vấn chi tiết hơn. Anh có thể tham gia cuộc họp vào thứ 5 tuần này lúc 10h sáng không?', NOW() - INTERVAL 3 DAY, true),
(26, 28, 'Tôi sẵn sàng tham gia. Thứ 5 lúc 10h sáng là phù hợp với tôi. Anh có thể gửi cho tôi chi tiết về cuộc họp qua email không?', NOW() - INTERVAL 3 DAY, false),

-- Anh (client) với Hải (freelancer)
(29, 30, 'Chào anh Hải, tôi là Anh từ NextGen Commerce. Chúng tôi đang tìm kiếm một Data Engineer có kinh nghiệm cho dự án AI trong thương mại điện tử.', NOW() - INTERVAL 8 DAY, true),
(30, 29, 'Chào anh Anh, rất vui được làm quen. Tôi có 6 năm kinh nghiệm với data engineering và đã từng làm việc với nhiều dự án AI/ML.', NOW() - INTERVAL 8 DAY, true),
(29, 30, 'Dự án của chúng tôi cần xây dựng hệ thống phân tích dữ liệu khách hàng, cá nhân hóa trải nghiệm mua sắm và tối ưu hóa tìm kiếm. Anh đã từng làm các hệ thống tương tự chưa?', NOW() - INTERVAL 7 DAY, true),
(30, 29, 'Vâng, tôi đã từng xây dựng data pipeline và data lake cho một sàn thương mại điện tử lớn, bao gồm cả hệ thống đề xuất sản phẩm và phân tích hành vi người dùng. Tôi sử dụng Apache Spark, Kafka, và các dịch vụ ML trên AWS cho dự án đó.', NOW() - INTERVAL 7 DAY, true),
(29, 30, 'Ấn tượng! Chúng tôi có khoảng 5TB dữ liệu từ nhiều nguồn khác nhau. Anh sẽ thiết kế hệ thống xử lý dữ liệu này như thế nào?', NOW() - INTERVAL 6 DAY, true),
(30, 29, 'Tôi sẽ thiết kế một kiến trúc theo hướng data mesh, tách biệt các domain nghiệp vụ khác nhau. Dữ liệu sẽ được thu thập thông qua Kafka, xử lý batch và streaming bằng Spark, và lưu trữ trong data lake trên S3 với các lớp: raw, processed, và consumption. Metadata sẽ được quản lý bởi AWS Glue, cho phép tìm kiếm và khai phá dữ liệu hiệu quả.', NOW() - INTERVAL 6 DAY, true),
(29, 30, 'Còn về việc cá nhân hóa trải nghiệm người dùng, anh có kinh nghiệm với loại mô hình ML nào?', NOW() - INTERVAL 5 DAY, true),
(30, 29, 'Tôi đã làm việc với các mô hình collaborative filtering, content-based filtering và hybrid approach. Gần đây tôi đã triển khai một hệ thống sử dụng deep learning (NCF - Neural Collaborative Filtering) kết hợp với thông tin ngữ cảnh để tạo ra các đề xuất theo thời gian thực. Hệ thống này đã cải thiện tỷ lệ chuyển đổi lên 35%.', NOW() - INTERVAL 5 DAY, true),
(29, 30, 'Rất ấn tượng! Chúng tôi muốn mời anh tham gia cuộc phỏng vấn kỹ thuật để thảo luận chi tiết hơn. Anh có thể sắp xếp vào tuần sau được không?', NOW() - INTERVAL 4 DAY, true),
(30, 29, 'Vâng, tôi rất sẵn lòng. Tuần sau tôi có thể sắp xếp vào các ngày thứ 3, thứ 4 hoặc thứ 6. Anh thấy ngày nào phù hợp nhất?', NOW() - INTERVAL 4 DAY, false);














