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
(1, 'João Samuel Gomes', 'Rua dos testes', 'Betest', 'Ijuí', 'RS', '98700-000', '(55)99999-9999');

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

--
-- Dumping data for table `tbl_produto`
--

INSERT INTO `tbl_produto` (`pk_id_produto`, `nome_produto`, `valor_produto`, `estoque_produto`) VALUES
(1, 'Placa-Mãe Gigabyte B550M Aorus Elite, AMD AM4, Micro ATX, DDR4', 849.99, 27);

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

--
-- Dumping data for table `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`pk_id_usuario`, `nome_usuario`, `login_usuario`, `senha_usuario`) VALUES
(1, 'Administrador', 'Admin', 'admin');

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
(1, 1, '2022-09-26', 849.99, 849.99, 0);

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
-- Dumping data for table `tbl_vendas_produtos`
--

INSERT INTO `tbl_vendas_produtos` (`pk_id_venda_produto`, `fk_produto`, `fk_venda`, `produto_valor`, `produto_quantidade`) VALUES
(1, 1, 1, 849.99, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`pk_id_cliente`);

--
-- Indexes for table `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pk_id_produto`);

--
-- Indexes for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`pk_id_usuario`);

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
  MODIFY `pk_id_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `pk_id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  MODIFY `pk_id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  MODIFY `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
