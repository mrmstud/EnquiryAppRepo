<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquiry App Home Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
<div class="row">
<div class="col-sm-4">
<c:import url="left-menu.jsp"></c:import>
</div>
<div class="col-sm-4">
<c:out value="${'Welcome to Enquiry App Page'}" />
</div>
</div><!-- ending row -->
</div><!-- ending container -->
<div class="jumbotron text-center" style="margin-bottom:0">
  <c:import url="footer.jsp"></c:import>
</div>
</body>
</html>