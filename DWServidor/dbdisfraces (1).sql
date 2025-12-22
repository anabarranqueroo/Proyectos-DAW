-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2025 a las 13:00:39
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
-- Base de datos: `dbdisfraces`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disfraces`
--

CREATE TABLE `disfraces` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `talla` varchar(50) DEFAULT NULL,
  `disponibilidad` varchar(50) DEFAULT NULL,
  `descuento` int(11) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `disfraces`
--

INSERT INTO `disfraces` (`id`, `descripcion`, `precio`, `talla`, `disponibilidad`, `descuento`, `categoria`, `fecha_inicio`, `fecha_fin`) VALUES
(1, '35657367', 55.70, 'M', 'DISPONIBLE', 25, 'Ropa', '2025-11-22', '2025-11-28'),
(3, 'bruja', 100.00, 'L', 'NODISPONIBLE', 10, 'Disfraces', '2025-11-11', '2025-11-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disfraces2`
--

CREATE TABLE `disfraces2` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `talla` varchar(50) DEFAULT NULL,
  `disponibilidad` varchar(50) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `disfraces2`
--

INSERT INTO `disfraces2` (`id`, `descripcion`, `precio`, `talla`, `disponibilidad`, `fecha_inicio`, `fecha_fin`) VALUES
(1, 'dghdfh', 22.00, 'S', 'DISPONIBLE', '2025-11-03', '2025-11-29'),
(2, 'dghdfh', 2222.00, 'XL', 'NODISPONIBLE', '2025-11-27', '2025-11-30');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `disfraces`
--
ALTER TABLE `disfraces`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `disfraces2`
--
ALTER TABLE `disfraces2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `disfraces`
--
ALTER TABLE `disfraces`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `disfraces2`
--
ALTER TABLE `disfraces2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
