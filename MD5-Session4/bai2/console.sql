CREATE DATABASE student_db;
USE student_db;

CREATE TABLE stundent
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(100) NOT NULL,
    age    INT          NOT NULL,
    status INT
);

-- tìm kiếm theo id
DELIMITER $$
CREATE PROCEDURE find_by_id(
    IN in_id int
)
BEGIN
    SELECT *
    FROM stundent
    WHERE id = in_id;
END $$
DELIMITER ;

-- hiển thị tất cả sinh viên
DELIMITER $$
CREATE PROCEDURE get_all_student()
BEGIN
    SELECT * FROM stundent;
END $$
DELIMITER ;

-- thêm mới sinh viên
DELIMITER $$
CREATE PROCEDURE add_student(
    IN in_name VARCHAR(100),
    IN in_age INT
)
BEGIN
    INSERT INTO stundent(name, age, status)
    VALUES (in_name, in_age, 1);
END $$
DELIMITER ;

-- sửa sinh viên
DELIMITER $$
CREATE PROCEDURE update_student(
    IN in_id INT,
    IN in_name VARCHAR(100),
    IN in_age INT,
    IN in_status INT
)
BEGIN
    UPDATE stundent
    SET name   = in_name,
        age    = in_age,
        status = in_status
    WHERE id = in_id;
END $$
DELIMITER ;

-- xóa sinh viên
DELIMITER $$
CREATE PROCEDURE delete_student(
    IN in_id INT
)
BEGIN
    DELETE
    FROM stundent
    WHERE id = in_id;
END $$
DELIMITER ;