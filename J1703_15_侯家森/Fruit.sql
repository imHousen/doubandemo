/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.50 : Database - fruit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fruit` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `fruit`;

/*Table structure for table `fruitm` */

DROP TABLE IF EXISTS `fruitm`;

CREATE TABLE `fruitm` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `unitPrice` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `remarks` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `fruitname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `placeofOrign` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `fruitm` */

insert  into `fruitm`(`number`,`unitPrice`,`remarks`,`fruitname`,`placeofOrign`) values 
(18,'1','4','2','1');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`userName`,`Password`,`email`) values 
(35,'1','111111','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
