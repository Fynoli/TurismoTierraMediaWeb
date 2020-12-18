<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<form class="form" <c:choose> <c:when test="${tipo != null}"> action="tipoatraccionactualizar" </c:when><c:otherwise>action="tipoatraccionalta"</c:otherwise>  </c:choose>method="POST">
							<div class="field">
								<label class="label" for="nombre">Tipo</label>
								<div class="control has-icons-left">
									<input type="text" class="input" name="nombre" id="nombre"
									<c:if test="${tipo != null}"> value="${tipo.getNombre()}" </c:if>
									>
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
									<button type="submit" class="button is-link">Guardar</button>
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
