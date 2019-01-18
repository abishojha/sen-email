-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 18, 2019 at 10:39 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `amcalert`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_id`
--

CREATE TABLE `login_id` (
  `ID` int(11) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(400) NOT NULL,
  `ASSOCIATED_GRP` varchar(45) DEFAULT NULL,
  `GRP_CODE` varchar(150) DEFAULT NULL,
  `USER_GRP` varchar(100) DEFAULT NULL,
  `ROLE` varchar(1000) NOT NULL,
  `UPDATE_TIME_STAMP` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ACTIVE_STAT` char(1) NOT NULL DEFAULT 'N',
  `INSERT_TIME_STAMP` date DEFAULT NULL,
  `CREATOR_NAME` varchar(100) DEFAULT NULL,
  `CREATOR_DESIG` varchar(100) DEFAULT NULL,
  `OLD_PASSWORD` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login_id`
--

INSERT INTO `login_id` (`ID`, `USER_NAME`, `PASSWORD`, `ASSOCIATED_GRP`, `GRP_CODE`, `USER_GRP`, `ROLE`, `UPDATE_TIME_STAMP`, `ACTIVE_STAT`, `INSERT_TIME_STAMP`, `CREATOR_NAME`, `CREATOR_DESIG`, `OLD_PASSWORD`) VALUES
(13, 'ADMIN', 'password', 'IT', NULL, 'ADMIN', 'ROLE_ADMIN', '2019-01-17 10:18:45', 'Y', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_amcdates`
--

CREATE TABLE `tbl_amcdates` (
  `id` int(11) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `amc_purpose` varchar(500) NOT NULL,
  `amc_from` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amc_to` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `amc_status` varchar(50) NOT NULL,
  `email_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_amcdates`
--

INSERT INTO `tbl_amcdates` (`id`, `vendor_id`, `amc_purpose`, `amc_from`, `amc_to`, `amc_status`, `email_status`) VALUES
(1, 1, 'HARDWARE SUPPORT AND BRANCH SUPPORT', '2018-12-31 18:15:00', '2019-02-27 18:15:00', 'Y', 'N'),
(2, 1, 'HOLIDAY SUPPORT', '2018-12-31 18:15:00', '2019-02-26 18:15:00', 'Y', 'N'),
(3, 2, 'ECC ', '2019-02-01 18:15:00', '2019-03-30 18:15:00', 'Y', 'N'),
(4, 2, 'ARU K K', '2019-01-16 18:15:00', '2019-02-27 18:15:00', 'Y', 'N'),
(5, 4, 'FONE BANK SUPPORT', '2019-01-31 18:15:00', '2019-04-29 18:15:00', 'Y', 'N'),
(6, 4, 'INTERNET BANKING', '2019-01-14 18:15:00', '2019-03-27 18:15:00', 'Y', 'N'),
(7, 5, 'FINACLE UPGRADATION', '2019-01-14 18:15:00', '2019-03-14 18:15:00', 'Y', 'N'),
(8, 5, 'CUTOMIZATION AND UPGRADATION', '2019-01-15 18:15:00', '2019-03-28 18:15:00', 'Y', 'N'),
(9, 15, 'NETWORK SECURITY', '2019-01-15 18:15:00', '2019-08-30 18:15:00', 'Y', 'N'),
(10, 15, 'NETWORK', '2019-01-10 18:15:00', '2019-03-21 18:15:00', 'Y', 'N'),
(11, 15, 'FORTIGATE', '2019-01-14 18:15:00', '2019-03-21 18:15:00', 'Y', 'N'),
(12, 5, 'BI', '2019-01-14 18:15:00', '2019-03-27 18:15:00', 'Y', 'N'),
(13, 16, 'IPS CHARGE', '2019-01-14 18:15:00', '2019-03-07 18:15:00', 'Y', 'N'),
(14, 34, 'building maintanennce', '2019-01-15 18:15:00', '2019-04-17 18:15:00', 'Y', 'N'),
(15, 34, 'test', '2019-01-15 18:15:00', '2019-03-20 18:15:00', 'Y', 'N'),
(16, 34, 'aa', '2019-01-16 18:15:00', '2019-04-29 18:15:00', 'Y', 'N'),
(17, 34, 'sfadfs', '2019-01-15 18:15:00', '2019-03-27 18:15:00', 'Y', 'N'),
(18, 35, 'SAS', '2019-01-16 18:15:00', '2019-03-15 18:15:00', 'Y', 'N'),
(19, 35, 'SUPPORT', '2019-01-16 18:15:00', '2019-04-29 18:15:00', 'Y', 'N'),
(20, 1, 'SUPPORT PERSON', '2019-01-17 18:15:00', '2019-03-21 18:15:00', 'Y', 'N');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vendors`
--

CREATE TABLE `tbl_vendors` (
  `id` int(11) NOT NULL,
  `vendorName` varchar(500) NOT NULL,
  `vendorPurpose` varchar(500) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_vendors`
--

INSERT INTO `tbl_vendors` (`id`, `vendorName`, `vendorPurpose`, `status`) VALUES
(1, 'IT LINX', 'HANDWARE SUPPPORT', 'Y'),
(2, 'integrated solution', '4428979 , pulchok', 'Y'),
(3, 'NTC ', 'CHABAHIL, 97997', 'Y'),
(4, 'F1SOFT', 'ANWAR, HATISAR', 'Y'),
(5, 'CAS TRADING', 'RAJU BALA, ANAMNAGAR', 'Y'),
(6, 'q', 'q', 'Y'),
(7, 'qw', 'qq', 'Y'),
(8, 'qqq', 'qqq', 'Y'),
(9, 'wqwq', 'wqwq', 'Y'),
(10, 'wqwa', 'qqq', 'Y'),
(11, 'qwqwq', 'qwqwq', 'Y'),
(12, 'etwet', 'srtgd', 'Y'),
(14, 'eryy', 'ythrety', 'Y'),
(15, 'DRISTI TECH', 'NETWORK SECURITY', 'Y'),
(16, 'SANIMA BANK', 'IPS', 'Y'),
(17, 'a', 'a', 'Y'),
(18, 'b', 'b', 'Y'),
(19, 'c', 'c', 'Y'),
(20, 'd', 'd', 'Y'),
(21, 'e', 'e', 'Y'),
(22, 'f', 'f', 'Y'),
(23, 'g', 'g', 'Y'),
(24, 'h', 'h', 'Y'),
(25, 'i', 'i', 'Y'),
(26, 'j', 'j', 'Y'),
(27, 'k', 'k', 'Y'),
(28, 'k', 'k', 'Y'),
(29, 'l', 'l', 'Y'),
(30, 'm', 'm', 'Y'),
(31, 'n', 'n', 'Y'),
(32, 'o', 'o', 'Y'),
(33, 'p', 'p', 'Y'),
(34, 'AAYUSH CONSTRUCTION', 'AAYUSH ,987654321', 'Y'),
(35, 'MAX INTERNATIONAL CAPITAL CENTRE', 'TEST', 'Y');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_id`
--
ALTER TABLE `login_id`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `USER_NAME` (`USER_NAME`);

--
-- Indexes for table `tbl_amcdates`
--
ALTER TABLE `tbl_amcdates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_vendors`
--
ALTER TABLE `tbl_vendors`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_id`
--
ALTER TABLE `login_id`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `tbl_amcdates`
--
ALTER TABLE `tbl_amcdates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_vendors`
--
ALTER TABLE `tbl_vendors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
