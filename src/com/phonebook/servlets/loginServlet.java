package com.phonebook.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phonebook.dao.userDao;
import com.phonebook.db.connectionProvider;
import com.phonebook.entities.Message;
import com.phonebook.entities.user;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		
		userDao udao=new userDao(connectionProvider.getConnection());
		
		user user=udao.loginUser(email, password);
		
		if(user==null) {
			Message m=new Message("Something Went Wrong...Try Again!!!", "alert", "alert-danger");
			HttpSession session=request.getSession();
			session.setAttribute("msg", m);
			
			response.sendRedirect("login.jsp");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user);
			
			response.sendRedirect("profile.jsp");
			
		}
	}

}
