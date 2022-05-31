package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.port.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Post")
public class PostUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirUsuario")
    public DTOusuario anadirUsuario(@RequestBody DTOusuario DTOusu) throws Exception{
        Usuario user  = usuarioServicio.guardar(modelMapper.map(DTOusu, Usuario.class));
        return DTOusu;
    }

}
