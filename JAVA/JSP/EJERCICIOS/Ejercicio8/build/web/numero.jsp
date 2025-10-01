<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla de multiplicar</title>
    </head>
    <body>
        <h3>Tabla.</h3>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td>Operacion</td>
                <td>Resultado</td>
            </tr>  
            <%
                int mul = Integer.parseInt(request.getParameter("numeroIntro"));
                for (int i = 0; i <= 10; i++) {
                    out.println("<tr>");
                    out.println("<td>" + mul + " * " + i + "</td>");
                    out.println("<td>" + (i*mul) + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
