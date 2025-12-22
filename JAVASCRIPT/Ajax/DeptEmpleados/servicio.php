<?php
header('Content-Type: application/json');

$conn = conectar("ajax", "root", "");

// Leer datos enviados desde fetch
$datos = file_get_contents('php://input');
$objeto = json_decode($datos);

if ($objeto != null) {
    switch ($objeto->servicio) {
        case "departamentos":
            echo json_encode(listarDepartamentos());
            break;

        case "anadeDepto":
            anadirDepto($objeto);
            echo json_encode(listarDepartamentos());
            break;

        case "empleados":
            echo json_encode(listarEmpleados($objeto->id_departamento));
            break;

        case "anadeEmpleado":
            anadirEmpleado($objeto);
            echo json_encode(listarEmpleados($objeto->id_departamento));
            break;

        case "modificaEmpleado":
            modificarEmpleado($objeto);
            echo json_encode(listarEmpleados($objeto->id_departamento));
            break;

        case "eliminaEmpleado":
            eliminarEmpleado($objeto->id, $objeto->id_departamento);
            echo json_encode(listarEmpleados($objeto->id_departamento));
            break;

        case "selEmpleadoID":
            echo json_encode(seleccionarEmpleadoID($objeto->id));
            break;
    }
}

// --- Funciones ---
function listarDepartamentos() {
    global $conn;
    $stmt = $conn->prepare("SELECT * FROM departamentos2");
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

function anadirDepto($obj) {
    global $conn;
    $stmt = $conn->prepare("INSERT INTO departamentos2(nombre, descripcion) VALUES (?, ?)");
    $stmt->execute([$obj->nombre, $obj->descripcion]);
}

function listarEmpleados($idDept) {
    global $conn;
    $stmt = $conn->prepare("SELECT * FROM empleados WHERE id_departamento = ?");
    $stmt->execute([$idDept]);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

function anadirEmpleado($obj) {
    global $conn;
    $stmt = $conn->prepare("INSERT INTO empleados(id_departamento, dni, nombre, apellidos) VALUES (?, ?, ?, ?)");
    $stmt->execute([$obj->id_departamento, $obj->dni, $obj->nombre, $obj->apellidos]);
}

function modificarEmpleado($obj) {
    global $conn;
    $stmt = $conn->prepare("UPDATE empleados SET dni = ?, nombre = ?, apellidos = ? WHERE id = ?");
    $stmt->execute([$obj->dni, $obj->nombre, $obj->apellidos, $obj->id]);
}

function eliminarEmpleado($id, $idDept) {
    global $conn;
    $stmt = $conn->prepare("DELETE FROM empleados WHERE id = ?");
    $stmt->execute([$id]);
}

function seleccionarEmpleadoID($id) {
    global $conn;
    $stmt = $conn->prepare("SELECT * FROM empleados WHERE id = ?");
    $stmt->execute([$id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

function conectar($bd, $usuario, $clave) {
    try {
        $opciones = [PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"];
        $conn = new PDO("mysql:host=localhost;dbname=$bd", $usuario, $clave, $opciones);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $conn;
    } catch (PDOException $e) {
        die("Error al conectar: " . $e->getMessage());
    }
}
?>
