function principal3(){

    let array = [17, 15, 14, 16, 12, 14, 18];

    let divArrayOriginal = document.getElementById("original");

    mostrarArray(divArrayOriginal, array);

    let arrayOrdenado = ordenarBurbuja(array);

    let divArrayOrdenado = document.getElementById("ordenado");

    mostrarArray(divArrayOrdenado, arrayOrdenado);


}

function ordenarBurbuja(array){

    for (let i = 1; i < array.length; i++) {
        for (let j = 0; j < array.length - i; j++) {
            
            if(array[j] > array[j+1]){
                let aux = array[j+1];
                array[j+1]=array[j]
                array[j] = aux;
            }

        }
    }

    return array;
}

function mostrarArray(elementoMostrar, array){

    elementoMostrar.innerHTML = "";

    for (let i = 0; i < array.length; i++) {
        const element = array[i];

        if(i === array.length - 1){
            elementoMostrar.innerHTML += element;
        }else{
            elementoMostrar.innerHTML += element + ",";
        }
        
    }

}