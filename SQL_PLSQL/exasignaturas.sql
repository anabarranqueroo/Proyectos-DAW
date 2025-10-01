SET SERVEROUTPUT ON;
/*EXAMEN DE PLSQL 2024 UNIVERSIDAD*/
/* EJ1 Disparador en cascada
Realiza un disparador llamado D1tusiniciales sobre la tabla ASIGNATURA para 
que cuando se cambie un valor del código de la asignatura de la tabla ASIGNATURA
se actualice en cascada dicho valor en la tabla CORRESPONDIENTE 
en el campo correspondiente. 0.5 puntos.
*/
CREATE OR REPLACE TRIGGER CASCADAFM
AFTER UPDATE OF ID ON ASIGNATURA
FOR EACH ROW
BEGIN

	UPDATE AMA
	SET ID_ASIGNATURA= :new.ID
	WHERE ID_ASIGNATURA = :old.ID;   
    
END;
/


/*EJ2.- Listar las asignaturas en las que hay alumnos matriculados.
Mostrar el número de alumnos de cada asignatura , 
el total de alumnos y las asignaturas sin alumnos. 
En el informe debe de aparecer la fecha de cuando se ejecuta.*/
 -- consultas:
 --numero de alumnos por asignatura:

 select count(ama.id_asignatura) NUM_ALU,asignatura.nombre
 from asignatura join ama on asignatura.id=ama.id_asignatura
 GROUP BY asignatura.nombre ;
 -- asignaturas sin alumnos
 SELECT DISTINCT  asignatura.nombre
 from asignatura full join ama on asignatura.id=ama.id_asignatura
 where ama.id_asignatura is  null;

create or replace procedure EJ2FM
IS
 
 CURSOR ALUM_ASIG IS
   select count(ama.id_asignatura) NUM_ALU,asignatura.nombre
   from asignatura join ama on asignatura.id=ama.id_asignatura
   GROUP BY asignatura.nombre ;
 
cursor  ASIG_SIN is
     SELECT DISTINCT  asignatura.nombre
     from asignatura full join ama on asignatura.id=ama.id_asignatura
     where ama.id_asignatura is  null;
     TOTAL NUMBER;
 BEGIN
   
 
     dbms_output.put_line('ASIGNATURAS CON ALUMNOS MATRICULADOS. '||'Fecha: '||sysdate);
     dbms_output.put_line(' ');
     for fila in  ALUM_ASIG loop
        DBMS_OUTPUT.PUT_LINE (fila.nombre);
        dbms_output.put_line('     Nº de alumnos '||fila.NUM_ALU);
    end loop; 
     
    SELECT COUNT(ID_ALUMNO) INTO TOTAL
        FROM AMA;
    dbms_output.put_line(' ');  
    dbms_output.put_line('   Tenemos un total de:  '|| total||' alumnos matriculados ');       
    dbms_output.put_line(' ');   
    dbms_output.put_line('ASIGNATURAS SIN ALUMNOS MATRICULADOS. '||'Fecha: '||sysdate);
    dbms_output.put_line(' ');
    for REG in ASIG_SIN loop
        DBMS_OUTPUT.PUT_LINE (REG.nombre);
   END LOOP;
END;
/
exec ej2fm;

---------------------------------------------------------------------------------
/*Ej3 Haz un procedimiento llamada FL3tusiniciales que reciba el NIF de un alumno como
parámetro de entrada para comprobar si  lo tenemos registrado en la BD . 
Si está registrado en la BD se ha de verificar que corresponde a un alumno en caso 
contrario se ha de generar el correspondiente mensaje de error. */

CREATE OR REPLACE procedure EJ3FM (DATO persona.nif%type) 

is
  ALUNIF persona.nif%type;
  TIPONIF persona.tipo%type;
 
  PROFE EXCEPTION;
BEGIN

    SELECT NIF, TIPO INTO ALUNIF, TIPONIF
    FROM PERSONA
    WHERE NIF=DATO;
   

    IF TIPONIF ='profesor'
            THEN RAISE PROFE;
    
    END IF;
     dbms_output.put_line('El alumno está registrado');


EXCEPTION
     when NO_DATA_FOUND THEN 
        dbms_output.put_line('El NIF : '||DATO||' NO ESTA REGISTRADO EN LA BASE DE DATOS');

		
    WHEN PROFE THEN
        dbms_output.put_line('El NIF : '||DATO||' CORRESPONDE A UN PROFESOR');
    
        END;        
/    
begin
dbms_output.put_line(fej3fm('1234567u'));
dbms_output.put_line(fej3fm('38223286T'));
dbms_output.put_line(fej3fm('26902806M'));
end;
/
CREATE OR REPLACE function FEJ3FM (DATO persona.nif%type) return number

is
  ALUNIF persona.nif%type;
  TIPONIF persona.tipo%type;
 
  PROFE EXCEPTION;
BEGIN

    SELECT NIF, TIPO INTO ALUNIF, TIPONIF
    FROM PERSONA
    WHERE NIF=DATO;
   

    IF TIPONIF ='profesor'
            THEN RAISE PROFE;
    
    END IF;
  
     dbms_output.put_line('El alumno está registrado');
    RETURN 1;

EXCEPTION
     when NO_DATA_FOUND THEN 
        dbms_output.put_line('El NIF : '||DATO||' NO ESTA REGISTRADO EN LA BASE DE DATOS');
           return -1;
		
    WHEN PROFE THEN
        dbms_output.put_line('El NIF : '||DATO||' CORRESPONDE A UN PROFESOR');
        return -2;
        END;        
/    
----------------------------------------------------------------------------
/*Ej 4 Implementa un procedimiento que dado el DNI de un alumno me indique 
la asignatuaras en la que está matriculado y el grado al que pertenecen*/

SELECT 
    grado.nombre AS nombre_grado,
    a.nombre AS nombre_asignatura
FROM 
    ama
JOIN 
    persona p ON ama.id_alumno = p.id
JOIN 
    asignatura a ON ama.id_asignatura = a.id
JOIN 
    grado ON a.id_grado = grado.id
WHERE 
    p.nif = '26902806M';
  

CREATE OR REPLACE PROCEDURE EJ4FM( DATO persona.nif%type)
is
    NOMBREA persona.nombre%type; 
    APEL1A  persona.apellido1%type;  
    APEL2a persona.apellido2%type; 
        
    CURSOR DATOS1 IS
     SELECT 
        p.nombre  nombre_alumno,
        p.apellido1  apellido1,
        p.apellido2  apellido2,
        grado.nombre  nombre_grado,
        a.nombre  nombre_asignatura
            
        FROM 
            ama
        JOIN 
            persona p ON ama.id_alumno = p.id
        JOIN 
            asignatura a ON ama.id_asignatura = a.id
        JOIN 
            grado ON a.id_grado = grado.id
        WHERE 
            p.nif = dato;
     ESALUMNO NUMBER;   
BEGIN
     ESALUMNO:=FEJ3FM(DATO);
     
     IF ESALUMNO=1 THEN
    --MUESTRO EL NOMBRE
    SELECT  nombre, apellido1,apellido2 
    INTO NOMBREA, APEL1A, APEL2a  
    FROM PERSONA
    WHERE NIF=DATO;
    dbms_output.put_line( '  ');
    dbms_output.put_line( 'NOMBRE :');   
    dbms_output.put_line( '  ' ||nombreA ||'  '|| apel1A ||'  '|| apel2A);
    --MUESTRO ASIGNATURAS
    dbms_output.put_line( 'Cursa las siguientes asignaturas:');
             FOR REG IN DATOS1  LOOP
              dbms_output.put_line('    '|| REG.nombre_asignatura ||' del '||REG.nombre_grado);   
            END LOOP;
  end if;
END;

/

EXEC ej4fm('1234567u');
EXEC ej4fm('38223286T');
EXEC ej4fm('89542419S');

-------------------------------------------------------------------------------
/*EJ5.-
Crea la función "Aniversario" que se le pase como parámetro una fecha y que 
devuelva TRUE o FALSE si hoy fuera el aniversario algo que ocurrió en esa fecha.
Con esta funcion creada usala para diseñar el procedimiento "ListarCumpleanios" 
que genere un listado en el que se vea cada persona con su fecha de nacimiento
"Feliz cumple" a aquellas  personas que hoy sea su cumpleaños.
Código:*/
CREATE OR REPLACE FUNCTION Aniversario( fecha IN DATE) RETURN BOOLEAN
AS 
	felicita BOOLEAN; --Variable de retorno
BEGIN
	IF TO_CHAR(SYSDATE,'MM') = TO_CHAR(fecha,'MM') AND 
		TO_CHAR(SYSDATE,'DD') = TO_CHAR(fecha,'DD') THEN
		felicita := TRUE;
	ELSE
		felicita := FALSE;
	END IF;
rETURN felicita;
END Aniversario;
/
begin
dbms_output.put_line(aniversario('20/05/99'));
end;
/
select aniversario(20/05/99)from dual;

CREATE OR REPLACE PROCEDURE ListarAniversario
AS
	felic	VARCHAR2(40);
	contar	NUMBER(3) := 0;
	CURSOR datos IS 
		SELECT nombre, apellido1, apellido2, fecha_nacimiento
		FROM persona;
BEGIN
	FOR reg IN datos LOOP 
		IF Aniversario(reg.fecha_nacimiento) THEN
			felic := '*******Feliz cumpleanios';
			contar := contar + 1;
		ELSE
			felic := NULL;
		END IF;
		DBMS_OUTPUT.PUT_LINE('-> '||reg.nombre||' '||reg.fecha_nacimiento||felic);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('Total Aniversario: '||contar);
EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('Ocurrió un error: '||SQLCODE);
END ListarAniversario;
/
exec ListarAniversario;