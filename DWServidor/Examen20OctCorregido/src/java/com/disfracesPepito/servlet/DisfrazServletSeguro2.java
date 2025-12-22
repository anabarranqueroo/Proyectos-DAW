package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.modelo.Disponibilidad;
import com.disfracesPepito.modelo.Talla;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DisfrazServletSeguro2")
public class DisfrazServletSeguro2 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        

        String mensaje = null;
        

        try {
            String descripcion = request.getParameter("descripcion");
        String precioStr = request.getParameter("precio");
        String disponibilidadString = request.getParameter("disponibilidad");
        String tallaString = request.getParameter("talla");
        Talla talla= Talla.valueOf(tallaString);
        Disponibilidad dispo =Disponibilidad.valueOf(disponibilidadString);

            double precio = Double.parseDouble(request.getParameter("precio"));

            if (descripcion == null || descripcion.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser mayor que 0.");
            }
            
            Disfraz d = new Disfraz(descripcion, precio,talla,dispo );

             request.setAttribute("disfraz", d);

            // Enviar datos a JSP
            request.getRequestDispatcher("muestradisfraz.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Error si precio o páginas no son válidos
            mensaje = "Error: Precio  no válido";
            request.setAttribute("error", mensaje);
            // Enviar datos a JSP
            request.getRequestDispatcher("muestradisfraz.jsp").forward(request, response); 
        } catch (IllegalArgumentException e) {
            mensaje =  e.getMessage();
            request.setAttribute("error", mensaje);   
            request.getRequestDispatcher("muestradisfraz.jsp").forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
