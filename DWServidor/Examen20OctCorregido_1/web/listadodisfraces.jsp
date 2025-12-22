<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
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
        <h2>Listado de Disfraces</h2>
        <ul>
            <%
                List<Disfraz>disfraces = (List<Disfraz>) request.getAttribute("disfraces");
                if(disfraces != null && !disfraces.isEmpty()){
                    for(Disfraz d : disfraces){
            %>
            <li><strong><%= d.getDescripcion() %></strong>: <br><%= d.getPrecio() %>€ <br><%= d.getTalla() %><br><%= d.getD() %></li><br>

            <%
               }
               }else{
            %>
            <li>No hay disfraces disponibles.</li>
                <%
                    }
                %>
        </ul>
        <a href="index.html">Volver al indice.</a>

    </body>
</html>

