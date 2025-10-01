-- Nombre: 
--------------------------------------------------------------------------------------
/*Parte 1
-- INSTRUCCIONES:

Entra en SQL-Developer y desde la conexión asociada system debes crearte un usuario con nombre EXDDLB y contraseña 123456. Debes activar la casilla asociada a "edición activada". En Tablespace por defecto elegir USERS, en Tablespace por temporal elegir TEMP. En la pestaña Roles otorgados elige Administrar todo.
Una vez creado el usuario debes crear la conexión que ahora se va a llamar EXDDLB. 
Tendrá como usuario el usuario  EXDDLB.
Crea un script.sql llamado tusiniciales_T4_B1.sql y escribe en él las instrucciones SQL necesarias para implementar la BD
La primera línea ha de ser un comentario para indicar tu nombre y dos apellidos.
*/


/*1.(3,5 puntos)Crea las tablas en ORACLE procurando que las columnas tengan el tipo y tamaño adecuado y con las siguientes restricciones:
A.Todas las claves primarias, y ajenas o foráneas .*/

/*B.No hay cursos en verano (desde el 21/06 al 21/09)*/

/*C.Los cursos no pueden durar más de 1000 horas.*/

/*D.La nota obtenida en el curso será: Suspenso,Aprobado,Notable o Sobresaliente. */

/*E.Los alumnos deben tener como mínimo 18 años en el momento en que se dan de alta en la base de datos.*/

/*F.Si no se sabe la duración de un curso, se guardará un 0 por defecto.*/

/*G.El teléfono de los alumnos es un campo obligatorio.*/

/*2.(2 puntos)Una vez creadas las tablas:
A.Añade una columna hora de comienzo a la tabla cursos cuyos posibles valores sean 9 o 17.*/

/*B.Añade una columna  ciudad a tabla empresas.*/

/*C.Añade la restricción: Los teléfonos empiezan por 6 o por 9 */

/*D.Añade la restricción:El nombre de la empresa ha de almacenarse en mayúsculas.*/

/*3.( 0.5 puntos)Borra las tablas teniendo en cuenta las reglas de integridad referencial.*/

/*Parte 2
-- INSTRUCCIONES:

Entra en SQL-Developer y desde la conexión ventas realiza los ejercicios pedidos.
Si no dispones de dicha conexión creala en moodle dispones del script de creación ventas.sql.
Crea un script.sql llamado tusiniciales_B2.sql y escribe en él las instrucciones SQL necesarias para implementar la BD
La primera línea ha de ser un comentario para indicar tu nombre y dos apellidos.*/


/*1.(1 punto) Escribe una vista que se llame listado_cliente_pedidos que muestre un listado con todos los clientes 
junto con los datos de los pedidos que han realizado cada uno de ellos. Este listado también debe incluir los clientes
que no han realizado ningún pedido.La vista deberá tener las siguientes columnas: nombre y apellidos de los clientes 
concatenados, ciudad , id del pedido, fecha del pedido y total de cantidad pedido.*/

/*2.(1 punto) Usando la vista anterior devuelve un listado con todos los pedidos que ha realizado Adela Salas Diaz*/

/*3.(1 punto) Usando la vista anterior devuelve el total del pedido de menor valor realizado por el cliente 'PepeRuizSantana'*/

/*4.(1 punto) Usando la vista anterior devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido*/

/*5.(1 punto) Usando la vista anterior devuelve el Cliente que ha realizado el mayor pedido.*/
