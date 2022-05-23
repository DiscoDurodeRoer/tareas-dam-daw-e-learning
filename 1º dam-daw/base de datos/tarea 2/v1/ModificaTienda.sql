-- STOCK
-- añadir columna fechaultimaentrada
ALTER TABLE STOCK add fechaultimaentrada date default SYSDATE;

-- añadir columna beneficio
ALTER TABLE STOCK add beneficio number(1,0);
ALTER TABLE STOCK add constraint CHK_BENEFICIO check(beneficio >= 1 and beneficio <= 5);

-- PRODUCTO
-- eliminar columna descripcion
ALTER TABLE PRODUCTO drop column descripcion;

-- añadir columnas perecedero
ALTER TABLE PRODUCTO add perecedero varchar2(1);
ALTER TABLE PRODUCTO add constraint CHK_PERECEDERO check(perecedero IN ('S','N'));

-- modificar tamaño campo
ALTER TABLE PRODUCTO modify denoproducto varchar2(50);

-- FAMILIA
-- añadir columna IVA
ALTER TABLE FAMILIA add IVA number(2,0);
ALTER TABLE FAMILIA add constraint CHK_IVA check(IVA IN(4,10,21));

-- TIENDA
-- tienda en una zona
ALTER TABLE TIENDA add constraint UQ_COD_POSTAL UNIQUE (codigopostal);

-- Renombrar stock
RENAME STOCK to PRODXTIENDAS;

-- Eliminar la tabla familias
DELETE FROM FAMILIA;
ALTER TABLE PRODUCTO DROP CONSTRAINT FK_FAMILIA;
DROP TABLE FAMILIA;

-- Crear usuario
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
create user C##INVITADO identified by 123456;
grant all ON PRODUCTO TO C##INVITADO;

-- Retirar permisos
revoke ALTER, DELETE ON PRODUCTO FROM C##INVITADO;









