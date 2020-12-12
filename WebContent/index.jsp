<jsp:include page="WEB-INF/layout/header.jsp"></jsp:include>
    <section class="section has-bg-map">
        <h2 class="title has-text-centered has-text-warning-light">Explora un fantástico mundo!</h2>
        
        <div class="container mt-6">
           <div class="columns is-variable is-8">
               <div class="column">
                  
                <div class="card is-smooth">
                    <div class="card-header">
                        <h2 class="card-header-title subtitle">La aventura te espera.</h2>
                    </div>
                    <div class="card-content">
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
                                    <a href="/" class="button is-primary">Crear cuenta</a>
                                </div>
                                <div class="control">
                                    <button type="submit" class="button is-link">Inciar</button>
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
   