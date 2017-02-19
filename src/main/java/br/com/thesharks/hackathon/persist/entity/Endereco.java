package br.com.thesharks.hackathon.persist.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cidade;

	private String estado;

	public Endereco() {
		super();
	}

	public Endereco(String cidade, String estado) {
		super();
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
