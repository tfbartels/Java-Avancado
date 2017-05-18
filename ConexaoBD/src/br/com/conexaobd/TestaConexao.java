package br.com.conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaConexao {

	public static void main(String[] args) {
		
		//EXEMPLO 01
		/*String host = "";
	    String usuario = "" ;
		String senha =	"";	
		
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(host,usuario,senha);
			System.out.println("Conectado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conexao.close();
				System.out.println("Desconectado!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
		//EXEMPLO 02
/*		Connection conexao  = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			ConnectionFactory cf =new ConnectionFactory();
			Connection conexao  = cf.getConnection();
			conexao  = new ConnectionFactory().getConnection();
			System.out.println("Conectado!");
			
			statement = conexao.createStatement();
			
			String query = "Select * from UF";
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("NOME"));
			}			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				statement.close();
				conexao.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}*/
		
		
		//EXEMPLO 03
		Connection conexao  = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conexao  = new ConnectionFactory().getConnection();						
			statement = conexao.createStatement();
			
			String query = "select id_pessoa, nome, telefone from pessoa where nome like 'MARIA%' and rownum <10";
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("NOME"));
				System.out.println(rs.getString("TELEFONE"));
			}			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				statement.close();
				conexao.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
		}

		
	}

}
