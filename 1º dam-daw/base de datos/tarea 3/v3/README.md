# Tarea 3 base de datos 

Youtube: https://youtu.be/5qOXFKhCwhg

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Ejercicio:

Se pretende diseñar una base de datos sobre los parques naturales gestionados por cada comunidad autónoma. Después de realizar un detallado análisis, se ha llegado a las siguientes conclusiones:

- Una comunidad autónoma (CA) puede tener varios parques naturales. En toda comunidad autónoma existe uno y sólo un organismo responsable de los parques. Un parque puede estar compartido por más de una comunidad.
- Un parque natural se identifica por un nombre, fue declarado en una fecha, se compone de varias áreas identificadas por un nombre y caracterizadas por una determinada extensión. Por motivos de eficiencia se desea favorecer las consultas referentes al número de parques existentes en cada comunidad y la superficie total declarada parque natural en cada CA.
- En cada área forzosamente residen especies que pueden ser de tres tipos: vegetales, animales y minerales. Cada especie tiene una denominación científica, una denominación vulgar y un número inventariado de individuos por área. De las especies vegetales se desea saber si tienen floración y en qué periodo se produce ésta; de las animales se desea saber su tipo de alimentación (herbívora, carnívora u omnívora) y sus periodos de celo; de las minerales se desea saber si se trata de cristales o de rocas.
- Además, interesa registrar qué especies sirven de alimento a otras especies, teniendo en cuenta que ninguna especie mineral se considera alimento de cualquier otra especie y que una especie vegetal no se alimenta de ninguna otra especie.
- Del personal del parque se guarda el DNI, número de seguridad social, nombre, dirección, teléfonos (domicilio, móvil) y sueldo. Se distinguen los siguientes tipos de personal:
▪ Personal de control de accesos: registra los datos de los visitantes del parque y están destinados en una entrada del parque (las entradas se identifican por un número).
▪ Personal de vigilancia: vigila un área determinada del parque que recorre en un vehículo (tipo y matrícula).
▪ Personal investigador: Tiene una titulación que ha de recogerse y pueden realizar (incluso conjuntamente) proyectos de investigación sobre
una determinada especie. Un proyecto de investigación tiene un presupuesto y un periodo de realización.
▪ Personal de conservación: mantiene y conserva un área determinada del parque. Cada uno lo realiza en una especialidad determinada (limpieza, caninos…).
- Un visitante (DNI, nombre, domicilio y profesión) debe alojarse dentro de los alojamientos de que dispone el parque; éstos tienen una capacidad limitada y tienen una determinada categoría. Pueden para el acceso cualquiera de las puertas del que dispone el parque, interesa saber en que fecha las ha utilizado.
- Los alojamientos organizan excursiones al parque, en vehículo o a pie, en determinados días de la semana y a una hora determinada. A estas excursiones puede acudir cualquier visitante del parque.
- Por comodidad, suponemos que un visitante tiene, obligatoriamente, que alojarse en el parque. Suponemos también, que cada vigilante tiene su vehículo propio que sólo utiliza él. 

Completa los siguientes apartados: 

a) Según la especificación de requerimientos, elabora el esquema conceptual basado en el modelo Entidad/Relación. Se utilizará la notación que se ha dejado en recursos adicionales. 

b) Transforma el diagrama entidad relación que corresponde con la solución de la primera parte de la actividad. Aplica el modelo Relacional y detalla las tablas, atributos, claves y claves foráneas generadas. 

c) Aplica el proceso de Normalización a dichas tablas hasta Tercera Forma Normal en caso de que el modelo no esté normalizado. Explica porqué las tablas están o no están en las 3 formas normales (1FN, 2FN, 3FN) y las soluciones que propondrías para normalizarlas. Si consideras que están normalizadas explica también porqué lo están.
