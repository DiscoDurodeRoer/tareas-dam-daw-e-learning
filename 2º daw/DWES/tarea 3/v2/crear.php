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
        <h3 class="text-center">Crear productos</h3>

        <?php
            require_once('conexion.php');

            if(isset($_POST['crear'])){

                $nombre = $_POST['nombre'];
                $nombreCorto = $_POST['nombre-corto'];
                $precio = $_POST['precio'];
                $familia = $_POST['familia'];
                $descripcion = $_POST['descripcion'];

                $sql = "INSERT INTO PRODUCTOS (nombre, nombre_corto, descripcion, pvp, familia) VALUES('$nombre', '$nombreCorto', '$descripcion', $precio, '$familia')";
                $insert = $conexion->query($sql);
				// En PHP 8, tendras que comentar la siguiente linea
                $insert->execute();

                header('Location: listado.php');
            }else if(isset($_POST['volver'])){
                header('Location: listado.php');
            }

        ?>

        <form method="POST">

            <div class="row">
                <div class="col-6">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="nombre" id="nombre"/>
                </div>
                <div class="col-6">
                    <label for="nombre-corto">Nombre corto</label>
                    <input type="text" class="form-control" name="nombre-corto" id="nombre-corto"/>
                </div>
            </div>

            <div class="row">
                <div class="col-6">
                    <label for="precio">Precio (€)</label>
                    <input type="text" class="form-control" name="precio" id="precio"/>
                </div>
                <div class="col-6">
                    <label for="familia">Familia</label>
                    <select class="form-control" name="familia" id="familia">
                        <?php
                            $result = $conexion->query("SELECT * FROM familias");
                            $result->execute();
                            while($row=$result->fetch(PDO::FETCH_OBJ)){
                                echo "<option value='$row->cod'>$row->nombre</option>";
                            }
                        ?>
                    </select>
                </div>
            </div>

            <div class="row mb-2">
                <div class="col-12">
                    <label for="descripcion">Descripción</label>
                    <textarea class="form-control" name="descripcion" id="descripcion" cols="100" rows="10"></textarea>
                </div>
            </div>

            <input type="submit" class="btn btn-primary" name="crear" value="Crear">
            <input type="reset" class="btn btn-success" value="Limpiar">
            <input type="submit" class="btn btn-light" name="volver" value="Volver">


        </form>

    </div>

</body>

</html>