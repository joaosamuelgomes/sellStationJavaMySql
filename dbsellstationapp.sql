DROP DATABASE IF EXISTS dbsellstationappteste;
CREATE DATABASE dbsellstationappteste;
USE dbsellstationappteste;

SET SQL_MODE = `NO_AUTO_VALUE_ON_ZERO`;
START TRANSACTION;
SET time_zone = `+00:00`;

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

INSERT INTO `tbl_cliente` (`pk_id_cliente`, `nome_cliente`, `endereco_cliente`, `bairro_cliente`, `cidade_cliente`, `estado_cliente`, `cep_cliente`, `telefone_cliente`) VALUES
(1, 'Pedro Certezas', 'Rua Alagoinha', 'Alagado', 'Maceio', 'AL', '57000-000', '(82)9999-9999'),
(2, 'Caze Mito', 'Testes', 'Sucess', 'Bom Jesus', 'TO', '78900-000', '(82)9921-0123');

CREATE TABLE `tbl_produto` (
  `pk_id_produto` bigint(20) UNSIGNED NOT NULL,
  `nome_produto` varchar(300) NOT NULL,
  `valor_produto` double NOT NULL,
  `estoque_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tbl_produto` (`pk_id_produto`, `nome_produto`, `valor_produto`, `estoque_produto`) VALUES
(1, 'SACO DE ARROZ', 137.5, 13),
(3, 'FEIJÃO 1KG', 7, 100);

CREATE TABLE `tbl_usuario` (
  `pk_id_usuario` bigint(20) UNSIGNED NOT NULL,
  `nome_usuario` varchar(300) NOT NULL,
  `login_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tbl_usuario` (`pk_id_usuario`, `nome_usuario`, `login_usuario`, `senha_usuario`) VALUES
(2, 'Gustavo', 'gustavo', '123');

CREATE TABLE `tbl_vendas` (
  `pk_id_venda` bigint(20) UNSIGNED NOT NULL,
  `fk_id_cliente` bigint(20) UNSIGNED NOT NULL,
  `data_venda` date NOT NULL,
  `valor_liquido` double NOT NULL,
  `valor_bruto` double NOT NULL,
  `valor_desconto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tbl_vendas_produtos` (
  `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_id_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_id_venda` bigint(20) UNSIGNED NOT NULL,
  `produto_valor` double NOT NULL,
  `produto_quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`pk_id_cliente`),
  ADD UNIQUE KEY `id_cliente` (`pk_id_cliente`);

ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pk_id_produto`),
  ADD UNIQUE KEY `pk_id_produto` (`pk_id_produto`);

ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`pk_id_usuario`),
  ADD UNIQUE KEY `id_usuario` (`pk_id_usuario`);

ALTER TABLE `tbl_vendas`
  ADD PRIMARY KEY (`pk_id_venda`);

ALTER TABLE `tbl_vendas_produtos`
  ADD PRIMARY KEY (`pk_id_venda_produto`);

ALTER TABLE `tbl_cliente`
  MODIFY `pk_id_cliente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `tbl_produto`
  MODIFY `pk_id_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `tbl_usuario`
  MODIFY `pk_id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `tbl_vendas`
  MODIFY `pk_id_venda` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `tbl_vendas_produtos`
  MODIFY `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

