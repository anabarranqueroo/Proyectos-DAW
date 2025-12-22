/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.blackfriday.servlet;

import com.blackfriday.dao.ProductoDAO;
import com.blackfriday.modelo.Producto;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    private final ProductoDAO dao = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        try {
            if ("eliminar".equalsIgnoreCase(accion)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.eliminar(id);
                req.setAttribute("msgOk", "Oferta eliminada (ID " + id + ").");
                cargarListado(req);
                req.getRequestDispatcher("productos.jsp").forward(req, resp);
                return;
            }

            if ("editar".equalsIgnoreCase(accion)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Producto p = dao.buscarPorId(id);
                if (p == null) {
                    req.setAttribute("msgErr", "No existe el producto con ID " + id);
                    cargarListado(req);
                    req.getRequestDispatcher("productos.jsp").forward(req, resp);
                } else {
                    req.setAttribute("producto", p);
                    req.getRequestDispatcher("editar.jsp").forward(req, resp);
                }
                return;
            }

            // Listado/filtrado por defecto
            cargarListado(req);
            req.getRequestDispatcher("productos.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("msgErr", "Error: " + e.getMessage());
            cargarListado(req);
            req.getRequestDispatcher("productos.jsp").forward(req, resp);
        }
    }

    private void cargarListado(HttpServletRequest req) {
        String filtroCat = req.getParameter("categoria");
        boolean activos = "on".equalsIgnoreCase(req.getParameter("activos"));
        List<Producto> lista = dao.listarFiltrado(filtroCat, activos);
        req.setAttribute("listaProductos", lista);
        req.setAttribute("f_categoria", filtroCat != null ? filtroCat : "");
        req.setAttribute("f_activos", activos ? "checked" : "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");
        if ("actualizar".equalsIgnoreCase(accion)) {
            actualizar(req, resp);
            return;
        }
        insertar(req, resp);
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Validacion v = validarDesdeRequest(req);
        if (!v.errores.isEmpty()) {
            req.setAttribute("msgErr", v.errores.toString());
            req.setAttribute("prev_nombre", v.nombre);
            req.setAttribute("prev_precio", req.getParameter("precio"));
            req.setAttribute("prev_descuento", req.getParameter("descuento"));
            req.setAttribute("prev_categoria", v.categoria);
            req.setAttribute("prev_fi", req.getParameter("fecha_inicio"));
            req.setAttribute("prev_ff", req.getParameter("fecha_fin"));
            cargarListado(req);
            req.getRequestDispatcher("productos.jsp").forward(req, resp);
            return;
        }
        try {
            dao.insertar(v.producto());
            resp.sendRedirect("ProductoServlet?msgOk=1");
        } catch (Exception e) {
            req.setAttribute("msgErr", "No se pudo insertar: " + e.getMessage());
            cargarListado(req);
            req.getRequestDispatcher("productos.jsp").forward(req, resp);
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Validacion v = validarDesdeRequest(req);
        int id = 0;
        try { id = Integer.parseInt(req.getParameter("id")); }
        catch (Exception ignore) { v.errores.append("ID inválido. "); }

        if (!v.errores.isEmpty()) {
            req.setAttribute("msgErr", v.errores.toString());
            // Recarga el formulario de edición con lo que intentó enviar
            Producto p = new Producto();
            p.setId(id);
            p.setNombre(v.nombre);
            p.setPrecio(v.precio);
            p.setDescuento(v.descuento);
            p.setCategoria(v.categoria);
            p.setFechaInicio(v.fechaInicio);
            p.setFechaFin(v.fechaFin);
            req.setAttribute("producto", p);
            req.getRequestDispatcher("editar.jsp").forward(req, resp);
            return;
        }

        try {
            Producto p = v.producto();
            p.setId(id);
            dao.actualizar(p);
            resp.sendRedirect("ProductoServlet?msgOk=1");
        } catch (Exception e) {
            req.setAttribute("msgErr", "No se pudo actualizar: " + e.getMessage());
            try {
                req.setAttribute("producto", dao.buscarPorId(id));
            } catch (Exception ignored) {}
            req.getRequestDispatcher("editar.jsp").forward(req, resp);
        }
    }

    // ---- Validación común ----
    private Validacion validarDesdeRequest(HttpServletRequest req) {
        Validacion v = new Validacion();
        v.nombre = trim(req.getParameter("nombre"));
        v.categoria = trim(req.getParameter("categoria"));

        StringBuilder err = v.errores;

        if (v.nombre.isEmpty()) err.append("El nombre es obligatorio. ");
        try {
            v.precio = Double.parseDouble(req.getParameter("precio"));
            if (v.precio <= 0) err.append("El precio debe ser positivo. ");
        } catch (Exception e) { err.append("Precio inválido. "); }

        try {
            v.descuento = Integer.parseInt(req.getParameter("descuento"));
            if (v.descuento < 1 || v.descuento > 90) err.append("El descuento debe estar entre 1 y 90. ");
        } catch (Exception e) { err.append("Descuento inválido. "); }

        try {
            String fi = req.getParameter("fecha_inicio");
            String ff = req.getParameter("fecha_fin");
            v.fechaInicio = (fi == null || fi.isBlank()) ? null : LocalDate.parse(fi);
            v.fechaFin = (ff == null || ff.isBlank()) ? null : LocalDate.parse(ff);
            if (v.fechaInicio != null && v.fechaFin != null && !v.fechaInicio.isBefore(v.fechaFin)) {
                err.append("La fecha de inicio debe ser anterior a la fecha de fin. ");
            }
        } catch (DateTimeParseException ex) {
            err.append("Formato de fecha inválido (AAAA-MM-DD). ");
        }
        return v;
    }

    private String trim(String s) { return s == null ? "" : s.trim(); }

    // Clase helper
    private static class Validacion {
        String nombre, categoria;
        double precio;
        int descuento;
        LocalDate fechaInicio, fechaFin;
        StringBuilder errores = new StringBuilder();

        Producto producto() {
            return new Producto(nombre, precio, descuento, categoria, fechaInicio, fechaFin);
        }
    }
}