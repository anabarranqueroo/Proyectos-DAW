<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Calendario</title>
</head>
<body>
    <h2>
        <%
            String anyo = request.getParameter("anyo");
            String mes = request.getParameter("mes");

            int anio = Integer.parseInt(anyo);
            int mesInt = Integer.parseInt(mes) - 1; 
            Calendar calendar = Calendar.getInstance();
            calendar.set(anio, mesInt, 1); 
            int primerDiaSemana = calendar.get(Calendar.DAY_OF_WEEK);

            int diasEnMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            out.println("<h3>Calendario " + anyo + "</h3>");
        %>
    </h2>
    <br>
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td>Lunes</td>
            <td>Martes</td>
            <td>Miércoles</td>
            <td>Jueves</td>
            <td>Viernes</td>
            <td>Sábado</td>
            <td>Domingo</td>
        </tr>
        <%
            int dia = 1;
            int diaSemana = primerDiaSemana - 1;
            int diasRestantes = diasEnMes;

            out.print("<tr>");
            for (int i = 0; i < 7; i++) {
                if (i < diaSemana) {
                    out.print("<td></td>");
                } else {
                    if (dia <= diasEnMes) {
                        out.print("<td>" + dia + "</td>");
                        dia++;
                    } else {
                        out.print("<td></td>");
                    }
                }
            }
            out.print("</tr>");

            while (dia <= diasEnMes) {
                out.print("<tr>");
                for (int i = 0; i < 7; i++) {
                    if (dia <= diasEnMes) {
                        out.print("<td>" + dia + "</td>");
                        dia++;
                    } else {
                        out.print("<td></td>");
                    }
                }
                out.print("</tr>");
            }
        %>
    </table>
</body>
</html>
