# Tarea 5 base de datos 

Youtube: https://youtu.be/cl5UuZKDz7k

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

1. Inserta un nuevo cliente y un pedido para este cliente (sin gastos de envío y total con valor 0 de momento) 

2. Inserta al menos 2 líneas al pedido anterior (cuidado al introducir los datos de los atributos que son calculados a partir de otros datos que se tienen) 

Ejemplo: 

| NUM | NUM_PEDIDO | PRODUCTO | CANTIDAD | IMPORTE |
|---|---|---|---|---|
| 1 | el ultimo introducido | 1001 | 3 | el que corresponda |
| siguiente | el ultimo introducido | 1002 | 2 | el que corresponda |

3. Modifica el último pedido introducido para que el importe total tenga el valor que corresponda según los importes de sus líneas. 

4. Haz un SELECT que muestre los datos de pedido anterior y de sus líneas. Copia aquí el resultado de la consulta. Si todo está bien
confirma definitivamente los cambios realizados, si no, repítelos y confírmalos cuando esté todo bien. 

5. Hay que retrasar 30 días las fechas previstas de entrega de los pedidos realizados en marzo de 2024 que incluyan el producto HDD Z 

6. A todos los pedidos realizados en 2024, que no tengan gastos de envío, se les pondrá 15€ de gastos de envío si su importe total no supera los 100€. 

7. Hay que bajar un 20% el precio de todos los productos que no se hayan pedido nunca. 

8. Detalla qué cambios se desharían si ahora ejecutamos ROLLBACK. 

9. Crea una tabla (PRODUCTOS_BORRADOS) donde se van a ir guardando los productos que se borren de la tabla PRODUCTOS, debe incluir los datos del producto y la fecha en la que se han borrado. 

10. Borra los productos que no hayan sido pedidos nunca. Recuerda que debes guardarlos en la tabla creada en el ejercicio anterior. ¿Cuántos se han borrado?. Explica si afecta, o no, esta acción a otras tablas y por qué.

11. La clienta Mª PILAR PEREZ BERMEJO nos ha pedido darla de baja. Explica qué ocurre y por qué. 

12. Ejecuta y justifica las acciones necesarias para borrar al cliente insertado en el ejercicio 1. 

13. Modifica la cantidad del producto de la línea 1 del pedido 10, y realiza las actualizaciones necesarias para que los datos del pedido sean correctos teniendo en cuenta la modificación realizada.

14. Modifica el producto HDD Y. Explica a qué tablas afecta, en qué, y por qué.
