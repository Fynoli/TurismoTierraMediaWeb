<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section has-bg-map">
	<h2 class="title has-text-centered has-text-warning-light">Edita este usuario</h2>

	<div class="container mt-6">

		<div class="columns is-variable is-8">

			<div class="column">
				<div class="card is-smooth">
					<div class="card-header">
						<h2 class="card-header-title subtitle has-text-warning-light">
							Modificar Usuario</h2>
					</div>
					<div class="card-content">
						<form class="form" action="usuarioactualizar" method="POST">
						<input name="id" id="id" value="${uModificar.getId()}" hidden>
							<div class="field">
								<label class="label has-text-warning-light" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
										value="${uModificar.getNombre()}">
									<span class="icon is-small is-left"> <i
										class="fas fa-user"></i>
									</span>
								</div>
							</div>
							<div class="field">
                                <label class="label has-text-warning-light" for="tipo">Preferencia</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tipo"
                                           id="tipo" value="${uModificar.getTipoAtraccion().getId()}"> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>
							<div class="field">
								<label class="label has-text-warning-light" for="presupuesto">Presupuesto</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="presupuesto"
										id="presupuesto"
										value="${uModificar.getPresupuesto()}">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="tiempoDisp">Tiempo
									disponible</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="tiempoDisp"
										id="tiempoDisp"
										value="${uModificar.getTiempo_disponible()}">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="password">Contraseņa</label>
								<div class="control has-icons-left">
									<input type="password" class="input" name="password" id="password"
										value="${uModificar.getPassword()}">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="isActivo">Activo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isActivo" id="isActivo"
										value="${uModificar.getActivo()}" escapeXml="false">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="isAdmin">Administrador</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isAdmin" id="isAdmin"
										value="${uModificar.getEsadmin()}">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<a href="usuarioslist" class="button is-primary">Cancelar</a>
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
var select = document.getElementById('pref');
select.addEventListener('change',
  function(){
    
    console.log(select.selectedIndex); 
 
  });
</script>

<jsp:include page="layout/footer.jsp"></jsp:include>
