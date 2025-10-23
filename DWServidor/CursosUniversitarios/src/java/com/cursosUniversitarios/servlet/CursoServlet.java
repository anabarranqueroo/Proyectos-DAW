package com.cursosUniversitarios.servlet;

import com.cursosUniversitarios.modelo.Modalidad;
import com.cursosUniversitarios.modelo.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CursoServlet")
public class CursoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        List<Curso> curso = new ArrayList<>();

        String nombre = request.getParameter("nombre");
        String profesor = request.getParameter("profesor");
        String duracionStr = request.getParameter("duracion");
        String plazasStr = request.getParameter("plazas");
        String modalidadString = request.getParameter("modalidad");

        boolean error = false;
        int duracion = 0;
        int plazas = 0;
        Modalidad modalidad = null;

        response.setContentType("text/html");

        if (nombre.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe un nombre del curso.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Nombre del curso:</strong> " + nombre + "</p>");
        }

        if (profesor.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe el nombre del profesor.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Profesor responsable:</strong> " + profesor + "</p>");
        }

        if (duracionStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe la duración del curso.</p>");
            error = true;
        } else {
            try {
                duracion = Integer.parseInt(duracionStr);
                if (duracion < 0) {
                    response.getWriter().println("<p style='color:red;'>La duración del curso tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Duración del curso:</strong> " + duracion + "h. </p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Duración no válida.</p>");
                error = true;
            }
        }

        if (plazasStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe un numero de plazas disponibles.</p>");
            error = true;
        } else {
            try {
                plazas = Integer.parseInt(plazasStr);
                if (plazas < 0) {
                    response.getWriter().println("<p style='color:red;'>El número de plazas disponibles tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Plazas disponibles:</strong> " + plazas + "</p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Numero de plazas disponibles no válido.</p>");
                error = true;
            }
        }
        
        modalidad = Modalidad.valueOf(modalidadString);
        response.getWriter().println("<p><strong>Modalidad:</strong> " + modalidadString + "</p>");

        if (!error) {
            Curso c = new Curso(nombre, profesor, duracion, plazas, modalidad);
            curso.add(c);
            response.getWriter().println("<h2>Curso introducido correctamente.</h2>");
        }

        response.getWriter().println("<a href=\"index.html\">Introduce otro curso universitario.</a>");
        
        request.setAttribute("cursos", curso);
        request.getRequestDispatcher("listaCursos.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
