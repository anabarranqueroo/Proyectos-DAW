package com.miempresa.servlet.RecetaServlet;

import com.miempresa.modelo.TipoPlato;
import com.miempresa.modelo.Receta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RecetarioServlet")
public class RecetarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        List<Receta> recetas = new ArrayList<>();

        String nombre = request.getParameter("nombre");
        String chef = request.getParameter("chef");
        String tiempoStr = request.getParameter("tiempo");
        String ingredientesStr = request.getParameter("ingredientes");
        String tipoString = request.getParameter("tipo");

        boolean error = false;
        double tiempo = 0;
        int ingredientes = 0;
        TipoPlato tipo = null;

        response.setContentType("text/html");

        if (nombre.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe un nombre de uan receta.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Nombre: </strong> " + nombre + "</p>");
        }

        if (chef.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe el nombre del chef.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Chef: </strong> " + chef + "</p>");
        }

        if (tiempoStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe el tiempo de preparación.</p>");
            error = true;
        } else {
            try {
                tiempo = Double.parseDouble(tiempoStr);
                if (tiempo < 0) {
                    response.getWriter().println("<p style='color:red;'>El tiempo de preparación tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Tiempo de preparación en minutos: </strong> " + tiempo + "</p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Tiempo de preparación no válido.</p>");
                error = true;
            }
        }

        if (ingredientesStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe un numero de ingredientes.</p>");
            error = true;
        } else {
            try {
                ingredientes = Integer.parseInt(ingredientesStr);
                if (ingredientes < 0) {
                    response.getWriter().println("<p style='color:red;'>El número de ingredientes tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Número de ingredientes:</strong> " + ingredientes + "</p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Numero de ingredientes no válido.</p>");
                error = true;
            }
        }
        
        tipo = TipoPlato.valueOf(tipoString);
        response.getWriter().println("<p><strong>Tipo de plato:</strong> " + tipoString + "</p>");

        if (!error) {
            Receta r = new Receta(nombre, chef, tiempo, ingredientes, tipo);
            recetas.add(r);
            response.getWriter().println("<h2>Receta introducida correctamente.</h2>");
        }

        response.getWriter().println("<a href=\"index.html\">Introduce otro libro.</a>");
        
        request.setAttribute("recetas", recetas);
        request.getRequestDispatcher("listaRecetas.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
