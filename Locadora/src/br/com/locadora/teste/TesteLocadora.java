package br.com.locadora.teste;
import java.sql.Date;
import java.util.Calendar;

import br.com.locadora.dao.AluguelDAO;
import br.com.locadora.dao.ClienteDAO;
import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.entidade.Aluguel;
import br.com.locadora.entidade.Cliente;
import br.com.locadora.entidade.Veiculo;


public class TesteLocadora {

	public static void main(String[] args) {
		
		ClienteDAO cd = new ClienteDAO();	
		VeiculoDAO vd = new VeiculoDAO();
		Cliente c1 = cd.buscar(25);									
		Veiculo v1 = vd.buscar(99);
		
		
		Aluguel a1 = new Aluguel(15,v1,c1, new Date(Calendar.getInstance().getTimeInMillis()),
								 new Date(Calendar.getInstance().getTimeInMillis()),1547);
		
		AluguelDAO ad = new AluguelDAO();		
		
		//ad.adicionar(a1);
		
		for (Aluguel a : ad.listar()){
			System.out.println(a.getId() + " - " +a.getCliente().getNome()+ " - " + a.getVeiculo().getMarca());
		}
	
		
		
		
		
	}

}
