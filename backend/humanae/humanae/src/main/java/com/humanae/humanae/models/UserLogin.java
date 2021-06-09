package com.humanae.humanae.models;

public class UserLogin {
	
	private long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	private boolean tipoDoador;
	
	private boolean tipoParceiros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isTipoDoador() {
		return tipoDoador;
	}

	public void setTipoDoador(boolean tipoDoador) {
		this.tipoDoador = tipoDoador;
	}

	public boolean isTipoParceiros() {
		return tipoParceiros;
	}

	public void setTipoParceiros(boolean tipoParceiros) {
		this.tipoParceiros = tipoParceiros;
	}

}
