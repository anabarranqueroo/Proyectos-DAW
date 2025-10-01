/*1. Para cada departamento con presupuesto inferior a 35.000 C, hallar el nombre del
Centro donde está ubicado y el máximo salario de sus empleados (si dicho máximo
excede de 1.500). Clasificar alfabéticamente por nombre de departamento.
*/
SELECT D.NOMDE , C.NOMCE ,MAX(E.SALAR)
FROM DEPARTAMENTOS D JOIN CENTROS C ON D.NUMCE=C.NUMCE JOIN EMPLEADOS E ON E.NUMDE=D.NUMDE
WHERE D.PRESU <35
GROUP BY D.NOMDE ,C.NOMCE
HAVING MAX(E.SALAR)>1500
ORDER BY NOMDE;

/*2. Hallar por orden alfabético los nombres de los departamentos que dependen de los
que tienen un presupuesto inferior a 30.000 C. También queremos conocer el
nombre del departamento del que dependen y su presupuesto.
*/

SELECT D.NOMDE "DEPARTAMENTO" ,D2.NOMDE "DPT DEL QUE DEPENDE", D2.PRESU
FROM DEPARTAMENTOS D JOIN DEPARTAMENTOS D2 ON D.DEPDE=D2.NUMDE
WHERE D2.PRESU<30
ORDER BY 1;

/*3. Obtener los nombres y los salarios medios de los departamentos
cuyo salario medio supera al salario medio de la empresa.
*/
SELECT D.NOMDE "DEPARTAMENTO", ROUND(AVG(E.SALAR),2)||'$' "SALARIO MEDIO"
FROM DEPARTAMENTOS D JOIN EMPLEADOS E ON D.NUMDE=E.NUMDE
GROUP BY D.NOMDE
HAVING AVG(SALAR)> (SELECT AVG(SALAR)
                    FROM EMPLEADOS
)
ORDER BY 2 DESC;

/*4.-Para los departamentos cuyo director lo sea en funciones, hallar el número de
empleados y la suma de sus salarios, comisiones y número de hijos
*/
SELECT D.NOMDE AS "DEPARTAMENTO",COUNT(E.NUMEM) AS "NUMERO_EMPLEADOS",SUM (SALAR),SUM (COMIS), SUM(NUMHI)
FROM DEPARTAMENTOS D
JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE D.TIDIR = 'F'
GROUP BY D.NOMDE;

SELECT D.NOMDE ,D.NUMDE AS "DEPARTAMENTO",COUNT(E.NUMEM) AS "NUMERO_EMPLEADOS",SUM (SALAR),SUM (COMIS), SUM(NUMHI)
FROM DEPARTAMENTOS D
JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE D.TIDIR = 'F'
GROUP BY D.NUMDE, D.NOMDE;

/*5. Para los departamentos cuyo presupuesto anual supera los
35.000 €, hallar cuántos empleados hay por cada extensión
telefónica.

*/
SELECT  NOMDE, E.EXTEL AS "EXTENSION",COUNT(E.NUMEM) AS "NUMERO_EMPLEADOS"
FROM DEPARTAMENTOS D JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE D.PRESU > 35
GROUP BY E.EXTEL,D.NOMDE
ORDER BY 3;

/*6. Hallar por orden alfabético los nombres de los empleados y su
número de hijos para aquellos que son directores en funciones.

*/
SELECT E.NOMEM AS "EMPLEADO",E.NUMHI AS "NUMERO_HIJOS", TIDIR,DIREC,NUMEM
FROM EMPLEADOS E JOIN DEPARTAMENTOS D ON D.NUMDE = E.NUMDE
WHERE D.TIDIR = 'F';

SELECT NoMEM
from empleados
WHERE NUMEM = '180';


SELECT E.NOMEM AS "EMPLEADO",E.NUMHI AS "NUMERO_HIJOS"
FROM EMPLEADOS E JOIN DEPARTAMENTOS D ON D.NUMDE = E.NUMDE
WHERE NUMEM IN (SELECT DIREC
             FROM DEPARTAMENTOS
            WHERE TIDIR = 'F')
ORDER BY E.NUMHI;

/*7. Muestra los nombres de departamentos que no tienen empleados
haciendo uso de la combinación externa LEFT JOIN. Muestra una
segunda columna con los nombres de empleados para asegurarnos
que realmente está a NULL.
*/
SELECT D.NOMDE AS "DEPARTAMENTO",E.NOMEM AS "EMPLEADO"
FROM DEPARTAMENTOS D LEFT JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE E.NUMEM IS NULL;

/*8. Muestra los nombres de departamentos que no tienen empleados
haciendo uso de la combinación externa RIGH JOIN. Muestra una segunda columna con los nombres de empleados para asegurarnos
que realmente está a NULL.

*/
SELECT D.NOMDE AS "DEPARTAMENTO",
       E.NOMEM AS "EMPLEADO"
FROM EMPLEADOS E
RIGHT JOIN DEPARTAMENTOS D ON D.NUMDE = E.NUMDE
WHERE E.NUMEM IS NULL;

/*9. Muestra los nombres de empleados que no tienen departamento
haciendo uso de la combinación externa LEFT JOIN. Muestra una
segunda columna con los nombres de departamentos para
asegurarnos que realmente está a NULL.

*/
SELECT E.NOMEM AS "EMPLEADO",
       D.NOMDE AS "DEPARTAMENTO"
FROM EMPLEADOS E
LEFT JOIN DEPARTAMENTOS D ON E.NUMDE = D.NUMDE
WHERE D.NUMDE IS NULL;

/*10. Muestra los nombres de empleados que no tienen departamento
haciendo uso de la combinación externa RIGHT JOIN. Muestra una
segunda columna con los nombres de empleados para asegurarnos
que realmente está a NULL
*/
SELECT E.NOMEM AS "EMPLEADO",
       D.NOMDE AS "DEPARTAMENTO"
FROM DEPARTAMENTOS D
RIGHT JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE D.NUMDE IS NULL;

/*11. Muestra los departamentos que no tienen empleados y los
empleados que no tiene departamento haciendo uso de la
combinación externa FULL JOIN.
*/
SELECT D.NOMDE AS "DEPARTAMENTO",
       E.NOMEM AS "EMPLEADO"
FROM DEPARTAMENTOS D
FULL JOIN EMPLEADOS E ON D.NUMDE = E.NUMDE
WHERE D.NUMDE IS NULL OR E.NUMEMP IS NULL;

/*12. Muestra a los empleados y sus respectivos departamentos
haciendo uso de la combinación interna INNER JOIN. ¿Aparecen
el departamento NUEVO y el empleado NORBERTO?¿Por qué?
*/
SELECT E.NOMEM AS "EMPLEADO",
       D.NOMDE AS "DEPARTAMENTO"
FROM EMPLEADOS E
INNER JOIN DEPARTAMENTOS D ON E.NUMDE = D.NUMDE;

/*13. Realiza la misma consulta anterior donde se cumpla la
condición que NUMDE está a NULL. ¿Aparece algún resultado?¿Por
qué?
*/
SELECT E.NOMEM AS "EMPLEADO",
       D.NOMDE AS "DEPARTAMENTO"
FROM EMPLEADOS E
LEFT JOIN DEPARTAMENTOS D ON E.NUMDE = D.NUMDE
WHERE E.NUMDE IS NULL;

/*14. Muestra la combinación de las 3 tablas CENTROS,
DEPARTAMENTOS y EMPLEADOS haciendo uso de NATURAL JOIN.
*/
SELECT *
FROM CENTROS
NATURAL JOIN DEPARTAMENTOS
NATURAL JOIN EMPLEADOS;