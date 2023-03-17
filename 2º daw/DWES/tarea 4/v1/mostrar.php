<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Mostrar</title>
</head>
<body class="bg-secondary">
    
    <?php
        session_start();

        if(isset($_POST['establecer'])){
            header('Location: preferencias.php');
        } else if(isset($_POST['borrar'])){
            if(!isset($_SESSION['idioma']) && !isset($_SESSION['perfil']) && !isset($_SESSION['zona-horaria'])){
                $error = true;
            }else{
                unset($_SESSION['idioma']);
                unset($_SESSION['perfil']);
                unset($_SESSION['zona-horaria']);
            }
           
        }

    ?>

    <div class="container bg-success mt-3 w-50 p-3 text-light">

        <div class="row">
            <div class="col-12">
                <h4><i class="fa-solid fa-user-gear"></i>Preferencias</h4>
            </div>
        </div>
       
        <div class="row">
            <div class="col-12">
                <?php
                    if(isset($error)){
                        ?>
                        <p>Debes fijar primero las preferencias</p>
                        <?php
                    }
                ?>

                <p><span class="fw-bold">Idioma: </span> <?php echo isset($_SESSION['idioma']) ? $_SESSION['idioma'] : 'No establecido' ?></p>
                <p><span class="fw-bold">Perfil público: </span> <?php echo isset($_SESSION['perfil']) ? $_SESSION['perfil'] : 'No establecido' ?></p>
                <p><span class="fw-bold">Zona horaria: </span><?php echo isset($_SESSION['zona-horaria']) ? $_SESSION['zona-horaria'] : 'No establecido' ?></p>

                <form method="POST">
                    <button type="submit" class="btn btn-primary" name="establecer">Establecer</button>
                    <button type="submit" class="btn btn-danger" name="borrar">Borrar</button>
                </form>
            </div>
        </div>
        

    </div>

    <script src="https://kit.fontawesome.com/b9f164ad49.js" crossorigin="anonymous"></script>
</body>
</html>