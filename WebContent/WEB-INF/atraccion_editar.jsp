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
                            Modificar Atraccion
                        </h2>
                    </div>
                    <div class="card-content">
                        <form class="form" action="atraccionactualizar" method="POST">
                            <input name="id" id="id" value="<c:out value="${atraccion.getId()}" escapeXml="false" />" hidden>
                            <div class="field">
                                <label class="label has-text-warning-light" for="nombre">Nombre</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="nombre" id="nombre" value=<c:out value="${nombre}" />>
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="descripcion">Descripcion</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="descripcion" id="descripcion" value=<c:out value="${atraccion.getDescripcion()}" escapeXml="false" />>
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="costo">Costo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="costo"
                                           id="costo" value=<c:out value="${atraccion.getCosto()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="tiempo">Tiempo
                                    Disponible</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tiempo"
                                           id="tiempo" value=<c:out value="${atraccion.getTiempo()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="cupo">Cupo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="cupo"
                                           id="cupo" value=<c:out value="${atraccion.getCupo()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="isActivo">Activo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="isActivo"
                                           id="isActivo" value=<c:out value="${atraccion.getActivo()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="tipo">Tipo de Atraccion</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tipo"
                                           id="tipo" value=<c:out value="${atraccion.getTipos_atraccion().getId()}" escapeXml="false" />> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field is-grouped">
                                <div class="control">
                                    <a href="atraccionlist" class="button is-primary">Cancelar</a>
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
