# Tarea 2 base de datos 

Youtube: https://youtu.be/u8pKj3HiUds

Si te ha servido este repositorio, no te olvides de darle una estrella.

# Enunciado

La Biblioteca Universitaria de Ciudad Real desea llevar la gestión y control de todo lo referente a sus socios, libros y ejemplares de cada libro, prestamos, etc, etc… Para ello se debe tener en cuenta lo siguiente:
-  Respecto a los socios existen 3 tipos de socios que pueden solicitar libros y pueden tener distintos tiposdecarnet dependiendo de sus funciones y responsabilidades en la Universidad.
-  Cualquier socio se deberá dar de alta en el sistema con sus datos “típicos” (nombre, apellidos, dirección, localidad, provincia, CP. teléfonos, DNI),
-  El sistema adjudicará al socio un número de socio(numerodesocio) , almacenará la fechadealta en el sistema y emitirá un carnetdesocio para cada tipodecarnet solicitado, adjudicándole un nºdecarnet, fechacarnet y el tipodecarnet solicitado. De esta forma podremos encontramos socios que posean 3 carnets distintos con el mismo numerodesocio.
-  Un socio puede solicitar un tipodecarnet en cualquier momento.
-  Los 3 tipos de socios son: Profesorado, alumnado y personal (de la universidad).:
o Del Profesorado necesitamos conocer adicionalmente a qué facultad y departamento pertenece.
o Del alumnado en qué facultad y grado está matriculado,
o Del personal necesitamos conocer adicionalmente qué función/cargo desempeña.
-  Como es lógico suponer un Grado va a pertenecer a una Facultad en concreto.
-  Las facultades están dadas de alta mediante un código asignado y su nombre, debiendo conocer quién es el rector de cada facultad que deberá ser un profesor de esa facultad.
-  Los Grados tienen un código universitario establecido y deben estar predefinidos para que no puedan existir errores de introducción de datos (ejemplo: 001 ARQUITECTURA, 002 BIOLOGIA, …, 030 INFORMATICA, etc, etc.).
-  Existen varios tipos de carnet (con posibilidad impredecible de ampliación y o modificación) con las siguientes características:
a)  CARNET A: ESTANDAR, puede llevarse libros de la Biblioteca con plazo máximo de entrega de 1 día,
b) CARNET B: GRADO, puede llevarse libros de la Biblioteca con plazo máximo de entrega de 10 días,
c)  CARNET C: POSTGRADO, con plazo máximo de entrega de 30 días,
d) CARNET D: MASTER, con plazo máximo de entrega de 60 días,
e) CARNET E: INVESTIGACION, con plazo máximo de entrega de 90 días
-  En la biblioteca se encuentran, como es natural, una serie de libros que se solicitan a las editoriales.
-  Cuando se hace un pedido de libros a una editorial se debe indicar la fecha, qué socio del “personal” lo ha realizado pudiendo pedir varios libros y cantidades. La dirección a la que ha de dirigir el pedido se encuentra en el fichero de editoriales. Como es de suponer los precios de los libros pueden variar a lo largo del año.
-  Cuando un libro se recibe, se le da de alta en el sistema, construyéndole una ficha detallada con sus datos como: ISBN, titulo, fechapublicacion, editorial, precio y autor(es) ya que pueden ser varios. Automáticamente el sistema debe dar de alta cada uno de los ejemplares recibidos de ese libro adicionando al ISBN su número de ejemplar:
Ejemplo:
ISBN Nºejemplar
35891211 01
35891211 02
35891211 03
… …

-  Cuando un socio desea retirar un libro de la biblioteca ha de presentar el carnet correspondiente para que se tome nota de la retirada, pudiendo llevarse en ese préstamo hasta un máximo de 5 ejemplares siempre y cuando correspondan con el mismo tipodecarnet, es decir si un socio desea llevarse 2 libros con el carnet B y otro libro con el carnet C deberán ser 2 prestamos y no 1.
-  Hay libros en la Biblioteca que No se pueden prestar, solo pueden ser consultados en la Biblioteca. Queremos controlar cada préstamo que se realiza almacenando: el socio que lo solicita, el nºdecarnet con el que lo solicita, libro y ejemplar que solicita, la fecha en la que se realiza, la fecha tope para devolver (que va en función del tipo de carnet presentado) y la fecha real en la que se devuelve el libro, teniendo en cuenta que un socio se puede llevar hasta 5 libros en un préstamo pero la fecha real de devolución podría ser distinta para ellos. Hay que tener en cuenta que un socio podría llevarse varias veces el mismo libro/ejemplar, pero en distintas fechas.
Diariamente, a primera hora un proceso nos debe informar de los ejemplares que están en préstamo.

A partir de la anterior Especificación de Requisitos (ERS):

Apartado 1.- Obtener el esquema conceptual asociado al problema planteado, realizando el diagrama Entidad/Relación -Extendido de forma que capture los requisitos detallados en los puntos anteriores:
i. ENTIDADES con sus atributos relevantes (solo serán evaluables los realmente “relevantes”)
ii. RELACIONES.
iii. Especifica si existen algunas RELACIONES y/o DATOS REDUNDANTES (calculados/derivados) que se podrían obviar, mejorar y omitir, DETALLANDO el POR QUÉ. Las relaciones y/o atributos redundantes innecesarios restarán puntuación.

Puedes utilizar la notación/simbología adecuada vista a lo largo de la unidad. (3puntos)

Apartado 2.- Partiendo del esquema conceptual obtenido en el apartado anterior, explica qué cambios previos al paso a modelo relacional se deberían realizar (si lo prefieres puedes modificar el esquema conceptual aplicando esos cambios previos). (2puntos)

Apartado 3.- Transforma el esquema conceptual anterior a modelo Relacional: detalla las tablas, atributos, características de los atributos, claves primarias y claves ajenas generadas para representar las relaciones y añade cualquier requisito no representado en el esquema relacional. (3 puntos)

Apartado 4.- Aplica el proceso de Normalización a las tablas obtenidas hasta Tercera Forma Normal, explicando el proceso realizado (qué tabla no cumple cada Forma Normal, por qué y tablas normalizadas, desde 1FN hasta 3FN). (2 puntos)