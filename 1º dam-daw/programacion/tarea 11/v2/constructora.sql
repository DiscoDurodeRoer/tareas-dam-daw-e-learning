drop database IF EXISTS constructora;

create database constructora;
use constructora;

create table proyectos (
	id integer primary key,
    nombre varchar(100)
);

create table fases(
	id int primary key auto_increment, 
    descripcion varchar(100), 
    presupuesto int, 
    idProyecto int references proyectos(id)
);


-- Insert sample data into proyectos
INSERT INTO proyectos (id, nombre) VALUES (1, 'Proyecto A');
INSERT INTO proyectos (id, nombre) VALUES (2, 'Proyecto B');
INSERT INTO proyectos (id, nombre) VALUES (3, 'Proyecto C');

-- Insert sample data into fases
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 1', 10000, 1);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 2', 15000, 1);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 1', 20000, 2);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 2', 25000, 2);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 1', 30000, 3);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 3', 20000, 1);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 4', 25000, 1);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 3', 30000, 2);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 4', 35000, 2);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 2', 40000, 3);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 3', 45000, 3);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 4', 50000, 3);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 5', 55000, 1);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 5', 60000, 2);
INSERT INTO fases (descripcion, presupuesto, idProyecto) VALUES ('Fase 5', 65000, 3);