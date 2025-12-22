<?php
header('Content-Type: application/json');

$host = "localhost";
$dbname = "ajax";
$user = "root";
$pass = "";

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch(PDOException $e) {
    echo json_encode(["error" => $e->getMessage()]);
    exit;
}

// Recibir JSON
$input = json_decode(file_get_contents("php://input"), true);
$servicio = $input['servicio'] ?? '';

switch($servicio) {

    case "departamentos":
        $stmt = $pdo->query("SELECT * FROM departamentos2");
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    case "anadeDepto":
        $stmt = $pdo->prepare("INSERT INTO departamentos2 (nombre, descripcion) VALUES (?, ?)");
        $stmt->execute([$input['nombre'], $input['descripcion']]);
        // Devolver todos los departamentos actualizados
        $stmt = $pdo->query("SELECT * FROM departamentos2");
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    case "empleados":
        $stmt = $pdo->prepare("SELECT * FROM empleados WHERE id_departamento = ?");
        $stmt->execute([$input['id_departamento']]);
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    case "anadeEmpleado":
        $stmt = $pdo->prepare("INSERT INTO empleados (id_departamento, dni, nombre, apellidos) VALUES (?, ?, ?, ?)");
        $stmt->execute([$input['id_departamento'], $input['dni'], $input['nombre'], $input['apellidos']]);
        // Devolver empleados del departamento
        $stmt = $pdo->prepare("SELECT * FROM empleados WHERE id_departamento = ?");
        $stmt->execute([$input['id_departamento']]);
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    case "modificaEmpleado":
        $stmt = $pdo->prepare("UPDATE empleados SET dni=?, nombre=?, apellidos=?, id_departamento=? WHERE id=?");
        $stmt->execute([$input['dni'], $input['nombre'], $input['apellidos'], $input['id_departamento'], $input['id']]);
        $stmt = $pdo->prepare("SELECT * FROM empleados WHERE id_departamento = ?");
        $stmt->execute([$input['id_departamento']]);
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    case "selEmpleadoID":
        $stmt = $pdo->prepare("SELECT * FROM empleados WHERE id = ?");
        $stmt->execute([$input['id']]);
        echo json_encode($stmt->fetch(PDO::FETCH_ASSOC));
        break;

    case "eliminaEmpleado":
        $stmt = $pdo->prepare("DELETE FROM empleados WHERE id = ?");
        $stmt->execute([$input['id']]);
        $stmt = $pdo->prepare("SELECT * FROM empleados WHERE id_departamento = ?");
        $stmt->execute([$input['id_departamento']]);
        echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
        break;

    default:
        echo json_encode(["error" => "Servicio no definido"]);
}
?>
