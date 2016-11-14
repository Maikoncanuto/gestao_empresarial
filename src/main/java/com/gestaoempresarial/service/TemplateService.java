package com.gestaoempresarial.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.gestaoempresarial.model.Template;
import com.gestaoempresarial.repository.TemplateRepository;

@Stateless
public class TemplateService {

	@Inject
	private TemplateRepository templateRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Template template) {
		templateRepository.incluir(template);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Template> lista() {
		return templateRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Template buscar(Integer id) {
		return templateRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(Template template){
		this.templateRepository.altera(template);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Template template){
		this.templateRepository.remover(template);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Integer id){
		this.templateRepository.remover(id);
	}
	
}
