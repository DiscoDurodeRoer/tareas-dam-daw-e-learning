<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Preferencias</title>
</head>
<body class="bg-secondary">

    <?php

        session_start();

        if(isset($_POST['mostrar'])){
            header('Location: mostrar.php');
        }else if(isset($_POST['establecer'])){
            
            $_SESSION['idioma'] = $_POST['idioma'];
            $_SESSION['perfil'] = $_POST['perfil'];
            $_SESSION['zona-horaria'] = $_POST['zona-horaria'];

            $success = true;

        }
    
    ?>

    <div class="container bg-white mt-3 w-50">

        <div class="row">
            <div class="col-12">

                <div class="row">
                    <div class="col-12 p-2 ps-3 bg-light">
                        <h3>Preferencias Usuario</h3>
                    </div>
                </div>

                <div class="row p-2">
                    <div class="col-12">
                        <form method="POST">

                            <?php
                                if(isset($success)){
                                    ?>
                                        <p class="text-primary">Preferencia de usuario guardadas</p>
                                    <?php
                                }
                            ?>

                            <p>Idioma</p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <label class="input-group-text rounded-0 rounded-start h-100" for="idioma">
                                        <i class="fas fa-book-open"></i>
                                    </label>
                                </div>
                                <select class="form-control custom-select" name="idioma" id="idioma">
                                    <option value="ingles" <?php echo isset($_SESSION['idioma']) && $_SESSION['idioma'] == 'ingles' ? 'selected' : null ?>>Inglés</option>
                                    <option value="español" <?php echo isset($_SESSION['idioma']) && $_SESSION['idioma'] == 'español' ? 'selected' : null ?>>Español</option>
                                </select>
                            </div>

                            <p>Perfil público</p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <label class="input-group-text rounded-0 rounded-start h-100" for="perfil">
                                        <i class="fa-solid fa-user"></i>
                                    </label>
                                </div>
                                <select class="form-control custom-select" name="perfil" id="perfil">
                                    <option value="si" <?php echo isset($_SESSION['perfil']) && $_SESSION['perfil'] == 'si' ? 'selected' : null ?>>Si</option>
                                    <option value="no" <?php echo isset($_SESSION['perfil']) && $_SESSION['perfil'] == 'no' ? 'selected' : null ?>>No</option>
                                </select>
                            </div>

                            <p>Zona horaria</p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <label class="input-group-text rounded-0 rounded-start h-100" for="zona-horaria">
                                        <i class="fa-solid fa-clock"></i>
                                    </label>
                                </div>
                                <select class="form-control custom-select" name="zona-horaria" id="zona-horaria">
                                    <option value="gmt-2" <?php echo isset($_SESSION['zona-horaria']) && $_SESSION['zona-horaria'] == 'gmt-2' ? 'selected' : null ?>>GMT-2</option>
                                    <option value="gmt-1" <?php echo isset($_SESSION['zona-horaria']) && $_SESSION['zona-horaria'] == 'gmt-1' ? 'selected' : null ?>>GMT-1</option>
                                    <option value="gmt" <?php echo isset($_SESSION['zona-horaria']) && $_SESSION['zona-horaria'] == 'gmt' ? 'selected' : null ?>>GMT</option>
                                    <option value="gmt+1" <?php echo isset($_SESSION['zona-horaria']) && $_SESSION['zona-horaria'] == 'gmt+1' ? 'selected' : null ?>>GMT+1</option>
                                    <option value="gmt+2" <?php echo isset($_SESSION['zona-horaria']) && $_SESSION['zona-horaria'] == 'gmt+2' ? 'selected' : null ?>>GMT+2</option>
                                </select>
                            </div>

                            <div class="row">
                                <div class="col-6">
                                    <button type="submit" class="btn btn-primary" name="mostrar">Mostrar preferencias</button>
                                </div>
                                <div class="col-6 text-end">
                                    <button type="submit" class="btn btn-success" name="establecer">Establecer preferencias</button>
                                </div>
                            </div>
                            
                            

                        </form>
                    </div>
                </div>

            </div>
        </div>

        




    </div>

    <script src="https://kit.fontawesome.com/b9f164ad49.js" crossorigin="anonymous"></script>
</body>
</html>