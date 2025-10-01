/*1. Dar de alta con fecha actual a la empleada María Najera García como 
programadora perteneciente al departamento de informatica situado en Fuenlabrada (Madrid).
Tendra un salario basede 5000 €/mes y no cobrara comision,
¿qué dificultad plantea el alta de este empleado? ¿Cómo podria solucionarse ?*/

INSERT INTO DEPT(DEPT_NO,DNOMBRE,LOC)
VALUES(70,'INFORMATICA','FUENLABRADA');

INSERT INTO EMP(EMP_NO,APELLIDO,OFICIO,FECHA_ALT,SALARIO,COMISION,DEPT_NO)
VALUES(8597,'NAJERA','PROGRAMADOR',SYSDATE,5000,0,70);
ROLLBACK;
/*2. En el departamento de ventas se dan de alta dos empleados: Alfonso Fernandez y Ana Prados. 
Su salario base es de 80000 y cobrarán una comisión del 15% de su salario.*/

INSERT INTO EMP(DEPT_NO,APELLIDO,SALARIO,COMISION,EMP_NO)
VALUES(30, 'FERNANDEZ',80000,80000*0.15,7500);

INSERT INTO EMP(DEPT_NO,APELLIDO,SALARIO,COMISION,EMP_NO)
VALUES(30, 'PRADOS',80000,80000*0.15,7600);

/*3. Incrementar un 5% el salario de los interinos de la plantilla que trabajen
en el turno de noche.*/

UPDATE PLANTILLA SET SALARIO = SALARIO*1.05 WHERE upper(FUNCION)='INTERINO'
AND T='N';

/*4. Se tienen que desplazar cincuenta camas del Hospital La Paz para otro Hospital.
Actualizar el número de camas del Hospital SAN CARLOS.*/

UPDATE HOSPITAL SET NUM_CAMA = NUM_CAMA+50 WHERE NOMBRE='San Carlos';

UPDATE HOSPITAL SET NUM_CAMA = NUM_CAMA - 50  WHERE NOMBRE LIKE 'La Paz';
/*5. Crear una tabla llamada Empleados e introducir todos los datos de la 
tabla EMP en ella.*/

CREATE TABLE EMPLEADOS
(
Emp_No NUMBER NOT NULL,
Apellido VARCHAR2(50) NULL,
Oficio VARCHAR2(50) NULL,
Dir NUMBER NULL,
Fecha_Alt DATE NULL,
Salario NUMBER(9,2) NULL,
Comision NUMBER(9,2) NULL,
Dept_No NUMBER NULL
);

INSERT INTO EMPLEADOS SELECT * FROM EMP;

--OPCION 2
CREATE TABLE EMPLEADOS AS (SELECT * FROM EMP);

/*6.Borra los campos de emp donde tienen relacion con informática*/

delete from emp 
where DEPT_NO =(SELECT DEPT_NO FROM DEPT WHERE DNOMBRE= 'INFORMATICA');

/*7. Borrar de la al enfermo con número de inscripción igual a 64823.*/

DELETE FROM enfermo WHERE INSCRIPCION= '64823';

/*8.Borrar todos los empleados dados de alta entre las fechas 01/01/80 y 31/12/82.*/

DELETE FROM EMPLEADOS WHERE TO_CHAR(FECHA_ALT,'YY') BETWEEN '80' AND '82';



DROP TABLE SALA CASCADE CONSTRAINTS;
DROP TABLE PLANTILLA CASCADE CONSTRAINTS;
DROP TABLE HOSPITAL CASCADE CONSTRAINTS;
DROP TABLE ENFERMO CASCADE CONSTRAINTS;
DROP TABLE EMP CASCADE CONSTRAINTS;
DROP TABLE EMPLEADOS CASCADE CONSTRAINTS;
DROP TABLE DOCTOR CASCADE CONSTRAINTS;
DROP TABLE DEPT CASCADE CONSTRAINTS;
