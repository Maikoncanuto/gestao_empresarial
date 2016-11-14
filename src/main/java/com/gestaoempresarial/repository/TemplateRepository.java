package com.gestaoempresarial.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestaoempresarial.model.Template;

public class TemplateRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Template template) {
		this.manager.persist(template);
	}	

	public void altera(Template template) {
		this.manager.merge(template);
	}

	public Template busca(Integer id) {
		return this.manager.find(Template.class, id);
	}

	public List<Template> lista() {
		return this.manager.createQuery("select a from template a", Template.class).getResultList();
	}
	
	public void remover(Template template){
		manager.remove(template);
	}
	
	public void remover(Integer id){
		manager.remove(this.busca(id));
	}
}
