package com.loperals.forochallenge.domain.publicaciones;

public record DatosPublicacion(
        Long idUsuario,
    String titulo,
    String mensaje,
        Curso curso
) {
}
