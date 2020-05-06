USE adlister_project_db;

-- DROP TABLE IF EXISTS retail;
-- DROP TABLE IF EXISTS restaurant;
-- DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    zip INT NOT NULL,
    is_admin BOOLEAN NULL,
    PRIMARY KEY (id),
    UNIQUE (username, email)
);

CREATE TABLE retail (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    rating INT DEFAULT 3,
    curb_side BOOLEAN NOT NULL,
    in_store BOOLEAN NOT NULL,
    mask BOOLEAN NOT NULL,
    gloves BOOLEAN NOT NULL,
    social_distancing BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE restaurant (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    rating INT DEFAULT 3,
    mask BOOLEAN NOT NULL,
    gloves BOOLEAN NOT NULL,
    social_distancing BOOLEAN NOT NULL,
    dine_in BOOLEAN NOT NULL,
    take_out BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
