/*ACTIVIDAD 5*/
/*ejercicio 1*/
SELECT nomem, comis
FROM empleados
WHERE numde=110 and EXISTS (SELECT comis FROM empleados)
ORDER BY nomem;

/*ejercicio 2*/
SELECT nomde
FROM departamentos
WHERE (nomde NOT LIKE 'DIRECC%') AND (nomde NOT LIKE 'SECTOR%') AND EXISTS 
(SELECT 1 FROM  departamentos);

/*ejercicio 3*/
SELECT nomem AS Nombre, salar ||'€' AS Salario
FROM empleados
WHERE (numhi=0 and salar>1500) OR (numhi>0 and salar<1000)
ORDER BY 1;

/*ejercicio 4*/
SELECT 'nº'||numem as "Numero_Empleado",nomem as "Nombre" , salar+comis ||'€' as "Salario_total"
FROM empleados
WHERE (salar+comis)> 1800+(SELECT min (salar) FROM empleados);


/*ejercicio 5*/
SELECT nomem, salar 
FROm empleados
WHERE numde=111 AND EXISTS (SELECT comis FROM empleados WHERE (comis IS NOT NULL) and (comis>salar*0.15))
ORDER BY 1;

/*ejercicio 6*/
SELECT nomde as "Nombre de departamento", tidir as "T", presu as "Presupuesto"
FROM departamentos
WHERE (tidir LIKE'F' or tidir LIKE 'P')and presu>30.000;

/*ejercicio 7*/
SELECT nomde as "Nombre de departamento", tidir as "T", presu ||'.000€' as "Presupuesto"
FROM departamentos
WHERE (tidir LIKE'F' or tidir LIKE 'P')and presu>30.000;
