<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneBook Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
html{
	 user-select: none;
}
.primary-background {
	background-color: #34377e;
}

.phone-bg {
	background: url("img/phone.jfif");
	background-size: cover;
	width: 100%;
	height: 80vh;
}

.footer {
	width: 100%;
	height: auto;
}

.banner-background {
	clip-path: polygon(50% 0%, 100% 0, 100% 86%, 55% 100%, 25% 88%, 0 100%, 0 0);
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container-fluid m-0 p-0 phone-bg">
		<div class="jumbotron primary-background banner-background">
			<div class="container text-white">
				<h3 class="display-3">Welcome To PhoneBook</h3>
				<p>The PhoneBook application works specifically for storing
					people's Information. The PhoneBook application contains a set of
					basic functions for adding, updating, and deleting new contacts.
					This PhoneBook design allows you to perform simple tasks in your
					PhoneBook, such as mobile phones.</p>
				<p>The application program has been successfully implemented
					using experimental cases and the language used Java.  This
					application works for other functions that make it easy to 
					delete, edit, and remember our peer information.</p>
				<!-- 
				<button class="btn btn-outline-light">
					<span class="fa fa-paperclip"></span> Start! Its Free
				</button> -->
				<a href="login.jsp" class="btn btn-outline-light"> <span
					class="fa fa-user-circle fa-spin"></span> Login
				</a>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>