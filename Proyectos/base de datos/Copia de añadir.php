<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Añadir</title>
    <link rel="stylesheet" href="añadirphp.css">
</head>
<body>
<?php
$conexion = new mysqli("localhost", "root", "", "tienda") or die("Problemas con la conexión");


    $codigo = $_POST['codigo'];
    $nombre = $_POST['nombre'];
    $precio = $_POST['precio'];
    $categoria = $_POST['categoria'] ?? null;
    $stock = $_POST['stock'];
    $fabricante = $_POST['fabricante'] ?? null;

    mysqli_query($conexion,"INSERT INTO producto (Codigo, Nombre, Precio, Categoria, Stock, IdFabricante)
            VALUES ($codigo, '$nombre', $precio, '$categoria', $stock, $fabricante)")
            or die("Problemas en el insert: " . mysqli_error($conexion));
    mysqli_close($conexion);
    echo "El producto ha sido añadido correctamente.";
?>
</body>
</html>