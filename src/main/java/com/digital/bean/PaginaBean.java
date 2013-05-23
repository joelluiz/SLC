package com.digital.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.digital.model.Pagina;
import com.digital.service.PaginaService;

public class PaginaBean {

	
	private Pagina pagina;
	@Autowired
	private PaginaService paginaService;
	
	
	public void salvar(){
		paginaService.salvar(pagina);
	}

	public Pagina getPagina() {
		if(pagina == null){
			pagina = new Pagina();
		}
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	
}
