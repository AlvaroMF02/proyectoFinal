-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ProyectoProgAlvaro
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProyectoProgAlvaro
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProyectoProgAlvaro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ProyectoProgAlvaro` ;

-- -----------------------------------------------------
-- Table `ProyectoProgAlvaro`.`empleados`
-- -----------------------------------------------------
DROP TABLE IF exists empleados;
CREATE TABLE IF NOT EXISTS `ProyectoProgAlvaro`.`empleados` (
  `codemp` VARCHAR(20) NOT NULL,
  `nomem` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `aniosExp` INT NOT NULL,
  PRIMARY KEY (`codemp`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ProyectoProgAlvaro`.`centros`
-- -----------------------------------------------------
DROP TABLE IF exists centros;
CREATE TABLE IF NOT EXISTS `ProyectoProgAlvaro`.`centros` (
  `codcen` VARCHAR(20) NOT NULL,
  `financiacion` INT NOT NULL,
  `cp` VARCHAR(5) NOT NULL DEFAULT '00000',
  `ubicacion` VARCHAR(20) NOT NULL,
  `empleados_codemp` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codcen`),
  INDEX `fk_centros_empleados1_idx` (`empleados_codemp` ASC) VISIBLE,
  CONSTRAINT `fk_centros_empleados1`
    FOREIGN KEY (`empleados_codemp`)
    REFERENCES `ProyectoProgAlvaro`.`empleados` (`codemp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ProyectoProgAlvaro`.`tatuajes`
-- -----------------------------------------------------
DROP TABLE IF exists tatuajes;
CREATE TABLE IF NOT EXISTS `ProyectoProgAlvaro`.`tatuajes` (
  `codcen` VARCHAR(20) NOT NULL,
  `estilo` VARCHAR(20) NOT NULL,
  `precio` INT NOT NULL,
  `tiempo` VARCHAR(20) NOT NULL,
  INDEX `fk_tatuajes_centros` (`codcen` ASC) VISIBLE,
  CONSTRAINT `fk_tatuajes_centros`
    FOREIGN KEY (`codcen`)
    REFERENCES `ProyectoProgAlvaro`.`centros` (`codcen`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
