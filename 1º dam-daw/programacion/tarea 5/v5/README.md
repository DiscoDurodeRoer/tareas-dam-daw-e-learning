# Tarea 5 programacion 

Youtube: https://youtu.be/o60HUzqvitU

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Se trata desarrollar una aplicación Java en consola que permita representar varias figuras geométricas. Al lanzarse la aplicación, el programa tendrá que solicitar el usuario los siguientes datos:

1. Tipo de figura. Sólo válidas “circunferencias”, “triángulos” y “rectángulo”.
2. Coordenadas., Toda coordenada tiene 2 valores, X e Y, en número enteros. La aplicación limitará las coordenadas a los puntos +5 tanto en el eje X cono en el eje Y. En función de la figura escogida, el programa dará distintas opciones:
• Para circunferencia, dos coordenadas: centro y punto exterior.
• Para triángulo, tres coordenadas: los tres vértices.
• Para rectángulo, dos coordenadas, vértice inferior izquierdo y vértice superior derecho.

Una vez diseñada la figura, mediante un menú se podrán realizar determinadas operaciones:
1. Ver el tipo de figura. El programa devolverá circunferencia, triángulo, rectángulo o cuadrado en función de las coordenadas. Un cuadrado es un rectángulo cuyos lados miden todos igual.
2. Calcular área.
3. Calcular perímetro.
4. Mover coordenada. La aplicación preguntará qué coordenadas se puede mover.
5. Convertir figura. Solo se podrán convertir figuras que compartan el número de coordenadas.
6. Ver lista de coordenadas.
7. Ver figuras en el plano. No se pueden ver en el plano las circunferencias ni triángulos. Esta operación mostrará el rectángulo con O, el centro con X y espacios en el resto de plano. Un rectángulo cuyos vértices estén en (-1, 1) y (0, 2) se verá así.
. . . . . . . . . . .
. . . . . . . . . . .
. . . . . . . . . . .
. . . .OO . . . .
. . . .OO . . . .
. . . . .X. . . . .
. . . . . . . . . . .
. . . . . . . . . . .
. . . . . . . . . . .
. . . . . . . . . . .
. . . . . . . . . . .
8. Salir de la aplicación.

El programa deberá asegurar que las coordenadas son válidas en función al tipo de figura:
• Para los triángulos, al menos dos coordenadas deben de no compartir un punto (x y Y), porque si no se definiría una recta.
• Para los rectángulos, ambas coordenadas deben de no compartir ningún punto, porque si no se definiría una recta.

Además del programa principal de la aplicación (clase con una función main), habrá que escribir una clase FiguraGeo que proporcione todas las herramientas necesarias para trabajar con este tipo de información

• Constructor (o constructores) adecuados.
• Almacenamiento del tipo de figura (atributos).
• Almacenamiento de las coordenadas (atributos).
• Movimiento de coordenadas (método de interfaz pública).
• Obtención de coordenadas (métodos de interfaz pública).
• Aquellas herramientas auxiliares para poder trabajar cómodamente con el objeto. Algunas de esas herramientas podrán ser públicas. Algunas podrán ser específicas de clase y otras podrán ser de objeto ( método de objeto privados, métodos estáticos públicos, etc.).

En general, deberías incluir excepciones para controlar aquellos casos en los que el uso de un método no sea posible (tipo de figura no existente, coordenadas no válidas, conversiones imposibles, puntos muy grandes, etc.).