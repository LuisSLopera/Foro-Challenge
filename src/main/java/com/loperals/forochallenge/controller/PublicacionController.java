package com.loperals.forochallenge.controller;


import com.loperals.forochallenge.domain.publicaciones.DatosPublicacion;
import com.loperals.forochallenge.domain.publicaciones.RegistrarPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class PublicacionController {

    @Autowired
    private RegistrarPublicacion registrar;

    @PostMapping
    public ResponseEntity registrar(@RequestBody DatosPublicacion datos){
        System.out.println(datos);
        registrar.registrar(datos);

        return ResponseEntity.ok(datos);
    }
}
