package com.example.library_direccion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library_direccion.model.Direccion;
import com.example.library_direccion.repository.DireccionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    // Obtener todas las direcciones
    @GetMapping
    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    // Obtener una dirección por ID
    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable Long id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        if (direccion.isPresent()) {
            return new ResponseEntity<>(direccion.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva dirección
    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    // Actualizar una dirección existente
    @PutMapping("/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable Long id, @RequestBody Direccion direccionDetails) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        if (direccion.isPresent()) {
            Direccion existingDireccion = direccion.get();
            existingDireccion.setCalle(direccionDetails.getCalle());
            existingDireccion.setCiudad(direccionDetails.getCiudad());
            existingDireccion.setPais(direccionDetails.getPais());
            final Direccion updatedDireccion = direccionRepository.save(existingDireccion);
            return new ResponseEntity<>(updatedDireccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una dirección
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDireccion(@PathVariable Long id) {
        try {
            direccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
