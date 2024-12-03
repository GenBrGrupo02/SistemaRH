package com.generation.pi.sistemarh.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é Obrigatorio ")
	@Size(min = 5, max = 20, message = "O atributo nome deve conter no mínimo 05 e no máximo 20 caracteres")
	private String nome;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("empresa")
	private List<Empregado> empregado;

	public List<Empregado> getEmpregado() {
		return empregado;
	}

	public void setEmpregado(List<Empregado> empregado) {
		this.empregado = empregado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
