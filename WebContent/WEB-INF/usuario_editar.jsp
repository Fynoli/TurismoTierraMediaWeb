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
							Modificar Usuario
						</h2>
					</div>
					<div class="card-content">
						<form class="form" action="usuarioactualizar" method="POST">
							<div class="field">
								<label class="label has-text-warning-light" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre" value=<c:out value="${uModificar.getNombre()}" escapeXml="false" />>
									<span class="icon is-small is-left"> <i
										class="fas fa-user"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="idTipoA">Preferencia</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="idTipoA" id="idTipoA" value=<c:out value="${uModificar.getTipoAtraccion().getNombre()}" escapeXml="false" />>
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="presupuesto">Presupuesto</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="presupuesto"
										id="presupuesto" value=<c:out value="${uModificar.getPresupuesto()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="tiempoDisp">Tiempo
									Disponible</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="tiempoDisp"
										id="tiempoDisp" value=<c:out value="${uModificar.getTiempo_disponible()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="password">Contraseña</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="password"
										id="password" value=<c:out value="${uModificar.getPassword()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="isActivo">Activo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isActivo"
										id="isActivo" value=<c:out value="${uModificar.getActivo()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="isAdmin">Administrador</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isAdmin"
										id="isAdmin" value=<c:out value="${uModificar.getEsadmin()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<a href="/" class="button is-primary">Cancelar</a>
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



<jsp:include page="layout/footer.jsp"></jsp:include>
