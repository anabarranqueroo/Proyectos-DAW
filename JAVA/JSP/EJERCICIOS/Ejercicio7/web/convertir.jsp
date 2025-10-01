<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado conversor</title>
    </head>
    <body>
        <h1>Resultado de la conversion</h1>
        <h3>Conversion realizada.</h3>
        <p>
        <%
            String opcion = request.getParameter("opcion");
            double cantidad = Double.parseDouble(request.getParameter("cantidad"));
            double resultado = 0.0;
            if("eu_pes".equals(opcion)){
                resultado = cantidad * 166.386;
                out.println(cantidad + " Euros son " + resultado + " Pesetas.");                
            } else if("pes_eu".equals(opcion)){
                resultado = cantidad * 0.0060;
                out.println(cantidad + "Pesetas son " + resultado + " Euros.");
            }
        %>
        </p>
        <a href="index.jsp"> Pagina principal </a>
    </body>
</html>
