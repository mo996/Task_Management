

-- Drop tables if they exist to avoid duplicate entries during development
-- Note: Be cautious with dropping tables in a production environment.
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

-- Create Roles table
CREATE TABLE IF NOT EXISTS roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) UNIQUE NOT NULL
);

-- Create Users table
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Create User_Roles join table
CREATE TABLE IF NOT EXISTS user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    UNIQUE (user_id, role_id)
);

-- Create Status table
CREATE TABLE IF NOT EXISTS status (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(255) UNIQUE NOT NULL
    );


-- Create Tasks table
CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,
    task_description TEXT,
    task_due_date DATE NOT NULL,
    user_id INT,
    status_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
    );


