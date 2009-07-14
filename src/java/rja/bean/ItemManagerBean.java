package rja.bean;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import rja.entities.Item;

/**
 * Describe class ItemManagerBean here.
 *
 *
 * Created: Tue Jun 16 19:55:15 2009
 *
 * @author <a href="mailto:rajeshja@GDYLPT13432"></a>
 * @version 1.0
 */
@PermitAll
@Stateless
@Local(rja.bean.ItemManager.class)
public class ItemManagerBean implements ItemManager {

	@Resource
	private SessionContext ctx;

	@PersistenceUnit(unitName="j2eeDB")
	private EntityManagerFactory emf;

	@RolesAllowed("loginUser")
	public void insert(Item item) {

		EntityManager em = emf.createEntityManager();
		item.setDescription("set by " + ctx.getCallerPrincipal());
		em.persist(item);

	}

	public List<Item> findAllItems() {

		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Item");
		List<Item> items = query.getResultList();
		
		return items;
	}

}
