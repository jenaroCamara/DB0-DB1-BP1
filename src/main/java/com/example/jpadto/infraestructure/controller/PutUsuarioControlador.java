package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Put")
public class PutUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("actualizar")
    public ResponseEntity<DTOusuario> actualiza(@RequestBody DTOusuario usuario) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
