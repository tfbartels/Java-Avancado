package br.com.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.entidade.Aluguel;

public class AluguelDAO extends DAO {


	@SuppressWarnings("unchecked")
	public List<Aluguel> listar() {

		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(a) from Aluguel as a JOIN FETCH a.cliente JOIN FETCH a.veiculo");

			return (List<Aluguel>) q.getResultList();
		} finally {
			em.close();
		}
	}

	public void adicionar(Aluguel aluguel) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.persist(aluguel);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void remover(Aluguel aluguel) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.remove(aluguel);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

}
