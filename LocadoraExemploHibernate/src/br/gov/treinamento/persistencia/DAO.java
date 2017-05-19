package br.gov.treinamento.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	
	private EntityManagerFactory emf; 
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public DAO() {
		emf = Persistence.createEntityManagerFactory("locadora");
		/*
		 * o nome passado vem do arquivo persistence.xml que contém as configs
		 * para conexão com o BD.
		 */
	}

}
