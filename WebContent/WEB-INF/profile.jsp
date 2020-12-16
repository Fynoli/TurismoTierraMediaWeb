<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Permite usar etiquetas personalizadas -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
<link rel="stylesheet" href="assets/custom.css">
<title>Tierra Media | Home</title>
</head>
<body>
	<header class="hero">
		<div class="hero-body has-background-grey-dark">
			<div class="container is-max-desktop">
				<h1 class="title has-text-warning-dark">Turismo en la Tierra
					media</h1>
			</div>
		</div>
	</header>
	<section class="section">
		<h1 class="title has-text-centered">Tu perfil</h1>
		<div class="container columns">
			<div
				class="card column is-half
            is-offset-one-quarter
            ">
				<div class="columns is-flex is-centered">
					<figure class="image is-128x128 ">
						<c:choose>

							<c:when test="${usuario.getProfile_pic()!=null}">
								<img class="is-rounded" src="${usuario.getProfile_pic()}">
							</c:when>
							<c:otherwise>
								<img class="is-rounded"
									src="https://i.ibb.co/0mz7xzJ/no-profile-photo.jpg">
							</c:otherwise>
						</c:choose>
					</figure>
				</div>
				<div class="card-header">
					<div class="card-header-title is-centered ">
						<h1 class="title">
							<c:out value="${usuario.getNombre()}" />
						</h1>
					</div>
				</div>
				<div class="card-content">
					<table class="table is-hoverable is-fullwidth">
						<tr class="tr">
							<th>Presupuesto</th>
							<td><c:out value="${usuario.getPresupuesto()}" /></td>
						</tr>
						<tr class="tr">
							<th>Tiempo disponible</th>
							<td><c:out value="${usuario.getTiempo_disponible()}" /></td>
						</tr>
						<tr class="tr">
							<th>Preferencia</th>
							<td><c:out value="${usuario.getTipoAtraccion().getNombre()}" /></td>
						</tr>
					</table>
					<p class="has-text-centered mb-4">
						<a href="itinerariousuario">Tenes
							aventuras pendientes!</a>
					</p>
					<p class="has-text-centered mb-4">
						<a href="atraccionlist">listar atracciones</a>
					</p>
					<p class="has-text-centered mb-4">
						<a href="usuarioslist">listar usuarios</a>
					</p>

					<div class="has-text-centered">
						<a href="compra" class="button is-primary">Comprar Atracciones</a>
					</div>

				</div>
				<!--Fin Card Content-->
			</div>
			<!--FIN CARD-->
		</div>
	</section>
	<footer class="footer has-background-grey-darker has-text-warning-dark">
		<p class="is-copy">Desarrollado por Ctrl+F</p>
	</footer>
	<script defer
		src="https://use.fontawesome.com/releases/v5.14.0/js/all.js"></script>
</body>
</html>