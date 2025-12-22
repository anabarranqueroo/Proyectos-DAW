package com.ejemplo.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String tema = "light";
        String idioma = "es";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("tema".equals(c.getName())) {
                    tema = c.getValue();
                } else if ("idioma".equals(c.getName())) {
                    idioma = c.getValue();
                }
            }
        }

        String bg = "light".equals(tema) ? "#ffffff" : "#111827";
        String fg = "light".equals(tema) ? "#111827" : "#f9fafb";

        String saludo;
        switch (idioma) {
            case "en": saludo = "Hello!"; break;
            case "fr": saludo = "Bonjour!"; break;
            default: saludo = "¡Hola!";
        }

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Preferencias con Cookies</title></head>");
        out.println("<body style='background:" + bg + "; color:" + fg + "; font-family: Arial, sans-serif;'>");
        out.println("<h1>" + saludo + " Preferencias aplicadas</h1>");
        out.println("<p><strong>Tema:</strong> " + tema + "</p>");
        out.println("<p><strong>Idioma:</strong> " + idioma + "</p>");
        out.println("<p><a href='preferencias.html' style='color:" + fg + ";'>Cambiar preferencias</a></p>");
        out.println("<p><a href='clear' style='color:" + fg + ";'>Borrar cookies</a></p>");
        out.println("</body></html>");
    }
}
