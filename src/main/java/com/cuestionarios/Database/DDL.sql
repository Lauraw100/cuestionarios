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
y
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
    numero_capitulo VARCHAR(50) NOT NULL,
    titulo_capitulo VARCHAR(50),
    CONSTRAINT pk_capitulos PRIMARY KEY (id),
    CONSTRAINT fk_capitulos_encuesta FOREIGN KEY (id_encuesta) REFERENCES encuestas(id)
);

CREATE TABLE preguntas (
    id INT AUTO_INCREMENT,
    id_capitulo INT,
    creado_en TIMESTAMP,
    actualizado_en TIMESTAMP,
    numero_pregunta VARCHAR(10) NOT NULL,
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
    numero_subopcion INT NOT NULL,
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

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizarcapitulo$$
CREATE PROCEDURE  actualizarcapitulo(
    IN idcapitulo INT,
    IN idEncuesta INT,
    IN titulocapitulo VARCHAR(100)
)

BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;
    DECLARE numcapituloactual INT;
    DECLARE encuestanum INT;

    SELECT MAX(numero_capitulo) INTO NumMax
    FROM capitulos
    WHERE id_encuesta = idEncuesta;

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    SELECT id_encuesta INTO encuestanum 
    FROM capitulos
    WHERE id = idcapitulo;

    SELECT numero_capitulo INTO numcapituloactual
    FROM capitulos
    WHERE id = idcapitulo AND id_encuesta = idEncuesta; 

    IF encuestanum = idEncuesta THEN
        UPDATE capitulos 
        SET id_encuesta = idEncuesta, numero_capitulo = numcapituloactual ,titulo_capitulo = titulocapitulo, actualizado_en = NOW()
        WHERE id = idcapitulo;
    ELSE 
        UPDATE capitulos 
        SET id_encuesta = idEncuesta, numero_capitulo = NumSiguiente ,titulo_capitulo = titulocapitulo, actualizado_en = NOW()
        WHERE id = idcapitulo;
        
    END IF;

END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS validarnumerocapitulo$$
CREATE PROCEDURE  validarnumerocapitulo(
    IN idEncuesta INT,
    IN titulocapitulo VARCHAR(100)
)
BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;

    SELECT MAX(numero_capitulo) INTO NumMax
    FROM capitulos
    WHERE id_encuesta = idEncuesta;
   

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    INSERT INTO capitulos (id_encuesta, creado_en, actualizado_en, numero_capitulo, titulo_capitulo)
    VALUES (idEncuesta,NOW(),NOW(),NumSiguiente,titulocapitulo);
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS validarnumeroPregunta$$
CREATE PROCEDURE  validarnumeroPregunta(
    IN idCapitulo INT,
    IN tipoRespuesta VARCHAR(100),
    IN comentarioPregunta VARCHAR(300),
    IN textoPregunta VARCHAR(200)
)
BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT; 

    SELECT MAX(numero_pregunta) INTO NumMax
    FROM preguntas
    WHERE id_capitulo = idCapitulo;
   

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    INSERT INTO  preguntas (id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta) 
    VALUES (idCapitulo, NOW(), NOW(),NumSiguiente,tipoRespuesta,comentarioPregunta,textoPregunta);
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS validarvaloropcion$$
CREATE PROCEDURE  validarvaloropcion(
    IN idpregunta INT,
    IN idcategoriacatalogo INT,
    IN idopcionpadre INT,
    IN tipocomponentehtml VARCHAR(100),
    IN comentariorespuesta TEXT,
    IN textoopcion TEXT
)
BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;

    SELECT MAX(valor_opcion) INTO NumMax
    FROM opciones_respuesta
    WHERE id_pregunta = idpregunta;
   

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    
    INSERT INTO opciones_respuesta (valor_opcion, id_categoria_catalogo, id_pregunta, creado_en, actualizado_en, tipo_componente_html, comentario_respuesta, texto_opcion) 
    VALUES (NumSiguiente, idcategoriacatalogo,idpregunta, NOW(),NOW(),tipocomponentehtml,comentariorespuesta,textoopcion);
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizarpregunta$$
CREATE PROCEDURE  actualizarpregunta(
    IN preguntaActualizar INT,
    IN idcapitulo INT,
    IN tipoRespuesta VARCHAR(100),
    IN comentarioPregunta VARCHAR(300),
    IN textoPregunta VARCHAR(200)
)

BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;
    DECLARE capitulonum INT;
    DECLARE preguntaNumero INT;

    SELECT MAX(numero_pregunta) INTO NumMax
    FROM preguntas
    WHERE id_capitulo   = idcapitulo;

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    SELECT id_capitulo INTO capitulonum 
    FROM preguntas
    WHERE id = preguntaActualizar;

    SELECT numero_pregunta INTO preguntaNumero
    FROM preguntas
    WHERE id = preguntaActualizar AND capitulonum = idcapitulo; 

    IF capitulonum = idcapitulo THEN
        UPDATE Preguntas 
        SET id_capitulo = idcapitulo, actualizado_en = NOW(), tipo_respuesta = tipoRespuesta, numero_pregunta = preguntaNumero, comentario_pregunta = comentarioPregunta, texto_pregunta = textoPregunta 
        WHERE id = preguntaActualizar;
        
    ELSE 
        UPDATE Preguntas 
        SET id_capitulo = idcapitulo, actualizado_en = NOW(), tipo_respuesta = tipoRespuesta, numero_pregunta = NumSiguiente, comentario_pregunta = comentarioPregunta, texto_pregunta = textoPregunta 
        WHERE id = preguntaActualizar;
        
    END IF;

END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizaropciones$$
CREATE PROCEDURE  actualizaropciones(
    IN idor INT,
    IN idpregunta INT,
    IN idcategoriacatalogo INT,
    IN idopcionpadre INT,
    IN tipocomponentehtml VARCHAR(100),
    IN comentariorespuesta TEXT,
    IN textoopcion TEXT
)

BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;
    DECLARE insPregunta INT;
    DECLARE valoractual INT;

    SELECT MAX(valor_opcion) INTO NumMax
    FROM opciones_respuesta
    WHERE id_pregunta = idpregunta;

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    SELECT id_pregunta INTO insPregunta
    FROM opciones_respuesta
    WHERE id = idor;

    SELECT valor_opcion INTO valoractual
    FROM opciones_respuesta
    WHERE id = idor AND id_pregunta = idpregunta; 

    IF insPregunta = idpregunta THEN
        UPDATE opciones_respuesta 
        SET valor_opcion = valoractual, id_pregunta = idpregunta, id_categoria_catalogo = idcategoriacatalogo, actualizado_en = now(), id_opcion_padre = idopcionpadre, tipo_componente_html = tipocomponentehtml, comentario_respuesta = comentariorespuesta, texto_opcion = textoopcion
        WHERE id = idor;
    ELSE 
        UPDATE opciones_respuesta 
        SET valor_opcion = NumSiguiente, id_pregunta = idpregunta, id_categoria_catalogo = idcategoriacatalogo, actualizado_en = now(), id_opcion_padre = idopcionpadre, tipo_componente_html = tipocomponentehtml, comentario_respuesta = comentariorespuesta, texto_opcion = textoopcion
        WHERE id = idor;
        
    END IF;

END$$
DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarSubopciones$$
CREATE PROCEDURE actualizarSubopciones(
    IN idSubopcion INT,
    IN idOpcionRespuesta INT,
    IN componenteHtml VARCHAR(255),
    IN textoSubopcion VARCHAR(255)
)
BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;
    DECLARE insOpcionRespuesta INT;
    DECLARE valorActual INT;

    SELECT MAX(numero_subopcion) INTO NumMax
    FROM subopciones_respuesta
    WHERE id_opcion_respuesta = idOpcionRespuesta;

    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    SELECT id_opcion_respuesta INTO insOpcionRespuesta
    FROM subopciones_respuesta
    WHERE id = idSubopcion;

    SELECT numero_subopcion INTO valorActual
    FROM subopciones_respuesta
    WHERE id = idSubopcion AND id_opcion_respuesta = idOpcionRespuesta; 


    IF insOpcionRespuesta = idOpcionRespuesta THEN
        UPDATE subopciones_respuesta 
        SET numero_subopcion = valorActual, actualizado_en = NOW(), componente_html = componenteHtml, texto_subopcion = textoSubopcion
        WHERE id = idSubopcion;
    ELSE 
        UPDATE subopciones_respuesta 
        SET numero_subopcion = NumSiguiente, id_opcion_respuesta = idOpcionRespuesta, actualizado_en = NOW(), componente_html = componenteHtml, texto_subopcion = textoSubopcion
        WHERE id = idSubopcion;
    END IF;

END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS validarvalorsubopciones$$
CREATE PROCEDURE validarvalorsubopciones(
    IN idopcionrespuesta INT,
    IN componentehtml VARCHAR(255),
    IN textosubopcion VARCHAR(255)
)
BEGIN
    DECLARE NumMax INT;
    DECLARE NumSiguiente INT;

    SELECT MAX(numero_subopcion) INTO NumMax
    FROM subopciones_respuesta
    WHERE id_opcion_respuesta = idopcionrespuesta;
   
    IF NumMax IS NULL THEN
        SET NumSiguiente = 1;
    ELSE
        SET NumSiguiente = NumMax + 1;
    END IF;

    INSERT INTO subopciones_respuesta (numero_subopcion, creado_en, actualizado_en, id_opcion_respuesta, componente_html, texto_subopcion) 
    VALUES (NumSiguiente, NOW(), NOW(), idopcionrespuesta, componentehtml, textosubopcion);
END$$

DELIMITER ;

CALL validarvaloropcion(2,2,null,"si","ok","ingrese");

CALL validarvalorsubopciones(3,"dia","noche");

CALL actualizaropciones(34,4,4,null,"mau","lau","maria");


CALL actualizarSubopciones(1,2,"h","t");

