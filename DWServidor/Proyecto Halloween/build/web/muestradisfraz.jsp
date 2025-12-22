<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.disfracesPepito.modelo.Disfraz" %>
<%@ page import="com.disfracesPepito.modelo.Disponibilidad" %>
<%@ page import="com.disfracesPepito.modelo.Talla" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Disfraces</h2>
        <ul>
            <%
                Disfraz d = (Disfraz) request.getAttribute("disfraz");
                if(d != null){
                
                %>
                <li><%= d.getDescripcion() %><br><%= d.getPrecio() %>€<br><%= d.getTalla() %><br><%= d.getD() %></li>
             <%
                }else{
            %>
                <li>No hay disfraces disponibles.</li>
                <%
                    }
                    %>
        </ul>
        <br><a href='index.html'>Volver al indice</a>
        <br><a href='nuevodisfrazseguro2.html'>Introduce otro disfraz</a>
    </body>
</html>
