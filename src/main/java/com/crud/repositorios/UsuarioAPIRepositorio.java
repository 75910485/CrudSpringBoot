package com.crud.repositorios;

import org.springframework.data.repository.CrudRepository;
import com.crud.modelo.UsuarioAPI;

public interface UsuarioAPIRepositorio extends CrudRepository<UsuarioAPI, Long> {

}