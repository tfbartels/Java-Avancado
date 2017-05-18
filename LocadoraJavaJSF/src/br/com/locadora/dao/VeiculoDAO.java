package br.com.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






import javax.naming.NamingException;

import br.com.locadora.entidade.Veiculo;
import br.com.locadora.bd.ConnectionFactory;

public class VeiculoDAO {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	
	public Veiculo buscar(int id) {
		
		Veiculo veiculo = null;
		
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "select id, qtde_lugares, placa, marca "
						 + "from treinamento_veiculo "
						 + "where id = ? ";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				veiculo = new Veiculo(rs.getInt("ID"), 
									   rs.getInt("QTDE_LUGARES"), 
									   rs.getString("PLACA"), 
									   rs.getString("MARCA"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}

		return veiculo;
	}
	
	public List<Veiculo> listar() {

		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		try {
			connection = new ConnectionFactory().getConnection();

			String query = "select id, qtde_lugares, placa, marca "
						 + "from treinamento_veiculo";

			stmt = connection.prepareStatement(query);		
			rs = stmt.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo(rs.getInt("ID"), 
									    	  rs.getInt("QTDE_LUGARES"), 
									    	  rs.getString("PLACA"), 
									    	  rs.getString("MARCA"));
				veiculos.add(veiculo);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}

		return veiculos;
	}
	
	
	public void adicionar(Veiculo veiculo){
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "insert into treinamento_veiculo (id, qtde_lugares, placa, marca) "
						+  "values (?,?,?,?) ";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, veiculo.getId());
			stmt.setInt(2, veiculo.getQtdeLugares());
			stmt.setString(3, veiculo.getPlaca());
			stmt.setString(4, veiculo.getMarca());
			stmt.executeQuery();

			
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}

	}
	
	public void remover(Veiculo veiculo){
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "delete from treinamento_veiculo "
						 + " where id = ? ";
						 						
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, veiculo.getId());			
			stmt.executeQuery();

			
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}

	}
	
}
