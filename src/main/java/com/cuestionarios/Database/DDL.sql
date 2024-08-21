DROP DATABASE IF EXISTS surveys;
CREATE DATABASE surveys;
USE surveys; 

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT,
    habilitado BOOLEAN,
    nombre_usuario VARCHAR(125),
    contraseña VARCHAR(255),
    CONSTRAINT pk_usuarios PRIMARY KEY (id)
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE usuarios_roles (
    id_rol INT,
    id_usuario INT,
    CONSTRAINT pk_usuarios_roles PRIMARY KEY (id_rol,id_usuario),
    CONSTRAINT fk_usuarios_roles_rol FOREIGN KEY (id_rol) REFERENCES roles(id),
    CONSTRAINT fk_usuarios_roles_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE categorias_catalogo (
    id INT AUTO_INCREMENT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    nombre VARCHAR(255),
    CONSTRAINT pk_categorias_catalogo PRIMARY KEY (id)
);

CREATE TABLE encuestas (
    id INT AUTO_INCREMENT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    descripcion VARCHAR(255),
    nombre VARCHAR(255),
    CONSTRAINT pk_encuestas PRIMARY KEY (id)
);

CREATE TABLE capitulos (
    id INT AUTO_INCREMENT,
    id_encuesta INT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    numero_capitulo VARCHAR(50) NOT NULL AUTO_INCREMENT,
    titulo_capitulo VARCHAR(50),
    CONSTRAINT pk_capitulos PRIMARY KEY (id),
    CONSTRAINT fk_capitulos_encuesta FOREIGN KEY (id_encuesta) REFERENCES encuestas(id)
);

CREATE TABLE preguntas (
    id INT AUTO_INCREMENT,
    id_capitulo INT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    numero_pregunta VARCHAR(10) NOT NULL AUTO_INCREMENT,
    tipo_respuesta VARCHAR(20),
    comentario_pregunta VARCHAR(255),
    texto_pregunta TEXT,
    CONSTRAINT pk_preguntas PRIMARY KEY (id),
    CONSTRAINT fk_preguntas_capitulo FOREIGN KEY (id_capitulo) REFERENCES capitulos(id)
);

CREATE TABLE opciones_respuesta (
    id INT AUTO_INCREMENT,
    valor_opcion INT,
    id_categoria_catalogo INT,
    id_pregunta INT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    id_opcion_padre INT,
    tipo_componente_html VARCHAR(30),
    comentario_respuesta TEXT,
    texto_opcion TEXT,
    CONSTRAINT pk_opciones_respuesta PRIMARY KEY (id),
    CONSTRAINT fk_opciones_categoria FOREIGN KEY (id_categoria_catalogo) REFERENCES categorias_catalogo(id),
    CONSTRAINT fk_opciones_pregunta FOREIGN KEY (id_pregunta) REFERENCES preguntas(id),
    CONSTRAINT fk_opciones_padre FOREIGN KEY (id_opcion_padre) REFERENCES opciones_respuesta(id)
);

CREATE TABLE subopciones_respuesta (
    id INT AUTO_INCREMENT,
    numero_subopcion INT NOT NULL AUTO_INCREMENT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    id_opcion_respuesta INT,
    componente_html VARCHAR(255),
    texto_subopcion VARCHAR(255),
    CONSTRAINT pk_subopciones_respuesta PRIMARY KEY (id),
    CONSTRAINT fk_subopciones_opcion FOREIGN KEY (id_opcion_respuesta) REFERENCES opciones_respuesta(id)
);

CREATE TABLE respuestas (
    id INT AUTO_INCREMENT,
    id_respuesta INT,
    id_subrespuesta INT,
    texto_respuesta VARCHAR(80),
    CONSTRAINT pk_respuestas PRIMARY KEY (id),
    CONSTRAINT fk_respuestas_pregunta FOREIGN KEY (id_respuesta) REFERENCES preguntas(id),
    CONSTRAINT fk_respuestas_subopcion FOREIGN KEY (id_subrespuesta) REFERENCES subopciones_respuesta(id)
);
