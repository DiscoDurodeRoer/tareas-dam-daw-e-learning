<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Borrar</title>
</head>

<body>

    <?php
        require_once('conexion.php');

        if(isset($_POST['id'])){
            $id = $_POST['id'];
            $sql = "DELETE FROM productos WHERE id = $id";
            $delete = $conexion->query($sql);
            $delete->execute();

        }else{
            header("Location: listado.php");
        }
    
    ?>

    <span class="font-weight-bold">Producto de codigo: <?php echo $id ?> Borrado correctamente</span>
        <div class="d-inline-block">
            <form action="listado.php">
                <button class="btn">Volver</button>
            </form>
        </div>


</body>

</html>