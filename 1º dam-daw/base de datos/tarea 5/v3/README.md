# Tarea 5 base de datos 

Youtube: 

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

1. Insertar en la tabla jornadas dos nuevos registros (jornadas 7 y 8) , a celebrarse el 28 de marzo de 2015 y el 5 de abril de 2015 respectivamente, ambas en la localidad de Plasencia y en horario de Tarde.

| IDJORNADA | LOCALIDAD | HORARIO | FECHA |
|---|---|---|---|
| 7 | Plasencia | T | 28 de Marzo de 2015 |
| 8 | Plasencia | T | 5 de Abrik de 2015 |

2. Modificar la tabla jornadas añadiendo un nuevo campo denominado “Provincia”, que solo podrá tener valores ‘BA’ o ‘CC’. Posteriormente realizar las operaciones necesarias para almacenar la provincia según la localidad que tenga asignada cada jornada. 

3. Insertar un nuevo campo en la tabla de jugadores denominado “enc_ganados” y actualizarlo de manera automática con el número de encuentros que haya ganado cada uno de los jugadores. (Se considera un encuentro ganado si el valor del campo puntos es igual a 1) 

4. Crear una nueva tabla denominada JUGADORES_PENOSOS que contenga aquellos jugadores que habiendo disputado algún encuentro, hayan conseguido una suma total de puntos menor de 2. (La nueva tabla estará formada solo con los campos idjugador,apellidos, nombre e idequipo, el resto de los campos no). (Pista: La nueva tabla obtenida tendrá 11 registros). 

5. Actualizar el nombre y los apellidos de todos los jugadores titulados de segunda división, de manera que aparezcan ambos campos en mayúsculas. (Se entiende como jugador titulado aquel que tiene contenido en el campo titulo. Para obtener la división correspondiente a su equipo habrá que relacionar las tablas jugadores y equipos, no siendo válido incorporar directamente una condición sobre el campo idequipo). (Pista: Se actualizarán 8 filas). 

6. Borrar de la tabla jugadores aquellos que no hayan disputado ningún encuentro. (Pista: la sentencia de borrado afectará a 32 registros de la tabla jugadores, quedando por tanto 48 registros en dicha tabla después de ejecutada).

7. Crear una transacción que contenga las siguientes acciones (si lo realizáis desde el APEX [Oracle Application Express] desmarcar la casilla “Autocommit” que aparece en la parte superior izquierda de la pantalla “SQL Commands”): 

a. Seleccionar de la tabla equipos aquellos que no hayan disputado ningún encuentro. 

b. Borrar de la tabla equipos aquellos que no hayan disputado ningún encuentro. 

c. Visualizar la tabla equipos ordenada por idequipo y nombre (para comprobar que se han borrado algunos registros). 

d. Deshacer los cambios efectuados hasta ahora. 

e. Visualizar la tabla equipos ordenada por idequipo y nombre (para comprobar que los registros afectados por la transación que hemos deshecho no se han borrado). 

f. En caso de que hubíesemos decidido hacer permanentes los cambios producidos en la transación, ¿que sentencia tendríamos que haber ejecutado y en que apartado de los anteriores?. 

8. Crear tres nuevos campos en la tabla Equipos a los que llamaremos “Enc_Ganados”, “Enc_Empatados” y “Enc_Perdidos” y almacenar en ellos la información obtenida de los encuentros disputados. (En base a la tabla encuentros y teniendo en cuenta que el encuentro está ganado si los puntos obtenidos es igual a 3, se empata si los puntos obtenidos son 2 y se pierde si los puntos obtenidos es igual a 1). En “Enc_Ganados”, “Enc_Empatados” y “Enc_Perdidos” se almacenará el número de encuentros correspondientes para cada uno de los equipos. Se aconseja asignarles un valor por defecto de 0 al crear estos campos. Comprobación: Salida de la tabla una vez creados y actualizados los campos: (Ordenado por idequipo)

| IDEQUIPO | NOMBREEQUIPO | ENC_GANADOS | ENC_EMPATADOS | ENC_PERDIDOS |
|---|---|---|---|---|
| 1 | Pacense | 2 | 0 | 3 |
| 2 | Don Benito | 1 | 2 | 2 |
| 3 | Moralo | 2 | 2 | 1 |
| 4 | Magic | 1 | 3 | 1 |
| 5 | Caceres | 1 | 1 | 3 |
| 6 | Placentino | 3 | 2 | 0 |
| 7 | Zafra | 2 | 0 | 3 |
| 8 | Coria | 2 | 2 | 1 |
| 9 | PuertaPalma | 0 | 3 | 2 |
| 10 | Ateneo | 3 | 1 | 1 |
| 11 | Castuera | 1 | 2 | 2 |
| 12 | Olivenza | 2 | 2 | 1 |

9. Escribir una sentencia que nos permita borrar los tres campos “Enc_Ganados”, “Enc_Empatados” y “Enc_Perdidos” creados anteriormente en la tabla equipos. (Realizar la operación con una sola sentencia que afecte a los tres campos).
