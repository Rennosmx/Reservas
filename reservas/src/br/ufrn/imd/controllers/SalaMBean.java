package br.ufrn.imd.controllers;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.ufrn.imd.controllers.UsuarioMBean;
import br.ufrn.imd.dao.SalaDao;
import br.ufrn.imd.dominio.Sala;

@ManagedBean
@SessionScoped
public class SalaMBean {

	private Sala sala;
	
	private DataModel<Sala> salasModel;
	
	@ManagedProperty(value="#{usuarioMBean}")
	private UsuarioMBean usuarioMBean;
	
	@Inject
	private SalaDao salaDao;
	
	public SalaMBean() {
		sala = new Sala();
	}
	
	public String novaSala() {
		sala = new Sala();
		return "/pages/sala/form.jsf";
	}
	
	public String listarSala() {
		salasModel = new ListDataModel<Sala>(salaDao.listar());
		return "/pages/sala/list.jsf";
	}
	
	public String removerSala() {
		Sala salaRemovido = salasModel.getRowData();
		salaDao.remover(salaRemovido);
		salasModel = new ListDataModel<Sala>(salaDao.listar());
		return "/pages/sala/list.jsf";
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public DataModel<Sala> getSalasModel() {
		return salasModel;
	}

	public void setSalasModel(DataModel<Sala> salasModel) {
		this.salasModel = salasModel;
	}

	public UsuarioMBean getUsuarioMBean() {
		return usuarioMBean;
	}

	public void setUsuarioMBean(UsuarioMBean usuarioMBean) {
		this.usuarioMBean = usuarioMBean;
	}
	
}
