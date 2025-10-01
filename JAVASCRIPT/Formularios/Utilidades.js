var maxCar = 5;

window.onload = function(){
    document.getElementById("sugerencia").onkeypress = limita;
    document.getElementById("sugerencia").onkeyup = maxCaracteres;
    document.getElementById("formulario_1").onsubmit = validar;
}    

function limita(){
    return (this.value.length < maxCar)
}

function maxCaracteres(){
    var caracteres = maxCar - this.value.length;
    document.getElementById("info_sugerencia").innerHTML = "Caracteres disponibles: " + caracteres; 
}

function validar(){
    //Validamos el nombre.
    var nombre = document.getElementById("nombre");
    if (nombre.value.length < 2){
        document.getElementById("info_nombre").innerHTML = "Introduce al menos 2 caracteres.";
        document.getElementById("nombre").focus();
        return false;
    }

    //Validamos el apellido.
    var apellidos = document.getElementById("apellidos");
    if (apellidos.value.length < 4){
        document.getElementById("info_apellidos").innerHTML = "Introduce al menos 4 caracteres."
        return false;
    }


    //Validamos el DNI.
    var valor = document.getElementById("dni").value;
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N',
    'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

    if( !(/^\d{8}[A-Z]$/.test(valor)) ) {
        document.getElementById("info_dni").innerHTML = "Formato inválido. Debes introducir 8 números y una letra.";
        return false;
    }
    if(valor.charAt(8) != letras[(valor.substring(0, 8))%23]) {
        document.getElementById("info_dni").innerHTML = "DNI incorrecto.";
        return false;
    }


     //Validamos el sexo.

    /*var indice = document.getElementById("sexo").selectedIndex;
    if( indice == null || indice == 0 ) {
        document.getElementById("info_sexo").innerHTML = "Selecciona al menos una opción.";
        return false;
    }*/

    var sexo = document.getElementsByName("sexo");
    var seleccionado = false;
    for(var i = 0; i<sexo.length; i++){
        if(sexo[i].checked){
            seleccionado = true;
            break;
        }
    }
    if(!seleccionado){
        document.getElementById("info_sexo").innerHTML = "Selecciona al menos una opción.";
        return false;
    }
    

    //Validamos la fecha.
    var dia = parseInt(document.getElementById("f_dia").value);
    var mes = parseInt(document.getElementById("f_mes").value);
    var anio = parseInt(document.getElementById("f_ano").value);

    var fecha = new Date (anio, mes -1, dia);

    if (fecha.getFullYear() !== anio || fecha.getMonth() !== (mes -1) || fecha.getDate()!== dia){
        document.getElementById("info_fecha").innerHTML ="Formato de fecha inválido."
        return false;
    }

    //Validamos la estatura.
    var estatura = document.getElementById("estatura").value;
    var est = parseFloat(estatura);
    
    if (est <= 0 || isNaN(est)){
        document.getElementById("info_estatura").innerHTML = "Introduce una estatura válida."
        return false;
    }

    //Validamos el estado civil.
    var defecto = document.getElementById("estado_civil").value;
    if(defecto == -1) {
        document.getElementById("info_estado_civil").innerHTML = "Selecciona al menos una opción.";
        return false;
    }

    //Validamos los zumos de cebada.
    var zumos = document.getElementsByName("bebidas");
    var contador = 0;

    for(var i = 0; i< zumos.length; i++){
            if(zumos[i].checked){
                contador++;
            }
        } 
 
    if(contador < 3){
        document.getElementById("info_bebidas").innerHTML = "Selecciona al menos 3 opciones.";
        return false;
    }     

    //Validamos el número de cuenta corriente.
    
    var numcuenta = document.getElementById("ccc").value;

    if(numcuenta.length !== 20 || isNaN(numcuenta)){
        document.getElementById("info_ccc").innerHTML ="Introduce un número de cuenta válido.";
        return false;
    }



}
      