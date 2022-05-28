<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tarea DWES 3 Alta</title>
</head>

<body>

    <?php
    
        if(isset($_POST['guardar'])){

            $dni = $_POST['dni'];

            require_once 'conexion.php';

            $sql = "SELECT * FROM alumnos WHERE Dni = '". $dni ."'";

            $resultados = mysqli_query($conexion, $sql);

            if(mysqli_num_rows($resultados) > 0){
                $mensaje = "El DNI introducido ya existe";
            }else{

                $nombre = $_POST['nombre'];
                $apellidos1 = $_POST['apellidos1'];
                $apellidos2 = $_POST['apellidos2'];
                $edad = $_POST['edad'];

                $sql = "INSERT INTO alumnos VALUES (";
                $sql .= "'".$dni."',";
                $sql .= "'".$nombre."',";
                $sql .= "'".$apellidos1."',";
                $sql .= "'".$apellidos2."',";
                $sql .= $edad;
                $sql .= ")";

                if(mysqli_query($conexion, $sql)){
                    $mensaje = "Se ha insertado con exito";
                }else{
                    $mensaje = "No se ha insertado con exito";
                }

            }

        }    
        
        if(isset($mensaje)){
            ?>
                <p><?php echo $mensaje; ?></p>
            <?php
        }



    ?>

    <form method="POST">

        <label for="dni">DNI</label>
        <input type="text" required maxlength="9"  name="dni" id="dni">
        
        <label for="nombre">Nombre</label>
        <input type="text" required maxlength="30" name="nombre" id="nombre">
        
        <label for="apellidos1">Apellidos1</label>
        <input type="text" required maxlength="30" name="apellidos1" id="apellidos1">
        
        <label for="apellidos2">Apellidos2</label>
        <input type="text" required maxlength="30" name="apellidos2" id="apellidos2">
        
        <label for="edad">Edad</label>
        <input type="number" required maxlength="3" name="edad" id="edad">

        <input type="submit" name="guardar" value="Guardar">

    </form>

    <a href="index.php">Volver</a>

</body>

</html>