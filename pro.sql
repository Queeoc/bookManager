/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.32-log : Database - project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`project` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `project`;

/*Table structure for table `book_info` */

DROP TABLE IF EXISTS `book_info`;

CREATE TABLE `book_info` (
                             `bookId` int(30) unsigned NOT NULL AUTO_INCREMENT,
                             `isbn` varchar(200) DEFAULT NULL,
                             `bookName` varchar(200) DEFAULT NULL,
                             `author` varchar(200) DEFAULT NULL,
                             `publisher` varchar(200) DEFAULT NULL,
                             `publishTime` date DEFAULT NULL,
                             `floor` varchar(30) DEFAULT NULL,
                             `state` tinyint(1) DEFAULT NULL,
                             `price` varchar(200) DEFAULT NULL,
                             `category` varchar(200) DEFAULT NULL,
                             `description` varchar(1000) DEFAULT NULL,
                             `face` varchar(10) DEFAULT NULL,
                             `column` varchar(10) DEFAULT NULL,
                             `row` varchar(10) DEFAULT NULL,
                             `bookBarcode` varchar(200) DEFAULT NULL,
                             `picture` varchar(1000) DEFAULT NULL,
                             PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=100049 DEFAULT CHARSET=utf8;

/*Data for the table `book_info` */

insert  into `book_info`(`bookId`,`isbn`,`bookName`,`author`,`publisher`,`publishTime`,`floor`,`state`,`price`,`category`,`description`,`face`,`column`,`row`,`bookBarcode`,`picture`) values
                                                                                                                                                                                           (100002,NULL,NULL,NULL,NULL,'2022-05-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/picture.jpg'),
                                                                                                                                                                                           (100027,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100027.jpg','/picture.jpg'),
                                                                                                                                                                                           (100028,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100028.jpg','/picture.jpg'),
                                                                                                                                                                                           (100029,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100029.jpg','/picture.jpg'),
                                                                                                                                                                                           (100030,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100030.jpg','/picture.jpg'),
                                                                                                                                                                                           (100031,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100031.jpg','/picture.jpg'),
                                                                                                                                                                                           (100032,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100032.jpg','/picture.jpg'),
                                                                                                                                                                                           (100033,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100033.jpg','/picture.jpg'),
                                                                                                                                                                                           (100047,'978-7-03-028917-9','物联网理论与技术','杨刚//沈沛意//郑春红','科学','2010-09-01','2',0,'28.00元','computer science','《物联网理论与技术》从物联网的概念出发，深入剖析了物联网这一概念背景下所涵盖的技术知识、发展现状及所面临的挑战和技术突破点，详尽阐述了物联网涉及的相关技术，紧密结合国际发展动态，逐个剖析了国际上的研究热点。\r\n全书共分5章。第1章介绍物联网的基本概念，并对相关技术名词进行说明；第2章在阐述物联网架构的基础上对比各地区提出的物联网架构的异同，同时对物联网的三层结构进行说明；第3章介绍物联网的关键技术和相关技术；第4章介绍物联网在现实生活中的应用实例；第5章总结了物联网在推广过程中的挑战和机遇。\r\n《物联网理论与技术》可作为研究物联网这一新兴技术的教学或参考书，同时也适合对这一技术感兴趣的学者及工程人员阅读、参考。','2','1','3','/100047.jpg','https://img9.doubanio.com/view/subject/m/public/s6228586.jpg'),
                                                                                                                                                                                           (100048,'978-7-03-028917-9','物联网理论与技术','杨刚//沈沛意//郑春红','科学','2010-09-01','2',0,'28.00元','computer science','《物联网理论与技术》从物联网的概念出发，深入剖析了物联网这一概念背景下所涵盖的技术知识、发展现状及所面临的挑战和技术突破点，详尽阐述了物联网涉及的相关技术，紧密结合国际发展动态，逐个剖析了国际上的研究热点。\r\n全书共分5章。第1章介绍物联网的基本概念，并对相关技术名词进行说明；第2章在阐述物联网架构的基础上对比各地区提出的物联网架构的异同，同时对物联网的三层结构进行说明；第3章介绍物联网的关键技术和相关技术；第4章介绍物联网在现实生活中的应用实例；第5章总结了物联网在推广过程中的挑战和机遇。\r\n《物联网理论与技术》可作为研究物联网这一新兴技术的教学或参考书，同时也适合对这一技术感兴趣的学者及工程人员阅读、参考。','2','1','3','/100048.jpg','https://img9.doubanio.com/view/subject/m/public/s6228586.jpg');

/*Table structure for table `lend_list` */

DROP TABLE IF EXISTS `lend_list`;

CREATE TABLE `lend_list` (
                             `bookId` int(30) NOT NULL,
                             `readerId` varchar(100) CHARACTER SET latin1 NOT NULL,
                             `borrowDate` date NOT NULL,
                             `latestFineDay` date DEFAULT NULL,
                             PRIMARY KEY (`bookId`,`readerId`,`borrowDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lend_list` */

/*Table structure for table `reader_info` */

DROP TABLE IF EXISTS `reader_info`;

CREATE TABLE `reader_info` (
                               `barcode` varchar(30) DEFAULT NULL,
                               `readerId` varchar(100) NOT NULL,
                               `address` varchar(100) DEFAULT NULL,
                               `phoneNumber` varchar(100) DEFAULT NULL,
                               `registerTime` date DEFAULT NULL,
                               `name` varchar(100) DEFAULT NULL,
                               `gender` varchar(20) DEFAULT NULL,
                               PRIMARY KEY (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader_info` */

insert  into `reader_info`(`barcode`,`readerId`,`address`,`phoneNumber`,`registerTime`,`name`,`gender`) values
    ('/20020504.jpg','20020504','游客-20020504','111111','2022-05-04','张三','男');

/*Table structure for table `reservation_info` */

DROP TABLE IF EXISTS `reservation_info`;

CREATE TABLE `reservation_info` (
                                    `bookId` varchar(100) DEFAULT NULL,
                                    `name` varchar(100) DEFAULT NULL,
                                    `readerId` varchar(100) DEFAULT NULL,
                                    `reserveTime` datetime DEFAULT NULL,
                                    `barcode` varchar(100) DEFAULT NULL,
                                    `isbn` varchar(100) DEFAULT NULL,
                                    `bookName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reservation_info` */

insert  into `reservation_info`(`bookId`,`name`,`readerId`,`reserveTime`,`barcode`,`isbn`,`bookName`) values
                                                                                                          ('100027','张三','20020504','2022-05-07 09:08:15','/100027.jpg','978-7-111-21354-3','数据通信与网络'),
                                                                                                          ('100029','张三','20020504','2022-05-07 09:08:21','/100029.jpg','978-7-111-21354-3','数据通信与网络');

/*Table structure for table `systemparamters` */

DROP TABLE IF EXISTS `systemparamters`;

CREATE TABLE `systemparamters` (
                                   `bookLimit` int(11) DEFAULT NULL,
                                   `timeLimit` int(11) DEFAULT NULL,
                                   `everdayFine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `systemparamters` */

insert  into `systemparamters`(`bookLimit`,`timeLimit`,`everdayFine`) values
    (5,10,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `username` varchar(100) NOT NULL,
                        `password` varchar(100) NOT NULL,
                        `role` varchar(30) DEFAULT NULL,
                        PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`role`) values
                                                      ('20020504','1','user'),
                                                      ('root','1','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
