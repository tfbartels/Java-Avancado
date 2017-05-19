package br.gov.treinamento.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.treinamento.beans.Pessoa;
import br.gov.treinamento.persistencia.PessoaDAO;

@ManagedBean
@RequestScoped
public class PessoaBean {
	
	private long id;
	private String nome;
	private String cpf;
	private String email;
	
	private List<Pessoa> pessoas;
	
	private String mensagem;
	
	public String cadastrar(){
		Pessoa pessoa = new Pessoa(id, nome, cpf, email);
		PessoaDAO dao = new PessoaDAO();
		dao.salvar(pessoa);
		
		this.mensagem = nome + " cadastrado com sucesso";
		
		return "listagem";
	}
	
	public List<Pessoa> getPessoas() {
		PessoaDAO dao = new PessoaDAO();
		pessoas = dao.listar();
		
		return pessoas;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
