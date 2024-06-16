package com.crud.service;

import com.crud.modelo.Direccion;
import com.crud.repositorios.DireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    public Iterable<Direccion> listarTodas() {
        return direccionRepositorio.findAll();
    }

    public Direccion obtenerPorId(Long id) {
        return direccionRepositorio.findById(id).orElse(null);
    }

    public void guardar(Direccion direccion) {
        direccionRepositorio.save(direccion);
    }

    public void eliminar(Long id) {
        direccionRepositorio.deleteById(id);
    }
}
