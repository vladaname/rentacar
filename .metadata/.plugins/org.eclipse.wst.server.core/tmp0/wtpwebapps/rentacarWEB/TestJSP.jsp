<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>

<c:choose>
	<c:when test="${poruka.equals('Zdravo!') }">
		<p>Aplikacija vas je pozdravila</p>
	</c:when>
	
	<c:when test="${poruka.equals('Pera') }">
		<p>Pozdavio vas je Pera</p>
	</c:when>
	
	<c:otherwise>
	<p>Niko vas nije pozdravio</p>
	</c:otherwise>
	
		
</c:choose>

	${poruka.equals('Djura')? "Zdravo Djuro!": "Zdravo!" }
	
	
	<c:if test="${poruka.equals('Djura') }">Zdravo Djuro!</c:if>

</body>
</html>