package com.digital.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface Dao<E> {

	DetachedCriteria detachedCriteria = DetachedCriteria
			.forClass(Object.class);
	
	E obter (String id,E o);
	E obter (Long id,E o);
	void salvar(E o);
	Boolean excluir (E o);
	List<E> listar(E o);
	void salvarUpdate(E o);
	void atualizar(E o);
	List<E> findByHql(String hql);
	Long lastId(E o);
}
