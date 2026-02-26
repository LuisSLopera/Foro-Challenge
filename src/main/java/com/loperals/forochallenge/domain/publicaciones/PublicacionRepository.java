package com.loperals.forochallenge.domain.publicaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    Boolean existsByMensaje(String mensaje);

    Boolean existsByTitulo(String titulo);
}
