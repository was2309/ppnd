/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.14-MariaDB : Database - ppnd_v5
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ppnd_v5` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ppnd_v5`;

/*Table structure for table `databasechangelog` */

DROP TABLE IF EXISTS `databasechangelog`;

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `databasechangelog` */

insert  into `databasechangelog`(`ID`,`AUTHOR`,`FILENAME`,`DATEEXECUTED`,`ORDEREXECUTED`,`EXECTYPE`,`MD5SUM`,`DESCRIPTION`,`COMMENTS`,`TAG`,`LIQUIBASE`,`CONTEXTS`,`LABELS`,`DEPLOYMENT_ID`) values 
('2','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:29',1,'EXECUTED','8:fbdf85cfe121b532d1d656bdbaef907d','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('3','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:29',2,'EXECUTED','8:9962d83a0ad81f23957fa356d8a182c8','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('4','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:29',3,'EXECUTED','8:9c54ea06214ecfa811f5c042b85270d2','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('5','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',4,'EXECUTED','8:abf12ade83b7edf3a747037469b24244','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('6','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',5,'EXECUTED','8:511f9053d26b4652b718691b1ce12b21','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('7','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',6,'EXECUTED','8:07f4113b8bb116f352f7aec4cbe89674','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('8','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',7,'EXECUTED','8:f83fa31c52d3f5b4be225d3c0ddd3c98','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('9','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',8,'EXECUTED','8:01a89f2ab94c716ab5fe42f3885689b6','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('10','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',9,'EXECUTED','8:8b011ee348dd9fea8252c0751706ee46','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('11','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',10,'EXECUTED','8:d3c1400f5ed37a497cf8298c94bb572d','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('12','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',11,'EXECUTED','8:a276b2854db94cee7a8df378f9fca531','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('13','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',12,'EXECUTED','8:5a124f38b1d881c835352a2105b44daa','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('14','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',13,'EXECUTED','8:b84a30502fd12355f3c18c433cda53c7','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('15','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',14,'EXECUTED','8:9e708e919d75e94a986e09f15eb6409b','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('16','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',15,'EXECUTED','8:eeeaa635189808c0c6a72fd13249bda8','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('17','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',16,'EXECUTED','8:05a5459120a11971b5954a22a249e163','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('18','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',17,'EXECUTED','8:4b00efe0658a857e62fc759af8e79306','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('19','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',18,'EXECUTED','8:f10fc2fc66e2b23d69788de50f14752c','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('20','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',19,'EXECUTED','8:5d8a3a8ef1660fe4c76e8d42e7381ef0','sql','',NULL,'4.9.1',NULL,NULL,'8585729557'),
('21','DocUser','classpath:db/changelog/db.changelog-master.sql','2022-07-23 16:15:30',20,'EXECUTED','8:d90023f4b8c9df6a34989a48eba2764d','sql','',NULL,'4.9.1',NULL,NULL,'8585729557');

/*Table structure for table `databasechangeloglock` */

DROP TABLE IF EXISTS `databasechangeloglock`;

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `databasechangeloglock` */

insert  into `databasechangeloglock`(`ID`,`LOCKED`,`LOCKGRANTED`,`LOCKEDBY`) values 
(1,'\0',NULL,NULL);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `department_name` varchar(80) DEFAULT NULL,
  `number_of_members` int(10) unsigned DEFAULT NULL,
  `department_type` varchar(20) NOT NULL,
  PRIMARY KEY (`department_id`),
  KEY `department_type_id` (`department_type`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `department` */

insert  into `department`(`department_id`,`department_name`,`number_of_members`,`department_type`) values 
(1,'Katedra za ekonomiju, poslovno planiranje i medjunarodni menadzment',2,'KATEDRA'),
(2,'Katedra za elektronsko poslovanje',4,'KATEDRA'),
(3,'Katedra za industrijsko i menadzment inzenjerstvo',5,'KATEDRA'),
(4,'Katedra za interdisciplinarna istrazivanja u menadzmentu',7,'KATEDRA'),
(5,'Katedra za informacione sisteme',4,'KATEDRA'),
(6,'Katedra za informacione tehnologije',3,'KATEDRA'),
(7,'Katedra za marketing menadzment i odnose s javnoscu',2,'KATEDRA'),
(8,'Katedra za matematiku',5,'KATEDRA'),
(9,'Katedra za menadzment i upravljanje projektima',13,'KATEDRA'),
(10,'Katedra za menadzment ljudskih resursa',2,'KATEDRA'),
(11,'Katedra za menadzment tehnologije, inovacija i odrzivog razvoja',6,'KATEDRA'),
(12,'Katedra za operaciona istrazivanja i statistiku',9,'KATEDRA'),
(13,'Katedra za organizaciju poslovnih sistema',11,'KATEDRA'),
(14,'Katedra za racunarski integrisanu proizvodnju i logistiku',4,'KATEDRA'),
(15,'Katedra za softversko inzenjerstvo',2,'KATEDRA'),
(16,'Katedra za menadzment kvaliteta i standardizaciju',3,'KATEDRA'),
(17,'Katedra za upravljanje proizvodnjom i pruzanjem uslugama',7,'KATEDRA'),
(18,'Katedra za finansijski menadzment i racunovodstvo',8,'KATEDRA'),
(19,'Katedra za upravljanje sistemima',2,'KATEDRA');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `education_title` varchar(20) NOT NULL,
  `department_id` bigint(20) unsigned DEFAULT NULL,
  `academic_title` varchar(255) DEFAULT NULL,
  `dtype` varchar(31) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `department_id` (`department_id`),
  KEY `education_title_id` (`education_title`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8mb4;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values 
(1,'Dusan','Starcevic','1946-07-22','DR',6,'PROF_EMERITUS','Lecturer'),
(2,'Nenad','Anicic','1962-08-22','DR',5,'REDOVNI_PROF','Lecturer'),
(3,'Sladjan','Babarogic','1967-07-22','DR',5,'REDOVNI_PROF','Lecturer'),
(4,'Dusan','Barac','1974-07-22','DR',2,'REDOVNI_PROF','Lecturer'),
(5,'Sladjana','Benkovic','1971-07-22','DR',18,'REDOVNI_PROF','Lecturer'),
(6,'Zorica','Bogdanovic','1975-07-22','DR',2,'REDOVNI_PROF','Lecturer'),
(7,'Vesna','Bogojevic-Arsic','1965-07-22','DR',18,'REDOVNI_PROF','Lecturer'),
(8,'Milica','Bulajic','1955-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(9,'Dragan','Vasiljevic','1963-07-22','DR',14,'REDOVNI_PROF','Lecturer'),
(10,'Sinisa','Vlajic','1959-07-22','DR',15,'REDOVNI_PROF','Lecturer'),
(11,'Dragan','Vukmirovic','1956-07-22','DR',2,'REDOVNI_PROF','Lecturer'),
(12,'Vesna','Damnjanovic','1979-07-22','DR',7,'REDOVNI_PROF','Lecturer'),
(13,'Vladan','Devedzic','1958-07-22','DR',15,'REDOVNI_PROF','Lecturer'),
(14,'Boris','Delibasic','1974-07-22','DR',13,'REDOVNI_PROF','Lecturer'),
(15,'Marijana','Despotovic-Zrakic','1964-07-22','DR',2,'REDOVNI_PROF','Lecturer'),
(16,'Dragan','Djuric','1976-07-22','DR',15,'REDOVNI_PROF','Lecturer'),
(17,'Nedeljko','Zivkovic','1973-07-22','DR',16,'REDOVNI_PROF','Lecturer'),
(18,'Bojan','Ilic','1968-07-22','DR',1,'REDOVNI_PROF','Lecturer'),
(19,'Radmila','Janicic','1965-07-22','DR',7,'REDOVNI_PROF','Lecturer'),
(20,'Ondrej','Jasko','1953-07-22','DR',13,'REDOVNI_PROF','Lecturer'),
(21,'Sandra','Jednak','1978-07-22','DR',1,'REDOVNI_PROF','Lecturer'),
(22,'Jelena','Jovanovic','1978-07-22','DR',15,'REDOVNI_PROF','Lecturer'),
(23,'Milica','Kostic-Stankovic','1967-07-22','DR',7,'REDOVNI_PROF','Lecturer'),
(24,'Dragana','Kragulj','1961-07-22','DR',1,'REDOVNI_PROF','Lecturer'),
(25,'Marija','Kuzmanovic','1965-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(26,'Sasa','Lazarevic','1965-07-22','DR',15,'REDOVNI_PROF','Lecturer'),
(27,'Danica','Lecic-Cvetkovic','1962-07-22','DR',17,'REDOVNI_PROF','Lecturer'),
(28,'Ivan','Lukovic','1967-07-22','DR',5,'REDOVNI_PROF','Lecturer'),
(29,'Dragana','Makajic-Nikolic','1972-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(30,'Zoran','Marjanovic','1969-07-22','DR',5,'REDOVNI_PROF','Lecturer'),
(31,'Aleksandar','Markovic','1959-07-22','DR',13,'REDOVNI_PROF','Lecturer'),
(32,'Milan','Martic','1956-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(33,'Ivana','Mijatovic','1961-07-22','DR',16,'REDOVNI_PROF','Lecturer'),
(34,'Slobodan','Miladinovic','1958-07-22','DR',10,'REDOVNI_PROF','Lecturer'),
(35,'Miroslav','Minovic','1973-07-22','DR',6,'REDOVNI_PROF','Lecturer'),
(36,'Marko','Mihic','1978-07-22','DR',9,'REDOVNI_PROF','Lecturer'),
(37,'Olivera','Mihic','1976-07-22','DR',8,'REDOVNI_PROF','Lecturer'),
(38,'Vladimir','Obradovic','1974-07-22','DR',4,'REDOVNI_PROF','Lecturer'),
(39,'Dejan','Petrovic','1972-07-22','DR',9,'REDOVNI_PROF','Lecturer'),
(40,'Natasa','Petrovic','1969-07-22','DR',11,'REDOVNI_PROF','Lecturer'),
(41,'Bozidar','Radenkovic','1955-07-22','DR',2,'REDOVNI_PROF','Lecturer'),
(42,'Zoran','Radojicic','1956-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(43,'Gordana','Savic','1969-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(44,'Dejan','Simic','1958-07-22','DR',10,'REDOVNI_PROF','Lecturer'),
(45,'Dragoslav','Slovic','1965-07-22','DR',3,'REDOVNI_PROF','Lecturer'),
(46,'Milan','Stanojevic','1973-07-22','DR',12,'REDOVNI_PROF','Lecturer'),
(47,'Milica','Stanojevic','1958-07-22','DR',8,'REDOVNI_PROF','Lecturer'),
(48,'Biljana','Stosic','1974-07-22','DR',11,'REDOVNI_PROF','Lecturer'),
(49,'Milija','Suknovic','1962-07-22','DR',13,'REDOVNI_PROF','Lecturer'),
(50,'Vesna','Todorcevic','1975-07-22','DR',8,'REDOVNI_PROF','Lecturer'),
(51,'Jovan','Filipovic','1969-07-22','DR',16,'REDOVNI_PROF','Lecturer'),
(52,'Slavica','Cicvaric Kostic','1976-07-22','DR',7,'REDOVNI_PROF','Lecturer'),
(53,'Mladen','Cudanov','1973-07-22','DR',13,'REDOVNI_PROF','Lecturer'),
(54,'Velimir','Stavljanin','1958-07-22','DR',7,'REDOVNI_PROF','Lecturer'),
(55,'Jelena','Andjelkovic Labrovic','1971-07-22','DR',10,'VANREDNI_PROF','Lecturer'),
(56,'Slobodan','Antic','1975-07-22','DR',17,'VANREDNI_PROF','Lecturer'),
(57,'Sladjana','Barjaktarovic Rakocevic','1981-07-22','DR',18,'VANREDNI_PROF','Lecturer'),
(58,'Tamara','Vlastelica','1984-07-22','DR',7,'VANREDNI_PROF','Lecturer'),
(59,'Milan','Vukicevic','1982-07-22','DR',13,'VANREDNI_PROF','Lecturer'),
(60,'Jovanka','Vukmirovic','1966-07-22','DR',7,'VANREDNI_PROF','Lecturer'),
(61,'Veljko','Dmitrovic','1979-07-22','DR',18,'VANREDNI_PROF','Lecturer'),
(62,'Ivana','Dragovic','1982-07-22','DR',19,'VANREDNI_PROF','Lecturer'),
(63,'Aleksandar','Djokovic','1972-07-22','DR',12,'VANREDNI_PROF','Lecturer'),
(64,'Lena','Djordjevic Milutinovic','1976-07-22','DR',17,'VANREDNI_PROF','Lecturer'),
(65,'Mladen','Djuric','1985-07-22','DR',16,'VANREDNI_PROF','Lecturer'),
(66,'Tatjana','Ivanovic','1988-07-22','DR',10,'VANREDNI_PROF','Lecturer'),
(67,'Marina','Ignjatovic','1986-07-22','DR',12,'VANREDNI_PROF','Lecturer'),
(68,'Milos','Jevtic','1978-07-22','DR',13,'VANREDNI_PROF','Lecturer'),
(69,'Veljko','Jeremic','1985-07-22','DR',12,'VANREDNI_PROF','Lecturer'),
(70,'Milos','Jovanovic','1987-07-22','DR',13,'VANREDNI_PROF','Lecturer'),
(71,'Predrag','Jovanovic','1980-07-22','DR',13,'VANREDNI_PROF','Lecturer'),
(72,'Marija','Jovic','1981-07-22','DR',7,'VANREDNI_PROF','Lecturer'),
(73,'Snezana','Knezevic','1975-07-22','DR',18,'VANREDNI_PROF','Lecturer'),
(74,'Ivana','Kovacevic','1980-07-22','DR',10,'VANREDNI_PROF','Lecturer'),
(75,'Aleksandra','Labus','1980-07-22','DR',2,'VANREDNI_PROF','Lecturer'),
(76,'Rade','Lazovic','1961-07-22','DR',8,'VANREDNI_PROF','Lecturer'),
(77,'Sanja','Marinkovic','1970-07-22','DR',11,'VANREDNI_PROF','Lecturer'),
(78,'Vidan','Markovic','1975-07-22','DR',5,'VANREDNI_PROF','Lecturer'),
(79,'Milos','Milovanovic','1982-07-22','DR',6,'VANREDNI_PROF','Lecturer'),
(80,'Milos','Milosavljevic','1986-07-22','DR',1,'VANREDNI_PROF','Lecturer'),
(81,'Nebojsa','Nikolic','1978-07-22','DR',8,'VANREDNI_PROF','Lecturer'),
(82,'Branka','Novcic Korac','1985-07-22','DR',7,'VANREDNI_PROF','Lecturer'),
(83,'Tijana','Obradovic','1984-07-22','DR',18,'VANREDNI_PROF','Lecturer'),
(84,'Biljana','Panic','1975-07-22','DR',12,'VANREDNI_PROF','Lecturer'),
(85,'Ognjen','Pantelic','1980-07-22','DR',5,'VANREDNI_PROF','Lecturer'),
(86,'Gordana','Pejovic','1978-07-22','DR',16,'VANREDNI_PROF','Lecturer'),
(87,'Jasna','Petkovic','1975-07-22','DR',11,'VANREDNI_PROF','Lecturer'),
(88,'Ana','Poledica','1982-07-22','DR',19,'VANREDNI_PROF','Lecturer'),
(89,'Dusan','Savic','1980-07-22','DR',15,'VANREDNI_PROF','Lecturer'),
(90,'Barbara','Simeunovic','1975-07-22','DR',3,'VANREDNI_PROF','Lecturer'),
(91,'Marija','Todorovic','1984-07-22','DR',9,'VANREDNI_PROF','Lecturer'),
(92,'Ivan','Tomasevic','1981-07-22','DR',3,'VANREDNI_PROF','Lecturer'),
(93,'Bojan','Tomic','1982-07-22','DR',15,'VANREDNI_PROF','Lecturer'),
(94,'Zoran','Sevarac','1983-07-22','DR',15,'VANREDNI_PROF','Lecturer'),
(95,'Bisera','Andric Gusavac','1980-07-22','DR',12,'DOCENT','Lecturer'),
(96,'Jelena','Andjelkovic','1978-07-22','DR',10,'DOCENT','Lecturer'),
(97,'Ilija','Antovic','1985-07-22','DR',15,'DOCENT','Lecturer'),
(98,'Srdja','Bjeladinovic','1984-07-22','DR',5,'DOCENT','Lecturer'),
(99,'Dragan','Bjelica','1982-07-22','DR',9,'DOCENT','Lecturer'),
(100,'Marija','Bogicevic Sretenovic','1984-07-22','MSA',6,'DOCENT','Lecturer'),
(101,'Marija','Boricic Joksimovic','1985-07-22','DR',8,'DOCENT','Lecturer'),
(102,'Maja','Glogovac','1987-07-22','DR',16,'DOCENT','Lecturer'),
(103,'Milos','Danilovic','1984-07-22','DR',14,'DOCENT','Lecturer'),
(104,'Bojan','Jovanovic','1982-07-22','DR',6,'DOCENT','Lecturer'),
(105,'Ana','Kicanovic','1985-07-22','DR',16,'DOCENT','Lecturer'),
(106,'Stefan','Komazec','1987-07-22','DR',13,'DOCENT','Lecturer'),
(107,'Jovan','Krivokapic','1985-07-22','DR',13,'DOCENT','Lecturer'),
(108,'Djordje','Krivokapic','1987-07-22','DR',13,'DOCENT','Lecturer'),
(109,'Milica','Latinovic','1982-07-22','DR',18,'DOCENT','Lecturer'),
(110,'Milica','Maricic','1989-07-22','DR',12,'DOCENT','Lecturer'),
(111,'Ivan','Milenkovic','1988-07-22','DR',6,'DOCENT','Lecturer'),
(112,'Nemanja','Milenkovic','1987-07-22','MSA',12,'DOCENT','Lecturer'),
(113,'Milos','Milic','1985-07-22','DR',15,'DOCENT','Lecturer'),
(114,'Tanja','Milic','1982-07-22','DR',1,'DOCENT','Lecturer'),
(115,'Pavle','Milosevic','1987-07-22','DR',19,'DOCENT','Lecturer'),
(116,'Radul','Milutinovic','1985-07-22','MSA',11,'DOCENT','Lecturer'),
(117,'Zorica','Mitrovic','1988-07-22','DR',9,'DOCENT','Lecturer'),
(118,'Milan','Okanovic','1987-07-22','DR',7,'DOCENT','Lecturer'),
(119,'Marko','Petrovic','1985-07-22','DR',5,'DOCENT','Lecturer'),
(120,'Milena','Popovic','1982-07-22','DR',12,'DOCENT','Lecturer'),
(121,'Sandro','Radovanovic','1989-07-22','MSA',13,'DOCENT','Lecturer'),
(122,'Ana','Rakic','1982-07-22','DR',16,'DOCENT','Lecturer'),
(123,'Aleksandar','Rakicevic','1988-07-22','DR',19,'DOCENT','Lecturer'),
(124,'Zoran','Rakicevic','1986-07-22','DR',17,'DOCENT','Lecturer'),
(125,'Dragana','Stojanovic','1983-07-22','DR',3,'DOCENT','Lecturer'),
(126,'Nina','Turajlic','1986-07-22','DR',5,'DOCENT','Lecturer'),
(127,'Marko','Cirovic','1982-07-22','DR',11,'DOCENT','Lecturer'),
(128,'Biljana','Cvetic','1985-07-22','DR',14,'DOCENT','Lecturer'),
(129,'Milan','Radojicic','1987-07-22','DR',12,'ASISTENT_SA_DOKTORATOM','Lecturer'),
(130,'Jelena','Ruso','1989-07-22','DR',16,'ASISTENT_SA_DOKTORATOM','Lecturer'),
(131,'Marija','Mersnik','1985-07-22','DR',10,'NASTAVNIK_STRANOG_JEZIKA','Lecturer'),
(132,'Vukasin','Brkovic','1992-07-22','MSA',8,'ASISTENT','Lecturer'),
(133,'Jelena','Djordjevic','1975-07-22','MSA',8,'ASISTENT','Lecturer'),
(134,'Ivona','Zivkovic','1991-07-22','MSA',10,'ASISTENT','Lecturer'),
(135,'Nikola','Zornic','1995-07-22','MSA',13,'ASISTENT','Lecturer'),
(136,'Olga','Jejic','1996-07-22','MSA',5,'ASISTENT','Lecturer'),
(137,'Milica','Jovanovic','1990-07-22','MSA',11,'ASISTENT','Lecturer'),
(138,'Ivona','Jovanovic','1994-07-22','MSA',3,'ASISTENT','Lecturer'),
(139,'Jovana','Jovic','1993-07-22','MSA',10,'ASISTENT','Lecturer'),
(140,'Stefan','Krstovic','1996-07-22','MSA',5,'ASISTENT','Lecturer'),
(141,'Ivana','Kuzet','1996-07-22','MSA',10,'ASISTENT','Lecturer'),
(142,'Petar','Lakcevic','1997-07-22','MSA',15,'ASISTENT','Lecturer'),
(143,'Bojan','Marceta','1984-07-22','MSA',6,'ASISTENT','Lecturer'),
(144,'Tamara','Naumovic','1994-07-22','MSA',2,'ASISTENT','Lecturer'),
(145,'Dejana','Nikolic','1995-07-22','MSA',7,'ASISTENT','Lecturer'),
(146,'Nikola','Petrovic','1996-07-22','MSA',10,'ASISTENT','Lecturer'),
(147,'Teodora','Rajkovic','1990-07-22','MSA',17,'ASISTENT','Lecturer'),
(148,'Nela','Rakic','1990-07-22','MSA',18,'ASISTENT','Lecturer'),
(149,'Jovana','Rakicevic','1993-07-22','MSA',11,'ASISTENT','Lecturer'),
(150,'Zeljko','Spasenic','1993-07-22','MSA',18,'ASISTENT','Lecturer'),
(151,'Jelica','Stanojevic','1996-07-22','MSA',6,'ASISTENT','Lecturer'),
(152,'Tatjana','Stojanovic','1994-07-22','MSA',15,'ASISTENT','Lecturer'),
(153,'Filip','Furtula','1996-07-22','MSA',5,'ASISTENT','Lecturer'),
(154,'Nikola','Cvetkovic','1994-07-22','MSA',12,'ASISTENT','Lecturer'),
(155,'Andrijana','Dzamic','1993-07-22','MSA',12,'ASISTENT','Lecturer'),
(156,'Milica','Skembarevic','1996-07-22','MSA',5,'ASISTENT','Lecturer'),
(157,'Ognjen','Andjelic','1997-07-22','DIPL',17,'SARADNIK_U_NASTAVI','Lecturer'),
(158,'Vladimir','Belca','1997-07-22','DIPL',5,'SARADNIK_U_NASTAVI','Lecturer'),
(159,'Andjelija','Djordjevic','1998-07-22','DIPL',9,'SARADNIK_U_NASTAVI','Lecturer'),
(160,'Andjela','Djordjevic','1997-07-22','DIPL',14,'SARADNIK_U_NASTAVI','Lecturer'),
(161,'Predrag','Imsic','1997-07-22','DIPL',5,'SARADNIK_U_NASTAVI','Lecturer'),
(162,'Djordje','Jovanovic','1996-07-22','DIPL',9,'SARADNIK_U_NASTAVI','Lecturer'),
(163,'Branko','Krsmanovic','1997-07-22','DIPL',5,'SARADNIK_U_NASTAVI','Lecturer'),
(164,'Petar','Lukovac','1998-07-22','DIPL',2,'SARADNIK_U_NASTAVI','Lecturer'),
(165,'Dusan','Mitrovic','1997-07-22','DIPL',6,'SARADNIK_U_NASTAVI','Lecturer'),
(166,'Andrea','Nikolic','1996-07-22','DIPL',13,'SARADNIK_U_NASTAVI','Lecturer'),
(167,'Petar','Stanimirovic','1997-07-22','DIPL',9,'SARADNIK_U_NASTAVI','Lecturer'),
(168,'Selena','Stanojevic','1997-07-22','DIPL',7,'SARADNIK_U_NASTAVI','Lecturer'),
(169,'Biljana','Tosic','1997-07-22','DIPL',16,'SARADNIK_U_NASTAVI','Lecturer');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(21);

/*Table structure for table `lecturing` */

DROP TABLE IF EXISTS `lecturing`;

CREATE TABLE `lecturing` (
  `lecturing_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `teaching_coverage_plan_id` bigint(20) unsigned NOT NULL,
  `teaching_form` varchar(25) DEFAULT NULL,
  `number_of_classes` int(10) unsigned DEFAULT NULL,
  `lecturer_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`lecturing_id`),
  KEY `lecturing_id` (`lecturing_id`),
  KEY `teaching_coverage_plan_id` (`teaching_coverage_plan_id`),
  KEY `lecturer_id` (`lecturer_id`),
  CONSTRAINT `lecturing_ibfk_4` FOREIGN KEY (`teaching_coverage_plan_id`) REFERENCES `teaching_coverage_plan` (`teaching_coverage_plan_id`),
  CONSTRAINT `lecturing_ibfk_5` FOREIGN KEY (`lecturer_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `lecturing` */

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `module_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `study_program_id` bigint(20) unsigned NOT NULL,
  `module_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`module_id`),
  KEY `module_id` (`module_id`),
  KEY `study_program_id` (`study_program_id`),
  CONSTRAINT `module_ibfk_2` FOREIGN KEY (`study_program_id`) REFERENCES `study_program` (`study_program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `module` */

insert  into `module`(`module_id`,`study_program_id`,`module_name`) values 
(1,1,'Informacione tehnologije'),
(2,1,'Informacioni sistemi'),
(3,1,'Informaciono inzenjerstvo'),
(4,1,'Poslovna analitika'),
(5,1,'Softversko inzenjerstvo'),
(6,1,'Tehnologije elektronskog poslovanja'),
(7,2,'Finansijski menadzment'),
(8,2,'Lin organizacija poslovanja'),
(9,2,'Marketing menadzment i komunikacije'),
(10,2,'Menadzment kvaliteta i standardizacija'),
(11,2,'Operacioni menadzment'),
(12,2,'Projektni menadzment');

/*Table structure for table `module_subject` */

DROP TABLE IF EXISTS `module_subject`;

CREATE TABLE `module_subject` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `module_id` bigint(20) unsigned NOT NULL,
  `subject_id` bigint(20) unsigned NOT NULL,
  `semester` int(10) unsigned DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `subject_type` varchar(15) DEFAULT NULL,
  `num_of_espb` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `module_id` (`module_id`,`subject_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `module_subject_ibfk_4` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`),
  CONSTRAINT `module_subject_ibfk_5` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `module_subject` */

/*Table structure for table `study_program` */

DROP TABLE IF EXISTS `study_program`;

CREATE TABLE `study_program` (
  `study_program_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `study_program_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`study_program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `study_program` */

insert  into `study_program`(`study_program_id`,`study_program_name`) values 
(1,'Informacioni sistemi i tehnologije'),
(2,'Menadzment i organizacija');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `subject_id` bigint(20) unsigned NOT NULL,
  `subject_name` varchar(100) DEFAULT NULL,
  `department_id` bigint(20) unsigned NOT NULL,
  `excercises_per_week` int(11) DEFAULT NULL,
  `lectures_per_week` int(11) DEFAULT NULL,
  `lab_excercises_per_week` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `subject` */

insert  into `subject`(`subject_id`,`subject_name`,`department_id`,`excercises_per_week`,`lectures_per_week`,`lab_excercises_per_week`) values 
(17,'Projektovanje softvera',15,1,2,1),
(20,'Napredne java tehnologije',15,1,2,1);

/*Table structure for table `teaching_coverage_plan` */

DROP TABLE IF EXISTS `teaching_coverage_plan`;

CREATE TABLE `teaching_coverage_plan` (
  `teaching_coverage_plan_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `year_id` bigint(20) unsigned NOT NULL,
  `module_subject_id` bigint(20) unsigned NOT NULL,
  `id` bigint(20) NOT NULL,
  `number_of_classes` int(11) NOT NULL,
  `teaching_form` varchar(255) DEFAULT NULL,
  `lecturer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`teaching_coverage_plan_id`),
  KEY `year_id` (`year_id`),
  KEY `module_subject_id` (`module_subject_id`),
  CONSTRAINT `teaching_coverage_plan_ibfk_6` FOREIGN KEY (`year_id`) REFERENCES `year` (`year_id`),
  CONSTRAINT `teaching_coverage_plan_ibfk_7` FOREIGN KEY (`module_subject_id`) REFERENCES `module_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `teaching_coverage_plan` */

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_profile` */

/*Table structure for table `year` */

DROP TABLE IF EXISTS `year`;

CREATE TABLE `year` (
  `year_id` bigint(20) unsigned NOT NULL,
  `study_year` varchar(9) DEFAULT NULL,
  `study_program_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`year_id`),
  KEY `study_program_id` (`study_program_id`),
  CONSTRAINT `year_ibfk_1` FOREIGN KEY (`study_program_id`) REFERENCES `study_program` (`study_program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `year` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
