-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: testing
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `consume`
--

LOCK TABLES `consume` WRITE;
/*!40000 ALTER TABLE `consume` DISABLE KEYS */;
INSERT INTO `consume` VALUES (1,'2016-11-30',6,'吃蒙古烤肉',60,'06132476',NULL,-1),(1,'2016-10-18',2,'鮮五洞',109,'09412035',NULL,0),(1,'2016-12-05',2,'鮮五棟',99,'09432928',NULL,-1),(1,'2016-11-01',4,'御茶園',23,'20468260',NULL,-1),(1,'2016-11-02',4,'御茶園+菸',98,'20469427',NULL,-1),(1,'2016-11-02',4,'御茶園檸檬紅茶',25,'20469652',NULL,-1),(1,'2016-11-03',4,'御茶園',23,'20470648',NULL,-1),(1,'2016-11-08',4,'御茶園',23,'20476774',NULL,-1),(1,'2016-11-09',4,'御茶園',23,'20477997',NULL,-1),(1,'2016-11-09',4,'御茶園檸檬紅茶',25,'20478212',NULL,-1),(1,'2016-11-10',4,'御茶園+菸',98,'20479205',NULL,-1),(1,'2016-11-14',4,'麥香紅茶',10,'20484540',NULL,-1),(1,'2016-11-16',4,'御茶園',23,'20486624',NULL,-1),(1,'2016-11-16',4,'麥香紅茶',10,'20487010',NULL,-1),(1,'2016-11-17',4,'御茶園',23,'20487851',NULL,-1),(1,'2016-11-18',4,'御茶園',23,'20489172',NULL,-1),(1,'2016-11-18',4,'御茶園',25,'20489398',NULL,-1),(1,'2016-12-07',4,'麥香紅茶',10,'20495874',NULL,-1),(1,'2016-11-21',4,'御茶園+菸',98,'20515334',NULL,-1),(1,'2016-11-24',4,'菸',85,'20519366',NULL,-1),(1,'2016-11-25',4,'御茶園',23,'20520024',NULL,-1),(1,'2016-11-25',4,'麥香紅茶',10,'20520441',NULL,-1),(1,'2016-12-05',4,'御茶園',23,'20531877',NULL,-1),(1,'2016-10-19',4,'御茶園',23,'25271135',NULL,0),(1,'2016-10-26',4,'御茶園',23,'25272332',NULL,0),(1,'2016-10-12',4,'麥香紅茶',10,'25313519',NULL,0),(1,'2016-10-13',4,'御茶園',23,'25314115',NULL,0),(1,'2016-10-13',4,'菸',75,'25314703',NULL,0),(1,'2016-10-14',4,'麥香紅茶',10,'25315848',NULL,0),(1,'2016-10-19',4,'菸',75,'25322054',NULL,0),(1,'2016-10-20',4,'御茶園',23,'25322968',NULL,0),(1,'2016-10-20',4,'飲料',20,'25323189',200,1),(1,'2016-10-21',4,'御茶園檸檬紅茶',25,'25323958',NULL,0),(1,'2016-10-24',4,'飲料',29,'25327644',NULL,0),(1,'2016-10-25',4,'御茶園',23,'25328794',NULL,0),(1,'2016-10-25',4,'御茶園檸檬紅茶',25,'25329058',NULL,0),(1,'2016-10-25',4,'菸',75,'25329416',NULL,0),(1,'2016-10-26',4,'麥香紅茶',10,'25330490',NULL,0),(1,'2016-10-27',4,'御茶園',23,'25331282',NULL,0),(1,'2016-11-11',4,'影印',5,'39543148',NULL,-1),(1,'2016-11-07',5,'92無鉛',78,'43087316',NULL,-1),(1,'2016-12-04',5,'95無鉛',968,'43094506',NULL,-1),(1,'2016-12-05',5,'92無鉛',97,'43094706',NULL,-1),(1,'2016-10-28',5,'92無鉛',97,'43096981',NULL,0),(1,'2016-10-18',5,'92無鉛',97,'43099428',NULL,0),(1,'2016-11-05',2,'Mos Burger',325,'51947017',NULL,-1),(1,'2016-12-03',4,'麥香紅茶',5,'66088741',NULL,-1),(1,'2016-11-23',7,'奶嘴',144,'84325228',NULL,-1),(1,'2016-11-07',4,'御茶園+菸',98,'87723390',NULL,-1),(1,'2016-10-07',5,'92無鉛',100,'91699388',NULL,0);
/*!40000 ALTER TABLE `consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mail_template`
--

LOCK TABLES `mail_template` WRITE;
/*!40000 ALTER TABLE `mail_template` DISABLE KEYS */;
INSERT INTO `mail_template` VALUES (1,'<div style=\"border:1px solid #ccc; width:500px; padding: 10px; background-color:#fefefe;\">\r\n    <p style=\"font-size: 16px;\">親愛的 <b>{0}</b> 您好：</p>\r\n    <hr style=\"border: 0px; border-bottom:1px dashed #ececec;\">\r\n    <p>恭喜您的發票中獎！</p>\r\n	<p>中獎資訊</p>','<div style=\"background-color:#fff; border:1px solid #ececec; padding: 10px; text-align:center; font-size: 22px; font-weight:bold;\">','</div>','<p style=\"background-color:#eee; color: #bf4736; padding: 10px; text-align:center;\">提醒您記得去領獎唷，啾咪！</p>\r\n	<p style=\"text-align:right; color:#666; padding-top:30px;\">Exfantasy團隊敬上</p>\r\n</div>');
/*!40000 ALTER TABLE `mail_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tommy.yeh1112@gmail.com','$2a$08$w/bObZ1DZglyjnSOLCTSH.fGzvvhBXUPh7N9LN1MBUFd8imuKB9mG','0988147589','tommyyeh','Y','2016-09-23','2016-12-13 15:22:10'),(2,'alicechen0913@gmail.com','$2a$08$/0rlakO3Sf73eE.cemgvn.nqPJkMk0/V/sLSltIKo0ZFkSX4MX5WO','0936902592','alicechen','Y','2016-10-07','2016-11-22 15:30:31'),(3,'bensonQQQQ@gmail.com','$2a$08$mgoCGk2Iyn.YEWvqtnjxke7Qezpyx6lIRLc1TnRWf1qIYCXCWDW2O','0912345678','bensonQQQQ','Y','2016-10-31','2016-10-31 16:34:01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'admin'),(2,'user'),(3,'user');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14 10:43:44
