package br.com.chattagarella.aplicacao;

import java.util.List;

import br.com.chattagarella.dao.UsuarioDao;
import br.com.chattagarella.models.Usuario;

public class UsuarioAplicacao {

	private UsuarioDao dao = new UsuarioDao();

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public List<Usuario> listar() {
		return dao.listar();
	}

	public List<Usuario> consultar(Usuario usuario) {
		return dao.consultar(usuario);
	}

	public void remover(Usuario usuario) {
		dao.remover(usuario);
	}

	public Usuario getPorLoginSenha(Usuario usuario) {
		return dao.getPorLoginSenha(usuario);
	}
}
