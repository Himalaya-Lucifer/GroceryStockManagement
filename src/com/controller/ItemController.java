package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.himalaya.data.ItemDAOImpl;
import com.himlaya.model.Item;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ItemDAOImpl itemUtil= null;
    
    
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		itemUtil = new ItemDAOImpl();
	}

	public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	   String command=request.getParameter("command");
	    	   if(command==null)
	    		   command="LIST";    	   
	    	   switch(command) {
	    	   
	    	   case "LIST":
	    		   listItem(request,response);
	    		   break;
	    	   case "LOAD":
	    		   loadItem(request,response);
	    		   break;
	    	   case "ADD":
	    		   addItem(request,response);
	    		   break;
	    	   case "UPDATE":
	    		   updateItem(request,response);
	    		   break;
	    	   case "DELETE":
	    		   deleteItem(request,response);
	    		   break;
	    	   case "SEARCH":
	    		   searchItem(request,response);
	    		   break;
	    	   case "default":
	    		   listItem(request,response);
	    		   break;
	    		   
	    	   }
	    	   	   
	       }
	       catch(Exception e)
	       {
	    	   throw new ServletException(e);
	       }
			
		
		
	}

	

	private void searchItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
String searchName= request.getParameter("searchName").trim();
		
		List<Item> items = itemUtil.searchItem(searchName);
		request.setAttribute("item_list",items);
		
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request,response);
		
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		int itemCode = Integer.parseInt(request.getParameter("itemCode"));
		
	       itemUtil.deleteItem(itemCode);   //Model ko date dega
			
			listItem(request,response); // list call
		
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
        int itemCode = Integer.parseInt(request.getParameter("itemCode"));
		
		String itemName = request.getParameter("itemName");
		String unit = request.getParameter("unit");
		int beginningInventory = Integer.parseInt(request.getParameter("beginningInventory"));
		int quantityOnHand = Integer.parseInt( request.getParameter("quantityOnHand"));
		double pricePerUnit = Double.parseDouble( request.getParameter("pricePerUnit"));
		String dateOfManufacture = request.getParameter("dateOfManufacture");
		String dateOfExpiry = request.getParameter("dateOfExpiry");
		String location = request.getParameter("location");
		String category = request.getParameter("category");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     // this method for changing string into date 
		Date dom = new Date();
		dom = sdf.parse(dateOfManufacture);
		
		Date doe = new Date();
		doe = sdf.parse(dateOfExpiry);
		String message=null;
		if(!doe.after(dom))
		{
			message="date of expiry can't be before date of manufacture ";
			request.setAttribute("msg", message);
			RequestDispatcher rd= request.getRequestDispatcher("update-item-form.jsp");
			rd.forward(request, response);
		}
		
		else {
		Item item = new Item(itemCode, itemName, unit, beginningInventory, quantityOnHand, pricePerUnit, dom, doe, location, category);
					
		itemUtil.updateItem(item);   //Model ko date dega
		
		//listItem(request,response); // list call
		response.sendRedirect("ItemController?command=LIST");
		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String itemName = request.getParameter("itemName");
		String unit = request.getParameter("unit");
		int beginningInventory = Integer.parseInt(request.getParameter("beginningInventory"));
		int quantityOnHand = Integer.parseInt( request.getParameter("quantityOnHand"));
		double pricePerUnit = Double.parseDouble( request.getParameter("pricePerUnit"));
		String dateOfManufacture = request.getParameter("dateOfManufacture");
		String dateOfExpiry = request.getParameter("dateOfExpiry");
		String location = request.getParameter("location");
		String category = request.getParameter("category");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     // this method for changing string into date 
		Date dom = new Date();
		dom = sdf.parse(dateOfManufacture);
		
		Date doe = new Date();
		doe = sdf.parse(dateOfExpiry);
		String message=null;
		if(!doe.after(dom))
		{
			message="date of expiry can't be before date of manufacture ";
			request.setAttribute("msg", message);
			RequestDispatcher rd= request.getRequestDispatcher("add_item.jsp");
			rd.forward(request, response);
		}
		else
		{
		
		Item item = new Item(itemName, unit, beginningInventory, quantityOnHand, pricePerUnit, dom, doe, location, category);
		
		itemUtil.addItem(item);  
		
		//listItem(request,response);  //send back to main page(the item list)
		response.sendRedirect("ItemController?command=LIST");
	}
	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		int itemCode = Integer.parseInt(request.getParameter("itemCode"));
		System.out.println(itemCode);
		Item item = itemUtil.getItem(itemCode);
		System.out.println(item);
		request.setAttribute("ITEM",item);
		RequestDispatcher rd = request.getRequestDispatcher("update-item-form.jsp");
		rd.forward(request, response);
	}

	private void listItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Item> items = itemUtil.getItem();
		request.setAttribute("item_list",items);
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
