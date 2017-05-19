package br.com.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.entidade.Veiculo;

public class VeiculoDAO extends DAO {
	
	public Veiculo buscar(int id) {
		
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(v) " 
								   + "from Veiculo as v "
								   + "where v.id = :paramId");
			q.setParameter("paramId", id);

			return (Veiculo) q.getResultList();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() {

		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(v) from Veiculo as v");

			return (List<Veiculo>) q.getResultList();
		} finally {
			em.close();
		}
	}
	
	
	public void adicionar(Veiculo veiculo){
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.persist(veiculo);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}
	
	public void remover(Veiculo veiculo){
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.remove(veiculo);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
}
