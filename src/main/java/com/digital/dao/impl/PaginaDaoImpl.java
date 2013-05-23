package com.digital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digital.dao.DaoModel;
import com.digital.dao.PaginaDao;
import com.digital.model.Pagina;

@Transactional
@Repository("paginaDao")
public class PaginaDaoImpl extends DaoModel<Pagina> implements PaginaDao{

}
