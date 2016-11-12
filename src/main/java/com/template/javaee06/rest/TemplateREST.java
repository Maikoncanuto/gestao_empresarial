package com.template.javaee06.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.javaee06.model.Template;
import com.template.javaee06.service.TemplateService;

@Path("/template")
@RequestScoped
public class TemplateREST {
	
		private TemplateService TemplateService = new TemplateService();
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Template> getAgentes() {
	 		return TemplateService.lista();
	    }

	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void salvarAgente(Template agente){
	 		TemplateService.incluir(agente);
	 	}
	 	
	 	@DELETE
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void excluirAgente(Template agente){
	 		TemplateService.remover(agente);
	 	}
	 	
	 	@DELETE
	 	@Path("/{id}")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public String excluirAgente(@PathParam("id") Integer id){
	 		TemplateService.buscar(id);
	 		return new String("REMOVIDO COM SUCESSO");
	 	}
}
