package com.gestaoempresarial.model;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "tbl_cliente", catalog = "gestao_empresarial")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cliente_id", unique = true, nullable = false)
	private Long clienteId;
	
	@Column(name = "cliente_nome", nullable = false, length = 100)
	private String clienteNome;
	
	@Column(name = "cliente_cpf", unique = true, nullable = false, length = 45)
	private String clienteCpf;
	
	@Column(name = "cliente_rg", unique = true, nullable = false, length = 45)
	private String clienteRg;
	
	@Column(name = "cliente_email", nullable = false, length = 100)
	private String clienteEmail;
	
	@Column(name = "cliente_telefone", nullable = false, length = 20)
	private String clienteTelefone;
	
	@Column(name = "cliente_endereco", nullable = false, length = 150)
	private String clienteEndereco;
	
	@Column(name = "cliente_cep", nullable = false, length = 45)
	private String clienteCep;
	
	@Column(name = "cliente_descricao", nullable = false, length = 45)
	private String clienteDescricao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_cliente_ordemservico", catalog = "gestao_empresarial", joinColumns = {
			@JoinColumn(name = "tbl_cliente_cliente_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "tbl_ordemservico_ordemservico_id", nullable = false, updatable = false) 
	})
	private Collection<OrdemServico> ordemServicos = new HashSet<OrdemServico>(0);

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	public String getClienteRg() {
		return clienteRg;
	}

	public void setClienteRg(String clienteRg) {
		this.clienteRg = clienteRg;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	public String getClienteEndereco() {
		return clienteEndereco;
	}

	public void setClienteEndereco(String clienteEndereco) {
		this.clienteEndereco = clienteEndereco;
	}

	public String getClienteCep() {
		return clienteCep;
	}

	public void setClienteCep(String clienteCep) {
		this.clienteCep = clienteCep;
	}

	public String getClienteDescricao() {
		return clienteDescricao;
	}

	public void setClienteDescricao(String clienteDescricao) {
		this.clienteDescricao = clienteDescricao;
	}

	public Collection<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setTblOrdemservicos(Collection<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

}
