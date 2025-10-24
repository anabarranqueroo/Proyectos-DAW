<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.disfracesPepito.modelo.Accesorio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Accesorios</h2>
        <ul>
            <%
                Accesorio ac = (Accesorio) request.getAttribute("accesorio");
                if(ac != null){
                
                %>
                <li><strong><%= ac.getNombre() %></strong>:<%= ac.getPrecio() %>€</li>
             <%
                }else{
            %>
                <li>No hay accesorios disponibles.</li>
                <%
                    }
                    %>
        </ul>
        <br><a href='index.html'>Volver al indice</a>
        <br><a href='nuevoaccesorioseguro2.html'>Introduce otro accesorio</a>
    </body>
</html>
