<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
							<td><c:out value="${usuario.getFav().getNombre()}" /></td>
						</tr>
					</table>
					<p class="has-text-centered mb-4">
						<a href="/itinerario?id={{id que me da Java}} ">Tenes
							aventuras pendientes!</a>
					</p>

					<div class="has-text-centered">
						<a href="" class="button is-primary">Comprar Atracciones</a>
					</div>


				<div class="has-text-centered">
					<a href="" class="button is-primary">Comprar Atracciones</a>
				</div>

			</div>
			<!--Fin Card Content-->
		</div>
		<!--FIN CARD-->
	</div>
</section>
<jsp:include page="layout/footer.jsp"></jsp:include>