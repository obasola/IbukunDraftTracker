
DROP SCHEMA MyNFL;

CREATE SCHEMA IF NOT EXISTS `MyNFL` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `MyNFL` ;

-- -----------------------------------------------------
-- Table `MyNFL`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `conference` VARCHAR(3) NOT NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyNFL`.`Pick`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Pick` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `team_id` INT NULL,
  `selection_round` INT NULL,
  `selection_number` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Team_Pick_idx` (`team_id` ASC) VISIBLE,
  CONSTRAINT `fk_Team_Pick`
    FOREIGN KEY (`team_id`)
    REFERENCES `MyNFL`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyNFL`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `height` FLOAT NULL,
  `weight` FLOAT NULL,
  `hand_size` FLOAT NULL,
  `arm_length` FLOAT NULL,
  `home_city` VARCHAR(45) NULL,
  `home_state` VARCHAR(45) NULL,
  `university` VARCHAR(75) NULL,
  `selection_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Player_Pick_idx` (`selection_id` ASC) VISIBLE,
  CONSTRAINT `fk_Player_Pick`
    FOREIGN KEY (`selection_id`)
    REFERENCES `MyNFL`.`Pick` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyNFL`.`Combine_Score`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyNFL`.`Combine_Score` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `forty_time` FLOAT NULL,
  `ten_yard_split` FLOAT NULL,
  `twenty_yard_shuttle` FLOAT NULL,
  `three_cone` FLOAT NULL,
  `vertical_leap` FLOAT NULL,
  `broadjump` FLOAT NULL,
  `player_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Combine_Score_1_idx` (`player_id` ASC) VISIBLE,
  CONSTRAINT `fk_Combine_Score_1`
    FOREIGN KEY (`player_id`)
    REFERENCES `MyNFL`.`Player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
