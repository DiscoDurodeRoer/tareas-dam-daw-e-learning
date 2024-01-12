# Tarea 5 programacion 

Youtube: https://youtu.be/N6igvGiRREc

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Se trata de desarrollar una aplicación Java denominado PROG05_Tarea que permita gestionar un vehículo. Mediante un menú que aparecerá en pantalla se podrán realizar determinas operaciones:
1. Nuevo Vehículo.
2. Ver datos identificativos
3. Ver estado del vehículo
4. Viajar
5. Repostar
6. Llenar depósito.
7. Actualizar precio combustible.
8. Mostrar antigüedad.
9. Mostrar propietario.
10. Salir.
La funcionalidad será la siguiente:
    - Al iniciar la aplicación se mostrará el menú propuesto.
    - Dependiendo de la opción seleccionada por el usuario:
        - Nuevo Vehículo: Se creará un nuevo Vehículo, si los datos introducidos por el usuario son correctos, que contendrá la siguiente información (marca, modelo, matrícula, número de kilómetros, fecha de matriculación, capacidad de depósito, descripción, precio, nombre del propietario, dni del propietario). Al crear un nuevo vehículo se hará con el depósito vacío. Todos los datos serán solicitados por teclado y tan solo habrá que comprobar:
        - Que la fecha de matriculación es anterior a la actual: puedes solicitar por separado día, mes y año y construir un objeto LocalDate (tienes una referencia en el apartado Consejos y recomendaciones).
        - Que el número de kilómetros es mayor o igual que 0.
        - Que el DNI del propietario es correcto.
        - Que la capacidad de depósito es un número positivo y menor que 100.
        - Que la marca, modelo y matrícula no se han dejado en blanco.
        - Que el consumo medio del vehículo (expresado en litros de combustible por cada 100 km) es positivo e inferior a 20.
        - Si no se cumple algunas de las condiciones se deberá mostrar el correspondiente mensaje de error. En ese caso habrá se mostrará de nuevo el menú principal.
        - Datos identificativos: Devolverá una cadena con la marca, modelo, matrícula y precio del vehículo.
        - Estado del vehículo: Devolverá una cadena con el número de kilómetros, así como el contenido actual del depósito.
        - Viajar: Se deberá comprobar si hay combustible suficiente para viajar los kilómetros solicitados, en caso contrario solo permitirá viajar hasta dejar el depósito a cero. Deberá actualizar el número de kilómetros del vehículo con los kilómetros efectivamente realizados (pueden ser menos de los solicitados) y restar del estado del depósito los litros consumidos en el viaje. Habrá que tener en cuenta que solo se podrán sumar kilómetros. Devolverá una cadena informando de los Km realmente realizados y de cómo queda el cuenta kilómetros tras el viaje.
        - Repostar. Se deben incrementar al contenido del depósito los litros que se pide repostar, pero teniendo en cuenta que no se podrá sobrepasar la capacidad máxima del depósito. Es decir, si el coche tiene 50 l de capacidad y actualmente 20 l en el depósito, si se pide repostar 40 l solo se podrán incrementar 30 l más (50 que caben menos 20 que hay antes). El método devolverá como cadena el importe de la operación (litros realmente repostados por el precio del combustible).
        - Llenar. Es similar a repostar, pero en este caso no se indican los litros ya que se trata de incrementar los litros que quepan hasta la capacidad máxima. Se puede hacer uso del método anterior o implementarlo completamente de nuevo. Como Repostar (…) también debe devolver una cadena con el importe de los litros repostados.
        - Actualizar precio combustible. Debe permitir cambiar el dato precio_combustible. Hay que tener en cuenta que el precio de combustible puede tener decimales y que es el mismo para todos, por lo que la clase deberá contemplar este dato compartido para todos los objetos de la clase coche, sin almacenar una copia de este valor para cada coche.
        - Mostrar antigüedad: devolverá en una cadena un mensaje informando del número de años del vehículo desde que se matriculó, no la fecha de matriculación.
        - Mostrar propietario: Devolverá el nombre del propietario del vehículo junto a su dni.
        - Salir: El programa finalizará.

El proyecto de Netbeans constará de dos paquetes, donde se crearán las clases oportunas:
- PROG05_Ejerc1: que contendrá la clase Vehículo y la clase Principal.
- PROG05_Ejerc1_util: contendrá una clase con un métodos estáticos para realizar validaciones.

La clase Vehículo dispondrá de los siguientes métodos:
- Constructor o constructores.
- Métodos get y set para acceder a sus propiedades.
- Método get_Anios(): Retorna un entero con el número de años del vehículo.
- Método mostrarDatosIdentificativos()
- Método mostrarEstadoVehiculo()
- Método viajar(km)
- Método respotar(litros)
- Método llenar()
- Método actualizarPrecio(nuevoPrecio)

TEN EN CUENTA
- En la clase vehículo no debe solicitar datos por teclado ni escribir datos en pantalla. Esas operaciones se realizarán en la clase Principal. Piensa por tanto en los tipos de datos que deben retornar los métodos para que el programa de la clase Principal pueda mostrar la información que se pide.
- En la clase Vehículo no se deben hacer validaciones de datos. Los datos se validan en la clase Principal y si son correcto, se instancia el objeto Vehículo.
- Debes incluir una excepción para la validación del DNI. Es decir, cuando no sea válido, se lanzará una excepción que se gestionará en la clase Principal, desde donde se mostrará el correspondiente mensaje de error.
- La aplicación solo trabajará con un vehículo, por lo tanto, solo utilizará una referencia a un objeto de tipo Vehículo en la clase Principal. Si existe un vehículo y el usuario selecciona Nuevo Vehículo en el menú, se perderá la información del vehículo existente y se guardará la del nuevo.
- No será necesario realizar comprobaciones de tipo en los datos solicitados por teclado.
- No se podrán mostrar datos de un vehículo si aún no se ha creado, y obviamente ninguna de las operaciones que cambian su estado (viajar, repostar, etc.): en ese caso habrá que mostrar un mensaje por pantalla. 