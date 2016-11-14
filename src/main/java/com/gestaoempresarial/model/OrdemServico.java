package com.gestaoempresarial.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_ordemservico", catalog = "gestao_empresarial")
public class OrdemServico implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ordemservico_id", unique = true, nullable = false)
	private Long ordemservicoId;
	
	@Column(name = "ordemservico_descricao", nullable = false, length = 45)
	private String ordemservicoDescricao;
	
	@Column(name = "ordemservico_codigo", nullable = false, length = 45)
	private String ordemservicoCodigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ordemservico_dataInicio", nullable = false, length = 10)
	private Date ordemservicoDataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ordemservico_dataMarcada", nullable = false, length = 10)
	private Date ordemservicoDataMarcada;
	
	@Column(name = "ordemservico_modelo", nullable = false, length = 45)
	private String ordemservicoModelo;
	
	@Column(name = "ordemservico_valor", nullable = false, precision = 5)
	private BigDecimal ordemservicoValor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_ordemservico_produto", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_ordemservico_ordemservico_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_produto_produto_id", nullable = false, updatable = false) 
	})
	private Collection<Produto> produtos = new HashSet<Produto>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_cliente_ordemservico", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_ordemservico_ordemservico_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_cliente_cliente_id", nullable = false, updatable = false) 
	})
	private Collection<Cliente> clientes = new HashSet<Cliente>(0);

	public Long getOrdemservicoId() {
		return ordemservicoId;
	}

	public void setOrdemservicoId(Long ordemservicoId) {
		this.ordemservicoId = ordemservicoId;
	}

	public String getOrdemservicoDescricao() {
		return ordemservicoDescricao;
	}

	public void setOrdemservicoDescricao(String ordemservicoDescricao) {
		this.ordemservicoDescricao = ordemservicoDescricao;
	}

	public String getOrdemservicoCodigo() {
		return ordemservicoCodigo;
	}

	public void setOrdemservicoCodigo(String ordemservicoCodigo) {
		this.ordemservicoCodigo = ordemservicoCodigo;
	}

	public Date getOrdemservicoDataInicio() {
		return ordemservicoDataInicio;
	}

	public void setOrdemservicoDataInicio(Date ordemservicoDataInicio) {
		this.ordemservicoDataInicio = ordemservicoDataInicio;
	}

	public Date getOrdemservicoDataMarcada() {
		return ordemservicoDataMarcada;
	}

	public void setOrdemservicoDataMarcada(Date ordemservicoDataMarcada) {
		this.ordemservicoDataMarcada = ordemservicoDataMarcada;
	}

	public String getOrdemservicoModelo() {
		return ordemservicoModelo;
	}

	public void setOrdemservicoModelo(String ordemservicoModelo) {
		this.ordemservicoModelo = ordemservicoModelo;
	}

	public BigDecimal getOrdemservicoValor() {
		return ordemservicoValor;
	}

	public void setOrdemservicoValor(BigDecimal ordemservicoValor) {
		this.ordemservicoValor = ordemservicoValor;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
}
