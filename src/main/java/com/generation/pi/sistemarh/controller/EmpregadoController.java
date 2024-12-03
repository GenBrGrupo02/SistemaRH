package com.generation.pi.sistemarh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.pi.sistemarh.model.Empregado;
import com.generation.pi.sistemarh.repository.EmpregadoRepository;
import com.generation.pi.sistemarh.repository.EmpresaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empregados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpregadoController {

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public ResponseEntity<List<Empregado>> getAll() {
		return ResponseEntity.ok(empregadoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empregado> getById(@PathVariable Long id) {
		return empregadoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Empregado> post(@Valid @RequestBody Empregado empregado) {
		if (empresaRepository.existsById(empregado.getEmpresa().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(empregadoRepository.save(empregado));

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa não existe!", null);
	}

	@PutMapping
	public ResponseEntity<Empregado> put(@Valid @RequestBody Empregado postagem) {
		if (empresaRepository.existsById(postagem.getId())) {

			if (empresaRepository.existsById(postagem.getEmpresa().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(empregadoRepository.save(postagem));

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa não existe!", null);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
