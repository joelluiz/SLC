package com.digital.test;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Test;

import com.digital.dao.PaginaDao;
import com.digital.model.Pagina;
import com.digital.service.PaginaService;

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/digital/resources/applicationContext.xml" })
public class PaginaTest extends TestCase {

	@Autowired
	private PaginaDao paginaDao;
	private PaginaService paginaService;

	@Test
	@Transactional
	public void testTeste() {
		assertTrue(true);

		Pagina pagina = new Pagina();
		pagina.setNome("Junit3");
		pagina.setPagina("Rollback3");

		
//		paginaDao.salvar(pagina);
		paginaService.salvar(pagina);

	}


}
