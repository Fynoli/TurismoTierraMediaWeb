<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
	<h1 class="title has-text-centered">Compra tus actividades</h1>
</div>
<div class="has-text-centered">
	Te restan:
	<c:out value="${usuario.getPresupuesto()}" />
	<img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">
	y
	<c:out value="${usuario.getTiempo_disponible()}" />
	Hs. disponibles.
</div>
<table id="example" class="display table">
	<thead class="thead">
		<tr>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Descripción</th>
			<th>Costo</th>
			<th>Tiempo</th>
			<th>Cupo</th>
			<th>Compra</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	var data = <c:out value="${productos}" escapeXml="false"/>;

	$('#example')
			.DataTable(
					{
						data : data,
						order : [],
						columns : [
								{
									data : 'Nombre',
								},
								{
									data : 'Tipo',
								},
								{
									data : 'Descripcion',
								},
								{
									data : 'Costo',
									render : function(data, type, row) {
										return data
												+ ' <img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">';
									}
								},
								{
									data : 'Tiempo',
									render : function(data, type, row) {
										return data + ' Hs';
									}
								},
								{
									data : 'Cupo',
								},
								{
									"defaultContent" : "<a href='realizarcompra?Id=`${data.Id}`&Tipo=`${data.Tipo}`' class='button is-link'> Comprar</a>"
								} ]
					});
</script>




<jsp:include page="layout/footer.jsp"></jsp:include>