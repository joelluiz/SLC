package com.digital.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PAGINA")
public class Pagina {

	@Id
	@Column(name="ID")
	@Basic(optional=false)
	@SequenceGenerator(name = "pagina_id", sequenceName = "pagina_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pagina_id")
	private Long id;

	@Column(name="NOME")
	private String nome;

	@Column(name="PAGINA")
	private String pagina;


	public Pagina(){

	}


	public Pagina(Long id, String nome, String pagina) {
		super();
		this.id = id;
		this.setNome(nome);
		this.pagina = pagina;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




}
