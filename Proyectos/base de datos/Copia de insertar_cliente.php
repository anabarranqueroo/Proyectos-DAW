<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <link rel="stylesheet" href="insertarphp.css">
</head>
<body>
<?php
  $conexion = mysqli_connect("localhost", "root", "", "tienda") or
    die("Problemas con la conexión");

  $DNI = $_REQUEST['DNI'];
  $Nombre = $_REQUEST['Nombre'];
  $Apellidos = $_REQUEST['Apellidos'];
  $Edad = $_REQUEST['Edad'];
  $Telefono = $_REQUEST['Telefono'];
  $Correo = $_REQUEST['Correo'];
  $Direccion = $_REQUEST['Direccion'];

  mysqli_query($conexion, "INSERT INTO cliente (DNI, Nombre, Apellidos, Edad, Telefono, Correo, Direccion)
                           VALUES ('$DNI', '$Nombre', '$Apellidos', '$Edad', '$Telefono', '$Correo', '$Direccion')")
    or die("Problemas en el insert: " . mysqli_error($conexion));

  mysqli_close($conexion);

  echo "El cliente fue dado de alta.";
  ?>
</body>
</html>