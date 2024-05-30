
# Tarea 11 programacion 

Youtube: https://youtu.be/8F-Lx0SHoJU

Si te ha servido este repositorio, no te olvides de darle una estre
lla.

## Enunciado

En esta última unidad vamos a implementar una aplicación simple que utilice una conexión con una base de datos relacional, existente en un servidor MySQL (o MariaDB). 

La base de datos, de nombre constructora, contendrá las tablas proyectos(id int primary key, nombre varchar(100)) y fases (id int primary key auto_increment, descripcion varchar(100), presupuesto int, idProyecto int references proyectos(id)). 

Utilizando un cliente diferente a nuestra aplicación, se insertarán datos en ambas tablas que puedan servir para realizar pruebas. 

Se quiere que la aplicaclón tenga una interfaz gráfica que permita ver todos los proyectos con sus fases y modificar el presupuesto de una de las fases de alguno de los proyectos existentes. 

Se podrá eliminar un proyecto y, en cascada, todas las fases relacionadas con él. 
Se podrá añadir cualquier funcionalidad adicional que considere oportuna, siempre y cuando suponga añadir funciones a las mínimas propuestas.