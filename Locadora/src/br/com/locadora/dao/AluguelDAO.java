package br.com.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.bd.ConnectionFactory;
import br.com.locadora.entidade.Aluguel;
import br.com.locadora.entidade.Cliente;
import br.com.locadora.entidade.Veiculo;

public class AluguelDAO {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Aluguel> listar() {

		List<Aluguel> alugueis = new ArrayList<Aluguel>();

		try {
			connection = new ConnectionFactory().getConnection();

			String query = "select id, id_veiculo, id_cliente, data_ini, data_fim, preco "
					+ "from treinamento_aluguel ";

			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {

				VeiculoDAO vd = new VeiculoDAO();
				Veiculo veiculo = vd.buscar(rs.getInt("ID_VEICULO"));

				ClienteDAO cd = new ClienteDAO();
				Cliente cliente = cd.buscar(rs.getInt("ID_CLIENTE"));

				Aluguel aluguel = new Aluguel(rs.getInt("ID"), veiculo,
											  cliente, rs.getDate("DATA_INI"),
											  rs.getDate("DATA_FIM"), rs.getDouble("PRECO"));

				alugueis.add(aluguel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return alugueis;
	}

	public void adicionar(Aluguel aluguel) {
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "insert into treinamento_aluguel (id, id_cliente, id_veiculo, data_ini, data_fim, preco) "
					     + "values (?,?,?,?,?,?) ";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, aluguel.getId());
			stmt.setInt(2, aluguel.getCliente().getId());
			stmt.setInt(3, aluguel.getVeiculo().getId());
			stmt.setDate(4, aluguel.getDataInicio());
			stmt.setDate(5, aluguel.getDataFim());
			stmt.setDouble(6, aluguel.getPreco());
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void remover(Aluguel aluguel) {
		try {
			connection = new ConnectionFactory().getConnection();

			String query = "delete from treinamento_aluguel "
					+ " where id = ? ";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, aluguel.getId());
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
