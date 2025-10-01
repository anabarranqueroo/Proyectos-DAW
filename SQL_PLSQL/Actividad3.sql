BEGIN
INSERT INTO comercial VALUES(9, 'Mar�a', 'S�ez', 'Vega',null);
INSERT INTO comercial VALUES(10, 'Alberto', 'G�mez', 'L�pez', null);
INSERT INTO comercial VALUES(11, 'Patricia','Garc�a', 'Salas', null);
INSERT INTO comercial VALUES(12, 'Raquel','Hern�ndez', 'Gil', null);
END;
/
/*1.Realiza una funci�n llamada incretusinciales que reciba como par�metro de
entrada un c�digo de un comercial e incremente su comisi�n un 7% y devuelva
dicha comisi�n incrementada. Tened en cuenta que hay comerciales que tienen
comisi�n igual a NULL y que para hacer operaciones matem�ticas con dicho valor
ten�is que usar la funci�n NVL(a,0) que lo que hace es que si el valor de a es NULL
devuelve un 0. Tambi�n ten�is que controlar la excepci�n de no existencia del
c�digo de comercial.*/

/*Si ejecut�is la funci�n con un c�digo de comercial cuya comisi�n IS NULL, el
resultado ha de ser igual a 0.*/

/*Si ejecutamos la funci�n con un c�digo comercial cuya comisi�n IS NOT NULL, el
resultado ha de ser la comisi�n incrementada.*/

/*Si ejecutamos la funci�n con un c�digo de comercial que no exista debe salir el
siguiente mensaje de error controlando la EXCEPCI�N adecuada y tambi�n
devolver el valor -1.*/
CREATE OR REPLACE FUNCTION ACT1 (COD NUMBER)
RETURN NUMBER IS
    RES NUMBER;
BEGIN
    SELECT NVL(COMISION,0) * 1.07  INTO RES 
    FROM COMERCIAL 
    WHERE ID = COD;
    
   IF (RES IS NULL) THEN 
   RETURN 0;
   END IF;
   
   RETURN RES;
   
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('EL COMERCIAL '|| COD || '  NO EXISTE.');
    RETURN -1;
END ACT1;
/

SET SERVEROUTPUT ON
BEGIN
    DBMS_OUTPUT.PUT_LINE(ACT1(12));
END;
/

SET SERVEROUTPUT ON
BEGIN
    DBMS_OUTPUT.PUT_LINE(ACT1(2));
END;
/

SET SERVEROUTPUT ON
BEGIN
    DBMS_OUTPUT.PUT_LINE(ACT1(20));
END;
/
    
/*2. Realiza un procedimiento llamado nuevacomistusiniciales que reciba como
par�metro de entrada un c�digo de comercial y si ese comercial tiene asignados 3 o
m�s pedidos se le incremente la comisi�n un 7% haciendo uso de la funci�n
anterior.
Debe mostrar el nombre del comercial, los apellidos, la cantidad de pedidos , la
comisi�n antigua y la nueva. Tambi�n debe actualizar dicho valor en la tabla
comercial.
Tened en cuenta que la excepci�n de no existencia del c�digo comercial ya est�
controlada en la funci�n.*/
CREATE OR REPLACE PROCEDURE ACT2 (COD NUMBER)
IS 
NOM COMERCIAL.NOMBRE%TYPE;
APE1 COMERCIAL.APELLIDO1%TYPE;
APE2 COMERCIAL.APELLIDO2%TYPE;
NUM_PED NUMBER;
COM_A COMERCIAL.COMISION%TYPE;
COM_N COMERCIAL.COMISION%TYPE;

BEGIN 
    SELECT COUNT(*) INTO NUM_PED
    FROM PEDIDO WHERE ID_COMERCIAL = COD;
    
    SELECT NOMBRE, APELLIDO1, APELLIDO2, COMISION INTO NOM, APE1, APE2, COM_A
    FROM COMERCIAL WHERE ID=COD;
    
    IF (NUM_PED >=3) THEN
        COM_N:=ACT1(COD);    
        UPDATE COMERCIAL SET COMISION = COM_N WHERE ID=COD; 
    END IF;

    DBMS_OUTPUT.PUT_LINE('COMERCIAL: '||NOM|| ' ' ||APE1|| ' ' ||APE2|| '.' || 'CANTIDAD DE 
    PEDIDOS: '|| NUM_PED|| ',' || 'COMISION ANTIGUA: '||COM_A|| ' Y  COMISION NUEVA:' ||COM_N);
    DBMS_OUTPUT.PUT_LINE('REGISTRO ACTUALIZADO CON LA NUEVA COMISION.');
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('EL COMERCIAL '|| COD || '  NO EXISTE.');
        WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('HA OCURRIDO UN ERROR'||SQLERRM);
END ACT2;
/
    
BEGIN
ACT2(1);
END;
/

BEGIN
ACT2(35);
END;
/

/*3.Crea una funci�n llamada passtusiniciales con un par�metro de entrada que ser�
un nombre para que genere una contrase�a de la siguiente forma: los tres �ltimos
caracteres del nombre junto con los dos primeros en min�scula y al final la cantidad
de caracteres que tienen el nombre.
La contrase�a no puede tener menos de 10 caracteres por eso al final se
completar� con la secuencia de caracteres ?*-*/
CREATE OR REPLACE FUNCTION ACT3 (NOM VARCHAR2)
RETURN VARCHAR2 IS
    TRES_ULT_CARACT VARCHAR2(3);
    DOS_PRIM_MAY VARCHAR2(2);
    CANT_CARACT NUMBER;
    CONT1 VARCHAR2(50);
    CONT2 VARCHAR2(50);
    RES VARCHAR(50);
BEGIN
    SELECT  LOWER(SUBSTR(NOM, 1,2)) INTO DOS_PRIM_MAY FROM DUAL;
    SELECT LENGTH(NOM) INTO CANT_CARACT FROM DUAL;
    SELECT UPPER(REVERSE(SUBSTR(REVERSE(NOM), 1, 3))) INTO TRES_ULT_CARACT FROM DUAL;
    SELECT CONCAT(TRES_ULT_CARACT,DOS_PRIM_MAY) INTO CONT1 FROM DUAL;
    SELECT CONCAT(CONT1,CANT_CARACT) INTO CONT2 FROM DUAL;
    SELECT CONCAT(CONT2,'?*-*/') INTO RES FROM DUAL;
    RETURN RES;
END ACT3;
/
    
BEGIN
    DBMS_OUTPUT.PUT_LINE(ACT3('MARIA JOSE'));
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(ACT3('LUIS'));
END;
/

/*4. Crear ahora un procedimiento que utilice la funci�n anterior para mostrar el listado
de los nombres de los comerciales junto con sus contrase�as. Ll�malo
lpasstusiniciales.*/
CREATE OR REPLACE PROCEDURE ACT4 AS CURSOR C
IS
    SELECT NOMBRE FROM COMERCIAL;
    
    CONT VARCHAR2(50);
    NOM VARCHAR2(50);
BEGIN
FOR REGISTRO IN C LOOP
     CONT:=ACT3(REGISTRO.NOMBRE);
     DBMS_OUTPUT.PUT_LINE('COMERCIAL: '||REGISTRO.NOMBRE);
     DBMS_OUTPUT.PUT_LINE('CONTRASE�A:: '||CONT);
     DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');
END LOOP;
END ACT4;
/
        
