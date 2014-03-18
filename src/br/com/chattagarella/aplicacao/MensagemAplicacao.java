package br.com.chattagarella.aplicacao;

import java.util.List;

import br.com.chattagarella.dao.MensagemDao;
import br.com.chattagarella.models.Mensagem;

public class MensagemAplicacao {
	private MensagemDao dao = new MensagemDao();

	public void salvar(Mensagem mensagem) {
		dao.salvar(mensagem);
	}

	public List<Mensagem> listar() {
		return dao.listar(new Mensagem());
	}

	public List<Mensagem> consultar(Mensagem mensagem) {
		return dao.consultar(mensagem);
	}

	public void remover(Mensagem mensagem) {
		dao.remover(mensagem);
	}
}
