<?php

    session_start();

    $pais = $_POST['pais'];
    $capital = $_POST['capital'];

    if(!isset($_SESSION['paises'])){
        $_SESSION['paises'] = array();
    }

    if (isset($capital) && !empty($capital)){
        $_SESSION['paises'][$pais] = $capital;
    }else{
        unset($_SESSION['paises'][$pais]);
    }

    header("Location: index.php");

?>