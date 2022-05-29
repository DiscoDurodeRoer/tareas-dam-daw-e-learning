-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2020 a las 23:14:31
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alumnos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `NIF` varchar(9) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido1` varchar(30) NOT NULL,
  `Apellido2` varchar(30) NOT NULL,
  `Edad` int(1) NOT NULL,
  `Pais` int(11) NOT NULL,
  `Provincia` int(11) NOT NULL,
  `Localidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`NIF`, `Nombre`, `Apellido1`, `Apellido2`, `Edad`, `Pais`, `Provincia`, `Localidad`) VALUES
('11111111A', 'Juan', 'Perez', 'Lopez', 23, 1, 1, 1),
('22222222B', 'Jose', 'Romero', 'Garcia', 25, 3, 1, 3),
('33333333C', 'Luis', 'Vera', 'Delgado', 27, 2, 2, 3),
('44444444D', 'Tomas', 'Moreno', 'Lopez', 31, 2, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidades`
--

CREATE TABLE `localidades` (
  `IdLoc` int(11) NOT NULL,
  `IdPais` int(11) NOT NULL,
  `IdProvincia` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `localidades`
--

INSERT INTO `localidades` (`IdLoc`, `IdPais`, `IdProvincia`, `Nombre`) VALUES
(1, 1, 1, 'Madrid'),
(1, 1, 2, 'Barcelona'),
(1, 1, 3, 'Valencia'),
(1, 2, 1, 'Paris'),
(1, 2, 2, 'Lyon'),
(1, 2, 3, 'tolouse'),
(2, 1, 1, 'Mostoles'),
(2, 1, 2, 'Badalona'),
(2, 1, 3, 'Alcira'),
(2, 2, 1, 'Paris Oeste'),
(2, 2, 2, 'Lyon Este'),
(2, 2, 3, 'tolouse Este');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`Id`, `Nombre`) VALUES
(1, 'España'),
(2, 'Francia'),
(3, 'Alemania');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE `provincias` (
  `Id` int(11) NOT NULL,
  `IdPro` int(11) NOT NULL,
  `IdPais` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`Id`, `IdPro`, `IdPais`, `Nombre`) VALUES
(1, 1, 1, 'Madrid'),
(2, 1, 2, 'Paris'),
(3, 1, 3, 'Berlin'),
(4, 2, 1, 'Barcelona'),
(5, 2, 2, 'Lyon'),
(6, 2, 3, 'Munich'),
(7, 3, 1, 'Valencia'),
(8, 3, 2, 'Tolouse'),
(9, 3, 3, 'Studgart');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`NIF`);

--
-- Indices de la tabla `localidades`
--
ALTER TABLE `localidades`
  ADD PRIMARY KEY (`IdLoc`,`IdPais`,`IdProvincia`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `provincias`
--
ALTER TABLE `provincias`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
