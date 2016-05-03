package br.ufrn.imd.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.ufrn.imd.dao.UsuarioDao;
import br.ufrn.imd.dominio.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMBean {

	private Usuario usuario;
	
	private Usuario usuarioLogado;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	public UsuarioMBean() {
		usuario = new Usuario();
	}

	public String logar() {
		Usuario usuarioBd = usuarioDao.buscarPorLogin(usuario.getLogin());
		if(usuarioBd != null) {
			//existe e senha está correta
			if(usuarioBd.getSenha().equals(usuario.getSenha())){
				usuarioLogado = usuarioBd;
				return "/pages/index.jsf";
			//senha incorreta
			} else {
				FacesMessage msg = new FacesMessage("Senha incorreta.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("", msg);
				return null;
			}
		//não existe
		}else {
			FacesMessage msg = new FacesMessage("Usuário não encontrado.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
