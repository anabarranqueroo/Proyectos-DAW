<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <link rel="stylesheet" href="mostrar.css">
</head>
<body>
    <h1 class="titulo" >Lista de Productos</h1>

    <table>
        <?php
        $conexion = mysqli_connect("localhost", "root", "", "tienda") or
        die("Problemas con la conexión");

        $resultado = mysqli_query($conexion, "SELECT * FROM producto") 
        or die("Problemas en el select: " . mysqli_error($conexion));
        ?>
        <th>Código</th>
        <th>Nombre</th>
        <?php
        while ($fila = mysqli_fetch_assoc($resultado)) {
            echo "<tr><td>" . $fila['Codigo'] . "</td><td>" . $fila['Nombre'] . "</td></tr>";
        }

        mysqli_close($conexion);
        ?>

    </table>
</body>
</html>
