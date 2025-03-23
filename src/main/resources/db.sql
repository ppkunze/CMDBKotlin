
CREATE TABLE location_type (
    location_type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE location_technology (
    location_technology_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    location_type_id INT,
    location_technology_id INT,
    FOREIGN KEY (location_type_id) REFERENCES location_type(location_type_id),
    FOREIGN KEY (location_technology_id) REFERENCES location_technology(location_technology_id)
);
