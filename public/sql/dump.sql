CREATE DATABASE  IF NOT EXISTS `xpeddata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `xpeddata`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: xpeddata
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `excursion` (
  `COUNTRY` varchar(255) DEFAULT NULL,
  `EXCURSION` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LAT` float DEFAULT NULL,
  `LONGIT` float DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  `DESCR` varchar(255) DEFAULT NULL,
  `REVIEWSCORE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
INSERT INTO `excursion` VALUES ('England','ExA','park',52.6049,1.6089,'website','desc',4.7),('England','ExB','park',50.5719,3.9207,'website','desc',4.8),('England','ExC','museum',51.4769,0.0005,'website','desc',4.5),('England','ExD','museum',51.5194,0.127,'website','desc',4.7),('England','ExE','castle',51.4839,0.6044,'website','desc',4.6),('England','ExF','castle',52.2792,1.5852,'website','desc',4.5),('England','ExG','zoo',53.2273,2.8844,'website','desc',4.7),('England','ExH','zoo',51.5353,0.1534,'website','desc',4.3),('England','ExI','beach',50.719,1.8512,'website','desc',4.6),('England','ExJ','beach',50.4165,5.1002,'website','desc',4.7);
/*!40000 ALTER TABLE `excursion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `USERID` int DEFAULT NULL,
  `LNAME` varchar(255) DEFAULT NULL,
  `FNAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'B','Tom','Email','Pass'),(2,'C','Yom','Email2','Pass2'),(3,'D','Jom','Email3','Pass3'),(4,'F','Kom','Email4','Pass4'),(5,'E','Pom','Email5','Pass5');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-29  9:53:26
