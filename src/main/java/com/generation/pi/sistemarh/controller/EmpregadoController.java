package com.generation.pi.sistemarh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.pi.sistemarh.model.Empregado;
import com.generation.pi.sistemarh.repository.EmpregadoRepository;
import com.generation.pi.sistemarh.repository.EmpresaRepository;


@RestController
@RequestMapping("/empregados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpregadoController {

	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public ResponseEntity<List<Empregado>> getAll(){
		return ResponseEntity.ok(empregadoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empregado> getById(@PathVariable Long id){
		return empregadoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	} 

}
