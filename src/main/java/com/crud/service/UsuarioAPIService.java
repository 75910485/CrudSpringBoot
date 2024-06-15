package com.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.modelo.UsuarioAPI;
import com.crud.repositorios.UsuarioAPIRepositorio;

@Service
@Transactional
public class UsuarioAPIService {

    @Autowired
    private UsuarioAPIRepositorio usuarioAPIRepository;

    public UsuarioAPI crear(UsuarioAPI usuario) {
        return usuarioAPIRepository.save(usuario);
    }

    public List<UsuarioAPI> buscarTodo() {
        return (List<UsuarioAPI>) usuarioAPIRepository.findAll();
    }

    public UsuarioAPI buscarPorId(Long id) {
        Optional<UsuarioAPI> usuarioOptional = usuarioAPIRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    public UsuarioAPI actualizar(UsuarioAPI usuarioActualizar) {
        UsuarioAPI usuarioActual = usuarioAPIRepository.findById(usuarioActualizar.getIdUsuario()).orElse(null);
        if (usuarioActual != null) {
            usuarioActual.setNombre(usuarioActualizar.getNombre());
            usuarioActual.setApellido(usuarioActualizar.getApellido());
            usuarioActual.setCorreo(usuarioActualizar.getCorreo());
            usuarioActual.setContraseña(usuarioActualizar.getContraseña());
            usuarioActual.setPlan(usuarioActualizar.getPlan());
            return usuarioAPIRepository.save(usuarioActual);
        }
        return null; // Manejar la lógica de error si no se encuentra el usuario
    }

    public void eliminarPorId(Long id) {
        usuarioAPIRepository.deleteById(id);
    }
}