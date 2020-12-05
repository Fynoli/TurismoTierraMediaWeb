<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Iniciar sesion</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.css">
<link rel="stylesheet" href="assets/custom.css">
<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

.hero {
	height: 100vh;
	position: relative;
}

.notification {
	padding-top: 20px;
	padding-bottom: 30px;
}

.button {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="hero login-bg">
		<div class="hero-body">
			<div class="columns is-centered">
				<div class="column is-half">
					<div class="notification is-light has-shadow">
						<h1 class="title has-text-centered is-size-2">Iniciar Sesion</h1>
						<figure class="image container is-64x64 rounded">
							<img src="assets/the-fellowship.jpg">
						</figure>
						<form action="login" method="post">
						<div class="field">
							<label class="label">Nombre</label>
							<p class="control has-icons-left has-icons-right">
								<input class="input" type="text" placeholder="Email" name="username"> <span
									class="icon is-small is-left"> <i
									class="fas fa-envelope"></i>
								</span>
							</p>
						</div>
						<div class="field">
							<label class="label">Contraseña:</label>
							<p class="control has-icons-left">
								<input class="input" type="password" placeholder="Password" name="password">
								<span class="icon is-small is-left"> <i
									class="fas fa-lock"></i>
								</span>
							</p>
						</div>
						<a class="button is-info is-rounded is-outlined is-medium">Crear
							Cuenta</a> 
							<button type="submit" class="button is-info is-rounded is-outlined is-medium">Iniciar Sesion</button>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>