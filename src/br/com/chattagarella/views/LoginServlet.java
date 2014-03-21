package br.com.chattagarella.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.chattagarella.aplicacao.CoockiesManager;
import br.com.chattagarella.aplicacao.UsuarioAplicacao;
import br.com.chattagarella.models.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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
		usuario = aplicacao.getPorLoginSenha(usuario);

		CoockiesManager.setUserId(response, usuario.getId());
		CoockiesManager.setUserName(response, usuario.getLoginName());
		
		response.sendRedirect("/ChatTagarella/index.do");

	}

}
