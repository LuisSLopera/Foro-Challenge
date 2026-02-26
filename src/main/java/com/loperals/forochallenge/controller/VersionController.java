package com.loperals.forochallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
    @GetMapping
    public String version(){
        return "Version 1.0.0 - Foro challenge - By Luis Sebastian Lopera";
    }

}
