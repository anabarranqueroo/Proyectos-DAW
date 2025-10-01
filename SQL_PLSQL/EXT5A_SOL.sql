/*nombre y apellidos:

/*1. Dar de alta con fecha actual al empleado Jose Escriche Barrera como
programador perteneciente al departamento de informática.Tendra 
un salario base de 7000 euros/mes y no cobrara comision, 
¿que dificultad plantea el alta de este empleado? ¿Como podria solucionarse ?(1 punto)*/
INSERT INTO DEPT(DEPT_NO,DNOMBRE,LOC)
VALUES(60,'INFORMATICA','MADRID');

INSERT INTO EMP(EMP_NO,APELLIDO,OFICIO,FECHA_ALT,SALARIO,COMISION,DEPT_NO)
VALUES(8596,'ESCRICHE','PROGRAMADOR',SYSDATE,70000,0,60);

SELECT * FROM DEPT;
SELECT * FROM EMP;
/*2. El departamento de ventas por motivos económicos se traslada a Lerida, 
realizar dicha modificación.(1 punto)*/

UPDATE DEPT SET LOC= 'LERIDA' WHERE DNOMBRE='VENTAS';
/*3. Modificar la comisión de los empleados de la empresa, de forma que todos 
tengan un incremento del 10% del salario.(1 punto)*/
UPDATE EMP SET SALARIO= SALARIO*1.10;
/*4. Crear una tabla llamada Mujeres con los mismos campos que la tabla enfermos e insertar los enfermos con este sexo.(1 punto)*/

--OPCION1
CREATE TABLE MUJERES
   (	INSCRIPCION NUMBER(*,0) NOT NULL ENABLE, 
	APELLIDO VARCHAR2(50 BYTE), 
	DIRECCION VARCHAR2(50 BYTE), 
	FECHA_NAC DATE, 
	S VARCHAR2(2 BYTE), 
	NSS NUMBER(*,0)
   ); 
   
  INSERT INTO MUJERES SELECT * FROM ENFERMO WHERE S = 'F';
  ---OPCION 2
  CREATE TABLE MUJERES AS 
SELECT * FROM ENFERMO WHERE S = 'M'; 
 
/*5. Subir el salario en 6000 y la comisión en 225 respectivamente a los empleados
que se dieron de alta despues de 1987.(1 punto)*/
SELECT * FROM EMP;
UPDATE EMP SET SALARIO=6000+SALARIO, COMISION=COMISION+255
            WHERE TO_CHAR(FECHA_ALT, 'YYYY')>'1987;
            
            
/*6. Borrar todos los registros de la tabla Mujeres cuya que hayan nacido antes de 1967.(1 punto)*/
DELETE FROM MUJERES WHERE TO_CHAR(FECHA_NAC, 'YY')<'67;
/*7.Borrar todos los enfermos nacidos entre las fechas 01/01/40 y 31/12/45.(1 punto)*/
DELETE FROM enfermo WHERE TO_CHAR(FECHA_nac,'YYYY')BETWEEN '1940' AND '1945';
/*8.Cambiar a turno de mañana 'M' a toda la plantilla del hospital 'La Paz' que tenga turno de tarde 'T'.(2 puntos) */
UPDATE PLANTILLA 
SET T='M' WHERE HOSPITAL_COD=( SELECT HOSPITAL_COD 
                            FROM HOSPITAL 
                            WHERE UPPER( NOMBRE)='LA PAZ')
            and T='T';
         
/*9.Borra todas las tablas. (1 punto)*/
DROP TABLE DEPT CASCADE CONSTRAINTS;
DROP TABLE EMP CASCADE CONSTRAINTS;
DROP TABLE HOSPITAL CASCADE CONSTRAINTS;
DROP TABLE PLANTILLA CASCADE CONSTRAINTS;
DROP TABLE SALA CASCADE CONSTRAINTS;
DROP TABLE MUJERES CASCADE CONSTRAINTS;
DROP TABLE ENFERMO CASCADE CONSTRAINTS;
DROP TABLE DOCTOR CASCADE CONSTRAINTS;