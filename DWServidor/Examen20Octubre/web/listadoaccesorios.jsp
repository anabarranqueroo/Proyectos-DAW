
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.disfracesPepito.modelo.Accesorio" %>

<h2>Listado de accesorios</h2>
<ul>
<%
    List<Accesorio> accesorios = (List<Accesorio>) request.getAttribute("accesorios");
    if (accesorios != null && !accesorios.isEmpty()) {
        for (Accesorio a : accesorios) {
%>
            <li><strong><%= a.getNombre() %></strong> - <%= a.getPrecio() %></li>
<%
        }
    } else {
%>
        <li>No hay accesorios disponibles.</li>
<%
    }
%>
</ul>