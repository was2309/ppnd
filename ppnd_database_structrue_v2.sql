/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.14-MariaDB : Database - ppnd_v2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ppnd_v2` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ppnd_v2`;

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
('1','Liquibase','classpath:db/changelog/db.changelog-master.yaml','2022-07-17 13:41:53',1,'EXECUTED','8:4c7fab90d227995218b8ba05c63d63e7','createTable tableName=test_table','',NULL,'4.9.1',NULL,NULL,'8058112891'),
('raw','includeAll','classpath:db/changelog/db.changelog-master.sql','2022-07-17 19:03:13',2,'EXECUTED','8:52cbeda78aa318c6c52e09bf519710bc','sql','',NULL,'4.9.1',NULL,NULL,'8077393529');

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
(2,'Katedra za ekonomiju, poslovno planiranje i medjunarodni menadzment',NULL,'KATEDRA'),
(3,'Katedra za elektronsko poslovanje',NULL,'KATEDRA'),
(4,'Katedra za industrijsko i menadzment inzenjerstvo',NULL,'KATEDRA'),
(5,'Katedra za interdisciplinarna istrazivanja u menadzmentu',NULL,'KATEDRA'),
(6,'Katedra za informacione sisteme',NULL,'KATEDRA'),
(7,'Katedra za informacione tehnologije',NULL,'KATEDRA'),
(8,'Katedra za marketing menadzment i odnose s javnoscu',NULL,'KATEDRA'),
(9,'Katedra za matematiku',NULL,'KATEDRA'),
(10,'Katedra za menadzment i upravljanje projektima',NULL,'KATEDRA'),
(11,'Katedra za menadzment ljudskih resursa',NULL,'KATEDRA'),
(12,'Katedra za menadzment tehnologije, inovacija i odrzivog razvoja',NULL,'KATEDRA'),
(13,'Katedra za operaciona istrazivanja i statistiku',NULL,'KATEDRA'),
(14,'Katedra za organizaciju poslovnih sistema',NULL,'KATEDRA'),
(15,'Katedra za racunarski integrisanu proizvodnju i logistiku',NULL,'KATEDRA'),
(16,'Katedra za softversko inzenjerstvo',NULL,'KATEDRA'),
(17,'Katedra za menadzment kvaliteta i standardizaciju',NULL,'KATEDRA'),
(18,'Katedra za upravljanje proizvodnjom i pruzanjem uslugama',NULL,'KATEDRA'),
(19,'Katedra za finansijski menadzment i racunovodstvo',NULL,'KATEDRA'),
(20,'Katedra za upravljanje sistemima',NULL,'KATEDRA');

/*Table structure for table `department_employees` */

DROP TABLE IF EXISTS `department_employees`;

CREATE TABLE `department_employees` (
  `department_department_id` bigint(20) NOT NULL,
  `employees_employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`department_department_id`,`employees_employee_id`),
  UNIQUE KEY `UK_9obuvdw21kpr3leh3g0k11j6` (`employees_employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `department_employees` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `employee` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `module` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `study_program` */

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `subject_id` bigint(20) unsigned NOT NULL,
  `subject_name` varchar(100) DEFAULT NULL,
  `number_of_espb` int(11) DEFAULT NULL,
  `department_id` bigint(20) unsigned NOT NULL,
  `id` bigint(20) NOT NULL,
  `excercies_per_week` int(11) NOT NULL,
  `lab_excercises_per_week` int(11) NOT NULL,
  `lecutres_per_week` int(11) NOT NULL,
  `excercises_per_week` int(11) DEFAULT NULL,
  `lectures_per_week` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `subject` */

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
