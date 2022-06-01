package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Post")
public class PostUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirUsuario")
    public ResponseEntity<DTOusuario> anadirUsuario(@RequestBody @Valid DTOusuario DTOusu) throws Exception{
        try{
            Usuario user  = usuarioServicio.guardar(modelMapper.map(DTOusu, Usuario.class));
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(user,DTOusuario.class));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
