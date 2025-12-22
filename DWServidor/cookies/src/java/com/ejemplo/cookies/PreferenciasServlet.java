package com.ejemplo.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/preferencias")
public class PreferenciasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tema = request.getParameter("tema");
        String idioma = request.getParameter("idioma");

        if (tema == null || tema.isBlank()) tema = "light";
        if (idioma == null || idioma.isBlank()) idioma = "es";

        Cookie temaCookie = new Cookie("tema", tema);
        Cookie idiomaCookie = new Cookie("idioma", idioma);

        temaCookie.setHttpOnly(true);
        idiomaCookie.setHttpOnly(true);

        temaCookie.setPath("/");
        idiomaCookie.setPath("/");

        int sevenDays = 7 * 24 * 60 * 60;
        temaCookie.setMaxAge(sevenDays);
        idiomaCookie.setMaxAge(sevenDays);

        response.addCookie(temaCookie);
        response.addCookie(idiomaCookie);

        response.sendRedirect("home");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("preferencias.html");
    }
}
