<%@page import="com.phonebook.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
		html{
		 user-select: none;
			}
		.primary-background{
			background-color: #34377e;
		}
		.phone-bg{
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
<jsp:include page="navbar.jsp"></jsp:include>

<%

	Message addError=(Message)session.getAttribute("addError");
	if(addError!=null){
		%>
		<div class="alert <%=addError.getCssClass() %> text-center m-0" style="width: 100%;" role="<%=addError.getType()%>">
					<%=addError.getContent() %>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		 </button>
		</div>
			
	<%
	session.removeAttribute("addError");
	}
%>
<%

	Message viewError=(Message)session.getAttribute("viewError");
	if(viewError!=null){
		%>
		<div class="alert <%=viewError.getCssClass() %> text-center m-0" style="width: 100%;" role="<%=viewError.getType()%>">
					<%=viewError.getContent() %>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		 </button>
		</div>
			
	<%
	session.removeAttribute("viewError");
	}
%>






<div class="container-fluid phone-bg">
<h1 class="text-center text-danger">Welcome To PhoneBook</h1>




<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="loginServlet" method="post" enctype="application/x-www-form-urlencoded" id="loginForm">
				<div class="card">
					<div class="card-header text-center text-white primary-background">
						<span class="fa fa-user-circle fa-3x"></span>
						<h4>Login Form</h4>
					</div>
					
					<%
						Message m=(Message)session.getAttribute("msg");
						if(m!=null)
						{
							%>
								<div class="alert <%=m.getCssClass() %>" role="<%=m.getType()%>">
					  					<%=m.getContent() %>
								</div>
									
							<%
							session.removeAttribute("msg");
						}
					%>
					
					
					
					
					<div class="card-body">
							<div class="form-group">
								<input required="required" class="form-control" type="email" name="email" placeholder="Enter Email"/>
							</div>
							<div class="form-group">
								<input required="required" class="form-control" type="password" name="password" placeholder="Enter Password"/>
							</div>
					</div>
					<div class="card-footer primary-background">
						<div class="form-group text-right">
								<button type="reset" class="btn btn-danger text-white">Reset</button>
								<button type="submit" class="btn btn-primary text-white">Submit</button>
							</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

</div>

<%@include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.6.3.min.js" ></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">
	
</script>





</body>
</html>