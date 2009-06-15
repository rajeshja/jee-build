package rja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rja.entities.Item;


/**
 * Describe class InsertItemServlet here.
 *
 *
 * Created: Mon Jun 15 00:46:17 2009
 *
 * @author <a href="mailto:rajeshja@rja-desktop-lnx">Rajesh</a>
 * @version 1.0
 */
public class InsertItemServlet extends HttpServlet {

	@PersistenceUnit(unitName="j2eeDB")
	EntityManagerFactory emf;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>InsertItem</title></head><body>");

		EntityManager em = emf.createEntityManager();

		Item item = new Item();
		item.setName("Item " + (int)(Math.random()*100));
		item.setDescription("Random description");
		item.setCreatedDate(new Date());
		
		em.persist(item);

		Query query = em.createQuery("select from Item");
		List<Item> items = query.getResultList();

		for (Item i: items) {
			out.print(i.getName() + "<br/>");
		}
		
		out.print("</body></html>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		doGet(request, response);
	}	

}
