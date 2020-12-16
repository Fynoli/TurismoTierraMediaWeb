<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section has-bg-map">
    <h2 class="title has-text-centered has-text-warning-light">Edita esta atracción</h2>

    <div class="container mt-6">

        <div class="columns is-variable is-8">

            <div class="column">
                <div class="card is-smooth">
                    <div class="card-header">
                        <h2 class="card-header-title subtitle has-text-warning-light">
                            Modificar Atracción
                        </h2>
                    </div>
                    <div class="card-content">
                        <form class="form" action="atraccionactualizar" method="POST">
                            <input name="id" id="id" value="${atraccion.getId()}" hidden>
                            <div class="field">
                                <label class="label has-text-warning-light" for="nombre">Nombre</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="nombre" id="nombre" value="${atraccion.getNombre()}">
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="descripcion">Descripción</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="descripcion" id="descripcion" value="${atraccion.getDescripcion()}">
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="costo">Costo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="costo"
                                           id="costo" value="${atraccion.getCosto()}"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="tiempo">Tiempo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tiempo"
                                           id="tiempo" value="${atraccion.getTiempo()}"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="cupo">Cupo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="cupo"
                                           id="cupo" value="${atraccion.getCupo()}"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="isActivo">Activo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="isActivo"
                                           id="isActivo" value="${atraccion.getActivo()}"> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="tipo">Tipo de Atracción</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tipo"
                                           id="tipo" value="${atraccion.getTipos_atraccion().getId()}"> <span class="icon is-small is-left">
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
