<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miempresa.modelo.Receta" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Listado de recetas de cocina</h2>
        <ul>
            <%
                List<Receta>recetas = (List<Receta>) request.getAttribute("recetas");
                if(recetas != null && !recetas.isEmpty()){
                    for(Receta r : recetas){
                %>
                <li><strong>Nombre: </strong> <%= r.getNombre() %> <strong> Chef: </strong><%= r.getChef() %>
                <strong> Tiempo de preparación: </strong><%= r.getTiempo() %><strong> Número de ingredientes: </strong><%= r.getIngredientes() %>
                <strong> Tipo de plato: </strong><%= r.getTipo() %></li>
                <br><br>
                <a href="index.html">Introduce otra receta de cocina.</a>
             <%
                }
                }else{
            %>
                <li>No hay recetas disponibles.</li>
                <%
                    }
                    %>
        </ul>

    </body>
</html>
