<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarea 6 DWES</title>
    <script src="main.js"></script>
</head>

<body>

    <form method="POST" name="formulario">

        <label for="dni">Escribe tu DNI</label>
        <input type="text" name="dni" id="dni">
        <br> <br>
        <label for="nombre">Escribe tu Nombre</label>
        <input type="text" name="nombre" id="nombre">
        <br> <br>
        <label for="apellido1">Escribe tu primer apellido</label>
        <input type="text" name="apellido1" id="apellido1">
        <br> <br>
        <label for="apellido2">Escribe tu segundo apellido</label>
        <input type="text" name="apellido2" id="apellido2">
        <br> <br>
        <label for="edad">Escribe tu edad</label>
        <input type="text" name="edad" id="edad">
        <br> <br>
        <label for="pais"> Indica tu país </label>
        <select name="pais" id="pais">
            <option value="-1">Seleccione un pais</option>
        </select>
        <br> <br>
        <label for="provincia"> Indica tu provincia </label>
        <select name="provincia" id="provincia">

        </select>
        <br> <br>
        <label for="localidad"> Indica tu localidad </label>
        <select name="localidad" id="localidad">

        </select>

        <br> <br>
        <input type="submit" name="enviar" value="Insertar alumno" />

    </form>

</body>

</html>