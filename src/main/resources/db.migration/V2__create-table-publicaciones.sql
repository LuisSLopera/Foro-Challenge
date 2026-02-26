
CREATE TABLE IF NOT EXISTS publicaciones (
  id BIGINT NOT NULL auto_increment,
  titulo VARCHAR(50) NOT NULL,
  mensaje VARCHAR(200) NOT NULL,
  fechaCreacion DATETIME NOT NULL,
  estado TINYINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  curso VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  INDEX usuario_id_idx (usuario_id ASC) VISIBLE,
  CONSTRAINT usuario_id
    FOREIGN KEY (usuario_id)
    REFERENCES mydb.usuarios (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);