<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section has-bg-map">
	<h2 class="title has-text-centered has-text-warning-light">Crea
		una nueva promoción</h2>

	<div class="container mt-6">

		<div class="columns is-variable is-8">

			<div class="column">
				<div class="card is-smooth">
					<div class="card-header">
						<h2 class="card-header-title subtitle has-text-warning-light">
							Datos de la promoción</h2>
					</div>
					<div class="card-content">
						<form id="formulario" class="form" action="altadepromo" method="POST">

							<div class="field">
								<label class="label has-text-warning-light" for="nombre">Nombre</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
										placeholder="Nombre"> <span
										class="icon is-small is-left"> <i
										class="fas fa-lign-left"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="descripcion">Descripción</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="descripcion"
										id="descripcion" placeholder="Descripcion"> <span
										class="icon is-small is-left"> <i
										class="fas fa-align-left"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label class="label has-text-warning-light" for="costo">Costo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="costo" id="costo"
										placeholder="Costo"> <span
										class="icon is-small is-left"> <i class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="select is-multiple">
								<label class="label has-text-warning-light" for="costo">Atracciones
									incluidas</label> 
								<select onchange="getSeleccionadas()" multiple id="listaatracciones"
									size="5">
									<c:forEach items="${atracciones}" var="a">
										<option value="${a.getId()}"><c:out
												value="${a.getNombre()}" /></option>
									</c:forEach>
								</select>
							</div>
							
							<input id="as" type="text" name="atracciones">
							
							
							<div class="field">
								<label class="label has-text-warning-light" for="isActivo">Activa</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="activo" id="isActivo"
										placeholder="Ingrese 1 para dar el alta o 0 para baja">
									<span class="icon is-small is-left"> <i
										class="fas fa-key"></i>
									</span>
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<a href="atraccionlist" class="button is-primary">Cancelar</a>
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

/*function getSelectedOption(sel) {
	var seleccionadas=[];
	var opt;
    for ( var i = 0, len = sel.options.length; i < len; i++ ) {
        opt = sel.options[i];
        if ( opt.selected === true ) {
            seleccionadas.push(opt.value);
        }
    }
    console.log("seleccionadas "+seleccionadas);
    hidenInput.innerHTML='<input type="text" class="is-invisible" name="seleccionadas" value="'+seleccionadas+'" />';
    return seleccionadas;
}

var boton=document.getElementById("boton");
var hidenInput=document.createElement("input");

boton.addEventListener('click',getSelectedOption(document.getElementById("listaatracciones")))*/

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
