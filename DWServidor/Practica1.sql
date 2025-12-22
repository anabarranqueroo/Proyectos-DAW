--DROP DATABASE IF EXISTS ventas; 

--CREATE DATABASE ventas CHARACTER SET utf8mb4; 

--USE ventas;  





CREATE TABLE cliente (   

id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,   

nombre VARCHAR(100) NOT NULL,   

apellido1 VARCHAR(100) NOT NULL,   

apellido2 VARCHAR(100),   

ciudad VARCHAR(100),   

categoría INT UNSIGNED );  



CREATE TABLE comercial (   

id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,   

nombre VARCHAR(100) NOT NULL,   

apellido1 VARCHAR(100) NOT NULL,   

apellido2 VARCHAR(100),   

comisión FLOAT );  



CREATE TABLE pedido (   

id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,   

total DOUBLE NOT NULL,   

fecha DATE,   

id_cliente INT UNSIGNED NOT NULL,   

id_comercial INT UNSIGNED NOT NULL,   

FOREIGN KEY (id_cliente) REFERENCES cliente(id),   

FOREIGN KEY (id_comercial) REFERENCES comercial(id) );  



INSERT INTO cliente VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);

INSERT INTO cliente VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);

INSERT INTO cliente VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);

INSERT INTO cliente VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300); 

INSERT INTO cliente VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);

INSERT INTO cliente VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);

INSERT INTO cliente VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);

INSERT INTO cliente VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);

INSERT INTO cliente VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);

INSERT INTO cliente VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);

INSERT INTO comercial VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);

INSERT INTO comercial VALUES(2, 'Juan', 'Gómez', 'López', 0.13);

INSERT INTO comercial VALUES(3, 'Diego','Flores', 'Salas', 0.11);

INSERT INTO comercial VALUES(4, 'Marta','Herrera', 'Gil', 0.14);

INSERT INTO comercial VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);

INSERT INTO comercial VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);

INSERT INTO comercial VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);

INSERT INTO comercial VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);

INSERT INTO pedido VALUES(1, 150.5, '2017-10-05', 5, 2);

INSERT INTO pedido VALUES(2, 270.65, '2016-09-10', 1, 5);

INSERT INTO pedido VALUES(3, 65.26, '2017-10-05', 2, 1);

INSERT INTO pedido VALUES(4, 110.5, '2016-08-17', 8, 3);

INSERT INTO pedido VALUES(5, 948.5, '2017-09-10', 5, 2);

INSERT INTO pedido VALUES(6, 2400.6, '2016-07-27', 7, 1);

INSERT INTO pedido VALUES(7, 5760, '2015-09-10', 2, 1);

INSERT INTO pedido VALUES(8, 1983.43, '2017-10-10', 4, 6);

INSERT INTO pedido VALUES(9, 2480.4, '2016-10-10', 8, 3);

INSERT INTO pedido VALUES(10, 250.45, '2015-06-27', 8, 2);

INSERT INTO pedido VALUES(11, 75.29, '2016-08-17', 3, 7);

INSERT INTO pedido VALUES(12, 3045.6, '2017-04-25', 2, 1);

INSERT INTO pedido VALUES(13, 545.75, '2019-01-25', 6, 1);

INSERT INTO pedido VALUES(14, 145.82, '2017-02-02', 6, 1);

INSERT INTO pedido VALUES(15, 370.85, '2019-03-11', 1, 5);

INSERT INTO pedido VALUES(16, 2389.23, '2019-03-11', 1, 5);


SELECT '-----------------------EJERCICIO 1---------------------------------';
--1. Devuelve un listado con todos los pedidos que se han realizado. 
--Los pedidos  deben estar ordenados mostrando en primer lugar
--los pedidos más recientes. 
SELECT * FROM pedido ORDER BY fecha DESC;
SELECT '-----------------------EJERCICIO 2---------------------------------';

--2. Devuelve un listado con los identificadores de los clientes que 
--han realizado algún  pedido. Tenga en cuenta que no debes mostrar 
--identificadores que estén repetidos. 
SELECT DISTINCT id_cliente FROM pedido;  
SELECT '-----------------------EJERCICIO 3--------------------------------';

--3. Devuelve un listado de todos los pedidos que se realizaron durante 
--el año 2017, cuya  cantidad sea superior a 500€. 
SELECT * FROM pedido WHERE fecha BETWEEN '2017-01-01' AND '2017-12-31' AND total > 500;
SELECT '------------------------EJERCICIO 4--------------------------------';

--4. Devuelve un listado con el nombre y los apellidos de los comerciales 
--que tienen una  comisión entre 0.05 y 0.11.
SELECT nombre, apellido1, apellido2 FROM comercial WHERE comisión BETWEEN '0.05' AND '0.11';
SELECT '-------------------------EJERCICIO 5--------------------------------';

--5. Devuelve el valor de la comisión de mayor y menor valor que existe 
--en la tabla comercial. 
SELECT MAX(comisión), MIN(comisión) FROM comercial;
SELECT '-------------------------EJERCICIO 6--------------------------------';

--6. Devuelve el identificador, nombre y primer apellido de aquellos clientes 
--cuyo segundo  apellido no es NULL. El listado deberá estar ordenado alfabéticamente 
--por apellidos y  nombre.
SELECT id, nombre, apellido1 FROM cliente WHERE apellido2 IS NOT NULL ORDER BY apellido1 ASC;
SELECT '-----------------------EJERCICIO 7-------------------------------';

--7. Devuelve un listado de los nombres de los clientes que empiezan por A y terminan 
--por o y también los nombres que empiezan por a. El listado deberá estar  ordenado 
--alfabéticamente. 
SELECT nombre FROM cliente WHERE (nombre LIKE 'A%o') OR (nombre LIKE 'a%') ORDER BY nombre;
SELECT '------------------------EJERCICIO 8----------------------------------';

--8. Devuelve un listado con los nombres de los comerciales que terminan por el o. 
--Tenga en cuenta que se deberán eliminar los nombres repetidos. 
SELECT DISTINCT nombre FROM comercial WHERE nombre LIKE '%o';
SELECT '------------------------EJERCICIO 9--------------------------------';

--9. Devuelve un listado con el identificador y nombre de todos los clientes que han 
--realizado algún pedido. El listado debe estar ordenado alfabéticamente y se  deben 
--eliminar los elementos repetidos. 
SELECT DISTINCT p.id_cliente, c.nombre FROM cliente c JOIN pedido p ON p.id_cliente = c.id 
    ORDER BY c.nombre;
SELECT '----------------------EJERCICIO 10-------------------------------';

--10. Devuelve un listado de todos el id y los nombres de clientes, que realizaron un pedido  durante el año 
--2017, cuya cantidad esté entre 300 € y 1000 €.
SELECT DISTINCT p.id_cliente, c.nombre FROM cliente c JOIN pedido p ON p.id_cliente = c.id 
    WHERE fecha BETWEEN '2017-01-01' AND '2017-12-31' 
    AND p.total BETWEEN '300' AND '1000';
SELECT '-------------------------EJERCICIO 11------------------------------';

--11. Devuelve el nombre y los apellidos de todos los comerciales que ha participado 
--en algún pedido realizado por María Santana Moreno. 
SELECT DISTINCT c.nombre, c.apellido1, c.apellido2 FROM comercial c JOIN pedido p ON c.id = p.id_comercial
    WHERE p.id_cliente = (SELECT id FROM cliente 
                            WHERE nombre = 'María' AND apellido1 = 'Santana' AND apellido2 = 'Moreno');
SELECT '---------------------EJERCICIO 12------------------------------';

--12. Devuelve el nombre de todos los clientes que han realizado algún pedido con
--algún comercial apellidado Vega. 
SELECT DISTINCT c.nombre FROM cliente c JOIN pedido p ON c.id = p.id_cliente JOIN comercial co ON p.id_comercial = co.id
WHERE p.id_cliente = (SELECT id FROM comercial 
                        WHERE apellido1 = 'Vega' OR apellido2 = 'Vega');
SELECT '----------------------EJERCICIO 13--------------------------------';

--13. Devuelve un listado que solamente muestre los clientes que no han realizado ningún  pedido. 
SELECT * FROM cliente 
    WHERE id NOT IN (
        SELECT id_cliente FROM pedido
);
SELECT '----------------------EJERCICIO 14-------------------------------';

--14. Devuelve un listado que solamente muestre los comerciales que no han realizado  ningún pedido. 
SELECT * FROM comercial
    WHERE id NOT IN (
        SELECT id_comercial FROM pedido
);
SELECT '----------------------EJERCICIO 15-------------------------------';
--15. Calcula la cantidad total y la cantidad media de todos los pedidos que aparecen en la  tabla pedido. 
SELECT SUM(total), AVG(total) FROM pedido;
SELECT '----------------------EJERCICIO 16-------------------------------';

--16. Calcula el número total de clientes que aparecen en la tabla cliente. 
SELECT COUNT(id) FROM cliente;
SELECT '----------------------EJERCICIO 17-------------------------------';

--17. Calcula cuál es la mayor y la menor cantidad que aparece en la tabla pedido. 
SELECT MAX(total), MIN(total) FROM pedido;
SELECT '----------------------EJERCICIO 18-------------------------------';

--18. Devuelve un listado con el identificador de cliente, nombre y apellidos y el  
--número total de pedidos que ha realizado cada uno de clientes.  
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) 
    FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente
    GROUP BY c.id, c.nombre, c.apellido1, c.apellido2 ORDER BY c.id;
SELECT '----------------------EJERCICIO 19-------------------------------';

--19. Haz el ejercicio 18 teniendo en cuenta que pueden existir clientes que no han 
--realizado  ningún pedido. Estos clientes no deben aparecer en el listado. 
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) 
    FROM cliente c JOIN pedido p ON c.id = p.id_cliente
    GROUP BY c.id, c.nombre, c.apellido1, c.apellido2 ORDER BY c.id;
SELECT '----------------------EJERCICIO 20-------------------------------';

--20. Devuelve un listado con el identificador de cliente, nombre y apellidos 
--y el  número total de pedidos que ha realizado cada uno de clientes durante el año 2017 
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) 
    FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente
    WHERE p.fecha BETWEEN '2017-01-01' AND '2017-12-31'
    GROUP BY c.id, c.nombre, c.apellido1, c.apellido2 ORDER BY c.id;
SELECT '----------------------EJERCICIO 21-------------------------------';

--21. Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz.
--(Usando  subconsulta) 
SELECT * FROM pedido WHERE id_cliente = (
    SELECT id FROM cliente WHERE nombre = 'Adela' AND apellido1 = 'Salas' AND apellido2 = 'Díaz'
);
SELECT '----------------------EJERCICIO 22-------------------------------';

--22. Devuelve el número de pedidos en los que ha participado el comercial Daniel  
--Sáez Vega. (Usando subconsulta) 
SELECT COUNT(*) FROM pedido WHERE id_comercial = (
    SELECT id FROM comercial WHERE nombre = 'Daniel' AND apellido1 = 'Sáez' AND apellido2 = 'Vega'
);
SELECT '----------------------EJERCICIO 23-------------------------------';

--23. Devuelve los datos del cliente que realizó el pedido más caro en el año 2019. (Usando  subconsulta) 
    SELECT * FROM cliente WHERE id = (
        SELECT id_cliente FROM pedido
        WHERE fecha BETWEEN '2019-01-01' AND '2019-12-01' AND total = (
                    SELECT MAX(total) FROM pedido
                      WHERE fecha BETWEEN '2019-01-01' AND '2019-12-31'    
        )
    );
SELECT '----------------------EJERCICIO 24-------------------------------';

--24. Devuelve la fecha y la cantidad del pedido de menor valor realizado por el cliente Pepe  Ruiz Santana. 
SELECT fecha, MIN(total) FROM pedido WHERE id_cliente = (
    SELECT id FROM cliente 
    WHERE nombre = 'Pepe' AND apellido1 = 'Ruiz' AND apellido2 = 'Santana'
);
SELECT '----------------------EJERCICIO 25-------------------------------';

--25. Devuelve el pedido más caro que existe en la tabla pedido si hacer uso de MAX. 
SELECT * FROM pedido 
WHERE total = (
    SELECT MAX(total) FROM pedido
);
SELECT '----------------------EJERCICIO 26-------------------------------';

--26. Devuelve un listado de los clientes que no han realizado ningún pedido. 
SELECT * FROM cliente
WHERE id NOT IN (
    SELECT id_cliente FROM pedido
);
SELECT '----------------------EJERCICIO 27-------------------------------';

--27. Devuelve un listado de los comerciales que no han realizado ningún pedido. Hazlo de 2  formas diferentes.
SELECT * FROM comercial
WHERE id NOT IN (
    SELECT id_comercial FROM pedido
);

SELECT c.* FROM comercial c LEFT JOIN pedido p ON c.id = p.id_comercial
WHERE p.id_comercial IS NULL;
