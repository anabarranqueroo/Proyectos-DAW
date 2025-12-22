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

@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet"})
public class LibroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Libro l1 = new Libro("Titulo1", " Autor1", 23.7, 200, Genero.CIENCIA);
        Libro l2 = new Libro("Titulo2", " Autor2", 29.0, 250, Genero.FANTASIA);
        //Simulación consulta de una base de datos.
        List<Libro> libros = new ArrayList<>();
        libros.add(l1);
        libros.add(l2);
        req.setAttribute("libros", libros);
        req.getRequestDispatcher("listadoLibros.jsp").forward(req, resp);
    }

}
