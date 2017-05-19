package br.gov.treinamento.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.treinamento.beans.Agenda;

public class AgendaDAO extends DAO {

	public void salvar(Agenda cliente) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.persist(cliente);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> listar() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(a) from Agenda as a JOIN FETCH a.pessoa");

			return (List<Agenda>) q.getResultList();
		} finally {
			em.close();
		}
	}
}
