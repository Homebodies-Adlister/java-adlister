USE adlister_project_db;

DROP TABLE IF EXISTS retail;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    zip VARCHAR(5) NOT NULL,
    is_admin BOOLEAN NULL,
    PRIMARY KEY (id)
);

CREATE TABLE retail (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    rating INT DEFAULT 3,
    curb_side BOOLEAN NOT NULL,
    in_store BOOLEAN NOT NULL,
    social_distancing BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE restaurant (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    rating INT DEFAULT 3,
    mask BOOLEAN NOT NULL,
    gloves BOOLEAN NOT NULL,
    social_distancing BOOLEAN NOT NULL,
    dine_in BOOLEAN NOT NULL,
    take_out BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_places (
    user_id INT UNSIGNED NOT NULL,
    restaurant_id INT UNSIGNED NOT NULL,
    retail_id INT UNSIGNED NOT NULL
);