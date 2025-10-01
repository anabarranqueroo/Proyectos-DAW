<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividad 7</title>
    </head>
    <body>
        <h1>Conversor de pesetas a euros y euros a pesetas</h1>
        <h3>Elige una opcion.</h3>
        <form method="post" action="convertir.jsp">
             <label for="opcion">Selecciona la conversion:</label><br>
             <input type="radio" id="eu_pes" name="opcion" value="eu_pes" checked>
             <label for="eu_pes">Euros a Pesetas</label><br>
             <input type="radio" id="pes_eu" name="opcion" value="pes_eu">
             <label for="pes_eu">Pesetas a Euros</label><br><br>
             <label for="cantidad">Cantidad a convertir:</label><br>
             <input type="number" id="cantidad" name="cantidad"><br><br>
             <input type="submit" value="convertir">
        </form>
        <img src="monedas.png" alt="Conversion de monedas" width="15%" heigth="30%">
    </body>
</html>


