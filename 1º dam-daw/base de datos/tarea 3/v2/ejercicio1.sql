create table titular (
    DNI varchar2(9) PRIMARY KEY,
    nombre varchar2(20) NOT NULL,
    edad number(2,0),
    avalador varchar2(9),
    constraint fk_avalador FOREIGN KEY (avalador) REFERENCES titular(DNI) on DELETE SET NULL
);

create table tarjeta (
    NUM number(8,0) primary key,
    fecha date NOT NULL,
    titular varchar2(9) NOT NULL unique,
    constraint fk_titular FOREIGN KEY (titular) REFERENCES titular(DNI)
);

create table comercio (
    CIF varchar2(13) primary key,
    nombre varchar2(40) NOT NULL unique,
    calle varchar2(40) NULL,
    numero number(2,0)
);

create table compra(
    numtarjeta number(8,0),
    CIF varchar2(13),
    fecha date,
    importe number(5,2) NOT NULL,
    constraint pk_compra primary key (numtarjeta, CIF, fecha),
    constraint fk_cif FOREIGN KEY (CIF) REFERENCES comercio(CIF),
    constraint fk_tarjeta FOREIGN KEY (numtarjeta) REFERENCES tarjeta(NUM) on delete cascade,
    constraint chk_compra check ( (extract(day from fecha) >= 15 and extract(month from fecha) = 12) OR (extract(day from fecha) <= 6 and extract(month from fecha) = 1) )
);


INSERT INTO TITULAR (DNI, NOMBRE, EDAD) VALUES ('12345678F', 't1', '30');
INSERT INTO TITULAR (DNI, NOMBRE, EDAD, AVALADOR) VALUES ('12345678A', 't2', '40', '12345678F');
INSERT INTO TITULAR (DNI, NOMBRE, EDAD) VALUES ('12345687G', 't3', '50');
INSERT INTO TITULAR (DNI, NOMBRE, EDAD, AVALADOR) VALUES ('87654321S', 't4', '60', '12345687G');

INSERT INTO COMERCIO (CIF, NOMBRE, CALLE, NUMERO) VALUES ('123456789ABCD', 'c1', 'calle falsa', '1');
INSERT INTO COMERCIO (CIF, NOMBRE, CALLE, NUMERO) VALUES ('123456789EFGH', 'c2', 'calle inventada', '3');
INSERT INTO COMERCIO (CIF, NOMBRE) VALUES ('123456789IJKL', 'c3');
INSERT INTO COMERCIO (CIF, NOMBRE, CALLE, NUMERO) VALUES ('123456789MNOP', 'c4', 'calle oracle', '5');

INSERT INTO TARJETA (NUM, FECHA, TITULAR) VALUES ('1234', TO_DATE('2022-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '12345678F');
INSERT INTO TARJETA (NUM, FECHA, TITULAR) VALUES ('12345', TO_DATE('2022-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '12345678A');
INSERT INTO TARJETA (NUM, FECHA, TITULAR) VALUES ('123456', TO_DATE('2022-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '12345687G');
INSERT INTO TARJETA (NUM, FECHA, TITULAR) VALUES ('1234567', TO_DATE('2022-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '87654321S');

INSERT INTO COMPRA (NUMTARJETA, CIF, FECHA, IMPORTE) VALUES ('1234', '123456789ABCD', TO_DATE('2022-12-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '34');
INSERT INTO COMPRA (NUMTARJETA, CIF, FECHA, IMPORTE) VALUES ('12345', '123456789EFGH', TO_DATE('2023-01-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '35');
INSERT INTO COMPRA (NUMTARJETA, CIF, FECHA, IMPORTE) VALUES ('123456', '123456789IJKL', TO_DATE('2023-01-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '35');
INSERT INTO COMPRA (NUMTARJETA, CIF, FECHA, IMPORTE) VALUES ('1234567', '123456789MNOP', TO_DATE('2023-01-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '35');

