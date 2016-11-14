package com.gestaoempresarial.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestaoempresarial.model.OrdemServico;
import com.gestaoempresarial.repository.OrdemServicoRepository;

@Stateless
public class OrdemServicoService {

	@Inject
	private OrdemServicoRepository repository;
	
	public void salvar(OrdemServico OrdemServico){
		this.repository.salvar(OrdemServico);
	}
	
	public void remover(OrdemServico OrdemServico){
		this.repository.remover(OrdemServico);
	}
	
	public void remover(Long id){
		this.repository.remover(id);
	}
	
	public OrdemServico buscar(Long id){
		return this.repository.buscar(id);
	}
	
	public List<OrdemServico> listar(){
		return this.repository.listar();
	}
	
}
