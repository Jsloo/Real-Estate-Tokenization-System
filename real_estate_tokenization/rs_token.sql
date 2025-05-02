-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 21, 2023 at 01:54 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rs_token`
--

-- --------------------------------------------------------

--
-- Table structure for table `investor`
--

DROP TABLE IF EXISTS `investor`;
CREATE TABLE IF NOT EXISTS `investor` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Secret_Key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `investor`
--

INSERT INTO `investor` (`ID`, `Name`, `Password`, `Secret_Key`) VALUES
(17, 'Anson', 'Anson', '5ZSV9CCSzL/oUlgS8qwgiHH+NiatNvLfkcjJuA8Kdts='),
(16, 'Marcus', 'Marcus', 'c14n4ipKPrNsTHHUbQrmLwt0LuXI9s4+NAM61y61Zkw=');

-- --------------------------------------------------------

--
-- Table structure for table `projectowner`
--

DROP TABLE IF EXISTS `projectowner`;
CREATE TABLE IF NOT EXISTS `projectowner` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Secret_Key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `projectowner`
--

INSERT INTO `projectowner` (`ID`, `Name`, `Password`, `Secret_Key`) VALUES
(7, 'Peter', 'Peter', 'mZZMpz0LjcliXvCQPVX/CJtsUjiSYDjKw8FJW3zUvuE='),
(8, 'Jason', 'Jason', 'VHq7pmB07m/oW+ifGK7kR6Qdor+5yy0XmRpsjJqNRkY=');

-- --------------------------------------------------------

--
-- Table structure for table `realestate`
--

DROP TABLE IF EXISTS `realestate`;
CREATE TABLE IF NOT EXISTS `realestate` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Token_Name` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `ZipCode` int DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `TokenAmount` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `POwner_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `POwner_ID` (`POwner_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `realestate`
--

INSERT INTO `realestate` (`ID`, `Token_Name`, `State`, `City`, `ZipCode`, `Address`, `TokenAmount`, `Price`, `image`, `POwner_ID`) VALUES
(24, 'Pinnalce', 'Selangor', 'Puchong', 57000, 'Jalan Teknologi 5, Taman Teknologi Malaysia, 57000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur', 15000, 2000, 'C:\\Users\\User\\Desktop\\Year 3 Sem 1\\BlockChain\\Ass\\property3.jpg', 7),
(23, 'Kenny Home', 'Negeri Sembilan', 'Seremban', 57000, 'Jalan Teknologi 5, Taman Teknologi Malaysia, 57000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur', 5000, 1000, 'C:\\Users\\User\\Desktop\\Year 3 Sem 1\\BlockChain\\Ass\\property2.jpg', 7),
(22, 'Nirvana', 'Kuala Lumpur', 'Kuala Lumpur', 57000, 'Jalan Teknologi 5, Taman Teknologi Malaysia, 57000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur', 10000, 1500, 'C:\\Users\\User\\Desktop\\Year 3 Sem 1\\BlockChain\\Ass\\property1.jpeg', 7),
(21, 'Endah Promenade', 'Kuala Lumpur', 'Kuala Lumpur', 123213, 'Kuala Lumpur', 250, 5000, 'C:\\Users\\User\\Documents\\WeChat Image_20210423152526.jpg', 8);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
CREATE TABLE IF NOT EXISTS `sale` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Investor_ID` int DEFAULT NULL,
  `RealEstate_ID` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Investor_ID` (`Investor_ID`),
  KEY `RealEstate_ID` (`RealEstate_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`ID`, `Investor_ID`, `RealEstate_ID`, `Amount`, `Price`) VALUES
(8, 17, 23, 10, 3500),
(7, 16, 22, 8, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `tokenwallet`
--

DROP TABLE IF EXISTS `tokenwallet`;
CREATE TABLE IF NOT EXISTS `tokenwallet` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Investor_ID` int DEFAULT NULL,
  `RealEstate_ID` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Investor_ID` (`Investor_ID`),
  KEY `RealEstate_ID` (`RealEstate_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tokenwallet`
--

INSERT INTO `tokenwallet` (`ID`, `Investor_ID`, `RealEstate_ID`, `Amount`) VALUES
(20, 16, 23, 40),
(19, 17, 23, 52),
(18, 16, 22, 100),
(17, 16, 21, 140);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FromInvestor_ID` int DEFAULT NULL,
  `ToInvestor_ID` int DEFAULT NULL,
  `RealEstate_ID` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Market` varchar(255) DEFAULT NULL,
  `from_encrypted` varchar(255) NOT NULL,
  `to_encrypted` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FromInvestor_ID` (`FromInvestor_ID`),
  KEY `ToInvestor_ID` (`ToInvestor_ID`),
  KEY `RealEstate_ID` (`RealEstate_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`ID`, `FromInvestor_ID`, `ToInvestor_ID`, `RealEstate_ID`, `Amount`, `Market`, `from_encrypted`, `to_encrypted`) VALUES
(41, 8, 16, 24, 50, 'primary', '3Wr4tvbwoVHodUipmVv9mRNo6eipHYdQEd+nTeeljhM=', 'Sn9ssHB6HJeic+cR8xuL5fq8kcUzQCdR4pAA9dDrwZg='),
(38, 16, 17, 21, 2, 'second', 'uziSIP9POtNK6nwDoXd8Uvq8kcUzQCdR4pAA9dDrwZg=', '36XRIVheg3BwHzcXK1As3uAc9wP1WgkhUIe7hlawuGk='),
(39, 8, 17, 22, 100, 'primary', 'ib1aC3dUor4LMSogcoDGj/TCrremheUJGR1ExzmxXoY=', 'EnAG2Lx1xwDMzGDE6NKv+JCJxzBuzneymALd2qDDlss='),
(42, 17, 16, 23, 40, 'second', '5G0e0APF5DiO88L+GRdd/5CJxzBuzneymALd2qDDlss=', 'kRaFR9iV4Naif4wcFyQsePh9e6eB8hkg4w6Rx/248eU='),
(40, 7, 16, 22, 50, 'primary', 'iNshxMjEUj0CTPYypx6L6A9bQ1omjhNPyUwrhwo6abA=', 'oSt0Y9Bn79CRuV8hxvEC6/q8kcUzQCdR4pAA9dDrwZg='),
(36, 8, 16, 23, 100, 'primary', '7z0csCd9bhzN09a+wO1pvvTCrremheUJGR1ExzmxXoY=', 'mrHg/QVD66wLDgyoF7Q/Qfh9e6eB8hkg4w6Rx/248eU='),
(37, 7, 16, 22, 50, 'primary', 'iNshxMjEUj0CTPYypx6L6A9bQ1omjhNPyUwrhwo6abA=', 'oSt0Y9Bn79CRuV8hxvEC6/q8kcUzQCdR4pAA9dDrwZg=');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
