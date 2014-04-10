package br.com.chattagarella.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.chattagarella.models.UnipeVO;

public abstract class GenericDAO<T extends UnipeVO> {

	protected static EntityManagerFactory entityManagerFactory;
	protected EntityManager manager;

	protected abstract Class getEntityClass();
	
	public GenericDAO() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("chattagarella");
		}
	}

	public void salvar(T obj) {

		T retorno = null;
		try {
			retorno = consultar(obj).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (retorno != null) {
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

		List<T> lista = null;

		manager = entityManagerFactory.createEntityManager();

		Serializable id = obj.getIdentificador();

		if (id != null) {
			lista = (List<T>) manager.find(obj.getClass(),
					obj.getIdentificador());
		}

		manager.close();
		return lista;
	}

	public List<T> listar() {
		manager = entityManagerFactory.createEntityManager();
		
		Query query = manager.createQuery(
				String.format("select c from %s c",getEntityClass().getName()),
				getEntityClass());
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
