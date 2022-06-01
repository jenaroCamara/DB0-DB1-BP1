package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Get")
public class GetUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("getUsuario/{id}")
    public ResponseEntity<DTOusuario> getById(@PathVariable(value="id" ) String id)throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.getUserById(id));
            //return usuarioServicio.getUserById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getUsuarios/{nombre}")
    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre){
        return usuarioServicio.getUsuariosByName(nombre);
    }
    @GetMapping("/getUsuarios")
    public List<DTOusuario> getUsuarios(){
        return usuarioServicio.getUsuarios();
    }

}
