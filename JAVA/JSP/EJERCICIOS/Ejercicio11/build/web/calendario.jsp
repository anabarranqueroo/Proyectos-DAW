<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendario</title>
    </head>
    <body>
        <h2>
            <%
                String texto = request.getParameter("texto");
                out.println(texto);
            %>
        </h2>
        <%
            String anyo = request.getParameter("anyo");
            String mes = request.getParameter("mes");
            out.println(mes + " " + anyo);
        %>
        <br>
        <br>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td>Lunes</td>
                <td>Martes</td>
                <td>Miercoles</td>
                <td>Jueves</td>
                <td>Viernes</td>
                <td>Sabado</td>
                <td>Domingo</td>
            </tr>
            <%
                int f = 1;
                int dias = Integer.parseInt(request.getParameter("dias"));
                String dia1 = request.getParameter("dia1");
               
                switch (dia1) {
                    case "Lunes":
                        for (int i = 1; i <= 5; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Martes":
                        
                        out.print("<td></td>");
                        out.print("<td>" + f + "</td>");
                        out.print("<td>" + (f + 1) + "</td>");
                        out.print("<td>" + (f + 2) + "</td>");
                        out.print("<td>" + (f + 3) + "</td>");
                        out.print("<td>" + (f + 4) + "</td>");
                        out.print("<td>" + (f + 5) + "</td>");
                
                        f=6;
                        for (int i = 1; i <= 4; i++) {
                        

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Miercoles":
                        out.print("<td></td>");
                        out.print("<td> </td>");
                        out.print("<td>" + f + "</td>");
                        out.print("<td>" + (f + 1) + "</td>");
                        out.print("<td>" + (f + 2) + "</td>");
                        out.print("<td>" + (f + 3) + "</td>");
                        out.print("<td>" + (f + 4) + "</td>");
                
                        f=5;
                        for (int i = 1; i <= 4; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Jueves":
                        out.print("<td></td>");
                        out.print("<td> </td>");
                        out.print("<td></td>");
                        out.print("<td>" + f + "</td>");
                        out.print("<td>" + (f + 1) + "</td>");
                        out.print("<td>" + (f + 2) + "</td>");
                        out.print("<td>" + (f + 3) + "</td>");
                
                        f=4;
                        for (int i = 1; i <= 5; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Viernes":
                        out.print("<td></td>");
                        out.print("<td> </td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td>" + f + "</td>");
                        out.print("<td>" + (f + 1) + "</td>");
                        out.print("<td>" + (f + 2) + "</td>");
                
                        f=3;
                        for (int i = 1; i <= 5; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Sabado":
                        out.print("<td></td>");
                        out.print("<td> </td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td>" + f + "</td>");
                        out.print("<td>" + (f + 1) + "</td>");
                
                        f=2;
                        for (int i = 1; i <= 5; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                    case "Domingo":
                        out.print("<td></td>");
                        out.print("<td> </td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td></td>");
                        out.print("<td>"+ f +"</td>");
                
                        f=1;
                        for (int i = 1; i <= 5; i++) {

                            out.print("<tr>");
                            if (f > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + f + "</td>");
                            }
                            if (f + 1 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 1) + "</td>");
                            }

                            if (f + 2 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 2) + "</td>");
                            }

                            if (f + 3 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 3) + "</td>");
                            }
                            if (f + 4 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 4) + "</td>");
                            }
                            if (f + 5 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 5) + "</td>");
                            }
                            if (f + 6 > dias) {
                                out.print("<td></td>");
                            } else {
                                out.print("<td>" + (f + 6) + "</td>");
                            }

                            out.print("</tr>");
                            f = f + 7;

                        }
                        break;
                }


            %>
        </table>
    </body>
</html>
