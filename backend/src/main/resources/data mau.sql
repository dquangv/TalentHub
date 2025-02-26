-- drop database job_e_commerce_platform;
-- create database job_e_commerce_platform;

use job_e_commerce_platform;

INSERT INTO school (school_name) 
VALUES 
('Đại học Bách Khoa TP.HCM'),
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

INSERT INTO major (major_name) 
VALUES 
('Lập trình viên (Software Developer)'),
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

INSERT INTO degree (degree_title)
VALUES
('Cử nhân'),
('Kỹ sư'),
('Thạc sĩ'),
('Tiến sĩ'),
('Cao đẳng'),
('Chứng chỉ');

-- pass 123
INSERT INTO account (email, password, role, created_at, updated_at, status) 
VALUES 
('tungvtps27852@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'ADMIN', NOW(), NOW(), TRUE),
('quangvdps36680@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), NOW(), TRUE),
('quangbmps28437@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), NOW(), TRUE),
('tiendqpc07858@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'FREELANCER', NOW(), NOW(), TRUE),
('huydqpc07859@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'CLIENT', NOW(), NOW(), TRUE);

INSERT INTO users (first_name, last_name, phone_number, address, title, introduction, image, account_id) 
VALUES 
('Tùng', 'Võ', '0976543210', 'Hà Nội', 'Frontend Developer', 'Chuyên gia ReactJS, VueJS với nhiều dự án UI/UX hiện đại', 'tungvo.png', 1),
('Quang', 'Vũ', '0987654321', 'Hồ Chí Minh', 'Backend Developer', 'Lập trìnaccounth viên backend với 3 năm kinh nghiệm trong Java Spring Boot', 'quangvu.png', 2),
('Quang', 'Bùi', '0965432109', 'Đà Nẵng', 'UI/UX Designer', 'Thiết kế trải nghiệm người dùng cho website và mobile app', 'hanguyen.png', 3),
('Tiến', 'Đinh', '0954321098', 'Cần Thơ', 'Digital Marketer', 'Chuyên gia SEO, quảng cáo Google Ads và Facebook Ads', 'anhpham.png', 4),
('Huy', 'Đinh', '0943210987', 'Cần Thơ', 'Fullstack Developer', 'Có kinh nghiệm với cả frontend (React, Angular) và backend (NodeJS, Java)', 'baole.png', 5);

INSERT INTO client (from_price, to_price, type_price, user_id)
VALUES 
(500000, 2000000, 'VNĐ', 3),
(1000000, 3000000, 'VNĐ', 5);

INSERT INTO company (company_name, phone_contact, address, industry, client_id)
VALUES
('Công ty Google', '0123456789', 'Hồ Chí Minh', 'Phát triển phần mềm', 1),
('Công ty Amazon', '0184675892', 'Hà Nội', 'Thương mại điện tử', 2);

INSERT INTO category (category_title) VALUES 
('Lập trình & Phát triển phần mềm'),
('Thiết kế đồ họa & Multimedia'),
('Viết lách & Dịch thuật'),
('Marketing & Quảng cáo'),
('SEO & Phát triển nội dung'),
('Dịch vụ khách hàng & Hỗ trợ kỹ thuật'),
('Tư vấn kinh doanh & Tài chính'),
('Quản lý dự án & Điều hành'),
('Sản xuất video & Chỉnh sửa phim'),
('Nhập liệu & Hành chính văn phòng');

INSERT INTO skill (skill_name) VALUES 
-- Lập trình & Phát triển phần mềm
('Java'), 
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

-- Dữ liệu & AI
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

-- DevOps & Cloud
('AWS'), 
('Azure'), 
('Google Cloud Platform'), 
('Docker'), 
('Kubernetes'), 
('Jenkins'), 
('CI/CD Pipelines'), 

-- Thiết kế & Đồ họa
('UI/UX Design'), 
('Adobe Photoshop'), 
('Adobe Illustrator'), 
('Figma'), 
('Sketch'), 
('Canva'), 
('Blender 3D'), 
('Maya'), 
('Cinema 4D'), 

-- Marketing & Content
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

-- Video & Âm thanh
('Video Editing'), 
('Adobe Premiere Pro'), 
('Final Cut Pro'), 
('After Effects'), 
('Animation'), 
('3D Modeling'), 
('Music Production'), 
('Podcast Editing'), 

-- Công việc kinh doanh & hỗ trợ
('Data Entry'), 
('Virtual Assistant'), 
('Project Management'), 
('Business Consulting'), 
('Customer Support'), 
('Sales'), 
('Lead Generation'), 
('Accounting'), 
('Bookkeeping'), 

-- Ngôn ngữ & Dịch thuật
('English Translation'), 
('Chinese Translation'), 
('Japanese Translation'), 
('Korean Translation'), 
('Spanish Translation'), 
('French Translation'), 
('German Translation'), 
('Proofreading'), 
('Transcription');


INSERT INTO freelancer (hourly_rate, description, category_id, user_id) VALUES 
(20.00, 'Lập trình viên Java với 5 năm kinh nghiệm về Spring Boot.', 1, 2), 
(15.50, 'Chuyên gia ReactJS và Node.js, có kinh nghiệm làm việc với nhiều startup.', 1, 4);

INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id) VALUES
('2015-09-01', '2019-06-30', 'Học chuyên ngành Khoa học Máy tính tại Đại học Bách Khoa TP.HCM.', 1, 1, 1, 1),
('2016-09-01', '2020-06-30', 'Tốt nghiệp ngành Thiết kế Đồ họa tại Đại học Kiến Trúc TP.HCM.', 2, 2, 2, 2);

INSERT INTO job (title, scope, hour_work, job_opportunity, from_price, to_price, type_price, description, type_payment, status, created_at, updated_at, client_id, category_id) VALUES
('Thiết kế logo thương hiệu', 'Thiết kế logo độc quyền cho startup.', 20.5, true, 500000, 2000000, 'Fixed', 'Cần tìm designer chuyên nghiệp để thiết kế logo sáng tạo.', 'BANK', 'OPEN', NOW(), NOW(), 1, 1),
('Lập trình website bán hàng', 'Xây dựng trang web thương mại điện tử.', 100, true, 5000000, 15000000, 'Hourly', 'Cần lập trình viên full-stack xây dựng website bán hàng.', 'CASH', 'OPEN', NOW(), NOW(), 2, 2),
('Dịch thuật tài liệu tiếng Anh', 'Dịch thuật tài liệu chuyên ngành từ Anh sang Việt.', 15, false, 300000, 1000000, 'Fixed', 'Cần dịch giả chuyên ngành IT để dịch tài liệu.', 'BANK', 'OPEN', NOW(), NOW(), 1, 3),
('Chạy quảng cáo Facebook', 'Tạo và tối ưu chiến dịch quảng cáo Facebook.', 30, true, 1000000, 5000000, 'Hourly', 'Cần marketer có kinh nghiệm chạy Facebook Ads.', 'BANK', 'OPEN', NOW(), NOW(), 2, 4),
('Phát triển ứng dụng di động', 'Xây dựng app Android/iOS cho startup.', 200, true, 20000000, 50000000, 'Hourly', 'Cần developer có kinh nghiệm Flutter hoặc React Native.', 'CASH', 'CLOSE', NOW(), NOW(), 1, 5),
('Viết bài chuẩn SEO', 'Viết bài blog chuẩn SEO về công nghệ.', 10, false, 200000, 800000, 'Fixed', 'Cần writer viết bài SEO theo từ khóa.', 'CASH', 'BAN', NOW(), NOW(), 2, 6);

INSERT INTO freelancer_skill (freelancer_id, skill_id) VALUES 
(1, 2),
(1, 3),
(1, 1),
(1, 4),
(1, 5),
(2, 6),
(2, 2),
(2, 7);

INSERT INTO job_skill (job_id, skill_id) VALUES 
(1, 2),
(1, 3),
(2, 1),
(2, 5),
(1, 4),
(1, 6),
(1, 7),
(2, 8),
(3, 10),
(3, 12),
(3, 13),
(4, 20),
(4, 22),
(4, 23),
(4, 24);


INSERT INTO freelancer_review (rating, note) VALUES
(4.5, 'Freelancer hoàn thành dự án đúng hạn, chất lượng tốt.'),
(3.8, 'Cần cải thiện kỹ năng giao tiếp, nhưng chất lượng ổn.');

INSERT INTO client_review (rating, note) VALUES
(4.0, 'Client có yêu cầu rõ ràng và thanh toán đúng hạn.'),
(3.5, 'Dự án có chút thay đổi giữa chừng, nhưng xử lý ổn.');


INSERT INTO freelancer_job (is_saved, status, cv, freelancer_id, job_id, freelancer_review_id, client_review_id) VALUES 
(true, 'Applied', 'cv_freelancer_1.pdf', 1, 1, NULL, NULL),
(false, 'InProgress', 'cv_freelancer_2.pdf', 2, 2, NULL, NULL),
(true, 'Completed', 'cv_freelancer_3.pdf', 1, 3, 1, 1),
(false, 'Completed', 'cv_freelancer_4.pdf', 2, 4, 2, 2);