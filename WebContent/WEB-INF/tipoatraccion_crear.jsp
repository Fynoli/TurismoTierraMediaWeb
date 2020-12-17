<jsp:include page="layout/header.jsp"></jsp:include>
<section class="section">
	<div class="container mt-6">
		<div class="columns is-variable is-8">
			<div class="column">
				<div class="card">
					<div class="card-header">
						<h2 class="card-header-title subtitle">Crear Tipo Atraccion</h2>
					</div>
					<div class="card-content">
						<form class="form" action="tipoatraccionalta" method="POST">
							<div class="field">
								<label class="label" for="nombre">Tipo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre">
									<span class="icon is-small is-left"> <i
										class="fas fa-map-signs"></i>
									</span>
								</div>
							</div>

							

							<div class="field is-grouped">
								<div class="control">
									<a href="tipoatraccionlist" class="button is-primary">Cancelar</a>
								</div>
								<div class="control">
									<button type="submit" class="button is-link">Crear</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
</section>
<jsp:include page="layout/footer.jsp"></jsp:include>
