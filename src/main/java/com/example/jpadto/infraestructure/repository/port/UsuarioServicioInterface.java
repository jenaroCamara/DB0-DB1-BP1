package com.example.jpadto.infraestructure.repository.port;

import com.example.jpadto.domain.Usuario;
import com.example.jpadto.infraestructure.dto.DTOusuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface UsuarioServicioInterface {
    public Usuario guardar(Usuario usuario) throws Exception;
    public List<DTOusuario> getUsuarios();
    public List<DTOusuario> getUsuariosByName(@PathVariable String nombre);
    public DTOusuario getUserById(String id) throws Exception ;
    public void actualiza(@RequestBody DTOusuario usuario) throws Exception;
    public void deleteById(String id) throws Exception;
}
