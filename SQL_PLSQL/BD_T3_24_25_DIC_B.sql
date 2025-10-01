--TIPO B
--------------------------------------------------------------------------------------

-- Nombre: Pon_aquí_tu_nombre

--------------------------------------------------------------------------------------
-- INSTRUCCIONES
--------------------------------------------------------------------------------------

-----Pon tu nombre arriba y lee atentamente todas las preguntas.
/*
- Entra en SQL-Developer y desde la conexión asociada system debes crearte un usuario
con nombre EXAMENT3 y contraseña 123456. En Tablespace por defecto elegir USERS, 
en Tablespace por defecto: TEMP. En la pestaña Roles otorgados elige Adminitrar todo.
-Una vez creado el usuario debes crear la conexión que ahora se va a llamar EXAMENT3. 
Tendrá como ususrio el usuario EXAMENT3.

- Carga el script para el examen desde el fichero "GESTPROY_datos.sql".

- Donde ponga "SQL>", copiarás las sentencias SQL que has utilizado.

- Donde ponga "Resultado:" copiarás el resultado que SQL te devuelve.

- RECUERDA: guardar, cada cierto tiempo, el contenido de este fichero. 
Es lo que voy a evaluar, si lo pierdes, lo siento, en la recuperación tendrás otra oportunidad.

--------------------------------------------------------------------------------------
-- PUNTUACIÓN
--------------------------------------------------------------------------------------

--Preguntas: 1 puntos cada respuesta correcta

--------------------------------------------------------------------------------------
-- CRITERIOS
--------------------------------------------------------------------------------------

-- Las consultas deben poder ejecutarse (sin errores de sintaxis) 

-- Deben mostrar la información pedida.
/*1. **Listar los proyectos en espera ordenados por nombre**/

/*2.Mostrar el nombre y descripcion de las tarea que no tiene asignado ningun proyecto ***/


/*RESULTADO:
TAREAS SIN PROYECTO                                                                                                                                                                                                                                                                                                                                                   
-----------------------------------------------------------------
Optimización de procesos : Reducción de tiempos de ejecución
Automatización de flujos : Uso de herramientas de automatización
Pruebas de calidad : Revisión de casos de prueba*/
/*3.Obtener las tareas EN CURSO ordenadas por fecha de finalización*/


/*RESULTADO:
Finaliza TAREA en curso                                                                                      
-------- -----------------------------------
15/02/24 Diseño del sistema                                                                                  
10/03/24 Diseño de interfaz                                                                                  
15/08/24 Integración con sistemas existentes 
*/
/*4.Contar cuántos proyectos hay en cada cada estado*/

/*RESULTADO
ESTADO                   TOTALP
-------------------- ----------
En espera                     4
Activo                       11
*/
/*/*5.Listar  nombre y correo electrónico de los empleados que realizan la tarea de Pruebas iniciales*/


/*REULTADO:
Empleado                                                                                                                                                                                                 
--------------------------
Jorge Hernández

/*6.Averigua que empleados tienen asignadas tarea en el proyecto Proyecto Epsilon*/

/*RESULTADO:
EMPLEADO                                                                                                                                                                                                 
---------------
Sofía Díaz
*/

/*7.Datos del proyecto que mas ha tardado en finalizar*/

/*8.Proyectos que han tenido tareas con más de 20 días de duración**/


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

/*resultado:
ID_TAREA NUMERO_EMPLEADOS
---------- ----------------
         1                1
         2                1
         3                1
         4                1
         5                1
         6                1
         7                1
         8                1
         9                1
        10                1
        11                1

*/