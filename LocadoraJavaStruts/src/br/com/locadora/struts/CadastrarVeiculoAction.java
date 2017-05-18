package br.com.locadora.struts;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.locadora.entidade.Veiculo;

public class CadastrarVeiculoAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		CadastrarVeiculoForm cform = new CadastrarVeiculoForm();
		
		Veiculo v = new Veiculo(175, cform.getQtdeLugares(), cform.getPlaca(), cform.getMarca());
		
		return mapping.findForward("Sucesso");
	}

}
