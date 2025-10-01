<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Eliminar</title>
    <link rel="stylesheet" href="eliminarphp.css">
</head>
<body>
<?php
  $conexion = mysqli_connect("localhost", "root", "", "tienda") or
    die("Problemas con la conexión");

  $Codigo = $_POST['Codigo'];
  $Nombre = $_POST['Nombre'];

  mysqli_query($conexion, "DELETE FROM producto WHERE Codigo=$Codigo AND Nombre='$Nombre'")
    or die("Problemas en el delete: " . mysqli_error($conexion));

  mysqli_close($conexion);

  echo "El producto fue eliminado correctamente.";
  ?>
</body>
</html>