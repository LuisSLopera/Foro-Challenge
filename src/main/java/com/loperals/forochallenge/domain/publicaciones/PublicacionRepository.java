package com.loperals.forochallenge.domain.publicaciones;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    Boolean existsByMensaje(String mensaje);

    Boolean existsByTitulo(String titulo);

    Page<Publicacion> findAllByEstadoTrue(Pageable paginacion);
}
