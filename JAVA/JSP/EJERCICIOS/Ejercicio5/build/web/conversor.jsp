<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversor</title>
    </head>
    <body>
        Pesetas:
        <%
            double euros = Double.parseDouble(request.getParameter("euros"));
            double pes = (euros * 166.386);
            out.print(pes);
        %>
    </body>
</html>
