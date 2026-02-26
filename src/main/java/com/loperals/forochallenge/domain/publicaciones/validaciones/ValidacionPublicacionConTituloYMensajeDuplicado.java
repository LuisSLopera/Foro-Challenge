package com.loperals.forochallenge.domain.publicaciones.validaciones;

import com.loperals.forochallenge.domain.ValidacionException;
import com.loperals.forochallenge.domain.publicaciones.DatosPublicacion;
import com.loperals.forochallenge.domain.publicaciones.Publicacion;
import com.loperals.forochallenge.domain.publicaciones.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPublicacionConTituloYMensajeDuplicado implements ValidadorConsultas {
    @Autowired
    private PublicacionRepository publicacionRepository;

    public void validar(DatosPublicacion datos){
        var titulopublicacion= publicacionRepository.existsByTitulo(datos.titulo());
        var mensajePublicacion = publicacionRepository.existsByMensaje(datos.mensaje());

        if(mensajePublicacion && titulopublicacion){
            throw new ValidacionException("Publicacion con titulo y mensaje duplicado");
        }


    }
}
