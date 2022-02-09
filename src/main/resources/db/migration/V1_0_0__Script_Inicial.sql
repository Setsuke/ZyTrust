CREATE TABLE `fac_clientes` (
                                `cli_id` varchar(255) NOT NULL,
                                `cli_apellidos` varchar(255) DEFAULT NULL,
                                `cli_direccion` varchar(255) DEFAULT NULL,
                                `cli_dni` varchar(255) DEFAULT NULL,
                                `cli_nombres` varchar(255) DEFAULT NULL,
                                `cli_razon_social` varchar(255) DEFAULT NULL,
                                `cli_ruc` varchar(255) DEFAULT NULL,
                                `cli_telefono` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`cli_id`)
) ENGINE=MyISAM;

CREATE TABLE `fac_productos` (
                                 `prod_id` varchar(255) NOT NULL,
                                 `prod_nombre` varchar(255) DEFAULT NULL,
                                 `prod_precio` decimal(19,2) DEFAULT NULL,
                                 `prod_stock` int DEFAULT NULL,
                                 PRIMARY KEY (`prod_id`)
) ENGINE=MyISAM;

CREATE TABLE `fac_facturas` (
                                `fact_id` varchar(255) NOT NULL,
                                `fact_estado` varchar(255) DEFAULT NULL,
                                `fact_fecha_emision` date DEFAULT NULL,
                                `fact_fecha_pago` date DEFAULT NULL,
                                `fact_fecha_vencimiento` date DEFAULT NULL,
                                `fact_impuesto` decimal(7,2) NOT NULL,
                                `fact_subtotal` decimal(7,2) NOT NULL,
                                `fact_tipo_pago` varchar(255) DEFAULT NULL,
                                `fact_total` decimal(7,2) NOT NULL,
                                `cli_id` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`fact_id`),
                                KEY `FK3du3182eupe9k6fskm7bookwf` (`cli_id`)
) ENGINE=MyISAM;

CREATE TABLE `fac_detalles` (
                                `det_id` varchar(255) NOT NULL,
                                `det_cantidad` decimal(19,2) DEFAULT NULL,
                                `fact_id` varchar(255) DEFAULT NULL,
                                `prod_id` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`det_id`),
                                KEY `FK5mdchli2e5cvtum16hh3p0l00` (`fact_id`),
                                KEY `FK2kwc39idld5gg7iawdxcb0vg3` (`prod_id`)
) ENGINE=MyISAM