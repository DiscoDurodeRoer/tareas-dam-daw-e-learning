function principal1() {

    let fecha = document.getElementById("fecha").value;

    let regs = [
        new RegExp(/(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[/]\d{4}/),
        new RegExp(/([1-9]|[12][0-9]|3[01])[\/]([1-9]|1[012])[\/]\d{4}/),
        new RegExp(/([1-9]|[12][0-9]|3[01])[\-]([1-9]|1[012])[\-]\d{4}/),
        new RegExp(/(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}/),
        new RegExp(/([1-9]|[12][0-9]|3[01])[\.]([1-9]|1[012])[\.]\d{4}/),
        new RegExp(/(0?[1-9]|[12][0-9]|3[01])[\.](0?[1-9]|1[012])[\.]\d{4}/)
    ];

    let correcto = false;

    regs.forEach(reg => {
        if (reg.test(fecha)) {
            correcto = true;
        }
    });

    try {

        if (correcto) {

            fecha = parseDate(fecha);
            console.log(fecha);

            let numDias = numeroDias(fecha.getMonth() + 1, fecha.getFullYear());
            console.log(numDias);
            if (fecha.getDate() <= numDias) {

                let fechaMinima = new Date("1975-01-01");
                let fechaMaxima = new Date("2019-12-15");

                if (fechaMinima.getTime() <= fecha.getTime() && fecha.getTime() <= fechaMaxima.getTime()) {

                    let dif1975 = diferenciaDias(fecha, fechaMinima);

                    alert("Han pasado " + dif1975 + " dias desde el 01/01/1975");

                    let dif2019 = diferenciaDias(fechaMaxima, fecha);

                    alert("Faltan " + dif2019 + " dias desde el 15/12/2019");

                    let mensajeDia = diaSemana(fecha);

                    alert(mensajeDia);

                } else {
                    throw new Error("La fecha debe estar entre 01/01/1975 y 15/12/2019");
                }
            } else {
                throw new Error("La fecha no es correcta");
            }
        } else {
            throw new Error("La fecha no tiene el formato correcto");
        }
    } catch (error) {
        alert(error)
    }

}

function parseDate(fecha) {

    let cadena = fecha.replace(/\/|\./g, "-");
    let partes = cadena.split("-");

    let dia = partes[0];
    let mes = partes[1];
    let anio = partes[2];

    let nuevaFecha = anio + "-" + mes + "-" + dia;

    return new Date(nuevaFecha);

}

function numeroDias(mes, anio) {

    let numDias = -1;

    switch (mes) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            numDias = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            numDias = 30;
            break;
        case 2:

            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)) {
                numDias = 29;
            } else {
                numDias = 28;
            }
            break;

    }

    return numDias;
}

function diferenciaDias(fecha1, fecha2) {

    let diferencia = fecha1.getTime() - fecha2.getTime();
    return Math.round(diferencia / (1000 * 60 * 60 * 24));

}

function diaSemana(fecha) {

    let mensaje = "El dia elegido es ";
    let dia = fecha.getDay();

    switch (dia) {
        case 0:
            mensaje += "domingo";
            break;
        case 1:
            mensaje += "lunes";
            break;
        case 2:
            mensaje += "martes";
            break;
        case 3:
            mensaje += "miercoles";
            break;
        case 4:
            mensaje += "jueves";
            break;
        case 5:
            mensaje += "viernes";
            break;
        case 6:
            mensaje += "sabado";
            break;
    }

    return mensaje;


}