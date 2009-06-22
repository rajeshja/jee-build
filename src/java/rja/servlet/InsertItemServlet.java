package rja.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rja.bean.Calculator;
import rja.bean.ItemManager;
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

	@EJB
	private Calculator calculator;

	@EJB
	private ItemManager itemManager;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Item item = new Item();
		item.setName("Item " + (int)(Math.random()*100));
		item.setDescription("Random description");
		item.setCreatedDate(new Date());
		item.setPrice(new BigDecimal(100.0));
		
		itemManager.insert(item);

		request.setAttribute("itemInserted", item);
		
		List<Item> items = itemManager.findAllItems();

		request.setAttribute("items", items);

		request.setAttribute("sum", calculator.add(2,3));
		request.setAttribute("difference", calculator.subtract(5,2));

//		if (request.getSession(false) == null) {
//			request.setAttribute("sessionExists",Boolean.FALSE);
//		} else {
//			request.setAttribute("sessionExists",Boolean.TRUE);
//		}

		request.getRequestDispatcher("item-list.jsp").forward(request, response);

		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		doGet(request, response);
	}	

}
