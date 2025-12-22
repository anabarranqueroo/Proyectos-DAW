/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Accesorio;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author fgarcia
 */
@WebServlet("/AccesorioServletSeguro")
public class AccesorioServletSeguro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html; charset=UTF-8");

        try {
            // 1️⃣ Recoger parámetros del formulario
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));

            // 2️⃣ Validaciones
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser mayor que 0.");
            }

            // 3️⃣ Crear objeto Accesorio
            Accesorio a = new Accesorio(nombre, precio);

            // 4️⃣ Mostrar accesorio
            response.getWriter().println("<h1>Accesorio introducido correctamente</h1>");
            response.getWriter().println("<p><b>Título:</b> " + a.getNombre() + "</p>");
            response.getWriter().println("<p><b>Precio:</b> " + a.getPrecio() + " €</p>");

        } catch (NumberFormatException e) {
            // Error si precio o páginas no son válidos
            response.getWriter().println("<h2 style='color:red;'>Error: Precio  no válido.</h2>");
        } catch (IllegalArgumentException e) {
            // Mensajes de validación
            response.getWriter().println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
        }

        // Enlace para volver al formulario
        response.getWriter().println("<br><a href='index.html'>Volver a index</a>");
    }
}