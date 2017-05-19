package br.gov.treinamento.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.treinamento.beans.Pessoa;

public class PessoaDAO extends DAO {

	public void salvar(Pessoa pessoa) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		pessoa.setId(null);
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.persist(pessoa);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			e.printStackTrace();
			em.getTransaction().rollback();
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(p) from Pessoa as p");

			return (List<Pessoa>) q.getResultList();
		} finally {
			em.close();
		}
	}

}
