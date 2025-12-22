CREATE TABLE departamentos2 (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  descripcion TEXT
);

CREATE TABLE empleados (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_departamento INT,
  dni VARCHAR(15),
  nombre VARCHAR(100),
  apellidos VARCHAR(150),
  FOREIGN KEY (id_departamento) REFERENCES departamentos2(id)
);

INSERT INTO departamentos2 (nombre, descripcion) VALUES
('Informática', 'Departamento técnico'),
('Marketing', 'Publicidad y redes sociales'),
('RRHH', 'Gestión de personal');


INSERT INTO empleados (id_departamento, dni, nombre, apellidos) VALUES
(1, '12345678A', 'Ana', 'García López'),
(2, '87654321B', 'Luis', 'Martínez Pérez');