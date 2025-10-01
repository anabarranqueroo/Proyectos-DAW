/*ACTIVIDAD 13*/

/*Ejercicio 1*/
SELECT nomem, salar+0.01*salar 
FROM empleados
WHERE numde = 100 and (EXTRACT(year from sysdate) - EXTRACT(year from fecin)) > 20
ORDER BY 1 desc;

/*Ejercicio 2*/
SELECT numce, avg(presu)
FROM departamentos
GROUP BY numce;

/*Ejercicio 3*/
SELECT nomem, EXTRACT (year from sysdate)- EXTRACT (year from fecna) as "EDAD"
FROM empleados e join departamentos d on e.numde = d.numde
WHERE nomde LIKE 'PERSONAL';

/*Ejercicio 4*/
SELECT dirce, nomde
FROM centros c join departamentos d on c.numce = d.numce
JOIN empleados e on d.numde = e.numde
WHERE e.numhi > 3;

/*Ejercicio 5*/
SELECT dirce, nomde
FROM centros c join departamentos d on c.numce = d.numce
JOIN empleados e on d.numde = e.numde
WHERE e.numhi > 3
GROUP BY dirce, nomde;

/*Ejercicio 6*/
SELECT count(numem), numhi
FROM empleados
GROUP BY numhi;

/*Ejercicio 7*/
create or replace view sincomision as 
SELECT nomem, EXTRACT (year from sysdate)- EXTRACT (year from fecna) as "EDAD ACTUAL", salar as "SALARIO"
FROm empleados
WHERE comis is null;

/*Ejercicio 8*/
SELECT avg(salario)
FROM sincomision;

/*Ejercicio 9*/
SELECT nomde, max(salar)
FROm departamentos d join empleados e on d.numde = e.numde
GROUP BY nomde
HAVING max(salar) < 2000;

/*Ejercicio 12*/
SELECT c.dirce, e.nomem, d.nomde, d.direc
FROM centros c join departamentos d on c.numce = d.numce
JOIN empleados e on d.numde = e.numde
WHERE e.nomem LIKE 'J%';