-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2016 at 02:44 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_book`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` int(11) NOT NULL,
  `BOOK_TITLE` varchar(60) NOT NULL,
  `PUBLISHER` varchar(60) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_BOOK_1` (`CATEGORY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `CATEGORY_ID`, `BOOK_TITLE`, `PUBLISHER`) VALUES
(1, 1, 'Practical Clojure', 'Apress'),
(2, 2, 'Beginning Groovy, Grails and\r\nGriffon', 'Apress'),
(3, 2, 'Definitive Guide to Grails 2', 'Apress'),
(4, 2, 'Groovy and Grails Recipes', 'Apress'),
(5, 3, 'Modern Java Web Development', 'Apress'),
(6, 3, 'Java 7 Recipes', 'Apress'),
(7, 3, 'Java EE 7 Recipes', 'Apress'),
(8, 3, 'Beginning Java 7 ', 'Apress'),
(9, 3, 'Pro Java 7 NIO.2', 'Apress'),
(10, 3, 'Java 7 for Absolute Beginners', 'Apress'),
(11, 3, 'Oracle Certified Java Enterprise\r\nArchitect Java EE7', 'Apress'),
(12, 4, 'Beginning Scala', 'Apress');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_BOOK_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
