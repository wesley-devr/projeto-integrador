package com.humanae.humanae.models;

public class UserLogin {
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	private boolean tipoParceiros;
	
	private boolean tipoDoador;

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

	public boolean isTipoParceiros() {
		return tipoParceiros;
	}

	public void setTipoParceiros(boolean tipoParceiros) {
		this.tipoParceiros = tipoParceiros;
	}

	public boolean isTipoDoador() {
		return tipoDoador;
	}

	public void setTipoDoador(boolean tipoDoador) {
		this.tipoDoador = tipoDoador;
	}


}
