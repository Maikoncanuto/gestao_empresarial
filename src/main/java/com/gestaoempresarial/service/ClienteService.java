package com.gestaoempresarial.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestaoempresarial.model.Cliente;
import com.gestaoempresarial.repository.ClienteRepository;

@Stateless
public class ClienteService {

	@Inject
	private ClienteRepository repository;
	
	public void salvar(Cliente Cliente){
		this.repository.salvar(Cliente);
	}
	
	public void remover(Cliente Cliente){
		this.repository.remover(Cliente);
	}
	
	public void remover(Long id){
		this.repository.remover(id);
	}
	
	public Cliente buscar(Long id){
		return this.repository.buscar(id);
	}
	
	public List<Cliente> listar(){
		return this.repository.listar();
	}
	
}
