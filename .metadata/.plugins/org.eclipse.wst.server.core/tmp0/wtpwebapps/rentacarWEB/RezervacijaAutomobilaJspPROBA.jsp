<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RezervacijaAutomobilaServletPROBA</title>
</head>
<body>
<table class="table table-striped table-condensed">
	<thead>
		<tr>
			<th>Marka</th>
			<th>Model</th>
			<th>Datum od</th>
			<th>Datum do</th>
			<th>Rezervisi</th>
		</tr>
	</thead>
	<tbody >
		<c:forEach var="r" items="${rent }">
			<tr>
				<td>${r.marka }</td>
				<td>${r.model }</td>
				<td>${r.datum_od }</td>
				<td>${r.datum_do }</td>
				<td>
				<form action="/rentacarWEB/RezervisiAuto" method="post">
				<button type="submit">Rezervisi</button>
				</form>
				</td>
			</tr>
	</c:forEach>
	
	</tbody>


</table>


</body>
</html>