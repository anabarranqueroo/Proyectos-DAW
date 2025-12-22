CREATE TABLE paises (
  CODIGO INT AUTO_INCREMENT PRIMARY KEY,
  NOMBRE VARCHAR(100)
);

CREATE TABLE ciudades (
  CODIGO INT AUTO_INCREMENT PRIMARY KEY,
  NOMBRE VARCHAR(100),
  CODIGO_PAIS INT,
  FOREIGN KEY (CODIGO_PAIS) REFERENCES paises(CODIGO)
);

INSERT INTO paises (NOMBRE) VALUES
('España'),
('Francia'),
('Italia');

INSERT INTO ciudades (NOMBRE, CODIGO_PAIS) VALUES
('Madrid', 1),
('Barcelona', 1),
('París', 2),
('Lyon', 2),
('Roma', 3),
('Milán', 3);
