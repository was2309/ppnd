--liquibase formatted sql



-- changeset DocUser:2
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




-- changeset DocUser:3
/*Table structure for table `databasechangeloglock` */

DROP TABLE IF EXISTS `databasechangeloglock`;

CREATE TABLE `databasechangeloglock` (
                                         `ID` int(11) NOT NULL,
                                         `LOCKED` bit(1) NOT NULL,
                                         `LOCKGRANTED` datetime DEFAULT NULL,
                                         `LOCKEDBY` varchar(255) DEFAULT NULL,
                                         PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- changeset DocUser:4
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



-- /*Table structure for table `department_employees` */
--
-- DROP TABLE IF EXISTS `department_employees`;
--
-- CREATE TABLE `department_employees` (
--                                         `department_department_id` bigint(20) NOT NULL,
--                                         `employees_employee_id` bigint(20) NOT NULL,
--                                         PRIMARY KEY (`department_department_id`,`employees_employee_id`),
--                                         UNIQUE KEY `UK_9obuvdw21kpr3leh3g0k11j6` (`employees_employee_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- /*Data for the table `department_employees` */


-- changeset DocUser:5
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

-- changeset DocUser:6
/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values
    (1);

-- changeset DocUser:7
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

-- changeset DocUser:8
/*Table structure for table `study_program` */

DROP TABLE IF EXISTS `study_program`;

CREATE TABLE `study_program` (
                                 `study_program_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                 `study_program_name` varchar(80) DEFAULT NULL,
                                 PRIMARY KEY (`study_program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- changeset DocUser:9
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


-- changeset DocUser:10
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


-- changeset DocUser:11
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


-- changeset DocUser:12
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

-- changeset DocUser:13
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


-- changeset DocUser:14
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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- changeset DocUser:15
insert  into `department`(`department_id`,`department_name`,`number_of_members`,`department_type`) values
                                                                                                       (1,'Katedra za ekonomiju, poslovno planiranje i medjunarodni menadzment',NULL,'KATEDRA'),
                                                                                                       (2,'Katedra za elektronsko poslovanje',NULL,'KATEDRA'),
                                                                                                       (3,'Katedra za industrijsko i menadzment inzenjerstvo',NULL,'KATEDRA'),
                                                                                                       (4,'Katedra za interdisciplinarna istrazivanja u menadzmentu',NULL,'KATEDRA'),
                                                                                                       (5,'Katedra za informacione sisteme',NULL,'KATEDRA'),
                                                                                                       (6,'Katedra za informacione tehnologije',NULL,'KATEDRA'),
                                                                                                       (7,'Katedra za marketing menadzment i odnose s javnoscu',NULL,'KATEDRA'),
                                                                                                       (8,'Katedra za matematiku',NULL,'KATEDRA'),
                                                                                                       (9,'Katedra za menadzment i upravljanje projektima',NULL,'KATEDRA'),
                                                                                                       (10,'Katedra za menadzment ljudskih resursa',NULL,'KATEDRA'),
                                                                                                       (11,'Katedra za menadzment tehnologije, inovacija i odrzivog razvoja',NULL,'KATEDRA'),
                                                                                                       (12,'Katedra za operaciona istrazivanja i statistiku',NULL,'KATEDRA'),
                                                                                                       (13,'Katedra za organizaciju poslovnih sistema',NULL,'KATEDRA'),
                                                                                                       (14,'Katedra za racunarski integrisanu proizvodnju i logistiku',NULL,'KATEDRA'),
                                                                                                       (15,'Katedra za softversko inzenjerstvo',NULL,'KATEDRA'),
                                                                                                       (16,'Katedra za menadzment kvaliteta i standardizaciju',NULL,'KATEDRA'),
                                                                                                       (17,'Katedra za upravljanje proizvodnjom i pruzanjem uslugama',NULL,'KATEDRA'),
                                                                                                       (18,'Katedra za finansijski menadzment i racunovodstvo',NULL,'KATEDRA'),
                                                                                                       (19,'Katedra za upravljanje sistemima',NULL,'KATEDRA');


--changeset DocUser:16
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (1, 'Dusan', 'Starcevic', '1946-07-22', 'DR', 6, 'PROF_EMERITUS', 'KATEDRA'),
                                                                                                        (2, 'Nenad', 'Anicic', '1962-08-22', 'DR', 5, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (3, 'Sladjan', 'Babarogic', '1967-07-22', 'DR', 5, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (4, 'Dusan', 'Barac', '1974-07-22', 'DR', 2, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (5, 'Sladjana', 'Benkovic', '1971-07-22', 'DR', 18, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (6, 'Zorica', 'Bogdanovic', '1975-07-22', 'DR', 2, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (7, 'Vesna', 'Bogojevic-Arsic', '1965-07-22', 'DR', 18, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (8, 'Milica', 'Bulajic', '1955-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (9, 'Dragan', 'Vasiljevic', '1963-07-22', 'DR', 14, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (10, 'Sinisa', 'Vlajic', '1959-07-22', 'DR', 15, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (11, 'Dragan', 'Vukmirovic', '1956-07-22', 'DR', 2, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (12, 'Vesna', 'Damnjanovic', '1979-07-22', 'DR', 7, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (13, 'Vladan', 'Devedzic', '1958-07-22', 'DR', 15, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (14, 'Boris', 'Delibasic', '1974-07-22', 'DR', 13, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (15, 'Marijana', 'Despotovic-Zrakic', '1964-07-22', 'DR', 2, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (16, 'Dragan', 'Djuric', '1976-07-22', 'DR', 15, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (17, 'Nedeljko', 'Zivkovic', '1973-07-22', 'DR', 16, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (18, 'Bojan', 'Ilic', '1968-07-22', 'DR', 1, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (19, 'Radmila', 'Janicic', '1965-07-22', 'DR', 7, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (20, 'Ondrej', 'Jasko', '1953-07-22', 'DR', 13, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (21, 'Sandra', 'Jednak', '1978-07-22', 'DR', 1, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (22, 'Jelena', 'Jovanovic', '1978-07-22', 'DR', 15, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (23, 'Milica', 'Kostic-Stankovic', '1967-07-22', 'DR', 7, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (24, 'Dragana', 'Kragulj', '1961-07-22', 'DR', 1, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (25, 'Marija', 'Kuzmanovic', '1965-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (26, 'Sasa', 'Lazarevic', '1965-07-22', 'DR', 15, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (27, 'Danica', 'Lecic-Cvetkovic', '1962-07-22', 'DR', 17, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (28, 'Ivan', 'Lukovic', '1967-07-22', 'DR', 5, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (29, 'Dragana', 'Makajic-Nikolic', '1972-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (30, 'Zoran', 'Marjanovic', '1969-07-22', 'DR', 5, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (31, 'Aleksandar', 'Markovic', '1959-07-22', 'DR', 13, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (32, 'Milan', 'Martic', '1956-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (33, 'Ivana', 'Mijatovic', '1961-07-22', 'DR', 16, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (34, 'Slobodan', 'Miladinovic', '1958-07-22', 'DR', 10, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (35, 'Miroslav', 'Minovic', '1973-07-22', 'DR', 6, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (36, 'Marko', 'Mihic', '1978-07-22', 'DR', 9, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (37, 'Olivera', 'Mihic', '1976-07-22', 'DR', 8, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (38, 'Vladimir', 'Obradovic', '1974-07-22', 'DR', 4, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (39, 'Dejan', 'Petrovic', '1972-07-22', 'DR', 9, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (40, 'Natasa', 'Petrovic', '1969-07-22', 'DR', 11, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (41, 'Bozidar', 'Radenkovic', '1955-07-22', 'DR', 2, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (42, 'Zoran', 'Radojicic', '1956-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (43, 'Gordana', 'Savic', '1969-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (44, 'Dejan', 'Simic', '1958-07-22', 'DR', 10, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (45, 'Dragoslav', 'Slovic', '1965-07-22', 'DR', 3, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (46, 'Milan', 'Stanojevic', '1973-07-22', 'DR', 12, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (47, 'Milica', 'Stanojevic', '1958-07-22', 'DR', 8, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (48, 'Biljana', 'Stosic', '1974-07-22', 'DR', 11, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (49, 'Milija', 'Suknovic', '1962-07-22', 'DR', 13, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (50, 'Vesna', 'Todorcevic', '1975-07-22', 'DR', 8, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (51, 'Jovan', 'Filipovic', '1969-07-22', 'DR', 16, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (52, 'Slavica', 'Cicvaric Kostic', '1976-07-22', 'DR', 7, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (53, 'Mladen', 'Cudanov', '1973-07-22', 'DR', 13, 'REDOVNI_PROF', 'KATEDRA'),
                                                                                                        (54, 'Velimir', 'Stavljanin', '1958-07-22', 'DR', 7, 'REDOVNI_PROF', 'KATEDRA');




