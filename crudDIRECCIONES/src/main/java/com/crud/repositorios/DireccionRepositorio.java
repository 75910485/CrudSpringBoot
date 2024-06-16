package com.crud.repositorios;

import com.crud.modelo.Direccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepositorio extends CrudRepository<Direccion, Long> {
}
