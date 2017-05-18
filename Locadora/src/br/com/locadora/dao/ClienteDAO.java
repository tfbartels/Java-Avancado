package br.com.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.bd.ConnectionFactory;
import br.com.locadora.entidade.Cliente;

public class ClienteDAO {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	
	public Cliente buscar(int id) {

		Cliente cliente = null;
		
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "select id, nome, cpf, email "
						 + "from treinamento_cliente "
						 + "where id = ? ";
			

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente(rs.getInt("ID"),
				                	  rs.getString("NOME"),
				                	  rs.getString("CPF"), 
				                	  rs.getString("EMAIL"));				
			}
		} catch (SQLException e) {			
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

		return cliente;
	}
	
	public List<Cliente> listar() {

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			connection = new ConnectionFactory().getConnection();

			String query = "select id, nome, cpf, email from treinamento_cliente ";

			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("ID"),
								              rs.getString("NOME"),
											  rs.getString("CPF"), 
											  rs.getString("EMAIL"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {			
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

		return clientes;
	}
	
	
	public void adicionar(Cliente cliente){
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "insert into treinamento_cliente (id, nome, cpf, email) "
						+  "values (?,?,?,?) ";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.executeQuery();

			
		} catch (SQLException e) {			
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
	
	public void remover(Cliente cliente){
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "delete from treinamento_cliente "
						 + " where id = ? ";
						 						
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, cliente.getId());			
			stmt.executeQuery();

			
		} catch (SQLException e) {			
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
