<?php
header("Content-Type: application/json");

$conn = conectar("proyectoGpx", "root", "");

$input = file_get_contents("php://input");
$obj = json_decode($input);

// Servicios
if ($obj) {
    switch ($obj->servicio) {

        case "listarRutas":
            listarRutas();
            break;

        case "detalleRuta":
            detalleRuta($obj->idRuta);
            break;

        case "borrarRuta":
            borrarRuta($obj->idRuta);
            break;


        case "anadirRuta":
            anadirRuta($obj);
            listarRutas();
            break;
    }
}

// ---- SERVICIOS ----

function listarRutas()
{
    global $conn;
    $rs = $conn->query("SELECT * FROM rutas ORDER BY fecha DESC");
    echo json_encode($rs->fetchAll(PDO::FETCH_ASSOC));
}


function detalleRuta($idRuta)
{
    global $conn;
    $rs = $conn->query("SELECT * FROM puntos WHERE id_ruta = $idRuta ORDER BY id");
    echo json_encode($rs->fetchAll(PDO::FETCH_ASSOC));
}

function borrarRuta($idRuta)
{
    global $conn;

    // borrar puntos
    $conn->query("DELETE FROM puntos WHERE id_ruta = $idRuta");

    // borrar ruta
    $conn->query("DELETE FROM rutas WHERE id = $idRuta");

    echo json_encode(true);
}



function anadirRuta($obj)
{
    global $conn;

    $nombre = isset($obj->nombre) ? $obj->nombre : $obj->archivo;
    $fecha = isset($obj->fecha) ? $obj->fecha : date("Y-m-d");

    // Insertar ruta
    $sql = "INSERT INTO rutas (nombre, fecha, archivo) VALUES (?, ?, ?)";
    $stm = $conn->prepare($sql);
    $stm->execute([$nombre, $fecha, $obj->archivo]);


    $idRuta = $conn->lastInsertId();

    // Insertar puntos si vienen desde JS
    if (isset($obj->puntos)) {
        foreach ($obj->puntos as $p) {
            $lat = floatval($p->lat);
            $lng = floatval($p->lng);
            $conn->query("INSERT INTO puntos (id_ruta, lat, lng) VALUES ($idRuta, $lat, $lng)");
        }
    }
}

// ---- CONEXIÓN ----
function conectar($bd, $user, $pass)
{
    try {
        $db = new PDO("mysql:host=localhost;dbname=$bd;charset=utf8", $user, $pass);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $db;
    } catch (Exception $e) {
        die("Error DB: " . $e->getMessage());
    }
}
?>