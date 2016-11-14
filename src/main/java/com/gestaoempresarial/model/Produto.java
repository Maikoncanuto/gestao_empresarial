package com.gestaoempresarial.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "tbl_produto", catalog = "gestao_empresarial")
public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "produto_id", unique = true, nullable = false)
	private Long produtoId;
	
	@Column(name = "produto_nome", nullable = false, length = 45)
	private String produtoNome;
	
	@Column(name = "produto_fabricante", nullable = false, length = 45)
	private String produtoFabricante;
	
	@Column(name = "produto_valor", nullable = false, precision = 5)
	private BigDecimal produtoValor;
	
	@Column(name = "produto_quantidade", nullable = false)
	private Integer produtoQuantidade;
	
	@Column(name = "produto_descricao", nullable = false, length = 45)
	private String produtoDescricao;
	
	@Column(name = "produto_codigo", nullable = false, length = 45)
	private String produtoCodigo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_ordemservico_produto", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_produto_produto_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_ordemservico_ordemservico_id", nullable = false, updatable = false) 
	})
	private Set<OrdemServico> ordemServicos = new HashSet<OrdemServico>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_produto_venda", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_produto_produto_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_venda_venda_id", nullable = false, updatable = false) 
	})
	private Set<Venda> vendas = new HashSet<Venda>(0);

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public String getProdutoFabricante() {
		return produtoFabricante;
	}

	public void setProdutoFabricante(String produtoFabricante) {
		this.produtoFabricante = produtoFabricante;
	}

	public BigDecimal getProdutoValor() {
		return produtoValor;
	}

	public void setProdutoValor(BigDecimal produtoValor) {
		this.produtoValor = produtoValor;
	}

	public Integer getProdutoQuantidade() {
		return produtoQuantidade;
	}

	public void setProdutoQuantidade(Integer produtoQuantidade) {
		this.produtoQuantidade = produtoQuantidade;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public String getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(String produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public Set<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(Set<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

}
