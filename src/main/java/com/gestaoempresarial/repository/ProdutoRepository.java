package com.gestaoempresarial.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestaoempresarial.model.Produto;

public class ProdutoRepository {

	@Inject
	private EntityManager manager;
	
	public void salvar(Produto produto){
		manager.merge(produto);
	}
	
	public void remover(Produto produto){
		manager.remove(produto);
	}
	
	public void remover(Long id){
		manager.remove(manager.find(Produto.class, id));
	}
	
	public Produto buscar(Long id){
		return manager.find(Produto.class, id);
	}
	
	public List<Produto> listar(){
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
}
