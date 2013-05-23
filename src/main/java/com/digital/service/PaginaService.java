package com.digital.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.digital.dao.PaginaDao;
import com.digital.model.Pagina;

public class PaginaService {

	@Autowired
	private PaginaDao paginaDao;
	
	public Long salvar(Pagina pagina){
		paginaDao.salvar(pagina);
		return pagina.getId();
	}

	
	
}
