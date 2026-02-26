package com.loperals.forochallenge.controller;

import com.loperals.forochallenge.domain.usuarios.DatosAutenticacion;
import com.loperals.forochallenge.domain.usuarios.Usuario;
import com.loperals.forochallenge.infra.security.DatosTokenJWT;
import com.loperals.forochallenge.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService token;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity inicioSesion(@Valid@RequestBody DatosAutenticacion datos){
        var authenticationToken=new UsernamePasswordAuthenticationToken(datos.nombre(),datos.contrasena());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJwt =token.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJwt));
    }
}
