<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
<style>
.view {
	background:
		url("https://mdbootstrap.com/img/Photos/Others/img (40).jpg")
		no-repeat center center;
}

.navbar {
	background-color: transparent;
}

.top-nav-collapse {
	background-color: #4285F4;
}

@media only screen and (max-width: 768px) {
	.navbar {
		background-color: #4285F4;
	}
}
</style>
</head>
<body>
	<header> <nav
		class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
	<a class="navbar-brand" href="#"><strong>Navbar</strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<div>
			<form class="navbar-nav mr-auto" action="/rentacarWEB/KontaktServlet" method="get">
				<button  type="submit" class="button">Kontakt</button>
			</form>
			<form class="navbar-nav mr-auto" action="/rentacarWEB/ListaAutomobilaServlet" method="get">
				<button  type="submit" class="button">Automobili</button>
			</form>
			<form class="navbar-nav mr-auto" action="/rentacarWEB/LoginServlet" method="get">
				<button  type="submit" class="button">Login</button>
			</form>


		</div>

	</div>
	</nav>

	<div class="view intro hm-purple-light" style="height: 400px;"></div>

	</header>
	<!--Main Navigation-->

	<!--Main Layout-->
	<main class="text-center py-5">

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<p align="justify">Europcar Rent a Car Beograd, Novi Sad, Niš

					Najpovoljnije ponude rent a car usluga u Beogradu,Novom Sadu i
					Nišu, stabilnost cena, specijalne ponude prema potrebama klijenata,
					najnoviji modeli vozila, najveći spektar dizel i automatik vozila,
					najmlađa vozila na tržištu, Europcar kao Vaš pouzdan partner.
					Možete se osloniti na nas. Da li se radi o dnevnom najmu u zemlji
					ili inostranstvu, prelaznom rešenju na nekoliko meseci ili kupovini
					vozila na duži period, Europcar vaš prati kao Vaš pouzdani partner.
					Sa našom flotom od 55 grupa vozila, od najmanjeg gradskog vozila,
					preko poslovnih limuzina i 4x4 džipova, pa do komercijalnih vozila,
					Europcar je tu da za Vas obezbedi najbolju soluciju. Kretanje kroz
					Beograd nikad nije bilo lakše i jeftnije nego sad uz Europcar rent
					a car vozila na Beogradskom Aerodromu. Čim stignete na aerodrom
					Beograd preuzmete rent a car vozilo, možete krenuti u istraživanje
					prelepih predela</p>

			</div>
		</div>
	</div>

	</main>
	<!--Main Layout-->
</body>
</html>