<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Tarea DWES 2</title>
</head>
<body>
    
    <?php
        session_start();

        // Creo el array de contactos
        if(!isset($_SESSION['contactos'])){
            $_SESSION['contactos'] = array();
        }

        $aviso = "";
        // Cuando pulsamos el Añadir
        if(isset($_POST['aniadir'])){

            // Obtengo el nombre y el telefono
            $nombre = $_POST['nombre'];
            $telefono = $_POST['telefono'];

            // Comprobamos si el nombre esta vacio
            if(empty($nombre)){
                $aviso = "El Nombre es Obligatorio!!!";
            // Comprobamos si no existe el nombre en la agenda y el telefono esta vacio
            }else if (!isset($_SESSION['contactos'][$nombre]) && empty($telefono)){
                $aviso = "El telefono es obligatorio";
            // Comprobamos si existe el nombre en la agenda y el telefono esta vacio
            }else if (isset($_SESSION['contactos'][$nombre]) && empty($telefono)){
                $aviso = "El contacto ha sido borrado";
                unset($_SESSION['contactos'][$nombre]);
            }else{

                // Creamos el contacto
                $contacto = array(
                    "nombre" => $nombre,
                    "telefono" => $telefono
                );
    
                // Si existe en la agenda, lo estamos actualizando
                if(isset($_SESSION['contactos'][$nombre])){
                    $aviso = "El contacto ha sido actualizado";
                }else{
                    $aviso = "El contacto ha sido creado";
                }
    
                // Modificamos o añadimos el contacto
                $_SESSION['contactos'][$nombre] = $contacto;
            
            }
        }

        // Si pulsamos en vaciar, borramos todos los contactos
        if(isset($_GET['vaciar'])){
            $aviso = "Todos los contactos han sido borrados";
            $_SESSION['contactos'] = array();
        }
    
        // Mostramos el aviso
        if(!empty($aviso)){
            ?>
            <p class="aviso"><?php echo $aviso; ?></p>
            <?php
        }

    
    ?>

    <div class="agenda">
        <h4>Agenda</h4>

        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">

            <?php
                // Solo si hay contactos lo mostraremos
                if(count($_SESSION['contactos']) > 0){
                    ?>
                <fieldset>
                    <legend>Datos Agenda</legend>
                    <table>
                    <?php
                    // Recorremos los contactos
                    foreach ($_SESSION['contactos'] as $key => $value) {
                        ?>
                        <tr>
                            <td><?php echo $value['nombre']; ?></td>
                            <td><?php echo $value['telefono']; ?></td>
                        </tr>
                        <?php
                    }
                    ?>
                    </table>
                </fieldset>
                <?php
                }
            ?>

            <fieldset>
                <legend>Nuevo Contacto</legend>

                <table>
                    <tr>
                        <td>
                            <label for="nombre">Nombre: </label>
                        </td>
                        <td>
                            <input type="text" name="nombre" id="nombre">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="telefono">Teléfono: </label>
                        </td>
                        <td>
                            <input type="text" name="telefono" id="telefono">
                        </td>
                    </tr>
                </table>
                
                <button type="submit" name="aniadir">Añadir Contacto</button>
                <button type="reset">Limpiar Campos</button>

            </fieldset>
            
        </form>

        <?php
            // Solo si hay contactos lo mostraremos
            if(count($_SESSION['contactos']) > 0){
                ?>
                <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="GET">
                    <fieldset>
                        <legend>Vaciar Agenda</legend>
                        <button type="submit" name="vaciar" value="1">Vaciar</button>
                    </fieldset>
                </form>
                <?php
            }
        ?>


    </div>
    



</body>
</html>