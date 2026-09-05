/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gudu.api.controller;

import com.gudu.api.model.Usuario;
import com.gudu.api.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioRepository repository;
    
    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }
    
    @GetMapping
    public List<Usuario> listar(){
        return repository.listar();
    }
    
    @PostMapping
    public String inserir(@RequestBody Usuario usuario){
        repository.inserir(usuario);
        return "foi";
    }
}
