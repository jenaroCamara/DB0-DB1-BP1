package com.example.jpadto.infraestructure;

import com.example.jpadto.infraestructure.controller.DTO.DTOusuario;
import com.example.jpadto.Repository.UsuarioService;
import com.example.jpadto.domain.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirUsuario")
    public DTOusuario anadirUsuario(@RequestBody DTOusuario DTOusu) throws Exception{
        Usuario user  = usuarioService.guardar(modelMapper.map(DTOusu, Usuario.class));
        return DTOusu;
    }

    @PutMapping("actualizar")
    public void actualiza(@RequestBody DTOusuario usuario) throws Exception {
        usuarioService.actualiza(usuario);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id) throws Exception {
        usuarioService.deleteById(id);
    }

    @GetMapping("getUsuario/{id}")
    public DTOusuario getById(@PathVariable(value="id" ) String id)throws Exception{
        return usuarioService.getUserById(id);
    }

    @GetMapping("/getUsuarios/{nombre}")
    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre){
        return usuarioService.getUsuariosByName(nombre);
    }
    @GetMapping("/getUsuarios")
    public List<DTOusuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

}
