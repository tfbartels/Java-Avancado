package br.com.locadora.struts;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.entidade.Veiculo;

public class VeiculosAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			ServletRequest request, ServletResponse response) throws Exception {

		VeiculoDAO dao = new VeiculoDAO();
		
		List<Veiculo> listaVeiculos =  dao.listar();
		
		request.setAttribute("listaVeiculos", listaVeiculos);
		
		return mapping.findForward("success"); 
	}

}
