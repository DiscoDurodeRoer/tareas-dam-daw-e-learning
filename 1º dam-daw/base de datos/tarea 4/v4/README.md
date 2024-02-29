# Tarea 4 base de datos 

Youtube: https://youtu.be/7qMYTJHUB3w

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Estas son las consultas que debes crear en SQL:

1. Número total de pedidos e importe de todos ellos, pero de los realizados en los últimos 60 días.

2. Número de pedido e importe de aquellos pedidos cuyo importe esté entre 100 y 200 €

3. Código y nombre de los productos ordenados ascendentemente por precio y nombre.

4. Clientes cuyo segundo apellido sea Perez

5. Número total de productos que vende la empresa (en la columna debe aparecer “Nº de productos”)

6. Número total de productos que no han sido pedidos

7. De cada pedido, mostrar su número, coste total y datos del cliente

8. Código, nombre del cliente y número total de pedidos que ha hecho cada cliente, ordenado de más a menos pedidos

9. Código, nombre del cliente y número total de pedidos que ha realizado cada cliente durante 2016

10. Código, nombre y número total de pedidos de los clientes que han realizado más de un pedido

11. Para cada pedido mostrar su número, código del cliente y nº total de líneas que tiene.

12. Código de cliente, nombre de producto y cantidad total que ha pedido cada cliente de cada producto

13. Para cada cliente mostrar su código, nombre , numero de pedido y coste total de cada uno de sus pedidos

14. Para cada cliente menor de edad mostrar su código y nombre, el importe más alto, el más bajo de los pedidos que ha realizado

15. Mostrar el código del producto, el nº de veces que ha sido pedido y la cantidad total de unidades que se han pedido (los que no hayan sido pedidos también deben ser mostrados con estos valores a 0) (combinación externa)

16. Datos del producto del que más unidades se han pedido

17. Datos del producto más caro del pedido 1

18. Datos del producto más caro de cada pedido (con una consulta correlacionada)

19. Código de cada cliente y cantidad total que se ha gastado en 2016

20. Cantidad total gastada y código de cliente de los que menos han gastado en 2016

21. Para cada cliente mostrar su código y la suma total de sus pedidos y gastos de envÍo

22. Número de pedido , importe y cliente de los pedidos que no tienen gastos de envío (debe aparecer un 0 en la columna de gastos de envío y
pon una etiqueta a ese campo)

23. Datos del pedido más caro y del más barato

24. Sentencia que muestre los productos con este formato
  
| CODIGO_PROD | NOMBRE | PRECIO |
|---|---|---|
| 10001--------------- | Pantalón | --------50 |
| 10002--------------- | Pantalón Campana | --------55 |
| 10003--------------- | Camisa M/L | --------65 |

25. Escribe los datos de los pedidos y su clientes con el siguiente formato:

| Nº Pedido | Fecha Pedido | Nombre Completo |
|---|---|---|
| 1 | jueves : 10/octubre /2015 | Garcia Perez, Luis |
| 2 | lunes : 10/febrero /2016 | Garcia Perez, Luis |
| 3 | jueves : 20/febrero /2016 | Garcia Perez, Luis |
| 4 | martes : 25/marzo /2016 | Lopez Garrido, Maria |
| 5 | martes : 25/marzo /2016 | Gamez Valiente, Javier |

26. (Solo con subconsultas, sin combinar tablas) Datos de los clientes que han pedido el producto de nombre ‘PANTALON’.

27. (Sin subconsultas) Datos de los clientes que han pedido el producto de nombre ‘PANTALON’.

28. Para cada cliente, mostrar los datos del pedido cuyo importe sea superior al importe l medio de sus pedidos

29. Lista de todos los pedidos mostrando también los días previstos de espera para el envío

30. Pedidos con el mínimo nº de días previsto de espera.
