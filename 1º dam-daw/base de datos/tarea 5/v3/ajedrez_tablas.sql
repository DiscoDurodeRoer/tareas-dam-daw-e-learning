-- Jornadas
CREATE TABLE Jornadas (
  IdJornada number(1) NOT NULL,
  Fecha date not null,
  Localidad varchar2(20) DEFAULT NULL,
  Horario char(1) DEFAULT 'M', 
  CONSTRAINTS JOR_IDJ_PK PRIMARY KEY (IdJornada),
  CONSTRAINTS JOR_HOR_CK CHECK (Horario IN ('M', 'T') ) -- Mañana / Tarde
 );

-- Equipos
 CREATE TABLE Equipos (
  IdEquipo number(2),
  NombreEquipo varchar(20) NOT NULL,
  Localidad varchar(20) NOT NULL,
  Provincia varchar(2) DEFAULT 'BA',
  Anio_Creacion number(4), 
  Division number(1) DEFAULT 1,
  CONSTRAINTS EQU_COD_PK PRIMARY KEY (IdEquipo)
);


-- Jugadores
CREATE TABLE Jugadores (
  IdJugador number(3) NOT NULL,
  Apellidos varchar(25) NOT NULL,
  Nombre varchar(20)  NOT NULL,
  Titulo varchar2(2) DEFAULT NULL,
  ELO number(4) DEFAULT NULL,
  IdEquipo number(2) NOT NULL,
  OrdenFuerza number(1) NOT NULL, 
  Importe_Enc number(5,2) not null ,
  Fecha_Nacimiento  date, 
  CONSTRAINTS JUG_COD_PK PRIMARY KEY (IdJugador),
  CONSTRAINTS JUG_EQU_FK FOREIGN KEY (IdEquipo) References Equipos(IdEquipo) on delete cascade 
);

-- Encuentros
CREATE TABLE Encuentros (
  IdJornada number(1) not null,
  IdEncuentro number(1) not null,  
  Tipo char(1) DEFAULT 'A', 
  IdEquipo number(2) not null ,
  Puntos number(1) not null ,
  Average number(2,1) not null ,
  CONSTRAINTS ECU_IDS_PK PRIMARY KEY (IdJornada, IdEncuentro, Tipo), 
  CONSTRAINTS ECU_TIP_CK CHECK (Tipo IN ('A', 'B') ), 
  CONSTRAINTS ECU_EQU_FK FOREIGN KEY (IdEquipo) References Equipos(IdEquipo) on delete cascade , 
  CONSTRAINTS ECU_JOR_FK FOREIGN KEY (IdJornada) References Jornadas(IdJornada) on delete cascade 
);

-- Enc_Jugadores
CREATE TABLE Enc_Jugadores (
  IdJornada number(1) not null,
  IdEncuentro number(1) not null,  
  Tablero number(1) default 1 not null,  
  Juega_BN char(1) DEFAULT 'B', 
  IdJugador number(3) not null ,  
  Puntos number(2,1) not null ,
  CONSTRAINTS ECJ_IDS_PK PRIMARY KEY (IdJornada, IdEncuentro, Tablero, Juega_BN), 
  CONSTRAINTS ECJ_JBN_CK CHECK (Juega_BN IN ('B', 'N') ),
  CONSTRAINTS ECJ_TAB_CK CHECK (Tablero between 1 and 4  ), 
  CONSTRAINTS ECJ_IEN_CK CHECK (IdEncuentro between 1 and 6  ), 
  CONSTRAINTS ECJ_IJU_FK FOREIGN KEY (IdJugador) References Jugadores(IdJugador) on delete cascade , 
  CONSTRAINTS ECJ_IJO_FK FOREIGN KEY (IdJornada) References Jornadas(IdJornada) on delete cascade 
);

