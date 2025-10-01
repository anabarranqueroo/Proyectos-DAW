/*

TIPO B:
Nombre: Ana Esteban Barranquero

************************************************************************
	INSTRUCCIONES:
	==============
Indicaciones: Usa el esquema de base de datos proporcionado para resolver las preguntas. 
Asegúrate de incluir la sintaxis completa de las consultas SQL.

-Salva este fichero con las iniciales de tu nombre y apellidos,
 en el directorio "C:\Examen\ ":
	

-Pon tu nombre al ejercicio y lee atentamente todas las preguntas.


-Carga el script para el examen desde el fichero "DatosExamen.sql".

-Donde ponga "SQL>", ESCRIBE las sentencias SQL que has utilizado.

-Donde ponga "Resultado:" copiarás el resultado que SQL*Plus te devuelve.

-RECUERDA: guardar, cada cierto tiempo, el contenido de este fichero. 
Es lo que voy a evaluar, si lo pierdes, lo siento, en la recuperación 
tendrás otra oportunidad.
********************************************************************
1.-Recupera el nombre y la especialidad de todos los profesores.
SQL*/
SELECT nombre_pr AS "Nombre profesor", especialidad_pr AS "Especialidad"
FROM profesores;

/*RESULTADO: 
Nombre profesor           Especialidad   
------------------------- ---------------
Del Junco Suarez, Malvina INFORMATICA    
Matito Lozano, Carmen     SISTEMAS       
Toscano Fernandez, Juan   INFORMATICA    
Valverde Gallego, Enrique ECONOMIA
*/


/********************************************************************
2.- Muestra los nombres de los alumnos nacidos después del 1 de enero de 1996.
El resultado debe mostrar el siguiente formato:
ALUMNOS NACICIDOS A PARTIR DE 
------------------------------
Carmona Castro, Nicolas M.   
Gomez Diaz, Daniel           
Gonzalez Flores, Francisco J.
Oancea , Dragos Andrei       
Silva Mulero, Jeronimo      
SQL*/
SELECT nombre_al AS "Alumnos nacidos a partir de"
FROM alumnos
WHERE fecnac_al > '01/01/1996';
/*RESULTADO:
Alumnos nacidos a partir de   
------------------------------
Carmona Castro, Nicolas M.   
Gomez Diaz, Daniel           
Gonzalez Flores, Francisco J.
Oancea , Dragos Andrei       
Silva Mulero, Jeronimo
*/

/********************************************************************
3.-Muestra los nombres de los alumnos junto con las asignaturas que cursan. 
eL RESULTADO DE PRESENTAR EL SIGUIENTE FORMATO:
ALUMNO                                    ASIGNATURA                         
----------------------------------------- -----------------------------------
Casado Ortega, Emilio        ...cursa...  Entornos de desarrollo  
SQL*/
SELECT DISTINCT a.nombre_al||'...cursa...' AS "Alumno", asi.nombre_as AS "Asignatura"
FROM alumnos a JOIN notas n ON a.cod_al = n.alumno_no JOIN asignaturas asi ON n.asignatura_no = asi.cod_as;

/*RESULTADO:
Alumno                                    Asignatura                         
----------------------------------------- -----------------------------------
Casado Ortega, Emilio        ...cursa...  Lenguajes de marcas                
Silva Mulero, Jeronimo       ...cursa...  Formacion y orientacion laboral    
Oria Guerrero, Leopoldo      ...cursa...  Entornos de desarrollo             
Ramirez Richarte, Jesus      ...cursa...  Bases de datos                     
Perez Lobato, Eduardo Jesus  ...cursa...  Bases de datos                     
Gonzalez Flores, Francisco J....cursa...  Entornos de desarrollo             
Casado Ortega, Emilio        ...cursa...  Entornos de desarrollo             
Oancea , Dragos Andrei       ...cursa...  Entornos de desarrollo             
Carmona Castro, Nicolas M.   ...cursa...  Entornos de desarrollo             
Olmo Reyes, Marcos Manuel    ...cursa...  Entornos de desarrollo             
Carmona Castro, Nicolas M.   ...cursa...  Bases de datos                     

Alumno                                    Asignatura                         
----------------------------------------- -----------------------------------
Cornejo Fernandez-Gao, Ramiro...cursa...  Lenguajes de marcas                
Carmona Castro, Nicolas M.   ...cursa...  Lenguajes de marcas                
Sanchez Soriano, Jose Antonio...cursa...  Bases de datos                     
Ruiz Sanchez, Alejandro      ...cursa...  Bases de datos                     
Gomez Diaz, Daniel           ...cursa...  Lenguajes de marcas                
Silva Mulero, Jeronimo       ...cursa...  Bases de datos                     

*/


/********************************************************************
4.- Lista las asignaturas junto con el nombre del profesor que las imparte y las
horas semanales asociadas.El resultado debe mostrar el siguiente formato:
ASIGNATURA                 PROFESOR                                    HORAS A LA SEMANA
-------------------------- ------------------------------------------- -----------------
Lenguajes de marcas        IMPARTIDA POR:  Del Junco Suarez, Malvina                 4
SQL*/
SELECT asi.nombre_as AS "Asignatura", p.nombre_pr AS "Profesor", cl.horassem_cl AS "Horas a la semana"
FROM asignaturas asi JOIN clases cl ON asi.cod_as = cl.asignatura_cl JOIN profesores p ON cl.profesor_cl = p.cod_pr;

/*RESULTADO:
Asignatura                          Profesor                  Horas a la semana
----------------------------------- ------------------------- -----------------
Lenguajes de marcas                 Del Junco Suarez, Malvina                 4
Entornos de desarrollo              Toscano Fernandez, Juan                   3
Bases de datos                      Del Junco Suarez, Malvina                 6
Programacion                        Toscano Fernandez, Juan                   8
Sistemas informaticos               Matito Lozano, Carmen                     6
Formacion y orientacion laboral     Valverde Gallego, Enrique                 3
*/

/********************************************************************
5.-Lista todos los profesores y, si existe, las asignaturas que imparten. 
Incluye a los profesores que aún no tienen asignaturas asignadas.El resultado 
debe mostrar el siguiente formato:
PROFESOR                  ASIGNATURAS                                       
------------------------- --------------------------------------------------
Del Junco Suarez, Malvina ...IMPARTE.....Lenguajes de marcas  
SQL*/
SELECT p.nombre_pr AS "Profesor", '...IMPARTE...'||asi.nombre_as AS "Asignaturas"
FROM asignaturas asi FULL JOIN clases cl ON asi.cod_as = cl.asignatura_cl JOIN profesores p ON cl.profesor_cl = p.cod_pr;

/*RESULTADO:
Profesor                  Asignaturas                                     
------------------------- ------------------------------------------------
Del Junco Suarez, Malvina ...IMPARTE...Lenguajes de marcas                
Del Junco Suarez, Malvina ...IMPARTE...Bases de datos                     
Matito Lozano, Carmen     ...IMPARTE...Sistemas informaticos              
Toscano Fernandez, Juan   ...IMPARTE...Entornos de desarrollo             
Toscano Fernandez, Juan   ...IMPARTE...Programacion                       
Valverde Gallego, Enrique ...IMPARTE...Formacion y orientacion laboral
*/

/********************************************************************
6.-Mostrar, de cada asignatura, su nombre y la nota media (CON DOS DECIMALES).
SQL*/
SELECT asi.nombre_as AS "Asignatura", ROUND(avg(n.nota_no),2) AS "Nota Media"
FROM asignaturas asi JOIN notas n ON asi.cod_as = n.asignatura_no
GROUP BY asi.nombre_as;


/*RESULTADO:
Asignatura                          Nota Media
----------------------------------- ----------
Formacion y orientacion laboral           8,83
Entornos de desarrollo                    5,93
Lenguajes de marcas                       6,65
Bases de datos                            6,91
*/
/********************************************************************
7.-Calcula el número total de profesores que imparten clases y el total 
de horas semanales impartidas por todos.
SQL*/
SELECT count(DISTINCT profesor_cl) AS "Nº Profesores", sum(horassem_cl)AS "Total de Horas Semanales"
FROM clases;
/*RESULTADO:
Nº Profesores Total de Horas Semanales
------------- ------------------------
            4                       30
*/

/********************************************************************
8.- Lista el número de alumnos agrupados por su tutor.
SQL*/
SELECT count(a.cod_al) AS "Nº Alumnos", p.nombre_pr AS "Tutor"
FROM alumnos a JOIN profesores p ON a.tutor_al = p.cod_pr
GROUP BY p.nombre_pr;

/*RESULTADO:
Nº Alumnos Tutor                    
---------- -------------------------
         7 Matito Lozano, Carmen    
         6 Del Junco Suarez, Malvina
*/

/********************************************************************
9.- Obtén los nombres de los profesores que imparten clases en asignaturas con 
más de 20 horas lectivas.
SQL*/
SELECT p.nombre_pr AS "Profesor", cl.horassem_cl AS "Horas Lectivas"
FROM profesores p JOIN clases cl ON p.cod_pr = cl.profesor_cl JOIN asignaturas asi ON cl.asignatura_cl = asi.cod_as
GROUP BY  p.nombre_pr, cl.horassem_cl
HAVING sum(cl.horassem_cl) > 20;

/*RESULTADO:
no se ha seleccionado ninguna fila
*/

/********************************************************************

10.-Muestra los nombres de los alumnos y la suma total de horas de las asignaturas que cursan.
El resultado 
debe mostrar el siguiente formato:
ALUMNO                         TOTAL_HORAS_ASIGNATURAS                       
------------------------------ ----------------------------------------------
Sanchez Soriano, Jose Antonio  576 HORAS           
SQL*/
SELECT a.nombre_al AS "Alumno", sum(asi.horas_as)||' HORAS' AS "Total_Horas_asignaturas"
FROM alumnos a JOIN notas n ON a.cod_al = n.alumno_no JOIN asignaturas asi ON n.asignatura_no = asi.cod_as
GROUP BY a.nombre_al;
          
/*RESULTADO:
Alumno                         Total_Horas_asignaturas                       
------------------------------ ----------------------------------------------
Carmona Castro, Nicolas M.     1248 HORAS                                    
Gonzalez Flores, Francisco J.  288 HORAS                                     
Silva Mulero, Jeronimo         864 HORAS                                     
Ruiz Sanchez, Alejandro        576 HORAS                                     
Cornejo Fernandez-Gao, Ramiro  384 HORAS                                     
Casado Ortega, Emilio          672 HORAS                                     
Oancea , Dragos Andrei         288 HORAS                                     
Perez Lobato, Eduardo Jesus    576 HORAS                                     
Oria Guerrero, Leopoldo        288 HORAS                                     
Olmo Reyes, Marcos Manuel      288 HORAS                                     
Sanchez Soriano, Jose Antonio  576 HORAS                                     

Alumno                         Total_Horas_asignaturas                       
------------------------------ ----------------------------------------------
Gomez Diaz, Daniel             384 HORAS                                     
Ramirez Richarte, Jesus        576 HORAS    
*/

/********************************************************************

