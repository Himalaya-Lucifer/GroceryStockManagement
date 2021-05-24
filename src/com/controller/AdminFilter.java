package com.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/*")
public class AdminFilter implements Filter {

	private static final String[] LoginRequiredURLS = {"ItemController","/add_item.jsp","update-item-form.jsp"};     
	
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("himalay");
		
		// just fo testing where it work or not
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		//this to cast servlet request to http servlet and telling session is already present
		
		boolean loggedIn = session != null && session.getAttribute("user")!=null;
		//this is to check whether session is there or not and whre the individual is log in or not
		
		String requestURL=httpRequest.getRequestURL().toString();
		//from which url it has come;
		
		if(!loggedIn && isLoginRequired(requestURL))
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		}
		else 
		    chain.doFilter(request, response);
	}

	private boolean isLoginRequired(String requestURL) {
		
		for(String loginRequiredURL:LoginRequiredURLS)
		{
			if(requestURL.contains(loginRequiredURL))
			{
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
