package br.gov.pbh.prodabel.treinamento.controller;

public class Animal{
	private String nome;
	private String raca;
	
	public Animal(String nome, String ra�a) {
		super();
		this.nome = nome;
		this.raca = ra�a;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String ra�a) {
		this.raca = ra�a;
	}
}
