DROP DATABASE IF EXISTS task_management_system;
CREATE DATABASE task_management_system;
USE task_management_system;

-- Create Roles table
CREATE TABLE IF NOT EXISTS roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) UNIQUE NOT NULL
);

-- Modify Users table to include role_id for a one-to-many relationship
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- Add an index on the username column for the Users table
CREATE INDEX idx_username ON users(username);

-- Create Permissions table
CREATE TABLE IF NOT EXISTS permissions (
    permission_id INT AUTO_INCREMENT PRIMARY KEY,
    permission_name VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255)
);

-- Create Role_Permissions table for many-to-many relationship between roles and permissions
CREATE TABLE IF NOT EXISTS role_permissions (
    role_id INT,
    permission_id INT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (permission_id) REFERENCES permissions(permission_id)
);


-- Create Status table
CREATE TABLE IF NOT EXISTS taskstatus (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(255) UNIQUE NOT NULL
);

-- Create Tasks table
CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,
    task_description TEXT,
    task_due_date TIMESTAMP NOT NULL,
    user_id INT,
    status_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (status_id) REFERENCES taskstatus(status_id)
) ENGINE=InnoDB;
CREATE INDEX idx_user_id ON tasks(user_id);
CREATE INDEX idx_status_id ON tasks(status_id);

-- Insert roles
INSERT INTO roles (role_name) VALUES ('ADMIN'), ('USER');

-- Insert task statuses
INSERT INTO taskstatus (status_name) VALUES ('TODO'), ('IN_PROGRESS'), ('DONE');

-- Assuming role_id for 'ADMIN' is 1, 'USER' is 2
-- Insert users with direct role assignments
-- adminUser  password1
-- firstUser  password2
-- secondUser password3

INSERT INTO users (username, password, email, role_id) VALUES ('adminUser', '$2a$10$MYwlzglw26aIR5/Yxczh6.pHBAZccCORWRFgmEFhyLlkqUmvbNWm2', 'admin@example.com', 1);
INSERT INTO users (username, password, email, role_id) VALUES ('firstUser', '$2a$10$DVp9elJEZOgg5G/saHcRKu2KzpdmwqGKS7sfjPupmnELUlnudd1QC', 'user1@example.com', 2);
INSERT INTO users (username, password, email, role_id) VALUES ('secondUser', '$2a$10$7.iG87iCbxRJDQixSm2daearLvEQzKnB6hndTtW36XelJ/3rqChJe', 'user2@example.com', 2);

-- Insert tasks for 'adminUser' (Assuming user_id = 1)
INSERT INTO tasks (task_title, task_description, task_due_date, user_id, status_id) VALUES
('Project Plan Review', 'Review the entire project plan for Q1', NOW(), 1, 1),
('Budget Proposal', 'Finalize the budget proposal for the upcoming fiscal year', ADDDATE(NOW(), INTERVAL 1 DAY), 1, 2);

-- Insert tasks for 'firstUser' (Assuming user_id = 2)
INSERT INTO tasks (task_title, task_description, task_due_date, user_id, status_id) VALUES
('Documentation Draft', 'Draft the necessary project documentation', NOW(), 2, 1),
('Timeline Update', 'Update the project timeline based on recent changes', ADDDATE(NOW(), INTERVAL 1 DAY), 2, 2);

-- Insert tasks for 'secondUser' (Assuming user_id = 3)
INSERT INTO tasks (task_title, task_description, task_due_date, user_id, status_id) VALUES
('Project Presentation', 'Prepare the project presentation for the next team meeting', NOW(), 3, 1),
('Feedback Collection', 'Collect and compile feedback from the team on the project', ADDDATE(NOW(), INTERVAL 1 DAY), 3, 3);

