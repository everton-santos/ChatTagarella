package br.com.chattagarella.aplicacao;

import java.util.Date;
import java.util.List;

import br.com.chattagarella.aplicacao.exceptions.AplicacaoException;
import br.com.chattagarella.dao.MensagemDao;
import br.com.chattagarella.models.Mensagem;
import br.com.chattagarella.models.Usuario;

public class MensagemAplicacao {
	private MensagemDao dao = new MensagemDao();

	public void salvar(Mensagem mensagem) throws AplicacaoException {
		if (mensagem.getDataHora() == null) {
			mensagem.setDataHora(new Date());
		}
		if (mensagem.getDestinatario() == null) {
			throw new AplicacaoException("Falta destinatario");
		}
		if (mensagem.getRemetente() == null) {
			throw new AplicacaoException("Falta remetente");
		}
		dao.salvar(mensagem);
	}

	public List<Mensagem> listar() {
		return dao.listar();
	}

	public List<Mensagem> consultar(Mensagem mensagem) {
		return dao.consultar(mensagem);
	}

	public List<Mensagem> listarMensagensNaoLidas(Usuario destinatario,
			Usuario remetente) {
		return dao.listarMensagensNaoLidas(destinatario, remetente);
	}

	public List<Mensagem> listarMensagensNaoLidas(Usuario destinatario) {
		return dao.listarMensagensNaoLidas(destinatario);
	}

	public int getQuantidadeMensagensNaoLidas(Usuario destinatario) {
		return dao.getQuantidadeMensagensNaoLidas(destinatario);
	}

	public void remover(Mensagem mensagem) {
		dao.remover(mensagem);
	}
}
