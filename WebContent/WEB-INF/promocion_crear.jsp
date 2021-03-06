<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section">
	<h2 class="title has-text-centered">Crea
		una nueva promoci�n</h2>

	<div class="container mt-6">

		<div class="columns is-variable is-8">

			<div class="column">
				<div class="card">
					<div class="card-header">
						<h2 class="card-header-title subtitle">
							Datos de la promoci�n</h2>
					</div>
					<div class="card-content">
						<form id="formulario" class="form" <c:choose><c:when test="${promo==null}">action="altadepromo"</c:when>  <c:otherwise>   action="cambiodepromo" </c:otherwise></c:choose> method="POST">

							<div class="field">
								<label class="label" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
										placeholder="Nombre"
										<c:if test="${promo != null}">
										   value='${promo.getNombre()}'
											</c:if>> <span
										class="icon is-small is-left"> <i
										class="fas fa-align-left"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="descripcion">Descripci�n</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="descripcion"
										id="descripcion" placeholder="Descripcion" <c:if test="${promo != null}">
										   value='${promo.getDescNoHTML()}'
									</c:if>> <span
										class="icon is-small is-left"> <i
										class="fas fa-align-left"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label" for="costo">Costo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="costo" id="costo"
										placeholder="Costo" <c:if test="${promo != null}">
										   value='${promo.getCosto()}'
									</c:if>> <span
										class="icon is-small is-left"> <i class="fas fa-coins"></i>
									</span>
								</div>
							</div>

							<div class="select is-multiple">
								<label class="label" for="costo">Atracciones
									incluidas</label> 
								<select onchange="getSeleccionadas()" multiple id="listaatracciones"
									size="5">
									<c:forEach items="${atracciones}" var="a">
										<option value="${a.getId()}"><c:out
												value="${a.getNombre()}" /></option>
									</c:forEach>
								</select>
							</div>
							
							<input id="as" type="text" name="atracciones" hidden>
							
							
							<div class="field">
								<label class="label" for="isActivo">Activa</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="activo" id="isActivo"
										placeholder="Ingrese 1 para dar el alta o 0 para baja" <c:if test="${promo != null}">
										   value='${promo.getActivo()}'
									</c:if>>
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<a href="listadepromo" class="button is-primary">Cancelar</a>
								</div>
								<div class="control">
									<button id="boton" type="submit" class="button is-link">Guardar</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
</section>

<script type="text/javascript">

var lista = document.getElementById("listaatracciones");
var seleccionadas=[];
function getSeleccionadas(){
	seleccionadas=[];
	for ( var i = 0, len = lista.selectedOptions.length; i < len; i++ ) {
        seleccionadas.push(lista.selectedOptions[i].index);
    }
	var as=document.getElementById("as");
	as.value=seleccionadas;
}



</script>

<jsp:include page="layout/footer.jsp"></jsp:include>
