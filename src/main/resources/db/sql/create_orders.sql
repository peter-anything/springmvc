CREATE TABLE IF NOT EXISTS `orders`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT UNSIGNED NOT NULL comment 'user id',
    `good_id` INT UNSIGNED NOT NULL comment 'good id',
    `count` INT UNSIGNED NOT NULL DEFAULT 0,
    `created_time` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
    FOREIGN KEY (`good_id`) REFERENCES `goods`(`id`)
);