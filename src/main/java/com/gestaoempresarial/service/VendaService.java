package com.gestaoempresarial.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestaoempresarial.model.Venda;
import com.gestaoempresarial.repository.VendaRepository;

@Stateless
public class VendaService {

	@Inject
	private VendaRepository repository;
	
	public void salvar(Venda Venda){
		this.repository.salvar(Venda);
	}
	
	public void remover(Venda Venda){
		this.repository.remover(Venda);
	}
	
	public void remover(Long id){
		this.repository.remover(id);
	}
	
	public Venda buscar(Long id){
		return this.repository.buscar(id);
	}
	
	public List<Venda> listar(){
		return this.repository.listar();
	}
	
}
