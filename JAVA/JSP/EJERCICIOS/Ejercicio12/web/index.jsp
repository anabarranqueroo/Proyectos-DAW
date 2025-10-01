<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario de Calendario</title>
</head>
<body>
    <h2>Generar Calendario</h2>
    <form action="calendario.jsp" method="GET">
        <label for="anyo">Año:</label>
        <input type="number" id="anyo" name="anyo" required>
        <br><br>
        <label for="mes">Mes:</label>
        <select id="mes" name="mes" required>
            <option value="1">Enero</option>
            <option value="2">Febrero</option>
            <option value="3">Marzo</option>
            <option value="4">Abril</option>
            <option value="5">Mayo</option>
            <option value="6">Junio</option>
            <option value="7">Julio</option>
            <option value="8">Agosto</option>
            <option value="9">Septiembre</option>
            <option value="10">Octubre</option>
            <option value="11">Noviembre</option>
            <option value="12">Diciembre</option>
        </select>
        <br><br>
        <input type="submit" value="Generar Calendario">
    </form>
</body>
</html>
