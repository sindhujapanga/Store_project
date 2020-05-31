-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 04:25 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `dept_table`
--

CREATE TABLE `dept_table` (
  `dept_id` int(20) NOT NULL,
  `dept_name` varchar(20) NOT NULL,
  `dept_location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dept_table`
--

INSERT INTO `dept_table` (`dept_id`, `dept_name`, `dept_location`) VALUES
(101, 'food', 'hyd'),
(102, 'Dairy', 'hyd'),
(1223, 'home appliances', 'hyd'),
(1234, 'billing', 'hyd'),
(4545, 'food', 'hyd');

-- --------------------------------------------------------

--
-- Table structure for table `employee_table`
--

CREATE TABLE `employee_table` (
  `emp_id` int(20) NOT NULL,
  `emp_name` varchar(20) NOT NULL,
  `emp_level` varchar(20) NOT NULL,
  `dept_id` int(20) NOT NULL,
  `emp_hiredate` date NOT NULL,
  `emp_sal` int(20) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_table`
--

INSERT INTO `employee_table` (`emp_id`, `emp_name`, `emp_level`, `dept_id`, `emp_hiredate`, `emp_sal`, `user_id`) VALUES
(1, 'abc', 'small', 4545, '2020-01-06', 10000, 1),
(3, 'asd', 'm', 1223, '2020-03-02', 6458, 3),
(6, 'abc', 'large', 1234, '2020-03-19', 12333, 2),
(7, 'asd', 'medium', 101, '2020-05-05', 9876, 1),
(10, 'def', 'small', 102, '2020-01-06', 11000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `task_emptable`
--

CREATE TABLE `task_emptable` (
  `task_emp_id` int(20) NOT NULL,
  `task_status` tinyint(1) NOT NULL,
  `task_id` int(20) NOT NULL,
  `emp_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_emptable`
--

INSERT INTO `task_emptable` (`task_emp_id`, `task_status`, `task_id`, `emp_id`) VALUES
(1, 0, 1, 1),
(14, 0, 1, 1),
(15, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `task_table`
--

CREATE TABLE `task_table` (
  `task_id` int(20) NOT NULL,
  `task_status` tinyint(1) NOT NULL,
  `task_action` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_table`
--

INSERT INTO `task_table` (`task_id`, `task_status`, `task_action`) VALUES
(1, 1, 'packing'),
(7, 1, 'shipping'),
(8, 1, 'delivering'),
(10, 1, 'billing');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_username` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`user_id`, `user_name`, `user_username`, `user_password`, `user_role`) VALUES
(1, 'abc', 'abc456', '456', 'Employee'),
(2, 'uvw', 'uvw345', '345', 'Employee'),
(3, 'hjk', 'hjk45', '567', 'Employee'),
(1122, 'xyz', 'xyz123', '123', 'manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dept_table`
--
ALTER TABLE `dept_table`
  ADD PRIMARY KEY (`dept_id`);

--
-- Indexes for table `employee_table`
--
ALTER TABLE `employee_table`
  ADD PRIMARY KEY (`emp_id`),
  ADD KEY `employee_table_ibfk_1` (`dept_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `task_emptable`
--
ALTER TABLE `task_emptable`
  ADD PRIMARY KEY (`task_emp_id`),
  ADD KEY `task_id` (`task_id`),
  ADD KEY `emp_id` (`emp_id`);

--
-- Indexes for table `task_table`
--
ALTER TABLE `task_table`
  ADD PRIMARY KEY (`task_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dept_table`
--
ALTER TABLE `dept_table`
  MODIFY `dept_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4546;

--
-- AUTO_INCREMENT for table `employee_table`
--
ALTER TABLE `employee_table`
  MODIFY `emp_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `task_emptable`
--
ALTER TABLE `task_emptable`
  MODIFY `task_emp_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `task_table`
--
ALTER TABLE `task_table`
  MODIFY `task_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1123;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
