package br.com.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.entidade.Cliente;

public class ClienteDAO extends DAO {


	public Cliente buscar(int id) {

		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(c) " + "from Cliente as c "
					+ "where c.id = :paramId");
			q.setParameter("paramId", id);

			return (Cliente) q.getResultList();
		} finally {
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {

		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(c) from Cliente as c");

			return (List<Cliente>) q.getResultList();
		} finally {
			em.close();
		}
	}

	public void adicionar(Cliente cliente) {
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
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void remover(Cliente cliente) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.remove(cliente);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

}
