CREATE TABLE survey_result (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    choice VARCHAR(5),
    count INT DEFAULT 0
);
