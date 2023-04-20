-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 20, 2023 at 11:21 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hant`
--

-- --------------------------------------------------------

--
-- Table structure for table `customeritem`
--

CREATE TABLE `customeritem` (
  `customerId` varchar(36) NOT NULL,
  `itemId` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `nationalId` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `purchaseDate` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `createdAt` date NOT NULL,
  `updatedAt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `id` varchar(36) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `userRole` varchar(50) NOT NULL,
  `action` varchar(50) NOT NULL,
  `actedOn` varchar(50) NOT NULL,
  `actedOnName` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `canCreateCustomer` tinyint(1) DEFAULT '1',
  `canViewCustomers` tinyint(1) DEFAULT '0',
  `canDeleteCustomer` tinyint(1) DEFAULT '0',
  `canUpdateCustomer` tinyint(1) DEFAULT '0',
  `canCreateItem` tinyint(1) DEFAULT '0',
  `canViewItems` tinyint(1) DEFAULT '0',
  `canDeleteItem` tinyint(1) DEFAULT '0',
  `canUpdateItem` tinyint(1) DEFAULT '0',
  `canViewUsers` tinyint(1) DEFAULT '0',
  `canCreateUser` tinyint(1) DEFAULT '0',
  `canViewLogs` tinyint(1) DEFAULT '0',
  `canCreateLog` tinyint(1) DEFAULT '0',
  `canDeleteLog` tinyint(1) DEFAULT '0',
  `canCreateRole` tinyint(1) DEFAULT '0',
  `canDeleteRole` tinyint(1) DEFAULT '0',
  `canUpdateRole` tinyint(1) DEFAULT '0',
  `canViewRoles` tinyint(1) DEFAULT '0',
  `canDeleteUser` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `roleName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customeritem`
--
ALTER TABLE `customeritem`
  ADD KEY `customerId` (`customerId`,`itemId`) USING BTREE,
  ADD KEY `itemId` (`itemId`) USING BTREE;

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `users_ibfk_2` (`roleName`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customeritem`
--
ALTER TABLE `customeritem`
  ADD CONSTRAINT `customeritem_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `customeritem_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `items` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleName`) REFERENCES `roles` (`name`) ON DELETE CASCADE,
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`roleName`) REFERENCES `roles` (`name`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
