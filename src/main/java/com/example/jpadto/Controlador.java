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
    public DTOusuario anadirUsuario(@RequestBody DTOusuario DTOusu){
        Usuario usuario = new Usuario(DTOusu.getId(),DTOusu.getName(),DTOusu.getUsuario());
        usuarioRepositorio.save(usuario);
        return DTOusu;
    }

    @GetMapping("getUsuario/{id}")
    public DTOusuario getById(@PathVariable String id)throws Exception{
        Usuario u = usuarioRepositorio.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        return new DTOusuario(u.getId(),u.getName(),u.getUsuario());
    }

    @PutMapping("actualizar")
    public void actualiza(@RequestBody DTOusuario usuario) throws Exception {
        Optional<Usuario> user = usuarioRepositorio.findById(Integer.toString(usuario.getId()));
        if(user.isPresent()){
            usuarioRepositorio.save(user.get());
        }
        //return usuarioRepositorio.findById(Integer.toString(usuario.getId())).orElseThrow(() -> new Exception("Usuario no encontrado"));
        //return user.get();
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id){
        if (usuarioRepositorio.findById(id).isPresent()){
            usuarioRepositorio.deleteById(id);
        }//preguntar si no está, mandar excepción o que
    }



}
