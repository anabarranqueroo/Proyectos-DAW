<?php
function Conectar($bd, $usuario, $clave) {
    try {
        $conn = new PDO('mysql:host=localhost;dbname='.$bd, $usuario, $clave);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $conn;
    } catch (PDOException $e) {
        die("Error de conexión: " . $e->getMessage());
    }
}

function Conectar2($bd, $usuario, $clave) {
    try {
        $opciones = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
        $conn = new PDO('mysql:host=localhost;dbname='.$bd, $usuario, $clave, $opciones);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $conn;
    } catch (PDOException $e) {
        die("No se pudo conectar a la base de datos. " . $e->getMessage());
    }
}
?>
