-- 1

INSERT INTO CLIENTES VALUES('C08', 'Juan', 'Martinez Rodriguez', 30);

INSERT INTO PEDIDOS (NUM, FECHA, GASTOS_ENVIO, FECHA_PREVISTA, TOTAL, CLIENTE)
SELECT 
    (SELECT Count(*) + 1 FROM PEDIDOS) as NUM,
    TO_DATE('2024-03-12', 'YYYY-MM-DD') as FECHA,
    NULL as GASTOS_ENVIO,
    TO_DATE('2024-03-15', 'YYYY-MM-DD') as FECHA_PREVISTA,
    0 as TOTAL,
    'C08' as CLIENTE
FROM DUAL;

-- 2

INSERT INTO LINEAS(NUM, NUMPEDIDO, PRODUCTO, CANTIDAD, IMPORTE)
SELECT
    (SELECT COUNT(*) + 1 FROM LINEAS WHERE numpedido = (SELECT max(num) from pedidos)) as NUM,
    (SELECT max(num) from pedidos) as NUMPEDIDO,
    codigo as PRODUCTO,
    3 as CANTIDAD,
    3 * PRECIO as IMPORTE
FROM PRODUCTOS
WHERE codigo = '1001';

INSERT INTO LINEAS(NUM, NUMPEDIDO, PRODUCTO, CANTIDAD, IMPORTE)
SELECT
    (SELECT COUNT(*) + 1 FROM LINEAS WHERE numpedido = (SELECT max(num) from pedidos)) as NUM,
    (SELECT max(num) from pedidos) as NUMPEDIDO,
    codigo as PRODUCTO,
    2 as CANTIDAD,
    2 * PRECIO as IMPORTE
FROM PRODUCTOS
WHERE codigo = '1002';

-- 3

UPDATE PEDIDOS
SET TOTAL = (SELECT SUM(IMPORTE) FROM LINEAS WHERE NUMPEDIDO = (SELECT MAX(NUM) FROM PEDIDOS))
WHERE NUM = (SELECT MAX(NUM) FROM PEDIDOS);

-- 4

SELECT p.*, l.*
FROM PEDIDOS P, LINEAS L
WHERE P.num = L.numpedido
and p.num = (SELECT max(num) FROM PEDIDOS);

COMMIT;


-- 5

UPDATE PEDIDOS
SET FECHA_PREVISTA = FECHA_PREVISTA + 30
WHERE EXTRACT(YEAR from fecha) = 2024 and EXTRACT(MONTH from fecha) = 3
AND num IN (SELECT numpedido 
                from lineas, productos 
                where producto = codigo
                and nombre = 'HDD Z');

-- 6

UPDATE PEDIDOS
SET GASTOS_ENVIO = 15
WHERE EXTRACT(YEAR from fecha) = 2024
and nvl(gastos_envio,0) = 0
and total < 100;

-- 7

UPDATE PRODUCTOS
SET PRECIO = PRECIO * 0.8
WHERE codigo NOT IN (SELECT DISTINCT producto from LINEAS)


-- 8

Todas las instrucciones anteriores no tendrian efecto hasta la 4

-- 9

CREATE TABLE PRODUCTOS_BORRADOS(
    CODIGO NUMBER(5,0) PRIMARY KEY,
    NOMBRE VARCHAR2(30) NOT NULL,
    PRECIO NUMBER(7,2) NOT NULL,
    FECHA_BORRADO DATE NOT NULL
);

-- 10

INSERT INTO PRODUCTOS_BORRADOS
SELECT p.*, SYSDATE as FECHA_BORRADO
FROM Productos p
WHERE codigo not in (SELECT producto from lineas);

DELETE FROM Productos
WHERE codigo not in (SELECT producto from lineas);

-- No afecta la no haber dependencias

-- 11

DELETE FROM CLIENTES
WHERE upper(nombre) = 'Mª PILAR' and upper(apellidos) = 'PEREZ BERMEJO'

-- Al existir datos, no nos dejara, podemos borrar los pedidos que esten asociados, se gun la restriccion podriamos usar on delete restrict o on delete cascada

-- 12

DELETE FROM LINEAS 
WHERE numpedido = (SELECT num from pedidos where cliente = 'C08');

DELETE FROM PEDIDOS 
WHERE cliente = 'C08';
 
DELETE FROM CLIENTES 
WHERE codigo = 'C08';

-- 13

UPDATE LINEAS
SET CANTIDAD = 3
WHERE numpedido = 10 and num = 1;

UPDATE LINEAS
SET IMPORTE = CANTIDAD * (SELECT PRECIO FROM productos, lineas 
                            where codigo = producto
                            and numpedido = 10 and num = 1)
WHERE numpedido = 10 and num = 1;

UPDATE PEDIDOS
SET TOTAL = (SELECT SUM(IMPORTE) FROM LINEAS WHERE numpedido = 10)
WHERE num = 10;


-- 14

UPDATE PRODUCTOS
SET precio = 55
where nombre = 'HDD Y';

-- Para arreglar los pedidos y lineas

UPDATE LINEAS
SET IMPORTE = CANTIDAD * (SELECT PRECIO FROM productos where nombre = 'HDD Y')
WHERE producto = (SELECT codigo FROM productos where nombre = 'HDD Y');

UPDATE PEDIDOS P
SET TOTAL = (SELECT SUM(IMPORTE) FROM LINEAS WHERE numpedido = p.num)
WHERE num IN (SELECT numpedido FROM LINEAS 
                where producto = (SELECT codigo 
                                    FROM productos 
                                    where nombre = 'HDD Y'));