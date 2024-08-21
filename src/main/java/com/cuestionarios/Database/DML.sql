INSERT INTO usuarios (habilitado, nombre_usuario, contraseña) VALUES 
(TRUE, 'juanperez', 'password123'),
(TRUE, 'maria_gomez', 'qwerty789'),
(FALSE, 'luis_rodriguez', 'pass@457'),
(TRUE, 'carla_lopez', 'abcde123'),
(TRUE, 'francisco_diaz', 'password987'),
(FALSE, 'sofia_martinez', 'p@ssword!'),
(TRUE, 'antonio_garcia', '9876pass'),
(TRUE, 'lucia_morales', 'secure@pass'),
(TRUE, 'julio_ramirez', 'ramirez321'),
(FALSE, 'paula_vargas', '123paula'),
(TRUE, 'pedro_torres', 'torres2020'),
(TRUE, 'camila_gutierrez', 'cami$567'),
(FALSE, 'andres_fernandez', 'andres123'),
(TRUE, 'catalina_sosa', 'sosaPass987'),
(TRUE, 'jorge_mendoza', 'jorge2021');

INSERT INTO roles (nombre) VALUES 
('Administrador'),
('Usuario');

INSERT INTO usuarios_roles (id_rol, id_usuario) VALUES 
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), 
(2, 8), (2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14), 
(1, 15);

INSERT INTO categorias_catalogo (creado_en, actualizado_en, nombre) VALUES
('2024-09-01', '2024-09-01', 'antecedentes medicos'), 
('2024-09-01', '2024-09-01', 'Escala de actividad física'),
('2024-12-01', '2024-12-01', 'escala de salud'),
('2024-10-01', '2024-10-01', 'Escala de regularidad del sueño'),
('2024-12-01', '2024-12-01', 'Frecuencia de calidad de alimentacion'),
('2024-12-20', '2024-12-20', 'Escala de nivel de estrés');

INSERT INTO encuestas (creado_en, actualizado_en, descripcion, nombre) VALUES 
('2024-09-01', '2024-09-15', 'Encuesta sobre salud', 'Encuesta de Salud'),
('2024-10-01', '2024-10-20', 'Encuesta sobre hábitos', 'Encuesta de Hábitos'),
('2024-12-01', '2024-12-15', 'Encuesta sobre alimentación', 'Encuesta de Alimentación'),
('2024-12-20', '2024-12-30', 'Encuesta sobre bienestar', 'Encuesta de Bienestar');


INSERT INTO capitulos (id_encuesta, creado_en, actualizado_en, numero_capitulo, titulo_capitulo) VALUES

(1, '2024-09-01', '2024-09-15', '1', 'Información General'),

(1, '2024-09-01', '2024-09-15', '1', 'Estado de Salud'),

(2, '2024-09-01', '2024-09-15', '1', 'Estado del sueño'),

(3, '2024-10-01', '2024-10-20', '2', 'Hábitos Alimenticios'),

(4, '2024-12-20', '2024-12-30', '2', 'Nivel de Estrés');

INSERT INTO preguntas (id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta) VALUES

(1, '2024-09-01', '2024-09-15', '1', 'Texto', 'Pregunta abierta sobre antecedentes médicos', '¿Tiene algún antecedente médico relevante?'),

(1, '2024-09-01', '2024-09-15', '2', 'Escala de 1 a 5', 'Pregunta sobre el nivel de actividad física', '¿Cómo calificaría su nivel de actividad física?'),


(2, '2024-09-01', '2024-09-15', '3', 'Escala de 1 a 5', 'Pregunta sobre la percepción de salud', '¿Cómo calificaría su percepción general de salud?'),

(2, '2024-09-01', '2024-09-15', '4', 'Sí/No', 'Pregunta sobre la presencia de enfermedades crónicas', '¿Padece alguna enfermedad crónica?'),


(3, '2024-10-01', '2024-10-20', '5', 'Escala de 1 a 5', 'Pregunta abierta sobre calidad del sueño', '¿Cómo es la calidad de su sueño?'),

(3, '2024-10-01', '2024-10-20', '6', 'Escala de 1 a 5', 'Pregunta sobre la regularidad del sueño', '¿Cómo calificaría la regularidad de su horario de sueño?'),


(4, '2024-10-01', '2024-10-20', '7', 'Escala de 1 a 5', 'Pregunta sobre la calidad de la alimentación', '¿Cómo calificaría la calidad de su alimentación?'),

(4, '2024-10-01', '2024-10-20', '8', 'Texto', 'Pregunta abierta sobre problemas alimenticios', '¿Tiene algún problema alimenticio que desee mencionar?'),


(5, '2024-12-20', '2024-12-30', '9', 'Escala de 1 a 5', 'Pregunta sobre nivel de estrés', '¿Cómo calificaría su nivel de estrés en las últimas semanas?');


INSERT INTO opciones_respuesta (valor_opcion, id_categoria_catalogo, id_pregunta, creado_en, actualizado_en, tipo_componente_html, comentario_respuesta, texto_opcion) VALUES

(1, 1, 2, '2024-09-01', '2024-09-15', 'radio', 'Escala de actividad física', 'Muy bajo'),
(2, 1, 2, '2024-09-01', '2024-09-15', 'radio', 'Escala de actividad física', 'Bajo'),
(3, 1, 2, '2024-09-01', '2024-09-15', 'radio', 'Escala de actividad física', 'Moderado'),
(4, 1, 2, '2024-09-01', '2024-09-15', 'radio', 'Escala de actividad física', 'Alto'),
(5, 1, 2, '2024-09-01', '2024-09-15', 'radio', 'Escala de actividad física', 'Muy alto'),



(1, 3, 4, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'si'),
(2, 3, 4, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'no'),

(1, 3, 3, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'Muy bajo'),
(2, 3, 3, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'Bajo'),
(3, 3, 3, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'Moderado'),
(4, 3, 3, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'Alto'),
(5, 3, 3, '2024-09-01', '2024-09-15', 'radio', 'Escala de salud', 'Muy alto'),




(1, 4, 5, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Muy bajo'),
(2, 4, 5, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Bajo'),
(3, 4, 5, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Moderado'),
(4, 4, 5, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Alto'),
(5, 4, 5, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Muy alto'),


(1, 4, 6, '2024-09-01', '2024-09-16', 'radio', 'escala de sueño', 'Muy bajo'),
(2, 4, 6, '2024-09-01', '2024-09-16', 'radio', 'escala de sueño', 'Bajo'),
(3, 4, 6, '2024-09-01', '2024-09-16', 'radio', 'escala de sueño', 'Moderado'),
(4, 4, 6, '2024-09-01', '2024-09-16', 'radio', 'escala de sueño', 'Alto'),
(5, 4, 6, '2024-09-01', '2024-09-15', 'radio', 'escala de sueño', 'Muy alto'),




(1, 5, 7, '2024-09-01', '2024-09-17', 'radio', 'habitos alimenticios', 'Muy bajo'),
(2, 5, 7, '2024-09-01', '2024-09-17', 'radio', 'habitos alimenticios', 'Bajo'),
(3, 5, 7, '2024-09-01', '2024-09-17', 'radio', 'habitos alimenticios', 'Moderado'),
(4, 5, 7, '2024-09-01', '2024-09-17', 'radio', 'habitos alimenticios', 'Alto'),
(5, 5, 7, '2024-09-01', '2024-09-17', 'radio', 'habitos alimenticios', 'Muy alto'),





(1, 6, 9, '2024-12-20', '2024-12-30', 'radio', 'Escala de nivel de estrés', 'Bajo'),
(2, 6, 9, '2024-12-20', '2024-12-30', 'radio', 'Escala de nivel de estrés', 'Moderado'),
(3, 6, 9, '2024-12-20', '2024-12-30', 'radio', 'Escala de nivel de estrés', 'Alto'),
(4, 6, 9, '2024-12-20', '2024-12-30', 'radio', 'Escala de nivel de estrés', 'Muy alto');

