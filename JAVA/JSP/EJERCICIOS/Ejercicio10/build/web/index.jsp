<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividad 10</title>
    </head>
    <body>
        <h3>Cuestionario.</h3>
        <form method="post" action="puntuacion.jsp">
            1.¿Que lenguaje estamos dando en Programacion?<br>
            <input type="radio" name="p1" value="0"> Python<br>
            <input type="radio" name="p1" value="1"> Java<br>
            <input type="radio" name="p1" value="0"> C++<br>
            <br>

            2.¿Que lenguaje estamos dando en Base de datos?<br>
            <input type="radio" name="p2" value="1"> SQL<br>
            <input type="radio" name="p2" value="0"> DML<br>
            <input type="radio" name="p2" value="0"> LMML<br>
            <br>

            3.¿Cuantas horas de sostenibilidad echamos en la semana?<br>
            <input type="radio" name="p3" value="0"> 2<br>
            <input type="radio" name="p3" value="1"> 1<br>
            <input type="radio" name="p3" value="0"> 3<br>

            <input type="submit" value="Enviar cuestionario.">
        </form>
    </body>
</html>


