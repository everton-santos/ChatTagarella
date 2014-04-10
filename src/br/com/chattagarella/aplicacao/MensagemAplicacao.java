package br.com.chattagarella.aplicacao;
import java.util.Date;
import java.util.List;
import br.com.chattagarella.aplicacao.exceptions.AplicacaoException;
import br.com.chattagarella.dao.MensagemDao;
import br.com.chattagarella.models.Mensagem;

public class MensagemAplicacao
{
	private MensagemDao	dao	= new MensagemDao();
	
	public void salvar(Mensagem mensagem) throws AplicacaoException
	{
		if (mensagem.getDataHora() == null)
		{
			mensagem.setDataHora(new Date());
		}
		if (mensagem.getDestinatario() == null)
		{
			throw new AplicacaoException("Falta destinatario");
		}
		if (mensagem.getRemetente() == null)
		{
			throw new AplicacaoException("Falta remetente");
		}
		dao.salvar(mensagem);
	}
	
	public List<Mensagem> listar()
	{
		return dao.listar();
	}
	
	public List<Mensagem> consultar(Mensagem mensagem)
	{
		return dao.consultar(mensagem);
	}
	
	public void remover(Mensagem mensagem)
	{
		dao.remover(mensagem);
	}
}
