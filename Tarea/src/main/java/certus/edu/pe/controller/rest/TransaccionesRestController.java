package certus.edu.pe.controller.rest;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import certus.edu.pe.modelo.Transacciones;
import certus.edu.pe.servicios.TransaccionesServicio;

@RestController
@RequestMapping("/rest/transacciones")
public class TransaccionesRestController {

	
	@Autowired
	private TransaccionesServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Transacciones> listaTransacciones = servicio.buscarTodo();
		System.out.println("LISTA DE FUNCIONES : " + listaTransacciones);
		return new ResponseEntity<>(listaTransacciones, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Transacciones funcion= servicio.buscarPorId(id);
		if(funcion == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Funcion no encontrada, id proporcionado no es correcto");
					
			return new ResponseEntity<Object>(funcion, HttpStatus.OK);

	}
		
	
@PostMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
             consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})	
public  ResponseEntity<Object> crear(@RequestBody Transacciones funcion){
	servicio.crear(funcion);
	return new  ResponseEntity<Object>("Funcion creada correctamente" , HttpStatus.OK);
}
	
	
@PutMapping(value = "/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})	
public  ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Transacciones funcion){
servicio.actualizar(funcion);
return new  ResponseEntity<Object>("Funcion actualizada correctamente" , HttpStatus.OK);
}

@DeleteMapping(value = "/{id}")
public  ResponseEntity<Object> eliminar(@PathVariable("id") int id){
servicio.eliminarFunciones(id);
return new  ResponseEntity<Object>("Funcion eliminada correctamente" , HttpStatus.OK);
}

	}
	


