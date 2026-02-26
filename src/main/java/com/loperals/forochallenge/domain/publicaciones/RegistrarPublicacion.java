package com.loperals.forochallenge.domain.publicaciones;

import com.loperals.forochallenge.domain.publicaciones.validaciones.ValidadorConsultas;
import com.loperals.forochallenge.domain.usuarios.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrarPublicacion {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private Usuariorepository usuariorepository;

    @Autowired
    List<ValidadorConsultas> validadores;

    public DatosConsultaPublicacion registrar(DatosPublicacion datos){
        var usuario = usuariorepository.findById(datos.idUsuario()).get();
        var fecha = LocalDateTime.now();

        validadores.forEach(v -> v.validar(datos));

        var registro = new Publicacion(null,datos.titulo(),datos.mensaje(),fecha,Boolean.TRUE,usuario,datos.curso());

        publicacionRepository.save(registro);

        return new DatosConsultaPublicacion(registro);

    }

    public void modificar(DatosPublicacion datos, Long id) {
        var usuario = usuariorepository.findById(datos.idUsuario()).get();
        var fecha = LocalDateTime.now();
        var publicacion = publicacionRepository.getReferenceById(id);

        validadores.forEach(v -> v.validar(datos));

        publicacion.modificar(datos);
        publicacionRepository.save(publicacion);
    }
}
