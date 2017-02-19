package br.com.thesharks.hackathon.persist.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.thesharks.hackathon.persist.entity.enums.TipoRepasseEnum;

@Entity
@Table(name = "interesse")
public class Interesse extends EntidadeAbstrata implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String link;

	@Enumerated(EnumType.STRING)
	private TipoRepasseEnum tipoInteresse;

	@Column(nullable = false)
	private Double valorDoInteresse;

	private Double valorDaParcela;

	private BigDecimal valorDoRepasse;

	private Integer quantidadeDeParcelas;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	public Interesse() {
		super();
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

	public TipoRepasseEnum getTipoInteresse() {
		return tipoInteresse;
	}

	public void setTipoInteresse(TipoRepasseEnum tipoInteresse) {
		this.tipoInteresse = tipoInteresse;
	}

	public Double getValorDoInteresse() {
		return valorDoInteresse;
	}

	public void setValorDoInteresse(Double valorDoInteresse) {
		this.valorDoInteresse = valorDoInteresse;
	}

	public Double getValorDaParcela() {
		return valorDaParcela;
	}

	public void setValorDaParcela(Double valorDaParcela) {
		this.valorDaParcela = valorDaParcela;
	}

	public BigDecimal getValorDoRepasse() {
		return valorDoRepasse;
	}

	public void setValorDoRepasse(BigDecimal valorDoRepasse) {
		this.valorDoRepasse = valorDoRepasse;
	}

	public Integer getQuantidadeDeParcelas() {
		return quantidadeDeParcelas;
	}

	public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
		this.quantidadeDeParcelas = quantidadeDeParcelas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
