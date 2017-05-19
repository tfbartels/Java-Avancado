package br.com.locadora.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "treinamento_aluguel")
public class Aluguel {

	@Id	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo" , referencedColumnName = "id")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente" , referencedColumnName = "id")
	private Cliente cliente;
	
	@Column(name = "data_ini")
	private Date dataInicio;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	private double preco;

		
	public Aluguel(){
		
	}
	public Aluguel(Integer id, Veiculo veiculo, Cliente cliente,
			Date dataInicio, Date dataFim, double preco) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}



}
