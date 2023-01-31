<%@page import="com.phonebook.entities.Message"%>
<%@page import="com.phonebook.entities.user"%>
<%
	user user= (user)session.getAttribute("currentUser");
	if(user==null){
		response.sendRedirect("login.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome, <%=user.getName() %></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
		html{
		 	user-select: none;
			}
		.primary-background{
			background-color: #34377e;
		}
		body{
			background:url("img/phone.jfif");
			background-size: cover;
			width: 100%;
			height: 80vh;
		}
		.footer{
			width: 100%;
			height: 11vh;
		}
	</style>
</head>
<body>
<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background ">
	  <a class="navbar-brand" href="profile.jsp"><i class="fa fa-phone"></i> PhoneBook</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="profile.jsp"><span class="fa fa-home"></span> Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="addPhone.jsp"><span class="fa fa-plus-square"></span> Add Phone no.</a>
	      </li>
	      
	      <li class="nav-item active">
	        <a class="nav-link" href="viewContact.jsp"><span class="fa fa-eye"></span> View Contact</a>
	      </li>
	    </ul>
	    <div>
	    	<button type="button" class="btn btn-outline-light" data-toggle="modal" data-target="#profileModal"><span class="fa fa-user-circle"></span> <%=user.getName() %></button>
	    	<a href="logoutServlet" class="btn btn-outline-light"><span class="fa fa-sign-out"></span> Logout</a>
	    </div>
	  </div>
</nav>

<!-- navbar end -->

<!-- profile modal start -->


		<!-- Modal -->
		<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header primary-background text-white">
		        <h5 class="modal-title" id="exampleModalLabel">Welcome, <%=user.getName() %></h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       		<div class="container text-center">
		       			<img alt="defaultPic" src="pics/<%=user.getProfile() %>" style="border-radius: 50%;" width="150px" height="150px">
		       			<h5><%=user.getName() %></h5>
		       		</div>
		       		<div class="conatiner text-center" id="userProfile">
		       			<table class="table table-striped">
		       				<tr>
		       					<th>ID</th>
		       					<td><%=user.getId() %></td>
		       				</tr>
		       				<tr>
		       					<th>Name</th>
		       					<td><%=user.getName()%></td>
		       				</tr>
		       				<tr>
		       					<th>Email</th>
		       					<td><%=user.getEmail()%></td>
		       				</tr>
		       				<tr>
		       					<th>Mobile</th>
		       					<td><%=user.getMobile() %></td>
		       				</tr>
		       			</table>
		       		</div>
		       		
		       		
		       		<div class="container">
		       			<div class="editProfile text-center" style="display: none;">
		       			<form action="editUserProfile" method="post" enctype="multipart/form-data">
		       				<table class="table table-striped">
		       				<tr>
		       					<th>ID</th>
		       					<td><%=user.getId() %></td>
		       				</tr>
		       				<tr>
		       					<th>Name</th>
		       					<td><input type="text" value="<%=user.getName()%>" name="name"/></td>
		       				</tr>
		       				<tr>
		       					<th>Email</th>
		       					<td><%=user.getEmail() %></td>
		       				</tr>
		       				<tr>
		       					<th>Password</th>
		       					<td><input type="password" value="<%=user.getPassword()%>" name="password"/></td>
		       				</tr>
		       				<tr>
		       					<th>Mobile</th>
		       					<td><input type="number" value="<%=user.getMobile()%>" name="mobile"/></td>
		       				</tr>
		       			</table>
		       				<div class="container">
		       					<button type="submit" class="btn btn-primary">Save</button>		       				</div>
		       			</form>
		       		</div>
		       		</div>
		       	
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" id="editProfileBtn" class="btn btn-primary">Edit</button>
		      </div>
		    </div>
		  </div>
		</div>

<!-- profile modal end -->

	<%
	
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>" role="alert"><%=m.getContent()%></div>


	<%
	session.removeAttribute("msg");
	}
	%>


<div class="container text-center text-danger">
	<h1 class="display-3">You Can Add , Update , Delete and View All Contact.</h1>
	<bR><br>
<a href="addPhone.jsp" class="btn btn-outline-primary btn-lg"><i class="fa fa-plus "></i> Add New Contact</a>
<br><br>
<a href="viewContact.jsp" class="btn btn-outline-primary btn-lg"><i class="fa fa-eye "></i> View Contact</a>
</div>



<script src="https://code.jquery.com/jquery-3.6.3.min.js" ></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">

	
	
	$(document).ready(function() {
		let editStatus = false;

		$('#editProfileBtn').click(function() {
			if (editStatus == false) {
				$('#userProfile').hide();
				$('.editProfile').show();
				editStatus = true;
				$(this).text("Back");
			} else {
				$('#userProfile').show();
				$('.editProfile').hide();
				editStatus = false;
				$(this).text("Edit");
			}
		})
	})
</script>
</body>
</html>