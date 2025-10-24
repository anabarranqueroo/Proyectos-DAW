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

        String descripcion = request.getParameter("descripcion");
        String precioStr = request.getParameter("precio");
        String disponibilidadString = request.getParameter("disponibilidad");
        String tallaString = request.getParameter("talla");

        boolean error = false;
        double precio = 0;
        Disponibilidad disponibilidad = null;
        Talla talla = null;

        response.setContentType("text/html");
        /*Comprueba el disfraz.*/
        if (descripcion.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe una descripcion.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Descripcion: </strong> " + descripcion + "</p>");
        }
        /*Comprueba el precio.*/
        if (precioStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe un precio.</p>");
            error = true;
        } else {
            try {
                precio = Double.parseDouble(precioStr);
                if (precio < 0) {
                    response.getWriter().println("<p style='color:red;'>El precio tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Precio:</strong> " + precio + "€ </p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Precio no válido.</p>");
                error = true;
            }
        }
        /*Coge el valor de la disponibilidad*/
        disponibilidad = Disponibilidad.valueOf(disponibilidadString);
        response.getWriter().println("<p><strong>Disponibilidad:</strong> " + disponibilidadString + "</p>");
        /*Coge el valor de la talla*/
        talla = Talla.valueOf(tallaString);
        response.getWriter().println("<p><strong>Talla:</strong> " + tallaString + "</p>");
        /*Crea el disfraz una vez compruebe que no hay errores*/
        if (!error) {
            Disfraz d = new Disfraz(descripcion, precio, talla,disponibilidad);
            request.setAttribute("disfraz", d);
            response.getWriter().println("<h2>Disfraz introducido correctamente</h2>");
        }

        response.getWriter().println("<a href=\"nuevodisfrazseguro2.html\">Introduce otro disfraz.</a><br><br>");
        response.getWriter().println("<a href=\"index.html\">Volver al indice.</a>");
        request.getRequestDispatcher("muestradisfraz.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
