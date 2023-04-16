<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
</head>
<body>

	<h1>직원 명단</h1>
<!-- 	<ul> -->
<%-- 		<c:forEach items = "${employeeList }" var = "eList"> --%>
<%-- 			<li>${eList.id } - ${eList.lastName }, ${eList.firstName }</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->

	<div>
		<!-- table.table>thead>tr>th*3^^tbody -->
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>LastName</th>
					<th>FirstName</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${employeeList }" var = "eList">
					<tr>
						<td>${eList.id }</td>
						<td>${eList.lastName }</td>
						<td>${eList.firstName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>