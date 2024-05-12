# Examen 1 programacion 

Youtube: https://youtu.be/w593t7mFSX8

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

El examen consiste en diseñar un programa con una serie de clases, Está planteado para que se pueda aplicar a una ventana, a una aplicación de consola, a una aplicación web, etc. No hay elementos de entrada de datos (p.e. Scanner), ni método main(). Solo se propone crear una nueva clase con método main() en el último apartado para que podáis comprobar el funcionamiento de vuestro programa. Crear un proyecto llamado "Ex2-nombreAlumno".

Las clases deben estar siempre en paquetes.

Diseñar un programa para gestionar un festival de música. Se debe gestionar los participantes (artista o asistente) y los conciertos. Para ello debemos diseñar una serie de clases sin método main() que definen el comportamiento del programa. Finalmente se solicitará mostrar el uso del programa en una clase con método main().

Requisitos principales: Crear las clases necesarias para desarrollar el programa. Añadiremos los métodos y constructores que consideremos oportunos.

Los participantes del festival son únicamente artistas y asistentes, los cuales tienen algunas características en común. Diseñar una herencia para estos dos elementos:

(0,2) Los asistentes tienen un código, nombre, dni y fecha de nacimiento.

(0,2) Los artistas tienen un código, nombre, numero de integrantes, estilo de música, y caché (precio).

(0,4) Los conciertos tienen un nombre, una fecha, un artista, un estilo de música, y una lista de asistentes.

(1,2 pto) En nuestra clase principal "Gestion Conciertos" hay únicamente dos estructuras de datos: una para almacenar los conciertos y otra para almacenar tanto los artistas como los asistentes.

Otros requisitos: Además, la clase Gestion Conciertos tiene una serie de operaciones (métodos en su mayoría) para gestionar los conciertos, los artistas y los asistentes. Se pueden crear todos los métodos que el alumno considere necesarios, aparte de los siguientes. *Tener métodos para buscar artistas, asistentes o conciertos facilitará las cosas.

(0,5) La lista que contiene los conciertos está en todo momento ordenada por la fecha.

(0,5) La lista que contiene a los participantes (artistas y asistentes) está siempre ordenada por código.

(0,75) Permite listar solo a los asistentes, solo a los artistas, y listar los conciertos.

(0,75) Crear los métodos para permitir dar de alta asistentes y dar de alta artistas, dando valor a todos los atributos de cada uno. Recordad que ambos se almacenan en la misma estructura de datos.

(1,25) Dar de alta un concierto añadiéndolo a la lista correspondiente. Se da de alta a partir de los siguientes datos: nombre, fecha, codigoArtista y estilo de música. Para que el método permita almacenar un nuevo concierto en la lista se debe comprobar que el código de Artista corresponde con un artista registrado, y que el estilo de música del concierto, corresponde con el estilo de música del artista. Solo en ese caso se añade el concierto a la lista. 015

(0,5) Permite listar los conciertos de un estilo concreto de música pasado por parámetro.

(0,5) Permite listar los conciertos realizados por un artista concreto. Recibe el código de artista

(0,75) Permite añadir un asistente a un concierto. Recibe el nombre de concierto y el código de asistente. Si el concierto o el asistente no existe, no hace nada.

(0,75) Permite mostrar la cantidad de conciertos a los que ha asistido un asistente. Recibe código de asistente.

(0,5) Una operación permite guardar conciertos y asistentes en fichero.
