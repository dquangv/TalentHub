use job_e_commerce_platform;

-- Insert data for account (password: 123)
INSERT INTO account (id, created_at, email, password, role, status, updated_at, user_id) VALUES
(1, NOW(), 'tungvt@gmail.com', '123', 'FREELANCER', 1, NOW(), NULL),
(2, NOW(), 'quangvd@gmail.com', '123', 'CLIENT', 1, NOW(), NULL),
(3, NOW(), 'quangbm@gmail.com', '123', 'FREELANCER', 1, NOW(), NULL),
(4, NOW(), 'tiendq@gmail.com', '123', 'CLIENT', 1, NOW(), NULL),
(5, NOW(), 'huydq@gmail.com', '123', 'FREELANCER', 1, NOW(), NULL);
-- Insert data into bank_account table
INSERT INTO bank_account (bank_account_number, bank_name, branch, start_date, status) VALUES
(123456, 'Bank A', 'Branch A', '2023-01-01 00:00:00', 1),
(234567, 'Bank B', 'Branch B', '2023-01-02 00:00:00', 1),
(345678, 'Bank C', 'Branch C', '2023-01-03 00:00:00', 1),
(456789, 'Bank D', 'Branch D', '2023-01-04 00:00:00', 1),
(567890, 'Bank E', 'Branch E', '2023-01-05 00:00:00', 1);

-- Insert data into banner table
INSERT INTO banner (created_at, image, status, title, updated_at, vendor) VALUES
('2023-01-01 00:00:00', 'image1.jpg', 'Active', 'Banner 1', '2023-01-01 00:00:00', 'Vendor 1'),
('2023-01-02 00:00:00', 'image2.jpg', 'Active', 'Banner 2', '2023-01-02 00:00:00', 'Vendor 2'),
('2023-01-03 00:00:00', 'image3.jpg', 'Active', 'Banner 3', '2023-01-03 00:00:00', 'Vendor 3'),
('2023-01-04 00:00:00', 'image4.jpg', 'Active', 'Banner 4', '2023-01-04 00:00:00', 'Vendor 4'),
('2023-01-05 00:00:00', 'image5.jpg', 'Active', 'Banner 5', '2023-01-05 00:00:00', 'Vendor 5');

-- Insert data into category table
INSERT INTO category (category_title) VALUES
('Category 1'),
('Category 2'),
('Category 3'),
('Category 4'),
('Category 5');

-- Insert data into client_review table
INSERT INTO client_review (note,  rating) VALUES
('Note 1', 5.0),
('Note 2', 4.5),
('Note 3', 4.0),
('Note 4', 3.5),
('Note 5', 3.0);

-- Insert data into degree table
INSERT INTO degree (degree_title) VALUES
('Degree 1'),
('Degree 2'),
('Degree 3'),
('Degree 4'),
('Degree 5');

-- Insert data into e_wallet_account table
INSERT INTO e_wallet_account (e_wallet_name, email, phone_number, start_date) VALUES
('Wallet 1', 'wallet1@example.com', '1234567890', '2023-01-01 00:00:00'),
('Wallet 2', 'wallet2@example.com', '2345678901', '2023-01-02 00:00:00'),
('Wallet 3', 'wallet3@example.com', '3456789012', '2023-01-03 00:00:00'),
('Wallet 4', 'wallet4@example.com', '4567890123', '2023-01-04 00:00:00'),
('Wallet 5', 'wallet5@example.com', '5678901234', '2023-01-05 00:00:00');

-- Insert data into freelancer_review table
INSERT INTO freelancer_review (note, rating) VALUES
('Note 1', 5.0),
('Note 2', 4.5),
('Note 3', 4.0),
('Note 4', 3.5),
('Note 5', 3.0);

-- Insert data into major table
INSERT INTO major (major_name) VALUES
('Major 1'),
('Major 2'),
('Major 3'),
('Major 4'),
('Major 5');

-- Insert data into payment table
INSERT INTO payment (is_default, account_id, bank_account_id, e_wallet_account_id) VALUES
(1, 1, 1, 1),
(1, 2, 2, 2),
(1, 3, 3, 3),
(1, 4, 4, 4),
(1, 5, 5, 5);

-- Insert data into school table
INSERT INTO school (school_name) VALUES
('School 1'),
('School 2'),
('School 3'),
('School 4'),
('School 5');

-- Insert data into skill table
INSERT INTO skill (skill_name) VALUES
('Skill 1'),
('Skill 2'),
('Skill 3'),
('Skill 4'),
('Skill 5');

-- Insert data into users table
INSERT INTO users (address, first_name, introduction, last_name, phone_number, title, account_id) VALUES
('Address 1', 'First 1', 'Intro 1', 'Last 1', '1234567890', 'Title 1', 1),
('Address 2', 'First 2', 'Intro 2', 'Last 2', '2345678901', 'Title 2', 2),
('Address 3', 'First 3', 'Intro 3', 'Last 3', '3456789012', 'Title 3', 3),
('Address 4', 'First 4', 'Intro 4', 'Last 4', '4567890123', 'Title 4', 4),
('Address 5', 'First 5', 'Intro 5', 'Last 5', '5678901234', 'Title 5', 5);

-- Insert data into client table
INSERT INTO client (from_price, to_price, type_price, user_id) VALUES
(100.0, 200.0, 'Type 1', 1),
(200.0, 300.0, 'Type 2', 2),
(300.0, 400.0, 'Type 3', 3),
(400.0, 500.0, 'Type 4', 4),
(500.0, 600.0, 'Type 5', 5);

-- Insert data into company table
INSERT INTO company (industry, address, company_name, phone_contact, client_id) VALUES
('Industry 1', 'Address 1', 'Company 1', '1234567890', 1),
('Industry 2', 'Address 2', 'Company 2', '2345678901', 2),
('Industry 3', 'Address 3', 'Company 3', '3456789012', 3),
('Industry 4', 'Address 4', 'Company 4', '4567890123', 4),
('Industry 5', 'Address 5', 'Company 5', '5678901234', 5);

-- Insert data into freelancer table
INSERT INTO freelancer (description, hourly_rate, category_id, user_id) VALUES
('Description 1', 50.0,  1, 1),
('Description 2', 60.0,  2, 2),
('Description 3', 70.0,3, 3),
('Description 4', 80.0,  4, 4),
('Description 5', 90.0,  5, 5);
-- Insert data into cv table
INSERT INTO cv (name_cv, path, freelancer_id) VALUES
('CV 1', 'path1', 1),
('CV 2', 'path2', 2),
('CV 3', 'path3', 3),
('CV 4', 'path4', 4),
('CV 5', 'path5', 5);

-- Insert data into education table
INSERT INTO education (description, end_date, start_date, degree_id, freelancer_id, major_id, school_id) VALUES
('Description 1', '2023-01-01 00:00:00', '2022-01-01 00:00:00', 1, 1, 1, 1),
('Description 2', '2023-01-02 00:00:00', '2022-01-02 00:00:00', 2, 2, 2, 2),
('Description 3', '2023-01-03 00:00:00', '2022-01-03 00:00:00', 3, 3, 3, 3),
('Description 4', '2023-01-04 00:00:00', '2022-01-04 00:00:00', 4, 4, 4, 4),
('Description 5', '2023-01-05 00:00:00', '2022-01-05 00:00:00', 5, 5, 5, 5);

-- Insert data into freelancer_skill table
INSERT INTO freelancer_skill (freelancer_id, skill_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
-- Insert data into job table
INSERT INTO job (created_at, from_price, hour_work, job_opportunity, scope, status, title, to_price, type_payment, description, type_price, updated_at, category_id, client_id) VALUES
('2023-01-01 00:00:00', 100.0, 10.0, true, 'Scope 1', 'Pending', 'Job 1', 200.0, 'BANK', 'Description 1', 'Type 1', '2023-01-01 00:00:00', 1, 1),
('2023-01-02 00:00:00', 200.0, 20.0, true, 'Scope 2', 'Pending', 'Job 2', 300.0, 'BANK', 'Description 2', 'Type 2', '2023-01-02 00:00:00', 2, 2),
('2023-01-03 00:00:00', 300.0, 30.0, true, 'Scope 3', 'Pending', 'Job 3', 400.0, 'BANK', 'Description 3', 'Type 3', '2023-01-03 00:00:00', 3, 3),
('2023-01-04 00:00:00', 400.0, 40.0, true, 'Scope 4', 'Pending', 'Job 4', 500.0, 'BANK', 'Description 4', 'Type 4', '2023-01-04 00:00:00', 4, 4),
('2023-01-05 00:00:00', 500.0, 50.0, true, 'Scope 5', 'Pending', 'Job 5', 600.0, 'BANK', 'Description 5', 'Type 5', '2023-01-05 00:00:00', 5, 5);

-- Insert data into freelancer_job table
INSERT INTO freelancer_job (is_saved, status, cv_id, client_review_id, freelancer_id, freelancer_review_id, job_id) VALUES
(1, 'Applied', 1, 1, 1, 1, 1),
(1, 'Applied', 2, 2, 2, 2, 2),
(1, 'Applied', 3, 3, 3, 3, 3),
(1, 'Applied', 4, 4, 4, 4, 4),
(1, 'Applied', 5, 5, 5, 5, 5);

-- Insert data into job_skill table
INSERT INTO job_skill (job_id, skill_id) VALUES
(1, 1),
(1, 3),
(1, 2),
(2, 1),
(2, 2),
(2, 2),
(3, 3),
(4, 4),
(5, 5);