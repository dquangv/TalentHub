create database job_e_commerce_platform;

use job_e_commerce_platform;

INSERT INTO school (school_name)
VALUES ('Đại học Bách Khoa TP.HCM'),
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
VALUES ('Lập trình viên (Software Developer)'),
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
VALUES ('Cử nhân'),
       ('Kỹ sư'),
       ('Thạc sĩ'),
       ('Tiến sĩ'),
       ('Cao đẳng'),
       ('Chứng chỉ');

-- pass 123
INSERT INTO account (email, password, role, created_at, updated_at, status, lat, lng)
VALUES ('tungvtps27852@fpt.edu.vn', '$2a$12$1PUaXLFDOmC4Af926SCOEeCGvOWirieoYIv1Z3L7npEfXYNtF8vjm', 'ADMIN', NOW(),
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
        'Chuyên gia ReactJS, VueJS với nhiều dự án UI/UX hiện đại.', 'tungvo.png', 1),
       ('Quang', 'Vũ', '0987654321', 'Tân Phú', 'Hồ Chí Minh', 'Backend Developer',
        'Lập trình viên backend với 3 năm kinh nghiệm trong Java Spring Boot.', 'quangvu.png', 2),
       ('Quang', 'Bùi', '0965432109', 'Bình Thạnh', 'Đà Nẵng', 'CEO', 'Chủ doanh nghiệp công ty công nghệ.',
        'hanguyen.png', 3),
       ('Tiến', 'Đinh', '0954321098', 'Gò Vấp', 'Cần Thơ', 'Digital Marketer',
        'Chuyên gia SEO, quảng cáo Google Ads và Facebook Ads.', 'anhpham.png', 4),
       ('Huy', 'Đinh', '0943210987', 'Gò Vấp', 'Cần Thơ', 'Tech Lead',
        '10 năm kinh nghiệm với vai trò Back-end Development.', 'baole.png', 5),
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
VALUES
('API Payment Integration', 'Java Spring Boot, REST API, MySQL', 'Tích hợp hệ thống thanh toán trực tuyến qua VNPay cho một ứng dụng thương mại điện tử.', 'https://github.com/quangvu/api-payment-integration', 'payment-integration.png', 1),
('User Management System', 'Java Spring Boot, JWT, PostgreSQL', 'Xây dựng hệ thống quản lý người dùng với tính năng phân quyền và bảo mật JWT.', 'https://github.com/quangvu/user-management-system', 'user-management.png', 1),
('SEO Growth Campaign', 'SEO, Google Analytics, Ahrefs', 'Tối ưu hóa công cụ tìm kiếm cho website thương mại điện tử, tăng lượng truy cập tự nhiên 200% trong 3 tháng.', 'https://behance.net/tienSEOcampaign', 'seo-growth.png', 2),
('Facebook Ads for Fashion Brand', 'Facebook Ads Manager, Canva, Copywriting', 'Chạy chiến dịch Facebook Ads giúp thương hiệu thời trang tăng doanh thu lên 150% trong mùa sale.', 'https://behance.net/tienfacebookads', 'fashion-ads.png', 2),
('E-Commerce Mobile App', 'Flutter, Firebase, Provider', 'Ứng dụng mua sắm đa nền tảng với thanh toán trực tuyến và theo dõi đơn hàng.', 'https://github.com/hoanganhpham/ecommerce-app', 'ecommerce-app.png', 3),
('Fitness Tracker App', 'React Native, Redux, NodeJS', 'Ứng dụng theo dõi sức khỏe và luyện tập, tích hợp đồng bộ với đồng hồ thông minh.', 'https://github.com/hoanganhpham/fitness-tracker', 'fitness-tracker.png', 3),
('Sales Dashboard', 'Power BI, DAX, Excel', 'Dashboard trực quan hóa số liệu bán hàng giúp doanh nghiệp theo dõi doanh thu và lợi nhuận theo thời gian thực.', 'https://datavizworld.com/sales-dashboard', 'sales-dashboard.png', 4),
('Customer Behavior Analysis', 'Tableau, SQL Server, Python', 'Phân tích hành vi người dùng từ dữ liệu CRM, đưa ra insight để tối ưu chiến dịch marketing.', 'https://datavizworld.com/customer-analysis', 'customer-analysis.png', 4),
('Event Highlight Video', 'Adobe Premiere, After Effects', 'Dựng video highlight sự kiện hội nghị khách hàng chuyên nghiệp, thời lượng 3 phút.', 'https://vimeo.com/lananh/event-highlight', 'event-highlight.png', 5),
('Product Commercial Video', 'Adobe Premiere, Photoshop', 'Video quảng cáo sản phẩm chăm sóc da, thiết kế hình ảnh sinh động và hấp dẫn.', 'https://vimeo.com/lananh/product-commercial', 'product-commercial.png', 5),
('Technical Document Translation', 'SDL Trados, Microsoft Word', 'Dịch tài liệu kỹ thuật phần mềm từ tiếng Anh sang tiếng Việt cho công ty CNTT.', 'https://drive.google.com/tech-doc-translation', 'tech-doc.png', 6),
('Creative Content Editing', 'Grammarly, Google Docs', 'Biên tập nội dung sáng tạo cho chiến dịch marketing, đảm bảo ngữ pháp và phong cách thu hút.', 'https://drive.google.com/creative-editing', 'creative-editing.png', 6),
('SEO Copywriting Course', 'Zoom, Google Meet, Miro', 'Khóa học trực tuyến hướng dẫn viết bài chuẩn SEO, tăng khả năng tiếp cận khách hàng.', 'https://hieunguyen.com/seo-copywriting-course', 'seo-course.png', 7),
('Digital Marketing Masterclass', 'Google Classroom, Canva, Facebook Ads', 'Đào tạo chuyên sâu về quảng cáo Google và Facebook, thực hành trực tiếp trên các chiến dịch thật.', 'https://hieunguyen.com/digital-marketing-masterclass', 'digital-marketing.png', 7);

INSERT INTO education (start_date, end_date, description, school_id, degree_id, major_id, freelancer_id, image) VALUES
('2015-09-01', '2019-06-30', 'Tốt nghiệp loại giỏi chuyên ngành Kỹ thuật phần mềm.', 1, 2, 1, 1, null),
('2016-09-01', '2020-06-30', 'Hoàn thành chương trình đào tạo chuyên ngành Marketing kỹ thuật số.', 5, 1, 4, 2, null),
('2017-09-01', '2021-06-30', 'Nghiên cứu và phát triển các ứng dụng di động trong các dự án sinh viên.', 4, 2, 12, 3, null),
('2014-09-01', '2018-06-30', 'Tốt nghiệp xuất sắc chuyên ngành Phân tích dữ liệu và Khoa học máy tính.', 2, 1, 7, 4, null),
('2015-09-01', '2019-06-30', 'Tham gia nhiều dự án phim ngắn và video quảng cáo cho các câu lạc bộ.', 14, 1, 3, 5, null),
('2013-09-01', '2017-06-30', 'Đào tạo chuyên sâu về Biên - Phiên dịch và Ngôn ngữ học.', 3, 1, 7, 6, null),
('2012-09-01', '2016-06-30', 'Đạt chứng chỉ Content Marketing và đào tạo SEO thực chiến.', 16, 6, 5, 7, null);

INSERT INTO experiences (company_name, position, start_date, end_date, description, status, freelancer_id)
VALUES
('TechCorp Solutions', 'Backend Developer', '2020-01-01', '2022-06-30', 'Phát triển và bảo trì hệ thống backend với Java Spring Boot, xây dựng RESTful API cho các ứng dụng web.', true, 1),
('Fintech Pro', 'Senior Backend Developer', '2022-07-01', '2024-12-31', 'Thiết kế và phát triển hệ thống thanh toán, đảm bảo hiệu suất và bảo mật cao.', true, 1),
('Marketing Plus', 'Digital Marketing Specialist', '2019-05-01', '2021-12-31', 'Quản lý chiến dịch SEO và quảng cáo Google/Facebook, giúp khách hàng tăng trưởng doanh thu 150%.', true, 2),
('Creative Ads Agency', 'Digital Marketing Lead', '2022-01-01', '2024-12-31', 'Lãnh đạo đội ngũ marketing triển khai các chiến dịch đa kênh cho thương hiệu thời trang và giáo dục.', true, 2),
('AppDev Studio', 'Mobile Developer', '2018-09-01', '2021-03-31', 'Phát triển ứng dụng Android/iOS với Flutter, tích hợp các API thanh toán và bản đồ.', true, 3),
('NextGen Mobile', 'Senior Mobile Developer', '2021-04-01', '2024-12-31', 'Dẫn dắt nhóm phát triển app thể thao và thương mại điện tử bằng React Native.', true, 3),
('Data Insights Co.', 'Junior Data Analyst', '2017-07-01', '2019-12-31', 'Xử lý và phân tích dữ liệu khách hàng, tạo dashboard và báo cáo bằng Power BI.', true, 4),
('Smart Data Group', 'Senior Data Analyst', '2020-01-01', '2024-12-31', 'Phân tích dữ liệu kinh doanh và xây dựng các báo cáo chiến lược giúp doanh nghiệp đưa ra quyết định.', true, 4),
('Creative Studio', 'Video Editor', '2016-05-01', '2019-10-31', 'Chỉnh sửa video sự kiện và TVC quảng cáo, đảm bảo chất lượng hình ảnh và âm thanh.', true, 5),
('Vision Media', 'Senior Video Editor', '2020-01-01', '2024-12-31', 'Chịu trách nhiệm hậu kỳ các video viral, phim ngắn cho khách hàng lớn trong ngành thời trang và giải trí.', true, 5),
('Global Translations Ltd.', 'Technical Translator', '2018-03-01', '2020-06-30', 'Dịch tài liệu kỹ thuật trong lĩnh vực phần mềm và viễn thông từ Anh sang Việt.', true, 6),
('Freelance Projects', 'Editor & Translator', '2020-07-01', '2024-12-31', 'Biên dịch và hiệu đính tài liệu pháp lý, sáng tạo, đảm bảo nội dung chính xác và trôi chảy.', true, 6),
('EduTech Vietnam', 'Online Tutor', '2019-01-01', '2021-06-30', 'Giảng dạy kỹ năng Digital Marketing và viết nội dung SEO cho sinh viên và doanh nghiệp vừa và nhỏ.', true, 7),
('Self-employed', 'Freelance Online Trainer', '2021-07-01', '2024-12-31', 'Đào tạo trực tuyến các khóa học chuyên sâu về Content Writing và chiến lược Marketing số.', true, 7);

INSERT INTO job (
    title, scope, hour_work, duration, job_opportunity, 
    from_price, to_price, type_price, description, 
    type_payment, status, created_at, updated_at, client_id, category_id
) VALUES
-- 1
('Phát triển Website thương mại điện tử', 'LARGE', 40, 60, true, 5000000, 15000000, 'VNĐ',
 'Cần phát triển một website thương mại điện tử hoàn chỉnh, tích hợp thanh toán online và giao diện thân thiện với người dùng.',
 'FULL', 'CLOSED', NOW(), NULL, 1, 1),
-- 2
('Lập trình viên ReactJS hỗ trợ UI/UX', 'MEDIUM', 20, 30, false, 3000000, 8000000, 'VNĐ',
 'Tìm kiếm một lập trình viên ReactJS giúp tối ưu hóa UI/UX cho hệ thống CRM.',
 'HOURLY', 'POSTED', NOW(), NULL, 1, 1),
-- 3
('Backend Developer Java Spring Boot', 'LARGE', 30, 90, true, 7000000, 20000000, 'VNĐ',
 'Cần backend developer có kinh nghiệm với Java Spring Boot, tối ưu hóa hiệu suất và bảo mật.',
 'FULL', 'POSTED', NOW(), NULL, 2, 1),
-- 4
('Kiểm thử và kiểm tra bảo mật hệ thống backend', 'MEDIUM', 25, 45, false, 5000000, 12000000, 'VNĐ',
 'Cần tester chuyên kiểm tra bảo mật hệ thống và viết báo cáo lỗi chi tiết.',
 'HOURLY', 'POSTED', NOW(), NULL, 2, 1),
-- 5
('Quản lý dự án phần mềm', 'LARGE', 40, 120, true, 10000000, 25000000, 'VNĐ',
 'Tìm kiếm freelancer có kinh nghiệm quản lý dự án Agile/Scrum cho ứng dụng di động.',
 'FULL', 'POSTED', NOW(), NULL, 3, 8),
-- 6
('Hỗ trợ lập kế hoạch và giám sát tiến độ dự án', 'MEDIUM', 15, 30, false, 0, 7000000, 'VNĐ',
 'Phụ trách lập kế hoạch chi tiết và báo cáo tiến độ cho dự án.',
 'HOURLY', 'POSTED', NOW(), NULL, 3, 8),
-- 7
('Phân tích nghiệp vụ hệ thống ERP', 'MEDIUM', 35, 60, true, 8000000, 18000000, 'VNĐ',
 'Cần BA có kinh nghiệm ERP để tư vấn và phân tích yêu cầu nghiệp vụ.',
 'FULL', 'POSTED', NOW(), NULL, 4, 7),
-- 8
('Viết tài liệu SRS và Use Case', 'SMALL', 20, 30, false, 5000000, 10000000, 'VNĐ',
 'Cần người có kinh nghiệm viết tài liệu phân tích nghiệp vụ, SRS và Use Case.',
 'HOURLY', 'POSTED', NOW(), NULL, 4, 7),
-- 9
('Thiết kế logo thương hiệu', 'SMALL', 10, 14, false, 2000000, 5000000, 'VNĐ',
 'Cần freelancer thiết kế logo sáng tạo và chuyên nghiệp cho công ty khởi nghiệp.',
 'HOURLY', 'POSTED', NOW(), NULL, 5, 2),
-- 10
('Thiết kế giao diện website UX/UI', 'MEDIUM', 30, 45, true, 5000000, 12000000, 'VNĐ',
 'Cần designer có kinh nghiệm thiết kế UX/UI cho ngành thời trang, ưu tiên có portfolio.',
 'FULL', 'POSTED', NOW(), NULL, 5, 2),
-- 11
('Chỉnh sửa ảnh cưới chuyên nghiệp', 'SMALL', 15, 30, true, 3000000, 7000000, 'VNĐ',
 'Cần freelancer chỉnh sửa ảnh cưới, blend màu sáng tạo theo yêu cầu studio.',
 'HOURLY', 'DRAFT', NOW(), NULL, 6, 9),
-- 12
('Biên tập video highlight đám cưới', 'SMALL', 20, 21, false, 4000000, 8000000, 'VNĐ',
 'Biên tập video cưới, thêm hiệu ứng và âm thanh phù hợp.',
 'HOURLY', 'POSTED', NOW(), NULL, 6, 9),
-- 13
('Phát triển Website bán hàng đa kênh', 'LARGE', 50, 75, true, 6000000, 16000000, 'VNĐ',
 'Cần xây dựng một website bán hàng đa kênh tích hợp quản lý kho và đồng bộ hóa đơn hàng từ các nền tảng TMĐT.',
 'FULL', 'BANNED', NOW(), NULL, 1, 1),
-- 14
('Phát triển API cho hệ thống quản lý khách hàng', 'LARGE', 35, 60, true, 8000000, 18000000, 'VNĐ',
 'Tuyển backend developer chuyên phát triển RESTful API với Java Spring Boot và tối ưu hóa bảo mật.',
 'FULL', 'CLOSED', NOW(), NULL, 2, 1),
-- 15
('Scrum Master cho dự án phát triển app mobile', 'LARGE', 30, 90, false, 9000000, 22000000, 'VNĐ',
 'Tuyển Scrum Master để điều phối nhóm phát triển ứng dụng di động, theo dõi tiến độ và đảm bảo chất lượng.',
 'FULL', 'POSTED', NOW(), NULL, 3, 8),
-- 16
('Thiết kế UX/UI cho sàn thương mại điện tử', 'MEDIUM', 40, 60, true, 7000000, 15000000, 'VNĐ',
 'Cần UI/UX designer thiết kế giao diện thân thiện, tối ưu trải nghiệm người dùng cho sàn thương mại điện tử.',
 'FULL', 'POSTED', NOW(), NULL, 5, 2),
-- 17
('Chỉnh sửa ảnh sự kiện chuyên nghiệp', 'SMALL', 12, 20, false, 2500000, 6000000, 'VNĐ',
 'Tuyển freelancer chỉnh sửa ảnh sự kiện hội nghị và lễ khai trương, yêu cầu chỉnh màu và blend tự nhiên.',
 'HOURLY', 'POSTED', NOW(), NULL, 6, 9);




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


INSERT INTO job_skill (job_id, skill_id) VALUES
(1, 12),
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
VALUES
(4.5, 'Freelancer hoàn thành website thương mại điện tử đúng tiến độ, tích hợp thanh toán và giao diện chuyên nghiệp.'),
(4.6, 'Freelancer xây dựng hệ thống API chuyên nghiệp, hiệu năng ổn định và đáp ứng yêu cầu bảo mật cao. Giao tiếp dễ dàng, luôn cập nhật tiến độ kịp thời.'),
(4.7, 'Freelancer backend Java Spring Boot làm việc chuyên nghiệp, tối ưu hệ thống hiệu quả.'), 
(4.8, 'Thiết kế UX/UI sáng tạo, đúng định hướng thương hiệu và chuyên nghiệp.'),
(4.2, 'Freelancer quản lý dự án tốt, giám sát tiến độ team hiệu quả và có kỹ năng giao tiếp tốt.');


INSERT INTO client_review (rating, note)
VALUES
(4.0, 'Client cung cấp tài liệu và yêu cầu đầy đủ, thanh toán đúng hẹn.'),
(4.7, 'Client cung cấp yêu cầu rõ ràng, phản hồi nhanh chóng trong suốt quá trình phát triển. Thanh toán đúng hạn, rất chuyên nghiệp.'),
(4.5, 'Dự án có quy mô rõ ràng, tài liệu chi tiết và hỗ trợ kịp thời khi cần làm rõ yêu cầu. Hợp tác mượt mà, rất đáng làm việc cùng.'),
(4.3, 'Client rõ ràng về quy trình quản lý dự án, thanh toán kịp thời.'),
(4.5, 'Client có tầm nhìn rõ ràng về thiết kế UX/UI, feedback rất chi tiết.');



INSERT INTO cv (title, url, status, freelancer_id) VALUES
('Back-end Developer', NULL, TRUE, 1);

INSERT INTO freelancer_job (
    is_saved, status, cv_id, freelancer_id, job_id, freelancer_review_id, client_review_id, applied_date
) VALUES
-- Freelancer 1: Backend Developer (Category 1)
(false, 'APPROVED', 1, 1, 1, 1, 1, NOW()),
(false, 'APPLIED', 1, 1, 3, NULL, NULL, NOW()),
(false, 'APPLIED', 1, 1, 4, NULL, NULL, NOW()),
(false, 'CANCELLED', 1, 1, 13, NULL, NULL, NOW()),
(false, 'APPROVED', 1, 1, 14, 2, 2, NOW()),

-- Freelancer 3: Mobile Developer (Category 1)
(false, 'APPLIED', NULL, 3, 2, NULL, NULL, NOW()),
(false, 'APPLIED', NULL, 3, 15, NULL, NULL, NOW()),
(false, 'APPLIED', NULL, 3, 3, NULL, NULL, NOW()),

-- Freelancer 4: Data Analyst (Category 7)
(false, 'VIEWED', NULL, 4, 7, NULL, NULL, NOW()),
(false, 'APPLIED', NULL, 4, 8, NULL, NULL, NOW()),
(false, 'APPLIED', NULL, 3, 3, NULL, NULL, NOW()),

-- Freelancer 5: Video Editor (Category 9)
(false, 'VIEWED', NULL, 5, 12, NULL, NULL, NOW()),
(false, 'APPLIED', NULL, 5, 17, NULL, NULL, NOW());


INSERT INTO reported_job (reason_freelancer, reason_admin, description, status, image, created_at, updated_at, freelancer_id, job_id) VALUES
('Công việc không rõ ràng về yêu cầu và phạm vi.', 'Đang xem xét thêm bằng chứng từ hai phía.', 'Freelancer cho rằng thông tin công việc mơ hồ và client không phản hồi rõ ràng sau khi trao đổi.', 1, 'https://example.com/images/report1.png', NOW(), NULL, 1, 13);

INSERT INTO appointments (topic, start_time, duration, description, link, client_id, freelancer_job_id)
VALUES
('Phỏng vấn công việc: Phát triển Website thương mại điện tử', NOW() + INTERVAL 1 DAY, 60, 'Thảo luận chi tiết về yêu cầu và mong đợi dự án.', 'https://meet.example.com/1-1', 1, 1),
('Phỏng vấn công việc: Backend Developer Java Spring Boot', NOW() + INTERVAL 3 DAY, 60, 'Cuộc trao đổi chi tiết về yêu cầu backend.', 'https://meet.example.com/2-1', 2, 2),
('Phỏng vấn công việc: Kiểm thử và kiểm tra bảo mật hệ thống backend', NOW() + INTERVAL 1 DAY, 60, 'Phỏng vấn kỹ năng quản kiểm thử hệ thống.', 'https://meet.example.com/3-1', 2, 3),
('Phỏng vấn công việc: Phát triển Website bán hàng đa kênh', NOW() + INTERVAL 2 DAY, 30, 'Thảo luận lập kế hoạch chi tiết và timeline.', 'https://meet.example.com/3-2', 1, 4),
('Phỏng vấn công việc: Phát triển API cho hệ thống quản lý khách hàng', NOW() + INTERVAL 3 DAY, 45, 'Cuộc phỏng vấn kiểm tra kinh nghiệm làm việc với API.', 'https://meet.example.com/4-1', 2, 5),
('Phỏng vấn công việc: Lập trình viên ReactJS hỗ trợ UI/UX', NOW() + INTERVAL 4 DAY, 30, 'Đánh giá kỹ năng Front-end.', 'https://meet.example.com/4-2', 1, 6),
('Phỏng vấn công việc: Scrum Master cho dự án phát triển app mobile', NOW() + INTERVAL 1 DAY, 30, 'Phỏng vấn ý tưởng phát triển app.', 'https://meet.example.com/5-1', 3, 7),
('Phỏng vấn công việc: Viết tài liệu SRS và Use Case', NOW() + INTERVAL 2 DAY, 45, 'Trao đổi về Use Case.', 'https://meet.example.com/5-2', 4, 9),
('Phỏng vấn công việc: Chỉnh sửa ảnh cưới chuyên nghiệp', NOW() + INTERVAL 1 DAY, 30, 'Phỏng vấn về kỹ năng chỉnh sửa ảnh.', 'https://meet.example.com/6-1', 6, 11);

INSERT INTO voucher_packages (name, price, duration, number_post, type_package, status, created_at, updated_at, account)
VALUES
('Gói thường', 0, 7, 1, 0, true, NOW(), NULL, 1),
('Gói bạc', 90000, 14, 5, 1, true, NOW(), NULL, 1),
('Gói vàng', 290000, 14, 10, 2, true, NOW(), NULL, 1),
('Gói kim cương', 390000, 30, 10, 3, true, NOW(), NULL, 1);

INSERT INTO sold_packages (start_date, end_date, price, number_post, number_posted, status, voucher_packages, client)
VALUES
(NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 200000, 10, 3, true, 3, 1),
(NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 3, true, 2, 2),
(NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 3),
(NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 2, true, 2, 4),
(NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 390000, 10, 3, true, 4, 5),
(NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 90000, 5, 2, true, 2, 6);

INSERT INTO banner (title, image, status, vendor, duration, created_at, updated_at, price, start_time, end_time)
VALUES
('Grand Opening - Ưu đãi khai trương', '/images/opening_banner.jpg', true, 'TalentHub', 30, NOW(), NULL, 0, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY)),
('Khuyến mãi Mùa Hè cùng VinFast', '/images/vinfast_summer.jpg', true, 'VinFast', 15, NOW(), NULL, 5000000, NOW(), DATE_ADD(NOW(), INTERVAL 15 DAY)),
('Viettel - Internet tốc độ cao ưu đãi lớn', '/images/viettel_internet.jpg', true, 'Viettel', 20, NOW(), NULL, 2000000, NOW(), DATE_ADD(NOW(), INTERVAL 20 DAY)),
('FPT Play - Xem phim thả ga', '/images/fptplay_promo.jpg', true, 'FPT Telecom', 10, NOW(), NULL, 1500000, NOW(), DATE_ADD(NOW(), INTERVAL 10 DAY)),
('Highlands Coffee - Giảm giá 50% thức uống', '/images/highlands_discount.jpg', true, 'Highlands Coffee', 7, NOW(), NULL, 1000000, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY)),
('Thế Giới Di Động - Mua sắm công nghệ giá sốc', '/images/tgdd_sale.jpg', true, 'Thế Giới Di Động', 14, NOW(), NULL, 3000000, NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY));
