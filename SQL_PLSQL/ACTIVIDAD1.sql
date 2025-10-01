/*1. Hacer un procedimiento que muestre el nombre y el salario del empleado
cuyo código es 390 .*/
CREATE OR REPLACE PROCEDURE NOM_SALAR
IS
NOMBRE EMPLEADOS.NOMEM%TYPE;
SALARIO NUMBER;
BEGIN
    SELECT NOMEM, SALAR INTO NOMBRE, SALARIO 
    FROM EMPLEADOS
    WHERE NUMEM = 390;
    DBMS_OUTPUT.PUT_LINE('NOMBRE: ' ||NOMBRE||' SU SALARIO ES: ' ||SALARIO);
END NOM_SALAR;
/
/*2. Hacer un procedimiento que reciba como parámetro un código de
empleado y devuelva su nombre*/
CREATE OR REPLACE PROCEDURE A1EJ2(CODEMP EMPLEADOS.NUMEM%TYPE)
IS
    NOMBRE EMPLEADOS.NOMEM%TYPE;
BEGIN
    SELECT NOMEM INTO NOMBRE
    FROM EMPLEADOS
    WHERE NUMEM=CODEMP;
    DBMS_OUTPUT.PUT_LINE('EL EMPLEADO CON CODIGO '||CODEMP||' ES:'||NOMBRE);
END A1EJ2;
/
/*3. Crear un procedimiento PL/SQL que cuente el número de filas que hay en
la tabla EMP, deposita el resultado en una variable y visualiza su contenido.*/
CREATE OR REPLACE PROCEDURE A1EJ3
IS
FILAS NUMBER;
BEGIN
    SELECT COUNT(*) INTO FILAS
    FROM EMPLEADOS;
    DBMS_OUTPUT.PUT_LINE('NUMERO DE FILAS DE LA TABLA EMPELADOS: '||FILAS);
END A1EJ3;
/
/*4. Codificar un procedimiento que reciba una cadena y la visualice al revés.*/
CREATE OR REPLACE PROCEDURE A1EJ4(CADENA VARCHAR2)
IS
    REVES VARCHAR2(50):='';
BEGIN
    FOR I IN REVERSE 1..LENGTH(CADENA)LOOP
    REVES:=REVES||SUBSTR(CADENA, I, 1);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('CADENA INVERTIDA: '||REVES);
END A1EJ4;
/
/*5. Escribir un procedimiento que reciba una fecha y escriba el año, en
número, correspondiente a esa fecha.*/
CREATE OR REPLACE PROCEDURE A1EJ5(FECHA DATE)
IS
    ANIO NUMBER;
BEGIN 
    ANIO:=EXTRACT(YEAR FROM FECHA);
    DBMS_OUTPUT.PUT_LINE('AÑO: '||ANIO);
END A1EJ5;
/
/*6. Codificar un procedimiento que reciba una lista de hasta 5 números y
visualice su suma.*/
CREATE OR REPLACE PROCEDURE A1EJ6(N1 NUMBER, N2 NUMBER, N3 NUMBER, N4 NUMBER, N5 NUMBER)
IS
    SUMA NUMBER:=0;
BEGIN
    SUMA:=(N1+N2+N3+N4+N5);
    DBMS_OUTPUT.PUT_LINE('SUMA DE LOS NUMEROS INTRODUCIDOS: '||SUMA);
END A1EJ6;
/
/*7. Codificar un procedimiento que permita borrar un empleado cuyo número
se pasará en la llamada.*/
CREATE OR REPLACE PROCEDURE A1EJ7(N NUMBER)
IS 
    NUM NUMBER;
BEGIN
    DELETE FROM EMPLEADOS WHERE N = NUMEM;
    DBMS_OUTPUT.PUT_LINE('EMPLEADO CON NUMERO '||N|| ' BORRADO.');
END A1EJ7;
/




    