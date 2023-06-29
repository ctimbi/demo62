package ec.edu.ups.demo62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demo62.modelo.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Producto producto) {
		em.persist(producto);
	}
	
	public void update(Producto producto) {
		em.merge(producto);
	}
	
	public Producto read(int codigo) {
		Producto p = em.find(Producto.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Producto p = em.find(Producto.class, codigo);
		em.remove(p);
	}
	
	public List<Producto> getAll(){
		String jpql = "SELECT p FROM Producto p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
