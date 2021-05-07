package com.humanae.humanae.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Parceiros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String causa;
	
	@NotNull
	@Size(min = 15, max = 255)
	private String descricao;
	
	@NotNull
	@Size(max = 14)
	private String cnpj;
	
	@NotNull
	@Size(min = 5, max = 150) 
	private String endereco;
	
	@NotNull
	@Size(min = 5, max = 45)
	private String email;
	
	@NotNull
	@Size(min = 5, max = 45)
	private String senha;
	
	@NotNull
	@Size(min = 5, max = 45)
	private String conta;
	
	@OneToMany(mappedBy = "parceiros" )
	@JsonIgnoreProperties
	private List<Produtos> produto;

	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}
	
	
}
