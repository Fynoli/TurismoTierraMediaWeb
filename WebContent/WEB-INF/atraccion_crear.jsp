<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section">
    <h2 class="title has-text-centered">Crea una nueva atracci�n</h2>

    <div class="container mt-6">
        <div class="columns is-variable is-8">

            <div class="column">
                <div class="card">
                    <div class="card-header">
                        <h2 class="card-header-title subtitle">
                            Datos de la Atracci�n
                        </h2>
                    </div>
                    <div class="card-content">
                        <form class="form" <c:choose> <c:when test="${atraccion == null}">action="atraccioncrear"</c:when><c:otherwise>action="atraccionactualizar"</c:otherwise> </c:choose>method="POST">

                            <div class="field">
                                <label class="label" for="nombre">Nombre</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="nombre" id="nombre" placeholder="Nombre"
                                    <c:if test="${atraccion != null}">value="${atraccion.getNombre()}"</c:if> >
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-align-left"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label" for="descripcion">Descripci�n</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="descripcion" id="descripcion" placeholder="Descripcion"
                                           <c:if test="${atraccion != null}">value="${atraccion.getDescripcion()}"</c:if>>
                                    <span class="icon is-small is-left"> <i
                                            class="fas fa-align-left"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label" for="costo">Costo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="costo"
                                           id="costo" placeholder="Costo"
                                           <c:if test="${atraccion != null}">value="${atraccion.getCosto()}"</c:if>> <span class="icon is-small is-left">
										<i class="fas fa-coins"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label" for="tiempo">Tiempo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="tiempo"
                                           id="tiempo"placeholder="Tiempo"
                                           <c:if test="${atraccion != null}">value="${atraccion.getTiempo()}"</c:if>> <span class="icon is-small is-left">
										<i class="fas fa-clock"></i>
									</span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label" for="cupo">Cupo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="cupo"
                                           id="cupo" placeholder="Cupo"
                                           <c:if test="${atraccion != null}">value="${atraccion.getCupo()}"</c:if>> <span class="icon is-small is-left">
										<i class="fas fa-users"></i>
									</span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label" for="isActivo">Activo</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="isActivo"
                                           id="isActivo" placeholder="Ingrese 1 para dar el alta"
                                           <c:if test="${atraccion != null}">value="${atraccion.getActivo()}"</c:if>> <span class="icon is-small is-left">
										<i class="fas fa-check"></i>
									</span>
                                </div>
                            </div>
                            <div class="field">
                                <div class="control">
                                    <label class="label" for="listatipo">Tipo de atracción</label>
                                <div class="select">
                                    <select onchange="getTipo()" id="listatipo">
                                        <c:forEach items="${tipos}" var="t">
                                            <option value="${t.getId()}"><c:out
                                                    value="${t.getNombre()}" /></option>
                                        </c:forEach>
                                    </select>
                                <input id="ts" type="text" name="tiposeleccionado" value="${atraccion.getTipos_atraccion().getId()}" hidden>
                                </div>
                                </div>
                            </div>
                            <c:if test="${atraccion != null}">
                                <input name="id" id="id" value="${atraccion.getId()}" hidden>

                            </c:if>
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
<script type="text/javascript">

    var lista = document.getElementById("listatipo");
    var seleccionada=1;
    function getTipo(){
        seleccionada=lista.selectedIndex+1;
        console.log(seleccionada);
        var ts=document.getElementById("ts");
        ts.value=seleccionada;
    }


</script>



<jsp:include page="layout/footer.jsp"></jsp:include>
