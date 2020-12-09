<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
    <link rel="stylesheet" href="assets/custom.css">
    <title>Tierra Media | Home</title>
</head>
<body>
<% String dbUser= (String) request.getAttribute("dbUser");%>
<% Integer dbPresupuesto= (Integer) request.getAttribute("dbPresupuesto");%>
<% Double dbTiempo= (Double) request.getAttribute("dbTiempo");%>
<% String dbGustos= (String) request.getAttribute("dbGustos");%>
    <header class="hero">
        <div class="hero-body has-background-grey-dark">
            <div class="container is-max-desktop">
                <h1 class="title has-text-warning-dark">Turismo en la Tierra media</h1>
            </div>
        </div>
    </header>
    <section class="section">
            <h1 class="title has-text-centered">Tu perfil</h1>
        <div class="container columns">
            <div class="card column is-half
            is-offset-one-quarter
            ">
            <div class="columns is-flex is-centered">
                <figure class="image is-128x128 ">
                    <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                  </figure>
            </div>
                <div class="card-header">
                  <div class="card-header-title is-centered "><h1 class="title">
                      <%
                          out.print(dbUser);
                      %>
                  </h1></div>
                </div>
                <div class="card-content">
                    <table class="table is-hoverable is-fullwidth">
                        <tr class="tr">
                            <th>Presupuesto</th>
                            <td>
                                <%
                                    out.print(dbPresupuesto);
                                %>
                            </td>
                        </tr>
                        <tr class="tr">
                            <th>Tiempo disponible</th>
                            <td>
                                <% out.print(dbTiempo); %>
                            </td>
                        </tr>
                        <tr class="tr">
                            <th>Preferencia</th>
                            <td>
                                <% out.print(dbGustos);%>
                            </td>
                        </tr>
                    </table>
                    <p class="has-text-centered mb-4">
                        <a href="/itinerario?id={{id que me da Java}} ">Tenes aventuras pendientes!</a>
                    </p>

                    <div class="has-text-centered">
                        <a href="" class="button is-primary">Comprar Atracciones</a>
                    </div>
    
                </div> <!--Fin Card Content-->
            </div><!--FIN CARD-->
        </div>
    </section>
    <footer class="footer has-background-grey-darker has-text-warning-dark">
        <p class="is-copy">Desarrollado por Ctrl+F</p>
    </footer>
    <script defer src="https://use.fontawesome.com/releases/v5.14.0/js/all.js"></script>
</body>
</html>