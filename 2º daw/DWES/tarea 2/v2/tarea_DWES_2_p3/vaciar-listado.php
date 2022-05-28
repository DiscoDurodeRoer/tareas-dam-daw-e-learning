<?php
    session_start();
    unset($_SESSION['paises']);
    header("Location: index.php")
?>