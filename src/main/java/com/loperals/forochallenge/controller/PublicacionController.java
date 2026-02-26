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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private RegistrarPublicacion registrar;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@Valid @RequestBody DatosPublicacion datos){
        System.out.println(datos);
        registrar.registrar(datos);

        return ResponseEntity.ok(datos);
    }

    @GetMapping
    public ResponseEntity<Page<DatosConsultaPublicacion>> consultar(@PageableDefault(size=10,sort = {"fechaCreacion"})Pageable paginacion){
        var page= publicacionRepository.findAllByEstadoTrue(paginacion).map(DatosConsultaPublicacion::new);

        return ResponseEntity.ok(page);

    }

    @GetMapping("{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var publicacion=publicacionRepository.getReferenceById(id);

        return ResponseEntity.ok(new DatosConsultaPublicacion(publicacion));
    }

    @PutMapping("{id}")
    public ResponseEntity modificar(@PathVariable Long id, @RequestBody DatosPublicacion datos){
        var publicacion=publicacionRepository.getReferenceById(id);
        registrar.modificar(datos, id);

        return ResponseEntity.ok(new DatosConsultaPublicacion(publicacion));
    }

}
