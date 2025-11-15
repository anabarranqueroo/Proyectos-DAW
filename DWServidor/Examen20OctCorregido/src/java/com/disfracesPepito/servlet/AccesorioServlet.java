package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Accesorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AccesorioServlet")
public class AccesorioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accesorio = request.getParameter("accesorio");
        double precio = Double.parseDouble(request.getParameter("precio"));
        Accesorio ac = new Accesorio(accesorio, precio);
        

        response.setContentType("text/html");

        response.getWriter().println("<h1>Accesorio introducido correctamente.</h1>");
        response.getWriter().println("<p><strong>Accesorio: </strong>" + accesorio + "</p>");
        response.getWriter().println("<p><strong>Precio: </strong>" + precio + "€ </p>");
        response.getWriter().println("<a href=\"nuevoaccesorio.html\">Introduce otro accesorio.</a><br><br>");
        response.getWriter().println("<a href=\"index.html\">Volver al indice.</a>");

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
   }

  

