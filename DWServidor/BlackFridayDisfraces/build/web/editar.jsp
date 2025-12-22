<%@ page import="com.disfracesPepito.modelo.Disfraz" %>
<%@ page import="com.disfracesPepito.modelo.Talla" %>
<%@ page import="com.disfracesPepito.modelo.Disponibilidad" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Editar disfraz</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 30px;
            }
            .err {
                background:#fdecea;
                border:1px solid #e74c3c;
                padding:8px;
                white-space: pre-wrap;
            }
            label {
                display:block;
                margin-top:10px;
            }
            input, select {
                padding:5px;
                width:250px;
            }
        </style>
    </head>
    <body>
        <h1>Editar disfraz</h1>
        <p><a href="DisfrazServlet">← Volver al listado</a></p>

        <%
        String msgErr = (String) request.getAttribute("msgErr");
        if (msgErr != null) {
        %>
        <div class="err"><%= msgErr %></div>
        <%
        }
        Disfraz d = (Disfraz) request.getAttribute("disfraz");
        if (d == null) {
        %>
        <p>No se encontró el disfraz.</p>
        <%
        } else {
        %>
        <form method="post" action="DisfrazServlet">
            <input type="hidden" name="accion" value="actualizar"/>
            <input type="hidden" name="id" value="<%= d.getId() %>"/>

            <label>Descripción:</label>
            <input type="text" name="descripcion" value="<%= d.getDescripcion() %>" required/>

            <label>Precio (€):</label>
            <input type="number" step="0.01" name="precio" value="<%= d.getPrecio() %>" required/>

            <label>Descuento (% 0–90):</label>
            <input type="number" min="0" max="90" name="descuento" value="<%= d.getDescuento() %>" required/>

            <label>Categoría:</label>
            <input type="text" name="categoria" value="<%= d.getCategoria() != null ? d.getCategoria() : "" %>"/>

            <label>Talla:</label>
            <select name="talla" required>
                <% for (Talla t : Talla.values()) { %>
                <option value="<%= t.name() %>" <%= d.getTalla() == t ? "selected" : "" %>><%= t.name() %></option>
                <% } %>
            </select>

            <label>Disponibilidad:</label>
            <select name="disponibilidad" required>
                <% for (Disponibilidad disp : Disponibilidad.values()) { %>
                <option value="<%= disp.name() %>" <%= d.getD() == disp ? "selected" : "" %>><%= disp.name() %></option>
                <% } %>
            </select>

            <label>Fecha inicio:</label>
            <input type="date" name="fecha_inicio"
                   value="<%= d.getFecha_inicio() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(d.getFecha_inicio()) : "" %>"
                   required/>

            <label>Fecha fin:</label>
            <input type="date" name="fecha_fin"
                   value="<%= d.getFecha_fin() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(d.getFecha_fin()) : "" %>"
                   required/>

            <br><br>
            <button type="submit">Guardar cambios</button>
            <a href="DisfrazServlet">Cancelar</a>
        </form>
        <% } %>

    </body>
</html>
