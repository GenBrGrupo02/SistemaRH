package com.generation.pi.sistemarh.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_empregado")
public class Empregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres.")
	private String nome;

	@NotBlank(message = "O atributo cargo é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo cargo deve conter no mínimo 05 e no máximo 100 caracteres")
	private String cargo;
	
	@NotBlank(message = "O atributo salario é obrigatório!")
	@Column(precision = 10, scale = 2)
	private BigDecimal salario;

	@ManyToOne
	@JsonIgnoreProperties("empresa")
	private Empresa empresa;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
