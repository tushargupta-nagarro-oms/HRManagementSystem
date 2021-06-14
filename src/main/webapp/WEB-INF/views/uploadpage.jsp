<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");

response.setHeader("Pragma", "no-cache");

response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Upload page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>

<body>

    <div class="container">
        <form action="${pageContext.request.contextPath}/save" method="post">

            <div class="row mt-3">
                <div class="col-md-6"></div>
                <div class="col-md-5">
                <h2>Welcome ${username}!</h2>
                </div>
                <div class="col-md-1">
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-dark" role="button" data-bs-toggle="button">Logout</a>
                </div>
            </div>
            <div class="row mt-2">
                <h3 class="d-flex justify-content-center py-3 p-3 mb-2">
                    Upload Employee Details 
                </h3>
            </div>
            
            
            
            <input type="hidden" name="managerId" value="${managerid}">
            
            <div class="mb-3">
                <label for="inputId" class="form-label">Employee Code:</label>
                <input type="text" class="form-control" name="employeeId" id="inputId" aria-describedby="emailHelp" maxlength="100" required>
            </div>


            <div class="mb-3">
                <label for="inputName" class="form-label">Employee Name:</label>
                <input type="text" class="form-control" name="employeeName" id="inputName" aria-describedby="emailHelp" maxlength="100" required>
            </div>

            <div class="mb-3">
                <label for="inputLocation" class="form-label">Location:</label>
                <input type="text" class="form-control" name="location" id="inputLocation" aria-describedby="emailHelp" maxlength="100" required>
            </div>

            <div class="mb-3">
                <label for="inputEmail" class="form-label">Email:</label>
                <input type="email" class="form-control" name ="employeeEmail" id="inputEmail" aria-describedby="emailHelp" maxlength="100" required>
            </div>

            <div class="mb-3">
                <label for="inputDOB" class="form-label">Date of Birth:</label>
                <input type="date" class="form-control" name="dateOfBirth" id="inputDOB" aria-describedby="emailHelp">
            </div>


            <div class="row mb-2">
                <div class="col-md-1"></div>
                <div class="col-md-1">
                    <input type="submit" value="Save" name="submitButton" class="btn btn-secondary btn-sm">
                </div>
                <div class="col-md-2">
                    <input type="Reset" value="Cancel" name="Cancel" class="btn btn-secondary btn-sm">
                </div>

            </div>

        </form>
    </div>

</body>

</html>
    