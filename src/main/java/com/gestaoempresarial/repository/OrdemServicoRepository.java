package com.gestaoempresarial.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestaoempresarial.model.OrdemServico;

public class OrdemServicoRepository {

	@Inject
	private EntityManager manager;
	
	public void salvar(OrdemServico OrdemServico){
		manager.merge(OrdemServico);
	}
	
	public void remover(OrdemServico OrdemServico){
		manager.remove(OrdemServico);
	}
	
	public void remover(Long id){
		manager.remove(manager.find(OrdemServico.class, id));
	}
	
	public OrdemServico buscar(Long id){
		return manager.find(OrdemServico.class, id);
	}
	
	public List<OrdemServico> listar(){
		return manager.createQuery("select p from OrdemServico p", OrdemServico.class).getResultList();
	}
}