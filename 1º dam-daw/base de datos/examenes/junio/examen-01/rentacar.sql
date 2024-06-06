create table cliente (
	cod_cliente char(4) primary key,
	dni char(9) unique,
	nombre varchar2(40) not null,
	direccion varchar2(40),
	telefono char(9)
);

create table avala (
	avalado char(4) primary key,
	avalador char(4),
	foreign key (avalado) references cliente(cod_cliente),
        foreign key (avalador) references cliente(cod_cliente)
);

create table reserva(
	numero number(4) primary key,
	fechainicio date,
	fechafin date,
	preciototal number,
	codcliente char(4),
	foreign key (codcliente) references cliente(cod_cliente)
);

create table coche(
	matricula char(7) primary key,
	marca varchar2(20) not null,
	modelo varchar2(20) not null,
	color varchar2(20),
	preciohora number
);

create table incluye(
	numero number(4),
	matricula char(7),
	litrosgas number,
	primary key(numero, matricula),
	foreign key (numero) references reserva(numero),
	foreign key (matricula ) references coche(matricula)
);

-- Datos para la tabla cliente
INSERT INTO cliente (cod_cliente, dni, nombre, direccion, telefono) 
VALUES ('C001', '12345678A', 'Juan Pérez', 'Calle Falsa 123', '600123456');

INSERT INTO cliente (cod_cliente, dni, nombre, direccion, telefono) 
VALUES ('C002', '23456789B', 'María López', 'Avenida Siempre Viva 742', '600234567');

INSERT INTO cliente (cod_cliente, dni, nombre, direccion, telefono) 
VALUES ('C003', '34567890C', 'Carlos Sánchez', 'Plaza Mayor 1', '600345678');

INSERT INTO cliente (cod_cliente, dni, nombre, direccion, telefono) 
VALUES ('C004', '45678901D', 'Laura García', 'Calle del Sol 45', '600456789');

-- Datos para la tabla avala
INSERT INTO avala (avalado, avalador) 
VALUES ('C001', 'C002');

INSERT INTO avala (avalado, avalador) 
VALUES ('C002', 'C003');

INSERT INTO avala (avalado, avalador) 
VALUES ('C003', 'C004');

INSERT INTO avala (avalado, avalador) 
VALUES ('C004', 'C001');

-- Datos para la tabla reserva
INSERT INTO reserva (numero, fechainicio, fechafin, preciototal, codcliente) 
VALUES (1001, TO_DATE('2023-01-01', 'YYYY-MM-DD'), TO_DATE('2023-01-05', 'YYYY-MM-DD'), 150.50, 'C001');

INSERT INTO reserva (numero, fechainicio, fechafin, preciototal, codcliente) 
VALUES (1002, TO_DATE('2023-02-10', 'YYYY-MM-DD'), TO_DATE('2023-02-12', 'YYYY-MM-DD'), 75.00, 'C002');

INSERT INTO reserva (numero, fechainicio, fechafin, preciototal, codcliente) 
VALUES (1003, TO_DATE('2023-03-15', 'YYYY-MM-DD'), TO_DATE('2023-03-20', 'YYYY-MM-DD'), 200.00, 'C003');

INSERT INTO reserva (numero, fechainicio, fechafin, preciototal, codcliente) 
VALUES (1004, TO_DATE('2023-04-01', 'YYYY-MM-DD'), TO_DATE('2023-04-07', 'YYYY-MM-DD'), 300.00, 'C004');

-- Datos para la tabla coche
INSERT INTO coche (matricula, marca, modelo, color, preciohora) 
VALUES ('ABC1234', 'Toyota', 'Corolla', 'Rojo', 15);

INSERT INTO coche (matricula, marca, modelo, color, preciohora) 
VALUES ('DEF5678', 'Honda', 'Civic', 'Azul', 20);

INSERT INTO coche (matricula, marca, modelo, color, preciohora) 
VALUES ('GHI9012', 'Ford', 'Focus', 'Negro', 18);

INSERT INTO coche (matricula, marca, modelo, color, preciohora) 
VALUES ('JKL3456', 'BMW', 'X3', 'Blanco', 25);

-- Datos para la tabla incluye
INSERT INTO incluye (numero, matricula, litrosgas) 
VALUES (1001, 'ABC1234', 50);

INSERT INTO incluye (numero, matricula, litrosgas) 
VALUES (1002, 'DEF5678', 30);

INSERT INTO incluye (numero, matricula, litrosgas) 
VALUES (1003, 'GHI9012', 60);

INSERT INTO incluye (numero, matricula, litrosgas) 
VALUES (1004, 'JKL3456', 70);
