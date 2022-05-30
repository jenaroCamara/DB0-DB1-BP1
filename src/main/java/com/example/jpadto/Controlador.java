package com.example.jpadto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/hola")
    public String hola(){
        return "hola";
    }

    @GetMapping("/getUsuarios")
    public List<DTOusuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/getUsuarios/{nombre}")
    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre){
        return usuarioService.getUsuariosByName(nombre);
    }

    @PostMapping("/anadirUsuario")
    public DTOusuario anadirUsuario(@RequestBody DTOusuario DTOusu) throws Exception{
        Usuario user  = usuarioService.guardar(modelMapper.map(DTOusu, Usuario.class));
        return DTOusu;
    }

    @GetMapping("getUsuario/{id}")
    public DTOusuario getById(@PathVariable(value="id" ) String id)throws Exception{
        return usuarioService.getUserById(id);
    }

    @PutMapping("actualizar")
    public void actualiza(@RequestBody DTOusuario usuario) throws Exception {
        usuarioService.actualiza(usuario);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id){
        usuarioService.deleteById(id);
    }

}
