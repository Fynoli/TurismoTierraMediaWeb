<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section has-bg-map">
	<h2 class="title has-text-centered has-text-warning-light">Explora
		un fantástico mundo!</h2>

	<div class="container mt-6">

		<div class="columns is-variable is-8">

			<div class="column">
				<div class="card is-smooth">
					<div class="card-header">
						<h2 class="card-header-title subtitle has-text-warning-light">
							Modificar Tipo Atraccion</h2>
					</div>
					<div class="card-content">
						<form class="form" action="tipoatraccionactualizar" method="POST">
						
							<div class="field">
								<label class="label has-text-warning-light" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
										value="${tipoModificar.getNombre()}"/>>
									<span class="icon is-small is-left"> <i
										class="fas fa-user"></i>
									</span>
								</div>
							</div>

							

							<div class="field is-grouped">
								<div class="control">
									<a href="TipoAtraccionList" class="button is-primary">Cancelar</a>
								</div>
								<div class="control">
									<button type="submit" class="button is-link">Modificar</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
</section>

<script>



</script>

<jsp:include page="layout/footer.jsp"></jsp:include>