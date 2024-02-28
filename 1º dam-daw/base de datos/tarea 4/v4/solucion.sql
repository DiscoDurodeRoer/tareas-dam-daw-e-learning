-- 1 

select count(*), sum(total + nvl(gastos_envio, 0)) as total
from pedidos 
where fecha BETWEEN SYSDATE - 60 AND SYSDATE;

-- 2 

Select num, total + nvl(gastos_envio, 0) as importe
from pedidos
where total + nvl(gastos_envio, 0) between 100 and 200

-- 3

select codigo, nombre
from productos 
order by precio, nombre;

-- 4

select *
from clientes
where upper(apellidos) LIKE '%PEREZ' COLLATE binary_ai;

-- 5

select count(*) as "Nº productos"
from productos;

-- 6

select count(*) as "Nº productos"
from productos
WHERE codigo not in (select producto from lineas);

-- 7

select p.num as "Nº pedido", c.*
from pedidos p, clientes c
where p.cliente = c.codigo

-- 8

select c.codigo, c.nombre, count(p.num) as "Nº pedidos"
from pedidos p, clientes c
where p.cliente = c.codigo
group by c.codigo, c.nombre;

-- 9

-- v1

select c.codigo, c.nombre, count(p.num) as "Nº pedidos"
from pedidos p, clientes c
where p.cliente = c.codigo
AND p.fecha LIKE '%-16'
group by c.codigo, c.nombre;

-- v2

select c.codigo, c.nombre, count(*) as "Nº pedidos"
from pedidos p, clientes c
where p.cliente = c.codigo
and EXTRACT(YEAR from p.fecha) = 2016
group by c.codigo, c.nombre;

-- 10

select c.codigo, c.nombre, count(p.num) as "Nº pedidos"
from pedidos p, clientes c
where p.cliente = c.codigo
group by c.codigo, c.nombre
having count(p.num) > 1;

-- 11

select p.num, p.cliente, count(l.num) as "Nº Lineas"
from pedidos p, lineas l
WHERE p.num = l.num_pedido
group by p.num, p.cliente;

-- 12

SELECT p.cliente as Cliente, pro.nombre as Producto, count(l.producto) as "Veces pedido"
from productos pro, pedidos p, lineas l
WHERE p.num = l.num_pedido and pro.codigo = l.producto
group by p.cliente, pro.nombre
order by p.cliente, pro.nombre;

-- 13

select c.codigo, c.nombre, p.num, p.total as "Total pedidos"
from clientes c, pedidos p
WHERE c.codigo = p.cliente
order by c.codigo, c.nombre, p.num;

-- 14

select c.codigo, c.nombre, min(p.total) as "Pedido minimo", max(p.total) as "Pedido maximo"
from clientes c, pedidos p
WHERE c.codigo = p.cliente
and c.edad < 18
group by c.codigo, c.nombre;

-- 15

select pro.codigo, count(*) as "Veces pedidos", nvl(sum(l.cantidad), 0) as "Unidades pedidas"
from productos pro left join lineas l on pro.codigo = l.producto
group by pro.codigo;

-- 16

select pro.codigo, pro.nombre, pro.precio
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
    		   ) 

-- 17

select pro.codigo, pro.nombre, pro.precio
from (select pro.codigo, pro.precio
from productos pro , lineas l
where pro.codigo = l.producto
and l.num_pedido = 1001) t,
productos pro
where t.codigo = pro.codigo
and t.precio = (select max(t2.precio) 
    				from (select pro.codigo, pro.precio
                            from productos pro , lineas l
                            where pro.codigo = l.producto
                            and l.num_pedido = 1001) t2
    					  );

-- 18

select t.codigo, t.nombre, t.num_pedido, t.precio
from (select pro.codigo, pro.nombre, l.num_pedido, pro.precio
from productos pro , lineas l
where pro.codigo = l.producto) t
where t.precio = (select max(t2.precio) 
    				from (select pro.codigo, pro.precio
                            from productos pro , lineas l
                            where pro.codigo = l.producto
                            and l.num_pedido = t.num_pedido) t2
    					  )
order by t.num_pedido;

-- 19

select c.codigo, sum(p.total) as Total
from clientes c, pedidos p
where c.codigo = p.cliente
    and p.fecha LIKE '%-16'
group by c.codigo;

-- 20

select t.codigo, t.total
from (select c.codigo, sum(p.total) as total
from clientes c, pedidos p
where c.codigo = p.cliente
    and p.fecha LIKE '%-16'
group by c.codigo) t
where t.total = (select min(t2.total) 
    				from (select c.codigo, sum(p.total) as total
                                       from clientes c, pedidos p
                                       where c.codigo = p.cliente
                                           and p.fecha LIKE '%-16'
                                       group by c.codigo) t2
    		 );

-- 21

select c.codigo, sum(p.total) + sum(nvl(p.gastos_envio,0)) as Total
from clientes c, pedidos p
where c.codigo = p.cliente
group by c.codigo;

-- 22

select p.num, p.total, c.codigo
from clientes c, pedidos p
where c.codigo = p.cliente
    and nvl(p.gastos_envio) = 0;

-- 23

select *
from pedidos
where total = (select min(total) from pedidos)
union
select *
from pedidos
where total = (select max(total) from pedidos);

-- 24

select rpad(codigo,15,'-') as codigo_prod, nombre, lpad(precio,15,'-')
from productos;

-- 25

select p.num as "Nº Pedido",  TO_CHAR(p.fecha, 'fmDAY') || ':' || to_date(p.fecha, 'DD / Month /YYYY') as "Fecha pedido", c.apellidos || ', ' || c.nombre as "Nombre completo"
from clientes c, pedidos p
where c.codigo = p.cliente;

-- 26

select *
from clientes
where codigo IN (select cliente
    			from pedidos
                where num IN (select num_pedido
    							from lineas
    							where producto = (select codigo
    												from productos
    												where upper(nombre) = 'PANTALÓN')
                            )
    		   );

-- 27

select c.*
from clientes c, pedidos p, lineas l, productos pro
where c.codigo = p.cliente
    and l.num_pedido = p.num
    and pro.codigo = l.producto
    and upper(pro.nombre) = 'PANTALÓN';

-- 28

select p.*
from clientes c, pedidos p
where c.codigo = p.cliente
and p.total > (select avg(total) from pedidos where cliente = c.codigo);


-- 29

select p.*, fecha_prevista - fecha as "dias previstos"
from pedidos p;

-- 30

select p.*, (fecha_prevista - fecha) as "dias previstos" 
from pedidos p
where (fecha_prevista - fecha) = (select min(fecha_prevista - fecha) from pedidos);
