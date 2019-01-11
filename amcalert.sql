-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2019 at 10:34 AM
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
  `CREATOR_NAME` varchar(100) NOT NULL,
  `CREATOR_DESIG` varchar(100) NOT NULL,
  `OLD_PASSWORD` varchar(100) NOT NULL,
  `branchCode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login_id`
--

INSERT INTO `login_id` (`ID`, `USER_NAME`, `PASSWORD`, `ASSOCIATED_GRP`, `GRP_CODE`, `USER_GRP`, `ROLE`, `UPDATE_TIME_STAMP`, `ACTIVE_STAT`, `INSERT_TIME_STAMP`, `CREATOR_NAME`, `CREATOR_DESIG`, `OLD_PASSWORD`, `branchCode`) VALUES
(1, 'admin', 'password', 'ADMIN', 'ADMIN', 'ADMIN', 'ADMIN', NULL, 'Y', NULL, 'ABISH', 'ASSISTANT', 'sanima@123', 1),
(0, 'abish', 'ojha', 'USER', 'ROLE_USER', 'USER', 'USER', '2017-09-10 03:43:32', 'Y', '2017-09-05', 'SUDIP', 'OFFICER', 'nepal', 1),
(3, 'anup', 'naxal@123', 'sadmin', 'SUPER ADMIN', 'SADMIN', 'SADMIN', '2017-09-11 01:20:31', 'Y', NULL, 'ABISH', 'ASSIS', '', 1);

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
(1, 'abish', 'ojha', 'Y'),
(2, 'abish', 'ojhaa', 'Y'),
(3, 'saugan', 'baniya', 'Y'),
(4, 'bfg', 'fgjfg', 'Y'),
(5, 'bfg', 'fgjfg', 'Y'),
(6, 'aaa', 'bbb', 'Y'),
(7, 'qqq', 'qqq', 'Y'),
(8, 'sdgsdg', 'gdsfg', 'Y'),
(9, 'ffdh', 'dhdgh', 'Y'),
(10, 'fgfdg', 'jfdg', 'Y'),
(11, 'xvbfs', 'sbs', 'Y'),
(12, 'sbs', 'sgsdg', 'Y'),
(13, 'gsfgs', 'sgsg', 'Y'),
(14, 'sgasg', 'sdgs', 'Y'),
(15, 'fdfdsh', 'fhfdhdhf', 'Y'),
(16, 'fdh', 'hddf', 'Y'),
(17, 'sdg', 'ggsd', 'Y'),
(18, 'absih', 'ojha', 'Y'),
(19, 'dsg', 'gdfgh', 'Y'),
(20, 'sg', 'sg', 'Y'),
(21, 'sdgs', 'gsd', 'Y'),
(22, 'dfsd', 'fgfd', 'Y'),
(23, 'abishek', 'ojhaaaa', 'Y'),
(24, 'sdg', 'gsg', 'Y'),
(25, 'sdgsdg', 'gsdg', 'Y'),
(26, 'fgdfh', 'dhdgh', 'Y'),
(27, 'ram', 'thakur', 'Y'),
(28, 'sdgs', 'sdgsd', 'Y'),
(29, 'raju', 'bala', 'Y');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_vendors`
--
ALTER TABLE `tbl_vendors`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_vendors`
--
ALTER TABLE `tbl_vendors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
