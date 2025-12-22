package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String referencia = request.getParameter("referencia");
        double precio = Double.parseDouble(request.getParameter("cantidad"));  
        String fecEnt1 = request.getParameter("fecEnt1");
        String fecEnt2 = request.getParameter("fecEnt2");
        
        LocalDate fecha1 = LocalDate.parse(fecEnt1);
        LocalDate fecha2 = LocalDate.parse(fecEnt2);       
        LocalDate fecHoy = LocalDate.now();
        
        Pedido p = new Pedido(referencia, precio, fecha1, fecha2, fecHoy);
        

        response.setContentType("text/html");

        response.getWriter().println("<h1>Accesorio introducido correctamente.</h1>");
        response.getWriter().println("<p><strong>Referencia: </strong>" + referencia + "</p>");
        response.getWriter().println("<p><strong>Cantidad Total: </strong>" + precio + "€ </p>");
        response.getWriter().println("<p><strong>Fecha entrega 1: </strong>" + fecha1 + "</p>");
        response.getWriter().println("<p><strong>Fecha entrega 2: </strong>" + fecha2 + "</p>");
        response.getWriter().println("<p><strong>Fecha realización del pedido: </strong>" + fecHoy + "</p>");
        response.getWriter().println("<a href=\"pedido.html\">Introduce otro pedido.</a><br><br>");
        response.getWriter().println("<a href=\"index.html\">Volver al indice.</a>");

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
   }

  

