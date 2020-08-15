CREATE TABLE IF NOT EXISTS `users`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(64) NOT NULL DEFAULT '',
    `mobile` VARCHAR(32) NOT NULL DEFAULT '',
    `email` VARCHAR(128) NOT NULL DEFAULT '',
    `sex` SMALLINT NOT NULL DEFAULT 0,
    `password` VARCHAR(128) NOT NULL DEFAULT '',
    `created_time` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);