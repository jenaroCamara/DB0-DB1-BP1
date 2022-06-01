package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Delete")
public class DeleteUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        try{
            usuarioServicio.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
