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
) ENGINE=InnoDB AUTO_INCREMENT=100059 DEFAULT CHARSET=utf8;

/*Data for the table `book_info` */

insert  into `book_info`(`bookId`,`isbn`,`bookName`,`author`,`publisher`,`publishTime`,`floor`,`state`,`price`,`category`,`description`,`face`,`column`,`row`,`bookBarcode`,`picture`) values 
(100027,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100027.jpg','/picture.jpg'),
(100029,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100029.jpg','/picture.jpg'),
(100030,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','2',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','1','2','2','/100030.jpg','/picture.jpg'),
(100031,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100031.jpg','/picture.jpg'),
(100032,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',0,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100032.jpg','/picture.jpg'),
(100033,'978-7-111-21354-3','数据通信与网络','(美)Behrouz A.Forouzan;Sophia Chung Fegan','机械工业出版社','2007-07-01','3',1,'79.00元','art','本书系统地介绍了数据通信与计算机网络领域的基本理论及应用。与前几版相比，第4版在内容和编排上都有较大更新，更加注重理论与实际应用相结合。主要内容包括：传输介质和数据编码、模拟信号和数字信号、建立连接、数据压缩、数据完整、数据安全、流量控制、局域网、网络互连、因特网协议和应用、因特网编程、电路技术等。另外，每章后面均附有大量复习题与练习题。\r\n本书适合作为高等院校计算机科学专业本科生的教材或参考书，也可供从事数据通信和网络工作的技术人员参考。','3','2','1','/100033.jpg','/picture.jpg'),
(100047,'978-7-03-028917-9','物联网理论与技术','杨刚//沈沛意//郑春红','科学','2010-09-01','2',0,'28.00元','computer science','《物联网理论与技术》从物联网的概念出发，深入剖析了物联网这一概念背景下所涵盖的技术知识、发展现状及所面临的挑战和技术突破点，详尽阐述了物联网涉及的相关技术，紧密结合国际发展动态，逐个剖析了国际上的研究热点。\r\n全书共分5章。第1章介绍物联网的基本概念，并对相关技术名词进行说明；第2章在阐述物联网架构的基础上对比各地区提出的物联网架构的异同，同时对物联网的三层结构进行说明；第3章介绍物联网的关键技术和相关技术；第4章介绍物联网在现实生活中的应用实例；第5章总结了物联网在推广过程中的挑战和机遇。\r\n《物联网理论与技术》可作为研究物联网这一新兴技术的教学或参考书，同时也适合对这一技术感兴趣的学者及工程人员阅读、参考。','2','1','3','/100047.jpg','https://img9.doubanio.com/view/subject/m/public/s6228586.jpg'),
(100048,'978-7-03-028917-9','物联网理论与技术','杨刚//沈沛意//郑春红','科学','2010-09-01','2',0,'28.00元','computer science','《物联网理论与技术》从物联网的概念出发，深入剖析了物联网这一概念背景下所涵盖的技术知识、发展现状及所面临的挑战和技术突破点，详尽阐述了物联网涉及的相关技术，紧密结合国际发展动态，逐个剖析了国际上的研究热点。\r\n全书共分5章。第1章介绍物联网的基本概念，并对相关技术名词进行说明；第2章在阐述物联网架构的基础上对比各地区提出的物联网架构的异同，同时对物联网的三层结构进行说明；第3章介绍物联网的关键技术和相关技术；第4章介绍物联网在现实生活中的应用实例；第5章总结了物联网在推广过程中的挑战和机遇。\r\n《物联网理论与技术》可作为研究物联网这一新兴技术的教学或参考书，同时也适合对这一技术感兴趣的学者及工程人员阅读、参考。','2','1','3','/100048.jpg','https://img9.doubanio.com/view/subject/m/public/s6228586.jpg'),
(100049,'978-7-5302-1921-8','人生海海','麦家','北京十月文艺出版社','2019-04-01','1',1,'55.00元','art','★豆瓣2019年度书单·中国文学（小说类） 第一名\r\n·\r\n“他是全村最出奇古怪的人，古怪的名目要扳着指头一个一个数：\r\n第一，他当过国民党军队的上校，是革命群众要斗争的对象。但大家一边斗争他，一边又巴结讨好他，家里出什么事都去找他拿主意。\r\n第二，都说他是太监，可我们小孩子经常偷看他那个地方，好像还是满当当的，有模有样的。\r\n第三， 他向来不出工，不干农活，天天空在家里看报纸，嗑瓜子，可日子过得比谁家都舒坦。还像养孩子一样养着一对猫，宝贝得不得了，简直神经病！”\r\n·\r\n《人生海海》讲述了一个人在时代中穿行缠斗的一生，离奇的故事里藏着让人叹息的人生况味,既有日常滋生的残酷，也有时间带来的仁慈。\r\n=========\r\n人生如海，总有阴冷暴虐的水域，也有轻柔温暖的洋流。\r\n·\r\n“生活摧残了他，但也让他穿越了生死恐惧和世态炎凉， 变得大彻大悟， 笑傲江湖。 ”\r\n他知道怎样在风光处耀目，也知道怎么在卑贱中自处。\r\n·\r\n★麦家强力超越之作·在一个最不可描述之处解密人性的荒唐与高尚\r\n★小说的迷人之 处就在于它能把不存在的人物写得仿佛是我们的朋友，麦家的《人生海海》就是这么迷人。——莫言\r\n★麦家的身上永远有一种旁观者的气质，一旦他开了口，他的语言是那么的精准。他的细节是那么的触动，他的思想是那么的深刻。如果用一句诗来形容我读完《人生海海》的感受，那就是“回首向来萧瑟处，也无风雨也无晴”。——董卿\r\n★我想写的是在绝望中诞生的幸运，在艰苦中卓绝的道德。我要另立山头，回到童年，回去故乡，去破译人心和人性的密码。——麦家\r\n★《人生海海》是麦家老师跨越了自己的第一座高峰，向内心深处的文学攀登下一座高峰的大作。——高晓松\r\n=========\r\n★“人生海海，敢死不叫勇气，活着才需要勇气。你要替我记住这句话，我要不遇到它，死几回都不够。”\r\n★人生海海，潮落之后是潮起。\r\n你说那是消磨、笑柄、罪过，但那就是我的英雄主义。','2','2','2','/100049.jpg','https://img2.doubanio.com/view/subject/m/public/s32266692.jpg'),
(100050,'978-7-5302-1921-8','人生海海','麦家','北京十月文艺出版社','2019-04-01','1',2,'55.00元','art','★豆瓣2019年度书单·中国文学（小说类） 第一名\r\n·\r\n“他是全村最出奇古怪的人，古怪的名目要扳着指头一个一个数：\r\n第一，他当过国民党军队的上校，是革命群众要斗争的对象。但大家一边斗争他，一边又巴结讨好他，家里出什么事都去找他拿主意。\r\n第二，都说他是太监，可我们小孩子经常偷看他那个地方，好像还是满当当的，有模有样的。\r\n第三， 他向来不出工，不干农活，天天空在家里看报纸，嗑瓜子，可日子过得比谁家都舒坦。还像养孩子一样养着一对猫，宝贝得不得了，简直神经病！”\r\n·\r\n《人生海海》讲述了一个人在时代中穿行缠斗的一生，离奇的故事里藏着让人叹息的人生况味,既有日常滋生的残酷，也有时间带来的仁慈。\r\n=========\r\n人生如海，总有阴冷暴虐的水域，也有轻柔温暖的洋流。\r\n·\r\n“生活摧残了他，但也让他穿越了生死恐惧和世态炎凉， 变得大彻大悟， 笑傲江湖。 ”\r\n他知道怎样在风光处耀目，也知道怎么在卑贱中自处。\r\n·\r\n★麦家强力超越之作·在一个最不可描述之处解密人性的荒唐与高尚\r\n★小说的迷人之 处就在于它能把不存在的人物写得仿佛是我们的朋友，麦家的《人生海海》就是这么迷人。——莫言\r\n★麦家的身上永远有一种旁观者的气质，一旦他开了口，他的语言是那么的精准。他的细节是那么的触动，他的思想是那么的深刻。如果用一句诗来形容我读完《人生海海》的感受，那就是“回首向来萧瑟处，也无风雨也无晴”。——董卿\r\n★我想写的是在绝望中诞生的幸运，在艰苦中卓绝的道德。我要另立山头，回到童年，回去故乡，去破译人心和人性的密码。——麦家\r\n★《人生海海》是麦家老师跨越了自己的第一座高峰，向内心深处的文学攀登下一座高峰的大作。——高晓松\r\n=========\r\n★“人生海海，敢死不叫勇气，活着才需要勇气。你要替我记住这句话，我要不遇到它，死几回都不够。”\r\n★人生海海，潮落之后是潮起。\r\n你说那是消磨、笑柄、罪过，但那就是我的英雄主义。','2','2','2','/100050.jpg','https://img2.doubanio.com/view/subject/m/public/s32266692.jpg'),
(100053,'12345-12345-111','一本书','张三','中国','1999-03-17','3',0,'500','computer science','这是一本好书','1','2','1','/100053.jpg','/picture.jpg'),
(100054,'12345-12345-111','一本书','张三','中国','1999-03-17','3',1,'500','computer science','这是一本好书','1','2','1','/100054.jpg','/picture.jpg'),
(100055,'12345-12345-111','一本书','张三','中国','1999-03-17','3',1,'500','computer science','这是一本好书','1','2','1','/100055.jpg','/picture.jpg'),
(100056,'978-7-5302-1921-8','人生海海','麦家','北京十月文艺出版社','2019-04-01','2',1,'55.00元','art','★豆瓣2019年度书单·中国文学（小说类） 第一名\r\n·\r\n“他是全村最出奇古怪的人，古怪的名目要扳着指头一个一个数：\r\n第一，他当过国民党军队的上校，是革命群众要斗争的对象。但大家一边斗争他，一边又巴结讨好他，家里出什么事都去找他拿主意。\r\n第二，都说他是太监，可我们小孩子经常偷看他那个地方，好像还是满当当的，有模有样的。\r\n第三， 他向来不出工，不干农活，天天空在家里看报纸，嗑瓜子，可日子过得比谁家都舒坦。还像养孩子一样养着一对猫，宝贝得不得了，简直神经病！”\r\n·\r\n《人生海海》讲述了一个人在时代中穿行缠斗的一生，离奇的故事里藏着让人叹息的人生况味,既有日常滋生的残酷，也有时间带来的仁慈。\r\n=========\r\n人生如海，总有阴冷暴虐的水域，也有轻柔温暖的洋流。\r\n·\r\n“生活摧残了他，但也让他穿越了生死恐惧和世态炎凉， 变得大彻大悟， 笑傲江湖。 ”\r\n他知道怎样在风光处耀目，也知道怎么在卑贱中自处。\r\n·\r\n★麦家强力超越之作·在一个最不可描述之处解密人性的荒唐与高尚\r\n★小说的迷人之 处就在于它能把不存在的人物写得仿佛是我们的朋友，麦家的《人生海海》就是这么迷人。——莫言\r\n★麦家的身上永远有一种旁观者的气质，一旦他开了口，他的语言是那么的精准。他的细节是那么的触动，他的思想是那么的深刻。如果用一句诗来形容我读完《人生海海》的感受，那就是“回首向来萧瑟处，也无风雨也无晴”。——董卿\r\n★我想写的是在绝望中诞生的幸运，在艰苦中卓绝的道德。我要另立山头，回到童年，回去故乡，去破译人心和人性的密码。——麦家\r\n★《人生海海》是麦家老师跨越了自己的第一座高峰，向内心深处的文学攀登下一座高峰的大作。——高晓松\r\n=========\r\n★“人生海海，敢死不叫勇气，活着才需要勇气。你要替我记住这句话，我要不遇到它，死几回都不够。”\r\n★人生海海，潮落之后是潮起。\r\n你说那是消磨、笑柄、罪过，但那就是我的英雄主义。','1','2','1','/100056.jpg','https://img2.doubanio.com/view/subject/m/public/s32266692.jpg'),
(100057,'978-7-5302-1921-8','人生海海','麦家','北京十月文艺出版社','2019-04-01','2',1,'55.00元','art','★豆瓣2019年度书单·中国文学（小说类） 第一名\r\n·\r\n“他是全村最出奇古怪的人，古怪的名目要扳着指头一个一个数：\r\n第一，他当过国民党军队的上校，是革命群众要斗争的对象。但大家一边斗争他，一边又巴结讨好他，家里出什么事都去找他拿主意。\r\n第二，都说他是太监，可我们小孩子经常偷看他那个地方，好像还是满当当的，有模有样的。\r\n第三， 他向来不出工，不干农活，天天空在家里看报纸，嗑瓜子，可日子过得比谁家都舒坦。还像养孩子一样养着一对猫，宝贝得不得了，简直神经病！”\r\n·\r\n《人生海海》讲述了一个人在时代中穿行缠斗的一生，离奇的故事里藏着让人叹息的人生况味,既有日常滋生的残酷，也有时间带来的仁慈。\r\n=========\r\n人生如海，总有阴冷暴虐的水域，也有轻柔温暖的洋流。\r\n·\r\n“生活摧残了他，但也让他穿越了生死恐惧和世态炎凉， 变得大彻大悟， 笑傲江湖。 ”\r\n他知道怎样在风光处耀目，也知道怎么在卑贱中自处。\r\n·\r\n★麦家强力超越之作·在一个最不可描述之处解密人性的荒唐与高尚\r\n★小说的迷人之 处就在于它能把不存在的人物写得仿佛是我们的朋友，麦家的《人生海海》就是这么迷人。——莫言\r\n★麦家的身上永远有一种旁观者的气质，一旦他开了口，他的语言是那么的精准。他的细节是那么的触动，他的思想是那么的深刻。如果用一句诗来形容我读完《人生海海》的感受，那就是“回首向来萧瑟处，也无风雨也无晴”。——董卿\r\n★我想写的是在绝望中诞生的幸运，在艰苦中卓绝的道德。我要另立山头，回到童年，回去故乡，去破译人心和人性的密码。——麦家\r\n★《人生海海》是麦家老师跨越了自己的第一座高峰，向内心深处的文学攀登下一座高峰的大作。——高晓松\r\n=========\r\n★“人生海海，敢死不叫勇气，活着才需要勇气。你要替我记住这句话，我要不遇到它，死几回都不够。”\r\n★人生海海，潮落之后是潮起。\r\n你说那是消磨、笑柄、罪过，但那就是我的英雄主义。','1','2','1','/100057.jpg','https://img2.doubanio.com/view/subject/m/public/s32266692.jpg'),
(100058,'978-7-5302-1921-8','人生海海','麦家','北京十月文艺出版社','2019-04-01','2',1,'55.00元','art','★豆瓣2019年度书单·中国文学（小说类） 第一名\r\n·\r\n“他是全村最出奇古怪的人，古怪的名目要扳着指头一个一个数：\r\n第一，他当过国民党军队的上校，是革命群众要斗争的对象。但大家一边斗争他，一边又巴结讨好他，家里出什么事都去找他拿主意。\r\n第二，都说他是太监，可我们小孩子经常偷看他那个地方，好像还是满当当的，有模有样的。\r\n第三， 他向来不出工，不干农活，天天空在家里看报纸，嗑瓜子，可日子过得比谁家都舒坦。还像养孩子一样养着一对猫，宝贝得不得了，简直神经病！”\r\n·\r\n《人生海海》讲述了一个人在时代中穿行缠斗的一生，离奇的故事里藏着让人叹息的人生况味,既有日常滋生的残酷，也有时间带来的仁慈。\r\n=========\r\n人生如海，总有阴冷暴虐的水域，也有轻柔温暖的洋流。\r\n·\r\n“生活摧残了他，但也让他穿越了生死恐惧和世态炎凉， 变得大彻大悟， 笑傲江湖。 ”\r\n他知道怎样在风光处耀目，也知道怎么在卑贱中自处。\r\n·\r\n★麦家强力超越之作·在一个最不可描述之处解密人性的荒唐与高尚\r\n★小说的迷人之 处就在于它能把不存在的人物写得仿佛是我们的朋友，麦家的《人生海海》就是这么迷人。——莫言\r\n★麦家的身上永远有一种旁观者的气质，一旦他开了口，他的语言是那么的精准。他的细节是那么的触动，他的思想是那么的深刻。如果用一句诗来形容我读完《人生海海》的感受，那就是“回首向来萧瑟处，也无风雨也无晴”。——董卿\r\n★我想写的是在绝望中诞生的幸运，在艰苦中卓绝的道德。我要另立山头，回到童年，回去故乡，去破译人心和人性的密码。——麦家\r\n★《人生海海》是麦家老师跨越了自己的第一座高峰，向内心深处的文学攀登下一座高峰的大作。——高晓松\r\n=========\r\n★“人生海海，敢死不叫勇气，活着才需要勇气。你要替我记住这句话，我要不遇到它，死几回都不够。”\r\n★人生海海，潮落之后是潮起。\r\n你说那是消磨、笑柄、罪过，但那就是我的英雄主义。','1','2','1','/100058.jpg','https://img2.doubanio.com/view/subject/m/public/s32266692.jpg');

/*Table structure for table `borrow_history` */

DROP TABLE IF EXISTS `borrow_history`;

CREATE TABLE `borrow_history` (
  `readerId` varchar(100) NOT NULL,
  `bookId` varchar(100) NOT NULL,
  `borrowDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`readerId`,`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow_history` */

insert  into `borrow_history`(`readerId`,`bookId`,`borrowDate`,`returnDate`,`state`) values 
('20020504','100027','2022-04-09','2022-05-10',0),
('20020504','100028','2022-05-10','2022-05-20',0),
('20020504','100029','2022-04-08','2022-05-10',0);

/*Table structure for table `category_info` */

DROP TABLE IF EXISTS `category_info`;

CREATE TABLE `category_info` (
  `category` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category_info` */

insert  into `category_info`(`category`) values 
('computer science');

/*Table structure for table `fine_history` */

DROP TABLE IF EXISTS `fine_history`;

CREATE TABLE `fine_history` (
  `readerId` varchar(100) DEFAULT NULL,
  `fineDay` date DEFAULT NULL,
  `fineCount` int(11) DEFAULT NULL,
  `bookId` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fine_history` */

insert  into `fine_history`(`readerId`,`fineDay`,`fineCount`,`bookId`) values 
('20020504','2022-05-11',10,'156'),
('20201515','2022-05-11',15,'123');

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

insert  into `lend_list`(`bookId`,`readerId`,`borrowDate`,`latestFineDay`) values 
(100030,'20020504','2022-05-10','2022-05-20'),
(100032,'20020504','2022-05-10','2022-05-20'),
(100047,'20220510','2022-04-20','2022-05-10'),
(100048,'20220510','2022-04-20','2022-05-10'),
(100053,'20020504','2022-05-25','2022-06-04');

/*Table structure for table `location_info` */

DROP TABLE IF EXISTS `location_info`;

CREATE TABLE `location_info` (
  `column` int(11) DEFAULT NULL,
  `face` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `row` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `location_info` */

insert  into `location_info`(`column`,`face`,`floor`,`row`) values 
(5,6,3,5);

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
('/20020504.jpg','20020504','游客-20020504','111111','2022-05-04','张三','男'),
('/20020508.jpg','20020508',NULL,NULL,'2022-05-24','游客-20020508',NULL),
('/20020509.jpg','20020509',NULL,NULL,'2022-05-24','游客-20020509',NULL),
('/20220510.jpg','20220510',NULL,NULL,'2022-05-10','游客-20220510',NULL),
('/202205101.jpg','202205101',NULL,NULL,'2022-05-24','游客-202205101',NULL),
('/2022051011.jpg','2022051011',NULL,NULL,'2022-05-24','游客-2022051011',NULL);

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
('20020508','1','user'),
('20020509','1','user'),
('20220510','1','user'),
('202205101','1','user'),
('2022051011','1','user'),
('root','1','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
