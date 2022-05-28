<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tarea 2 DWES (DAW) </title>
</head>
<body>
    
    <?php
    
        if(isset($_POST['enviar'])){

            $texto = $_POST['Texto'];

            $letrasContador = array();

            $letras = str_split($texto);

            foreach ($letras as $letra) {
                if(ctype_alnum($letra)){
                    if(isset($letrasContador[strtoupper($letra)]) || isset($letrasContador[strtolower($letra)])){

                        if(isset($letrasContador[strtoupper($letra)])){
                            $letrasContador[strtoupper($letra)]++;
                        }

                        if(isset($letrasContador[strtolower($letra)])){
                            $letrasContador[strtolower($letra)]++;
                        }

                    }else{
                        $letrasContador[$letra] = 1;
                    }
                }   
            }

            ?>

            <table>
                <tr>
                    <th>Letras</th>
                    <th>Repeticiones</th>
                </tr>
                <?php
                foreach($letrasContador as $letra => $contador){
                    echo "<tr>";
                    echo "<td>".$letra."</td>";
                    echo "<td>".$contador."</td>";
                    echo "</tr>";
                }

                ?>

            </table>

            <?php

        }
    
    ?>



    <form method="POST">
    
        <label for="Texto">Texto</label>
        <textarea name="Texto" id="Texto" cols="30" rows="10"></textarea>
    
        <input type="submit" name="enviar" value="Enviar" />
        <input type="reset" value="Reiniciar" />

    </form>


</body>
</html>