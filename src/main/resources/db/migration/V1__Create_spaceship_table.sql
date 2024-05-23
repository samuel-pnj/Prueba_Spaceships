-- src/main/resources/db/migration/V1__Create_spaceship_table.sql
CREATE TABLE spaceship (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    series VARCHAR(255)
);