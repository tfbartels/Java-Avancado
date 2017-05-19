package br.com.locadora.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treinamento_cliente")
public class Cliente {
	
	@Id	
	private Integer id;
	private String nome;
	private String cpf;	
	private String email;

    public Cliente(){
    	
    }	
		
	public Cliente(Integer id, String nome, String cpf, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

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


	@Override
	public String toString() {
		return this.nome +" - " + this.cpf;
	}

	@Override
	public boolean equals(Object obj) {
		Cliente c = (Cliente) obj;
		return c.nome.equals(this.nome);
	}
}
