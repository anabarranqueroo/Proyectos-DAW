/*Actividad 1*/
SELECT nomem, fecna 
FROM empleados
WHERE EXTRACT(month FROM fecna)=11
ORDER BY 1;

/*Actividad 2*/
SELECT nomem
FROM empleados
WHERE fecna=sysdate;

/*Actividad 3*/
SELECT nomem, fecna
FROM empleados
WHERE EXTRACT(year FROM fecna)<1950;

/*Actividad 4*/
SELECT nomem, fecin
FROM empleados
WHERE EXTRACT(year FROM fecin)<1970;

/*Actividad 5*/
SELECT nomem, fecna, fecin
FROM empleados
WHERE (EXTRACT(year FROM fecna))-(EXTRACT(year FROM fecin))<30;

/*Actividad 6*/
SELECT nomem, TO_CHAR(fecna, 'day')"Dia de nacimiento" 
FROM empleados
WHERE TO_CHAR(fecna, 'D')='1';

/*Actividad 7*/
SELECT nomem, TO_CHAR(fecna, 'day')"viernes para nac. e incorp." 
FROM empleados
WHERE TO_CHAR(fecna, 'D')='5' and TO_CHAR(fecin, 'D')='5';

/*Actividad 8*/
SELECT nomem, TO_CHAR(fecna, 'day')"Mismo dia de nac. e incorp"
FROM empleados
WHERE TO_CHAR(fecna, 'D')=TO_CHAR(fecin, 'D');

/*Actividad 9*/
SELECT nomem, TO_CHAR(fecin,'month')"Mes incorporacion"
FROM empleados
WHERE EXTRACT(MONTH FROM fecin) BETWEEN 1 AND 6;

/*Actividad 10*/
SELECT nomem, TO_CHAR(fecin, 'month')"Mes de incorporacion"
FROM empleados
WHERE EXTRACT(MONTH FROM fecin)BETWEEN 1 and 6 
and EXTRACT(MONTH FROM fecin)=EXTRACT(MONTH FROM fecna);


