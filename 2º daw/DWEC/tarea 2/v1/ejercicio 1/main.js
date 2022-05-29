function principal1() {

    let limiteText = document.getElementById("limite").value;
    let multiploText = document.getElementById("multiplo").value;

    let limite = parseInt(limiteText);
    let multiplo = parseInt(multiploText);

    try {

        if (limite <= 0 || multiplo <= 0) {
            throw new Error("El limite o el multiplo deben ser mayores que cero");
        }else if(multiplo > limite){
            throw new Error("El  multiplo es mayor que el limite");
        }else{

            let divNumeros = document.getElementById("numeros");
            divNumeros.innerHTML = "";
            divNumeros.innerHTML = "<ul>";
            for (let i = 1; i <= limite; i++) {
                if(i % multiplo === 0){
                    divNumeros.innerHTML += "<li>"+i+"</li>";
                }
            }
            divNumeros.innerHTML += "</ul>";


        }


    } catch (error) {
        alert(error)
    }



}