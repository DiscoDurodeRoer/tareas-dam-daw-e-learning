<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>DWES tarea 2</title>
</head>
<body>

    <h3>PAISES DE LA UNION EUROPEA</h3>

    <?php 
        session_start(); 
        if(isset($_SESSION['paises']) && count($_SESSION['paises']) > 0){
            ?>
                <form>
                    <fieldset>
                        <legend>Listado paises</legend>
                        <?php
                            foreach ($_SESSION['paises'] as $key => $value) {
                                ?>
                                    <div>
                                        <div class="row-list-1">
                                            <span><?php echo $key; ?></span>
                                        </div>
                                        <div class="row-list-2">
                                            <span><?php echo $value; ?></span>
                                        </div>
                                    </div>
                                <?php
                            }
                        ?>
                    </fieldset>
                </form>
            <?php
        }
    ?>

    <form action="aniadir-pais.php" method="POST">
        <fieldset>
            <legend>Pais de la union europea</legend>

            <div>
                <div class="row-form-1">
                    <span>Pais:</span>
                </div>
                <div class="row-form-2">
                    <input type="text" name="pais" />
                </div>
            </div>
            
            <div>
                <div class="row-form-1">
                    <span>Capital:</span>
                </div>
                <div class="row-form-2">
                    <input type="text" name="capital" />
                </div>
            </div>
            
            <div class="buttons">
                <input class="btn-add" type="submit" value="Añadir pais" />
                <input class="btn-reset" type="reset" value="Limpiar campos" />
            </div>
            
        </fieldset>

    </form>


    <?php 
        if(isset($_SESSION['paises']) && count($_SESSION['paises']) > 0){
            ?>
                <form action="vaciar-listado.php">
                    <fieldset>
                        <legend>Vaciar listado</legend>
                        <input class="btn-clear" type="submit" value="Vaciar" />
                    </fieldset>
                </form>
            <?php
        }
    ?>



    
</body>
</html>