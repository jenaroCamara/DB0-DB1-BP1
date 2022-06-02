package com.example.jpadto.application;

import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.repository.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio implements UsuarioServicioInterface {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    public Usuario guardar(Usuario usuario) throws Exception {
        String auxName = usuario.getUsuario();
        if (auxName.length() < 6 || auxName.length() > 16) {
            throw new BeanNotFoundException("Error al guardar el usuario");
        }
        return usuarioRepositorio.save(usuario);
    }

    public List<DTOusuario> getUsuarios() {
        Iterable<Usuario> iterableUsuario = usuarioRepositorio.findAll();
        List<DTOusuario> ListaDTOs = new ArrayList<>();
        iterableUsuario.forEach((Usuario) -> {
            ListaDTOs.add(modelMapper.map(Usuario, DTOusuario.class));
        });
        return ListaDTOs;
    }

    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre) {
        List<Usuario> lista = usuarioRepositorio.findByName(nombre);
        return lista.stream()
                .map(Usuario -> modelMapper.map(Usuario, DTOusuario.class))
                .collect(Collectors.toList());
    }

    public DTOusuario getUserById(String id) throws Exception {
        Usuario user = usuarioRepositorio.findById(Integer.parseInt(id)).orElseThrow(() -> new BeanNotFoundException("Usuario no encontrado"));
        return modelMapper.map(user, DTOusuario.class);
    }

    public DTOusuario actualiza(@RequestBody DTOusuario usuario) throws Exception {
        Usuario user = usuarioRepositorio.findById(usuario.getId()).orElseThrow(() -> new Exception("Usuario no encontrado"));
        usuarioRepositorio.save(modelMapper.map(usuario, Usuario.class));
        return usuario;
    }

    public void deleteById(String id) throws Exception {
            if (!usuarioRepositorio.findById(Integer.parseInt(id)).isPresent()) {
                throw new UnprocesableException("Usuario no encontrado");
            }
        usuarioRepositorio.deleteById(Integer.parseInt(id));
    }
}
