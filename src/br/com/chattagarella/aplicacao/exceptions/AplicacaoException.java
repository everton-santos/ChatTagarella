package br.com.chattagarella.aplicacao.exceptions;
public class AplicacaoException extends Exception
{
	private String	mensagemUsuario;
	private String	mensagemLog;
	
	public AplicacaoException(String mensagemUsuario)
	{
		this.mensagemUsuario = mensagemUsuario;
	}
	
	public AplicacaoException(String mensagemUsuario, String mensagemLog)
	{
		this.mensagemLog = mensagemLog;
		this.mensagemUsuario = mensagemUsuario;
	}
	
	public String getMensagemUsuario()
	{
		return mensagemUsuario;
	}
	
	public void setMensagemUsuario(String mensagemUsuario)
	{
		this.mensagemUsuario = mensagemUsuario;
	}
	
	public String getMensagemLog()
	{
		return mensagemLog;
	}
	
	public void setMensagemLog(String mensagemLog)
	{
		this.mensagemLog = mensagemLog;
	}
}
