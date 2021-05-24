package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.himalaya.data.UserDAOImpl;
import com.himlaya.model.User;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
@MultipartConfig(
		fileSizeThreshold=1024 * 10, //10 KB
		maxFileSize=1024*300, //300 kb
		maxRequestSize=1024*1024
		)
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAOImpl userUtil = null;  
	
	// very imp made it khud
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userUtil = new UserDAOImpl();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // thios can be any name like singup aur else;	   
       try {
    	   String command=request.getParameter("command");
    	   switch(command) {
    	   case "ADD":
    		   addUser(request,response);
    		   break;
    	 
    	   case "USER":
    		   getUser(request,response);
    		   break;
    	   case "LOGOUT":
    		   LogOut(request,response);
    		   break;
    	   case "UPDATEPHOTO":
				updatePhoto(request,response);
				break;
    	   }
    	   
    	   
       }
       catch(Exception e)
       {
    	   throw new ServletException(e);
       }
		
		
	}

	

	private void updatePhoto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String userId=request.getParameter("userId");
		Part filePart=request.getPart("photo");
		
		InputStream inputStream = null;
		if(filePart!=null)
		{
			inputStream=filePart.getInputStream();
		}
		try 
		{
		userUtil.updatePhoto(userId, inputStream);
		
		User user= userUtil.getUser(userId);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/ItemController");
		}
		catch(Exception e)
		{
			User user= userUtil.getUser(userId);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("ItemController");
		}
	}

	private void LogOut(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		session.invalidate();
		String message="LOG OUT Sucessfully";
		RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
		request.setAttribute("msg", message);
		rd.forward(request,response);
		
		
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId").trim();
		String password=request.getParameter("password").trim();
		
		String message=null;
		String path="login.jsp";
		
		try {
			User user = userUtil.getUser(userId);
			if(user.getPassword().equals(password)) {
			//	String uri = request.getRequestURI();
			//	System.out.println(uri);
			//pah = "ItemController";
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("ItemController");
				//  System.out.println("Testing...");
				
		}
		else {
				message = "Wrong password : please try again";
				request.setAttribute("msg", message);
				RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
				//System.out.println(e);
		}
		}catch (Exception e) {
			message = e.getMessage();
			request.setAttribute("msg", message);
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
			System.out.println(e);
		
	}
		
		
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		
		Part filePart= request.getPart("photo");// to take photo
		InputStream inputStream =null;
		if(filePart!=null)
		{
			inputStream=filePart.getInputStream();
		}
		
		User user = new User(userId, password, firstName, lastName, address, city,inputStream);
		
		System.out.println(user);
		
		//UserDAOImpl userUtil = new UserDAOImpl();
		
		
		String message=null;
		String resource="registration.jsp";
		
		try 
		{
			userUtil.addUser(user);
			message="registration successfull pls login";
			resource="login.jsp";
		}
		catch(Exception e)
		{
			System.out.println(e);
			message = e.getMessage();
		}
		// to send msg to  main page
		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
