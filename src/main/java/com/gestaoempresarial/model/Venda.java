package com.gestaoempresarial.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_venda", catalog = "gestao_empresarial")
public class Venda implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "venda_id", unique = true, nullable = false)
	private Long vendaId;
	
	@Column(name = "venda_descricao", nullable = false, length = 45)
	private String vendaDescricao;
	
	@Column(name = "venda_valor", nullable = false, precision = 5)
	private BigDecimal vendaValor;
	
	@Column(name = "venda_quantidade", nullable = false)
	private int vendaQuantidade;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_produto_venda", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_venda_venda_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_produto_produto_id", nullable = false, updatable = false) 
	})
	private Collection<Produto> produtos = new HashSet<Produto>(0);

	public Long getVendaId() {
		return vendaId;
	}

	public void setVendaId(Long vendaId) {
		this.vendaId = vendaId;
	}

	public String getVendaDescricao() {
		return vendaDescricao;
	}

	public void setVendaDescricao(String vendaDescricao) {
		this.vendaDescricao = vendaDescricao;
	}

	public BigDecimal getVendaValor() {
		return vendaValor;
	}

	public void setVendaValor(BigDecimal vendaValor) {
		this.vendaValor = vendaValor;
	}

	public int getVendaQuantidade() {
		return vendaQuantidade;
	}

	public void setVendaQuantidade(int vendaQuantidade) {
		this.vendaQuantidade = vendaQuantidade;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
}
