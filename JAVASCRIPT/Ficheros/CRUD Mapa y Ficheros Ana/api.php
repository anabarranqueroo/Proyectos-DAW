<?php
// api.php

// Forzar siempre salida JSON
header('Content-Type: application/json');

// Desactivar warnings/notices que rompan el JSON
error_reporting(E_ALL & ~E_NOTICE & ~E_WARNING);

include("conexion.php");
$conn = Conectar2("rutas", "root", "");

// Inicializamos la respuesta
$respuesta = [];

try {
    $datos = file_get_contents('php://input');
    $objeto = json_decode($datos);

    if ($objeto != null && isset($objeto->servicio)) {
        switch($objeto->servicio) {
            case "listar":
                $respuesta = listarRutas();
            break;

            case "insertar":
                insertarRuta($objeto);
                $respuesta = listarRutas();
            break;

            case "borrar":
                if (isset($objeto->id)) {
                    borrarRuta($objeto->id);
                }
                $respuesta = listarRutas();
            break;

            case "modificar":
                modificarRuta($objeto);
                $respuesta = listarRutas();
            break;

            case "selRutaID":
                if (isset($objeto->id)) {
                    $respuesta = selRutaID($objeto->id);
                } else {
                    $respuesta = [];
                }
            break;

            default:
                $respuesta = ['error' => 'Servicio no reconocido'];
        }
    } else {
        $respuesta = ['error' => 'No se recibió ningún objeto JSON'];
    }
} catch(Exception $e) {
    $respuesta = ['error' => $e->getMessage()];
}

echo json_encode($respuesta, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);


/* ================================
   FUNCIONES
================================ */

function listarRutas() {
    global $conn;
    try {
        $sql = "SELECT * FROM rutas ORDER BY id DESC";
        $stm = $conn->prepare($sql);
        $stm->execute();
        return $stm->fetchAll(PDO::FETCH_ASSOC);
    } catch(Exception $e) {
        return ['error' => $e->getMessage()];
    }
}

function insertarRuta($objeto) {
    global $conn;
    try {
        $sql = "INSERT INTO rutas(nombre, duracion, distancia, velocidad, path)
                VALUES (?, ?, ?, ?, ?)";
        $conn->prepare($sql)->execute([
            $objeto->nombre ?? '',
            $objeto->duracion ?? '',
            $objeto->distancia ?? 0,
            $objeto->velocidad ?? 0,
            json_encode($objeto->path ?? [])
        ]);
        return true;
    } catch(Exception $e) {
        return false;
    }
}

function borrarRuta($id) {
    global $conn;
    try {
        $sql = "DELETE FROM rutas WHERE id = ?";
        $conn->prepare($sql)->execute([$id]);
        return true;
    } catch(Exception $e) {
        return false;
    }
}

function modificarRuta($objeto) {
    global $conn;
    try {
        $sql = "UPDATE rutas SET 
                nombre=?, duracion=?, distancia=?, velocidad=?, path=?
                WHERE id=?";
        $conn->prepare($sql)->execute([
            $objeto->nombre ?? '',
            $objeto->duracion ?? '',
            $objeto->distancia ?? 0,
            $objeto->velocidad ?? 0,
            json_encode($objeto->path ?? []),
            $objeto->id
        ]);
        return true;
    } catch(Exception $e) {
        return false;
    }
}

function selRutaID($id) {
    global $conn;
    try {
        $sql = "SELECT * FROM rutas WHERE id = ?";
        $stm = $conn->prepare($sql);
        $stm->execute([$id]);
        return $stm->fetch(PDO::FETCH_ASSOC);
    } catch(Exception $e) {
        return ['error' => $e->getMessage()];
    }
}
?>
