package br.com.locadora.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.entidade.Veiculo;

@ManagedBean
@RequestScoped
public class VeiculoBean {

	private List<Veiculo> veiculos;

	public List<Veiculo> getVeiculos() {
		VeiculoDAO dao = new VeiculoDAO();
		
		veiculos = dao.listar();
		
		return veiculos;
	}


	
	
}
