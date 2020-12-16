<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
	<h1 class="title has-text-centered"><c:out value="${usuario.getNombre()}" escapeXml="false"/>, este es tu itinerario para el día de hoy.</h1>
</div>
<table id="example" class="display table">
	<thead class="thead">
		<tr>
			<th>Producto</th>
			<th>Tipo</th>
			<th>Descripción</th>
			<th>Costo</th>
			<th>Tiempo</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	var data = <c:out value="${itinerarios}" escapeXml="false"/>;
	$('#example')
			.DataTable(
					{
						data : data,
						order : [],
						columns : [
								{
									data : 'producto',
								},
								{
									data : 'tipo',
								},
								{
									data : 'descripcion',
								},
								{
									data : 'costo',
									render : function(data, type, row) {
										return data
												+ ' <img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">';
									}
								}, {
									data : 'tiempo',
									render : function(data, type, row) {
										return data + ' Hs';
									}
								} ]
					});
</script>
<div class="has-text-centered">
	Te restan:
	<c:out value="${usuario.getPresupuesto()}" />
	<img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">
	y
	<c:out value="${usuario.getTiempo_disponible()}" />
	Hs. disponibles.
	</div>
	<div class="has-text-centered">
		<a href="compra" class="button is-success">Comprar mas actividades!</a>
	</div>


<jsp:include page="layout/footer.jsp"></jsp:include>
