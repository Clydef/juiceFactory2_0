create database juice_factory;

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'customer')
BEGIN
CREATE TABLE customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          customer_number VARCHAR(255) UNIQUE NOT NULL,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          phone_number VARCHAR(255),
                          address VARCHAR(255),
                          district VARCHAR(255),
                          date_registered DATE,
                          category VARCHAR(255)
);
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'product')
BEGIN
CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         description VARCHAR(255),
                         price DECIMAL(10, 2),
                         quantity_in_stock INT,
                         image_url VARCHAR(255),
                         code VARCHAR(255) UNIQUE NOT NULL,
                         category VARCHAR(255)
);
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'orders')
BEGIN
CREATE TABLE orders (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       order_number VARCHAR(255) UNIQUE NOT NULL,
                       customer_id BIGINT,
                       order_date DATE,
                       total_amount DECIMAL(10, 2),
                       payment_method VARCHAR(255)
);
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'order_item')
BEGIN
CREATE TABLE order_item (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            order_id BIGINT,
                            product_id BIGINT,
                            quantity INT,
                            unit_price DECIMAL(10, 2),
                            FOREIGN KEY (order_id) REFERENCES order(id) ON DELETE CASCADE,
                            FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);
END