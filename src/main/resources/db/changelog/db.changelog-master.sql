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

--changeset DocUser:17
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (55, 'Jelena', 'Andjelkovic Labrovic', '1971-07-22', 'DR', 10, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (56, 'Slobodan', 'Antic', '1975-07-22', 'DR', 17, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (57, 'Sladjana', 'Barjaktarovic Rakocevic', '1981-07-22', 'DR', 18, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (58, 'Tamara', 'Vlastelica', '1984-07-22', 'DR', 7, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (59, 'Milan', 'Vukicevic', '1982-07-22', 'DR', 13, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (60, 'Jovanka', 'Vukmirovic', '1966-07-22', 'DR', 7, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (61, 'Veljko', 'Dmitrovic', '1979-07-22', 'DR', 18, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (62, 'Ivana', 'Dragovic', '1982-07-22', 'DR', 19, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (63, 'Aleksandar', 'Djokovic', '1972-07-22', 'DR', 12, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (64, 'Lena', 'Djordjevic Milutinovic', '1976-07-22', 'DR', 17, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (65, 'Mladen', 'Djuric', '1985-07-22', 'DR', 16, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (66, 'Tatjana', 'Ivanovic', '1988-07-22', 'DR', 10, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (67, 'Marina', 'Ignjatovic', '1986-07-22', 'DR', 12, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (68, 'Milos', 'Jevtic', '1978-07-22', 'DR', 13, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (69, 'Veljko', 'Jeremic', '1985-07-22', 'DR', 12, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (70, 'Milos', 'Jovanovic', '1987-07-22', 'DR', 13, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (71, 'Predrag', 'Jovanovic', '1980-07-22', 'DR', 13, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (72, 'Marija', 'Jovic', '1981-07-22', 'DR', 7, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (73, 'Snezana', 'Knezevic', '1975-07-22', 'DR', 18, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (74, 'Ivana', 'Kovacevic', '1980-07-22', 'DR', 10, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (75, 'Aleksandra', 'Labus', '1980-07-22', 'DR', 2, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (76, 'Rade', 'Lazovic', '1961-07-22', 'DR', 8, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (77, 'Sanja', 'Marinkovic', '1970-07-22', 'DR', 11, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (78, 'Vidan', 'Markovic', '1975-07-22', 'DR', 5, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (79, 'Milos', 'Milovanovic', '1982-07-22', 'DR', 6, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (80, 'Milos', 'Milosavljevic', '1986-07-22', 'DR', 1, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (81, 'Nebojsa', 'Nikolic', '1978-07-22', 'DR', 8, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (82, 'Branka', 'Novcic Korac', '1985-07-22', 'DR', 7, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (83, 'Tijana', 'Obradovic', '1984-07-22', 'DR', 18, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (84, 'Biljana', 'Panic', '1975-07-22', 'DR', 12, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (85, 'Ognjen', 'Pantelic', '1980-07-22', 'DR', 5, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (86, 'Gordana', 'Pejovic', '1978-07-22', 'DR', 16, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (87, 'Jasna', 'Petkovic', '1975-07-22', 'DR', 11, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (88, 'Ana', 'Poledica', '1982-07-22', 'DR', 19, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (89, 'Dusan', 'Savic', '1980-07-22', 'DR', 15, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (90, 'Barbara', 'Simeunovic', '1975-07-22', 'DR', 3, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (91, 'Marija', 'Todorovic', '1984-07-22', 'DR', 9, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (92, 'Ivan', 'Tomasevic', '1981-07-22', 'DR', 3, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (93, 'Bojan', 'Tomic', '1982-07-22', 'DR', 15, 'VANREDNI_PROF', 'KATEDRA'),
                                                                                                        (94, 'Zoran', 'Sevarac', '1983-07-22', 'DR', 15, 'VANREDNI_PROF', 'KATEDRA');

--changeset DocUser:18
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (95, 'Bisera', 'Andric Gusavac', '1980-07-22', 'DR', 12, 'DOCENT', 'KATEDRA'),
                                                                                                        (96, 'Jelena', 'Andjelkovic', '1978-07-22', 'DR', 10, 'DOCENT', 'KATEDRA'),
                                                                                                        (97, 'Ilija', 'Antovic', '1985-07-22', 'DR', 15, 'DOCENT', 'KATEDRA'),
                                                                                                        (98, 'Srdja', 'Bjeladinovic', '1984-07-22', 'DR', 5, 'DOCENT', 'KATEDRA'),
                                                                                                        (99, 'Dragan', 'Bjelica', '1982-07-22', 'DR', 9, 'DOCENT', 'KATEDRA'),
                                                                                                        (100, 'Marija', 'Bogicevic Sretenovic', '1984-07-22', 'MSA', 6, 'DOCENT', 'KATEDRA'),
                                                                                                        (101, 'Marija', 'Boricic Joksimovic', '1985-07-22', 'DR', 8, 'DOCENT', 'KATEDRA'),
                                                                                                        (102, 'Maja', 'Glogovac', '1987-07-22', 'DR', 16, 'DOCENT', 'KATEDRA'),
                                                                                                        (103, 'Milos', 'Danilovic', '1984-07-22', 'DR', 14, 'DOCENT', 'KATEDRA'),
                                                                                                        (104, 'Bojan', 'Jovanovic', '1982-07-22', 'DR', 6, 'DOCENT', 'KATEDRA'),
                                                                                                        (105, 'Ana', 'Kicanovic', '1985-07-22', 'DR', 16, 'DOCENT', 'KATEDRA'),
                                                                                                        (106, 'Stefan', 'Komazec', '1987-07-22', 'DR', 13, 'DOCENT', 'KATEDRA'),
                                                                                                        (107, 'Jovan', 'Krivokapic', '1985-07-22', 'DR', 13, 'DOCENT', 'KATEDRA'),
                                                                                                        (108, 'Djordje', 'Krivokapic', '1987-07-22', 'DR', 13, 'DOCENT', 'KATEDRA'),
                                                                                                        (109, 'Milica', 'Latinovic', '1982-07-22', 'DR', 18, 'DOCENT', 'KATEDRA'),
                                                                                                        (110, 'Milica', 'Maricic', '1989-07-22', 'DR', 12, 'DOCENT', 'KATEDRA'),
                                                                                                        (111, 'Ivan', 'Milenkovic', '1988-07-22', 'DR', 6, 'DOCENT', 'KATEDRA'),
                                                                                                        (112, 'Nemanja', 'Milenkovic', '1987-07-22', 'MSA', 12, 'DOCENT', 'KATEDRA'),
                                                                                                        (113, 'Milos', 'Milic', '1985-07-22', 'DR', 15, 'DOCENT', 'KATEDRA'),
                                                                                                        (114, 'Tanja', 'Milic', '1982-07-22', 'DR', 1, 'DOCENT', 'KATEDRA'),
                                                                                                        (115, 'Pavle', 'Milosevic', '1987-07-22', 'DR', 19, 'DOCENT', 'KATEDRA'),
                                                                                                        (116, 'Radul', 'Milutinovic', '1985-07-22', 'MSA', 11, 'DOCENT', 'KATEDRA'),
                                                                                                        (117, 'Zorica', 'Mitrovic', '1988-07-22', 'DR', 9, 'DOCENT', 'KATEDRA'),
                                                                                                        (118, 'Milan', 'Okanovic', '1987-07-22', 'DR', 7, 'DOCENT', 'KATEDRA'),
                                                                                                        (119, 'Marko', 'Petrovic', '1985-07-22', 'DR', 5, 'DOCENT', 'KATEDRA'),
                                                                                                        (120, 'Milena', 'Popovic', '1982-07-22', 'DR', 12, 'DOCENT', 'KATEDRA'),
                                                                                                        (121, 'Sandro', 'Radovanovic', '1989-07-22', 'MSA', 13, 'DOCENT', 'KATEDRA'),
                                                                                                        (122, 'Ana', 'Rakic', '1982-07-22', 'DR', 16, 'DOCENT', 'KATEDRA'),
                                                                                                        (123, 'Aleksandar', 'Rakicevic', '1988-07-22', 'DR', 19, 'DOCENT', 'KATEDRA'),
                                                                                                        (124, 'Zoran', 'Rakicevic', '1986-07-22', 'DR', 17, 'DOCENT', 'KATEDRA'),
                                                                                                        (125, 'Dragana', 'Stojanovic', '1983-07-22', 'DR', 3, 'DOCENT', 'KATEDRA'),
                                                                                                        (126, 'Nina', 'Turajlic', '1986-07-22', 'DR', 5, 'DOCENT', 'KATEDRA'),
                                                                                                        (127, 'Marko', 'Cirovic', '1982-07-22', 'DR', 11, 'DOCENT', 'KATEDRA'),
                                                                                                        (128, 'Biljana', 'Cvetic', '1985-07-22', 'DR', 14, 'DOCENT', 'KATEDRA');


--changeset DocUser:19
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (129, 'Milan', 'Radojicic', '1987-07-22', 'DR', 12, 'ASISTENT_SA_DOKTORATOM', 'KATEDRA'),
                                                                                                        (130, 'Jelena', 'Ruso', '1989-07-22', 'DR', 16, 'ASISTENT_SA_DOKTORATOM', 'KATEDRA'),
                                                                                                        (131, 'Marija', 'Mersnik', '1985-07-22', 'DR', 10, 'NASTAVNIK_STRANOG_JEZIKA', 'KATEDRA');

--changeset DocUser:20
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (132, 'Vukasin', 'Brkovic', '1992-07-22', 'MSA', 8, 'ASISTENT', 'KATEDRA'),
                                                                                                        (133, 'Jelena', 'Djordjevic', '1975-07-22', 'MSA', 8, 'ASISTENT', 'KATEDRA'),
                                                                                                        (134, 'Ivona', 'Zivkovic', '1991-07-22', 'MSA', 10, 'ASISTENT', 'KATEDRA'),
                                                                                                        (135, 'Nikola', 'Zornic', '1995-07-22', 'MSA', 13, 'ASISTENT', 'KATEDRA'),
                                                                                                        (136, 'Olga', 'Jejic', '1996-07-22', 'MSA', 5, 'ASISTENT', 'KATEDRA'),
                                                                                                        (137, 'Milica', 'Jovanovic', '1990-07-22', 'MSA', 11, 'ASISTENT', 'KATEDRA'),
                                                                                                        (138, 'Ivona', 'Jovanovic', '1994-07-22', 'MSA', 3, 'ASISTENT', 'KATEDRA'),
                                                                                                        (139, 'Jovana', 'Jovic', '1993-07-22', 'MSA', 10, 'ASISTENT', 'KATEDRA'),
                                                                                                        (140, 'Stefan', 'Krstovic', '1996-07-22', 'MSA', 5, 'ASISTENT', 'KATEDRA'),
                                                                                                        (141, 'Ivana', 'Kuzet', '1996-07-22', 'MSA', 10, 'ASISTENT', 'KATEDRA'),
                                                                                                        (142, 'Petar', 'Lakcevic', '1997-07-22', 'MSA', 15, 'ASISTENT', 'KATEDRA'),
                                                                                                        (143, 'Bojan', 'Marceta', '1984-07-22', 'MSA', 6, 'ASISTENT', 'KATEDRA'),
                                                                                                        (144, 'Tamara', 'Naumovic', '1994-07-22', 'MSA', 2, 'ASISTENT', 'KATEDRA'),
                                                                                                        (145, 'Dejana', 'Nikolic', '1995-07-22', 'MSA', 7, 'ASISTENT', 'KATEDRA'),
                                                                                                        (146, 'Nikola', 'Petrovic', '1996-07-22', 'MSA', 10, 'ASISTENT', 'KATEDRA'),
                                                                                                        (147, 'Teodora', 'Rajkovic', '1990-07-22', 'MSA', 17, 'ASISTENT', 'KATEDRA'),
                                                                                                        (148, 'Nela', 'Rakic', '1990-07-22', 'MSA', 18, 'ASISTENT', 'KATEDRA'),
                                                                                                        (149, 'Jovana', 'Rakicevic', '1993-07-22', 'MSA', 11, 'ASISTENT', 'KATEDRA'),
                                                                                                        (150, 'Zeljko', 'Spasenic', '1993-07-22', 'MSA', 18, 'ASISTENT', 'KATEDRA'),
                                                                                                        (151, 'Jelica', 'Stanojevic', '1996-07-22', 'MSA', 6, 'ASISTENT', 'KATEDRA'),
                                                                                                        (152, 'Tatjana', 'Stojanovic', '1994-07-22', 'MSA', 15, 'ASISTENT', 'KATEDRA'),
                                                                                                        (153, 'Filip', 'Furtula', '1996-07-22', 'MSA', 5, 'ASISTENT', 'KATEDRA'),
                                                                                                        (154, 'Nikola', 'Cvetkovic', '1994-07-22', 'MSA', 12, 'ASISTENT', 'KATEDRA'),
                                                                                                        (155, 'Andrijana', 'Dzamic', '1993-07-22', 'MSA', 12, 'ASISTENT', 'KATEDRA'),
                                                                                                        (156, 'Milica', 'Skembarevic', '1996-07-22', 'MSA', 5, 'ASISTENT', 'KATEDRA');

--changeset DocUser:21
insert  into `employee`(`employee_id`,`first_name`,`last_name`,`birthday`,`education_title`,`department_id`,`academic_title`,`dtype`) values
                                                                                                        (157, 'Ognjen', 'Andjelic', '1997-07-22', 'DIPL', 17, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (158, 'Vladimir', 'Belca', '1997-07-22', 'DIPL', 5, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (159, 'Andjelija', 'Djordjevic', '1998-07-22', 'DIPL', 9, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (160, 'Andjela', 'Djordjevic', '1997-07-22', 'DIPL', 14, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (161, 'Predrag', 'Imsic', '1997-07-22', 'DIPL', 5, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (162, 'Djordje', 'Jovanovic', '1996-07-22', 'DIPL', 9, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (163, 'Branko', 'Krsmanovic', '1997-07-22', 'DIPL', 5, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (164, 'Petar', 'Lukovac', '1998-07-22', 'DIPL', 2, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (165, 'Dusan', 'Mitrovic', '1997-07-22', 'DIPL', 6, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (166, 'Andrea', 'Nikolic', '1996-07-22', 'DIPL', 13, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (167, 'Petar', 'Stanimirovic', '1997-07-22', 'DIPL', 9, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (168, 'Selena', 'Stanojevic', '1997-07-22', 'DIPL', 7, 'SARADNIK_U_NASAVI', 'KATEDRA'),
                                                                                                        (169, 'Biljana', 'Tosic', '1997-07-22', 'DIPL', 16, 'SARADNIK_U_NASAVI', 'KATEDRA');
