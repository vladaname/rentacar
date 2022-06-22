<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Razduzi</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="adminpage.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
      <li><a href="/rentACar/admin/adminpage.jsp">Admin centar</a></li>
      <li class="active"><a href="/rentACar/razduziServlet">Razduzi auto</a></li>
      <li><a href="/rentACar/adminCenovnikServlet">Izmeni cenovnik</a></li>
      <li><a href="/rentACar/uploadServlet">Dodaj fotografije</a></li>
      <li><a href="/rentACar/pregledIznajmljivanjaServlet">Iznajmljivanja</a></li>
    </ul>
    <a href="/rentACar/admin/izvestaji.jsp"><button
				class="btn btn-danger navbar-btn">Izvestaji</button></a>

		<a href="<c:url value='/LoginServlet?logout'/>"><button
				class="btn btn-danger navbar-btn pull-right">Log out</button></a>
	</div>
	</nav>
	<form action="/rentACar/razduziServlet" method="get">

		<p>Pregled zauzetih automobila</p>


		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Marka</th>
					<th>Model</th>
					<th>Gorivo</th>
					<th>Boja</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="auto" items="${autalista}">
					<tr>
						<td>${auto.marka }</td>
						<td>${auto.model }</td>
						<td>${auto.gorivo }</td>
						<td>${auto.boja }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
<form action="/rentACar/razduziServlet" method="post">
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Opcija</th>
					<th>Izbor</th>
					<th>Aktivnost</th>


				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Odaberite vozilo:</td>
					<td class="right"><select name="vozniPark">
							<c:forEach var="vp" items="${autalista}">
								<option value="${vp.registracija }">${vp.marka} ${vp.model} 
								Registracione oznake: ${vp.registracija}</option>
							</c:forEach>
					</select></td>
					<td><input class="btn btn-success active btn-xs" type="submit"
						value="Razduzi" /></td>
				</tr>
			</tbody>
		</table>



	</form>
</body>
</html>

</body>
</html>