/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `drinkcounter`;
CREATE DATABASE IF NOT EXISTS `drinkcounter` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `drinkcounter`;

DROP TABLE IF EXISTS `detalle_consumo`;
CREATE TABLE IF NOT EXISTS `detalle_consumo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_consumo` int(11) DEFAULT NULL,
  `codigo_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `detalle_consumo` DISABLE KEYS */;
INSERT INTO `detalle_consumo` (`id`, `id_consumo`, `codigo_producto`, `cantidad`, `precio`, `importe`) VALUES
	(0, 0, 0, 2, 750.00, 1500.00),
	(1, 1, 3, 1, 650.00, 650.00),
	(2, 2, 2, 1, 350.00, 350.00),
	(3, 3, 2, 1, 350.00, 350.00),
	(4, 4, 2, 2, 350.00, 700.00),
    (5, 5, 0, 1, 750.00, 750.00),
    (6, 6, 0, 1, 750.00, 750.00),
    (7, 7, 2, 3, 350.00, 1050.00),
	(8, 8, 3, 1, 650.00, 650.00),
    (9, 9, 1, 3, 450.00, 1350.00),
	(10, 10, 1, 3, 450.00, 1350.00),
	(11, 11, 1, 1, 450.00, 450.00);
  
/*!40000 ALTER TABLE `detalle_consumo` ENABLE KEYS */;

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `cuit_proveedor` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_productos_proveedores` (`cuit_proveedor`),
  CONSTRAINT `FK_productos_proveedores` FOREIGN KEY (`cuit_proveedor`) REFERENCES `proveedores` (`cuit`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`codigo`, `nombre`, `cuit_proveedor`, `cantidad`, `precio`) VALUES
	(0, 'Fernet', 021001, 8, 750.00),
	(1, 'Corona', 021001, 8, 450.00),
	(2, 'Gancia', 11111, 30, 350.00),
    (3, 'Smirnoff', 11111, 8, 650.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE IF NOT EXISTS `proveedores` (
  `cuit` int(11) NOT NULL,
  `razon_social` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` int(20) DEFAULT NULL,
  PRIMARY KEY (`cuit`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` (`cuit`, `razon_social`, `nombre`, `direccion`, `telefono`) VALUES
	(021001, 'Bebidas SA', 'Juan', 'Dorrego 123', 65432),
    (11111, 'Vodka SA', 'Cristian', 'Rivadavia 777', 12345);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `descripcion`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'JEFE DE BARRA'),
    (3, 'ABASTECIMIENTO');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL DEFAULT '',
  `id_tipo_usuario` int(11) NOT NULL,
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_usuario`),
  KEY `FK_usuarios_tipo_usuario` (`id_tipo_usuario`),
  CONSTRAINT `FK_usuarios_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id_usuario`, `usuario`, `id_tipo_usuario`, `password`) VALUES
	(1, 'eze', 1, '21232f297a57a5a743894a0e4a801fc3'),
    (2, 'mirko', 1, '21232f297a57a5a743894a0e4a801fc3'),
    (3, 'marcos', 1, '21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

DROP TABLE IF EXISTS `consumos`;
CREATE TABLE IF NOT EXISTS `consumos` (
  `id_consumo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_consumo` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id_consumo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*!40000 ALTER TABLE `consumos` DISABLE KEYS */;
INSERT INTO `consumos` (`id_consumo`, `fecha_consumo`, `id_usuario`, `total`) VALUES
	(0, '2022-01-10', 1,  1500.00),
	(1, '2022-01-11', 1,  650.00),
	(2, '2022-02-12', 1,  350.00),
	(3, '2022-05-13', 2,  350.00),
	(4, '2022-06-14', 3,  700.00),
	(5, '2022-06-15', 2,  750.00),
	(6, '2022-07-16', 1,  750.00),
	(7, '2022-08-17', 3, 1050.00),
	(8, '2022-09-17', 3,  650.00),
	(9, '2022-09-18', 3,  1350.00),
	(10, '2022-09-19', 2, 1350.00),
	(11, '2022-09-20', 2, 450.00);
/*!40000 ALTER TABLE `consumos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


-- use drinkcounter;
-- INSERT INTO usuarios VALUES (3, 'prueba', 3, md5("prueba")); MANERA DE INGRESAR NUEVO USUARIO