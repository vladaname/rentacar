<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automobili</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Marka</th>
			    <th>Model</th>
			    <th>Gorivo</th>
			    <th>Cena po danu</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="automobila" items="${auto}">
				<tr>
					<td>${automobila.marka }</td>
					<td>${automobila.model }</td>
					<td>${automobila.gorivo }</td>
					<td>${automobila.cenaPoDanu }</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>