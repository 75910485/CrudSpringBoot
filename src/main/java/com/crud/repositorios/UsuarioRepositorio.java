package com.crud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crud.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    // Consulta personalizada para buscar usuarios por nombre
    @Query(value = "SELECT u FROM Usuario u WHERE u.nombre = ?1")
    public List<Usuario> buscarUsuariosPorNombre(String nombre);
    
    // Consulta personalizada para buscar usuarios cuyo nombre empiece con el valor proporcionado
    @Query(value = "SELECT u FROM Usuario u WHERE u.nombre like CONCAT(?1,'%')")
    public List<Usuario> buscarUsuariosLikeNombre(String nombre);
    
}