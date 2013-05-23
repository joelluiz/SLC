package com.digital.dao;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.component.log.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class DaoModel<Object> extends HibernateDaoSupport implements
		Dao<Object> {

	public Object obter(String id, Object o) {
		return ((Object) getHibernateTemplate().get(o.getClass(), id));
	}

	public Object obter(Long id, Object o) {
		return ((Object) getHibernateTemplate().get(o.getClass(), id));
	}

	@Transactional(readOnly=false)
	public void salvar(Object o) {
		getHibernateTemplate().save(o);
		getHibernateTemplate().flush();
	}

	
	public Boolean excluir(Object o) {
		try {
			Class<?> classe = o.getClass(); // Pega a classe do objeto
			String mensagem = "O(A) " + o.getClass().getSimpleName();
			Method metodo = null;
			List<String> metodos = new ArrayList<String>();
			for (Method m : classe.getMethods()) {
				metodos.add(m.getName());
			}
			if (metodos.contains("getTitulo")) {
				mensagem += " com o título "
						+ classe.getMethod("getTitulo").invoke(o);
			} else if (metodos.contains("getEndereco")) {
				mensagem += " com o endereço "
						+ classe.getMethod("getEndereco").invoke(o);
			} else if (metodos.contains("getLogin")) {
				mensagem += " com o login "
						+ classe.getMethod("getLogin").invoke(o);
			}
//			Usuario usuario = null;
//			if (FacesContext.getCurrentInstance() != null) {
//				HttpSession session = (HttpSession) FacesContext
//						.getCurrentInstance().getExternalContext()
//						.getSession(false);
//				usuario = (Usuario) session.getAttribute("usuario");
//			}
			String id = "";
			if (metodos.contains("getId")) {
				id = " com id: " + classe.getMethod("getId").invoke(o);
			}
//			Object obj = (Object) new Log(
//					new SimpleDateFormat("HH:mm").format(new Date()), mensagem
//							+ id + " foi excluído.", new Date(), o.getClass()
//							.getSimpleName(), usuario);
//			getHibernateTemplate().saveOrUpdate(obj);
			getHibernateTemplate().delete(o);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	
	public List<Object> listar(Object o) {
		List<Object> list = (List<Object>) getHibernateTemplate().loadAll(
				o.getClass());
		if (list == null) {
			return new ArrayList<Object>();
		}
		return list;
	}

	
	public void salvarUpdate(Object o) {
		try {
			Class<?> classe = o.getClass(); // Pega a classe do objeto
			String mensagem = "O(A) " + o.getClass().getSimpleName();
			Method metodo = null;
			List<String> metodos = new ArrayList<String>();
			for (Method m : classe.getMethods()) {
				metodos.add(m.getName());
			}
			if (metodos.contains("getTitulo")) {
				mensagem += " com o título "
						+ classe.getMethod("getTitulo").invoke(o);
			} else if (metodos.contains("getEndereco")) {
				mensagem += " com o endereço "
						+ classe.getMethod("getEndereco").invoke(o);
			} else if (metodos.contains("getLogin")) {
				mensagem += " com o login "
						+ classe.getMethod("getLogin").invoke(o);
			}
//			Usuario usuario = null;
//			if (FacesContext.getCurrentInstance() != null) {
//				HttpSession session = (HttpSession) FacesContext
//						.getCurrentInstance().getExternalContext()
//						.getSession(false);
//				usuario = (Usuario) session.getAttribute("usuario");
//			}
			String interacao = "";
			if (metodos.contains("getId")) {
				if (classe.getMethod("getId").invoke(o) == null) {
					interacao = " foi cadastrado(a)";
				} else {
					interacao = " foi alterado(a)";
				}
			}
			getHibernateTemplate().saveOrUpdate(o);
			interacao += !interacao.isEmpty() ? " com id: "
					+ classe.getMethod("getId").invoke(o) : "";
//			Object obj = (Object) new Log(
//					new SimpleDateFormat("HH:mm").format(new Date()), mensagem
//							+ interacao, new Date(), o.getClass()
//							.getSimpleName(), usuario);
//			getHibernateTemplate().saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getHibernateTemplate().saveOrUpdate(o);
	}

	
	public void atualizar(Object o) {
		getHibernateTemplate().update(o);
	}

	
	public List<Object> findByHql(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public Long lastId(Object o) {
		String hql = "select max(i.id) from " + o.getClass().getName() + " i";
		List<Long> v = getHibernateTemplate().find(hql);
		return v.get(0) == null ? 0 : v.get(0);
	};

}
