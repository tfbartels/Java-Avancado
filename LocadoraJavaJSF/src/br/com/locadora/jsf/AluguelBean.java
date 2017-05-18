package br.com.locadora.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.locadora.dao.AluguelDAO;
import br.com.locadora.entidade.Aluguel;

@ManagedBean
@RequestScoped
public class AluguelBean {
	
	private List<Aluguel> alugueis;

	public List<Aluguel> getAlugueis() {
		
		AluguelDAO dao = new AluguelDAO();
		
		alugueis = dao.listar();
		
		return alugueis;
	}


	

}
