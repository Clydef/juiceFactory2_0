create database juice_factory;
-- use juice_factory;

-- CREATE SEQUENCE my_seq_gen START 1;


CREATE TABLE `juice_factory`.`customer` (
                                            `id` BIGINT(45) NOT NULL AUTO_INCREMENT,
                                            `customer_number` VARCHAR(45) NOT NULL,
                                            `name` VARCHAR(45) NOT NULL,
                                            `address` VARCHAR(45) NOT NULL,
                                            `district` VARCHAR(45) NOT NULL,
                                            `phone_number` VARCHAR(45) NOT NULL,
                                            `date_registered` DATETIME NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE INDEX `customer_number_UNIQUE` (`customer_number` ASC) VISIBLE);


CREATE TABLE `juice_factory`.`order_status` (
                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                `order_state` VARCHAR(45) NOT NULL,
                                                PRIMARY KEY (`id`));


CREATE TABLE `juice_factory`.`payment_method` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `payment_method_name` VARCHAR(45) NOT NULL,
                                                  PRIMARY KEY (`id`));


CREATE TABLE `juice_factory`.`product` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `product_code` VARCHAR(45) NOT NULL,
                                           `product_name` VARCHAR(45) NOT NULL,
                                           `product_description` VARCHAR(45) NULL,
                                           `production_date` DATETIME NULL,
                                           `expire_date` DATETIME NULL,
                                           `type_of_product` VARCHAR(45) NOT NULL,
                                           PRIMARY KEY (`id`),
                                           UNIQUE INDEX `product_code_UNIQUE` (`product_code` ASC) VISIBLE);


CREATE TABLE `juice_factory`.`invoice` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `total_price` VARCHAR(45) NULL,
                                           PRIMARY KEY (`id`));


CREATE TABLE `juice_factory`.`orders` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `customer_id` VARCHAR(45) NOT NULL,
                                          `invoice_id` INT NOT NULL,
                                          `order_date` DATETIME NULL,
                                          `delivery_date` VARCHAR(45) NULL,
                                          `order_status_id` INT NOT NULL,
                                          PRIMARY KEY (`id`),
                                          INDEX `customer_idx` (`customer_id` ASC) VISIBLE,
                                          INDEX `invoice_idx` (`invoice_id` ASC) VISIBLE,
                                          INDEX `order_status_id_idx` (`order_status_id` ASC) VISIBLE,
                                          CONSTRAINT `customer_id`
                                              FOREIGN KEY (`customer_id`)
                                                  REFERENCES `juice_factory`.`customer` (`customer_number`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
                                          CONSTRAINT `invoice_id`
                                              FOREIGN KEY (`invoice_id`)
                                                  REFERENCES `juice_factory`.`invoice` (`id`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
                                          CONSTRAINT `order_status_id`
                                              FOREIGN KEY (`order_status_id`)
                                                  REFERENCES `juice_factory`.`order_status` (`id`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION);


ALTER TABLE `juice_factory`.`orders`
    ADD COLUMN `order_number` VARCHAR(45) NOT NULL AFTER `id`,
ADD UNIQUE INDEX `order_number_UNIQUE` (`order_number` ASC) VISIBLE;
;


CREATE TABLE `juice_factory`.`order_products` (
                                                  `order_id` INT NOT NULL,
                                                  `product_id` VARCHAR(45) NOT NULL,
                                                  `quantity` INT NULL,
                                                  PRIMARY KEY (`order_id`, `product_id`),
                                                  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
                                                  CONSTRAINT `product_id`
                                                      FOREIGN KEY (`product_id`)
                                                          REFERENCES `juice_factory`.`product` (`product_code`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION);


ALTER TABLE `juice_factory`.`order_products`
    CHANGE COLUMN `order_id` `order_id` VARCHAR(45) NOT NULL ,
DROP PRIMARY KEY;
;
ALTER TABLE `juice_factory`.`order_products`
    ADD CONSTRAINT `order_id`
        FOREIGN KEY (`order_id`)
            REFERENCES `juice_factory`.`orders` (`order_number`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


ALTER TABLE `juice_factory`.`invoice`
    ADD COLUMN `orders_id` VARCHAR(45) NOT NULL AFTER `id`,
ADD COLUMN `payment_methods_id` INT NULL AFTER `total_price`,
ADD INDEX `payment_methods_id_idx` (`payment_methods_id` ASC) VISIBLE,
ADD INDEX `order_ids_idx` (`orders_id` ASC) VISIBLE;
;
ALTER TABLE `juice_factory`.`invoice`
    ADD CONSTRAINT `payment_methods_id`
        FOREIGN KEY (`payment_methods_id`)
            REFERENCES `juice_factory`.`payment_method` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `orders_id`
  FOREIGN KEY (`orders_id`)
  REFERENCES `juice_factory`.`orders` (`order_number`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `juice_factory`.`invoice`
DROP COLUMN `order_id`,
DROP INDEX `order_id_idx` ;
;
ALTER TABLE `juice_factory`.`invoice`
    ADD CONSTRAINT `payment_method_id`
        FOREIGN KEY (`payment_method_id`)
            REFERENCES `juice_factory`.`payment_method` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;



