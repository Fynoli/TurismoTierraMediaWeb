<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Permite usar etiquetas personalizadas -->
<section class="section ">
	<h1 class="title has-text-centered  mb-8">Tu perfil</h1>

	<div class="columns">
		<div class="card column is-6 is-offset-one-quarter">
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
						<th><span class="pr-1"> <i class="fas fa-coins"></i></span> Presupuesto</th>
						<td><c:out value="${usuario.getPresupuesto()}"/></td>
					</tr>
					<tr class="tr">
						<th><span class="pr-1"> <i class="fas fa-clock"></i></span> Tiempo disponible</th>
						<td> <c:out value="${usuario.getTiempo_disponible()}"/></td>
					</tr>
					<tr class="tr">
						<th><span class="pr-1"><i class="fas fa-map-signs"></i></span> Preferencia</th>
						<td> <c:out value="${usuario.getTipoAtraccion().getNombre()}"/></td>
					</tr>
				</table>
				<p class="has-text-centered mb-4">
					<a class="button is-link" href="itinerariousuario">Ver mi itinerario</a>
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