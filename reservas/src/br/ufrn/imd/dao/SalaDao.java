package br.ufrn.imd.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufrn.imd.dominio.Sala;

@Stateless
public class SalaDao {

	@PersistenceContext
    private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Sala salvarOuAtualizar(Sala sala) {
		if(sala.getId() == 0)
			em.persist(sala);
		else
			em.merge(sala);
		return sala;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Sala sala) {
		sala = em.find(Sala.class, sala.getId());
		em.remove(sala);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sala> listar() {
		return (List<Sala>) em.createQuery("select m from Sala m").getResultList();
	}	
	
}
