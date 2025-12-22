-- Creación de tablas sin restricciones, ni PK, ni FK, ...
CREATE TABLE A (
    A1 VARCHAR(15),
    A2 DECIMAL(5,3) DEFAULT 2.4,
    A3 CHAR(1)
);

CREATE TABLE R (
    R1 VARCHAR(15)
);

CREATE TABLE B (
    B1 VARCHAR(15),
    B2 DECIMAL(5,3) DEFAULT 2.4,
    B3 CHAR(1)
);

-- Alteración de tablas para añadir PK
ALTER TABLE R
ADD COLUMN A1 VARCHAR(15);

ALTER TABLE R
ADD COLUMN B1 VARCHAR(15);

ALTER TABLE A
ADD CONSTRAINT PK_A PRIMARY KEY (A1);

ALTER TABLE B
ADD CONSTRAINT PK_B PRIMARY KEY (B1);

ALTER TABLE R
ADD CONSTRAINT PK_R PRIMARY KEY (A1, B1);

-- Alteración de tablas para añadir FK
ALTER TABLE R
ADD CONSTRAINT FK_R_A FOREIGN KEY (A1) REFERENCES A(A1);

ALTER TABLE R
ADD CONSTRAINT FK_R_B FOREIGN KEY (B1) REFERENCES B(B1);


-- Alteración de tablas para el resto de restricciones
ALTER TABLE A
MODIFY A2 DECIMAL(5,3) DEFAULT 2.4;

ALTER TABLE A
ADD CONSTRAINT CHK_A2_RANGO CHECK (A2 >= 0 AND A2 <= 99.999);

ALTER TABLE A
ADD CONSTRAINT CHK_A3_VALORES CHECK (A3 IN ('H', 'M'));

ALTER TABLE B
MODIFY B2 DECIMAL(5,3) DEFAULT 2.4;

ALTER TABLE B
ADD CONSTRAINT CHK_B2_RANGO CHECK (B2 >= 0 AND B2 <= 99.999);

ALTER TABLE B
ADD CONSTRAINT CHK_B3_VALORES CHECK (B3 IN ('H', 'M'));

-- Insertar datos en la tabla A y B
INSERT INTO A VALUES ('sai', 3.123, 'H');
INSERT INTO A VALUES ('pga', 12.547, 'M');

INSERT INTO B VALUES ('INF', 35.325, 'M');
INSERT INTO B VALUES ('ECO', 27.223, 'M');
INSERT INTO B VALUES ('GAR', null, 'H');

-- Insertar datos en la tabla que relaciona A y B
-- INSERT INTO R (R1, A1, B1) VALUES ('sai', 'ECO', 'TOH');
-- INSERT INTO R (R1, A1, B1) VALUES ('pga', 'ECO', 'TKK');
-- INSERT INTO R (R1, A1, B1) VALUES ('sai', 'GAR', 'CBB');
-- Da fallo al insertar ya que ECO y TOH no existen en A, para ello:

-- Datos que hay que insertar para poder hacer la consulta: 
INSERT INTO B VALUES ('TOH', 10.0, 'M');
INSERT INTO B VALUES ('TKK', 15.0, 'M');
INSERT INTO B VALUES ('CBB', 20.0, 'M');

INSERT INTO A VALUES ('ECO', 5.0, 'H');
INSERT INTO A VALUES ('GAR', 7.0, 'M');

-- Ahora si insertamos lo anterior:
INSERT INTO R (R1, A1, B1) VALUES ('sai', 'ECO', 'TOH');
INSERT INTO R (R1, A1, B1) VALUES ('pga', 'ECO', 'TKK');
INSERT INTO R (R1, A1, B1) VALUES ('sai', 'GAR', 'CBB');

-- Buscar resultados de A3, R1, A2, B2, en la que el B3 sea igual a M.
SELECT a.A3, a.A2, r.R1, b.B2 FROM A a JOIN R r ON a.A1 = r.A1 JOIN B b ON r.B1 = b.B1
WHERE b.B3 = 'M';

SELECT '--------------------------';

-- Incrementar en 10 los valores de B2 en B, que sea inferior a 90.
UPDATE B SET B2 = B2 + 10
WHERE B2 < 90;
