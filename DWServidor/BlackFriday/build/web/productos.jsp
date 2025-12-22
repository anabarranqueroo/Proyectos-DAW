<%@ page import="java.util.*, com.blackfriday.modelo.Producto" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Gestor de Ofertas Black Friday</title>
<style>
  body { font-family: Arial, sans-serif; }
  .ok { background:#e9f9ee; border:1px solid #2ecc71; padding:8px; }
  .err { background:#fdecea; border:1px solid #e74c3c; padding:8px; white-space: pre-wrap; }
  table { border-collapse: collapse; width: 100%; }
  th, td { border:1px solid #ccc; padding:6px 10px; text-align:left; }
</style>
</head>
<body>
<h1>🛍️ Black Friday Manager</h1>

<p><a href="index.jsp">Inicio</a></p>

<% String msgOk = request.getParameter("msgOk");
   if (msgOk != null) { %>
<div class="ok">Operación realizada correctamente.</div>
<% } %>
<% String msgOkAttr = (String) request.getAttribute("msgOk");
   if (msgOkAttr != null) { %>
<div class="ok"><%= msgOkAttr %></div>
<% } %>
<% String msgErr = (String) request.getAttribute("msgErr");
   if (msgErr != null) { %>
<div class="err"><%= msgErr %></div>
<% } %>

<!-- Filtro -->
<form method="get" action="ProductoServlet">
  <fieldset>
    <legend>Filtrar</legend>
    Categoría: <input type="text" name="categoria" value="<%= request.getAttribute("f_categoria")!=null?request.getAttribute("f_categoria"):"" %>"/>
    &nbsp;&nbsp;
    <label><input type="checkbox" name="activos" <%= request.getAttribute("f_activos")!=null?request.getAttribute("f_activos"):"" %>/> Solo activos hoy</label>
    &nbsp;&nbsp;
    <button type="submit">Aplicar</button>
    <a href="ProductoServlet">Limpiar</a>
  </fieldset>
</form>

<%
    List<Producto> lista = (List<Producto>) request.getAttribute("listaProductos");
    if (lista != null && !lista.isEmpty()) {
%>
<table>
<tr>
  <th>ID</th><th>Nombre</th><th>Precio (€)</th><th>Desc. (%)</th>
  <th>Precio Final (€)</th><th>Categoría</th><th>Inicio</th><th>Fin</th><th>Acciones</th>
</tr>
<%
  for (Producto p : lista) {
%>
<tr>
  <td><%= p.getId() %></td>
  <td><%= p.getNombre() %></td>
  <td><%= String.format("%.2f", p.getPrecio()) %></td>
  <td><%= p.getDescuento() %></td>
  <td><%= String.format("%.2f", p.getPrecioFinal()) %></td>
  <td><%= p.getCategoria()!=null?p.getCategoria():"" %></td>
  <td><%= p.getFechaInicio()!=null?p.getFechaInicio().toString():"" %></td>
  <td><%= p.getFechaFin()!=null?p.getFechaFin().toString():"" %></td>
  <td>
    <form method="get" action="ProductoServlet" style="display:inline;">
      <input type="hidden" name="accion" value="editar"/>
      <input type="hidden" name="id" value="<%= p.getId() %>"/>
      <button type="submit">Editar</button>
    </form>
    <form method="get" action="ProductoServlet" onsubmit="return confirm('¿Eliminar oferta ID <%=p.getId()%>?');" style="display:inline;">
      <input type="hidden" name="accion" value="eliminar"/>
      <input type="hidden" name="id" value="<%= p.getId() %>"/>
      <button type="submit">Eliminar</button>
    </form>
  </td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No hay ofertas para los filtros actuales.</p>
<% } %>

<hr>
<h2>Agregar nueva oferta</h2>
<form method="post" action="ProductoServlet">
  <label>Nombre:</label><br>
  <input type="text" name="nombre" value="<%= request.getAttribute("prev_nombre")!=null?request.getAttribute("prev_nombre"):"" %>" required><br><br>

  <label>Precio (€):</label><br>
  <input type="number" step="0.01" name="precio" value="<%= request.getAttribute("prev_precio")!=null?request.getAttribute("prev_precio"):"" %>" required><br><br>

  <label>Descuento (% 1–90):</label><br>
  <input type="number" min="1" max="90" name="descuento" value="<%= request.getAttribute("prev_descuento")!=null?request.getAttribute("prev_descuento"):"" %>" required><br><br>

  <label>Categoría:</label><br>
  <input type="text" name="categoria" value="<%= request.getAttribute("prev_categoria")!=null?request.getAttribute("prev_categoria"):"" %>"><br><br>

  <label>Fecha inicio:</label><br>
  <input type="date" name="fecha_inicio" value="<%= request.getAttribute("prev_fi")!=null?request.getAttribute("prev_fi"):"" %>" required><br><br>

  <label>Fecha fin:</label><br>
  <input type="date" name="fecha_fin" value="<%= request.getAttribute("prev_ff")!=null?request.getAttribute("prev_ff"):"" %>" required><br><br>

  <input type="hidden" name="accion" value="insertar"/>
  <button type="submit">Registrar oferta</button>
</form>

</body>
</html>