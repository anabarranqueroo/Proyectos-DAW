<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Piramide</title>
    </head>
    <body>
        <%
            int altura = 1;
            int i = 0;
            int alt = Integer.parseInt(request.getParameter("alturaIntro"));
            int espacios = alt - 1;
            while (altura <= alt){
                for(i=0; i<=espacios; i++){
                    out.print("<img src=\"espacio.jpg\" width=\"50\" height=\"50\">");
                }
                for(i=1; i<altura * 2; i++){
                    out.print("<img src=\"ladrillo.jpg\" width=\"50\" height=\"50\">");
                }
                out.println("<br>");
                altura++;
                espacios--;
            }
        %>
    </body>
</html>
