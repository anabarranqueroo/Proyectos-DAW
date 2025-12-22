<%@ page import="java.util.*, com.disfracesPepito.modelo.Disfraz, com.disfracesPepito.modelo.Talla, com.disfracesPepito.modelo.Disponibilidad" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Gestor de Disfraces Black Friday</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .ok {
                background:#e9f9ee;
                border:1px solid #2ecc71;
                padding:8px;
            }
            .err {
                background:#fdecea;
                border:1px solid #e74c3c;
                padding:8px;
                white-space: pre-wrap;
            }
            table {
                border-collapse: collapse;
                width: 100%;
                margin-top:15px;
            }
            th, td {
                border:1px solid #ccc;
                padding:6px 10px;
                text-align:left;
            }
            fieldset {
                margin-top:20px;
            }
            input, select {
                padding:5px;
            }
        </style>
    </head>
    <body>
        <h1>🎭 Gestor de Disfraces</h1>

        <p><a href="index.jsp">Inicio</a></p>

        <%
        String msgOk = request.getParameter("msgOk");
        if (msgOk != null) {
        %>
        <div class="ok">Operación realizada correctamente.</div>
        <%
        }
        String msgOkAttr = (String) request.getAttribute("msgOk");
        if (msgOkAttr != null) {
        %>
        <div class="ok"><%= msgOkAttr %></div>
        <%
        }
        String msgErr = (String) request.getAttribute("msgErr");
        if (msgErr != null) {
        %>
        <div class="err"><%= msgErr %></div>
        <%
        }
        %>

        <!-- Filtro -->
        <form method="get" action="DisfrazServlet">
            <fieldset>
                <legend>Filtrar</legend>
                Categoría: 
                <input type="text" name="categoria" value="<%= request.getAttribute("f_categoria")!=null?request.getAttribute("f_categoria"):"" %>"/>
                &nbsp;&nbsp;
                <label><input type="checkbox" name="activos" <%= request.getAttribute("f_activos")!=null?request.getAttribute("f_activos"):"" %>/> Solo activos hoy</label>
                &nbsp;&nbsp;
                <button type="submit">Aplicar</button>
                <a href="DisfrazServlet">Limpiar</a>
            </fieldset>
        </form>

        <%
        List<Disfraz> lista = (List<Disfraz>) request.getAttribute("listaDisfraces");
        if (lista != null && !lista.isEmpty()) {
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Precio (€)</th>
                <th>Desc. (%)</th>
                <th>Precio Final (€)</th>
                <th>Categoría</th>
                <th>Talla</th>
                <th>Disponibilidad</th>
                <th>Inicio</th>
                <th>Fin</th>
                <th>Acciones</th>
            </tr>
            <%
            for (Disfraz d : lista) {
            %>
            <tr>
                <td><%= d.getId() %></td>
                <td><%= d.getDescripcion() %></td>
                <td><%= String.format("%.2f", d.getPrecio()) %></td>
                <td><%= d.getDescuento() %></td>
                <td><%= String.format("%.2f", d.getPrecioFinal()) %></td>
                <td><%= d.getCategoria()!=null?d.getCategoria():"" %></td>
                <td><%= d.getTalla()!=null?d.getTalla().name():"" %></td>
                <td><%= d.getD()!=null?d.getD().name():"" %></td>
                <td><%= d.getFecha_inicio()!=null?d.getFecha_inicio().toString():"" %></td>
                <td><%= d.getFecha_fin()!=null?d.getFecha_fin().toString():"" %></td>
                <td>
                    <form method="get" action="DisfrazServlet" style="display:inline;">
                        <input type="hidden" name="accion" value="editar"/>
                        <input type="hidden" name="id" value="<%= d.getId() %>"/>
                        <button type="submit">Editar</button>
                    </form>
                    <form method="get" action="DisfrazServlet" onsubmit="return confirm('¿Eliminar disfraz ID <%= d.getId() %>?');" style="display:inline;">
                        <input type="hidden" name="accion" value="eliminar"/>
                        <input type="hidden" name="id" value="<%= d.getId() %>"/>
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
            <%
            }
            %>
        </table>
        <%
        } else {
        %>
        <p>No hay disfraces para los filtros actuales.</p>
        <%
        }
        %>

        <hr>
        <h2>Agregar nuevo disfraz</h2>
        <form method="post" action="DisfrazServlet">
            <label>Descripción:</label><br>
            <input type="text" name="descripcion" value="<%= request.getAttribute("prev_descripcion")!=null?request.getAttribute("prev_descripcion"):"" %>" required><br><br>

            <label>Precio (€):</label><br>
            <input type="number" step="0.01" name="precio" value="<%= request.getAttribute("prev_precio")!=null?request.getAttribute("prev_precio"):"" %>" required><br><br>

            <label>Descuento (% 0–90):</label><br>
            <input type="number" min="0" max="90" name="descuento" value="<%= request.getAttribute("prev_descuento")!=null?request.getAttribute("prev_descuento"):"" %>" required><br><br>

            <label>Categoría:</label><br>
            <input type="text" name="categoria" value="<%= request.getAttribute("prev_categoria")!=null?request.getAttribute("prev_categoria"):"" %>"><br><br>

            <label>Talla:</label><br>
            <select name="talla" required>
                <% for (Talla t : Talla.values()) { %>
                <option value="<%= t.name() %>"><%= t.name() %></option>
                <% } %>
            </select><br><br>

            <label>Disponibilidad:</label><br>
            <select name="disponibilidad" required>
                <% for (Disponibilidad disp : Disponibilidad.values()) { %>
                <option value="<%= disp.name() %>"><%= disp.name() %></option>
                <% } %>
            </select><br><br>

            <label>Fecha inicio:</label><br>
            <input type="date" name="fecha_inicio" value="<%= request.getAttribute("prev_fi")!=null?request.getAttribute("prev_fi"):"" %>" required><br><br>

            <label>Fecha fin:</label><br>
            <input type="date" name="fecha_fin" value="<%= request.getAttribute("prev_ff")!=null?request.getAttribute("prev_ff"):"" %>" required><br><br>

            <input type="hidden" name="accion" value="insertar"/>
            <button type="submit">Registrar disfraz</button>
        </form>

    </body>
</html>
