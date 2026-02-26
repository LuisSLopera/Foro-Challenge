package com.loperals.forochallenge.domain.publicaciones;

import java.time.LocalDateTime;

public record DatosConsultaPublicacion(
        Long id,
    Long idUsuario,
    String titulo,
    String mensaje,
    LocalDateTime fechaCreacion
) {
    public DatosConsultaPublicacion(Publicacion registro) {
        this(registro.getId(), registro.getUsuario().getId(),
                registro.getTitulo(),registro.getMensaje(),registro.getFechaCreacion());
    }
}
