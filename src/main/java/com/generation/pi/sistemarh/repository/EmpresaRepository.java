package com.generation.pi.sistemarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.pi.sistemarh.model.Empresa;
	
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	public List<Empresa> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
