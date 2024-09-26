INSERT INTO reunion(id, asunto, fecha) VALUES (1, 'Reunión de trabajo', '2021-01-01');
INSERT INTO reunion(id, asunto, fecha) VALUES (2, 'Reunión de trabajo', '2021-01-02');
INSERT INTO reunion(id, asunto, fecha) VALUES (3, 'Reunión de trabajo', '2021-01-03');

INSERT INTO persona(id, nombre, apellido) VALUES (1, 'Juan', 'Pérez');
INSERT INTO persona(id, nombre, apellido) VALUES (2, 'María', 'González');
INSERT INTO persona(id, nombre, apellido) VALUES (3, 'Pedro', 'Martínez');

INSERT INTO asistente(reunion_id, persona_id) VALUES (1, 1);
INSERT INTO asistente(reunion_id, persona_id) VALUES (1, 2);
INSERT INTO asistente(reunion_id, persona_id) VALUES (2, 1);
INSERT INTO asistente(reunion_id, persona_id) VALUES (2, 3);
INSERT INTO asistente(reunion_id, persona_id) VALUES (3, 2);
INSERT INTO asistente(reunion_id, persona_id) VALUES (3, 3);

