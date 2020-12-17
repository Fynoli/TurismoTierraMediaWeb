<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section">
	<h2 class="title has-text-centered">Crea un nuevo usuario</h2>

	<div class="container mt-6">

		<div class="columns is-variable is-8">

			<div class="column">
				<div class="card">
					<div class="card-header">
						<h2 class="card-header-title subtitle">
							Datos del usuario</h2>
					</div>
					<div class="card-content">
						<form class="form" action="usuariocrear" method="POST">
							<div class="field">
								<label class="label" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
										placeholder="Ingrese su nombre">
									<span class="icon is-small is-left"> <i
										class="fas fa-user"></i>
									</span>
								</div>
							</div>
							<div class="field">
                                <label class="label" for="tipo">Preferencia</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tipo"
                                           id="tipo" placeholder="Ingrese la id de si preferencia"> <span class="icon is-small is-left">
										<i class="fas fa-map-signs"></i>
									</span>
                                </div>
                            </div>
							<div class="field">
								<label class="label " for="presupuesto">Presupuesto</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="presupuesto"
										id="presupuesto"
										placeholder="Ingrese presupuesto inicial">
									<span class="icon is-small is-left"> <i
										class="fas fa-coins"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="tiempo">Tiempo
									disponible</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="tiempo"
										id="tiempoDisp"
										placeholder="Ingrese el tiempo disponible inicial">
									<span class="icon is-small is-left"> <i
										class="fas fa-clock"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="password">Contrase�a</label>
								<div class="control has-icons-left">
									<input type="password" class="input" name="password" id="password"
										placeholder="Ingrese la contrase�a">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="isActivo">Activo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isActivo" id="isActivo"
										placeholder="Ingrese 1 para usuario activo o 0 para inactivo">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="isAdmin">Administrador</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="isAdmin" id="isAdmin"
										placeholder="Ingrese 1 para usuario admin o 0 para inactivo">
									<span class="icon is-small is-left"> <i
										class="fas fa-users-cog"></i>
									</span>
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<a href="usuarioslist" class="button is-primary">Cancelar</a>
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

<script>
var select = document.getElementById('pref');
select.addEventListener('change',
  function(){
    
    console.log(select.selectedIndex); 
 
  });
</script>

<jsp:include page="layout/footer.jsp"></jsp:include>
