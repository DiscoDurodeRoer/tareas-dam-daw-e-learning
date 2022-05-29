<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Crear</title>
</head>

<body class="bg-info">

    <div class="container">
        <h3 class="text-center">Detalle producto</h3>

        <?php

            if(!isset($_GET['id'])){
                header("Location: listado.php");
            }else{

                require_once('conexion.php');

                $id = $_GET['id'];
                $sql = "SELECT * FROM PRODUCTOS WHERE id = $id";
                $result = $conexion->query($sql);
                $result->execute();
                $producto = $result->fetch(PDO::FETCH_OBJ);

                if($producto == null){
                    header("Location: listado.php");
                }

            }

        ?>

        <div class="card  bg-info mt-4">
            <div class="text-center card-header">
                <?php echo $producto->nombre; ?>
            </div>
            <div class="card-body">
                <p class="card-text">
                    <p>
                        <span class="font-weight-bold">Nombre: </span>
                        <span><?php echo $producto->nombre; ?></span>
                    </p>
                    <p>
                        <span class="font-weight-bold">Nombre corto: </span>
                        <span><?php echo $producto->nombre_corto; ?></span>
                    </p>
                    <p>
                        <span class="font-weight-bold">Código familia: </span>
                        <span><?php echo $producto->familia; ?></span>
                    </p>
                    <p>
                        <span class="font-weight-bold">PVP (€): </span>
                        <span><?php echo $producto->pvp; ?></span>
                    </p>
                    <p>
                        <span class="font-weight-bold">Descripción: </span>
                        <span><?php echo $producto->descripcion; ?></span>
                    </p>
                </p>
            </div>
        </div>

        <div class="mt-2 text-center">
            <form action="listado.php">
                <input type="submit" class="btn btn-light" value="Volver">
            </form>
        </div>

    </div>

</body>

</html>