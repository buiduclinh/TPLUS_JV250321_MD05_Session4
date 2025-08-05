CREATE DATABASE product_manager;
USE product_manager;

CREATE TABLE category
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100),
    description VARCHAR(100),
    status      BIT DEFAULT 1
);

-- lấy hết thông tin nhãn
DELIMITER $$
CREATE PROCEDURE get_all_category(
)
BEGIN
    SELECT * FROM category;
END $$
DELIMITER ;

-- lấy nhãn id
DELIMITER $$
CREATE PROCEDURE get_category_by_id(
    IN in_category_id INT
)
BEGIN
    SELECT *
    FROM category
    WHERE id = in_category_id;
END $$
DELIMITER ;

-- thêm mới nhãn hàng
DELIMITER $$
CREATE PROCEDURE add_category(
    IN in_category_name VARCHAR(100),
    IN in_category_description VARCHAR(100)
)
BEGIN
    INSERT INTO category(name, description)
    VALUES (in_category_name, in_category_description);
END $$
DELIMITER ;

-- chỉnh sửa nhãn hàng
DELIMITER $$
CREATE PROCEDURE update_category(
    IN in_category_id INT,
    IN in_category_name VARCHAR(100),
    IN in_category_description VARCHAR(100),
    IN in_category_status BIT
)
BEGIN
    UPDATE category
    SET name        = in_category_name,
        description = in_category_description,
        status      = in_category_status
    WHERE id = in_category_id;
END $$
DELIMITER ;

-- xóa nhãn hàng
DELIMITER $$
CREATE PROCEDURE delete_category(
    IN in_category_id INT
)
BEGIN
    DELETE
    FROM category
    WHERE id = in_category_id;
END $$
DELIMITER ;