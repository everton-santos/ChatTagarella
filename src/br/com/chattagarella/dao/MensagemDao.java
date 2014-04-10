package br.com.chattagarella.dao;
import java.util.List;

import javax.persistence.Query;

import br.com.chattagarella.models.Mensagem;
import br.com.chattagarella.models.Usuario;

public class MensagemDao extends GenericDAO<Mensagem>
{
	public MensagemDao()
	{
	}
	
	public List<Mensagem> listarMensagensNaoLidas(Usuario destinatario, Usuario remetente)
	{
		manager = entityManagerFactory.createEntityManager();
		String sql = String.format("select c from %s c where c.id_destinatario = '%s'", Mensagem.class.getName());
		Query query = manager.createQuery(sql, Mensagem.class);
		return query.getResultList();
	}

	@Override
	protected Class getEntityClass() {
		return Mensagem.class;
	}
}
