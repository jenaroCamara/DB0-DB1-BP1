package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.infraestructure.repository.port.UsuarioServicioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Delete")
public class DeleteUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id) throws Exception {
        usuarioServicio.deleteById(id);
    }

}
