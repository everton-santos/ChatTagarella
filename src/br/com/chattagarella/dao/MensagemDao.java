package br.com.chattagarella.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.chattagarella.models.Mensagem;

public class MensagemDao extends GenericDAO<Mensagem> {

	private static List<Mensagem> dbMensagens;

	public MensagemDao() {
		if (dbMensagens == null) {
			dbMensagens = new ArrayList<Mensagem>();
		}
	}
	
	

}
