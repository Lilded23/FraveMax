-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2023 a las 21:48:23
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fravemax`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Domicilio` varchar(100) NOT NULL,
  `Telefono` varchar(60) NOT NULL,
  `Correo` varchar(170) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `Apellido`, `Nombre`, `DNI`, `Domicilio`, `Telefono`, `Correo`) VALUES
(1, 'Perez', 'Victor', 36895784, 'Lobos 975', '115698753', 'respaldofravemax@gmail.com'),
(9, 'Quiroga', 'Luciana', 98876544, 'Calle Falsa 123', '543567765', ''),
(10, 'Fernandez', 'Cristina', 2176532, 'Calle Falsa 123', '32234432', ''),
(14, 'Luna', 'Federico', 37625172, 'Ni idea 352', '278346221', 'mfzini@ulp.edu.ar'),
(16, 'Gonzalez', 'Claudia', 21786532, 'Chile 8847', '763522132', ''),
(17, 'Cruz', 'Jesus', 38927253, 'Av. lima 638213', '', ''),
(20, 'Zini', 'Francisco', 87643223, '', '', ''),
(21, 'Quiroga', 'Angel', 56565655, 'holahola', '56874512', ''),
(22, 'zule', 'jacinta', 8645645, 'dasda 154', '98566354', ''),
(23, 'MAX', 'Frave', 77777777, 'Las Vegas 826', '3562849302', 'fravemax@gmail.com'),
(25, 'Castillo', 'Agustina', 39012904, 'Lobos 0216', '2641111111', ''),
(27, 'asdadasdsa', 'aaaaaa', 98754457, 'adasdadsa98', '21122211', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `precioVenta` double NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idDetalleVenta`, `Cantidad`, `idVenta`, `precioVenta`, `idProducto`) VALUES
(294, 1, 250, 367000, 26),
(296, 1, 253, 90000, 20),
(297, 1, 253, 54000, 22),
(298, 1, 253, 132000, 25),
(299, 1, 255, 43000, 23),
(300, 1, 255, 90000, 20),
(301, 1, 255, 75000, 21),
(302, 1, 257, 30000, 28),
(307, 1, 260, 165000, 29),
(308, 1, 260, 132000, 25),
(311, 1, 270, 149999.99, 19),
(312, 1, 270, 367000, 26),
(313, 1, 270, 149999.99, 19),
(314, 1, 270, 97000.79, 24),
(315, 1, 270, 43000, 23),
(316, 1, 271, 75000, 21),
(317, 1, 271, 310000, 18),
(318, 1, 271, 30000, 28),
(319, 2, 271, 86000, 23),
(320, 1, 272, 149999.99, 19),
(321, 1, 272, 54000, 22),
(322, 1, 272, 120999.99, 17),
(324, 1, 276, 97000.79, 24),
(325, 1, 277, 90000, 20),
(326, 1, 277, 310000, 18),
(327, 1, 278, 367000, 26),
(328, 1, 278, 149999.99, 19),
(332, 1, 280, 54000, 22),
(333, 1, 280, 150000, 16),
(334, 1, 282, 149999.99, 19),
(335, 1, 282, 150000, 16),
(336, 1, 282, 270999.99, 15),
(340, 1, 284, 75000, 21),
(341, 1, 284, 150000, 16),
(342, 1, 284, 100200, 17),
(343, 1, 285, 270999, 15),
(344, 1, 285, 150000, 16),
(345, 1, 286, 270999, 15),
(346, 1, 286, 310000, 18),
(347, 1, 286, 54000, 22),
(348, 1, 289, 165000, 29),
(349, 1, 290, 43000, 23),
(350, 1, 290, 149999, 19),
(351, 1, 290, 30000, 28),
(352, 1, 291, 132000, 25),
(353, 1, 291, 149999, 19),
(354, 1, 292, 310000, 18),
(355, 1, 292, 132000, 25),
(356, 1, 292, 30000, 28),
(357, 1, 293, 97000.79, 24),
(358, 1, 293, 90000, 20),
(359, 1, 294, 30000, 28),
(360, 1, 294, 150000, 16),
(361, 1, 295, 90000, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `descripcion` varchar(120) NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcion`, `precioActual`, `stock`, `estado`) VALUES
(15, 'Lavadora', 'Lavadora de carga frontal, capacidad de 7 kg.', 270999, 46, 1),
(16, 'Refrigerador', 'Refrigerador de dos puertas, capacidad de 400 litros.', 150000, 22, 1),
(17, 'Horno de Microondas', 'Horno de microondas de 1100 vatios.', 100200, 56, 1),
(18, 'Televisor LED', 'Televisor LED de 55 pulgadas, resolución 4K.', 310000, 35, 1),
(19, 'Aspiradora', 'Aspiradora inalámbrica, potente succión.', 149999, 8, 1),
(20, 'Licuadora', 'Licuadora de alta velocidad, capacidad de 1.5 litros.', 90000, 18, 1),
(21, 'Ventilador', 'Ventilador de torre con control remoto.', 75000, 13, 1),
(22, 'Cafetera', 'Cafetera programable, capacidad de 12 tazas.', 54000, 22, 1),
(23, 'Plancha de Vapor', 'Plancha de vapor con suela antiadherente.', 43000, 29, 1),
(24, 'Batidora de Pie', 'Batidora de pie con múltiples accesorios.', 97000.79, 6, 1),
(25, 'Secadora de Ropa', 'Secadora de ropa de carga frontal, capacidad de 8 kg.', 132000, 17, 1),
(26, 'Aire Acondicionado', 'Aire acondicionado split, Marca RGA', 367000, 12, 1),
(27, 'Cafetera Express', 'Cafetera express con espumador de leche.', 149000.12, 22, 1),
(28, 'Tostadora', 'Tostadora de 2 rebanadas con funciones de tostado variable.', 30000, 34, 1),
(29, 'Ventilador de Techo', 'Ventilador de techo con luz y control remoto.', 165000, 4, 1),
(30, 'Parrilla Eléctrica', 'Parrilla eléctrica de interior, superficie antiadherente.', 77000, 12, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fechaVenta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `idCliente`, `fechaVenta`) VALUES
(250, 9, '2023-10-15'),
(253, 1, '2023-10-16'),
(254, 16, '2023-10-17'),
(255, 16, '2023-10-17'),
(256, 14, '2023-10-17'),
(257, 14, '2023-10-17'),
(260, 17, '2023-10-17'),
(262, 14, '2023-10-17'),
(264, 10, '2023-10-17'),
(265, 17, '2023-10-18'),
(270, 20, '2023-10-20'),
(271, 9, '2023-10-20'),
(272, 21, '2023-10-20'),
(276, 22, '2023-10-20'),
(277, 1, '2023-10-20'),
(278, 1, '2023-10-21'),
(280, 23, '2023-10-21'),
(281, 23, '2023-10-21'),
(282, 23, '2023-10-21'),
(284, 16, '2023-10-21'),
(285, 17, '2023-10-21'),
(286, 25, '2023-10-21'),
(289, 9, '2023-10-23'),
(290, 16, '2023-10-23'),
(291, 10, '2023-10-23'),
(292, 1, '2023-10-23'),
(293, 14, '2023-10-23'),
(294, 10, '2023-10-23'),
(295, 16, '2023-10-23');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalleVenta`),
  ADD KEY `idVenta` (`idVenta`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `idCliente` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=362;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=296;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
