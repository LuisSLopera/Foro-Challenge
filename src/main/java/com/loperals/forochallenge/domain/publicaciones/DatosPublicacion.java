package com.loperals.forochallenge.domain.publicaciones;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosPublicacion(
        @NotNull Long idUsuario,
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull Curso curso
) {
}
