<?php
session_start();
if(!isset($_SESSION['usu'])){
    header('Location:login.php');
    die();
}
require './include/Producto.php';
require 'include/xajax_core/xajax.inc.php';
$productos=new Producto();
$todos=$productos->listadoProductos();

$xajax =  new xajax('include/AccionesVoto.php');

$xajax->register(XAJAX_FUNCTION, 'miVoto');
$xajax->register(XAJAX_FUNCTION, 'pintarEstrellas');

$xajax->configure('javascript URI', './include/');
$xajax->configure('deferScriptGeneration', false);
$xajax->configure('debug', false);
$xajax->processRequest();


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
    <?php $xajax->printJavascript(); ?>
    <script type="text/javascript" src="validar.js"></script>
    
    <script>
      xajax_pintarEstrellas();        
    </script>
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
      <th scope="col">Valoración</th>
      <th scope="col">Valorar</th>
    </tr>
  </thead>
  <tbody>
      <?php
        while($item=$todos->fetch(PDO::FETCH_OBJ)){
           echo <<<END
             <tr class='text-center'>
             <th scope='row'>{$item->id}</th>
             <td>{$item->nombre}</td>
             <td>
              <div id="votos_{$item->id}">
              </div>
             </td>
             <td>
              <form name='miForm' id="miForm_{$item->id}" method='POST' action="listado.php" >
                <input name="idPr" type="hidden" value="{$item->id}">
                <input name="idUs" type="hidden" value="{$_SESSION['usu']}">
                <div class="row">
                  <div class="col">
                   <select class="form-control" name="cantidad">
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                   </select>
                  </div>
                  <div class="col">
                   <input type="button" value="Votar" class="btn btn-info" name='votar' id="enviar" onclick="envFormVoto(xajax.getFormValues('miForm_{$item->id}'))" />
                  </div>
                </div>
              </form
             </td>
             </tr>
            END;
      }
      ?>
  </tbody>
</table>
</body>
</html>