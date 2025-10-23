<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miempresa.modelo.Libro" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Listado de Libros</h2>
        <ul>
            <%
                List<Libro>libros = (List<Libro>) request.getAttribute("libros");
                if(libros != null && !libros.isEmpty()){
                    for(Libro l : libros){
                %>
                <li><strong><%= l.getTitulo() %></strong><%= l.getAutor() %></li>
             <%
                }
                }else{
            %>
                <li>No hay libros disponibles.</li>
                <%
                    }
                    %>
        </ul>

    </body>
</html>
