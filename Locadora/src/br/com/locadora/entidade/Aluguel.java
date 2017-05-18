package br.com.locadora.entidade;

import java.sql.Date;

public class Aluguel {

	private Integer id;
	private Veiculo veiculo;
	private Cliente cliente;
	private Date dataInicio;
	private Date dataFim;
	private double preco;

		

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
