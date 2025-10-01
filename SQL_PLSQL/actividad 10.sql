select p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id;

select p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
ORDER BY 3;

SELECT p.id, p.nombre, f.id, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id;

SELECT p.nombre, p.precio, f.nombre
FROm producto p JOIN fabricante f ON p.id_fabricante = f.id
WHERE precio = (SELECT min(precio) FROM producto)
GROUP BY p.precio, p.nombre, f.nombre;

SELECT p.nombre, p.precio, f.nombre
FROm producto p JOIN fabricante f ON p.id_fabricante = f.id
WHERE precio = (SELECT max(precio) FROM producto)
GROUP BY p.precio, p.nombre, f.nombre;

SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Lenovo';


SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Crucial' and p.precio > 200;

SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKE 'Asus' or f.nombre LIKe 'Hewlett-Packard' or f.nombre LIke 'Seagate';

SELECT *
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre IN('Asus', 'Hewlett-Packard', 'Seagate');

SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKe '%e';

SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE f.nombre LIKe '%w%';

SELECT p.nombre, p.precio, f.nombre
FROM producto p full join fabricante f on p.id_fabricante = f.id
WHERE p.precio >=180
ORDER BY 2 desc;