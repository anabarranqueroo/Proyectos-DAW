/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.disfracesPepito.servlet;

import com.disfracesPepito.modelo.Accesorio;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fgarcia
 */
@WebServlet("/ListadoAccesoriosServlet")
public class ListadoAccesoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lista de libros (simulada)
        Accesorio a1 = new Accesorio("Cuchillo", 2.4);
        Accesorio a2 = new Accesorio("Hacha ensangrentada", 7.2);
        List<Accesorio> accesorios = new ArrayList<>();
        accesorios.add(a1);
        accesorios.add(a2);
        request.setAttribute("accesorios", accesorios);

        // Enviar datos a JSP
        request.getRequestDispatcher("listadoaccesorios.jsp").forward(request, response);

    }
}
