<%@ page import="com.blackfriday.modelo.Producto" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Editar oferta</title>
<style>
  body { font-family: Arial, sans-serif; }
  .err { background:#fdecea; border:1px solid #e74c3c; padding:8px; white-space: pre-wrap; }
</style>
</head>
<body>
<h1>Editar oferta</h1>
<p><a href="ProductoServlet">← Volver</a></p>

<% String msgErr = (String) request.getAttribute("msgErr");
   if (msgErr != null) { %>
<div class="err"><%= msgErr %></div>
<% } %>

<%
  Producto p = (Producto) request.getAttribute("producto");
  if (p == null) {
%>
<p>No se encontró la oferta.</p>
<% } else { %>
<form method="post" action="ProductoServlet">
  <input type="hidden" name="accion" value="actualizar"/>
  <input type="hidden" name="id" value="<%= p.getId() %>"/>

  <label>Nombre:</label><br>
  <input type="text" name="nombre" value="<%= p.getNombre() %>" required><br><br>

  <label>Precio (€):</label><br>
  <input type="number" step="0.01" name="precio" value="<%= p.getPrecio() %>" required><br><br>

  <label>Descuento (% 1–90):</label><br>
  <input type="number" min="1" max="90" name="descuento" value="<%= p.getDescuento() %>" required><br><br>

  <label>Categoría:</label><br>
  <input type="text" name="categoria" value="<%= p.getCategoria()!=null?p.getCategoria():"" %>"><br><br>

  <label>Fecha inicio:</label><br>
  <input type="date" name="fecha_inicio" value="<%= p.getFechaInicio()!=null?p.getFechaInicio().toString():"" %>" required><br><br>

  <label>Fecha fin:</label><br>
  <input type="date" name="fecha_fin" value="<%= p.getFechaFin()!=null?p.getFechaFin().toString():"" %>" required><br><br>

  <button type="submit">Guardar cambios</button>
  <a href="ProductoServlet">Cancelar</a>
</form>
<% } %>

</body>
</html>