
CREATE TABLE IF NOT EXISTS publicaciones (
  id BIGINT NOT NULL auto_increment,
  titulo VARCHAR(50) NOT NULL,
  mensaje VARCHAR(200) NOT NULL,
  fechaCreacion DATETIME NOT NULL,
  estado TINYINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  curso VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));