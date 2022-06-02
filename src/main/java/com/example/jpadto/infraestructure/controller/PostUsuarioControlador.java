package com.example.jpadto.infraestructure.controller;

import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Post")
public class PostUsuarioControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirUsuario")//Dejo esta función así, hasta ver si las validation van en dto o en las entidades
    public ResponseEntity<DTOusuario> anadirUsuario(@RequestBody @Valid DTOusuario DTOusu) throws Exception {
            Usuario user = usuarioServicio.guardar(modelMapper.map(DTOusu, Usuario.class));
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(user, DTOusuario.class));
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
