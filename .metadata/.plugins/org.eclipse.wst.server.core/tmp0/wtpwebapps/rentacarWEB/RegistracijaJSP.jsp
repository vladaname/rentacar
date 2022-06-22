<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>
</head>
<body>
	<form class="form-horizontal" action="/rentacarWEB/RegistracijaSERVLET"
		method="POST">
		<fieldset>
			<div id="legend">
				<legend class="">Register</legend>
			</div>
			<div class="control-group">
				<!-- Ime -->
				<label class="control-label" for="ime">Ime</label>
				<div class="controls">
					<input type="text" id="ime" name="ime" placeholder=""
						class="input-xlarge">
					<p class="help-block">Name</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Prezime -->
				<label class="control-label" for="prezime">Prezime</label>
				<div class="controls">
					<input type="text" id="prezime" name="prezime" placeholder=""
						class="input-xlarge">
					<p class="help-block">Surname</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Telefon -->
				<label class="control-label" for="telefon">Telefon</label>
				<div class="controls">
					<input type="text" id="telefon" name="telefon" placeholder=""
						class="input-xlarge">
					<p class="help-block">Telefon</p>
				</div>
			</div>

			<div class="control-group">
				<!-- E-mail -->
				<label class="control-label" for="email">E-mail</label>
				<div class="controls">
					<input type="text" id="email" name="email" placeholder=""
						class="input-xlarge">
					<p class="help-block">Please provide your E-mail</p>
				</div>
			</div>


			<div class="control-group">
				<!-- Username -->
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<input type="text" id="username" name="username" placeholder=""
						class="input-xlarge">
					<p class="help-block">Username can contain any letters or
						numbers, without spaces</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" id="password" name="password" placeholder=""
						class="input-xlarge">
					<p class="help-block">Password should be at least 4 characters</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Password -->
				<label class="control-label" for="password_confirm">Password
					(Confirm)</label>
				<div class="controls">
					<input type="password" id="password_confirm"
						name="password_confirm" placeholder="" class="input-xlarge">
					<p class="help-block">Please confirm password</p>
				</div>
			</div>

			<div class="control-group">
				<!-- JMBG -->
				<label class="control-label" for="jmbg">JMBG</label>
				<div class="controls">
					<input type="text" id="jmbg" name="jmbg" placeholder=""
						class="input-xlarge">
					<p class="help-block">JMBG</p>
				</div>
			</div>

			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success" type="submit">Register</button>
				</div>
			</div>
		</fieldset>
	</form>
	PORUKA:
	<h1>${message }</h1>

</body>
</html>