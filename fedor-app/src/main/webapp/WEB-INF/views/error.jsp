<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Resource loader -->
<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>FEDOR ${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/bootstrap-readable.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/fedorapp.css" rel="stylesheet">



</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		
		<div class="container">
		<div class="navbar-header">
		<a class="navbar-brand" href="${contextRoot}/home">HOME</a>
		</div>
		</div>
		</nav>

		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
					<div class="jumbotron">
					<h1>${errorTitle}</h1>
					<ht/>
					<blockquote>
					${errorDescription}
					
					</blockquote>
					
					</div>
					
					
					
					
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
