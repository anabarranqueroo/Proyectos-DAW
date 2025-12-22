package com.ejemplo.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/clear")
public class ClearCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie tema = new Cookie("tema", "");
        Cookie idioma = new Cookie("idioma", "");

        tema.setPath("/");
        idioma.setPath("/");

        tema.setMaxAge(0);
        idioma.setMaxAge(0);

        response.addCookie(tema);
        response.addCookie(idioma);

        response.sendRedirect("home");
    }
}
