<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarea 5</title>
</head>

<body>
    <?php
    require_once "Alumno.php";
    require_once "conexion.php";
    require_once "DaoAlumno.php";
    $dao = new DaoAlumno($db);

    if (isset($_POST['insertar'])) {

        $Dni = $_POST['Dni'];
        $nombre = $_POST['nombre'];
        $apellido1 = $_POST['apellido1'];
        $apellido2 = $_POST['apellido2'];
        $edad = $_POST['edad'];

        $alumno = new Alumno(
            $Dni,
            $nombre,
            $apellido1,
            $apellido2,
            $edad
        );
        $dao->insertar($alumno);
        echo "Insertado correctamente";
    } else if (isset($_POST['actualizar'])) {


        if (isset($_POST['Dnis'])) {

            $Dnis = $_POST['Dnis'];
            foreach ($Dnis as $key => $dni) {
                $nombre = $_POST[$dni . '_nombre'];
                $apellido1 = $_POST[$dni . '_apellido1'];
                $apellido2 = $_POST[$dni . '_apellido2'];
                $edad = $_POST[$dni . '_edad'];

                $alumno = new Alumno(
                    $dni,
                    $nombre,
                    $apellido1,
                    $apellido2,
                    $edad
                );
                $dao->actualizar($alumno);
            }

            echo "Actualizado correctamente";
        } else {
            echo "Debes seleccionar algun alumno";
        }
    } else if (isset($_POST['borrar'])) {

        if (isset($_POST['Dnis'])) {

            $Dnis = $_POST['Dnis'];
            $dao->borrar($Dnis);
            echo "Se han eliminado correctamente";
        } else {
            echo "Debes seleccionar algun alumno";
        }
    } else if (isset($_POST['buscar'])) {
        $Dni = $_POST['Dni'];

        if (!empty($Dni)) {
            $alumnoBuscado = $dao->buscar($Dni);

            if (is_null($alumnoBuscado)) {
                echo "No existe ese alumno";
            }
        } else {
            echo "El dni esta vacio";
        }
    }



    $alumnos = $dao->listar();
    ?>


    <form method="POST">
        <table>
            <tr>
                <th></th>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Apellido1</th>
                <th>Apellido2</th>
                <th>Edad</th>
            </tr>
            <?php
            foreach ($alumnos as $key => $alumno) {
                echo "<tr>";

                echo "<td>";
                echo "<input type='checkbox' name='Dnis[]' value='" . $alumno->Dni . "' />";
                echo "</td>";

                echo "<td>";
                echo $alumno->Dni;
                echo "</td>";

                echo "<td>";
                echo "<input type='text' name='" . $alumno->Dni . "_nombre' value='" . $alumno->Nombre . "' />";
                echo "</td>";

                echo "<td>";
                echo "<input type='text' name='" . $alumno->Dni . "_apellido1' value='" . $alumno->Apellido1 . "' />";
                echo "</td>";

                echo "<td>";
                echo "<input type='text' name='" . $alumno->Dni . "_apellido2' value='" . $alumno->Apellido2 . "' />";
                echo "</td>";

                echo "<td>";
                echo "<input type='text' name='" . $alumno->Dni . "_edad' value='" . $alumno->Edad . "' />";
                echo "</td>";

                echo "</tr>";
            }


            ?>
            <tr>
                <td></td>
                <td>
                    <input type="text" name="Dni" value="<?php if(isset($alumnoBuscado)) { echo $alumnoBuscado->Dni;}?>"/>
                </td>

                <td>
                    <input type="text" name="nombre" value="<?php if(isset($alumnoBuscado)) { echo $alumnoBuscado->Nombre;}?>"/>
                </td>
                <td>
                    <input type="text" name="apellido1" value="<?php if(isset($alumnoBuscado)) { echo $alumnoBuscado->Apellido1;}?>"/>
                </td>
                <td>
                    <input type="text" name="apellido2" value="<?php if(isset($alumnoBuscado)) { echo $alumnoBuscado->Apellido2;}?>"/>
                </td>
                <td>
                    <input type="text" name="edad" value="<?php if(isset($alumnoBuscado)) { echo $alumnoBuscado->Edad;}?>"/>
                </td>
            </tr>
        </table>

        <input type="submit" name="borrar" value="Borrar" />
        <input type="submit" name="actualizar" value="Actualizar" />
        <input type="submit" name="insertar" value="Insertar" />
        <input type="submit" name="buscar" value="Buscar" />

    </form>



</body>

</html>