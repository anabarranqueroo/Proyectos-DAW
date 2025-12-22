<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.disfracesPepito.modelo.Disfraz" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Listado de disfraces</h2>
        <ul>
            <%
                Disfraz d = (Disfraz) request.getAttribute("disfraz");
                if (d != null) {
     
            %>
            <li><strong><%= d.getDescripcion() %></strong> - <%= d.getPrecio() %> - <%= d.getTalla() %> - <%= d.getD() %>
                    <%
       
                        } else {
                             String error = (String) request.getAttribute("error");
                    %>
            <li><h2 style='color:red;'><%= error %> </h2> </li>
                <%
                    }
                %>
        </ul>
        <br><a href='index.html'>Volver a index</a>
    </body>
</html>
