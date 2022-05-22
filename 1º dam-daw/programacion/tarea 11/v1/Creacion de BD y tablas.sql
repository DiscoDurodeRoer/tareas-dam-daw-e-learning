CREATE TABLE propietario(
	id_prop INT(11) NOT NULL PRIMARY KEY,
	nombre_prop VARCHAR(100) NOT NULL,
	dni_prop VARCHAR(9) NOT NULL
)ENGINE=INNODB;
 
 CREATE TABLE vehiculo(
	mat_veh CHAR(7) NOT NULL PRIMARY KEY,
	marca_veh VARCHAR(50) NOT NULL,
	kms_veh INT(11) NOT NULL,
	precio_veh FLOAT NOT NULL,
	desc_veh VARCHAR(300) NOT NULL,
	id_prop INT(11) NOT NULL,
	CONSTRAINT vehiculo_fk FOREIGN KEY (id_prop) REFERENCES propietario (id_prop)
)ENGINE=InnoDB;

INSERT INTO propietario VALUES(0001, 'Ruben Garcia', '03475057X');
INSERT INTO propietario VALUES(0002, 'Miriam Garcia', '03475058X');
INSERT INTO propietario VALUES(0003, 'Angel Luis Garcia', '03475059X');
INSERT INTO propietario VALUES(0004, 'Angel Garcia', '03475050X');
INSERT INTO propietario VALUES(0005, 'Ana Isabel Gonzalez', '03475051X');

INSERT INTO vehiculo VALUES('2440FVD', 'Honda', 2200, 800, 'CG 125', 0001);
INSERT INTO vehiculo VALUES('2564FVD', 'Yamaha', 4000, 2000, 'ni idea', 0003);
INSERT INTO vehiculo VALUES('2230FVD', 'Seat', 140000, 8000, 'Leon Fr', 0001);
INSERT INTO vehiculo VALUES('3230FVD', 'Opel', 120000, 8000, 'Astra', 0002);
INSERT INTO vehiculo VALUES('4230FVD', 'Peugeot', 130000, 8000, '3008', 0003);
INSERT INTO vehiculo VALUES('5230FVD', 'Citroen', 140000, 8000, 'Picasso', 0004);
INSERT INTO vehiculo VALUES('6230FVD', 'Citroen', 160000, 8000, 'Xsara', 0005);

-- SELECT * FROM vehiculo;
-- SELECT * FROM propietario;


