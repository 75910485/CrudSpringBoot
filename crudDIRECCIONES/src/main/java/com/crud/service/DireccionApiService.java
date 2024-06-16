package com.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.modelo.Direccion;
import com.crud.repositorios.DireccionRepositorio;

@Service
@Transactional
public class DireccionApiService {

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    public Direccion guardar(Direccion direccion) {
        return direccionRepositorio.save(direccion);
    }

    public List<Direccion> listarTodas() {
        return (List<Direccion>) direccionRepositorio.findAll();
    }

    public Direccion obtenerPorId(Long id) {
        Optional<Direccion> direccionOptional = direccionRepositorio.findById(id);
        return direccionOptional.orElse(null);
    }

    public Direccion actualizar(Direccion direccionActualizar) {
        Direccion direccionActual = direccionRepositorio.findById(direccionActualizar.getId()).orElse(null);
        if (direccionActual != null) {
            direccionActual.setCalle(direccionActualizar.getCalle());
            direccionActual.setCiudad(direccionActualizar.getCiudad());
            direccionActual.setEstado(direccionActualizar.getEstado());
            direccionActual.setCodigoPostal(direccionActualizar.getCodigoPostal());
            direccionActual.setPais(direccionActualizar.getPais());
            return direccionRepositorio.save(direccionActual);
        }
        return null; 
    }

    public void eliminar(Long id) {
        direccionRepositorio.deleteById(id);
    }
}

