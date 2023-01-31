package com.phonebook.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phonebook.dao.contactDao;
import com.phonebook.db.connectionProvider;
import com.phonebook.entities.Message;

/**
 * Servlet implementation class deleteContact
 */
@WebServlet("/deleteContact")
public class deleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		contactDao cdao=new contactDao(connectionProvider.getConnection());
		boolean f=cdao.deleteContact(id, uid);
		
		if(f) {
//			out.write("done");
			Message m=new Message("Contact Deleted Successfully.", "success", "alert-success");
			HttpSession session=request.getSession();
			session.setAttribute("deleteMsg", m);
			
			response.sendRedirect("viewContact.jsp");
			
		}else{
//			out.write("failed");
			Message m=new Message("Contact Not Deleted...!Something Went Wrong", "error", "alert-error");
			HttpSession session=request.getSession();
			session.setAttribute("deleteMsg", m);
			
			response.sendRedirect("viewContact.jsp");
		}
	}

}
