CREATE TABLE reunion (
    id BIGSERIAL PRIMARY KEY,
    asunto VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL
);

CREATE TABLE persona (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL
);

CREATE TABLE asistente (
    reunion_id BIGINT NOT NULL,
    persona_id BIGINT NOT NULL,
    PRIMARY KEY (reunion_id, persona_id),
    FOREIGN KEY (reunion_id) REFERENCES reunion(id),
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);