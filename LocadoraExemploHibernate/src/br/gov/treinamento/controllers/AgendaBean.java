package br.gov.treinamento.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.treinamento.beans.Agenda;
import br.gov.treinamento.beans.Pessoa;
import br.gov.treinamento.persistencia.AgendaDAO;
import br.gov.treinamento.persistencia.PessoaDAO;


@ManagedBean
@RequestScoped
public class AgendaBean {
	
	private List<Pessoa> pessoas;
	private List<Agenda> contatos;

	public List<Pessoa> getPessoas() {
		PessoaDAO dao = new PessoaDAO();
		return dao.listar();
	}
	
	public List<Agenda> getContatos() {
		contatos = new ArrayList<Agenda>();
		pessoas = new ArrayList<Pessoa>();
		Pessoa p1 = new Pessoa("Frodo Baggins", "90909090987", "O Condado");
		Pessoa p2 = new Pessoa("Luke Skywalker", "10110101101", "Tattoine");
		Pessoa p3 = new Pessoa("Starlord", "22298722265", "Earth");
		
		contatos.add(new Agenda(1, p1, "Condado", "98765432"));
		contatos.add(new Agenda(2, p2, "Tatooine", "87623457"));
		contatos.add(new Agenda(3, p3, "Earth", "98102345"));
		
		AgendaDAO agendaDAO = new AgendaDAO();
		
		return agendaDAO.listar();
	}
	
}
