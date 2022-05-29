
var nombreEquipos = [];
var datosEquipos = [];
var indiceEquipo = 0;

const INDICE_EQUIPO = 0;
const INDICE_PG = 1;
const INDICE_PE = 2;
const INDICE_PP = 3;
const INDICE_PUNTOS = 4;
const INDICE_FECHA = 5;


function principal3() {

    try {

        if (nombreEquipos.length < 5) {

            let nombreEquipo = document.getElementById("nombreEquipo").value;
            let partidosGanados = parseInt(document.getElementById("partidosGanados").value);
            let partidosEmpatados = parseInt(document.getElementById("partidosEmpatados").value);
            let partidosPerdidos = parseInt(document.getElementById("partidosPerdidos").value);

            if (!existeEquipo(nombreEquipo)) {

                nombreEquipos.push(nombreEquipo);

                datosEquipos[indiceEquipo] = [];

                datosEquipos[indiceEquipo][INDICE_PG] = partidosGanados;
                datosEquipos[indiceEquipo][INDICE_PE] = partidosEmpatados;
                datosEquipos[indiceEquipo][INDICE_PP] = partidosPerdidos;
                datosEquipos[indiceEquipo][INDICE_PUNTOS] = (partidosGanados * 3) + partidosEmpatados;
                datosEquipos[indiceEquipo][INDICE_FECHA] = calcularAnioFundacion();

                ordenar();
                reordernarIndices();

                indiceEquipo++;
                console.log(nombreEquipos);
                console.log(datosEquipos);

                mostrarEquipos();
            } else {
                throw new Error("El equipo ya existe");
            }

        } else {
            throw new Error("No puedes insertar mas de 5 equipos");
        }



    } catch (error) {
        alert(error);
    }
}

function existeEquipo(nombreEquipo) {
    return nombreEquipos.find(n => n == nombreEquipo);
}

function calcularAnioFundacion() {
    let d = new Date();
    let anioMaximo = d.getUTCFullYear();
    let anioMinimo = anioMaximo - 50;

    return Math.floor(Math.random() * (anioMaximo - anioMinimo) + anioMinimo)
}

function mostrarEquipos(){

    let info = document.getElementById("info");
    info.innerHTML="";

    let resultado = "";

    datosEquipos.forEach(fila => {
        
        let nombreEquipo = nombreEquipos[fila[0]];
        resultado += nombreEquipo + "(" + fila[5] +")";
        resultado += "-Puntos: " + fila[4] + "<br/>";
        resultado += "Ganados: " + fila[1] + " ";
        resultado += "Empatados: " + fila[2] + " ";
        resultado += "Perdidos: " + fila[3] + ".<br/>";

    });

    info.innerHTML = resultado



}

function ordenar() {

    let ultimoInsertado = nombreEquipos[nombreEquipos.length - 1];
    let index = nombreEquipos.findIndex(n => n.localeCompare(ultimoInsertado) > 0);

    if (index != -1) {
        nombreEquipos.splice(index, 0, ultimoInsertado);
        nombreEquipos.splice(nombreEquipos.length - 1, 1);

        datosEquipos.splice(index, 0, datosEquipos[datosEquipos.length - 1]);
        datosEquipos.splice(datosEquipos.length - 1, 1);
    }


}

function reordernarIndices() {

    for (let index = 0; index < nombreEquipos.length; index++) {
        datosEquipos[index][INDICE_EQUIPO] = index;
    }

}