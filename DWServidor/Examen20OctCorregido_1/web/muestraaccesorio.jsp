
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.disfracesPepito.modelo.Accesorio" %>

<h2>Listado de accesorios</h2>
<ul>
<%
    Accesorio a = (Accesorio) request.getAttribute("accesorio");
    if (a != null) {
     
%>
            <li><strong><%= a.getNombre() %></strong> - <%= a.getPrecio() %></li>
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