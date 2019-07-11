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

CREATE TABLE `t_user` (
	`id` VARCHAR(50) NULL,
	`pw` VARCHAR(50) NULL
)
COLLATE='utf8_general_ci'
;

