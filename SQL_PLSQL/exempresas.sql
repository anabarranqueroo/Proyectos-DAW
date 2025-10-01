/*EXAMEN DE PLSQL fct b 2024*/
/* EJ1 Disparador en cascada*/
set serveroutput on;
CREATE OR REPLACE TRIGGER CASCADAMJ
AFTER UPDATE OF COD_TUTOR_DOCENTE ON TUTOR_DOCENTE
FOR EACH ROW
BEGIN

	UPDATE alumno
	SET COD_TUTOR_DOCENTE= :new.COD_TUTOR_DOCENTE
	WHERE COD_TUTOR_DOCENTE = :old.COD_TUTOR_DOCENTE;   
    
END;
/
/* EJ2 Realiza un procedimiento que muestre el nombre de la empresa junto con la cantidad
de alumnos que tienen en prácticas. Debe mostrar también la cantidad de alumnos que a día de hoy
tienen empresa asignada y cuantos todavía no tienen empresa asignada*
no tienen alumnos asignados junto con la fecha de hoy*/
Select e.nombre,count(a.cod_alumno) nalu
from empresa e join tutor_laboral tl on e.cod_empresa=tl.cod_empresa
                         join alumno a on tl.cod_tutor_laboral= a.cod_tutor_laboral
group by e.nombre;


/* Alumnos sin empresa asignada */
Select count(cod_alumno)
from alumno
where cod_tutor_laboral is null;

/*Alumnos con empresa asignada*/
Select count(cod_alumno)
from alumno
where cod_tutor_laboral is not null;

create or replace procedure pl2FM
as
    cursor nomempresas is
        Select e.nombre,count(a.cod_alumno) nalu
        from empresa e join tutor_laboral tl on e.cod_empresa=tl.cod_empresa
                         join alumno a on tl.cod_tutor_laboral= a.cod_tutor_laboral
        group by e.nombre;
        
        conempresa number;
        sinempresa number;
        total number;
begin

    Select count(cod_alumno) into conempresa
    from alumno
    where cod_tutor_laboral is not null;
    
    Select count(cod_alumno) into sinempresa
    from alumno
    where cod_tutor_laboral is null;
    
    Select count(cod_alumno) into total
    from alumno;
    
     dbms_output.put_line('Empresas que tienen alumnos en prácticas. '||'Fecha: '||sysdate);
     dbms_output.put_line(' ');
     for fila in nomempresas loop
        DBMS_OUTPUT.PUT_LINE (fila.nombre);
        dbms_output.put_line('     Nº de alumnos '||fila.nalu);
    end loop; 
    
    DBMS_OUTPUT.PUT_LINE(' ');
    
    DBMS_OUTPUT.PUT_LINE('Tenemos un total de ' ||total || ' alumnos registrados:');
    DBMS_OUTPUT.PUT_LINE(conempresa || ' con empresa ');
    DBMS_OUTPUT.PUT_LINE(sinempresa || ' sin empresa '); 
    
    
end;
/

set SERVEROUTPUT ON;
exec pl2FM;

/*Ej 3 Haz una función llamada FL3tusiniciales que reciba el DNI de un alumno como
parámetro de entrada para comprobar si un alumno lo tenemos registrado en la BD y tiene empresa asignada. Si estando registrado en la BD 
no tiene empresa asignada y por último que el DNI indicado no corresponda a ningún alumno. Tened en cuenta que un alumno tendrá
empresa asignada cuando se le haya indicado el código del tutor laboral*/
create or replace function FL3FM(dnialu alumno.dni%type)
return number
is
	tl	alumno.cod_tutor_laboral%type;
    noempresa exception;
begin
	select cod_tutor_laboral into tl
	from alumno
	where dni=dnialu;
    
    if tl is null then
        raise noempresa;
    end if;
    dbms_output.put_line('ALUMNO REGISTRADO CON EMPRESA');
	return 1;
exception
	when NO_DATA_FOUND then
		dbms_output.put_line('El alumno con DNI: '||dnialu||' no existe');
		return -1;
    when noempresa then
        dbms_output.put_line('El alumno con DNI: '||dnialu||' no tiene empresa asignada');
		return -2;
end;
/

begin
    dbms_output.put_line(FL3FM('655555ddD'));
     dbms_output.put_line(FL3FM('22222222A'));
     dbms_output.put_line(FL3FM('66666666D'));
end;
/

/*Ej 4 Dado el DNI de un alumno me indique la empresa,
el tutor laboral que tiene asignado y tutor docente*/
select a.nombre||' '||a.apellido1||' '||a.apellido2 alumno,e.nombre empresa,td.nombre||' '||td.apellido1||' '||td.apellido2 docente ,
tl.nombre ||' '||tl.apellido1|| ' '||tl.apellido2 laboral,a.cod_tutor_laboral,a.cod_tutor_docente
from empresa e  full join tutor_laboral tl on e.cod_empresa=tl.cod_empresa
                          full join alumno a  on a.cod_tutor_laboral=tl.cod_tutor_laboral
                           full join tutor_docente td on td.cod_tutor_docente=a.cod_tutor_docente                        
where a.cod_tutor_laboral is not null and a.dni='77777777R';

select * from alumno
where dni='77777777R';


create or replace procedure pl4FM (dnia alumno.dni%type)
as
    nalumno varchar2(60);
    nempresa empresa.nombre%type;
    ndocente varchar2(60);
    nlaboral varchar2(60);
        
begin
if FL3FM(dnia)=1 then
        select a.nombre||' '||a.apellido1||' '||a.apellido2 alumno,e.nombre empresa,td.nombre||' '||td.apellido1||' '||td.apellido2 docente ,
        tl.nombre ||' '||tl.apellido1|| ' '||tl.apellido2 laboral into  nalumno, nempresa, ndocente, nlaboral
        from empresa e  full join tutor_laboral tl on e.cod_empresa=tl.cod_empresa
                          full join alumno a  on a.cod_tutor_laboral=tl.cod_tutor_laboral
                           full join tutor_docente td on td.cod_tutor_docente=a.cod_tutor_docente                        
        where a.cod_tutor_laboral is not null and a.DNI=dnia;
        dbms_output.put_line('El alumno: '||nalumno|| ' realiza sus prácticas en: '|| nempresa);
        dbms_output.put_line('Tutor laboral: '|| nlaboral);
        dbms_output.put_line('Tutor docente: '|| ndocente);
        
    end if;

end;
/

exec pl4FM('655555ddD');
exec pl4FM('655555ddD');
exec pl4FM('22222222A');
exec pl4FM('88888868K');
/* Ej5 
Crea la función "Cumple" que se le pase como parámetro una fecha y que
devuelva TRUE o FALSE si hoy fuera el cumpleaños de alguien nacido en esa fecha.
Con esta función creada úsala para diseñar el procedimiento PEJ5_TUSINICIALES 
que genere un listado en el que se vea cada alumno con su fecha de nacimiento y 
"Feliz cumple" a aquellos  alumnos que hoy sea su cumpleaños y 
el total de las que cumplen años hoy. 
Código:*/
CREATE OR REPLACE FUNCTION Cumple( fecha IN DATE) RETURN number
AS 
	felicita number; --Variable de retorno
BEGIN
	IF TO_CHAR(SYSDATE,'MM') = TO_CHAR(fecha,'MM') AND 
		TO_CHAR(SYSDATE,'DD') = TO_CHAR(fecha,'DD') THEN
		felicita := 1;
	ELSE
		felicita := 0;
	END IF;
	RETURN felicita;
END Cumple;
/

SELECT nombre ,Cumple(fec_nac) cumpleanios FROM alumno;


CREATE OR REPLACE PROCEDURE PEJ5FM
AS
	felic	VARCHAR2(40);
	contar	NUMBER(3) := 0;
	CURSOR DATO IS 
		SELECT NOMBRE || ' '||apellido1 nomapel, fec_nac
		FROM alumno;
BEGIN
	FOR reg IN dato LOOP 
		IF cumple(reg.fec_nac)=1 THEN
			felic := '****   Feliz cumpleaños**';
			contar := contar + 1;
		ELSE
			felic := NULL;
		END IF;
		DBMS_OUTPUT.PUT_LINE('-> '||reg.nomapel||' '||reg.fec_nac||felic);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('Total Aniversario: '||contar);
EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('Ocurrió un error: '||SQLCODE);
END;
/

exec pej5fm;
--borra estdisticas
exec DBMS_STATS.DELETE_SCHEMA_STATS ('C##EX26MAYO');