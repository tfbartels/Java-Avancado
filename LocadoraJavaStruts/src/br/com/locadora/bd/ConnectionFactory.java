package br.com.locadora.bd;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class ConnectionFactory {


	private Connection conexao;

	public Connection getConnection() throws SQLException, NamingException {

		try {			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/treinamento");
			conexao = ds.getConnection();		
			return conexao;
		} catch (SQLException e) {			
			throw e;
		} catch (NamingException e) {			
			throw e;
		}

	}

	public void closeConnection() throws SQLException {
		if (this.conexao != null){
			this.conexao.close();
		}
	}

}
