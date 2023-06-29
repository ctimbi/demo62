package ec.edu.ups.demo62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demo62.modelo.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleFacturaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(DetalleFactura detalle) {
		em.persist(detalle);
	}
	
	public void update(DetalleFactura detalle) {
		em.merge(detalle);
	}
	
	public DetalleFactura read(int codigo) {
		DetalleFactura p = em.find(DetalleFactura.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		DetalleFactura p = em.find(DetalleFactura.class, codigo);
		em.remove(p);
	}
	
	public List<DetalleFactura> getAll(){
		String jpql = "SELECT p FROM DetalleFactura p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}