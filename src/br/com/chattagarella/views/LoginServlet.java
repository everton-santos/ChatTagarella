package br.com.chattagarella.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.chattagarella.dao.UsuarioDao;
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



		PrintWriter pw = response.getWriter();



	}

}
