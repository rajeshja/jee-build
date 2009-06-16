package rja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rja.bean.Calculator;
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
	private EntityManagerFactory emf;

	@EJB
	private Calculator calculator;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>InsertItem</title></head><body>");

		EntityManager em = emf.createEntityManager();

		Item item = new Item();
		item.setName("Item " + (int)(Math.random()*100));
		item.setDescription("Random description");
		item.setCreatedDate(new Date());
		item.setPrice(new BigDecimal(100.0));
		
		em.persist(item);
		
		out.print("Just attempted to create an item - " 
				  + item.getName() + ", "
				  + item.getDescription() + ", "
				  + item.getCreatedDate() + ", "
				  + item.getPrice() + "<br/>");
		out.println();

		Query query = em.createQuery("from Item");
		List<Item> items = query.getResultList();
		
		if (items!=null) {
			out.print("The query returned " + items.size() + " rows.<br/>");
		} else {
			out.print("The query returned null.<br/>");
		}
		
		for (Item i: items) {
			out.print(i.getName() + "<br/>");
		}

		out.print("And the sum of 2 and 3 is " + calculator.add(2,3) + "<br/>");
		out.print("And the different of 5 and 3 is " + calculator.subtract(5,3) + "<br/>");
		
		out.print("</body></html>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		doGet(request, response);
	}	

}
