<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section has-bg-map">
    <h2 class="title has-text-centered has-text-warning-light">Crea una nueva atracción</h2>

    <div class="container mt-6">

        <div class="columns is-variable is-8">

            <div class="column">
                <div class="card is-smooth">
                    <div class="card-header">
                        <h2 class="card-header-title subtitle has-text-warning-light">
                            Crear Atracción
                        </h2>
                    </div>
                    <div class="card-content">
                        <form class="form" action="atraccioncrear" method="POST">

                            <div class="field">
                                <label class="label has-text-warning-light" for="nombre">Nombre</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="nombre" id="nombre" placeholder="Nombre">
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="descripcion">Descripción</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="descripcion" id="descripcion" placeholder="Descripcion">
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="costo">Costo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="costo"
                                           id="costo" placeholder="Costo"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="tiempo">Tiempo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tiempo"
                                           id="tiempo"placeholder="Tiempo"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="cupo">Cupo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="cupo"
                                           id="cupo" placeholder="Cupo"> <span class="icon is-small is-left">
										<i class="fas fa-key"></i>
									</span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label has-text-warning-light" for="isActivo">Activo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="isActivo"
                                           id="isActivo" placeholder="Ingrese 1 para dar el alta"> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label has-text-warning-light" for="tipo">Tipo de Atracción</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tipo"
                                           id="tipo" placeholder="Ingrese el id en numero por ahora"> <span class="icon is-small is-left">
										<i class="fas fa-user"></i>
									</span>
                                </div>
                            </div>

                            <div class="field is-grouped">
                                <div class="control">
                                    <a href="atraccionlist" class="button is-primary">Cancelar</a>
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
