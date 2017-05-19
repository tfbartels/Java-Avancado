package br.com.locadora.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treinamento_veiculo")
public class Veiculo {
	
	@Id
	private Integer id;
	
	@Column(name = "qtde_lugares")
	private Integer qtdeLugares;
	private String placa;
	private String marca;

	
	public Veiculo(){
		
	}
	
	public Veiculo(Integer id, Integer qtdeLugares, String placa, String marca) {
		super();
		this.id = id;
		this.qtdeLugares = qtdeLugares;
		this.placa = placa;
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdeLugares() {
		return qtdeLugares;
	}
	
	public void setQtdeLugares(Integer qtdeLugares) {
		this.qtdeLugares = qtdeLugares;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return this.placa +" - " + this.marca;
	}
	
	@Override
	public boolean equals(Object obj) {
		Veiculo v = (Veiculo) obj;
		return v.getPlaca().equals(this.placa);
	}
}
