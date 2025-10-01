/*Actividad 10. Consultas multitabla*/

/*Actividad 1*/
select p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id;

/*Actividad 2*/
select p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
ORDER BY 3;

/*Actividad 3*/
SELECT p.id, p.nombre, f.id, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id;

/*Actividad 4*/
SELECT p.nombre, p.precio, f.nombre
FROM producto p JOIN fabricante f ON p.id_fabricante = f.id
WHERE precio = (SELECT min(precio) FROM producto)
GROUP BY p.precio, p.nombre, f.nombre;

/*Actividad 5*/
SELECT p.nombre, p.precio, f.nombre
FROM producto p JOIN fabricante f ON p.id_fabricante = f.id
WHERE precio = (SELECT max(precio) FROM producto)
GROUP BY p.precio, p.nombre, f.nombre;

/*Actividad 6*/
SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Lenovo';

/*Actividad 7*/
SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Crucial' and p.precio > 200;

/*Actividad 8*/
SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Asus' or f.nombre LIKe 'Hewlett-Packard' or f.nombre LIke 'Seagate';

/*Actividad 9*/
SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre IN('Asus', 'Hewlett-Packard', 'Seagate');

/*Actividad 10*/
SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKe '%e';

/*Actividad 11*/
SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKe '%w%';

/*Actividad 12*/
SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE p.precio >=180
ORDER BY 2 desc, 1 asc;

/*Actividad 13*/
SELECT f.id, f.nombre
FROM producto p left join fabricante f on p.id_fabricante = f.id
GROUP BY f.id, f.nombre;
