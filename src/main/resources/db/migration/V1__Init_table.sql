-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema linkme
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema linkme
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `linkme` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `linkme` ;

CREATE TABLE IF NOT EXISTS `t_user` (
    `id` VARCHAR(50) NOT NULL,
    `passwd` VARCHAR(50) NULL DEFAULT NULL,
    `email` VARCHAR(50) NULL DEFAULT NULL,
    `userType` VARCHAR(32) NULL DEFAULT NULL,
    `privateKey` VARCHAR(4096) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS `t_guaranteeFund` (
    `user_id` VARCHAR(50) NULL DEFAULT NULL,
    `bank_name` VARCHAR(50) NULL DEFAULT NULL,
    `bank_number` VARCHAR(50) NULL DEFAULT NULL,
    INDEX `FK_t_guaranteeFund_t_user` (`user_id`),
    CONSTRAINT `FK_t_guaranteeFund_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS `t_directFund` (
    `user_id` VARCHAR(50) NULL DEFAULT NULL,
    `phone_num` VARCHAR(50) NULL DEFAULT NULL,
    `social_security_num` VARCHAR(50) NULL DEFAULT NULL,
    INDEX `FK_t_directFund_t_user` (`user_id`),
    CONSTRAINT `FK_t_directFund_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

