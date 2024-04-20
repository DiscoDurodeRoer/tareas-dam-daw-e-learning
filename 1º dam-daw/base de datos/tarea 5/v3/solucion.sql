-- 1

INSERT INTO jornadas (idjornada, localidad, horario, fecha)
VALUES (7, 'Plasencia', 'T', to_date('2015-03-28', 'YYYY-MM-DD'));

INSERT INTO jornadas (idjornada, localidad, horario, fecha)
VALUES (8, 'Plasencia', 'T', to_date('2015-04-05', 'YYYY-MM-DD'));

-- 2

alter table jornadas
ADD provincia VARCHAR2(2) 
constraint CK_PROVINCIA CHECK (provincia in ('BA', 'CC'));

UPDATE jornadas
SET provincia = 'BA' 
WHERE localidad in ('Don Benito', 'Badajoz', 'Navalmoral', 'Almendralejo');

UPDATE jornadas
SET provincia = 'CC' 
WHERE localidad in ('Caceres', 'Merida', 'Plasencia');

-- 3

alter table jugadores ADD enc_ganados NUMBER DEFAULT 0;

UPDATE jugadores j
SET j.enc_ganados = (
    SELECT COUNT(*)
    FROM enc_jugadores
    WHERE idjugador = j.idjugador
    and puntos = 1
);

-- 4

CREATE TABLE JUGADORES_PENOSOS AS
SELECT 
    idjugador,
    nombre,
    apellidos,
    idequipo
FROM jugadores j
WHERE (
    SELECT SUM(puntos) 
    FROM enc_jugadores 
    WHERE idjugador = j.idjugador) < 2;


-- 5

update JUGADORES j
SET nombre = UPPER(nombre), apellidos = UPPER(apellidos)
WHERE titulo is not null
and idequipo IN (
    SELECT idequipo
    FROM equipos
    where division = 2
);

-- 6

DELETE FROM jugadores
WHERE idjugador NOT IN (SELECT distinct idjugador from enc_jugadores);

-- 7

SET TRANSACTION READ WRITE;

-- a

SELECT *
FROM equipos
WHERE idequipo NOT IN (SELECT distinct idequipo from encuentros);

-- b

DELETE FROM equipos
WHERE idequipo NOT IN (SELECT distinct idequipo from encuentros);

-- c

SELECT *
from Equipos 
order by idequipo, nombreequipo;

-- d

ROLLBACK;

-- e

SELECT *
from Equipos 
order by idequipo, nombreequipo;

-- f. Realizariamos un COMMIT en el apartado d

-- 8

ALTER TABLE Equipos ADD Enc_Ganados NUMBER(3) DEFAULT 0;
ALTER TABLE Equipos ADD Enc_Empatados NUMBER(3) DEFAULT 0;
ALTER TABLE Equipos ADD Enc_Perdidos NUMBER(3) DEFAULT 0;

    
UPDATE equipos e
SET enc_ganados = (SELECT COUNT(*) 
                    FROM encuentros 
                    WHERE idequipo = e.idequipo and puntos = 3),
enc_empatados = (SELECT COUNT(*) 
                    FROM encuentros 
                    WHERE idequipo = e.idequipo and puntos = 2),
enc_perdidos = (SELECT COUNT(*) 
                    FROM encuentros 
                    WHERE idequipo = e.idequipo and puntos = 1);
                      
select idequipo, nombreequipo, enc_ganados, enc_empatados, enc_perdidos
FROM equipos
order by idequipo;

-- 9 

ALTER TABLE equipos drop (enc_ganados, enc_empatados, enc_perdidos);
