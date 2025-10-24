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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListadoDisfracesServlet", urlPatterns = {"/ListadoDisfracesServlet"})
public class ListadoDisfracesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Disfraz d1 = new Disfraz("Disfraz 1 ", 65.7, Talla.S, Disponibilidad.DISPONIBLE);
        Disfraz d2 = new Disfraz("Disfraz 2 ", 30, Talla.M, Disponibilidad.NODISPONIBLE);
        Disfraz d3 = new Disfraz("Disfraz 3 ", 22.5, Talla.XL, Disponibilidad.DISPONIBLE);
        List<Disfraz> disfraces = new ArrayList<>();
        disfraces.add(d1);
        disfraces.add(d2);
        disfraces.add(d3);
        req.setAttribute("disfraces", disfraces);
        req.getRequestDispatcher("listadodisfraces.jsp").forward(req, resp);
    }

}
