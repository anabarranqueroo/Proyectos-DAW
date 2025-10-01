/*1. Escribe un procedimiento que muestre el n�mero de empleados y
el salario m�nimo, m�ximo y medio del departamento de FINANZAS.
Debe hacerse uso de cursores impl�citos, es decir utilizar SELECT ...
INTO.Llamalo p_T6A2E1_tusiniciales*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD1 
IS
    NUM_EMP NUMBER;
    SAL_MIN NUMBER;
    SAL_MAX NUMBER;
    SAL_MED NUMBER;
BEGIN
    SELECT COUNT(*), MIN(SALAR),MAX(SALAR), AVG(SALAR) INTO NUM_EMP, SAL_MIN, SAL_MAX, SAL_MED
    FROM EMPLEADOS
    WHERE NUMDE = (SELECT NUMDE FROM DEPARTAMENTOS WHERE NOMDE = 'FINANZAS');
    DBMS_OUTPUT.PUT_LINE('NUMERO DE EMPLEADOS: '||NUM_EMP);
    DBMS_OUTPUT.PUT_LINE('SALARIO MINIMO: '||SAL_MIN);
    DBMS_OUTPUT.PUT_LINE('SALARIO MAXIMO: '||SAL_MAX);
    DBMS_OUTPUT.PUT_LINE('SALARIO MEDIO: '||SAL_MED);
END ACTIVIDAD1;
/   


/*2. Investiga el uso y funcionamiento de ROWID y ROWNUM en
oracle. En el siguiente ejercicio debes usar ROWID o ROWNUM.*/
/*
ROWID: Identificador �nico de fila, utilizado para acceder r�pidamente a los datos.
ROWNUM: Asigna un n�mero secuencial a las filas de una consulta, �til para limitar resultados.
*/
/*Escribe un procedimiento que suba un 10% el salario a los
EMPLEADOS con m�s de 2 hijos y que ganen menos de 2000 �.
Para cada empleado se mostrar� por pantalla el c�digo de empleado,
nombre, salario anterior y final. Utiliza un cursor expl�cito. La
transacci�n no puede quedarse a medias. Si por cualquier raz�n no
es posible actualizar todos estos salarios, debe deshacerse el trabajo
a la situaci�n inicial. Llamalo p_T6A2E2_tusiniciales*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD2 AS
    CURSOR SUBIDASALARIO IS
        SELECT NUMEM, NOMEM, SALAR FROM EMPLEADOS WHERE NUMHI > 2 AND SALAR < 2000;
        CODIGO EMPLEADOS.NUMEM%TYPE;
        NOMBRE EMPLEADOS.NOMEM%TYPE;
        SALARIO_ANTERIOR EMPLEADOS.SALAR%TYPE;
        SALARIO_FINAL EMPLEADOS.SALAR%TYPE;
BEGIN
    OPEN SUBIDASALARIO;
    LOOP
        FETCH SUBIDASALARIO INTO CODIGO, NOMBRE, SALARIO_ANTERIOR;
        EXIT WHEN SUBIDASALARIO%NOTFOUND;
        SALARIO_FINAL:= (SALARIO_ANTERIOR * 1.10);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('CODIGO: '||CODIGO);
        DBMS_OUTPUT.PUT_LINE('NOMBRE: '||NOMBRE);
        DBMS_OUTPUT.PUT_LINE('SALARIO ANTERIOR: '||SALARIO_ANTERIOR);
        DBMS_OUTPUT.PUT_LINE('SALARIO FINAL: '||SALARIO_FINAL);
    END LOOP;
    CLOSE SUBIDASALARIO;
END ACTIVIDAD2;
/


/*3. Escribe un procedimiento que reciba dos par�metros (n�mero de
departamento, hijos). Deber� crearse un cursor expl�cito al que se le
pasar�n estos par�metros y que mostrar� los datos de los empleados
que pertenezcan al departamento y con el n�mero de hijos indicados.
Al final se indicar� el n�mero de empleados obtenidos.Llamalo
p_T6A2E3_tusiniciales*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD3 (NUM_DEP DEPARTAMENTOS.NUMDE%TYPE, HIJOS NUMBER)AS
    CURSOR PARAMETROS IS
        SELECT * FROM EMPLEADOS WHERE NUMHI = HIJOS AND NUMDE = NUM_DEP;
        NUM_EMP NUMBER :=0;
BEGIN  
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
    FOR REGISTRO IN PARAMETROS LOOP
        DBMS_OUTPUT.PUT_LINE('NUMERO: '||REGISTRO.NUMEM);
        DBMS_OUTPUT.PUT_LINE('EXTENSION TEL: '||REGISTRO.EXTEL);
        DBMS_OUTPUT.PUT_LINE('FECHA NAC: '||REGISTRO.FECNA);
        DBMS_OUTPUT.PUT_LINE('FECHA INI: '||REGISTRO.FECIN);
        DBMS_OUTPUT.PUT_LINE('SALARIO: '||REGISTRO.SALAR);
        DBMS_OUTPUT.PUT_LINE('COMISION: '||REGISTRO.COMIS);
        DBMS_OUTPUT.PUT_LINE('HIJOS: '||REGISTRO.NUMHI);
        DBMS_OUTPUT.PUT_LINE('NOMBRE: '||REGISTRO.NOMEM);
        DBMS_OUTPUT.PUT_LINE('NUMERO DEPT: '||REGISTRO.NUMDE);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        NUM_EMP := NUM_EMP + 1;
END LOOP;
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('TOTAL EMPLEADOS: '||NUM_EMP);
END ACTIVIDAD3;
/


/*4. Escribe un procedimiento con un par�metro para el nombre de
empleado, que nos muestre la edad de dicho empleado en a�os,
meses y d�as.Llamalo p_T6A2E4_tusiniciales.*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD4 (NOMBRE EMPLEADOS.NOMEM%TYPE) AS
CURSOR C IS
    SELECT NOMEM, FECNA
    FROM EMPLEADOS WHERE NOMEM = NOMBRE;
    
    FECHA_NAC DATE;
    ANIOS NUMBER:=0;
    MESES NUMBER:=0;
    DIAS NUMBER:=0;
    M NUMBER;
BEGIN
    FOR REGISTRO IN C LOOP
    MESES:= MONTHS_BETWEEN (SYSDATE, REGISTRO.FECNA);
    ANIOS:= MESES/12;
    M:= MOD(MESES,12);
    DIAS:= (M - TRUNC(M))*30;
    DBMS_OUTPUT.PUT_LINE('EDAD DEL EMPLEADO-- ');
    DBMS_OUTPUT.PUT_LINE('A�OS: '||TRUNC( ANIOS));
    DBMS_OUTPUT.PUT_LINE('MESES: '|| TRUNC(M));
    DBMS_OUTPUT.PUT_LINE('DIAS: '||TRUNC( DIAS));
    END LOOP;
END ACTIVIDAD4;
/ 