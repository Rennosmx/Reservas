package br.ufrn.imd.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.ufrn.imd.dominio.Reserva;

@Stateless
public class ReservaDao {

	@PersistenceContext
    private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Reserva salvarOuAtualizar(Reserva reserva) {
		if(reserva.getId() == 0){
			em.persist(reserva.getSalaReservada());	
			em.persist(reserva);
		}
		else
			em.merge(reserva);
		return reserva;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Reserva reserva) {
		reserva = em.find(Reserva.class, reserva.getId());
		em.remove(reserva);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> listar() {
		return (List<Reserva>) em.createQuery("select m from Reserva m").getResultList();
	}
	
}
