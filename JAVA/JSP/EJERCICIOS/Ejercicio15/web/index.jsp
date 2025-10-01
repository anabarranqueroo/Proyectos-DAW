<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividad 15</title>
    </head>
    <body>
        <h3>Numeros Aleatorios</h3>
        <%
            for (int i = 0; i <= 100; i++) {
                int num = (int) (Math.random() * 200) + 1;
                boolean bo = false;

                for (int j = 2; j <=Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        bo = true;
                        break;
                    }

                }
                if (bo) {
                    out.print(num + " ");
                } else {
                    out.print(" "+"<b>"+num+"</b>"+" ");
                }
            }
        %>
    </body>
</html>
