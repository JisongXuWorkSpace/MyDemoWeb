

-- Insert some default roles
INSERT IGNORE INTO roles (name) VALUES ('ROLE_USER');
INSERT IGNORE INTO roles (name) VALUES ('ROLE_ADMIN');


INSERT IGNORE INTO users (username, password, email, enabled) VALUES
('john_doe', '123456', 'john.doe@example.com', true),
('jisong', '123456', 'jisongxu613@gmail.com', true),
('admin', 'admin', 'admin@example.com', true);

-- Assign roles to users

INSERT IGNORE INTO user_roles (user_id, role_id) VALUES
((SELECT id FROM users WHERE username = 'john_doe'), (SELECT id FROM roles WHERE name = 'ROLE_USER')),
((SELECT id FROM users WHERE username = 'jisong'), (SELECT id FROM roles WHERE name = 'ROLE_USER')),
((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE name = 'ROLE_ADMIN')),
((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE name = 'ROLE_USER'));

