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
        <h3 class="text-center">Modificar Producto</h3>

        <?php
            require_once('conexion.php');

            if(isset($_POST['modificar'])){

                $id = $_POST['id'];
                $nombre = $_POST['nombre'];
                $nombreCorto = $_POST['nombre-corto'];
                $precio = $_POST['precio'];
                $familia = $_POST['familia'];
                $descripcion = $_POST['descripcion'];

                $sql = "UPDATE PRODUCTOS SET nombre = '$nombre', nombre_corto = '$nombreCorto', descripcion = '$descripcion', pvp = $precio, familia = '$familia' WHERE id = $id";
                $insert = $conexion->query($sql);
                $insert->execute();

                header('Location: listado.php');
            }

            if(!isset($_GET['id']) || isset($_POST['volver'])){
                header("Location: listado.php");
            }else{

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

        <form method="POST">

            <input type="hidden" name="id" value="<?php echo $producto->id; ?>">

            <div class="row">
                <div class="col-6">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="nombre" id="nombre" value="<?php echo $producto->nombre; ?>"/>
                </div>
                <div class="col-6">
                    <label for="nombre-corto">Nombre corto</label>
                    <input type="text" class="form-control" name="nombre-corto" id="nombre-corto"  value="<?php echo $producto->nombre_corto; ?>"/>
                </div>
            </div>

            <div class="row">
                <div class="col-6">
                    <label for="precio">Precio (€)</label>
                    <input type="text" class="form-control" name="precio" id="precio"  value="<?php echo $producto->pvp; ?>"/>
                </div>
                <div class="col-6">
                    <label for="familia">Familia</label>
                    <select class="form-control" name="familia" id="familia">
                        <?php
                            $result = $conexion->query("SELECT * FROM familias");
                            $result->execute();
                            while($row=$result->fetch(PDO::FETCH_OBJ)){
                                if($row->cod == $producto->familia){
                                    echo "<option selected value='$row->cod'>$row->nombre</option>";
                                }else{
                                    echo "<option value='$row->cod'>$row->nombre</option>";
                                }
                            }
                        ?>
                    </select>
                </div>
            </div>

            <div class="row mb-2">
                <div class="col-12">
                    <label for="descripcion">Descripción</label>
                    <textarea class="form-control" name="descripcion" id="descripcion" cols="100" rows="10"><?php echo $producto->descripcion; ?></textarea>
                </div>
            </div>

            <input type="submit" class="btn btn-primary" name="modificar" value="Modificar">
            <input type="submit" class="btn btn-light" name="volver" value="Volver">


        </form>

    </div>

</body>

</html>