package com.loperals.forochallenge.controller;


import com.loperals.forochallenge.domain.publicaciones.DatosConsultaPublicacion;
import com.loperals.forochallenge.domain.publicaciones.DatosPublicacion;
import com.loperals.forochallenge.domain.publicaciones.PublicacionRepository;
import com.loperals.forochallenge.domain.publicaciones.RegistrarPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private RegistrarPublicacion registrar;

    @PostMapping
    public ResponseEntity registrar(@RequestBody DatosPublicacion datos){
        System.out.println(datos);
        registrar.registrar(datos);

        return ResponseEntity.ok(datos);
    }

    @GetMapping
    public ResponseEntity<Page<DatosConsultaPublicacion>> consultar(@PageableDefault(size=10,sort = {"fechaCreacion"})Pageable paginacion){
        var page= publicacionRepository.findAllByEstadoTrue(paginacion).map(DatosConsultaPublicacion::new);

        return ResponseEntity.ok(page);

    }
}
