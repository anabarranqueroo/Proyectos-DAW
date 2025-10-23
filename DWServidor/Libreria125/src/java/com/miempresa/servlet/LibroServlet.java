package com.miempresa.servlet;

import com.miempresa.modelo.Genero;
import com.miempresa.modelo.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        List<Libro> libros = new ArrayList<>();

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String precioStr = request.getParameter("precio");
        String paginasStr = request.getParameter("numpag");
        String generoString = request.getParameter("genero");

        boolean error = false;
        double precio = 0;
        int paginas = 0;
        Genero genero = null;

        response.setContentType("text/html");

        if (titulo.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe un titulo.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Titulo:</strong> " + titulo + "</p>");
        }

        if (autor.length() < 1) {
            response.getWriter().println("<p style='color:red;'>Escribe un autor.</p>");
            error = true;
        } else {
            response.getWriter().println("<p><strong>Autor:</strong> " + autor + "</p>");
        }

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

        if (paginasStr == null) {
            response.getWriter().println("<p style='color:red;'>Escribe un numero de paginas.</p>");
            error = true;
        } else {
            try {
                paginas = Integer.parseInt(paginasStr);
                if (paginas < 0) {
                    response.getWriter().println("<p style='color:red;'>El número de páginas tiene que ser superior a 0.</p>");
                    error = true;
                } else {
                    response.getWriter().println("<p><strong>Páginas:</strong> " + paginas + "</p>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("<p style='color:red;'>Numero de paginas no válido.</p>");
                error = true;
            }
        }
        
        genero = Genero.valueOf(generoString);
        response.getWriter().println("<p><strong>Género:</strong> " + generoString + "</p>");

        if (!error) {
            Libro li = new Libro(titulo, autor, precio, paginas, genero);
            libros.add(li);
            response.getWriter().println("<h2>Libro introducido correctamente</h2>");
        }

        response.getWriter().println("<a href=\"index.html\">Introduce otro libro.</a>");
        
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("listaLibros.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
