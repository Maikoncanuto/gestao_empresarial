package com.template.javaee06.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.template.javaee06.model.Template;
import com.template.javaee06.service.TemplateService;
import com.template.javaee06.util.FacesUtil;


@Named("templateMB")
@SessionScoped
public class TemplateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Template template;
	
	@Inject
	private TemplateService templateService;


	public void incluir() {
		try {
			templateService.incluir(template);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (RuntimeException e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.template = new Template();
	}

	//Metodos Getters and Setters
	public Template gettemplate() {
		return template;
	}

	public void settemplate(Template template) {
		this.template = template;
	}

	public List<Template> templates(){
		return templateService.lista();
	}
	
	public void excluir(){
		templateService.remover(template);
	}
	
}
