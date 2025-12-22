-- Tabla de rutas

CREATE TABLE rutas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  duracion VARCHAR(100) DEFAULT NULL,
  distancia DOUBLE DEFAULT NULL,
  velocidad DOUBLE DEFAULT NULL,
  path LONGTEXT DEFAULT NULL, /*Trazado de la ruta en array de puntos lat y lng*/
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP /*FEcha y hora que se inserto la ruta*/
);
