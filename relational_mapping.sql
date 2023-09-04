-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2023 at 12:33 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `relational_mapping`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `gender`, `student_name`) VALUES
(3, 'Male', 'Rejaur Rahman'),
(4, 'Male', 'Zilani'),
(5, 'Male', 'Khalid'),
(6, 'Male', 'Moien');

-- --------------------------------------------------------

--
-- Table structure for table `student_subject`
--

CREATE TABLE `student_subject` (
  `student_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_subject`
--

INSERT INTO `student_subject` (`student_id`, `subject_id`) VALUES
(5, 1),
(3, 2),
(3, 1),
(6, 6),
(6, 1),
(4, 1),
(4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` bigint(20) NOT NULL,
  `marks` int(11) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `marks`, `subject_name`) VALUES
(1, 90, 'Math'),
(2, 95, 'Physics'),
(3, 85, 'Chemistry'),
(5, 85, 'Biology'),
(6, 80, 'Bangla');

-- --------------------------------------------------------

--
-- Table structure for table `subject_student`
--

CREATE TABLE `subject_student` (
  `subject_subject_id` bigint(20) NOT NULL,
  `student_student_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD KEY `FK5cvx0kd792xhvd99s3bsbygfq` (`subject_id`),
  ADD KEY `FKnhw926s5os3ei5wqfaq94j0mh` (`student_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `subject_student`
--
ALTER TABLE `subject_student`
  ADD KEY `FKkop4rk2fii3k80ockf8cjtmqq` (`student_student_id`),
  ADD KEY `FKev01pf7gvc2bexwxulhg9e6a3` (`subject_subject_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD CONSTRAINT `FK5cvx0kd792xhvd99s3bsbygfq` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `FKnhw926s5os3ei5wqfaq94j0mh` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `subject_student`
--
ALTER TABLE `subject_student`
  ADD CONSTRAINT `FKev01pf7gvc2bexwxulhg9e6a3` FOREIGN KEY (`subject_subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `FKkop4rk2fii3k80ockf8cjtmqq` FOREIGN KEY (`student_student_id`) REFERENCES `student` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
