package br.ufrn.imd.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufrn.imd.dominio.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscarPorLogin(String login) {
		try {
			Query q = em.createQuery("select u from Usuario u where login = :login");
			q.setParameter("login", login);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
