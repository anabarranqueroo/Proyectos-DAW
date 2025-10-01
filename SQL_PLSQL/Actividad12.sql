/*ACTIVIDAD 12*/

/*CONSULTAS SOBRE UNA TABLA*/
/*Ejercicio 1*/
SELECT *
FROM pedido
ORDER BY fecha desc;

/*Ejercicio 2*/
SELECT distinct id_cliente
FROM pedido;

/*Ejercicio 3*/
SELECT *
FROM pedido
WHERE extract(year from fecha)= 2017 and total > 500;

/*Ejercicio 4*/
SELECT nombre, apellido1, apellido2
FROM comercial
WHERE comision BETWEEN 0.05 and 0.11;

/*Ejercicio 5*/
SELECT max(comision)
FROM comercial;

/*Ejercicio 6*/
SELECT id, apellido1, nombre
FROM cliente
WHERE apellido2 is not null
ORDER BY 2;

/*Ejercicio 7*/
SELECT nombre
FROM cliente
WHERE nombre LIKE 'A%n' or nombre LIKE 'P%'
ORDER BY 1;

/*Ejercicio 8*/
SELECT nombre
FROM cliente
WHERE nombre not like 'A%'
ORDER BY 1;

/*Ejercicio 9*/
SELECT distinct nombre
FROM comercial
WHERE nombre LIKE '%el' or nombre LIKE '%o';

/*CONSULTAS MULTITABLA COMPOSICIÓN INTERNA*/
/*Ejercicio 1*/
SELECT distinct p.id_cliente, c.nombre, c.apellido1, c.apellido2
FROM cliente c join pedido p on c.id = p.id_cliente
ORDER BY 2;

/*Ejercicio 2*/
SELECT *
FROM pedido p join cliente c on c.id = p.id_cliente
ORDER BY c.nombre;

/*Ejercicio 3*/
SELECT *
FROM pedido p join comercial c on p.id_comercial = c.id
ORDER BY c.nombre;

/*Ejercicio 4*/
SELECT *
FROM cliente cl join pedido p on cl.id = p.id_cliente JOIN comercial co on p.id_comercial = co.id;

/*Ejercicio 5*/
SELECT *
FROm cliente c join pedido p on c.id = p.id_cliente
WHERE extract(year from fecha)= 2017 and total BETWEEN 300 and 1000;

/*Ejercicio 6*/
SELECT distinct cl.nombre, cl.apellido1, cl.apellido2
FROM cliente cl join pedido p on cl.id = p.id_cliente JOIN comercial co on p.id_comercial = co.id
WHERE cl.nombre LIKE 'Maria';

/*Ejercicio 7*/
SELECT distinct cl.nombre
FROM cliente cl join pedido p on cl.id = p.id_cliente JOIN comercial co on p.id_comercial = co.id
WHERE co.nombre LIKE 'Daniel';

/*CONSULTAS MULTITABLA COMPOSICIÓN EXTERNA*/
/*Ejercicio 1*/
SELECT *
FROM cliente c left join pedido p on c.id = p.id_cliente
ORDER BY c.apellido1, c.apellido2, c.nombre;

/*Ejercicio 2*/
SELECT *
FROM comercial c left join pedido p on c.id = p.id_comercial
ORDER BY c.apellido1, c.apellido2, c.nombre;

/*Ejercicio 3*/
SELECT *
FROM cliente c left join pedido p on c.id = p.id_cliente
WHERE p.id_cliente IS NULL;

/*Ejercicio 4*/
SELECT *
FROM comercial c left join pedido p on c.id = p.id_comercial
WHERE p.id_comercial IS NULL;

/*Ejercicio 5*/
SELECT cl.nombre||' '||cl.apellido1||' '||cl.apellido2 as "Cliente sin pedidos", co.nombre||' '||co.apellido1||' '||co.apellido2 as "Comerciales sin pedidos"
FROM cliente cl full join pedido p on cl.id = p.id_cliente full JOIN comercial co on p.id_comercial = co.id
WHERE p.id_comercial IS NULL or p.id_cliente IS NULL
ORDER BY cl.nombre;

/*Ejercicio 6*/
/*RESPUESTA: No, porque se unirían las tablas por las columas que tienen el mismo nombre, no por su llave primaria.*/

/*CONSULTAS RESUMEN*/
/*Ejercicio 1*/
SELECT sum(total)
FROM pedido;

/*Ejercicio 2*/
SELECT avg(total)
FROM pedido;

/*Ejercicio 3*/
SELECT count(distinct id_comercial)
FROM pedido;

/*Ejercicio 4*/
SELECT count(id)
FROM cliente;

/*Ejercicio 5*/
SELECT max(total)
FROM pedido;

/*Ejercicio 6*/
SELECT min(total)
FROM pedido;

/*Ejercicio 7*/
SELECT ciudad, max(categoria)
FROM cliente
GROUP BY ciudad;

/*Ejercicio 8*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, p.fecha, max(p.total)
FROM pedido p JOIN cliente c ON p.id_cliente = c.id
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2, p.fecha
ORDER BY c.id, p.fecha;

/*Ejercicio 9*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, p.fecha, max(p.total)
FROM pedido p JOIN cliente c ON p.id_cliente = c.id
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2, p.fecha
HAVING max(p.total) > 2000
ORDER BY c.id, p.fecha;

/*Ejercicio 10*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, max(p.total)
FROM comercial c JOIN pedido p ON c.id = p.id_comercial
WHERE p.fecha = '17/08/2016'
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2
ORDER BY c.id;

/*Ejercicio 11*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, count(p.id_cliente)
FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2;

/*Ejercicio 12*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, count(p.id_cliente)
FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE extract(year from p.fecha)='2017'
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2;

/*Ejercicio 13*/
SELECT c.id, c.nombre, c.apellido1, max(p.total)
FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2;

/*Ejercicio 14*/
SELECT max(total), EXTRACT(year from fecha)
FROM pedido
GROUP BY EXTRACT(year from fecha);

/*Ejercicio 15*/
SELECT count(total), EXTRACT(year from fecha)
FROM pedido
GROUP BY EXTRACT(year from fecha);

/*SUBCONSULTAS*/
/*Ejercicio 1*/
SELECT *
FROm pedido
WHERE id_cliente = (SELECT id 
                    FROM cliente 
                    WHERE nombre LIKE 'Adela' and apellido1 LIKE 'Salas' and apellido2 LIKE 'Diaz');

/*Ejercicio 2*/
SELECT count(id)
FROM pedido
WHERE id_comercial = (SELECT id 
                        FROM comercial
                        WHERE nombre LIKE 'Daniel' and apellido1 LIKE 'Saez' and apellido2 LIKE 'Vega');
                        
/*Ejercicio 3*/
SELECT *
FROM cliente
WHERE id = (SELECT id_cliente
            FROM pedido
            WHERE total= (SELECT max(total)
                            FROM pedido
                            WHERE EXTRACT(year from fecha)=2019));
                            
/*Ejercicio 4*/
SELECT fecha, total
FROM pedido 
WHERE total = (SELECT min(total)
                FROM pedido
                WHERE id_cliente = (SELECT id 
                                    FROM cliente
                                    WHERE nombre LIKE 'Pepe' and apellido1 LIKE 'Ruiz' and apellido2 LIKE 'Santana'));
 
 /*Ejercicio 5*/  
 SELECT *
 FROM cliente
 WHERE id = (SELECT id_cliente
            FROM pedido
            WHERE EXTRACT(year from fecha)=2017 and total >= (SELECT avg(total)
                                                            FROM pedido));
                                                            
/*Ejercicio 6*/
SELECT total
FROm pedido
WHERE total >= all (SELECT total FROM pedido);

/*Ejercicio 7*/

/*Ejercicio 8*/

/*Ejercicio 9*/
SELECT *
FROM cliente
WHERE id NOT IN (SELECT id_cliente FROM pedido);

/*Ejercicio 10*/
SELECT *
FROM comercial
WHERE id NOT IN (SELECT id_comercial FROM pedido);

/*Ejercicio 11*/

/*Ejercicio 12*/
