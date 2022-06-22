<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListaRezervisanihAutomobila</title>
</head>
<body>

	<p>Pregled zauzetih automobila</p>


	<table class="table">
		<thead class="thead-inverse">
			<tr>
				<th>Marka</th>
				<th>Model</th>
				<th>Gorivo</th>
				<th>Kubikaza</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="auto" items="${listaRezervisano}">
				<tr>
					<td>${auto.marka }</td>
					<td>${auto.model }</td>
					<td>${auto.gorivo }</td>
					<td>${auto.kubikaza }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="/rentacarWEB/OslobodiAuto" method="post">
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
					<td class="right">
						<select name="idautomobil">
								<c:forEach var="vp" items="${listaRezervisano}">
									<option value="${vp.idautomobil }">${vp.marka}
											${vp.model}
									</option>
								</c:forEach>
							</select>
						</td>
					<td>
					<input class="btn btn-success active btn-xs" type="submit" value="Razduzi" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>