-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 04, 2018 at 06:58 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `Id` int(11) NOT NULL,
  `Street` varchar(30) NOT NULL,
  `Town` varchar(30) NOT NULL,
  `Postcode` varchar(7) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `catagories`
--

DROP TABLE IF EXISTS `catagories`;
CREATE TABLE IF NOT EXISTS `catagories` (
  `Id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagories`
--

INSERT INTO `catagories` (`Id`, `name`) VALUES
(1, 'Building Materials');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `AdressId` int(11) NOT NULL,
  `FirstName` varchar(15) NOT NULL,
  `Surname` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Role` varchar(30) NOT NULL,
  `insert_time` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `Id` int(11) NOT NULL,
  `AdressId` int(11) NOT NULL,
  `PaymentId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `NumberOfProducts` int(11) NOT NULL,
  `HasBeenOrdered` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment details`
--

DROP TABLE IF EXISTS `payment details`;
CREATE TABLE IF NOT EXISTS `payment details` (
  `Id` int(11) NOT NULL,
  `CardNumber` int(16) NOT NULL,
  `ExpiryDate` int(4) NOT NULL,
  `NameOnCard` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `Id` int(15) NOT NULL,
  `Product_Name` varchar(160) NOT NULL,
  `Stock` int(15) NOT NULL,
  `Weight` int(15) NOT NULL,
  `Price` int(15) NOT NULL,
  `Description` varchar(160) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`Id`, `Product_Name`, `Stock`, `Weight`, `Price`, `Description`) VALUES
(13, 'Steel', 50, 60, 10, 'Steel beam'),
(2, 'Steel', 50, 60, 10, 'Steel beam'),
(3, 'Steel', 50, 60, 10, 'Steel beam'),
(4, 'Cement', 100, 5, 20, 'Cement'),
(5, 'Steel', 50, 60, 10, 'Steel beam'),
(6, 'Steel', 50, 60, 10, 'Steel beam'),
(7, 'Steel', 50, 60, 10, 'Steel beam'),
(8, 'Steel', 50, 60, 10, 'Steel beam'),
(9, 'Steel', 50, 60, 10, 'Steel beam'),
(10, 'Steel', 50, 60, 10, 'Steel beam'),
(11, 'Steel', 50, 60, 10, 'Steel beam'),
(12, 'Steel', 50, 60, 10, 'Steel beam'),
(14, 'Steel', 50, 60, 10, 'Steel beam'),
(15, 'Steel', 50, 60, 10, 'Steel beam'),
(16, 'Steel', 50, 60, 10, 'Steel beam'),
(17, 'Steel', 50, 60, 10, 'Steel beam'),
(18, 'Steel', 50, 60, 10, 'Steel beam'),
(19, 'Steel', 50, 60, 10, 'Steel beam'),
(20, 'Steel', 50, 60, 10, 'Steel beam'),
(21, 'Steel', 50, 60, 10, 'Steel beam'),
(22, 'Steel', 50, 60, 10, 'Steel beam'),
(23, 'Steel', 50, 60, 10, 'Steel beam'),
(24, 'Steel', 50, 60, 10, 'Steel beam'),
(25, 'Steel', 50, 60, 10, 'Steel beam'),
(26, 'Steel', 50, 60, 10, 'Steel beam'),
(27, 'Steel', 50, 60, 10, 'Steel beam'),
(28, 'Steel', 50, 60, 10, 'Steel beam'),
(29, 'Steel', 50, 60, 10, 'Steel beam'),
(30, 'Steel', 49, 60, 10, 'Steel beam');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
