package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Get")
public class GetUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("getUsuario/{id}")
    public ResponseEntity<DTOusuario> getById(@PathVariable(value = "id") String id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.getUserById(id));
    }

    @GetMapping("/getUsuarios/{nombre}")
    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre) {
        return usuarioServicio.getUsuariosByName(nombre);
    }

    @GetMapping("/getUsuarios")
    public List<DTOusuario> getUsuarios() {
        return usuarioServicio.getUsuarios();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
