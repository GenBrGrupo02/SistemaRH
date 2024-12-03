package com.generation.pi.sistemarh.controller;

import com.generation.pi.sistemarh.model.Empresa;
import com.generation.pi.sistemarh.repository.EmpresaRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public ResponseEntity<List<Empresa>> getAll() {
		return ResponseEntity.ok(empresaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> getById(@PathVariable Long id) {
		return empresaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/departamento/{departamento}")
	public ResponseEntity<List<Empresa>> getByTitle(@PathVariable String departamento) {
		return ResponseEntity.ok(empresaRepository.findAllByDepartamentoContainingIgnoreCase(departamento));
	}

	@PostMapping
	public ResponseEntity<Empresa> post(@Valid @RequestBody Empresa empresa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
	}

	@PutMapping
	public ResponseEntity<Empresa> put(@Valid @RequestBody Empresa empresa) {
		return empresaRepository.findById(empresa.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Empresa> tema = empresaRepository.findById(id);
		
		if(tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		empresaRepository.deleteById(id);
	}

}
