package br.com.chattagarella.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.chattagarella.models.UnipeVO;

public abstract class GenericDAO<T extends UnipeVO> {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager manager;

	public GenericDAO() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("chattagarella");
		}
	}

	public void salvar(T obj) {
		if (consultar(obj).size() > 0) {
			alterar(obj);
		} else {
			incluir(obj);
		}
	}

	protected void incluir(T obj) {
		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		manager.close();
	}

	public void remover(T obj) {
		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.detach(obj);
		manager.getTransaction().commit();
		manager.close();
	}

	public List<T> consultar(T obj) {
		manager = entityManagerFactory.createEntityManager();
		List<T> lista = (List<T>) manager.find(obj.getClass(),
				obj.getIdentificador());
		manager.close();
		return lista;
	}

	public List<T> listar(T obj) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(
				String.format("select c from %s c", obj.getClass().getName()),
				obj.getClass());
		return query.getResultList();
	}

	protected void alterar(T obj) {
		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		manager.close();
	}
}
