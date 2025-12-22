<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.disfracesPepito.modelo.Accesorio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Listado de Accesorios</h2>
        <ul>
            <%
                List<Accesorio>accesorios = (List<Accesorio>) request.getAttribute("accesorios");
                if(accesorios != null && !accesorios.isEmpty()){
                    for(Accesorio ac : accesorios){
            %>
            <li><strong><%= ac.getNombre() %></strong>: <%= ac.getPrecio() %>€</li>

            <%
               }
               }else{
            %>
            <li>No hay accesorios disponibles.</li>
                <%
                    }
                %>
        </ul>
        <a href="index.html">Volver al indice.</a>

    </body>
</html>

