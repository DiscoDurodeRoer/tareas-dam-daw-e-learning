<?php
 
  //Opciones de la conexión
  $opciones = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
 
  // Lugar donde esta la BD
  define("HOST_DB", "localhost");
  // Usuario que se conecta a la BD
  define("USER_DB", "root");
  // Contraseña del usuario
  define("PASS_DB", "");
  // Nombre de la BD
  define("NAME_DB", "proyecto");
 
  try {
 
    $conexion = new PDO(
      'mysql:host='.constant("HOST_DB").';dbname='.constant("NAME_DB"),
      constant("USER_DB"),
      constant("PASS_DB"),
      $opciones
    );
  } catch (PDOException $e) {
    echo "Error: " . $e->getMessage() . "\n";
    exit;
  }
?>