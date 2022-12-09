<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarea 2 DWES</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <?php
        // Arranco la sesión
        session_start();

        // Comprobamos si el nif es correcto
        $dni = $_POST['nif'];
        // Obtengo el numero del nif
        $numDNI = substr($dni, 0, -1);
        // Obtengo la letra del nif
        $letraDNI = substr($dni, -1, 1);
        $letras = 'TRWAGMYFPDXBNJZSQVHLCKET';
        // Obtengo el resto
        $indice = $numDNI % 23;
        $letraCalc = substr($letras, $indice, 1);

        // Si la letra que me dan es diferente a la que deberia ser, mandamos el error
        if($letraDNI != $letraCalc){
            $_SESSION['error'] = "EL NIF no es correcto";
            header('Location: Datos.php');
        }else{

            // incrementamos el numero de solicitud
            $_SESSION['num_solicitud'] = $_SESSION['num_solicitud'] + 1;

            // Baremo
            $baremo = array(
                "Universitario Superior" => 10,
                "Universitario Medio" => 8,
                "FP" => 6,
                "Bachillerato" => 6,
                "Prueba Acceso" => 4,
                "Familia Numerosa" => 4,
                "Renta" => 4,
                "Paro" => 4,
                "Minusvalia" => 5,
                "Monoparental" => 5
            );
    
            // Calculo de diferencia de años
            $diferencia = date_diff(date_create($_POST['fecha_nac']), date_create());
            $edad = $diferencia->format('%y');
        }

    
    ?>

    <form action="Datos.php" method="post">

        <fieldset>
            <!-- Mostramos la fecha de hoy y el numero de solicitud actual -->
            <legend>BAREMACIÓN AL <?php echo date_format(date_create(), 'd-m-Y') ?></legend>

            <p>
                <b>SOLICITANTE: <?php echo $_POST['nombre'] . ' ' . $_POST['apellidos'] . ' NIF: ' . $_POST['nif'];?></b>
            </p>

            <p>
                <b>Edad en el año <?php echo date("Y") ?>: <?php echo $edad;?></b>
            </p>

            <!-- Mostramos el valor del baremo de la forma de acceso -->
            <p>
                <b>Puntos por titulación: </b>

                <ul>
                    <li><?php echo $_POST['form_acceso']; ?>: <?php echo $baremo[$_POST['form_acceso']]; ?></li>
                </ul>
            </p>

            <!-- Mostramos el valor del baremo del acceso preferente, si existe -->
            <p>
                <b>Acceso preferente: </b>
                <?php
                    $totalAccesoPref = 0;
                    if(isset($_POST['acesso_pref'])){
                        ?>
                        <ul>
                            <?php
                            foreach ($_POST['acesso_pref'] as $key => $value) {
                                ?>
                                <li><?php echo $value . ':' . $baremo[$value]; ?></li>
                                <?php
                                $totalAccesoPref = $totalAccesoPref + $baremo[$value];
                            }
                            ?>
                        </ul>
                        <?php
                    }
                ?>
            </p>

            <p>
                <b>Puntos por acceso preferente: <?php echo $totalAccesoPref; ?></b>
            </p>

            <!-- Sumamos los puntos -->
            <p>
                <b>Total Puntos obtenidos: <?php echo $totalAccesoPref + $baremo[$_POST['form_acceso']]; ?></b>
            </p>
            
            
            <input type="submit" value="Volver">
        </fieldset>

    </form>
    
</body>
</html>