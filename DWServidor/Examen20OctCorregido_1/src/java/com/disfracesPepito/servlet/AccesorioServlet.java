/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Accesorio;
import com.disfracesPepito.dao.AccesorioDAO;
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
@WebServlet("/AccesorioServlet")
public class AccesorioServlet extends HttpServlet {

    private AccesorioDAO dao = new AccesorioDAO();
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        // 1️⃣ Recoger parámetros del formulario
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));

        // 2️⃣ Crear objeto Accesorio
        Accesorio a = new Accesorio(nombre, precio);
        dao.insertar(a);
        // 3️⃣ Generar la respuesta HTML
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h1>Accesorio introducido correctamente</h1>");
        response.getWriter().println("<p><b>Nombre:</b> " + a.getNombre() + "</p>");
        response.getWriter().println("<p><b>Precio:</b> " + a.getPrecio() + " €</p>");
        
        // Enlace para volver al formulario
        response.getWriter().println("<br><a href='index.html'>volver a index</a>");
    }

}
