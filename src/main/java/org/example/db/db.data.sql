/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - sbs_proj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sbs_proj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `sbs_proj`;

/*Table structure for table `Check` */

DROP TABLE IF EXISTS `Check`;

CREATE TABLE `Check` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `reservation` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reservation` (`reservation`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `Check` */

insert  into `Check`(`id`,`time`,`reservation`,`name`) values 
(1,'2024-04-17 18:17:19','7타임','짱구'),
(7,'2024-04-18 18:22:59','','123'),
(12,'2024-04-18 18:33:35',' 타임','예지'),
(14,'2024-04-18 18:37:25','user1_타임','유나'),
(15,'2024-04-18 18:41:22','qwer_타임','채령'),
(16,'2024-04-18 18:42:20','1타임','예지'),
(17,'2024-04-18 18:43:21','2타임','예지');

/*Table structure for table `Cul` */

DROP TABLE IF EXISTS `Cul`;

CREATE TABLE `Cul` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_name` char(100) NOT NULL,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_name` (`member_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `Cul` */

insert  into `Cul`(`id`,`member_name`,`regDate`,`updateDate`,`STATUS`) values 
(1,'호올리','2024-04-18 16:07:16','2024-04-18 16:07:16','미출석'),
(2,'유리','2024-04-18 16:07:16','2024-04-18 16:07:16','출석'),
(3,'예지','2024-04-18 16:09:48','2024-04-18 16:09:48','출석');

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `title` char(100) NOT NULL,
  `body` text NOT NULL,
  `memberId` int(10) unsigned NOT NULL,
  `boardId` int(10) unsigned NOT NULL,
  `hit` int(100) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `boardId` (`boardId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`regDate`,`updateDate`,`title`,`body`,`memberId`,`boardId`,`hit`) values 
(1,'2024-04-17 18:17:19','2024-04-17 18:17:19','제목1','내용1',1,1,50),
(2,'2024-04-17 18:17:19','2024-04-17 18:17:19','제목2','내용2',2,1,7),
(3,'2024-04-17 18:17:19','2024-04-17 18:17:19','제목3','내용3',2,2,30);

/*Table structure for table `articleReply` */

DROP TABLE IF EXISTS `articleReply`;

CREATE TABLE `articleReply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `body` char(100) NOT NULL,
  `memberId` int(10) unsigned NOT NULL,
  `articleId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articleId` (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `articleReply` */

insert  into `articleReply`(`id`,`regDate`,`updateDate`,`body`,`memberId`,`articleId`) values 
(1,'2024-04-17 18:17:19','2024-04-17 18:17:19','댓글1',1,2),
(2,'2024-04-17 18:17:19','2024-04-17 18:17:19','댓글2',2,1);

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `code` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `board` */

insert  into `board`(`id`,`regDate`,`updateDate`,`code`,`name`) values 
(1,'2024-04-17 18:17:19','2024-04-17 18:17:19','notice','공지'),
(2,'2024-04-17 18:17:19','2024-04-17 18:17:19','free','자유');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `loginId` char(100) NOT NULL,
  `loginPw` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`loginId`,`loginPw`,`name`) values 
(1,'2024-04-17 18:17:19','2024-04-17 18:17:19','admin','admin','관리자'),
(2,'2024-04-17 18:17:19','2024-04-17 18:17:19','user','user','예지'),
(3,'2024-04-17 18:17:19','2024-04-17 18:17:19','user1','user1','유나'),
(4,'2024-04-17 18:17:19','2024-04-17 18:17:19','qwer','qwer','채령');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
