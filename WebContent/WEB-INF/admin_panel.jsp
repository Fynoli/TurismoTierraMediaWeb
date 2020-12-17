<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<section class="section columns ">
    <aside class="aside column is-3 ">
        <nav class="panel is-primary">
            <p class="panel-heading">
                Administracion
            </p>


            <a class="panel-block" href="usuarioslist">
                  <span class="panel-icon">
                    <i class="fas fa-user" aria-hidden="true"></i>
                  </span>
                Usuarios
            </a>
            <a class="panel-block"  href="atraccionlist">
                  <span class="panel-icon">
                    <i class="fas fa-map-signs" aria-hidden="true"></i>
                  </span>
                Atracciones
            </a>
            <a class="panel-block"  href="tipoatraccionlist">
                  <span class="panel-icon">
                    <i class="fas fa-star" aria-hidden="true"></i>
                  </span>
                Categoria de atracciones
            </a>
            <a class="panel-block" href="listadepromo">
                  <span class="panel-icon">
                    <i class="fas fa-box" aria-hidden="true"></i>
                  </span>
                Promociones
            </a>

        </nav>
    </aside>