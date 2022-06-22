<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selektuj Datume</title>
</head>
<body>

<form action="/rentacarWEB/RezervacijaAutomobilaServletPROBA" method="post">

Datum od:<input type="datetime-local" name="datum_od"><br>
Datum do:<input type="datetime-local" name="datum_do"><br>
<button type="submit">Rezervisi</button>

</form>

</body>
</html>