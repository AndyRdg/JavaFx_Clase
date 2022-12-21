-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-08-2020 a las 16:27:07
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `clase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `matricula` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `poblacion` varchar(35) NOT NULL,
  `nif` varchar(10) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `nif` (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`matricula`, `nombre`, `direccion`, `poblacion`, `nif`, `telefono`) VALUES
('1', 'Ramón Sánchez Carrero', 'c/calle,1', 'Mérida', '1', '1'),
('11111', 'José Fernández López', 'c/calle 11111', 'Mérida', '111', '5'),
('2', 'Miguel Hernández Fernández', 'c/calle2', 'Calamonte', '2', '2'),
('3', 'Diego Sánchez Barrera', 'c/calle3', 'Badajoz', '3333', '33333'),
('4', 'Moises Elias', 'c/calle4', 'Montijo', '4444', '44444'),
('6', 'Josefa Delgado Prieto', 'c/dir 66', 'Mérida', '6', '66'),
('7', 'Luis Rodríguez Fernández', 'c/ dir7', 'Valdelacalzada', '7', '777');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alu_curso`
--

CREATE TABLE IF NOT EXISTS `alu_curso` (
  `indice` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(8) NOT NULL,
  `ind_curso` int(11) NOT NULL,
  `fecha_matricula` date NOT NULL,
  PRIMARY KEY (`indice`),
  UNIQUE KEY `indice` (`indice`),
  KEY `matricula` (`matricula`,`ind_curso`),
  KEY `ind_curso` (`ind_curso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `alu_curso`
--

INSERT INTO `alu_curso` (`indice`, `matricula`, `ind_curso`, `fecha_matricula`) VALUES
(1, '1', 1, '2020-08-28'),
(2, '2', 2, '2020-08-28'),
(3, '11111', 4, '2020-08-28'),
(4, '3', 4, '2020-08-28'),
(5, '4', 1, '2020-08-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `ind_curso` int(11) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(15) NOT NULL,
  `etapa` varchar(15) NOT NULL,
  PRIMARY KEY (`ind_curso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`ind_curso`, `denominacion`, `etapa`) VALUES
(1, 'ASIR1', 'ciclos'),
(2, 'ASIR2', 'ciclos'),
(3, 'DAW 1', 'ciclos'),
(4, 'DAW 2', 'ciclos');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alu_curso`
--
ALTER TABLE `alu_curso`
  ADD CONSTRAINT `alu_curso_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `alumnos` (`matricula`),
  ADD CONSTRAINT `alu_curso_ibfk_2` FOREIGN KEY (`ind_curso`) REFERENCES `cursos` (`ind_curso`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
