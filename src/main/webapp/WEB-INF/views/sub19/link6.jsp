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

	<form action="/sub19/link7" method = "post"> <br />
		이름 : <input type="text" name = "name"/> <br />
		나이 : <input type="number" name = "age"/> <br />
		가격 : <input type="text" name = "price" /> <br />
		생일 : <input type="date" name = "birth" /> <br />
		입력일시  :<input type="datetime-local" name = "inserted"/> <br />
		<input type="submit" value = "link7 전송" />
	
	</form>
	
	<form action="/sub19/link8" method = "post"> <br />
		이름 : <input type="text" name = "name"/> <br />
		나이 : <input type="number" name = "age"/> <br />
		가격 : <input type="text" name = "price" /> <br />
		생일 : <input type="date" name = "birth" /> <br />
		입력일시  :<input type="datetime-local" name = "inserted"/> <br />
		<input type="submit" value = "link8 전송" />
	
	</form>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>