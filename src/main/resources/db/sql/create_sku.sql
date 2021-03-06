CREATE TABLE IF NOT EXISTS `skus`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `uuid` VARCHAR(128) NOT NULL DEFAULT '',
    `created_time` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY ( `id` ) REFERENCES `goods`(`id`)
);