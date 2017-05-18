package br.com.locadora.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String host = "";
	private String usuario = "";
	private String senha = "";

	private Connection conexao;

	public Connection getConnection() throws SQLException {

		try {
			conexao = DriverManager.getConnection(host, usuario, senha);
			return conexao;
		} catch (SQLException e) {			
			throw e;
		}

	}

	public void closeConnection() throws SQLException {
		if (this.conexao != null){
			this.conexao.close();
		}
	}

}
