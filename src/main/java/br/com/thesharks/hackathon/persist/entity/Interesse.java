package br.com.thesharks.hackathon.persist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interesse")
public class Interesse extends EntidadeAbstrata implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "link")
	private String link;

	@Column(name = "valor_produto", nullable = false)
	private Double valorProduto;

	@Column(name = "valor_parcela", nullable = false)
	private Double valorParcela;

	@Column(name = "numero_de_parcelas", nullable = false)
	private Integer numeroDeParcelas;

	@Column(name = "valor_a_vista", nullable = false)
	private Double valorAVista;

	@Column(name = "juros", nullable = false)
	private Double juros;

	@ManyToOne
	private Usuario usuario;

	public Interesse() {
		super();
	}

	public Interesse(String nome, String link, Double valorProduto, Double valorParcela, Integer numeroDeParcelas,
			Double valorAVista, Double juros, Usuario usuario) {
		super();
		this.nome = nome;
		this.link = link;
		this.valorProduto = valorProduto;
		this.valorParcela = valorParcela;
		this.numeroDeParcelas = numeroDeParcelas;
		this.valorAVista = valorAVista;
		this.juros = juros;
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Double getValorAVista() {
		return valorAVista;
	}

	public void setValorAVista(Double valorAVista) {
		this.valorAVista = valorAVista;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
