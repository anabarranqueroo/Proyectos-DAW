package com.disfracesPepito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.modelo.Disponibilidad;
import com.disfracesPepito.modelo.Talla;


@WebServlet("/carro")
public class CarritoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked")
        List<Disfraz> disfraces = (List<Disfraz>) session.getAttribute("disfraces");
        if (disfraces == null) {
            disfraces = new ArrayList<>();
            session.setAttribute("disfraces", disfraces);
        }

        Double total = 0.0;
        for (Disfraz d : disfraces) {
            total += d.getPrecio() ;
        }
        session.setAttribute("total", total);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Gestor de Disfraces</title></head><body>");
        out.println("<h1>Gestor de Disfraces</h1>");
        out.println("<p><b>Total del carrito:</b> " + total + "€</p>"); 
        out.println("<form method='post'>");
        out.println("Disfraz: <input type='text' name='disfraz' required><br><br>");
        out.println("Precio: <input type='number' step='0.01' name='precio' required><br><br>");
        out.println("Talla: <select name='talla'>");
        out.println("<option value='S'>S</option>");
        out.println("<option value='M'>M</option>");
        out.println("<option value='L'>L</option>");
        out.println("<option value='XL'>XL</option>");
        out.println("<option value='XXL'>XXL</option>");
        out.println("</select><br><br>");
        out.println("Disponibilidad: <select name='disponibilidad'>");
        out.println("<option value='DISPONIBLE'>Disponible</option>");
        out.println("<option value='NODISPONIBLE'>No disponible</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Añadir'>");
        out.println("</form>");

        out.println("<h2>Lista de disfraces</h2>");
        if (disfraces.isEmpty()) {
            out.println("<p>No hay disfraces.</p>");
        } else {
            out.println("<ul>");
            for (Disfraz d : disfraces) {
                out.println("<li>"+ d.getDescripcion()+ " - " + d.getPrecio() + "€ - " +d.getTalla()+" - "+ d.getD()+"</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href=\"index.html\">Volver al indice.</a><br><br>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Disfraz> disfraces = (List<Disfraz>) session.getAttribute("disfraces");
        if (disfraces == null) {
            disfraces = new ArrayList<>();
        }

        String nuevoDisfraz = request.getParameter("disfraz");
        String precioStr = request.getParameter("precio");
        String tallaStr = request.getParameter("talla");
        String disponibilidadStr = request.getParameter("disponibilidad");

        if (nuevoDisfraz != null && !nuevoDisfraz.trim().isEmpty() && precioStr != null) {
            double precio = Double.parseDouble(precioStr);
            
            Talla talla = Talla.valueOf(tallaStr);
            Disponibilidad disponibilidad = Disponibilidad.valueOf(disponibilidadStr);
            disfraces.add(new Disfraz(nuevoDisfraz, precio, talla, disponibilidad));
        }
        session.setAttribute("disfraces", disfraces);
        response.sendRedirect("carro");
    }
}
