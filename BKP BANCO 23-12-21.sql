CREATE DATABASE  IF NOT EXISTS `venda_produtos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `venda_produtos`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: venda_produtos
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `codAutor` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_autor` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (4,'d902d');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `codCategoria` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'hjjhj');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `codCidade` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (4,'kdsjs'),(5,'city'),(6,'sss');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codCliente` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(60) DEFAULT NULL,
  `cidade_CodCidade` int unsigned NOT NULL DEFAULT '0',
  `sexo` char(1) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `cpf` varchar(25) DEFAULT NULL,
  `qtde_comprado` int DEFAULT NULL,
  PRIMARY KEY (`codCliente`),
  KEY `cliente_FKIndex1` (`cidade_CodCidade`),
  CONSTRAINT `cliente_fk1` FOREIGN KEY (`cidade_CodCidade`) REFERENCES `cidade` (`codCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (10,'Pedro',4,'M','uyuyuyu','0980-9','899.898',155),(11,'ana',5,'M','','','',507),(12,'teset',4,'M','','','',153),(13,'refs',4,'M','','','',96),(14,'autoridade',4,'M','','','',151),(16,'online',4,'M','','','',89),(17,'selec',5,'M','','','',216),(19,'teste',4,'M','','','',284);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `codCompra` int unsigned NOT NULL AUTO_INCREMENT,
  `fornecedor_CodFornecedor` int unsigned NOT NULL,
  `data_compra` date DEFAULT NULL,
  `valor_total` decimal(15,2) unsigned DEFAULT NULL,
  `valor_recebido` double(15,2) DEFAULT NULL,
  PRIMARY KEY (`codCompra`,`fornecedor_CodFornecedor`),
  KEY `compra_FKIndex1` (`fornecedor_CodFornecedor`),
  CONSTRAINT `compra_fk1` FOREIGN KEY (`fornecedor_CodFornecedor`) REFERENCES `fornecedor` (`codFornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (11,5,'2012-07-03',1500.00,NULL),(12,5,'2012-07-05',158.00,NULL),(13,6,'2012-07-05',32.00,NULL);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contas_receber`
--

DROP TABLE IF EXISTS `contas_receber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contas_receber` (
  `codContas_receber` int NOT NULL AUTO_INCREMENT,
  `venda_codVenda` int unsigned NOT NULL DEFAULT '0',
  `situacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codContas_receber`),
  KEY `fk_venda` (`venda_codVenda`),
  CONSTRAINT `fk_venda` FOREIGN KEY (`venda_codVenda`) REFERENCES `venda` (`codVenda`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contas_receber`
--

LOCK TABLES `contas_receber` WRITE;
/*!40000 ALTER TABLE `contas_receber` DISABLE KEYS */;
INSERT INTO `contas_receber` VALUES (1,61,'aberto'),(4,64,'aberto'),(5,66,'aberto'),(6,68,'aberto'),(7,69,'aberto'),(9,71,'aberto'),(10,72,'quitada'),(11,73,'aberto'),(12,74,'aberto');
/*!40000 ALTER TABLE `contas_receber` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_cr_bd` BEFORE DELETE ON `contas_receber` FOR EACH ROW delete from parcelas where cod_contas_receber = old.codContas_receber; */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `CodEditora` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_editora` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`CodEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (3,'jfkfd');
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pg`
--

DROP TABLE IF EXISTS `forma_pg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forma_pg` (
  `cod_forma_pg` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(120) DEFAULT NULL,
  `venda_codVenda` int unsigned NOT NULL DEFAULT '0',
  `NumParcelas` int unsigned DEFAULT NULL,
  PRIMARY KEY (`cod_forma_pg`),
  KEY `fk_FP` (`venda_codVenda`),
  CONSTRAINT `forma_pg_ibfk_1` FOREIGN KEY (`venda_codVenda`) REFERENCES `venda` (`codVenda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pg`
--

LOCK TABLES `forma_pg` WRITE;
/*!40000 ALTER TABLE `forma_pg` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_pg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `codFornecedor` int unsigned NOT NULL AUTO_INCREMENT,
  `cidade_CodCidade` int unsigned NOT NULL DEFAULT '0',
  `cnpj` varchar(30) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `nome_fornecedor` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codFornecedor`),
  KEY `fornecedor_FKIndex1` (`cidade_CodCidade`),
  CONSTRAINT `fornecedor_fk1` FOREIGN KEY (`cidade_CodCidade`) REFERENCES `cidade` (`codCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (5,4,'93805803','9890',NULL,'9809','98080808','ewo'),(6,4,'','',NULL,'','','djfdjkfl');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_compra`
--

DROP TABLE IF EXISTS `itens_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_compra` (
  `compra_CodCompra` int unsigned NOT NULL,
  `livro_codLivro` int unsigned NOT NULL,
  `preco_total` decimal(15,2) DEFAULT NULL,
  `quantidade` double(15,3) DEFAULT NULL,
  `valor_unitario` decimal(15,2) unsigned DEFAULT NULL,
  `sub_total` decimal(15,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`compra_CodCompra`,`livro_codLivro`),
  KEY `livro_has_compra_FKIndex2` (`compra_CodCompra`),
  KEY `livro_has_compra_FKIndex1` (`livro_codLivro`),
  CONSTRAINT `itens_compra_fk1` FOREIGN KEY (`compra_CodCompra`) REFERENCES `compra` (`codCompra`),
  CONSTRAINT `itens_compra_fk2` FOREIGN KEY (`livro_codLivro`) REFERENCES `livro` (`codLivro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_compra`
--

LOCK TABLES `itens_compra` WRITE;
/*!40000 ALTER TABLE `itens_compra` DISABLE KEYS */;
INSERT INTO `itens_compra` VALUES (11,10,1500.00,10.000,150.00,1500.00),(12,10,158.00,1.000,8.00,8.00),(12,12,158.00,1.000,8.00,8.00),(13,12,32.00,4.000,8.00,32.00);
/*!40000 ALTER TABLE `itens_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `itens_compra_AI` AFTER INSERT ON `itens_compra` FOR EACH ROW update livro set estoque_atual= estoque_atual + new.quantidade where  new.livro_codLivro =  codLivro; */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `itens_venda`
--

DROP TABLE IF EXISTS `itens_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_venda` (
  `venda_CodVenda` int unsigned NOT NULL DEFAULT '0',
  `livro_codLivro` int unsigned NOT NULL,
  `preco_total` decimal(15,2) DEFAULT NULL,
  `quantidade` double DEFAULT NULL,
  `valor_unitario` decimal(15,2) DEFAULT NULL,
  `sub_total` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`venda_CodVenda`,`livro_codLivro`),
  KEY `venda_has_livro_FKIndex1` (`venda_CodVenda`),
  KEY `venda_has_livro_FKIndex2` (`livro_codLivro`),
  CONSTRAINT `itens_venda_fk1` FOREIGN KEY (`venda_CodVenda`) REFERENCES `venda` (`codVenda`),
  CONSTRAINT `itens_venda_ibfk_1` FOREIGN KEY (`livro_codLivro`) REFERENCES `livro` (`codLivro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_venda`
--

LOCK TABLES `itens_venda` WRITE;
/*!40000 ALTER TABLE `itens_venda` DISABLE KEYS */;
INSERT INTO `itens_venda` VALUES (60,11,98.00,1,98.00,98.00),(61,10,256.00,1,150.00,150.00),(61,11,256.00,1,98.00,98.00),(61,12,256.00,1,8.00,8.00),(62,10,248.00,1,150.00,150.00),(62,11,248.00,1,98.00,98.00),(64,10,354.00,1,150.00,150.00),(64,11,354.00,2,98.00,196.00),(64,12,354.00,1,8.00,8.00),(65,11,98.00,1,98.00,98.00),(66,10,150.00,1,150.00,150.00),(67,11,196.00,2,98.00,196.00),(68,10,308.00,2,150.00,300.00),(68,12,308.00,1,8.00,8.00),(69,10,264.00,1,150.00,150.00),(69,11,264.00,1,98.00,98.00),(69,12,264.00,2,8.00,16.00),(70,10,764.00,3,150.00,450.00),(70,11,764.00,3,98.00,294.00),(70,12,764.00,1,8.00,8.00),(70,13,764.00,1,12.00,12.00),(71,12,8.00,1,8.00,8.00),(72,10,458.00,3,150.00,450.00),(72,12,458.00,1,8.00,8.00),(73,13,24.00,2,12.00,24.00),(74,11,196.00,2,98.00,196.00),(75,10,256.00,1,150.00,150.00),(75,11,256.00,1,98.00,98.00),(75,12,256.00,1,8.00,8.00),(76,12,568.00,71,8.00,568.00),(77,12,8.00,1,8.00,8.00),(78,10,174.00,1,150.00,150.00),(78,13,174.00,2,12.00,24.00),(79,11,122.00,1,98.00,98.00),(79,13,122.00,2,12.00,24.00),(80,11,306.00,3,98.00,294.00),(80,13,306.00,1,12.00,12.00),(81,11,350.00,2,150.00,150.00),(81,12,350.00,1,200.00,200.00),(82,10,250.00,1,150.00,450.00),(82,12,250.00,2,150.00,150.00),(83,11,150.00,1,200.00,400.00),(84,10,300.00,1,50.00,100.00),(84,11,300.00,1,150.00,150.00),(85,10,150.00,1,200.00,400.00),(86,10,350.00,2,150.00,300.00),(86,12,350.00,1,150.00,150.00),(87,13,200.00,1,200.00,200.00),(88,11,550.00,2,200.00,200.00),(88,12,550.00,1,150.00,600.00),(88,13,550.00,1,50.00,50.00);
/*!40000 ALTER TABLE `itens_venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `itens_venda_BI_qtdVendido` BEFORE INSERT ON `itens_venda` FOR EACH ROW update livro set qtde_vendido = qtde_vendido+new.quantidade where codLivro = new.livro_codLivro; */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Intens_venda_AI` AFTER INSERT ON `itens_venda` FOR EACH ROW update livro set estoque_atual= estoque_atual-new.quantidade where  new.livro_codLivro =  codLivro; */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `codLivro` int unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) DEFAULT NULL,
  `editora_CodEditora` int unsigned NOT NULL,
  `categoria_CodCategoria` int unsigned NOT NULL,
  `autor_CodAutor` int unsigned NOT NULL,
  `qtde_vendido` int unsigned DEFAULT NULL,
  `estoque_atual` int unsigned DEFAULT NULL,
  `estoque_minimo` int unsigned DEFAULT NULL,
  `data_lanc` date DEFAULT NULL,
  `preco_custo` decimal(15,2) DEFAULT NULL,
  `preco_venda` decimal(15,2) DEFAULT NULL,
  `resenha` text,
  `foto` text,
  `isbn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codLivro`),
  KEY `livro_FKIndex1` (`categoria_CodCategoria`),
  KEY `livro_FKIndex2` (`editora_CodEditora`),
  KEY `autor_CodAutor` (`autor_CodAutor`),
  CONSTRAINT `livro_fk1` FOREIGN KEY (`editora_CodEditora`) REFERENCES `editora` (`CodEditora`),
  CONSTRAINT `livro_fk2` FOREIGN KEY (`categoria_CodCategoria`) REFERENCES `categoria` (`codCategoria`),
  CONSTRAINT `livro_fk3` FOREIGN KEY (`autor_CodAutor`) REFERENCES `autor` (`codAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (10,'liro redes',3,5,4,26,85,10,'1212-12-12',100.00,150.00,'sdjfsfdjsdlldks','java2.jpg',NULL),(11,'oracle',3,5,4,29,51,10,'1212-12-01',100.00,150.00,',sd,n,','ubuntu1.jpg',''),(12,'aaaa',3,5,4,87,195,8,'1212-12-12',20.00,50.00,'','ubuntu1.jpg',''),(13,'liro',3,5,4,10,48,12112,'1212-12-12',100.00,200.00,'jlkaldlkaj','sql1.jpg','');
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_usuario`
--

DROP TABLE IF EXISTS `log_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_usuario` (
  `codigo_log` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(150) DEFAULT NULL,
  `data_movimento` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `tipo_movimento` varchar(100) DEFAULT NULL,
  `tabela` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_log`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_usuario`
--

LOCK TABLES `log_usuario` WRITE;
/*!40000 ALTER TABLE `log_usuario` DISABLE KEYS */;
INSERT INTO `log_usuario` VALUES (7,'a','2012-07-03','19:28:26','delete','venda'),(8,'ads','2012-07-03','19:29:27','delete','venda'),(9,'ads','2012-07-03','19:29:31','delete','venda'),(10,'ads','2012-07-03','19:29:42','delete','venda'),(11,'a','2019-10-29','13:14:39','delete','venda');
/*!40000 ALTER TABLE `log_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcelas`
--

DROP TABLE IF EXISTS `parcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parcelas` (
  `codParcela` int NOT NULL AUTO_INCREMENT,
  `cod_contas_receber` int NOT NULL,
  `valor_parcela` double(15,2) DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  `valor_pago` double(15,2) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `num_parcelas` int unsigned DEFAULT NULL,
  `quitada` char(1) DEFAULT NULL,
  PRIMARY KEY (`codParcela`),
  KEY `fk_cr_parcela` (`cod_contas_receber`),
  CONSTRAINT `fk_cr_parcela` FOREIGN KEY (`cod_contas_receber`) REFERENCES `contas_receber` (`codContas_receber`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcelas`
--

LOCK TABLES `parcelas` WRITE;
/*!40000 ALTER TABLE `parcelas` DISABLE KEYS */;
INSERT INTO `parcelas` VALUES (1,1,0.00,NULL,0.00,NULL,2,'N'),(2,1,0.00,NULL,0.00,NULL,2,'N'),(7,4,177.00,NULL,100.00,NULL,2,'N'),(8,4,177.00,NULL,100.00,NULL,2,'N'),(9,5,75.00,NULL,0.00,NULL,2,'N'),(10,5,75.00,NULL,0.00,NULL,2,'N'),(11,6,103.00,NULL,0.00,NULL,3,'N'),(12,6,103.00,NULL,0.00,NULL,3,'N'),(13,6,103.00,NULL,0.00,NULL,3,'N'),(14,7,0.00,NULL,0.00,NULL,2,'N'),(15,7,0.00,NULL,0.00,NULL,2,'N'),(19,9,0.00,NULL,0.00,NULL,2,'N'),(20,9,0.00,NULL,0.00,'2012-07-11',2,'S'),(21,10,153.00,NULL,0.00,'2012-07-10',3,'S'),(22,10,153.00,NULL,0.00,'2012-07-10',3,'S'),(23,10,153.00,NULL,0.00,'2012-07-10',3,'S'),(24,11,12.00,NULL,0.00,NULL,2,'N'),(25,11,12.00,NULL,0.00,NULL,2,'N'),(26,12,98.00,NULL,0.00,NULL,2,'N'),(27,12,98.00,NULL,0.00,NULL,2,'N');
/*!40000 ALTER TABLE `parcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `login` varchar(150) NOT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'a','a'),(4,'ads','123'),(5,'admin','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `codVenda` int unsigned NOT NULL AUTO_INCREMENT,
  `cliente_CodCliente` int unsigned NOT NULL,
  `data_venda` date DEFAULT NULL,
  `valor_total` decimal(15,2) DEFAULT NULL,
  `valor_recebido` double(15,2) DEFAULT NULL,
  PRIMARY KEY (`codVenda`),
  KEY `cliente_CodCliente` (`cliente_CodCliente`),
  CONSTRAINT `venda_fk1` FOREIGN KEY (`cliente_CodCliente`) REFERENCES `cliente` (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (60,11,'2012-07-03',98.00,0.00),(61,11,'2012-07-04',256.00,0.00),(62,10,'2012-07-04',248.00,0.00),(64,13,'2012-07-05',354.00,100.00),(65,11,'2012-07-05',98.00,0.00),(66,14,'2012-07-05',150.00,0.00),(67,12,'2012-07-05',196.00,0.00),(68,14,'2012-07-05',308.00,0.00),(69,16,'2012-07-10',264.00,0.00),(70,13,'2012-07-10',764.00,0.00),(71,10,'2012-07-10',8.00,0.00),(72,12,'2012-07-10',458.00,0.00),(73,11,'2012-07-11',24.00,0.00),(74,17,'2012-07-11',196.00,0.00),(75,16,'2012-07-11',256.00,0.00),(76,11,'2019-10-29',568.00,0.00),(77,11,'2019-10-29',8.00,0.00),(78,19,'2021-12-21',174.00,0.00),(79,11,'2021-12-21',122.00,0.00),(80,14,'2021-12-22',306.00,0.00),(81,12,'2021-12-23',350.00,0.00),(82,11,'2021-12-23',250.00,0.00),(83,16,'2021-12-23',150.00,0.00),(84,10,'2021-12-23',300.00,0.00),(85,11,'2021-12-23',150.00,0.00),(86,19,'2021-12-23',350.00,0.00),(87,13,'2021-12-23',200.00,0.00),(88,17,'2021-12-23',550.00,0.00);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_venda_bd` BEFORE DELETE ON `venda` FOR EACH ROW delete from itens_venda  where venda_codVenda = old.codVenda; */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `view_cliente`
--

DROP TABLE IF EXISTS `view_cliente`;
/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_cliente` AS SELECT 
 1 AS `nome_cliente`,
 1 AS `codCliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_itens_venda`
--

DROP TABLE IF EXISTS `view_itens_venda`;
/*!50001 DROP VIEW IF EXISTS `view_itens_venda`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_itens_venda` AS SELECT 
 1 AS `livro_codLivro`,
 1 AS `preco_total`,
 1 AS `preco_venda`,
 1 AS `quantidade`,
 1 AS `valor_unitario`,
 1 AS `sub_total`,
 1 AS `codigovenda`,
 1 AS `codLivro`,
 1 AS `titulo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_nome_cidade`
--

DROP TABLE IF EXISTS `view_nome_cidade`;
/*!50001 DROP VIEW IF EXISTS `view_nome_cidade`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_nome_cidade` AS SELECT 
 1 AS `nome_cidade`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_nome_clientes`
--

DROP TABLE IF EXISTS `view_nome_clientes`;
/*!50001 DROP VIEW IF EXISTS `view_nome_clientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_nome_clientes` AS SELECT 
 1 AS `nome_cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_nome_fornecedores`
--

DROP TABLE IF EXISTS `view_nome_fornecedores`;
/*!50001 DROP VIEW IF EXISTS `view_nome_fornecedores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_nome_fornecedores` AS SELECT 
 1 AS `nome_fornecedor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_titulo_livro`
--

DROP TABLE IF EXISTS `view_titulo_livro`;
/*!50001 DROP VIEW IF EXISTS `view_titulo_livro`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_titulo_livro` AS SELECT 
 1 AS `titulo`,
 1 AS `data_lanc`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_ultima_venda`
--

DROP TABLE IF EXISTS `view_ultima_venda`;
/*!50001 DROP VIEW IF EXISTS `view_ultima_venda`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_ultima_venda` AS SELECT 
 1 AS `ultima`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_venda`
--

DROP TABLE IF EXISTS `view_venda`;
/*!50001 DROP VIEW IF EXISTS `view_venda`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_venda` AS SELECT 
 1 AS `valor_total_geral`,
 1 AS `quantidade_total`,
 1 AS `codVenda`,
 1 AS `data_venda`,
 1 AS `nome_cliente`,
 1 AS `preco_total`,
 1 AS `valor_recebido`,
 1 AS `valor_total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_teste`
--

DROP TABLE IF EXISTS `vw_teste`;
/*!50001 DROP VIEW IF EXISTS `vw_teste`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_teste` AS SELECT 
 1 AS `codCliente`,
 1 AS `nome_cliente`,
 1 AS `cidade_CodCidade`,
 1 AS `sexo`,
 1 AS `endereco`,
 1 AS `telefone`,
 1 AS `cpf`,
 1 AS `qtde_comprado`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'venda_produtos'
--

--
-- Dumping routines for database 'venda_produtos'
--
/*!50003 DROP PROCEDURE IF EXISTS `cadautor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cadautor`(in _id INT)
BEGIN



      insert into autor (nome_autor) values ('2222');



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar`(out _id INT)
BEGIN



      IF(_id IS NULL) THEN



        SELECT * FROM cidade;



      ELSE



        SELECT *  FROM cidade where cidade.codCidade = _id;



      END IF;



   END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_cidade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_cidade`(IN _id INT)
BEGIN



      IF(_id IS NULL) THEN



        SELECT * FROM cidade;



      ELSE



        SELECT *  FROM cidade where cidade.codCidade = _id;



      END IF;



   END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_delete_contas_receber` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_delete_contas_receber`(in opcao integer)
BEGIN

     delete from contas_receber where venda_CodVenda = opcao;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_insere_itens_venda` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_insere_itens_venda`( venda INT, livro INT, pr_total DOUBLE, qtd DOUBLE, unitario DOUBLE, subtotal DOUBLE )
BEGIN



      insert into itens_venda  values (venda,livro,pr_total,qtd,unitario,subtotal);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_insere_parcelas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_insere_parcelas`( contasreceber INT, valorparcela DOUBLE,

                                             valor_recebido DOUBLE, nume_parcela INT, situacao char(1) )
BEGIN



      insert into parcelas(cod_contas_receber,valor_parcela,valor_pago,num_parcelas,quitada)

        values (contasreceber, valorparcela,valor_recebido , nume_parcela, situacao );



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_log_del_venda` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_log_del_venda`(login varchar(150),tabela_mov varchar (150),tipo varchar(100))
BEGIN  

       insert into log_usuario (usuario,data_movimento,hora,tipo_movimento,tabela)       

       values(login,NOW(),CURTIME(),tipo,tabela_mov);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `qtde_comprado_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `qtde_comprado_cliente`()
BEGIN

     declare id int;

     declare qtd float;

     

     set qtd = (select quantidade from itens_venda order by quantidade  desc limit 1 );

     

     Set id=(select cliente_codCliente from venda order by codVenda desc limit 1) ;

     

    

    

    UPDATE cliente set qtde_comprado = qtde_comprado + qtd where cliente.codCliente = id;



      



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `WhileLoopProc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `WhileLoopProc`()
BEGIN

              DECLARE x  INT;

              DECLARE str  VARCHAR(255);

              SET x = 1;

              SET str =  '';

              WHILE x  <= 5 DO

                        insert into cliente(nome_cliente,cidade_CodCidade) values ('ppppp',1);

                          

                          SET  x = x + 1;

              END WHILE;

              SELECT str;

      END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `view_cliente`
--

/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_cliente` AS select `cliente`.`nome_cliente` AS `nome_cliente`,`cliente`.`codCliente` AS `codCliente` from `cliente` order by `cliente`.`nome_cliente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_itens_venda`
--

/*!50001 DROP VIEW IF EXISTS `view_itens_venda`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_itens_venda` AS select `itens_venda`.`livro_codLivro` AS `livro_codLivro`,`itens_venda`.`preco_total` AS `preco_total`,`livro`.`preco_venda` AS `preco_venda`,`itens_venda`.`quantidade` AS `quantidade`,`itens_venda`.`valor_unitario` AS `valor_unitario`,`itens_venda`.`sub_total` AS `sub_total`,`itens_venda`.`venda_CodVenda` AS `codigovenda`,`livro`.`codLivro` AS `codLivro`,`livro`.`titulo` AS `titulo` from (`itens_venda` join `livro` on((`livro`.`codLivro` = `itens_venda`.`livro_codLivro`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_nome_cidade`
--

/*!50001 DROP VIEW IF EXISTS `view_nome_cidade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_nome_cidade` AS select `cidade`.`nome_cidade` AS `nome_cidade` from `cidade` order by `cidade`.`nome_cidade` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_nome_clientes`
--

/*!50001 DROP VIEW IF EXISTS `view_nome_clientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`user`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_nome_clientes` AS select `cliente`.`nome_cliente` AS `nome_cliente` from `cliente` order by `cliente`.`nome_cliente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_nome_fornecedores`
--

/*!50001 DROP VIEW IF EXISTS `view_nome_fornecedores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_nome_fornecedores` AS select `fornecedor`.`nome_fornecedor` AS `nome_fornecedor` from `fornecedor` order by `fornecedor`.`nome_fornecedor` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_titulo_livro`
--

/*!50001 DROP VIEW IF EXISTS `view_titulo_livro`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_titulo_livro` AS select `livro`.`titulo` AS `titulo`,`livro`.`data_lanc` AS `data_lanc` from `livro` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_ultima_venda`
--

/*!50001 DROP VIEW IF EXISTS `view_ultima_venda`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_ultima_venda` AS select max(`venda`.`codVenda`) AS `ultima` from `venda` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_venda`
--

/*!50001 DROP VIEW IF EXISTS `view_venda`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_venda` AS select sum(`itens_venda`.`sub_total`) AS `valor_total_geral`,sum(`itens_venda`.`quantidade`) AS `quantidade_total`,`venda`.`codVenda` AS `codVenda`,`venda`.`data_venda` AS `data_venda`,`cliente`.`nome_cliente` AS `nome_cliente`,`itens_venda`.`preco_total` AS `preco_total`,`venda`.`valor_recebido` AS `valor_recebido`,`venda`.`valor_total` AS `valor_total` from (((`venda` join `itens_venda` on((`venda`.`codVenda` = `itens_venda`.`venda_CodVenda`))) join `livro` on((`livro`.`codLivro` = `itens_venda`.`livro_codLivro`))) join `cliente` on((`venda`.`cliente_CodCliente` = `cliente`.`codCliente`))) group by `venda`.`codVenda` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_teste`
--

/*!50001 DROP VIEW IF EXISTS `vw_teste`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`user`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_teste` AS select `cliente`.`codCliente` AS `codCliente`,`cliente`.`nome_cliente` AS `nome_cliente`,`cliente`.`cidade_CodCidade` AS `cidade_CodCidade`,`cliente`.`sexo` AS `sexo`,`cliente`.`endereco` AS `endereco`,`cliente`.`telefone` AS `telefone`,`cliente`.`cpf` AS `cpf`,`cliente`.`qtde_comprado` AS `qtde_comprado` from `cliente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-23 17:04:24
