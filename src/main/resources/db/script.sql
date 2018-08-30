INSERT INTO `mitraiscarrot`.`role`
(`id`,
`created_by`,
`created_time`,
`is_deleted`,
`last_modified_by`,
`last_modified_time`,
`role_name`)
VALUES
(1, "admin", "2018-08-24", 0, "admin", "2018-08-24", "admin");

INSERT INTO `mitraiscarrot`.`user`
(`id`,
`active`,
`created_by`,
`created_time`,
`email`,
`is_deleted`,
`last_modified_by`,
`last_modified_time`,
`password`,
`user_name`,
`role_id`)
VALUES
(1, 0, "admin", "2018-08-24", "test@test.com", 0, "admin", "2018-08-24", "admin", "first", 1),
(2, 0, "admin", "2018-08-24", "test@test.com", 0, "admin", "2018-08-24", "admin", "second", 1),
(3, 0, "admin", "2018-08-24", "test@test.com", 0, "admin", "2018-08-24", "admin", "thrid", 1),
(4, 0, "admin", "2018-08-24", "test@test.com", 0, "admin", "2018-08-24", "admin", "fourth", 1);
