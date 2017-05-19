package br.gov.treinamento.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "produto_id_produto_seq", sequenceName = "produto_id_produto_seq", allocationSize = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = -8121617132071401241L;

	@Id
	@GeneratedValue(generator = "produto_id_produto_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_produto")
	private Integer idProduto;

	// relacionamento com categoria
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	@Column(name = "nm_produto")
	private String nomeProduto;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "valor")
	private Double valor;
	
	public Categoria getCategory() {
		return categoria;
	}
	
	public void setCategory(Categoria category) {
		this.categoria = category;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}