<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fibonacci</title>
</head>
<body>
    <%
        int num = Integer.parseInt(request.getParameter("numero"));
        int n1=0;
        int n2=1;
        int n3=0;
        out.print("0,1");
        num-=1;
        for(int i=0; i<num; i++){
            out.print("," +(n1+n2));
            n3=n2;
            n2=n1+n2;
            n1=n3;
        }
        %>
</body>
</html>