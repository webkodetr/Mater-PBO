-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2018 at 05:51 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `deskripsi` text,
  `hargabeli` double DEFAULT NULL,
  `hargajual` double DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `deskripsi`, `hargabeli`, `hargajual`, `stok`) VALUES
(1, 'Federasi', 'Jam Tangan Anti Air', 100000, 100000, 13),
(2, 'Grazy', 'Jam Tangan Brand', 150000, 150000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `id` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `supplier_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id`, `total`, `timestamp`, `supplier_id`, `user_id`) VALUES
(1, 1250000, '2018-07-20 06:36:16', 1, 1),
(2, 650000, '2018-07-20 14:29:02', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_detail`
--

CREATE TABLE `pembelian_detail` (
  `id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  `barang_id` int(11) NOT NULL,
  `pembelian_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian_detail`
--

INSERT INTO `pembelian_detail` (`id`, `qty`, `sub_total`, `barang_id`, `pembelian_id`) VALUES
(1, 5, 500000, 1, 1),
(2, 5, 750000, 2, 1),
(3, 2, 200000, 1, 2),
(4, 3, 450000, 2, 2);

--
-- Triggers `pembelian_detail`
--
DELIMITER $$
CREATE TRIGGER `pembelian_detail_AFTER_INSERT` AFTER INSERT ON `pembelian_detail` FOR EACH ROW BEGIN
	UPDATE barang
    SET stok = stok + NEW.qty
    WHERE id = NEW.barang_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `total`, `timestamp`, `user_id`) VALUES
(1, 400000, '2018-07-20 06:37:16', 1),
(2, 450000, '2018-07-20 14:32:45', 1);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_detail`
--

CREATE TABLE `penjualan_detail` (
  `id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  `barang_id` int(11) NOT NULL,
  `penjualan_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan_detail`
--

INSERT INTO `penjualan_detail` (`id`, `qty`, `sub_total`, `barang_id`, `penjualan_id`) VALUES
(1, 4, 400000, 1, 1),
(2, 3, 450000, 2, 2);

--
-- Triggers `penjualan_detail`
--
DELIMITER $$
CREATE TRIGGER `penjualan_detail_AFTER_INSERT` AFTER INSERT ON `penjualan_detail` FOR EACH ROW BEGIN
UPDATE barang
    SET stok = stok - NEW.qty
    WHERE id = NEW.barang_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `pemilik` varchar(50) DEFAULT NULL,
  `alamat` text,
  `no_telp` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `nama`, `pemilik`, `alamat`, `no_telp`, `email`) VALUES
(1, 'Dedi', 'Bangunan', 'Mataram', '098765467', 'Dedi@Gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  `alamat` text,
  `status` varchar(45) DEFAULT NULL,
  `foto` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `nama`, `no_telp`, `alamat`, `status`, `foto`) VALUES
(1, 'gerha', 'gerha', 'Gerha', '082235544974', 'PRAYA', 'mahasiswa', NULL),
(2, 'admin', 'admin', 'Role', '055566643322', 'Praya', 'Admin', NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_item_detail`
--
CREATE TABLE `v_item_detail` (
`pembelian_id` int(11)
,`barang_id` int(11)
,`nama` varchar(50)
,`hargabeli` double
,`qty` int(11)
,`sub_total` double
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_item_penjualan`
--
CREATE TABLE `v_item_penjualan` (
`penjualan_id` int(11)
,`barang_id` int(11)
,`nama` varchar(50)
,`hargajual` double
,`qty` int(11)
,`sub_total` double
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_pembelian`
--
CREATE TABLE `v_pembelian` (
`id` int(11)
,`tanggal_waktu` timestamp
,`total` double
,`supplier_nama` varchar(100)
,`user_nama` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_penjualan`
--
CREATE TABLE `v_penjualan` (
`id` int(11)
,`tanggal_waktu` timestamp
,`total` double
,`user_nama` varchar(50)
);

-- --------------------------------------------------------

--
-- Structure for view `v_item_detail`
--
DROP TABLE IF EXISTS `v_item_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_item_detail`  AS  select `p`.`id` AS `pembelian_id`,`b`.`id` AS `barang_id`,`b`.`nama` AS `nama`,`b`.`hargabeli` AS `hargabeli`,`pd`.`qty` AS `qty`,`pd`.`sub_total` AS `sub_total` from ((`pembelian_detail` `pd` join `barang` `b` on((`b`.`id` = `pd`.`barang_id`))) join `pembelian` `p` on((`p`.`id` = `pd`.`pembelian_id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_item_penjualan`
--
DROP TABLE IF EXISTS `v_item_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_item_penjualan`  AS  select `p`.`id` AS `penjualan_id`,`b`.`id` AS `barang_id`,`b`.`nama` AS `nama`,`b`.`hargajual` AS `hargajual`,`pd`.`qty` AS `qty`,`pd`.`sub_total` AS `sub_total` from ((`penjualan_detail` `pd` join `barang` `b` on((`b`.`id` = `pd`.`barang_id`))) join `penjualan` `p` on((`p`.`id` = `pd`.`penjualan_id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_pembelian`
--
DROP TABLE IF EXISTS `v_pembelian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_pembelian`  AS  select `p`.`id` AS `id`,`p`.`timestamp` AS `tanggal_waktu`,`p`.`total` AS `total`,`s`.`nama` AS `supplier_nama`,`u`.`nama` AS `user_nama` from ((`pembelian` `p` join `supplier` `s` on((`s`.`id` = `p`.`supplier_id`))) join `user` `u` on((`u`.`id` = `p`.`user_id`))) order by `p`.`id` ;

-- --------------------------------------------------------

--
-- Structure for view `v_penjualan`
--
DROP TABLE IF EXISTS `v_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_penjualan`  AS  select `p`.`id` AS `id`,`p`.`timestamp` AS `tanggal_waktu`,`p`.`total` AS `total`,`u`.`nama` AS `user_nama` from (`penjualan` `p` join `user` `u` on((`u`.`id` = `p`.`user_id`))) order by `p`.`id` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pembelian_supplier_idx` (`supplier_id`),
  ADD KEY `fk_pembelian_users1_idx` (`user_id`);

--
-- Indexes for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pembelian_detail_barang1_idx` (`barang_id`),
  ADD KEY `fk_pembelian_detail_pembelian1_idx` (`pembelian_id`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_penjualan_users1_idx` (`user_id`);

--
-- Indexes for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_penjualan_detail_barang1_idx` (`barang_id`),
  ADD KEY `fk_penjualan_detail_penjualan1_idx` (`penjualan_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `fk_pembelian_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pembelian_users1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  ADD CONSTRAINT `fk_pembelian_detail_barang1` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pembelian_detail_pembelian1` FOREIGN KEY (`pembelian_id`) REFERENCES `pembelian` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `fk_penjualan_users1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD CONSTRAINT `fk_penjualan_detail_barang1` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_penjualan_detail_penjualan1` FOREIGN KEY (`penjualan_id`) REFERENCES `penjualan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
