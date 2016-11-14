package com.gestaoempresarial.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestaoempresarial.model.Produto;
import com.gestaoempresarial.repository.ProdutoRepository;

@Stateless
public class ProdutoService {

	@Inject
	private ProdutoRepository repository;
	
	public void salvar(Produto produto){
		this.repository.salvar(produto);
	}
	
	public void remover(Produto produto){
		this.repository.remover(produto);
	}
	
	public void remover(Long id){
		this.repository.remover(id);
	}
	
	public Produto buscar(Long id){
		return this.repository.buscar(id);
	}
	
	public List<Produto> listar(){
		return this.repository.listar();
	}
	
}
