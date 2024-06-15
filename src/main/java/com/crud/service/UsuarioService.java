package com.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.modelo.Usuario;
import com.crud.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario crear(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public List<Usuario> buscarTodo() {
        return (List<Usuario>) repositorio.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Usuario actualizar(Usuario usuarioActualizar) {
        Usuario usuarioActual = repositorio.findById(usuarioActualizar.getIdUsuario()).orElse(null);
        if (usuarioActual != null) {
            usuarioActual.setNombre(usuarioActualizar.getNombre());
            usuarioActual.setApellido(usuarioActualizar.getApellido());
            usuarioActual.setCorreo(usuarioActualizar.getCorreo());
            usuarioActual.setContraseña(usuarioActualizar.getContraseña());
            usuarioActual.setPlan(usuarioActualizar.getPlan());
            return repositorio.save(usuarioActual);
        }
        return null;
    }

    public void borrarPorId(Long id) {
        repositorio.deleteById(id);
    }
}