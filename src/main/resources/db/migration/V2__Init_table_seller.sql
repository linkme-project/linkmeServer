CREATE TABLE `t_fundseller` (
	`user_Id` VARCHAR(50) NULL DEFAULT NULL,
	`bank_name` VARCHAR(50) NULL DEFAULT NULL,
	`bank_number` VARCHAR(50) NULL DEFAULT NULL,
	INDEX `FK_t_fundSeller_t_user` (`user_Id`),
	CONSTRAINT `FK_t_fundSeller_t_user` FOREIGN KEY (`user_Id`) REFERENCES `t_user` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
