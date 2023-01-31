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
import com.phonebook.entities.contact;

/**
 * Servlet implementation class addPhoneServlet
 */

@MultipartConfig
@WebServlet("/addPhoneServlet")
public class addPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPhoneServlet() {
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
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		contact contact=new contact(name, email, mobile, uid);
		contactDao cdao=new contactDao(connectionProvider.getConnection());
		
		boolean f=cdao.saveContact(contact);
		
		if(f) {
			out.write("done");
			Message m=new Message("Contact Added Successfully.", "success", "alert-success");
			
			HttpSession session=request.getSession();
			
			session.setAttribute("addContactMsg", m);
			
			response.sendRedirect("addPhone.jsp");
			
		}else {
			out.write("failed");
			Message m=new Message("Contact Not Added...! Something Went Wrong.", "error", "alert-danger");
			
			HttpSession session=request.getSession();
			
			session.setAttribute("addContactMsg", m);
			
			response.sendRedirect("addPhone.jsp");
		}
		
	}

}
