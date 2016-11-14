package com.gestaoempresarial.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestaoempresarial.model.Venda;

public class VendaRepository {

	@Inject
	private EntityManager manager;
	
	public void salvar(Venda venda){
		manager.merge(venda);
	}
	
	public void remover(Venda venda){
		manager.remove(venda);
	}
	
	public void remover(Long id){
		manager.remove(manager.find(Venda.class, id));
	}
	
	public Venda buscar(Long id){
		return manager.find(Venda.class, id);
	}
	
	public List<Venda> listar(){
		return manager.createQuery("select p from venda p", Venda.class).getResultList();
	}
}