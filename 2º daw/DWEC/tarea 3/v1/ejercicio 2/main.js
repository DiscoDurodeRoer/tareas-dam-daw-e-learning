const INDICE_CONTADOR_A = 0;
const INDICE_CONTADOR_E = 1;
const INDICE_CONTADOR_I = 2;
const INDICE_CONTADOR_O = 3;
const INDICE_CONTADOR_U = 4;
const INDICE_CONTADOR_LETRAS_PALABRAS = 5;

const INDICE_MIN = 0;
const INDICE_MAX = 1;

function principal2() {

    let texto = document.getElementById("texto").value;

    try {
        if (texto.trim() !== "") {

            let reg = new RegExp(/^[A-Za-z(\.{1,3})\?\,\;\:\'\"\¿\¡\!\- ]+$/);

            if (reg.test(texto)) {
                let palabras = texto.split(' ');

                reg = new RegExp(/[A-Za-z]+/);

                palabras = palabras.filter(p => reg.test(p));

                if (palabras.length >= 10) {

                    let resultado = "El total de palabras del parrafo es " + palabras.length + "<br/>";

                    palabras.forEach(p => {

                        let contadores = cuentaLetras(p);

                        let indices = minMax(contadores);

                        let porcLetraMax = contadores[indices[INDICE_MAX]] * 100 / contadores[INDICE_CONTADOR_LETRAS_PALABRAS];
                        let porcLetraMin = contadores[indices[INDICE_MIN]] * 100 / contadores[INDICE_CONTADOR_LETRAS_PALABRAS];

                        resultado += "En la palabra <strong>"+ p +"</strong> hay " + contadores[INDICE_CONTADOR_LETRAS_PALABRAS] + " letras";
                        resultado += "El porcentaje de la vocal mas repetida es "+ porcLetraMax +"% ";
                        resultado += "y el porcentaje de la vocal menos repetida es "+ porcLetraMin +"%. ";
                        resultado += "Hay un total de "+ contadores[INDICE_CONTADOR_A] +" as, ";
                        resultado += "un total de "+ contadores[INDICE_CONTADOR_E] +" es, ";
                        resultado += "un total de "+ contadores[INDICE_CONTADOR_I] +" is, ";
                        resultado += "un total de "+ contadores[INDICE_CONTADOR_O] +" os y ";
                        resultado += "un total de "+ contadores[INDICE_CONTADOR_U] +" us <br/>";
                    
                    });

                    let div = document.getElementById("resultado");
                    div.innerHTML = resultado;

                } else {
                    throw Error("Deben haber 10 palabras al menos");
                }

            } else {
                throw Error("Tienes símbolos no permitidos");
            }

        } else {
            throw Error("No has insertado nada, revisa eso");
        }
    } catch (err) {
        alert(err);
    }
}

function cuentaLetras(palabra) {

    let contadorLetraPalabra = 0;
    let contadorA = 0;
    let contadorE = 0;
    let contadorI = 0;
    let contadorO = 0;
    let contadorU = 0;

    palabra.split('').forEach(letra => {

        switch (letra.toLowerCase()) {
            case 'a':
                contadorA++;
                break;
            case 'e':
                contadorE++;
                break;
            case 'i':
                contadorI++;
                break;
            case 'o':
                contadorO++;
                break;
            case 'u':
                contadorU++;
                break;
        }

        let reg = RegExp(/[A-Za-z]/);

        if (reg.test(letra)) {
            contadorLetraPalabra++;
        }

    })

    return [contadorA, contadorE, contadorI, contadorO, contadorU, contadorLetraPalabra]

}

function minMax(contadores) {

    let max = contadores[0];
    let min = Number.MAX_VALUE;

    for (let i = 0; i < contadores.length -1 ; i++) {
        const element = contadores[i];

        if (element > max) {
            max = element;
        }

        if (element < min && element != 0) {
            min = element;
        }

    }

    let indiceMax = contadores.findIndex(contador => contador === max);
    let indiceMin = contadores.findIndex(contador => contador === min);

    if (indiceMin == -1) {
        indiceMin = indiceMax;
    }

    return [indiceMin, indiceMax];

}