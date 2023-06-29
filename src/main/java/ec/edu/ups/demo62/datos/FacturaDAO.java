package ec.edu.ups.demo62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demo62.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class FacturaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	public void update(Factura factura) {
		em.merge(factura);
	}
	
	public Factura read(int codigo) {
		Factura p = em.find(Factura.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Factura p = em.find(Factura.class, codigo);
		em.remove(p);
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT p FROM Factura p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
