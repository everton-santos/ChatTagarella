package br.com.chattagarella.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.chattagarella.aplicacao.CoockiesManager;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (CoockiesManager.getUserId(request) > 0) {
			response.sendRedirect("ChatTagarella/mensagens.do");
		} else {
			response.sendRedirect("/ChatTagarella/login.html");
		}

	}

}
