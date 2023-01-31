package com.phonebook.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.phonebook.Helper.Helper;
import com.phonebook.dao.userDao;
import com.phonebook.db.connectionProvider;
import com.phonebook.entities.Message;
import com.phonebook.entities.user;

/**
 * Servlet implementation class editUserProfile
 */
@MultipartConfig
@WebServlet("/editUserProfile")
public class editUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUserProfile() {
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
		String password=request.getParameter("password");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		
		
		
		
		HttpSession session=request.getSession();
		user user=(user)session.getAttribute("currentUser");
		
		user.setName(name);
		user.setPassword(password);
		user.setMobile(mobile);

		
		
		userDao udao=new userDao(connectionProvider.getConnection());
		boolean f=udao.updateUser(user);
		
		if (f) {
			out.write("update successfully");
			Message msg = new Message("Profile Updated", "success", "alert-success");
			session.setAttribute("msg", msg);
		} else {
			out.write("file not saved.");
			Message msg = new Message("Something Went Wrong ! Try Again", "error", "alert-danger");
			session.setAttribute("msg", msg);
		}
		response.sendRedirect("profile.jsp");
		
	}

}
