-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2025 a las 10:29:55
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Edad` int(11) DEFAULT NULL CHECK (`Edad` >= 0),
  `Telefono` varchar(20) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Edad`, `Telefono`, `Correo`, `Direccion`) VALUES
('12345678A', 'Juan', 'Pérez Gómez', 35, '600111222', 'juan.perez@gmail.com', 'Calle Mayor 10'),
('23456789B', 'Laura', 'Martínez Ruiz', 28, '600222333', 'laura.martinez@hotmail.com', 'Av. Andalucía 5'),
('34567890C', 'Carlos', 'López Díaz', 42, '600333444', 'carlos.lopez@yahoo.com', 'Calle Luna 22'),
('45678901D', 'Marta', 'García Sánchez', 31, '600444555', 'marta.garcia@gmail.com', 'Paseo del Sol 15'),
('56789012E', 'Lucía', 'Fernández Gómez', 23, '600555666', 'lucia.fernandez@gmail.com', 'Calle Río 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprar`
--

CREATE TABLE `comprar` (
  `DNI` varchar(20) NOT NULL,
  `CodigoProducto` int(11) NOT NULL,
  `FechaCompra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comprar`
--

INSERT INTO `comprar` (`DNI`, `CodigoProducto`, `FechaCompra`) VALUES
('12345678A', 1, '2024-11-10'),
('12345678A', 2, '2025-05-01'),
('12345678A', 6, '2024-12-05'),
('23456789B', 2, '2025-01-15'),
('23456789B', 3, '2025-05-05'),
('23456789B', 7, '2025-01-20'),
('34567890C', 4, '2025-02-10'),
('34567890C', 8, '2025-05-10'),
('34567890C', 9, '2025-02-12'),
('45678901D', 3, '2025-03-01'),
('45678901D', 5, '2025-03-03'),
('45678901D', 6, '2025-05-12'),
('56789012E', 1, '2025-04-25'),
('56789012E', 4, '2025-05-14'),
('56789012E', 10, '2025-04-18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricante`
--

CREATE TABLE `fabricante` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fabricante`
--

INSERT INTO `fabricante` (`Id`, `Nombre`) VALUES
(1, 'Sony'),
(2, 'Samsung'),
(3, 'Apple'),
(4, 'LG'),
(5, 'HP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Categoria` varchar(50) DEFAULT NULL,
  `Stock` int(11) NOT NULL DEFAULT 0,
  `IdFabricante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`Codigo`, `Nombre`, `Precio`, `Categoria`, `Stock`, `IdFabricante`) VALUES
(1, 'Televisor 42\"', 399.99, 'Electrónica', 10, 1),
(2, 'Smartphone Galaxy', 699.00, 'Telefonía', 15, 2),
(3, 'iPhone 14', 999.99, 'Telefonía', 8, 3),
(4, 'Portátil HP 15\"', 599.50, 'Informática', 5, 5),
(5, 'Monitor LG 27\"', 249.00, 'Informática', 12, 4),
(6, 'Auriculares Sony WH-1000XM4', 299.00, 'Audio', 7, 1),
(7, 'Tablet Samsung Galaxy Tab', 349.99, 'Informática', 10, 2),
(8, 'MacBook Air', 1299.00, 'Informática', 4, 3),
(9, 'Impresora HP DeskJet', 89.99, 'Oficina', 20, 5),
(10, 'Altavoz LG XBoom', 199.00, 'Audio', 6, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `comprar`
--
ALTER TABLE `comprar`
  ADD PRIMARY KEY (`DNI`,`CodigoProducto`,`FechaCompra`),
  ADD KEY `CodigoProducto` (`CodigoProducto`);

--
-- Indices de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `IdFabricante` (`IdFabricante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprar`
--
ALTER TABLE `comprar`
  ADD CONSTRAINT `comprar_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `cliente` (`DNI`),
  ADD CONSTRAINT `comprar_ibfk_2` FOREIGN KEY (`CodigoProducto`) REFERENCES `producto` (`Codigo`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`IdFabricante`) REFERENCES `fabricante` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
