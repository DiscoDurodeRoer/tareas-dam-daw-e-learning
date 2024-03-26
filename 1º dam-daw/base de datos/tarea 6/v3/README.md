# Tarea 6 base de datos 

Youtube: https://youtu.be/-yMlmz_VSkY

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Para la realización de la tarea de esta unidad nos basaremos en la base de datos creada para las tareas de las unidades 4 y 5. La tarea que te pedimos que realices consta de 2 actividades: 

- Actividad 1.

Queremos crear los siguientes subprogramas:

1. Función que compruebe si existe un pedido con el número que se le pase. Devolverá verdadero o falso.

2. Función que devuelve todos los datos de un pedido a partir de su número (toda la fila de la tabla pedidos)

3. Procedimiento que devuelve los datos de un cliente a partir del código de cliente

4. Procedimiento que muestra un listado con las líneas de un pedido ( a partir de su número), de la siguiente manera: Nº Línea NombreProducto 

Precio Cantidad Importe
::::::::: :::::::::::::::::::::: ::::: ::::::: :::::::
......... ...................... ...... ...... ......

5. Procedimiento o bloque anónimo que a partir de un número de pedido, si existe, nos muestre todos los datos del pedido, del cliente y el listado de todas las líneas que tiene, utilizando los subprogramas anteriores.

6. Deben tratarse las excepciones oportunas en cada uno de los subprogramas (si no existe el pedido, o no tiene líneas,….).

- Actividad 2.

Queremos controlar algunas restricciones mediante triggers: (debes crear dos disparadores, uno para cada ejercicio):

1. Cada vez que se vaya a insertar o modificar una línea de un pedido debe de actualizarse correctamente el importe de la misma (cantidad X precio del producto).

2. Cada vez que se inserten, se borren o modifiquen líneas hay que actualizar el importe del pedido correspondiente