<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado cuestionario</title>
    </head>
    <body>
        <h3>Puntuación.</h3>
        <p>
            Has obtenido
            <%
                int puntos = 0;
                puntos += Integer.parseInt(request.getParameter("p1"));
                puntos += Integer.parseInt(request.getParameter("p2"));
                puntos += Integer.parseInt(request.getParameter("p3"));
                out.print(puntos);
            %>
            puntos.
        </p>
    </body>
</html>
