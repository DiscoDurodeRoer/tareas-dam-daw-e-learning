-- 1

select * 
from productos 
where precio between 30 and 60
order by precio desc;

-- 2

select * 
from pedidos 
where fecha between SYSDATE - 50 and SYSDATE;

-- 3

select num, fecha, cliente, total, gastos_envio, total + gastos_envio as IMPORTE_TOTAL
from pedidos
where gastos_envio IS NOT NULL;

-- 4

select num, fecha, cliente, total, NVL(gastos_envio,0) AS gastos_envio, total + NVL(gastos_envio,0) as IMPORTE_TOTAL
from pedidos

-- 5


SELECT *
FROM CLIENTES
WHERE upper(apellidos) LIKE '%GARCIA%' 
COLLATE binary_ai;

-- 6

SELECT p.*, c.*
FROM pedidos p, clientes c
WHERE p.cliente = c.codigo;

-- 7

SELECT *
FROM productos
WHERE codigo not in (select producto from lineas);

-- 8

SELECT count(*) as "Nº de productos"
FROM productos

-- 9

select c.codigo, c.nombre, count(*)
from clientes c, pedidos p
where c.codigo = p.cliente
and EXTRACT(YEAR from date) = 2023
group by c.codigo, c.nombre;

-- 10

SELECT C.CODIGO AS CodigoCliente, C.NOMBRE AS NombreCliente, COUNT(P.NUM) AS TotalPedidos
FROM CLIENTES C LEFT JOIN PEDIDOS P ON C.CODIGO = P.CLIENTE AND p.fecha LIKE '%/23'
GROUP BY C.CODIGO, C.NOMBRE

-- 11

select c.codigo, c.nombre, COUNT(*) as "Nº pedidos realizados", sum(total + NVL(gastos_envio,0))as IMPORTE_TOTAL
from clientes c, pedidos p
where c.codigo = p.cliente
group by c.codigo, c.nombre
order by COUNT(*) desc;

-- 12

select c.codigo, c.nombre, COUNT(*) as "Nº pedidos realizados"
from clientes c, pedidos p
where c.codigo = p.cliente
group by c.codigo, c.nombre
having COUNT(*) > 2;

-- 13

select c.*
from (select c.codigo, COUNT(*) as pedidos_realizados
from clientes c, pedidos p
where c.codigo = p.cliente
group by c.codigo) t,
clientes c
where c.codigo = t.codigo
and t.pedidos_realizados = (select max(t2.pedidos_realizados) 
                                from (select c.codigo, COUNT(*) as pedidos_realizados
                                        from clientes c, pedidos p
                                        where c.codigo = p.cliente
                                        group by c.codigo) t2
                            );

-- 14

select p.cliente, pro.nombre, sum(l.cantidad)
from pedidos p, lineas l, productos pro
where p.num = l.numpedido and l.producto = pro.codigo
group by p.cliente, pro.nombre;

-- 15

   
select *
from productos
where codigo IN 
    (select producto
        from lineas
        where numpedido IN 
            (select num 
                from pedidos
                where cliente IN 
                    (select codigo
                        from clientes
                        where upper(nombre) = 'LUIS' 
                            and upper(apellidos) = 'GARCIA PEREZ'
                            collate binary_ai)))                                                               where nombre = 'Luis' and apellidos= 'Garcia Perez')))

-- 16

select pro.*
from productos pro, lineas l, pedidos p, clientes c
where pro.codigo = l.producto and p.num = l.numpedido and p.cliente = c.codigo
and c.nombre = 'Luis' and c.apellidos= 'Garcia Perez'

-- 17


select pro.*
from (select pro.codigo, sum(l.cantidad) as unidades
from productos pro ,lineas l
where pro.codigo = l.producto
group by pro.codigo) t,
productos pro
where t.codigo = pro.codigo
and t.unidades = (select max(t2.unidades) 
    				from (select pro.codigo, sum(l.cantidad) as unidades
                            from productos pro ,lineas l
                            where pro.codigo = l.producto
                            group by pro.codigo) t2
    		   );

-- 18

SELECT *
FROM productos
WHERE precio = (select max(pro.precio)
                        from productos pro , lineas l
                        where pro.codigo = l.producto
                        and l.numpedido = 1)

-- 19

SELECT l.numpedido, pro.*
FROM productos pro, lineas l
WHERE l.producto = pro.codigo
and precio = (select max(pro2.precio)
                        from productos pro2 , lineas l2
                        where pro2.codigo = l2.producto
                        and l2.numpedido = l.numpedido)
order by p.num;

-- 20

SELECT p.*
FROM pedidos p, clientes c
WHERE p.cliente = c.codigo
and p.total > (SELECT avg(total)
                    FROM pedidos
                    WHERE cliente = c.codigo)
order by p.num;
-- 21

select c.codigo, sum(total + NVL(gastos_envio,0))as IMPORTE_TOTAL
from clientes c, pedidos p
where c.codigo = p.cliente
and c.edad < 30
and p.fecha LIKE '%/23'
group by c.codigo;


-- 22

select num, cliente, total, NVL(gastos_envio, 0) as gastos_envio
from pedidos;

-- 23

select *
from productos
where precio = (select min(precio) from productos)
union
select *
from productos
where precio = (select max(precio) from productos);

-- 24

select p.num as "Nº Pedido",  
to_char(p.fecha, 'day: DD/Month/YYYY') as "Fecha pedido", 
c.apellidos || ', ' || c.nombre as "Nombre completo"
from clientes c, pedidos p
where c.codigo = p.cliente;

-- 25

select rpad(codigo,15,'-') as codigo_prod, nombre, lpad(precio,10,'-') as precio
from productos;
