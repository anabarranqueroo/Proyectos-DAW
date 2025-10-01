/*Actividad 8*/

/*Tablas EMPLE y DEPART*/

/*Ejercicio 1*/
SELECT emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no  
FROM emple
WHERE apellido Like 'M%' and oficio Like '%V%';
/*Ejercicio 2*/
SELECT apellido, oficio, loc 
FROM depart, emple
WHERE emple.dept_no=depart.dept_no and oficio Like 'ANALISTA';
/*Ejercicio 3*/
SELECT apellido, oficio, salario, EXTRACT(year FROM fecha_alt)
FROM emple
WHERE (oficio = (SELECT oficio FROM emple WHERE apellido Like 'TOVAR')) and
(salario >= (SELECT salario FROM emple WHERE apellido Like 'ALONSO'));
/*Ejecicio 4*/
SELECT apellido, oficio, salario, dept_no
FROM emple
WHERE dept_no=(SELECT dept_no FROM emple WHERE apellido Like 'SANCHEZ') and 
salario = (SELECT salario FROM emple WHERE apellido Like 'SANCHEZ');
/*Ejercicio 5*/
SELECT apellido, oficio
FROM emple
WHERE oficio=(SELECT oficio FROM emple WHERE apellido Like 'JIMENEZ');

/*Tabla LIBRERIA*/

/*Ejercicio 1*/
SELECT tema, estante, ejemplares
FROM libreria
WHERE ejemplares >=8 and ejemplares <=15
ORDER BY 3;
/*Ejercicio 2*/
SELECT tema, estante, ejemplares
FROM libreria
WHERE estante Not Between 'C' and 'E';
/*Ejercicio 3*/
SELECT tema
FROM libreria
WHERE ejemplares<(SELECT ejemplares FROM libreria WHERE tema = 'Deportes');
/*Ejercicio 4*/
SELECT tema
FROM libreria
WHERE ejemplares Between '15' and '20';


/*Tabla ALUMNOS, ASIGNATURAS y NOTAS*/

/*Ejercicio 1*/
SELECT cod, nombre, pobla
FROM alumnos natural join notas natural join asignaturas
WHERE alumnos.pobla='Madrid' and nombre Like '%o%o%';
/*Ejercicio 2*/
SELECT apenom 
FROM alumnos natural join notas natural join asignaturas
WHERE nombre like 'FOL' and nota between '5' and '8';
/*Ejercicio 3*/
SELECT apenom, nota, pobla
FROM alumnos natural join notas natural join asignaturas
WHERE pobla like 'Madrid' and nota Like '5';
/*Ejercicio 4*/
/*Ejercicio 5*/