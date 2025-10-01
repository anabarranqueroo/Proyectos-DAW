-- Nombre: 
--------------------------------------------------------------------------------------
/*PARTE1
-- INSTRUCCIONES
    • Entra en SQL-Developer y desde la conexión asociada system debes crearte un usuario con nombre EXDDLA y contraseña 123456. Debes activar la casilla asociada a "edición activada". En Tablespace por defecto elegir USERS, en Tablespace por temporal elegir TEMP. En la pestaña Roles otorgados elige Administrar todo.
    • Una vez creado el usuario debes crear la conexión que ahora se va a llamar EXDDLA. 
    • Tendrá como usuario el usuario  EXDDLA.
    • Para ello crear un script.sql llamado tusiniciales_A1.sql y escribe en él las instrucciones SQL necesarias para implementar la BD
    • La primera línea ha de ser un comentario para indicar tu nombre y dos apellidos.



    1. ( 3,5 puntos)Crea las tablas en ORACLE procurando que las columnas tengan el tipo y tamaño adecuado y con las siguientes restricciones:
        a. Todas las claves primarias, y ajenas o foráneas .*/
        
/*       1 b. No hay partidos en verano (desde el 21/06 al 21/09)*/

       /* 1.c. Los partidos no pueden durar más de 100 minutos incluyendo el descuento.*/
       
       /*1.d. La posición de un jugador puede ser Portero, Defensa, Centrocampista o Delantero.*/
       
        /*1.e. Si no se sabe el aforo de un estadio, se guardará un 0 por defecto.*/
        
        /*1.f. El nombre del equipo es único.*/
        
   /* 2. ( 2 puntos)Una vez creadas las tablas:
        a. Añade una columna NumTitulos a la tabla Equipos.*/
        
        /*2.b. Elimina la columna Ciudad.*/
        
        /*2.c. Añade la restricción: Todos los equipos se han fundado después del año 1890.*/
        
        /*2.d. Añade la restricción:El nombre del equipo ha de almacenarse en mayúsculas.*/
        
    /*3. ( 0.5 punto)Borra las tablas teniendo en cuenta las reglas de integridad referencial.*/
    
/*PARTE 2
-- INSTRUCCIONES:

    • Entra en SQL-Developer y desde la conexión ventas realiza los ejercicios pedidos.
    • Si no dispones de dicha conexión creala en moodle dispones del script de creación ventas.sql.
    • Crea un script.sql llamado tusiniciales_A2.sql y escribe en él las instrucciones SQL necesarias para implementar la BD
    • La primera línea ha de ser un comentario para indicar tu nombre y dos apellidos

    1. (1 Punto) Escribe una vista que se llame listado_comercial_pedidos que muestre un listado con todos los comerciales 
    junto con los datos de los pedidos que han realizado cada uno de ellos. Este listado también debe incluir los comerciales 
    que no han realizado ningún pedido. La vista deberá tener las siguientes columnas: nombre y apellidos de los comerciales 
    concatenados, ciudad , id del pedido, fecha del pedido.*/
    
    /*2. (1 Punto) Usando la vista anterior devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.*/
    
    /*3. (1 Punto)Usando la vista anterior devuelve un listado con todos los pedidos que ha realizado ‘DanielSaezVega’*/
    
    /*4. (1 Punto) Usando la vista anterior devuelve un listado de los comerciales que han realizado pedidos que superen la cantidad de 2000 €*/
    
