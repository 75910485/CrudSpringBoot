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

import com.crud.modelo.UsuarioAPI;
import com.crud.service.UsuarioAPIService;

@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioRestControler {

    @Autowired
    private UsuarioAPIService usuarioAPIService;
    
    @GetMapping
    public ResponseEntity<List<UsuarioAPI>> buscarTodos() {
        List<UsuarioAPI> listaUsuarios = usuarioAPIService.buscarTodo();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAPI> buscarPorId(@PathVariable("id") Long id) {
        UsuarioAPI usuario = usuarioAPIService.buscarPorId(id);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Usuario no encontrado, ID proporcionado no es correcto");
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> crear(@RequestBody UsuarioAPI usuario) {
        usuarioAPIService.crear(usuario);
        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody UsuarioAPI usuario) {
        usuario.setIdUsuario(id); // Asegura que el ID del usuario a actualizar sea el correcto
        usuarioAPIService.actualizar(usuario);
        return new ResponseEntity<>("Usuario actualizado correctamente", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id) {
        usuarioAPIService.eliminarPorId(id);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }
}
