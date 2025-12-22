<?php
header('Content-Type: application/json');

if (!isset($_GET["servicio"])) return;

$conn = conectar("ajax", "root", "");

$servicio = $_GET["servicio"];

switch ($servicio) {
  case "paises":
    listarPaises();
    break;
  case "ciudades":
    listarCiudades();
    break;
}

function listarPaises() {
  global $conn;
  $rs = $conn->query("SELECT * FROM paises");
  echo json_encode($rs->fetchAll(PDO::FETCH_ASSOC));
}

function listarCiudades() {
  global $conn;
  $cp = isset($_GET["codigop"]) ? $_GET["codigop"] : -1;
  $rs = $conn->query("SELECT * FROM ciudades WHERE CODIGO_PAIS=$cp");
  echo json_encode($rs->fetchAll(PDO::FETCH_ASSOC));
}

function conectar($bd, $usuario, $clave) {
  try {
    $opciones = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
    $bd = new PDO('mysql:host=localhost;dbname=' . $bd, $usuario, $clave, $opciones);
    $bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    return $bd;
  } catch (PDOException $e) {
    echo json_encode(["error" => $e->getMessage()]);
    exit;
  }
}
?>
