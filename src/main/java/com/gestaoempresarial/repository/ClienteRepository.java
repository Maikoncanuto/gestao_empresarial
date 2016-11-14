package com.gestaoempresarial.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestaoempresarial.model.Cliente;

public class ClienteRepository {

	@Inject
	private EntityManager manager;
	
	public void salvar(Cliente Cliente){
		manager.merge(Cliente);
	}
	
	public void remover(Cliente Cliente){
		manager.remove(Cliente);
	}
	
	public void remover(Long id){
		manager.remove(manager.find(Cliente.class, id));
	}
	
	public Cliente buscar(Long id){
		return manager.find(Cliente.class, id);
	}
	
	public List<Cliente> listar(){
		return manager.createQuery("select p from Cliente p", Cliente.class).getResultList();
	}
}