package br.gov.treinamento.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "categoria_id_categoria_seq", sequenceName = "categoria_id_categoria_seq", allocationSize = 1)
public class Categoria implements Serializable {

	private static final long serialVersionUID = -8765631845563878481L;

	@Id
	@GeneratedValue(generator = "categoria_id_categoria_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_categoria")
	private Long idCategoria;

	@Column(name = "nome", nullable = false)
	private String nome;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> listaProdutos;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "fg_ativo")
	private Boolean ativo;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
