-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema MyNFL
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MyNFL` ;

-- -----------------------------------------------------
-- Schema MyNFL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MyNFL` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `MyNFL` ;

-- -----------------------------------------------------
-- Table `MyNFL`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `conference` VARCHAR(35) NOT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `MyNFL`.`Pick`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Pick` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `teamId` INT NULL DEFAULT NULL,
  `selectionRound` INT NULL DEFAULT NULL,
  `selectionNumber` INT NULL DEFAULT NULL,
  `selectionYear` DATE NULL DEFAULT NULL,
  `selectionPickFrom` VARCHAR(45) NULL DEFAULT NULL,
  `selectionPickTo` VARCHAR(45) NULL DEFAULT NULL,
  `combineScore` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Team_Pick_idx` (`teamId` ASC) VISIBLE,
  CONSTRAINT `fk_Team_Pick`
    FOREIGN KEY (`teamId`)
    REFERENCES `MyNFL`.`Team` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `MyNFL`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `height` FLOAT NULL DEFAULT NULL,
  `weight` FLOAT NULL DEFAULT NULL,
  `handSize` FLOAT NULL DEFAULT NULL,
  `armLength` FLOAT NULL DEFAULT NULL,
  `homeCity` VARCHAR(45) NULL DEFAULT NULL,
  `homeState` VARCHAR(45) NULL DEFAULT NULL,
  `university` VARCHAR(75) NULL DEFAULT NULL,
  `selectionId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Player_Pick_idx` (`selectionId` ASC) VISIBLE,
  CONSTRAINT `fk_Player_Pick`
    FOREIGN KEY (`selectionId`)
    REFERENCES `MyNFL`.`Pick` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `MyNFL`.`CombineScore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`CombineScore` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fortyTime` FLOAT NULL DEFAULT NULL,
  `tenYardSplit` FLOAT NULL DEFAULT NULL,
  `twentyYardShuttle` FLOAT NULL DEFAULT NULL,
  `threeCone` FLOAT NULL DEFAULT NULL,
  `verticalLeap` FLOAT NULL DEFAULT NULL,
  `broadJump` FLOAT NULL DEFAULT NULL,
  `playerId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Combine_Score_1_idx` (`playerId` ASC) VISIBLE,
  CONSTRAINT `fk_Combine_Score_1`
    FOREIGN KEY (`playerId`)
    REFERENCES `MyNFL`.`Player` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `MyNFL`.`Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `teamId` INT NOT NULL,
  `opponentId` INT NOT NULL,
  `scheduleWeek` INT NULL,
  `gameDate` DATE NULL,
  `gameCity` VARCHAR(45) NULL,
  `gameStateProvince` VARCHAR(45) NULL,
  `gameCountry` VARCHAR(45) NULL,
  `gameLocation` VARCHAR(75) NULL,
  `opponentConference` VARCHAR(45) NULL,
  `opponentDivision` VARCHAR(45) NULL,
  `wonLostFlag` VARCHAR(1) NULL,
  `homeOrAway` VARCHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Team_Schedule_idx` (`teamId` ASC) VISIBLE,
  CONSTRAINT `fk_Team_Schedule`
    FOREIGN KEY (`teamId`)
    REFERENCES `MyNFL`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

