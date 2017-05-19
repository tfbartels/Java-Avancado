package br.gov.treinamento.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@Column
	private String endereco;
	@Column
	private String telefone;
	
	public Agenda(){}
	public Agenda(long id, Pessoa pessoa, String endereco, String telefone) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
