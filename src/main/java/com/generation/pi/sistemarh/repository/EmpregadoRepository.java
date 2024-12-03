package com.generation.pi.sistemarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.pi.sistemarh.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	public List<Empregado> findAllByCargoContainingIgnoreCase(@Param("cargo") String cargo);
}
