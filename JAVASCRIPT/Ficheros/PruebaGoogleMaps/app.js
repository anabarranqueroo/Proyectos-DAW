// --- Eventos al cargar la página ---
// Se ejecuta cuando la página termina de cargarse
window.onload = function () {
    // Asignar eventos a los botones y selectores
    document.getElementById("btnNuevaRuta").onclick = abrirModal;     // Abrir modal para añadir ruta
    document.getElementById("btnCancelarModal").onclick = cerrarModal; // Cerrar modal sin guardar
    document.getElementById("btnGuardarRuta").onclick = anadirRuta;    // Subir y guardar nueva ruta
    document.getElementById("rutas").onchange = cargarTabla;           // Al cambiar la ruta seleccionada, cargar puntos en tabla
    document.getElementById("btnBorrarRuta").onclick = borrarRuta;     // Borrar ruta seleccionada

    // Cargar todas las rutas existentes al iniciar
    cargarRutas();
}

let mapa; // Variable global para el objeto del mapa de Google Maps

// --- Inicialización del mapa ---
function initMap() {
    // Crear un mapa de Google Maps en el div "divmapa"
    mapa = new google.maps.Map(document.getElementById("divmapa"), {
        center: { lat: 37.874327, lng: -0.756041 }, // Coordenadas iniciales
        zoom: 17,                                   // Zoom inicial
        mapId: "mapa1"                              // ID de estilo de mapa (opcional)
    });
    console.log("Mapa cargado"); // Mensaje para confirmar que el mapa está listo
}

// --- Función para dibujar ruta en el mapa ---
function dibujarRuta(listaCoordenadas) {
    if (!mapa) { // Comprobar que el mapa ya está inicializado
        console.warn("Mapa aún no inicializado");
        return;
    }

    if (!listaCoordenadas.length) return; // No dibujar si la lista de coordenadas está vacía

    // Crear la línea que conecta todos los puntos
    const polyline = new google.maps.Polyline({
        path: listaCoordenadas,      // Array de objetos {lat, lng}
        strokeColor: "#FF0000",      // Color de la línea
        strokeOpacity: 0.8,          // Opacidad
        strokeWeight: 4               // Grosor de la línea
    });
    polyline.setMap(mapa);           // Dibujar la línea en el mapa

    // Centrar el mapa en el primer punto de la ruta
    mapa.setCenter(listaCoordenadas[0]);
    mapa.setZoom(17);
}

// --- Modal (ventana emergente para subir rutas) ---
function abrirModal() {
    document.getElementById("modal").classList.remove("oculto"); // Mostrar modal
}

function cerrarModal() {
    document.getElementById("modal").classList.add("oculto");    // Ocultar modal
}

// --- Subir ruta desde un archivo GPX ---
function anadirRuta() {
    const archivoInput = document.getElementById("rutaArchivo"); // Input de archivo
    const archivo = archivoInput.files[0]; // Tomar el archivo seleccionado

    if (!archivo) { // Comprobar que haya un archivo
        alert("Selecciona un archivo");
        return;
    }

    const lector = new FileReader(); // Crear lector de archivos
    lector.onload = function () {
        const contenido = lector.result; // Contenido del archivo
        const xml = new DOMParser().parseFromString(contenido, "text/xml"); // Parsear como XML
        const puntos = xml.getElementsByTagName("trkpt"); // Obtener todos los puntos de track

        let listaCoordenadas = [];
        for (let i = 0; i < puntos.length; i++) {
            const lat = parseFloat(puntos[i].getAttribute("lat")); // Latitud
            const lng = parseFloat(puntos[i].getAttribute("lon")); // Longitud
            listaCoordenadas.push({ lat, lng });                  // Guardar en array
        }

        // Dibujar ruta en el mapa
        dibujarRuta(listaCoordenadas);

        // Enviar la ruta al servidor para guardarla
        fetch("servidor.php", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                servicio: "anadirRuta",    // Indicar acción al servidor
                archivo: archivo.name,      // Nombre del archivo
                puntos: listaCoordenadas    // Array de coordenadas
            })
        }).then(r => r.json())
          .then(() => {
              cerrarModal();   // Cerrar modal
              cargarRutas();   // Actualizar lista de rutas en el select
          });
    };
    lector.readAsText(archivo); // Leer el archivo como texto
}

// --- Cargar rutas desde el servidor ---
function cargarRutas() {
    fetch("servidor.php", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ servicio: "listarRutas" }) // Solicitar lista de rutas
    })
    .then(r => r.json())
    .then(datos => {
        const select = document.getElementById("rutas");
        select.innerHTML = `<option value="-1">Selecciona una ruta</option>`; // Opción inicial

        // Añadir cada ruta como opción
        for (let i = 0; i < datos.length; i++) {
            const ruta = datos[i];
            const option = document.createElement("option");
            option.value = ruta.id;       // ID de la ruta
            option.textContent = ruta.archivo; // Nombre del archivo
            select.appendChild(option);   // Añadir al select
        }
    });
}

// --- Seleccionar ruta del select ---
function cargarTabla() {
    const idRuta = this.value;
    if (idRuta == -1) { // Si no se selecciona ruta
        document.getElementById("cuerpoTabla").innerHTML = ""; // Limpiar tabla
        document.getElementById("distanciaTotal").textContent = "0 km";
        return;
    }
    cargarDetalleRuta(idRuta); // Cargar puntos de la ruta seleccionada
}

// --- Cargar puntos de la ruta y calcular distancia ---
function cargarDetalleRuta(idRuta) {
    fetch("servidor.php", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ servicio: "detalleRuta", idRuta }) // Solicitar detalle
    })
    .then(r => r.json())
    .then(puntos => {
        const tbody = document.getElementById("cuerpoTabla");
        tbody.innerHTML = "";

        let listaCoordenadas = [];
        let distanciaTotal = 0;

        // Agregar cada punto a la tabla
        for (let i = 0; i < puntos.length; i++) {
            const punto = puntos[i];
            const tr = document.createElement("tr");
            tr.innerHTML = `<td>${i + 1}</td><td>${punto.lat}</td><td>${punto.lng}</td>`;
            tbody.appendChild(tr);

            listaCoordenadas.push({ lat: parseFloat(punto.lat), lng: parseFloat(punto.lng) });
        }

        // Calcular distancia total usando Google Maps
        for (let i = 0; i < listaCoordenadas.length - 1; i++) {
            const p1 = new google.maps.LatLng(listaCoordenadas[i].lat, listaCoordenadas[i].lng);
            const p2 = new google.maps.LatLng(listaCoordenadas[i + 1].lat, listaCoordenadas[i + 1].lng);
            distanciaTotal += google.maps.geometry.spherical.computeDistanceBetween(p1, p2);
        }

        // Mostrar distancia total en km
        document.getElementById("distanciaTotal").textContent = (distanciaTotal / 1000).toFixed(2) + " km";

        // Dibujar la ruta en el mapa
        dibujarRuta(listaCoordenadas);
    });
}

// --- Borrar ruta ---
function borrarRuta() {
    const select = document.getElementById("rutas");
    const idRuta = select.value;
    if (idRuta == -1) { // Comprobar que se ha seleccionado una ruta
        alert("Selecciona una ruta para borrarla");
        return;
    }

    if (!confirm("¿Seguro que quiere borrar la ruta seleccionada?")) return;

    fetch("servidor.php", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ servicio: "borrarRuta", idRuta }) // Enviar petición de borrado
    })
    .then(r => r.json())
    .then(respuesta => {
        if (respuesta === true) { // Si se borró correctamente
            cargarRutas();                     // Actualizar lista
            document.getElementById("cuerpoTabla").innerHTML = ""; // Limpiar tabla
            document.getElementById("distanciaTotal").textContent = "0 km"; // Reiniciar distancia
        } else {
            alert("Error al borrar la ruta"); // Mensaje de error
        }
    });
}
