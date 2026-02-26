package com.loperals.forochallenge.domain.publicaciones;

import com.loperals.forochallenge.domain.usuarios.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrarPublicacion {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private Usuariorepository usuariorepository;

    public DatosConsultaPublicacion registrar(DatosPublicacion datos){
        var usuario = usuariorepository.findById(datos.idUsuario()).get();
        var fecha = LocalDateTime.now();
        var registro = new Publicacion(null,datos.titulo(),datos.mensaje(),fecha,Boolean.TRUE,usuario,datos.curso());

        publicacionRepository.save(registro);

        return new DatosConsultaPublicacion(registro);

    }
}
