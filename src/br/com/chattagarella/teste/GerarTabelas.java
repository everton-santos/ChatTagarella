package br.com.chattagarella.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.chattagarella.models.Usuario;

public class GerarTabelas {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("chattagarella");
		EntityManager manager = factory.createEntityManager();
		
		Usuario user = new Usuario();
		
		user.setLoginName("everton");
		user.setLoginPass("123");
		user.setOnline(false);
		
		manager.persist(user);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		
		factory.close();
		
		
		System.out.println("funcionou!");
	}

}
