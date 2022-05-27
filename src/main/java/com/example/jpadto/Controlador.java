package com.example.jpadto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/hola")
    public String hola(){
        return "hola";
    }

    @GetMapping("/getUsuarios")
    public List<Usuario> getUsuarios(){
        return usuarioRepositorio.findAll();
    }

    @PostMapping("/anadirUsuario")
    public Usuario anadirUsuario(@RequestBody Usuario usuario){
        usuarioRepositorio.save(usuario);
        return usuario;
    }

    @GetMapping("getUsuario/{id}")
    public Usuario getById(@PathVariable String id)throws Exception{
        return usuarioRepositorio.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
    }

    @PutMapping("actualizar")
    public Usuario actualiza(@RequestBody Usuario usuario) throws Exception {
        Optional<Usuario> user = usuarioRepositorio.findById(Integer.toString(usuario.getId()));
        if(user.isPresent()){
            usuarioRepositorio.save(usuario);
        }
        return usuarioRepositorio.findById(Integer.toString(usuario.getId())).orElseThrow(() -> new Exception("Usuario no encontrado"));
        //return user.get();
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id){
        if (usuarioRepositorio.findById(id).isPresent()){
            usuarioRepositorio.deleteById(id);
        }//preguntar si no está, mandar excepción o que
    }



}
