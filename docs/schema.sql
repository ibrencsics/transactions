-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.25 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-12-15 02:16:08
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table transaction_test.transaction_test_table
DROP TABLE IF EXISTS `transaction_test_table`;
CREATE TABLE IF NOT EXISTS `transaction_test_table` (
  `time` varchar(50) NOT NULL,
  `action` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table transaction_test.transaction_test_table: ~11 rows (approximately)
DELETE FROM `transaction_test_table`;
/*!40000 ALTER TABLE `transaction_test_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_test_table` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
