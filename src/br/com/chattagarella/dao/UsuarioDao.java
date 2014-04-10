package br.com.chattagarella.dao;

import javax.persistence.Query;

import br.com.chattagarella.models.Usuario;

public class UsuarioDao extends GenericDAO<Usuario> {

	public Usuario getPorLoginSenha(Usuario usuario) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager
				.createQuery(String
						.format("select u from %s u where UPPER(u.loginName) = UPPER('%s') and u.loginPass = '%s'",
								usuario.getClass().getName(),
								usuario.getLoginName(), usuario.getLoginPass()));

		return (Usuario) query.getSingleResult();
	}

	@Override
	protected Class getEntityClass() {
		return Usuario.class;
	}
}
