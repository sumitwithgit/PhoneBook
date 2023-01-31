<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="Error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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

<div class="container-fluid phone-bg">
<h1 class="text-center text-danger">Welcome To PhoneBook</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="registerServlet" method="post" enctype="application/x-www-form-urlencoded" id="regForm">
				<div class="card">
					<div class="card-header text-center text-white primary-background">
						<span class="fa fa-user-plus fa-3x"></span>
						<h4>Registration Form</h4>
					</div>
					<div class="card-body">
							<div class="form-group">
								<input required="required" class="form-control" type="text" name="name" placeholder="Enter Name"/>
							</div>
							<div class="form-group">
								<input required="required" class="form-control" type="email" name="email" placeholder="Enter Email"/>
							</div>
							<div class="form-group">
								<input required="required" class="form-control" type="password" name="password" placeholder="Enter Password"/>
							</div>
							<div class="form-group">
								<input required="required" class="form-control" type="number" name="mobile" placeholder="Enter Mobile"/>
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
$(document).ready(function(){
	$("#regForm").on('submit',function(event){
		event.preventDefault();
		let form=new FormData(this);
		$.ajax({
			url:'registerServlet',
			method:'post',
			data:form,
			success:function(data){
				console.log(data);
				if(data.trim()==='done')
				{
				swal({
					  title: "Registration Successfully!!!",
					  text: "We are Redirecting to Login Page.",
					  icon: "success",
					  button: "Done...!",
					}).then((value)=>{
						window.location="login.jsp"
					});
				}
			else
					{
					swal({
						  title: "Something Went Wrong...!!!Try Again.",
						  text: "We are Redirecting to Registration Page Again.",
						  icon: "warning",
						  buttons: true,
						  dangerMode: true,
						}).then((value)=>{
							window.location="register.jsp";
						})
					} 
			},
			error:function(data){
				concole.log(data);
				swal({
					  title: "Something Went Wrong...!!!Try Again.",
					  text: "We are Redirecting to Registration Page Again.",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					}).then((value)=>{
						window.location="register.jsp";
					})
			},
			processData:false,
			contentType:false
		});
	})
});
</script>


</body>
</html>