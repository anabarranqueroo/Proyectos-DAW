package com.disfracesPepito.servlet;

import com.disfracesPepito.dao.DisfrazDAO;
import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.modelo.Talla;
import com.disfracesPepito.modelo.Disponibilidad;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/DisfrazServlet")
public class DisfrazServlet extends HttpServlet {

    private final DisfrazDAO dao = new DisfrazDAO();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        try {
            if ("eliminar".equalsIgnoreCase(accion)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.eliminar(id);
                req.setAttribute("msgOk", "Disfraz eliminado (ID " + id + ").");
                cargarListado(req);
                req.getRequestDispatcher("disfraces.jsp").forward(req, resp);
                return;
            }

            if ("editar".equalsIgnoreCase(accion)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Disfraz d = dao.buscarPorId(id);
                if (d == null) {
                    req.setAttribute("msgErr", "No existe el disfraz con ID " + id);
                    cargarListado(req);
                    req.getRequestDispatcher("disfraces.jsp").forward(req, resp);
                } else {
                    req.setAttribute("disfraz", d);
                    req.getRequestDispatcher("editar.jsp").forward(req, resp);
                }
                return;
            }

            cargarListado(req);
            req.getRequestDispatcher("disfraces.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("msgErr", "Error: " + e.getMessage());
            cargarListado(req);
            req.getRequestDispatcher("disfraces.jsp").forward(req, resp);
        }
    }

     private void cargarListado(HttpServletRequest req) {
        // Obtener filtros desde parámetros del formulario o URL
        String talla = req.getParameter("talla");
        String disponibilidad = req.getParameter("disponibilidad");
        boolean activos = "on".equalsIgnoreCase(req.getParameter("activos"));

        // Llamar al DAO con los filtros
        List<Disfraz> lista = dao.listarFiltrado(talla, disponibilidad, activos);

        // Enviar datos a la JSP
        req.setAttribute("listaDisfraces", lista);
        req.setAttribute("f_talla", talla != null ? talla : "");
        req.setAttribute("f_disponibilidad", disponibilidad != null ? disponibilidad : "");
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
            cargarListado(req);
            req.getRequestDispatcher("disfraces.jsp").forward(req, resp);
            return;
        }

        try {
            dao.insertar(v.disfraz());
            resp.sendRedirect("DisfrazServlet?msgOk=1");
        } catch (Exception e) {
            req.setAttribute("msgErr", "No se pudo insertar: " + e.getMessage());
            cargarListado(req);
            req.getRequestDispatcher("disfraces.jsp").forward(req, resp);
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Validacion v = validarDesdeRequest(req);
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception ignore) {
            v.errores.append("ID inválido. ");
        }

        if (!v.errores.isEmpty()) {
            req.setAttribute("msgErr", v.errores.toString());
            Disfraz d = v.disfraz();
            d.setId(id);
            req.setAttribute("disfraz", d);
            req.getRequestDispatcher("editar.jsp").forward(req, resp);
            return;
        }

        try {
            Disfraz d = v.disfraz();
            d.setId(id);
            dao.actualizar(d);
            resp.sendRedirect("DisfrazServlet?msgOk=1");
        } catch (Exception e) {
            req.setAttribute("msgErr", "No se pudo actualizar: " + e.getMessage());
            try {
                req.setAttribute("disfraz", dao.buscarPorId(id));
            } catch (Exception ignored) {
            }
            req.getRequestDispatcher("editar.jsp").forward(req, resp);
        }
    }

    private Validacion validarDesdeRequest(HttpServletRequest req) {
        Validacion v = new Validacion();

        v.descripcion = trim(req.getParameter("descripcion"));
        v.talla = req.getParameter("talla");
        v.disponibilidad = req.getParameter("disponibilidad");

        StringBuilder err = v.errores;

        if (v.descripcion.isEmpty()) {
            err.append("La descripción es obligatoria. ");
        }

        try {
            v.precio = Double.parseDouble(req.getParameter("precio"));
            if (v.precio <= 0) {
                err.append("El precio debe ser positivo. ");
            }
        } catch (Exception e) {
            err.append("Precio inválido. ");
        }

        

        try {
            String fi = req.getParameter("fecha_inicio");
            String ff = req.getParameter("fecha_fin");
            v.fechaInicio = (fi == null || fi.isBlank()) ? null : sdf.parse(fi);
            v.fechaFin = (ff == null || ff.isBlank()) ? null : sdf.parse(ff);
            if (v.fechaInicio != null && v.fechaFin != null && !v.fechaInicio.before(v.fechaFin)) {
                err.append("La fecha de inicio debe ser anterior a la de fin. ");
            }
        } catch (ParseException ex) {
            err.append("Formato de fecha inválido (AAAA-MM-DD). ");
        }

        return v;
    }

    private String trim(String s) {
        return s == null ? "" : s.trim();
    }

    private static class Validacion {

        String descripcion, talla, disponibilidad;
        double precio;
   
        Date fechaInicio, fechaFin;
        StringBuilder errores = new StringBuilder();

        Disfraz disfraz() {
            return new Disfraz(
                    descripcion,
                    precio,
                    Talla.valueOf(talla),
                    Disponibilidad.valueOf(disponibilidad),
                    fechaInicio,
                    fechaFin
                    
                    
            );
        }
    }
}
