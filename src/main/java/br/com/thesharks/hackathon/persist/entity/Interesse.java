package br.com.thesharks.hackathon.persist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "interesse")
public class Interesse extends EntidadeAbstrata implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "link")
	private String link;

	@Column(name = "tipo_interesse")
	private String tipoInteresse;

	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;

	@Column(name = "valor_parcela")
	private Double valorParcela;

	@Column(name = "numero_de_parcelas")
	private Integer numeroDeParcelas;

	@Column(name = "valor_a_vista")
	private Double valorAVista;

	@Column(name = "juros")
	private Double juros;

	@ManyToOne
	private Usuario usuario;

	public Interesse() {
		super();
	}

	public Interesse(String nome, String link, Double valorTotal, Double valorParcela, Integer numeroDeParcelas,
			Double valorAVista, Double juros, Usuario usuario) {
		super();
		this.nome = nome;
		this.link = link;
		this.valorTotal = valorTotal;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();

		System.out.println(om.writeValueAsString(new Interesse()));
	}

	public String getTipoInteresse() {
		return tipoInteresse;
	}

	public void setTipoInteresse(String tipoInteresse) {
		this.tipoInteresse = tipoInteresse;
	}

}
