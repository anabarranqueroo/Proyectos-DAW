<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cursosUniversitarios.modelo.Curso" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Listado de Crusos universitarios</h2>
        <ul>
            <%
                List<Curso>cursos = (List<Curso>) request.getAttribute("cursos");
                if(cursos != null && !cursos.isEmpty()){
                    for(Curso c : cursos){
                %>
                <li><strong>Nombre del curso: </strong> <%= c.getNombre() %> <br><strong> Profesor responsable: </strong><%= c.getProfesor() %><br>
                <strong> Duración en horas:  </strong><%= c.getDuracion() %><br><strong> Número de plazas disponibles: </strong><%= c.getPlazas() %><br>
                <strong> Modalidad: </strong><%= c.getModalidad() %></li>
                <br><br>
                <a href="index.html">Introducir otro curso Universitario.</a>
             <%
                }
                }else{
            %>
                <li>No hay cursos disponibles.</li>
                <%
                    }
                    %>
        </ul>

    </body>
</html>
