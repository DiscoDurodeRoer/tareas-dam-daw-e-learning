<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tarea DWES 3 Buscar</title>
</head>

<body>

    <?php
    
        if(isset($_POST['buscar'])){

            $nombre = $_POST['nombre'];
            $apellidos1 = $_POST['apellidos1'];
            $apellidos2 = $_POST['apellidos2'];
            $min_edad = $_POST['min_edad'];
            $max_edad = $_POST['max_edad'];

            $sql = "SELECT * FROM alumnos WHERE 1 ";

            if(!empty($nombre)){
                $sql .= "and lower(Nombre) LIKE '%". strtolower($nombre) ."%' ";
            }

            if(!empty($apellidos1)){
                $sql .= "and lower(Apellido1) LIKE '%". strtolower($apellidos1) ."%' ";
            }

            if(!empty($apellidos2)){
                $sql .= "and lower(Apellido2) LIKE '%". strtolower($apellidos2) ."%' ";
            }

            if(!empty($min_edad)){
                $sql .= "and Edad >= ". $min_edad . " ";
            }

            if(!empty($max_edad)){
                $sql .= "and Edad <= ". $max_edad. " ";
            }

            require_once 'conexion.php';

            $resultados = mysqli_query($conexion, $sql);

            if(mysqli_num_rows($resultados) == 0){
                ?>
                    <p>No hay resultados</p>
                <?php
            }else{
                ?>
                <table>
                    <tr>
                        <th>DNI</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO1</th>
                        <th>APELLIDO2</th>
                        <th>EDAD</th>
                    </tr>
                    <?php
                    while($fila = mysqli_fetch_assoc($resultados)){
                        echo "<tr>";
                        echo "<td>".$fila['Dni']."</td>";
                        echo "<td>".$fila['Nombre']."</td>";
                        echo "<td>".$fila['Apellido1']."</td>";
                        echo "<td>".$fila['Apellido2']."</td>";
                        echo "<td>".$fila['Edad']."</td>";
                        echo "</tr>";
                    }
                    
                    ?>
                </table>
                <?php
            }

        }
    
    ?>


    <form method="POST">

        <label for="nombre">Nombre</label>
        <input type="text" maxlength="30" name="nombre" id="nombre">
        
        <label for="apellidos1">Apellidos1</label>
        <input type="text" maxlength="30" name="apellidos1" id="apellidos1">
        
        <label for="apellidos2">Apellidos2</label>
        <input type="text" maxlength="30" name="apellidos2" id="apellidos2">
        
        <label for="min_edad">Min edad</label>
        <input type="number" maxlength="3" name="min_edad" id="min_edad"> 

        <label for="max_edad">Max edad</label>
        <input type="number" maxlength="3" name="max_edad" id="max_edad"> 

        <input type="submit" name="buscar" value="Buscar">

    </form>

    <a href="index.php">Volver</a>

</body>

</html>