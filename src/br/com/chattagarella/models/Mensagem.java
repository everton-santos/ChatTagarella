package br.com.chattagarella.models;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensagem extends UnipeVO {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_destinatario")
	private Usuario destinatario;
	
	@ManyToOne
	@JoinColumn(name="id_remetente")
	private Usuario remetente;
	
	private String texto;
	
	private Date dataHora;
	
	private boolean isVisualizada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public boolean isVisualizada() {
		return isVisualizada;
	}
	public void setVisualizada(boolean isVisualizada) {
		this.isVisualizada = isVisualizada;
	}
	@Override
	@Transient
	public Serializable getIdentificador() {
		return this.id;
	}
}
