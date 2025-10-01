/*1.Implementa un procedimiento llamado listaPFP_tusiniciales que muestre un Listado
con el nombre de cada fabricante junto con el nombre y el precio de cada producto que
suministra*/
CREATE OR REPLACE PROCEDURE LISTAPFP_AEB AS
CURSOR ACTIVIDAD1 IS
    SELECT FABRICANTE.NOMBRE AS NOMBREF, PRODUCTO.NOMBRE AS NOMBREP, PRODUCTO.PRECIO
    FROM FABRICANTE JOIN PRODUCTO ON FABRICANTE.ID=PRODUCTO.ID_FABRICANTE;
BEGIN
    FOR REGISTRO IN ACTIVIDAD1 LOOP
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('FABRICANTE: '|| REGISTRO.NOMBREF);
        DBMS_OUTPUT.PUT_LINE('PRODUCTO: '|| REGISTRO.NOMBREP);
        DBMS_OUTPUT.PUT_LINE('PRECIO: '|| REGISTRO.PRECIO);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        END LOOP;
END  LISTAPFP_AEB;
/

/*2.Implementa un procedimiento llamado PRECIO_MEDIO_TUSINICIALES de los productos
de cada fabricante*/
CREATE OR REPLACE PROCEDURE PRECIO_MEDIO_AEB AS
CURSOR ACTIVIDAD2 IS
    SELECT FABRICANTE.NOMBRE, AVG(PRODUCTO.PRECIO) AS PRECIO_MEDIO
    FROM FABRICANTE JOIN PRODUCTO ON FABRICANTE.ID=PRODUCTO.ID_FABRICANTE
    GROUP BY FABRICANTE.NOMBRE;
BEGIN
    FOR REGISTRO IN ACTIVIDAD2 LOOP
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('FABRICANTE: '|| REGISTRO.NOMBRE);
        DBMS_OUTPUT.PUT_LINE('PRECIO MEDIO: '|| REGISTRO. PRECIO_MEDIO);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        END LOOP;
END  PRECIO_MEDIO_AEB;
/
/*3. Desarrollar un procedimiento que visualice el el nombre y la fecha de alta de
todos los empleados ordenados por FECHA DE ALTA*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD3 AS
CURSOR A3 IS
    SELECT NOMEM, FECIN FROM EMPLEADOS ORDER BY 2;
BEGIN
    FOR REGISTRO IN A3 LOOP
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('NOMBRE DEL EMPLEADO:' || REGISTRO.NOMEM);
        DBMS_OUTPUT.PUT_LINE('FECHA DE ALTA:' || REGISTRO.FECIN);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
        END LOOP;
END ACTIVIDAD3;
/
/*4.-Desarrollar un procedimiento que permita insertar nuevos departamentos según las
siguientes especificaciones:
*Se pasará al procedimiento el nombre del departamento.
*El procedimiento insertará la fila nueva asignando como número de departamento la
decena siguiente al número mayor de la tabla.
*Se incluirá gestión de posibles errores.*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD4( NOM_DEP  DEPARTAMENTOS.NOMDE%TYPE) AS
CURSOR A4 IS
    SELECT NOMDE FROM DEPARTAMENTOS
    WHERE NOMDE = UPPER(NOM_DEP);
    
    NUMERO_DEPT DEPARTAMENTOS.NUMDE%TYPE;
    NOMBRE_DUPLICADO EXCEPTION;
    
BEGIN
    FOR I IN A4 LOOP
        IF I.NOMDE IS NOT NULL THEN
        RAISE NOMBRE_DUPLICADO;
        END IF;
        END LOOP;
        
     SELECT MAX(NUMDE)+10 INTO NUMERO_DEPT FROM DEPARTAMENTOS;
     INSERT INTO DEPARTAMENTOS (NOMDE, NUMDE) VALUES (NOM_DEP, NUMERO_DEPT);
     DBMS_OUTPUT.PUT_LINE('SE HA INSERTADO CORRECTAMENTE');
     
EXCEPTION
    WHEN NOMBRE_DUPLICADO THEN
        DBMS_OUTPUT.PUT_LINE('NOMBRE DUPLICADO');
END ACTIVIDAD4;
/

/*5.Desarrolla un procedimiento donde se muestre un informe completo por cada centro
de los departamentos que lo componen y por cada departamento la información relativa
a cada uno de sus empleados. Como vemos en el ejemplo de salida que debe proporcionar
el procedimiento.*/
CREATE OR REPLACE PROCEDURE ACTIVIDAD5 AS
CURSOR CEN IS
    SELECT NUMCE,NOMCE, DIRCE FROM CENTROS;
    
CURSOR DEP (NUMERO_CENTRO CENTROS.NUMCE%TYPE) IS    
    SELECT D.NUMDE, D.NOMDE, D.PRESU, E.NOMEM 
    FROM DEPARTAMENTOS  D JOIN EMPLEADOS E ON D.DIREC=E.NUMEM
    WHERE NUMERO_CENTRO=D.NUMCE;
    
CURSOR EM(NUMERO_DEPARTAMENTO DEPARTAMENTOS.NUMDE%TYPE) IS
    SELECT NUMEM, NOMEM, NUMHI, SALAR FROM EMPLEADOS
    WHERE NUMERO_DEPARTAMENTO=NUMDE;
    
BEGIN
     FOR CENTROS IN CEN LOOP
            DBMS_OUTPUT.PUT_LINE(' CENTRO: '|| CENTROS.NOMCE||' '||CENTROS.DIRCE);
                 FOR DEPARTAMENTO IN DEP(CENTROS.NUMCE) LOOP
                    DBMS_OUTPUT.PUT_LINE(' DEPARTAMENTO: '|| DEPARTAMENTO.NUMDE||':  '||DEPARTAMENTO.NOMDE || ' (' ||DEPARTAMENTO.PRESU|| ') DIRECTOR:' ||DEPARTAMENTO.NOMEM);
                    FOR EMPLEADO IN EM(DEPARTAMENTO.NUMDE) LOOP
                        DBMS_OUTPUT.PUT_LINE(EMPLEADO.NUMEM|| ' ' || EMPLEADO.NOMEM || ' HIJOS: '||EMPLEADO.NUMHI|| ' SALARIO:'||EMPLEADO.SALAR);
                        END LOOP;
                    END LOOP;
        END LOOP;
END ACTIVIDAD5;
/
