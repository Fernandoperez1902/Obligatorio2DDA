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
(1);

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
(3,'Caballo X','Dueño del Caballo X'),
(4,'Caballo Y','Dueño del Caballo Y'),
(5,'Caballo Z','Dueño del Caballo Z'),
(6,'Caballo U','Dueño del Caballo U');

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
(10,'Hipodromo1','Direccion de Hipodromo 1'),
(11,'Hipodromo 2','Direccion de Hipodromo 2'),
(12,'Hipodromo 3','Direccion de Hipodromo 3');

/*Table structure for table `jornada` */

DROP TABLE IF EXISTS `jornada`;

CREATE TABLE `jornada` (
  `oid` int(11) NOT NULL,
  `fechaJornada` datetime NOT NULL,
  `oidHipodromo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jornada` */

insert  into `jornada`(`oid`,`fechaJornada`,`oidHipodromo`) values 
(41,'2020-06-21 00:00:00',41),
(43,'2020-06-21 00:00:00',43),
(46,'2020-06-21 00:00:00',46),
(49,'2020-06-21 00:00:00',49),
(52,'2020-06-21 00:00:00',52),
(55,'2020-06-21 00:00:00',55),
(57,'2020-06-21 00:00:00',57),
(60,'2020-06-21 00:00:00',60);

/*Table structure for table `jugador` */

DROP TABLE IF EXISTS `jugador`;

CREATE TABLE `jugador` (
  `oidJugador` int(11) NOT NULL,
  `saldo` float DEFAULT NULL,
  `oidApuesta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jugador` */

insert  into `jugador`(`oidJugador`,`saldo`,`oidApuesta`) values 
(2,150,NULL);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `ultimo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `oid` */

insert  into `oid`(`ultimo`) values 
(62);

/*Table structure for table `participante` */

DROP TABLE IF EXISTS `participante`;

CREATE TABLE `participante` (
  `oid` int(11) NOT NULL,
  `oidCarrera` int(11) NOT NULL,
  `oidCaballo` int(11) NOT NULL,
  `numeroParticipante` int(11) NOT NULL,
  `dividendo` double NOT NULL,
  `ganador` tinyint(1) NOT NULL
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
(1,'X1','X1','Administrador X'),
(2,'J','J','Jugador X');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
