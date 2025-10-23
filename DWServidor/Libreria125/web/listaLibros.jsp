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
                <li><strong>Titulo:</strong> <%= l.getTitulo() %> <strong> Autor:</strong><%= l.getAutor() %>
                <strong> Precio: </strong><%= l.getPrecio() %><strong> Número de páginas: </strong><%= l.getPaginas() %>
                <strong> Género: </strong><%= l.getGenero() %></li>
                <br><br>
                <a href="index.html">Introducir otro libro.</a>
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
