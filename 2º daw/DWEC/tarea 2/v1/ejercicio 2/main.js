function principal2(){

    let anioText = document.getElementById("anio").value;

    let anio = parseInt(anioText);

    try {
        if(Number.isInteger(anio)){
            if(anio >= 0){

                if(esBisiesto(anio)){
                    alert("El año " + anio + " es bisiesto");
                }else{

                    let bisiesto = false;
                    let anioSiguiente = anio++;
                    while(!bisiesto){
                        if(esBisiesto(anioSiguiente)){
                            bisiesto = true;
                        }else{
                            anioSiguiente++;
                        }
                    }

                    alert("El año bisiesto siguiente es " + anioSiguiente);

                }


            }else{
                throw new Error("El año debe ser mayor que 0");
            }
        }else{
            throw new Error("El año no es un número entero");
        }
            
    } catch (error) {
        alert(error)
    }

}

function esBisiesto(anio){
    return (anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0);
}