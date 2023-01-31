package com.phonebook.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phonebook.dao.contactDao;
import com.phonebook.db.connectionProvider;
import com.phonebook.entities.Message;

/**
 * Servlet implementation class editContact
 */
@MultipartConfig
@WebServlet("/editContact")
public class editContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		int id=Integer.parseInt(request.getParameter("id"));
		
		contactDao cdao=new contactDao(connectionProvider.getConnection());

		boolean f=cdao.updateContact(name, email, mobile, id);
		
		if(f) {
			out.write("done");
//			Message m=new Message("Contact Update Successfully.", "success", "alert-success");
//			HttpSession session=request.getSession();
//			session.setAttribute("updateMsg", m);
//			
//			response.sendRedirect("viewContact.jsp");
			
			
		}else {
			out.write("failed");
//			Message m=new Message("Something Went Wrong", "error", "alert-error");
//			HttpSession session=request.getSession();
//			session.setAttribute("updateMsg", m);
//			
//			response.sendRedirect("viewContact.jsp");
		}
	}

}
