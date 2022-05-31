package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.port.UsuarioServicioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Put")
public class PutUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;

    @PutMapping("actualizar")
    public void actualiza(@RequestBody DTOusuario usuario) throws Exception {
        usuarioServicio.actualiza(usuario);
    }
}
