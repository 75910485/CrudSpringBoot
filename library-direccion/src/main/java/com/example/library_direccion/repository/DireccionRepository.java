package com.example.library_direccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_direccion.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
