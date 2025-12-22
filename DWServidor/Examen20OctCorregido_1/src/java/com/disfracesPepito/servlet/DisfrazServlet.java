package com.disfracesPepito.servlet;

import com.disfracesPepito.dao.DisfrazDAO;
import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.modelo.Disponibilidad;
import com.disfracesPepito.modelo.Talla;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DisfrazServlet")
public class DisfrazServlet extends HttpServlet {
     private DisfrazDAO dao = new DisfrazDAO();
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String disponibilidadString = request.getParameter("disponibilidad");
        Disponibilidad disponibilidad = Disponibilidad.valueOf(disponibilidadString);
        String tallaString = request.getParameter("talla");
        Talla talla = Talla.valueOf(tallaString);
        Disfraz d = new Disfraz(descripcion, precio, talla, disponibilidad);
        dao.insertar(d);
        

        response.setContentType("text/html");

        response.getWriter().println("<h1>Disfraz introducido correctamente.</h1>");
        response.getWriter().println("<p><strong>Descripcion: </strong>" + descripcion + "</p>");
        response.getWriter().println("<p><strong>Precio: </strong>" + precio + "€ </p>");
        response.getWriter().println("<p><strong>Talla: </strong>" + talla + "</p>");
        response.getWriter().println("<p><strong>Disponibilidad: </strong>" + disponibilidad + "</p>");
        response.getWriter().println("<a href=\"nuevodisfraz.html\">Introduce otro disfraz.</a><br><br>");
        response.getWriter().println("<a href=\"index.html\">Volver al indice.</a>");

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
   }

  

