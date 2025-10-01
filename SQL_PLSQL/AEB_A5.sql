CREATE TABLE SUCURSALES(
    CODIGO NUMBER(4) PRIMARY KEY,
    CIUDAD VARCHAR2(20)
);

CREATE TABLE EMPLEADOS(
    DOCUMENTO CHAR(8) NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR2(30) NOT NULL,
    DOMICILIO VARCHAR(30),
    SECCION VARCHAR2(20),
    SUELDO NUMBER(6,2),
    CODIGOSUCURSAL NUMBER(4),
    CONSTRAINT EMP_CLAVEF_FK1 FOREIGN KEY (CODIGOSUCURSAL)
        REFERENCES SUCURSALES(CODIGO) ON DELETE CASCADE
);

insert into sucursales values(1,'Cordoba');
insert into sucursales values(2,'Villa Maria');
insert into sucursales values(3,'Carlos Paz');
insert into sucursales values(4,'Cruz del Eje');
insert into empleados values('22222222','Ana Acosta','Avellaneda 111','Secretaria',500,1);
insert into empleados values('23333333','Carlos Caseros','Colon 222','Sistemas',800,1);
insert into empleados values('24444444','Diana Dominguez','Dinamarca 333','Secretaria',550,2);
insert into empleados values('25555555','Fabiola Fuentes','Francia 444','Sistemas',750,2);
insert into empleados values('26666666','Gabriela Gonzalez','Guemes 555','Secretaria',580,3);
insert into empleados values('27777777','Juan Juarez','Jujuy 777','Secretaria',500,4);
insert into empleados values('28888888','Luis Lopez','Lules 888','Sistemas',780,4);
insert into empleados values('29999999','Maria Morales','Marina 999','Contaduria',670,4);

SELECT *
FROM EMPLEADOS EMP JOIN SUCURSALES SUC ON EMP.CODIGOSUCURSAL = SUC.CODIGO;

CREATE TABLE SECCIONES AS
SELECT DISTINCT(SECCION)
FROM EMPLEADOS;

SELECT *
FROM SECCIONES;

CREATE TABLE SUELDOSXSECCION AS
SELECT SUM(SUELDO) "SUMA_SUELDO", SECCION
FROM EMPLEADOS
GROUP BY SECCION;

SELECT *
FROM SUELDOSXSECCION;

CREATE TABLE sucursalCordoba AS
SELECT NOMBRE, SECCION
FROM EMPLEADOS EMP JOIN SUCURSALES SUC ON EMP.CODIGOSUCURSAL = SUC.CODIGO
WHERE CIUDAD = 'Cordoba';

SELECT *
FROM sucursalCordoba;