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
@WebServlet("/AccesorioServletSeguro2")
public class AccesorioServletSeguro2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = null;
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

             request.setAttribute("accesorio", a);

            // Enviar datos a JSP
            request.getRequestDispatcher("muestraaccesorio.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Error si precio o páginas no son válidos
            mensaje = "Error: Precio  no válido";
            request.setAttribute("error", mensaje);
            // Enviar datos a JSP
            request.getRequestDispatcher("muestraaccesorio.jsp").forward(request, response); 
        } catch (IllegalArgumentException e) {
            mensaje =  e.getMessage();
            request.setAttribute("error", mensaje);   
            request.getRequestDispatcher("muestraaccesorio.jsp").forward(request, response);
        }

    }
}