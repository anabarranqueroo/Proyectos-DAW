package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tareas")
public class TareaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked")
        List<String> tareas = (List<String>) session.getAttribute("tareas");
        if (tareas == null) {
            tareas = new ArrayList<>();
            session.setAttribute("tareas", tareas);
        }

        Integer visitas = (Integer) session.getAttribute("visitas");
        if (visitas == null) visitas = 0;
        visitas++;
        session.setAttribute("visitas", visitas);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Gestor de Tareas</title></head><body>");
        out.println("<h1>Gestor de Tareas</h1>");
        out.println("<p>Has visitado esta página " + visitas + " veces.</p>");
        out.println("<form method='post'>");
        out.println("Tarea: <input type='text' name='tarea' required>");
        out.println("<input type='submit' value='Añadir'>");
        out.println("</form>");
        out.println("<h2>Lista de tareas</h2>");
        if (tareas.isEmpty()) {
            out.println("<p>No hay tareas.</p>");
        } else {
            out.println("<ul>");
            for (String t : tareas) {
                out.println("<li>" + t + "</li>");
            }
            out.println("</ul>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<String> tareas = (List<String>) session.getAttribute("tareas");
        if (tareas == null) {
            tareas = new ArrayList<>();
        }

        String nuevaTarea = request.getParameter("tarea");
        if (nuevaTarea != null && !nuevaTarea.trim().isEmpty()) {
            tareas.add(nuevaTarea);
        }
        session.setAttribute("tareas", tareas);
        response.sendRedirect("tareas");
    }
}
