package br.gov.treinamento.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.gov.treinamento.beans.Agenda;
import br.gov.treinamento.beans.Pessoa;

public class Hibernate5InsertTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Pessoa pessoa = new Pessoa(0, "Peter Quill", "98765432134", "starlord@galaxy.com");
		Agenda agenda = new Agenda(1, pessoa, "Earth", "67543287653");
		
		session.save(pessoa);
		System.out.println(pessoa.getId());
		session.save(agenda);
		tx.commit();
		session.close();
	}
}