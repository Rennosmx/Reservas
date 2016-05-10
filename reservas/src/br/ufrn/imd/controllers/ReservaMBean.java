package br.ufrn.imd.controllers;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.ufrn.imd.dao.ReservaDao;
import br.ufrn.imd.dominio.Reserva;

@ManagedBean
@SessionScoped
public class ReservaMBean {

	private Reserva reserva;
	
	private DataModel<Reserva> reservasModel;
	
	@ManagedProperty(value="#{usuarioMBean}")
	private UsuarioMBean usuarioMBean;
	
	@Inject
	private ReservaDao reservaDao;
	
	public ReservaMBean() {

		reserva = new Reserva();
	}

	public String novaReserva() {
		reserva = new Reserva();
		return "/pages/reserva/form.jsf";
	}
	
	public String listarReservas() {
		reservasModel = new ListDataModel<Reserva>(reservaDao.listar());
		return "/pages/reserva/list.jsf";
	}
	
	public String cadastrarReserva() {
		reserva.setUsuarioAssociado(usuarioMBean.getUsuarioLogado());
		reservaDao.salvarOuAtualizar(reserva);
		reserva = new Reserva();
		return "/pages/reserva/form.jsf";
	}
	
	public String removerReserva() {
		Reserva reservaRemovida = reservasModel.getRowData();
		reservaDao.remover(reservaRemovida);
		reservasModel = new ListDataModel<Reserva>(reservaDao.listar());
		return "/pages/reserva/list.jsf";
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public DataModel<Reserva> getReservasModel() {
		return reservasModel;
	}

	public void setReservasModel(DataModel<Reserva> reservasModel) {
		this.reservasModel = reservasModel;
	}

	public UsuarioMBean getUsuarioMBean() {
		return usuarioMBean;
	}

	public void setUsuarioMBean(UsuarioMBean usuarioMBean) {
		this.usuarioMBean = usuarioMBean;
	}
	
	
	
}
