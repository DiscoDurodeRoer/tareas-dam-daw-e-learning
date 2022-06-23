-- Jornadas
INSERT INTO Jornadas VALUES (1, to_date('24/01/2015','dd/mm/yyyy') , 'Don Benito',  'M' );
INSERT INTO Jornadas VALUES (2, to_date('01/02/2015','dd/mm/yyyy') , 'Badajoz' ,    'M');
INSERT INTO Jornadas VALUES (3, to_date('14/02/2015','dd/mm/yyyy') , 'Navalmoral',  'M' );
INSERT INTO Jornadas VALUES (4, to_date('01/03/2015','dd/mm/yyyy') , 'Almendralejo','T' );
INSERT INTO Jornadas VALUES (5, to_date('14/03/2015','dd/mm/yyyy') , 'Caceres' ,    'M' );
INSERT INTO Jornadas VALUES (6, to_date('19/03/2015','dd/mm/yyyy') , 'Merida' ,     'T' );

-- Equipos
INSERT INTO Equipos VALUES (1,'Pacense','Badajoz','BA',2004,1);
INSERT INTO Equipos VALUES (2,'Don Benito','Don Benito','BA',2010,1);
INSERT INTO Equipos VALUES (3,'Moralo','Navalmoral','CC',2005,1);
INSERT INTO Equipos VALUES (4,'Magic','Merida','BA',2001,1);
INSERT INTO Equipos VALUES (5,'Caceres','Caceres','CC',2009,1);
INSERT INTO Equipos VALUES (6,'Placentino','Plasencia','CC',2003,1);
INSERT INTO Equipos VALUES (13,'Almendralejo','Almendralejo','BA',2001,1);
INSERT INTO Equipos VALUES (14,'Trujillano','Trujillo','CC',2002,1);

INSERT INTO Equipos VALUES (7,'Zafra','Zafra','BA',2002,2);
INSERT INTO Equipos VALUES (8,'Coria','Coria','CC',2004,2);
INSERT INTO Equipos VALUES (9,'PuertaPalma','Badajoz','BA',2001,2);
INSERT INTO Equipos VALUES (10,'Ateneo','Caceres','CC',2004,2);
INSERT INTO Equipos VALUES (11,'Castuera','Castuera','BA',2002,2);
INSERT INTO Equipos VALUES (12,'Olivenza','Olivenza','BA',2003,2);
INSERT INTO Equipos VALUES (15,'Miajadas','Miajadas','CC',2001,2);
INSERT INTO Equipos VALUES (16,'Circulo','Badajoz','BA',2005,2);


-- Jugadores
INSERT INTO Jugadores VALUES (11, 'Montes Calero', 'Francisco', 'GM', 2560, 1, 1, 50,to_date('04/03/1960','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (12, 'Bueno Lozano', 'Eulalio', 'IM', 2300, 1, 2, 44.75,to_date('22/07/1962','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (13, 'Zapata Simoes', 'Marcelo',  null,2000, 1, 3, 32.25,to_date('07/06/1964','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (14, 'Conejero Niso', 'Daniel',  null,1800, 1, 4,0, to_date('23/05/1966','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (15, 'Andrade Maya', 'Dario',  null,1700, 1, 5, 0,to_date('23/02/1968','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (21, 'Lobato Rueda', 'Francisco', 'GM', 2525, 2, 1,75, to_date('22/01/1970','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (22, 'Mateos Pajuelo', 'Manuel', 'MF', 2325, 2, 2,70, to_date('13/04/1972','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (23, 'Cabezas Merino', 'Luisa',  null,2100, 2, 3, 65,to_date('25/09/1974','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (24, 'Mateos Acedo', 'Oscar',  null,1850, 2, 4, 50,to_date('23/04/1976','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (25, 'Bahamontes Torres', 'Luciano',  null,1450, 2, 5,0, to_date('14/12/1978','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (31, 'Alcalde Herrera', 'Cristian', 'GM', 2536, 3, 1,90, to_date('20/05/1960','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (32, 'Madagar Agudo', 'Francisco', 'IM', 2350, 3, 2, 85,to_date('06/01/1970','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (33, 'Bejar Barroso', 'Jose Antonio',  null,2200, 3, 3, 82.75,to_date('29/07/1980','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (34, 'Corbacho Cano', 'Jose Antonio',  null,1875, 3, 4, 75,to_date('30/03/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (35, 'Carpintero Rueda', 'Fernando',  null,1750, 3, 5, 65,to_date('12/04/2000','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (41, 'Agudo Lozano', 'Ruben', 'GM', 2512, 4, 1, 65,to_date('05/07/1965','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (42, 'Moraga Fuentes', 'Diego', 'IM', 2375, 4, 2, 60,to_date('17/11/1975','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (43, 'Mulet Torres', 'Carlos',  null,2125, 4, 3, 55,to_date('14/09/1980','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (44, 'Lobato Cano', 'David',  null,1890, 4, 4, 40,to_date('23/09/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (45, 'Morientes Rueda', 'Laura',  null,1689, 4, 5, 0,to_date('05/03/1966','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (51, 'Martin Torres', 'Alberto', 'GM', 2566, 5, 1,85, to_date('24/01/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (52, 'Panadero Lozano', 'Victor', 'IM', 2345, 5, 2, 75,to_date('23/10/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (53, 'Alcalde Agudo', 'Alvaro',  null,2000, 5, 3, 65,to_date('30/10/1994','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (54, 'Parejo Herrera', 'Jorge',  null,1850, 5, 4, 55,to_date('28/11/1996','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (55, 'Moya Acedo', 'Oscar',  null,1600, 5, 5, 0,to_date('04/12/1998','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (61, 'Lozano Merino', 'Javier', 'GM', 2475, 6, 1, 95.25,to_date('21/05/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (62, 'Taborda Fuentes', 'Juan', 'IM', 2340, 6, 2,90, to_date('06/02/1987','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (63, 'Marquez Carmona', 'Javier',  null,2200, 6, 3, 80,to_date('13/02/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (64, 'Medina Cano', 'Daniel',  null,1847, 6, 4, 70,to_date('20/11/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (65, 'Hidalgo Barroso', 'Alberto',  null,1582, 6, 5,0, to_date('06/11/1994','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (71, 'Burgos Lozano', 'Manuel', 'MF', 2350, 7, 1, 55,to_date('10/10/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (72, 'Osorio Acedo', 'Juan',  null,2275, 7, 2, 45,to_date('14/03/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (73, 'Sosa Rueda', 'Clara',  null,2100, 7, 3, 35,to_date('19/05/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (74, 'Mateos Agudo', 'Lucas',  null,1846, 7, 4, 0,to_date('26/08/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (75, 'Gallego Herrera', 'Alberto',  null,1600, 7, 5,0, to_date('16/04/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (81, 'Pulido Merino', 'Pablo', 'IM', 2225, 8, 1, 60,to_date('08/04/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (82, 'Castellanos', 'Antonio',  null,2100, 8, 2, 55,to_date('11/01/1988','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (83, 'Lucas Godoy', 'Juan',  null,2050, 8, 3, 50,to_date('26/04/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (84, 'Amador Godoy', 'Daniel',  null,1825, 8, 4, 0,to_date('13/10/1997','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (85, 'Garcia Lozano', 'Pedro',  null,1450, 8, 5, 0,to_date('14/01/1998','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (91, 'Trejo Acedo', 'Manuel', 'IM', 2490, 9, 1, 55,to_date('11/09/1982','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (92, 'Mairena Barroso', 'Dario',  null,2150, 9, 2, 50,to_date('24/02/1983','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (93, 'Villafruela Rueda', 'Alberto',  null,1900, 9, 3,45, to_date('29/03/1984','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (94, 'Nevado Lozano', 'Pablo',  null,1869, 9, 4, 40,to_date('04/12/1986','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (95, 'Reyes Godoy', 'Pedro',  null,1550, 9, 5, 0,to_date('18/11/1986','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (101, 'Soto Merino', 'Oscar', 'IM', 2275, 10, 1, 65,to_date('08/11/1994','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (102, 'Garcia Fuentes', 'Luis',  null,2124, 10, 2, 60,to_date('14/10/1996','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (103, 'Constantino Barroso', 'Javier',  null,1975, 10, 3,55, to_date('12/05/1998','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (104, 'Lobato Lozano', 'Nicomedes',  null,1874, 10, 4, 45,to_date('09/07/1999','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (105, 'Castro Rueda', 'Alberto',  null,1699, 10, 5, 0,to_date('03/11/1999','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (111, 'Montes Bueno', 'Francisco',  null,2260, 11, 1, 65,to_date('20/11/1973','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (112, 'Lozano Calero', 'Antonio',  null,2030, 11, 2, 60,to_date('29/11/1976','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (113, 'Zapata Niso', 'Marcelo',  null,2000, 11, 3, 55,to_date('15/10/1979','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (114, 'Simoes Conejero', 'Daniel',  null,1800, 11, 4, 0,to_date('12/03/1982','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (115, 'Rueda Andrade', 'Dario',  null,1700, 11, 5, 0,to_date('13/02/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (121, 'Maya Lobato', 'Francisco',  null,2225, 12, 1, 55,to_date('03/03/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (122, 'Merino Mateos', 'Manuel',  null,2125, 12, 2, 45,to_date('16/03/1988','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (123, 'Pajuelo Cabezas', 'Luisa',  null,2100, 12, 3, 35,to_date('15/01/1973','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (124, 'Torres Mateos', 'Oscar',  null,1850, 12, 4, 0,to_date('09/10/1970','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (125, 'Acedo Bahamontes', 'Luciano',  null,1450, 12, 5, 0,to_date('25/03/1994','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (131, 'Agudo Alcalde', 'Antonio', 'GM', 2536, 13, 1, 75,to_date('01/02/1978','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (132, 'Herrera Madagar', 'Francisco', 'IM', 2350, 13, 2,70, to_date('06/12/1975','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (133, 'Cano Bejar', 'Jose Antonio',  null,2200, 13, 3, 65,to_date('18/09/1997','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (134, 'Barroso Corbacho', 'Jose Antonio',  null,1875, 13, 4,60, to_date('08/01/1999','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (135, 'Lozano Carpintero', 'Daniel',  null,1750, 13, 5, 0,to_date('24/10/1970','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (141, 'Rueda Agudo', 'Ruben', 'GM', 2512, 14, 1, 65,to_date('14/07/1976','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (142, 'Torres Moraga', 'Diego', 'IM', 2375, 14, 2, 60,to_date('17/03/1986','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (143, 'Fuentes Mulet', 'Carlos',  null,2125, 14, 3, 55,to_date('11/07/1988','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (144, 'Rueda Lobato', 'Miguel',  null,1890, 14, 4, 45,to_date('16/06/2000','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (145, 'Cano  Morientes', 'Laura',  null,1689, 14, 5, 0,to_date('02/07/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (151, 'Martin Lozano', 'Alberto', 'GM', 2566, 15, 1, 50,to_date('29/12/1990','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (152, 'Torres Panadero', 'Alvaro', 'IM', 2345, 15, 2, 45,to_date('26/05/1996','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (153, 'Alcalde Herrera', 'Javier',  null,2005, 15, 3, 40,to_date('30/04/2004','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (154, 'Parejo Agudo', 'Jorge',  null,1850, 15, 4, 35,to_date('21/01/2004','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (155, 'Moya Merino', 'Oscar',  null,1600, 15, 5, 0,to_date('21/02/2004','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (161, 'Lozano  Acedo', 'Victor', 'GM', 2475, 16, 1, 60,to_date('09/05/1985','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (162, 'Taborda Carmona', 'Miguel', 'IM', 2340, 16, 2, 55,to_date('10/04/1996','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (163, 'Marquez Fuentes', 'Javier',  null,2200, 16, 3, 45,to_date('10/05/1994','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (164, 'Medina Barroso', 'Fernando',  null,1847, 16, 4, 0,to_date('26/05/1992','dd/mm/yyyy')  );
INSERT INTO Jugadores VALUES (165, 'Hidalgo  Cano', 'Alberto',  null,1582, 16, 5, 0,to_date('20/05/1975','dd/mm/yyyy')  );


-- Encuentros
INSERT INTO Encuentros VALUES (1, 1, 'A', 1, 1, 1  );
INSERT INTO Encuentros VALUES (1, 1, 'B', 6, 3, 3  );
INSERT INTO Encuentros VALUES (1, 2, 'A', 2, 1, 1.5  );
INSERT INTO Encuentros VALUES (1, 2, 'B', 5, 3, 2.5  );
INSERT INTO Encuentros VALUES (1, 3, 'A', 3, 2, 2  );
INSERT INTO Encuentros VALUES (1, 3, 'B', 4, 2, 2  );
INSERT INTO Encuentros VALUES (1, 4, 'A', 7, 1, 1  );
INSERT INTO Encuentros VALUES (1, 4, 'B', 12, 3, 3  );
INSERT INTO Encuentros VALUES (1, 5, 'A', 8, 2, 2  );
INSERT INTO Encuentros VALUES (1, 5, 'B', 11, 2, 2  );
INSERT INTO Encuentros VALUES (1, 6, 'A', 9, 2, 2  );
INSERT INTO Encuentros VALUES (1, 6, 'B', 10, 2, 2  );
INSERT INTO Encuentros VALUES (2, 1, 'A', 6, 2, 2  );
INSERT INTO Encuentros VALUES (2, 1, 'B', 4, 2, 2  );
INSERT INTO Encuentros VALUES (2, 2, 'A', 5, 1, 1  );
INSERT INTO Encuentros VALUES (2, 2, 'B', 3, 3, 3  );
INSERT INTO Encuentros VALUES (2, 3, 'A', 1, 1, 1  );
INSERT INTO Encuentros VALUES (2, 3, 'B', 2, 3, 3  );
INSERT INTO Encuentros VALUES (2, 4, 'A', 12, 1, 0  );
INSERT INTO Encuentros VALUES (2, 4, 'B', 10, 3, 4  );
INSERT INTO Encuentros VALUES (2, 5, 'A', 11, 2, 2  );
INSERT INTO Encuentros VALUES (2, 5, 'B', 9, 2, 2  );
INSERT INTO Encuentros VALUES (2, 6, 'A', 7, 1, 1  );
INSERT INTO Encuentros VALUES (2, 6, 'B', 8, 3, 3  );
INSERT INTO Encuentros VALUES (3, 1, 'A', 2, 2, 2  );
INSERT INTO Encuentros VALUES (3, 1, 'B', 6, 2, 2  );
INSERT INTO Encuentros VALUES (3, 2, 'A', 3, 3, 3  );
INSERT INTO Encuentros VALUES (3, 2, 'B', 1, 1, 1  );
INSERT INTO Encuentros VALUES (3, 3, 'A', 4, 2, 2  );
INSERT INTO Encuentros VALUES (3, 3, 'B', 5, 2, 2  );
INSERT INTO Encuentros VALUES (3, 4, 'A', 8, 2, 2  );
INSERT INTO Encuentros VALUES (3, 4, 'B', 12, 2, 2  );
INSERT INTO Encuentros VALUES (3, 5, 'A', 9, 1, 1.5  );
INSERT INTO Encuentros VALUES (3, 5, 'B', 7, 3, 2.5  );
INSERT INTO Encuentros VALUES (3, 6, 'A', 10, 1, 1  );
INSERT INTO Encuentros VALUES (3, 6, 'B', 11, 3, 3  );
INSERT INTO Encuentros VALUES (4, 1, 'A', 6, 3, 3.5  );
INSERT INTO Encuentros VALUES (4, 1, 'B', 5, 1, .5  );
INSERT INTO Encuentros VALUES (4, 2, 'A', 1, 3, 3  );
INSERT INTO Encuentros VALUES (4, 2, 'B', 4, 1, 1  );
INSERT INTO Encuentros VALUES (4, 3, 'A', 2, 2, 2  );
INSERT INTO Encuentros VALUES (4, 3, 'B', 3, 2, 2  );
INSERT INTO Encuentros VALUES (4, 4, 'A', 12, 3, 2.5  );
INSERT INTO Encuentros VALUES (4, 4, 'B', 11, 1, 1.5  );
INSERT INTO Encuentros VALUES (4, 5, 'A', 7, 1, 1.5  );
INSERT INTO Encuentros VALUES (4, 5, 'B', 10, 3, 2.5  );
INSERT INTO Encuentros VALUES (4, 6, 'A', 8, 3, 2.5  );
INSERT INTO Encuentros VALUES (4, 6, 'B', 9, 1, 1.5  );
INSERT INTO Encuentros VALUES (5, 1, 'A', 3, 1, 0  );
INSERT INTO Encuentros VALUES (5, 1, 'B', 6, 3, 4  );
INSERT INTO Encuentros VALUES (5, 2, 'A', 4, 3, 2.5  );
INSERT INTO Encuentros VALUES (5, 2, 'B', 2, 1, 1.5  );
INSERT INTO Encuentros VALUES (5, 3, 'A', 5, 1, 1.5  );
INSERT INTO Encuentros VALUES (5, 3, 'B', 1, 3, 2.5  );
INSERT INTO Encuentros VALUES (5, 4, 'A', 9, 2, 2  );
INSERT INTO Encuentros VALUES (5, 4, 'B', 12, 2, 2  );
INSERT INTO Encuentros VALUES (5, 5, 'A', 10, 3, 3  );
INSERT INTO Encuentros VALUES (5, 5, 'B', 8, 1, 1  );
INSERT INTO Encuentros VALUES (5, 6, 'A', 11, 1, 1  );
INSERT INTO Encuentros VALUES (5, 6, 'B', 7, 3, 3  );


-- Enc_Jugadores
INSERT INTO Enc_Jugadores VALUES (1, 1, 1, 'B', 11, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 1, 'N', 61, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 2, 'B', 62, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 2, 'N', 12, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 3, 'B', 13, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 3, 'N', 63, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 4, 'B', 64, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 1, 4, 'N', 14, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 1, 'B', 21, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 1, 'N', 51, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 2, 'B', 52, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 2, 'N', 22, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 3, 'B', 23, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 3, 'N', 53, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 4, 'B', 54, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 2, 4, 'N', 24, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 1, 'B', 31, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 1, 'N', 41, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 2, 'B', 42, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 2, 'N', 32, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 3, 'B', 33, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 3, 'N', 43, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 4, 'B', 44, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 3, 4, 'N', 34, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 1, 'B', 71, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 1, 'N', 121, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 2, 'B', 122, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 2, 'N', 72, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 3, 'B', 73, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 3, 'N', 123, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 4, 'B', 124, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 4, 4, 'N', 74, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 1, 'B', 81, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 1, 'N', 111, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 2, 'B', 112, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 2, 'N', 82, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 3, 'B', 83, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 3, 'N', 113, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 4, 'B', 114, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 5, 4, 'N', 84, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 1, 'B', 91, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 1, 'N', 101, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 2, 'B', 102, 0 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 2, 'N', 92, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 3, 'B', 93, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 3, 'N', 103, .5 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 4, 'B', 104, 1 );
INSERT INTO Enc_Jugadores VALUES (1, 6, 4, 'N', 94, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 1, 'B', 61, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 1, 'N', 41, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 2, 'B', 42, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 2, 'N', 62, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 3, 'B', 63, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 3, 'N', 43, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 4, 'B', 44, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 1, 4, 'N', 64, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 1, 'B', 51, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 1, 'N', 31, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 2, 'B', 32, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 2, 'N', 52, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 3, 'B', 53, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 3, 'N', 33, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 4, 'B', 34, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 2, 4, 'N', 54, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 1, 'B', 11, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 1, 'N', 21, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 2, 'B', 22, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 2, 'N', 12, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 3, 'B', 13, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 3, 'N', 23, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 4, 'B', 24, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 3, 4, 'N', 14, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 1, 'B', 121, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 1, 'N', 101, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 2, 'B', 102, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 2, 'N', 122, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 3, 'B', 123, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 3, 'N', 103, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 4, 'B', 104, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 4, 4, 'N', 124, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 1, 'B', 111, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 1, 'N', 91, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 2, 'B', 92, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 2, 'N', 112, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 3, 'B', 113, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 3, 'N', 93, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 4, 'B', 94, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 5, 4, 'N', 114, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 1, 'B', 71, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 1, 'N', 81, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 2, 'B', 82, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 2, 'N', 72, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 3, 'B', 73, 0 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 3, 'N', 83, 1 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 4, 'B', 84, .5 );
INSERT INTO Enc_Jugadores VALUES (2, 6, 4, 'N', 74, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 1, 'B', 21, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 1, 'N', 61, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 2, 'B', 62, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 2, 'N', 22, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 3, 'B', 23, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 3, 'N', 63, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 4, 'B', 64, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 1, 4, 'N', 24, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 1, 'B', 31, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 1, 'N', 11, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 2, 'B', 12, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 2, 'N', 32, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 3, 'B', 33, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 3, 'N', 13, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 4, 'B', 14, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 2, 4, 'N', 34, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 1, 'B', 41, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 1, 'N', 51, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 2, 'B', 52, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 2, 'N', 42, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 3, 'B', 43, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 3, 'N', 53, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 4, 'B', 54, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 3, 4, 'N', 44, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 1, 'B', 81, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 1, 'N', 121, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 2, 'B', 122, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 2, 'N', 82, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 3, 'B', 83, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 3, 'N', 123, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 4, 'B', 124, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 4, 4, 'N', 84, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 1, 'B', 91, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 1, 'N', 71, .5 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 2, 'B', 72, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 2, 'N', 92, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 3, 'B', 93, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 3, 'N', 73, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 4, 'B', 74, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 5, 4, 'N', 94, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 1, 'B', 101, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 1, 'N', 111, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 2, 'B', 112, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 2, 'N', 102, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 3, 'B', 103, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 3, 'N', 113, 1 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 4, 'B', 114, 0 );
INSERT INTO Enc_Jugadores VALUES (3, 6, 4, 'N', 104, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 1, 'B', 61, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 1, 'N', 51, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 2, 'B', 52, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 2, 'N', 62, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 3, 'B', 63, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 3, 'N', 53, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 4, 'B', 54, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 1, 4, 'N', 64, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 1, 'B', 11, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 1, 'N', 41, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 2, 'B', 42, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 2, 'N', 12, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 3, 'B', 13, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 3, 'N', 43, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 4, 'B', 44, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 2, 4, 'N', 14, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 1, 'B', 21, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 1, 'N', 31, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 2, 'B', 32, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 2, 'N', 22, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 3, 'B', 23, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 3, 'N', 33, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 4, 'B', 34, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 3, 4, 'N', 24, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 1, 'B', 121, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 1, 'N', 111, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 2, 'B', 112, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 2, 'N', 122, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 3, 'B', 123, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 3, 'N', 113, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 4, 'B', 114, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 4, 4, 'N', 124, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 1, 'B', 71, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 1, 'N', 101, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 2, 'B', 102, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 2, 'N', 72, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 3, 'B', 73, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 3, 'N', 103, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 4, 'B', 104, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 5, 4, 'N', 74, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 1, 'B', 81, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 1, 'N', 91, .5 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 2, 'B', 92, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 2, 'N', 82, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 3, 'B', 83, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 3, 'N', 93, 0 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 4, 'B', 94, 1 );
INSERT INTO Enc_Jugadores VALUES (4, 6, 4, 'N', 84, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 1, 'B', 31, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 1, 'N', 61, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 2, 'B', 62, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 2, 'N', 32, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 3, 'B', 33, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 3, 'N', 63, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 4, 'B', 64, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 1, 4, 'N', 34, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 1, 'B', 41, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 1, 'N', 21, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 2, 'B', 22, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 2, 'N', 42, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 3, 'B', 43, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 3, 'N', 23, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 4, 'B', 24, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 2, 4, 'N', 44, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 1, 'B', 51, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 1, 'N', 11, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 2, 'B', 12, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 2, 'N', 52, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 3, 'B', 53, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 3, 'N', 13, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 4, 'B', 14, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 3, 4, 'N', 54, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 1, 'B', 91, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 1, 'N', 121, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 2, 'B', 122, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 2, 'N', 92, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 3, 'B', 93, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 3, 'N', 123, .5 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 4, 'B', 124, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 4, 4, 'N', 94, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 1, 'B', 101, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 1, 'N', 81, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 2, 'B', 82, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 2, 'N', 102, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 3, 'B', 103, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 3, 'N', 83, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 4, 'B', 84, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 5, 4, 'N', 104, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 1, 'B', 111, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 1, 'N', 71, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 2, 'B', 72, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 2, 'N', 112, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 3, 'B', 113, 0 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 3, 'N', 73, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 4, 'B', 74, 1 );
INSERT INTO Enc_Jugadores VALUES (5, 6, 4, 'N', 114, 0 );