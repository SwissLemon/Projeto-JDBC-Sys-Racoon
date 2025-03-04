package model;

import java.util.Date;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private String senha;	
	private int status;
	private Date dataNascimento;
	private String dataCriacao;
	private String dultimoLogin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getDultimoLogin() {
		return dultimoLogin;
	}
	public void setDultimoLogin(String dultimoLogin) {
		this.dultimoLogin = dultimoLogin;
	}	
}