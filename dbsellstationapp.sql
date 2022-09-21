-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 21, 2022 at 04:55 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbsellstationapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cliente`
--

CREATE TABLE `tbl_cliente` (
  `pk_id_cliente` bigint(20) UNSIGNED NOT NULL,
  `nome_cliente` varchar(300) NOT NULL,
  `endereco_cliente` varchar(350) NOT NULL,
  `bairro_cliente` varchar(200) NOT NULL,
  `cidade_cliente` varchar(200) NOT NULL,
  `estado_cliente` varchar(2) NOT NULL,
  `cep_cliente` varchar(9) NOT NULL,
  `telefone_cliente` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_cliente`
--

INSERT INTO `tbl_cliente` (`pk_id_cliente`, `nome_cliente`, `endereco_cliente`, `bairro_cliente`, `cidade_cliente`, `estado_cliente`, `cep_cliente`, `telefone_cliente`) VALUES
(1, 'Pedro Certezas', 'Rua Alagoinha', 'Alagado', 'Maceio', 'AL', '57000-000', '(82)9999-9999');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_produto`
--

CREATE TABLE `tbl_produto` (
  `pk_id_produto` bigint(20) UNSIGNED NOT NULL,
  `nome_produto` varchar(300) NOT NULL,
  `valor_produto` double NOT NULL,
  `estoque_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `pk_id_usuario` bigint(20) UNSIGNED NOT NULL,
  `nome_usuario` varchar(300) NOT NULL,
  `login_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vendas`
--

CREATE TABLE `tbl_vendas` (
  `pk_id_vendas` bigint(20) UNSIGNED NOT NULL,
  `fk_cliente_vendas` bigint(20) UNSIGNED NOT NULL,
  `data_venda_vendas` date NOT NULL,
  `venda_liquido_vendas` double NOT NULL,
  `venda_bruto_vendas` double NOT NULL,
  `desconto_vendas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_vendas`
--

INSERT INTO `tbl_vendas` (`pk_id_vendas`, `fk_cliente_vendas`, `data_venda_vendas`, `venda_liquido_vendas`, `venda_bruto_vendas`, `desconto_vendas`) VALUES
(1, 1, '2022-09-20', 60, 60, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vendas_produtos`
--

CREATE TABLE `tbl_vendas_produtos` (
  `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_venda` bigint(20) UNSIGNED NOT NULL,
  `produto_valor` double NOT NULL,
  `produto_quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`pk_id_cliente`),
  ADD UNIQUE KEY `id_cliente` (`pk_id_cliente`);

--
-- Indexes for table `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pk_id_produto`),
  ADD UNIQUE KEY `pk_id_produto` (`pk_id_produto`);

--
-- Indexes for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`pk_id_usuario`),
  ADD UNIQUE KEY `id_usuario` (`pk_id_usuario`);

--
-- Indexes for table `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  ADD PRIMARY KEY (`pk_id_vendas`);

--
-- Indexes for table `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  ADD PRIMARY KEY (`pk_id_venda_produto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  MODIFY `pk_id_cliente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `pk_id_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `pk_id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  MODIFY `pk_id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  MODIFY `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
