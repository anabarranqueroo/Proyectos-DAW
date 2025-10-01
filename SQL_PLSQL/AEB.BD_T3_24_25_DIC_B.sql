--TIPO B
--------------------------------------------------------------------------------------

-- Nombre: Ana Esteban Barranquero

--------------------------------------------------------------------------------------
-- INSTRUCCIONES
--------------------------------------------------------------------------------------

-----Pon tu nombre arriba y lee atentamente todas las preguntas.
/*
- Entra en SQL-Developer y desde la conexi�n asociada system debes crearte un usuario
con nombre EXAMENT3 y contrase�a 123456. En Tablespace por defecto elegir USERS, 
en Tablespace por defecto: TEMP. En la pesta�a Roles otorgados elige Adminitrar todo.
-Una vez creado el usuario debes crear la conexi�n que ahora se va a llamar EXAMENT3. 
Tendr� como ususrio el usuario EXAMENT3.

- Carga el script para el examen desde el fichero "GESTPROY_datos.sql".

- Donde ponga "SQL>", copiar�s las sentencias SQL que has utilizado.

- Donde ponga "Resultado:" copiar�s el resultado que SQL te devuelve.

- RECUERDA: guardar, cada cierto tiempo, el contenido de este fichero. 
Es lo que voy a evaluar, si lo pierdes, lo siento, en la recuperaci�n tendr�s otra oportunidad.

--------------------------------------------------------------------------------------
-- PUNTUACI�N
--------------------------------------------------------------------------------------

--Preguntas: 1 puntos cada respuesta correcta

--------------------------------------------------------------------------------------
-- CRITERIOS
--------------------------------------------------------------------------------------

-- Las consultas deben poder ejecutarse (sin errores de sintaxis) 

-- Deben mostrar la informaci�n pedida.
/*1. **Listar los proyectos en espera ordenados por nombre**/
SELECT nombre_proyecto, estado
FROM proyectos
WHERE estado LIKE 'En espera'
ORDER BY 1;
/*RESULTADO:
NOMBRE_PROYECTO                                                                                      ESTADO              
---------------------------------------------------------------------------------------------------- --------------------
Proyecto Epsilon                                                                                     En espera           
Proyecto Gamma                                                                                       En espera           
Proyecto Lambda                                                                                      En espera           
Proyecto Theta                                                                                       En espera
*/
/*2.Mostrar el nombre y descripcion de las tarea que no tiene asignado ningun proyecto ***/

/*RESULTADO:
TAREAS SIN PROYECTO                                                                                                                                                                                                                                                                                                                                                   
-----------------------------------------------------------------
Optimizaci�n de procesos : Reducci�n de tiempos de ejecuci�n
Automatizaci�n de flujos : Uso de herramientas de automatizaci�n
Pruebas de calidad : Revisi�n de casos de prueba*/

/*3.Obtener las tareas EN CURSO ordenadas por fecha de finalizaci�n*/
SELECT fecha_fin as "Finaliza", nombre_tarea as "Tarea en curso"
FROM tareas
WHERE estado LIKE 'En curso'
ORDER BY fecha_fin;

/*RESULTADO:
Finaliza Tarea en curso                                                                                      
-------- ----------------------------------------------------------------------------------------------------
15/02/24 Dise�o del sistema                                                                                  
10/03/24 Dise�o de interfaz                                                                                  
15/08/24 Integraci�n con sistemas existentes  
*/
/*4.Contar cu�ntos proyectos hay en cada cada estado*/
SELECT estado, COUNT(estado)as "TotalP"
FROM proyectos
GROUP BY estado;
/*RESULTADO
ESTADO                   TotalP
-------------------- ----------
Activo                       11
En espera                     4
*/
/*/*5.Listar  nombre y correo electr�nico de los empleados que realizan la tarea de Pruebas iniciales*/
SELECT nombre, email
FROM empleados
WHERE id_empleado=(SELECT id_empleado FROM asignaciones WHERE id_tarea= (SELECT id_tarea FROM tareas WHERE nombre_tarea LIKE 'Pruebas iniciales'));
/*REULTADO:
NOMBRE                                                                                               EMAIL                                                                                                                                                 
---------------------------------------------------------------------------------------------------- ------------------------------------------------------------------------------------------------------------------------------------------------------
Jorge                                                                                                jorge.hernandez@example.com

/*6.Averigua que empleados tienen asignadas tarea en el proyecto Proyecto Epsilon*/
SELECT *
FROM empleados
WHERE id_empleado=(SELECT id_empleado FROM asignaciones WHERE id_tarea=(SELECT id_tarea FROM tareas WHERE id_proyecto=(SELECT id_proyecto FROM proyectos WHERE nombre_proyecto LIKE 'Proyecto Epsilon')));
/*RESULTADO:
ID_EMPLEADO NOMBRE                                                                                               APELLIDO                                                                                             EMAIL                                                                                                                                                  TELEFONO       
----------- ---------------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ---------------
          8 Sof�a                                                                                                D�az                                                                                                 sofia.diaz@example.com
*/

/*7.Datos del proyecto que mas ha tardado en finalizar*/
SELECT nombre_proyecto ,max(abs(EXTRACT(month from fecha_fin)-EXTRACT(month from fecha_inicio))) as "duracion"
FROM proyectos
GROUP BY nombre_proyecto;
/*
RESULTADO: 
NOMBRE_PROYECTO                                                                                        duracion
---------------------------------------------------------------------------------------------------- ----------
Proyecto Gamma                                                                                                9
*/

/*8.Proyectos que han tenido tareas con m�s de 20 d�as de duraci�n**/
SELECT id_proyecto, nombre_proyecto
FROM proyectos
WHERE fecha_fin is not null and (EXTRACT(day from fecha_fin)- EXTRACT(day from fecha_inicio))>20;
/*RESULTADO:
ID_PROYECTO NOMBRE_PROYECTO                                                                                     
----------- ----------------------------------------------------------------------------------------------------
          1 Proyecto Alpha                                                                                      
          2 Proyecto Beta                                                                                       
          7 Proyecto Eta   
         
*/
/*9. Proyectos cuyo tiempo total (diferencia entre fecha de inicio y fin) es mayor
al promedio de todos los proyectos*/

/*resultado:
  DURACION NOMBRE_PROYECTO                                                                                     
---------- ----------------------------------------------------------------------------------------------------
       213 Proyecto Beta                                                                                       
       305 Proyecto Gamma                                                                                      
*/
/*10.Cantidad de empleados que tiene asignada cada tarea*/
SELECT id_tarea, count(id_empleado) as "Numero_empleado"
FROM asignaciones
GROUP BY id_tarea, id_empleado;
/*resultado:
 ID_TAREA Numero_empleado
---------- ---------------
         1               1
         2               1
         3               1
         4               1
         5               1
         6               1
         7               1
         8               1
         9               1
        10               1
        11               1

*/