<html>

<head>
  <title>Modificacion de producto</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="Modifica.css"/>
</head>

<body>

  <?php

  $conexion = mysqli_connect("localhost", "root", "", "tienda") or
    die("Problemas con la conexión");

  $registros = mysqli_query($conexion, "select * from producto
                        where Codigo='$_REQUEST[Codigo]'") or
    die("Problemas en el select:" . mysqli_error($conexion));
  if ($reg = mysqli_fetch_array($registros)) {
    ?>
	<div class="container">
	<h2>Modificar precio del producto: <?php echo $reg['Nombre']; ?></h2>
    <form action="modifica2.php" method="post">
      <label>Ingrese un nuevo precio para el producto:
      <input type="text" name="precio_nuevo" value="<?php echo $reg['Precio'] ?>">
      </label>
      <input type="hidden" name="Codigo" value="<?php echo $reg['Codigo'] ?>">
      <button type="submit" value="Modificar">Modificar</button>
    </form>
	</div>
  <?php
  } else
    echo "No existe producto con dicho código";
  ?>
</body>

</html>