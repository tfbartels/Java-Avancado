package br.com.locadora.struts;

import org.apache.struts.action.ActionForm;

public class VeiculosForm extends ActionForm {

		
	private static final long serialVersionUID = 1L;
	
	private Integer qtdeLugares;
	private String placa;
	private String marca;
	
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
	
	
	
	
}
