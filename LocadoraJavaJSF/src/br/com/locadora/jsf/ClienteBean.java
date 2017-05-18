package br.com.locadora.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.locadora.dao.ClienteDAO;
import br.com.locadora.entidade.Cliente;

@ManagedBean
@RequestScoped
public class ClienteBean {
	
	private List<Cliente> clientes;

	public List<Cliente> getClientes() {

		ClienteDAO dao = new ClienteDAO();
		
		clientes = dao.listar();
		
		return clientes;
	}

	

}
