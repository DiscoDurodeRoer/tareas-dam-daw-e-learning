<?php
session_start();
if(!isset($_SESSION['usu'])){
    header('Location:login.php');
    die();
}
require './include/Producto.php';
$productos=new Producto();
$todos=$productos->listadoProductos();

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Productos</title>
</head>
<body style="background:gainsboro">
<div class="float float-right d-inline-flex mt-2">
   
    
    <i class="fas fa-user mr-3 fa-2x"></i>
    <input type="text" size='10px' value="<?php echo $_SESSION['usu']; ?>" class="form-control
    mr-2 bg-transparent text-info font-weight-bold" disabled>
    <a href="cerrar.php" class="btn btn-warning mr-2">Salir</a>
</div>
<br>
<h4 class="container text-center mt-4 font-weight-bold">Productos onLine</h4>
<div class="container mt-3">
<table class="table table-striped table-dark">
  <thead>
    <tr class='text-center'>
      <th scope="col">Código</th>
      <th scope="col">Nombre</th>
      <th scope="col">Nombre Corto</th>
      <th scope="col">Precio (€)</th>
      <th scope="col">Familia</th>
    </tr>
  </thead>
  <tbody>
      <?php
        while($item=$todos->fetch(PDO::FETCH_OBJ)){
           echo <<<END
             <tr class='text-center'>
             <th scope='row'>{$item->id}</th>
             <td>{$item->nombre}</td>
             <td>{$item->nombre_corto}</td>
             <td>{$item->pvp}</td>
             <td>{$item->familia}</td>
             </tr>
            END;
      }
      ?>
  </tbody>
</table>
</body>
</html>