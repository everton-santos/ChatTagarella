package br.com.chattagarella.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.chattagarella.aplicacao.UsuarioAplicacao;
import br.com.chattagarella.models.Usuario;

public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String loginName = request.getParameter("login-name");
		String loginPass = request.getParameter("login-pass");
		
		Usuario usuario = new Usuario();
		usuario.setLoginName(loginName);
		usuario.setLoginPass(loginPass);
		UsuarioAplicacao aplicacao = new UsuarioAplicacao();
		aplicacao.salvar(usuario);
		response.sendRedirect("/ChatTagarella/index.do");
		
	}

}
