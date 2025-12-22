CREATE TABLE centros (
    Numero      INT PRIMARY KEY,
    Nombre      VARCHAR(50) NOT NULL,
    Direccion   VARCHAR(100) NOT NULL
);

CREATE TABLE departamentos (
    Numero       INT PRIMARY KEY,
    Nombre       VARCHAR(50) NOT NULL,
    Centro       INT NOT NULL,
    Director     INT,
    Tipo_dir     CHAR(1) CHECK (Tipo_dir IN ('P', 'F')),
    Presupuesto  DECIMAL(10,2),
    Depto_jefe   INT NULL,
    CONSTRAINT FK_DEPTO_CENTRO FOREIGN KEY (Centro)
        REFERENCES centros(Numero),
    CONSTRAINT FK_DEPTO_DEPTOJEFE FOREIGN KEY (Depto_jefe)
        REFERENCES departamentos(Numero),
    FOREIGN KEY (Director)
        REFERENCES empleados(Cod)
);

CREATE TABLE empleados (
    Cod              INT PRIMARY KEY,
    Departamento     INT NOT NULL,
    Telefono         INT,
    Fecha_nacimiento DATE NOT NULL,
    Fecha_ingreso    DATE NOT NULL,
    Salario          DECIMAL(10,2) CHECK (Salario >= 0),
    Comision         DECIMAL(10,2) NULL CHECK (Comision >= 0),
    Num_hijos        INT CHECK (Num_hijos >= 0),
    Nombre           VARCHAR(60) NOT NULL,
    CONSTRAINT FK_EMP_DEPTO FOREIGN KEY (Departamento)
        REFERENCES departamentos(Numero)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

insert into centros values (10, 'SEDE CENTRAL', 'C. ALCALA 820, MADRID');
insert into centros values (20, 'RELACION CON CLIENTE', 'C. ATOCHA 405, MADRID');

insert into departamentos values (100,'DIRECCION GENERAL', 10, 260, 'P', 12, null);
insert into departamentos values (110,'DIRECC.COMERCIAL', 20, 180, 'P', 15, 100);
insert into departamentos values (111,'SECTOR INDUSTRIAL', 20, 180, 'F', 11, 110);
insert into departamentos values (112,'SECTOR SERVICIOS', 20, 270, 'P', 9, 100);
insert into departamentos values (120,'ORGANIZACION', 10, 150, 'F', 3, 100);
insert into departamentos values (121,'PERSONAL', 10, 150, 'P', 2, 120);
insert into departamentos values (122,'PROCESO DE DATOS', 10, 350, 'P', 6, 120);
insert into departamentos values (130,'FINANZAS', 10, 310, 'P', 2, 100);

insert into empleados values (110, 121, 350, '2010-11-01', '1914-02-05',1310, null, 3, 'PONS, CESAR');
insert into empleados values (120, 112, 840, '2009-06-02', '1918-10-06',1350, 110, 1, 'LASA, 03IO');
insert into empleados values (130, 112, 810, '2009-11-03', '1936-02-07',1290, 110, 2, 'TEROL, LUCIANO');
insert into empleados values (150, 121, 340, '2010-08-04', '1939-01-09',1440, null, 0, 'PEREZ, 07IO');
insert into empleados values (160, 111, 740, '2009-07-05', '1939-11-10',1310, 110, 2, 'AGUIRRE, AUREO');
insert into empleados values (180, 110, 508, '2018-10-06', '1945-03-11',1480, 50, 2, 'PEREZ, 03COS');
insert into empleados values (190, 121, 350, '2012-05-07', '2011-02-12',1300, null, 4, 'VEIGA, 07IANA');
insert into empleados values (210, 100, 200, '2028-09-08', '2022-01-13',1380, null, 2, 'GALVEZ, PILAR');
insert into empleados values (240, 111, 760, '2026-02-09', '2024-02-14',1280, 100, 3, 'SANZ, LAVINIA');
insert into empleados values (250, 100, 250, '2027-10-10', '2001-03-15',1450, null, 0, 'ALBA, ADRIANA');
insert into empleados values (260, 100, 220, '2003-12-11', '2012-07-16',1720, null, 6, 'LOPEZ, ANTONIO');
insert into empleados values (270, 112, 800, '2021-05-12', '2010-09-17',1380, 80, 3, 'GARCIA, 10AVIO');
insert into empleados values (280, 130, 410, '2011-01-13', '2008-10-18',1290, null, 5, 'FLOR, DOROTEA');
insert into empleados values (285, 122, 620, '2025-10-14', '2015-02-19',1380, null, 0, 'POLO, OTILIA');
insert into empleados values (290, 120, 910, '2030-11-15', '2014-02-20',1270, null, 3, 'GIL, GLORIA');
insert into empleados values (310, 130, 480, '2021-11-16', '2015-01-21',1420, null, 0, 'GARCIA, 08USTO');
insert into empleados values (320, 122, 620, '2025-12-17', '2005-02-22',1405, null, 2, 'SANZ, CORNELIO');
insert into empleados values (330, 112, 850, '2019-08-18', '2001-03-23',1280, 90, 0, 'DIEZ, AMELIA');
insert into empleados values (350, 122, 610, '2013-04-19', '2010-09-24',1450, null, 1, 'CAMPS, AURELIO');
insert into empleados values (360, 111, 750, '2029-10-20', '2010-10-25',1250, 100, 2, 'LARA, DORINDA');
insert into empleados values (370, 121, 360, '2022-06-21', '2020-01-26',1190, null, 1, 'RUIZ, FABIOLA');
insert into empleados values (380, 112, 880, '2030-03-22', '2001-01-27',1180, null, 0, '03TIN, MICAELA');
insert into empleados values (390, 110, 500, '2019-02-23', '2008-10-28',1215, null, 1, 'MORAN, CARMEN');
insert into empleados values (400, 111, 780, '2018-08-24', '2001-11-29',1185, null, 0, 'LARA, LUCRECIA');
insert into empleados values (410, 122, 660, '2014-07-25', '2013-10-30',1175, null, 0, 'MUãOZ, AZUCENA');
insert into empleados values (420, 130, 450, '2022-10-26', '2019-11-30',1400, null, 0, 'FIERRO, CLAUDIA');
insert into empleados values (430, 122, 650, '2026-10-27', '2019-11-03',1210, null, 1, 'MORA, VALERIANA');
insert into empleados values (440, 111, 760, '2027-09-28', '2028-02-07',1210, 100, 0, 'DURAN, LIVIA');
insert into empleados values (450, 112, 880, '2021-10-29', '2028-02-07',1210, 100, 0, 'PEREZ, SABINA');
insert into empleados values (480, 111, 760, '2004-04-30', '2028-02-08',1210, 100, 1, 'PINO, DIANA');
insert into empleados values (490, 112, 880, '2006-06-01', '2001-01-09',1180, 100, 0, 'TORRES, HORACIO');
insert into empleados values (500, 111, 750, '2008-10-02', '2001-01-10',1200, 100, 0, 'VAZQUEZ, HONORIA');

SELECT '---------------ACTIVIDAD 1-----------------';
-- 1. Hallar la comisión, el nombre y el salario de los empleados con más de tres hijos,
--ordenados por comisión y, dentro de comisión, alfabéticamente.
SELECT Comision, Nombre, Salario FROM empleados 
WHERE Num_hijos > 3
ORDER BY Comision ASC, Nombre ASC;

SELECT '---------------ACTIVIDAD 2-----------------';
--2. Obtener los nombres de los departamentos que no dependen de otros.
SELECT Nombre FROM departamentos
WHERE Depto_jefe IS NULL;

SELECT '---------------ACTIVIDAD 3-----------------';
--3. Obtener, por orden alfabético, los nombres y los salarios de los empleados cuyo salario
--esté comprendido entre 1250 y 1300 euros.
SELECT Nombre, Salario FROM empleados
WHERE Salario BETWEEN '1250' AND '1300'
ORDER BY Nombre;

SELECT '---------------ACTIVIDAD 4-----------------';
--4. Datos de los empleados que cumplen la condición anterior o tienen al menos un hijo.
SELECT * FROM empleados
WHERE (Salario BETWEEN '1250' AND '1300') OR  (Num_hijos > 0)
ORDER BY Nombre;

SELECT '---------------ACTIVIDAD 5-----------------';
--5. Obtener, por orden alfabético, los nombres de los departamentos que no contengan la
--palabra 'Dirección' ni 'Sector'.
SELECT Nombre FROM departamentos
WHERE Nombre NOT LIKE '%Direccion%' AND Nombre NOT LIKE '%Sector%'
ORDER BY Nombre;


SELECT '---------------ACTIVIDAD 6-----------------';
--6. Obtener, por orden alfabético, los nombres de los departamentos que, o bien tienen
--directores en funciones y su presupuesto no excede los 5 mil euros, o bien no dependen de
--ningún otro departamento.
SELECT Nombre FROM departamentos
WHERE (Tipo_dir = 'F' AND Presupuesto <= 5) OR (Depto_jefe IS NULL) 
ORDER BY Nombre;

SELECT '---------------ACTIVIDAD 7-----------------';
--7. Hallar, por orden de número de empleado, el nombre y el salario total (salario más
--comisión) de los empleados cuyo salario total supera los 1300 euros mensuales.
SELECT Nombre, Salario+Comision FROM empleados
WHERE (Salario+Comision) > 1300
ORDER BY Cod;

SELECT '---------------ACTIVIDAD 8-----------------';
--8. Hallar el número de empleados de toda la empresa.
SELECT COUNT(*) FROM empleados;

SELECT '---------------ACTIVIDAD 9-----------------';
--9. Hallar cuántos departamentos existen y el presupuesto anual medio de la empresa para el
--global de todos los departamentos.
SELECT COUNT(*), AVG(Presupuesto) FROM departamentos;

SELECT '---------------ACTIVIDAD 10-----------------';
--10. Hallar el número de empleados y de extensiones telefónicas distintas del departamento
--112.
SELECT COUNT(*), COUNT(DISTINCT Telefono) FROM empleados 
WHERE Departamento = 112;

SELECT '---------------ACTIVIDAD 11-----------------';
--11. Utilice las operaciones de conjuntos para extraer los códigos de los departamentos que no
--hacen de departamento jefe.
SELECT Numero FROM departamentos
WHERE Numero NOT IN (
    SELECT DISTINCT Depto_jefe FROM departamentos
    WHERE Depto_jefe IS NOT NULL
);

SELECT '---------------ACTIVIDAD 12-----------------';
--12. Ídem pero que sí hacen de departamento jefe de algún otro departamento.
SELECT DISTINCT Depto_jefe FROM Departamentos
WHERE Depto_jefe IS NOT NULL;
