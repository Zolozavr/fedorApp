<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Resource loader -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>FEDOR ${title}</title>
<script src="${js}/jquery.qrcode.js"></script>

<script src="${js}/qrcode.js"></script>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/bootstrap-readable.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/fedorapp.css" rel="stylesheet">
<!-- MIT CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickShop == true}">
				<!-- Home section -->
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<!-- About section -->
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<!-- Contact section -->
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- All books view or view books by category-->
			<c:if
				test="${userClickAllBooks == true or userClickCategoryBooks == true}">
				<!-- Contact section -->
				<%@include file="listBooks.jsp"%>
			</c:if>
			<!-- Manage book view -->
			<c:if test="${userClickShowBook == true}">


				<%@include file="book.jsp"%>
			</c:if>
			<!-- Manager Book View -->
			<c:if test="${userClickManageBooks == true}">
				<!-- Contact section -->
				<%@include file="manageBooks.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<script>
			//jQuery('#qrcode').qrcode("this plugin is great");
			jQuery('#qrcodeTable').qrcode({
				render : "table",
				text : "http://jetienne.com"
			});
			jQuery('#qrcodeCanvas').qrcode({
				text : "http://jetienne.com"
			});
		</script>

		

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- MIT DATATABLE -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- MIT DATATABLE BOOTSTRAP -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- BOOTBOX BOOTSTRAP -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- QRcode generator -->
		

		<!-- My code -->
		<script src="${js}/myapp.js"></script>

		<!-- Google maps -->
		<script>
			function initMap() {
				var uluru = {
					lat : 49.8426551033341,
					lng : 24.0348394587636
				};
				var map = new google.maps.Map(document.getElementById('map'), {
					zoom : 20,
					center : uluru
				});
				var marker = new google.maps.Marker({
					position : uluru,
					map : map
				});
				function loadMap() {
					//...
					var marker = new google.maps.Marker({
						position : latlng,
						map : map,
						title : "FEDOR"
					});
					//...
				}
			}
		</script>
		<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC4IIcG_Cr99EjCTdPrVUCbYHI_U6UKiVU&callback=initMap">
			
		</script>
	</div>
</body>

</html>
