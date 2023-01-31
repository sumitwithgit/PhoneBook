package com.phonebook.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonebook.dao.userDao;
import com.phonebook.db.connectionProvider;
import com.phonebook.entities.user;

/**
 * Servlet implementation class registerServlet
 */

@MultipartConfig
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		
		user user=new user(name, email, password, mobile);
		
		userDao udao=new userDao(connectionProvider.getConnection());
		boolean  f=udao.saveUser(user);
		
		if(f) {
			out.write("done");
		}else {
			out.write("failed");
		}
		
	}

}
