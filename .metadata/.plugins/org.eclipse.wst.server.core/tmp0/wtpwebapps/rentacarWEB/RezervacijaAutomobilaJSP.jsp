<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezervacija</title>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
 body{ 
/* background: blue; */
/* color: white; */
 } 

</style>
</head>
<body>
	<center>
		<h1>Odobrali ste automobil ${naziv } po ceni od ${cena }</h1>
		<table class="table table-striped table-condensed">

			<thead>
				<tr>
					<th>Vreme od</th>
					<th>Vreme do</th>
					<th>Marka</th>
					<th>Model</th>
					<th>Rezervisi</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="i" items="${autoL }">
					<tr>
						<td>${i.datum_od }</td>
						<td>${i.datum_do }</td>
						<td>${i.automobil.marka }</td>
						<td>${i.automobil.model }</td>
						<td>
							<form action="/rentacarWEB/RezervacijaAutomobilaServlet" method="post">
							<input type="date" name="4-953409">
							<input type="hidden" value="${p.idPregled }" name="idPregled">
							<input type="hidden" value="${idUsluga }" name="idUsluga">
							<input type="hidden" value="${naziv }" name="naziv">
							<input type="hidden" value="${cena }" name="cena">
								<button type="submit" class="button">Rezervisi</button>
							</form>
						</td>
						
						

					</tr>
				</c:forEach>
			</tbody>

		</table>
		
		<p>${poruka }</p>

	</center>

</body>
</html>