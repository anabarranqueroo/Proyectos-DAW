package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Accesorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccesorioServletSeguro")
public class AccesorioServletSeguro extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accesorio = request.getParameter("accesorio");
        String precioStr = request.getParameter("precio");

        boolean error = false;
        double precio = 0;

        response.setContentType("text/html");
        /*Comprueba el accesorio.*/
        if (accesorio.length() < 1) {
            response.getWriter().println("<p style='color:red;'>El nombre no puede estar vacio.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Accesorio: </strong> " + accesorio + "</p>");
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

        if (!error) {
            Accesorio ac = new Accesorio(accesorio, precio);
            response.getWriter().println("<h2>Accesorio introducido correctamente</h2>");
        }

        response.getWriter().println("<a href=\"nuevoaccesorioseguro.html\">Introduce otro accesorio.</a><br><br>");
        response.getWriter().println("<a href=\"index.html\">Volver al indice.</a>");

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
