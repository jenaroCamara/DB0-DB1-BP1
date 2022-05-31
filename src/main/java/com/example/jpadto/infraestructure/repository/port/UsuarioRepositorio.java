package com.example.jpadto.infraestructure.repository.port;

import com.example.jpadto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    List<Usuario> findByName(String nombre);
}
