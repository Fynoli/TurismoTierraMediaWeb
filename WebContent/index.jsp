<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- Permite usar etiquetas personalizadas -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
    <link rel="stylesheet" href="assets/custom.css">
    <title>Tierra Media | Home</title>
</head>
<body>
<header class="hero">
    <div class="hero-body has-bg-primary">
        <div class="container is-max-desktop">
            <h1 class="title has-text-warning-dark">Turismo en la Tierra
                media</h1>
        </div>
    </div>
</header>
    <section class="section has-bg-map">
        <h2 class="title has-text-centered has-text-warning-light">Explora un fantástico mundo!</h2>
        
        <div class="container mt-6">
           <div class="columns is-variable is-8">
               <div class="column">
                  
                <div class="card is-smooth has-text-white">
                    <div class="card-header ">
                        <h2 class="card-header-title subtitle has-text-white">La aventura te espera.</h2>
                    </div>
                    <div class="card-content ">
                        <p>Experimenta aventuras nunca antes vistas.</p>
                        <p>Recorre excepcionales paisajes en lugares donde solo los mas habilidosos pueden llegar.</p>
                        <p>Disfruta apetitosos banquetes de la cocina tradicional hobbit</p>
                    </div>
                  </div>

               </div>
               
               <div class="column">
                   <div class="card is-smooth">
                    <div class="card-header">
                        <h2 class="card-header-title subtitle has-text-warning-light">Comienza tu aventura</h2>
                    </div>
                    <div class="card-content">
                        <form class="form" action="login" method="POST">
                            <div class="field">
                                <label class="label has-text-warning-light" for="username">Usuario</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="username" id="username">
                                    <span class="icon is-small is-left">
                                        <i class="fas fa-user"></i>
                                    </span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-warning-light" for="password">contraseña</label>
                                <div class="control has-icons-left">
                                    <input type="password" class="input" name="password" id="password">
                                    <span class="icon is-small is-left">
                                        <i class="fas fa-key"></i>
                                    </span>
                                </div>
                            </div>

                            <div class="field is-grouped">
                                <div class="control">
                                    <button type="submit" class="button is-link">Iniciar sesión</button>
                                </div>
                            </div>
                        </form>
                    </div>
                  </div>
               </div>

           </div>
        </div>
    </section>
    <jsp:include page="WEB-INF/layout/footer.jsp"></jsp:include>
   