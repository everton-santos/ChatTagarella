package br.com.chattagarella.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.chattagarella.models.Usuario;


@ManagedBean
@SessionScoped
public class UsuarioMB {
	
	
	private Usuario usuario = new Usuario();
	
	private String palavra;

	
	public String carregar(){
		palavra += "meu primeiro managedBean";
		return "principal";
	}
	
	
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
