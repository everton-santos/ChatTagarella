package br.com.chattagarella.teste;
import br.com.chattagarella.aplicacao.MensagemAplicacao;
import br.com.chattagarella.aplicacao.UsuarioAplicacao;
import br.com.chattagarella.aplicacao.exceptions.AplicacaoException;
import br.com.chattagarella.models.Mensagem;
import br.com.chattagarella.models.Usuario;

public class GerarTabelas
{
	public static void main(String[] args)
	{
		Usuario remetente = new Usuario();
		remetente.setLoginName("everton");
		remetente.setLoginPass("123");
		remetente.setOnline(true);
		Usuario destinatario = new Usuario();
		destinatario.setLoginName("destinatario");
		destinatario.setLoginPass("123");
		destinatario.setOnline(true);
		UsuarioAplicacao userApp = new UsuarioAplicacao();
		userApp.salvar(destinatario);
		userApp.salvar(remetente);
		Mensagem msg = new Mensagem();
		msg.setDestinatario(destinatario);
		msg.setRemetente(remetente);
		msg.setTexto("Ola!");
		MensagemAplicacao msgApp = new MensagemAplicacao();
		try
		{
			msgApp.salvar(msg);
		} catch (AplicacaoException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("funcionou!");
	}
}
