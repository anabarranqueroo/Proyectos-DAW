<html>

<head>
    <title>Modificacion de producto</title>
	<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="Modifica2.css"/>
</head>

<body>
    <?php
    $conexion = mysqli_connect("localhost", "root", "", "tienda") or
        die("Problemas con la conexión");

    mysqli_query($conexion, "update producto
                          set Precio='$_REQUEST[precio_nuevo]' 
                        where Codigo='$_REQUEST[Codigo]'") or
        die("Problemas en la modificación:" . mysqli_error($conexion));
    echo "El precio del producto fue modificado con exito";
    ?>
</body>

</html>