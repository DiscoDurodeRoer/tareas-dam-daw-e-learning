<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Listado</title>
</head>

<body class="bg-info">

    <div class="container">
        <h3 class="text-center">Gestion de productos</h3>

        <form action="crear.php" class="mb-1">
            <button class="btn btn-success">Crear</button>
        </form>

        <table class="table table-striped table-dark text-center">
            <thead>
                <tr>
                    <th scope="col">Detalle</th>
                    <th scope="col">Código</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    require_once('conexion.php');

                    $query = $conexion->query('SELECT * FROM productos');
                    $query->execute();

                    while($row=$query->fetch(PDO::FETCH_OBJ)){
                        ?>
                            <tr>
                            <td>
                                <form action="detalle.php" method="GET">
                                    <input type="hidden" name="id" value="<?php echo $row->id; ?>">
                                    <button class="btn btn-info">Detalle</button>
                                </form>
                            </td>
                            <td>
                                <?php echo $row->id; ?>
                            </td>
                            <td>
                                <?php echo $row->nombre; ?>
                            </td>
                            <td>

                                <form class="d-inline-block" action="update.php" class="mb-1" method="GET">
                                    <input type="hidden" name="id" value="<?php echo $row->id; ?>">
                                    <button class="btn btn-warning">Actualizar</button>
                                </form>
                                
                                <form class="d-inline-block" action="borrar.php" class="mb-1" method="POST">
                                    <input type="hidden" name="id" value="<?php echo $row->id; ?>">
                                    <button class="btn btn-danger">Borrar</button>
                                </form>
                            </td>

                        <?php

                        echo "</tr>";
                    }

                ?>
            </tbody>
        </table>

    </div>




</body>

</html>