package com.crud.controler.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crud.modelo.Direccion;
import com.crud.service.DireccionService;

@RestController
@RequestMapping("/rest/direcciones")
public class DireccionRestControler {

    @Autowired
    private DireccionService direccionService;
    
    @GetMapping
    public ResponseEntity<List<Direccion>> buscarTodos() {
        List<Direccion> listaDirecciones = (List<Direccion>) direccionService.listarTodas();
        return new ResponseEntity<>(listaDirecciones, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Direccion> buscarPorId(@PathVariable("id") Long id) {
        Direccion direccion = direccionService.obtenerPorId(id);
        if (direccion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Dirección no encontrada, ID proporcionado no es correcto");
        }
        return new ResponseEntity<>(direccion, HttpStatus.OK);
    }
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> crear(@RequestBody Direccion direccion) {
        direccionService.guardar(direccion);
        return new ResponseEntity<>("Dirección creada correctamente", HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody Direccion direccion) {
        direccion.setId(id); 
        direccionService.guardar(direccion);
        return new ResponseEntity<>("Dirección actualizada correctamente", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id) {
        direccionService.eliminar(id);
        return new ResponseEntity<>("Dirección eliminada correctamente", HttpStatus.OK);
    }
}
