CREATE DATABASE  IF NOT EXISTS `TatuajesAlvaroViejo`;
USE `TatuajesAlvaroViejo`;



/* 
	EMPLEADOS
*/

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados` (
  `codemp` varchar(20) NOT NULL,
  `nomem` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `aniosExp` int(11) NOT NULL,
  CONSTRAINT pk_empleados PRIMARY KEY (`codemp`)
);


INSERT INTO `empleados` VALUES 
('1','Alfonso','Ramirez',1),
('2','Lara','Pérez',2);


/* 
	CENTROS
*/
DROP TABLE IF EXISTS `centros`;
CREATE TABLE `centros` (
  `codcen` varchar(20) NOT NULL,
  `codemp` varchar(20) NOT NULL,
  `financiacion` int(20) NOT NULL,
  `cp` varchar(5) NOT NULL DEFAULT '00000',
  `ubicacion` varchar(20) NOT NULL,
  CONSTRAINT pk_centros PRIMARY KEY (`codcen`),
  CONSTRAINT fk_centros_empleados FOREIGN KEY (`codemp`) REFERENCES `empleados`(`codemp`)
	ON DELETE NO ACTION ON UPDATE CASCADE
  
);

INSERT INTO `centros` VALUES 
(1,1, 10000,'23330', 'C/ Larios'),
(2,2, 34590,'26510', 'AV/ Cristo');





/* 
	TATUAJES 
*/
DROP TABLE IF EXISTS `tatuajes`;
CREATE TABLE `tatuajes` (
  `codcen` varchar(20) NOT NULL,
  `estilo` varchar(20) NOT NULL,
  `precio` int(20) NOT NULL,
  `tiempo` varchar(20) NOT NULL,

  CONSTRAINT fk_tatuajes_centros FOREIGN KEY (`codcen`) REFERENCES `centros`(`codcen`)
	ON DELETE NO ACTION ON UPDATE CASCADE

);


INSERT INTO `tatuajes` VALUES 
(1,'blackwork',80,'1h'),
(1,'realista',235,'3h'),
(1,'tribal',39,'1h'),
(1,'old school',55,'1h'),
(1,'puntillismo',456,'6h'),
(2,'geometrico',632,'2d'),
(2,'trash polka',12,'48m'),
(2,'blanco',100,'2h'),
(2,'fluorescente',40,'50m');