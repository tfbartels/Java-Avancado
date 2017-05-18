package br.com.locadora.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.dao.ClienteDAO;
import br.com.locadora.entidade.Cliente;

/**
 * Servlet implementation class CadastrarClienteServlet
 */
@WebServlet("/cadastrarCliente")
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String msg = "";
		
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.adicionar(new Cliente(245, nome, cpf, email));
			msg = "Cliente inserido com sucesso";
		} catch (Exception e) {
			msg = "Erro na execucao: " + e.getMessage();						
			return;
		}
		
		out.println(msg);
		
	}
}
