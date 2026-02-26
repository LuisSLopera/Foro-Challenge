
CREATE TABLE  IF NOT EXISTS  usuarios (
  id BIGINT NOT NULL auto_increment,
  nombre VARCHAR(50) NOT NULL,
  contrasena VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));

