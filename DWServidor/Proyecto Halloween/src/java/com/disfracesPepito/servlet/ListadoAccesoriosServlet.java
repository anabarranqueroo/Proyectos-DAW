package com.disfracesPepito.servlet;


import com.disfracesPepito.modelo.Accesorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListadoAccesoriosServlet", urlPatterns = {"/ListadoAccesoriosServlet"})
public class ListadoAccesoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Accesorio a1 = new Accesorio("Guantes", 65.7);
        Accesorio a2 = new Accesorio("Gorro", 12);
        Accesorio a3 = new Accesorio("Capa", 33.8);
        List<Accesorio> accesorios = new ArrayList<>();
        accesorios.add(a1);
        accesorios.add(a2);
        accesorios.add(a3);
        req.setAttribute("accesorios", accesorios);
        req.getRequestDispatcher("listadoaccesorios.jsp").forward(req, resp);
    }

}
