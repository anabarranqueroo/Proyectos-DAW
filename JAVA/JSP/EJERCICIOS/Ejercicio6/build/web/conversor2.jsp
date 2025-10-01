<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversor</title>
    </head>
    <body>
        Euros:
        <%
            String pes = request.getParameter("pesetas");
            double pesetas = Double.parseDouble(pes);
            double euros = pesetas / 166.386;
            out.print(euros);
        %>
    </body>
</html>
