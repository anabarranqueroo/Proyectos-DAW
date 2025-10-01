-- Script para la creación de tablas de seguimiento de proyectos

-- Tabla de Proyectos
CREATE TABLE Proyectos (
    id_proyecto NUMBER  PRIMARY KEY,
    nombre_proyecto VARCHAR2(100) NOT NULL,
    descripcion VARCHAR2(255),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    estado VARCHAR2(20) CHECK (estado IN ('Activo', 'En espera', 'Completado')) NOT NULL
);

-- Tabla de Tareas
CREATE TABLE Tareas (
    id_tarea NUMBER PRIMARY KEY,
    id_proyecto NUMBER NOT NULL,
    nombre_tarea VARCHAR2(100) NOT NULL,
    descripcion VARCHAR2(255),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    estado VARCHAR2(20) CHECK (estado IN ('Pendiente', 'En curso', 'Finalizada')) NOT NULL,
    CONSTRAINT fk_tareas_proyectos FOREIGN KEY (id_proyecto)
        REFERENCES Proyectos (id_proyecto)
        ON DELETE CASCADE
);

-- Tabla de Empleados
CREATE TABLE Empleados (
    id_empleado NUMBER  PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    apellido VARCHAR2(100) NOT NULL,
    email VARCHAR2(150) UNIQUE NOT NULL,
    telefono VARCHAR2(15)
);

-- Tabla de Asignaciones (relación muchos a muchos entre Tareas y Empleados)
CREATE TABLE Asignaciones (
    id_asignacion NUMBER  PRIMARY KEY,
    id_tarea NUMBER NOT NULL,
    id_empleado NUMBER NOT NULL,
    fecha_asignacion DATE DEFAULT SYSDATE,
    CONSTRAINT fk_asignaciones_tareas FOREIGN KEY (id_tarea)
        REFERENCES Tareas (id_tarea)
        ON DELETE CASCADE,
    CONSTRAINT fk_asignaciones_empleados FOREIGN KEY (id_empleado)
        REFERENCES Empleados (id_empleado)
        ON DELETE CASCADE,
    CONSTRAINT uc_tarea_empleado UNIQUE (id_tarea, id_empleado) -- Evita duplicados
);

-- Comprobación de las tablas creadas
SELECT table_name FROM user_tables WHERE table_name IN ('PROYECTOS', 'TAREAS', 'EMPLEADOS', 'ASIGNACIONES');


-- Inserción de datos en la tabla Proyectos
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(1,'Proyecto Alpha', 'Implementación del sistema ERP', TO_DATE('2024-01-01', 'YYYY-MM-DD'), TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(2,'Proyecto Beta', 'Desarrollo de aplicación móvil', TO_DATE('2024-02-15', 'YYYY-MM-DD'), TO_DATE('2024-09-15', 'YYYY-MM-DD'), 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(3,'Proyecto Gamma', 'Migración de datos a la nube', TO_DATE('2024-03-01', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'En espera');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(4,'Proyecto Delta', 'Rediseño del sitio web corporativo', TO_DATE('2024-04-01', 'YYYY-MM-DD'), TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(5,'Proyecto Epsilon', 'Auditoría de seguridad', TO_DATE('2024-05-01', 'YYYY-MM-DD'), NULL, 'En espera');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(6,'Proyecto Zeta', 'Capacitación en ciberseguridad', TO_DATE('2024-06-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(7,'Proyecto Eta', 'Implementación de CRM', TO_DATE('2024-07-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(8,'Proyecto Theta', 'Despliegue de infraestructura IT', TO_DATE('2024-08-01', 'YYYY-MM-DD'), TO_DATE('2024-11-30', 'YYYY-MM-DD'), 'En espera');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(9,'Proyecto Iota', 'Optimización del proceso de ventas', TO_DATE('2024-09-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(10,'Proyecto Kappa', 'Automatización de marketing', TO_DATE('2024-10-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(11,'Proyecto Lambda', 'Pruebas de calidad de software', TO_DATE('2024-11-01', 'YYYY-MM-DD'), TO_DATE('2025-03-01', 'YYYY-MM-DD'), 'En espera');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(12,'Proyecto Mu', 'Investigación y desarrollo', TO_DATE('2024-12-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(13,'Proyecto Nu', 'Analítica de datos', TO_DATE('2024-01-15', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(14,'Proyecto Xi', 'Integración de sistemas', TO_DATE('2024-02-01', 'YYYY-MM-DD'), NULL, 'Activo');
INSERT INTO Proyectos (id_proyecto,nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(15,'Proyecto Omicron', 'Reducción de costos', TO_DATE('2024-03-15', 'YYYY-MM-DD'), NULL, 'Activo');

-- Inserción de datos en la tabla Empleados
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(1,'Carlos', 'García', 'carlos.garcia@example.com', '123456789');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(2,'María', 'Pérez', 'maria.perez@example.com', '987654321');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(3,'Luis', 'Martínez', 'luis.martinez@example.com', '567123890');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(4,'Ana', 'López', 'ana.lopez@example.com', '789012345');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(5,'Jorge', 'Hernández', 'jorge.hernandez@example.com', '345678901');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(6,'Laura', 'González', 'laura.gonzalez@example.com', '654789012');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(7,'David', 'Ramírez', 'david.ramirez@example.com', '890123456');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(8,'Sofía', 'Díaz', 'sofia.diaz@example.com', '432567890');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(9,'Raúl', 'Sánchez', 'raul.sanchez@example.com', '678901234');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(10,'Elena', 'Torres', 'elena.torres@example.com', '789654321');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(11,'Pablo', 'Ruiz', 'pablo.ruiz@example.com', '890456123');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(12,'Carla', 'Morales', 'carla.morales@example.com', '345678432');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(13,'Sergio', 'Ortega', 'sergio.ortega@example.com', '654321987');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(15,'Isabel', 'Vargas', 'isabel.vargas@example.com', '567890123');
INSERT INTO Empleados (ID_empleado,nombre, apellido, email, telefono) VALUES
(16,'Fernando', 'Jiménez', 'fernando.jimenez@example.com', '678432109');

-- Inserción de datos en la tabla Tareas
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(1,1, 'Análisis de requisitos', 'Recopilación de requisitos iniciales', TO_DATE('2024-01-10', 'YYYY-MM-DD'), TO_DATE('2024-01-20', 'YYYY-MM-DD'), 'Finalizada');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(2,1, 'Diseño del sistema', 'Creación de diagramas y especificaciones', TO_DATE('2024-01-21', 'YYYY-MM-DD'), TO_DATE('2024-02-15', 'YYYY-MM-DD'), 'En curso');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(3,1, 'Desarrollo de módulos', 'Codificación de componentes principales', TO_DATE('2024-02-16', 'YYYY-MM-DD'), TO_DATE('2024-05-15', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(4,2, 'Diseño de interfaz', 'Prototipos de interfaz gráfica', TO_DATE('2024-02-20', 'YYYY-MM-DD'), TO_DATE('2024-03-10', 'YYYY-MM-DD'), 'En curso');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(5,2, 'Pruebas iniciales', 'Testing de funcionalidades básicas', TO_DATE('2024-03-11', 'YYYY-MM-DD'), TO_DATE('2024-04-01', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(6,3, 'Configuración de servicios', 'Preparar servicios en la nube', TO_DATE('2024-03-05', 'YYYY-MM-DD'), TO_DATE('2024-03-20', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(7,4, 'Investigación de tendencias', 'Análisis de sitios similares', TO_DATE('2024-04-02', 'YYYY-MM-DD'), TO_DATE('2024-04-15', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(8,5, 'Revisión de auditorías pasadas', 'Estudio de problemas previos', TO_DATE('2024-05-05', 'YYYY-MM-DD'), TO_DATE('2024-05-15', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(9,6, 'Planificación de capacitaciones', 'Elaboración del cronograma', TO_DATE('2024-06-10', 'YYYY-MM-DD'), TO_DATE('2024-06-20', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(10,7, 'Integración con sistemas existentes', 'Pruebas de compatibilidad', TO_DATE('2024-07-15', 'YYYY-MM-DD'), TO_DATE('2024-08-15', 'YYYY-MM-DD'), 'En curso');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(11,8, 'Despliegue inicial', 'Implementación piloto', TO_DATE('2024-08-05', 'YYYY-MM-DD'), TO_DATE('2024-08-25', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(12,9, 'Optimización de procesos', 'Reducción de tiempos de ejecución', TO_DATE('2024-09-10', 'YYYY-MM-DD'), TO_DATE('2024-09-25', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(13,10, 'Automatización de flujos', 'Uso de herramientas de automatización', TO_DATE('2024-10-05', 'YYYY-MM-DD'), TO_DATE('2024-10-20', 'YYYY-MM-DD'), 'Pendiente');
INSERT INTO Tareas (id_tarea,id_proyecto, nombre_tarea, descripcion, fecha_inicio, fecha_fin, estado) VALUES
(14,11, 'Pruebas de calidad', 'Revisión de casos de prueba', TO_DATE('2024-11-10', 'YYYY-MM-DD'), TO_DATE('2024-11-30', 'YYYY-MM-DD'), 'Pendiente');


-- Inserción de datos en la tabla Asignaciones
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (1, 1, 1, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (2, 2, 2, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (3, 3, 3, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (4, 4, 4, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (5, 5, 5, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (6, 6, 6, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (7, 7, 7, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (8, 8, 8, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (9, 9, 9, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (10, 10, 10, SYSDATE);
INSERT INTO Asignaciones (id_asignacion, id_tarea, id_empleado, fecha_asignacion) VALUES (11, 11, 11, SYSDATE);