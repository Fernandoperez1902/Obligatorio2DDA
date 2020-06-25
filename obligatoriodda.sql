/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.30-log : Database - obligatoriodda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`obligatoriodda` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `obligatoriodda`;

/*Table structure for table `administrador` */

DROP TABLE IF EXISTS `administrador`;

CREATE TABLE `administrador` (
  `oidAdministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `administrador` */

insert  into `administrador`(`oidAdministrador`) values 
(4),
(5);

/*Table structure for table `apuesta` */

DROP TABLE IF EXISTS `apuesta`;

CREATE TABLE `apuesta` (
  `oid` int(11) NOT NULL,
  `oidJugador` int(11) NOT NULL,
  `oidParticipante` int(11) NOT NULL,
  `oidCarrera` int(11) NOT NULL,
  `montoApostado` float NOT NULL,
  `montoPagado` float NOT NULL,
  `montoGanado` float NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `apuesta` */

/*Table structure for table `caballo` */

DROP TABLE IF EXISTS `caballo`;

CREATE TABLE `caballo` (
  `oid` int(11) NOT NULL,
  `nombreCaballo` varchar(90) DEFAULT NULL,
  `nombreResponsable` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `caballo` */

insert  into `caballo`(`oid`,`nombreCaballo`,`nombreResponsable`) values 
(10,'Caballo 1','Dueño del Caballo 1'),
(11,'Caballo 2','Dueño del Caballo 2'),
(12,'Caballo 3','Dueño del Caballo 3'),
(13,'Caballo 4','Dueño del Caballo 4'),
(14,'Caballo 5','Dueno del Caballo 5'),
(15,'Caballo 6','Dueño del Caballo 6'),
(16,'Caballo 7','Dueño del Caballo 7'),
(17,'Caballo 8','Dueño del Caballo 8');

/*Table structure for table `carrera` */

DROP TABLE IF EXISTS `carrera`;

CREATE TABLE `carrera` (
  `oid` int(11) NOT NULL,
  `numeroCarrera` int(11) NOT NULL,
  `oidJornada` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `nombreCarrera` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `carrera` */

/*Table structure for table `hipodromo` */

DROP TABLE IF EXISTS `hipodromo`;

CREATE TABLE `hipodromo` (
  `oid` int(11) NOT NULL,
  `nombre` varchar(90) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hipodromo` */

insert  into `hipodromo`(`oid`,`nombre`,`direccion`) values 
(1,'Hipodromo1','Direccion de Hipodromo 1'),
(2,'Hipodromo2','Direccion de Hipodromo 2'),
(5,'Hipodromo3','Direccion de Hipodromo 3');

/*Table structure for table `jornada` */

DROP TABLE IF EXISTS `jornada`;

CREATE TABLE `jornada` (
  `oid` int(11) NOT NULL,
  `fechaJornada` datetime NOT NULL,
  `oidHipodromo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jornada` */

/*Table structure for table `jugador` */

DROP TABLE IF EXISTS `jugador`;

CREATE TABLE `jugador` (
  `oidJugador` int(11) NOT NULL,
  `saldo` float DEFAULT NULL,
  `oidApuesta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jugador` */

insert  into `jugador`(`oidJugador`,`saldo`,`oidApuesta`) values 
(6,1000,NULL),
(7,500,NULL),
(8,100,NULL),
(9,50,NULL);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `ultimo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `oid` */

insert  into `oid`(`ultimo`) values 
(100);

/*Table structure for table `participante` */

DROP TABLE IF EXISTS `participante`;

CREATE TABLE `participante` (
  `oid` int(11) NOT NULL,
  `oidCarrera` int(11) NOT NULL,
  `oidCaballo` int(11) NOT NULL,
  `numeroParticipante` int(11) NOT NULL,
  `dividendo` double NOT NULL,
  `ganador` tinyint(1) NOT NULL,
  `modalidad` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `participante` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `oid` int(11) NOT NULL,
  `nombreUsuario` varchar(90) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  `nombreCompleto` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`oid`,`nombreUsuario`,`password`,`nombreCompleto`) values 
(4,'X','X','Administrador X'),
(5,'Y','Y','Administrador Y'),
(6,'A','A','Jugador A'),
(7,'B','B','Jugador B'),
(8,'C','C','Jugador C'),
(9,'D','D','Jugador D');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
