<%@page import="com.nagarro.assignments.entities.Employee"%>
<%@page import="com.nagarro.assignments.HrManagerApplication"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="org.springframework.ui.Model"%>
<%@ page import="org.springframework.http.ResponseEntity"%>


<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");

response.setHeader("Pragma", "no-cache");

response.setHeader("Expires", "0");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<style type="text/css">
.result {
	width: 100%;
	border-collapse: collapse;
	background-color: #f2f2f2;
}

.result td {
	text-align: center;
	height: 25px;
	border: 1px solid black;
}

th {
	text-align: center;
	height: 50px;
	border: 1px solid black;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<div class="col-md-6"></div>
			<div class="col-md-5">
			<h2 >Welcome ${username}!</h2>
			</div>
			<div class="col-md-1">
			<a href="${pageContext.request.contextPath}/logout" class="btn btn-dark " role="button "
				data-bs-toggle="button">Logout</a>
			</div>
		</div>

		<div class="row mt-2">
			<h4 class="d-flex justify-content-center py-3 p-3 mb-2">
				Employee Listings</h4>
		</div>

		<div class="row mt-2">
			<div class="col-md-6"></div>
			<div class="col-md-3">
				<form action="uploadpage" method="post">
					<input type="submit" value="Upload Employee Details"
						name="uploadButton" class="btn btn-outline-secondary btn-sm">
				</form>
			</div>
			<div class="col-md-3">
				<a href="${pageContext.request.contextPath}/download" class="btn btn-outline-primary" type="button" download>Download Employee Details</a>
			</div>
		</div>

		<div class="table-responsive mt-4">
			<table class="table table-bordered">
				<tr>
					<th scope="col" class="col-md-2">Employee Code</th>
					<th scope="col" class="col-md-3">Employee Name</th>
					<th scope="col" class="col-md-2">Location</th>
					<th scope="col" class="col-md-3">Email</th>
					<th scope="col" class="col-md-2">Date Of Birth</th>
					<th scope="col" class="col-md-2">Action</th>
				</tr>

						<%
						/* int managerid = (Integer)session.getAttribute("managerid"); */
						
					    List<Employee>  list =	(List<Employee>) request.getAttribute("allEmployee");
						
						%>
						
						

						<%
						
						if(list==null)
						{
						%>
						<tr><h3>No data found</h3></tr>
						<%
						}
						else
						{
							for(Employee e : list){
								
								
						%>
				<tr>
					<td><%=e.getEmployeeId() %></td>
					<td><%=e.getEmployeeName() %></td>
					<td><%=e.getLocation() %></td>
					<td><%=e.getEmployeeEmail() %></td>
					<td><%=e.getDateOfBirth() %></td>
					<td>
					<a href="${pageContext.request.contextPath}/editpage?employeeid=<%=e.getEmployeeId()%>" class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
					</td>
				</tr>
				<%
							}
						}
				%>
			</table>


		</div>

	</div>

</body>
</html>