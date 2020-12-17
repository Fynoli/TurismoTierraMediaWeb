<jsp:include page="admin_panel.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="container column is-9  has-text-right">
	<a class="button is-link" href="tipoatraccionalta">Crear tipo nuevo</a>
<table id="example" class="display table">
	<thead class="thead">
		<tr>
			<th>Id</th>
			<th>Activo</th>
			<th>Nombre</th>
			<th>Editar</th>
			<th>Borrar</th>
			
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</div>
</section>

<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	var data = <c:out value="${tipoAtracciones}" escapeXml="false"/>;

	$('#example')
	.DataTable(
			{
				data : data,
				order : [],
				columns : [
				
					{
						data : 'Id',
					},
					{
						data : 'Activo',
					},
						{
							data : 'Nombre',
						},
						
						{
							data : 'Editar',
							render : function(data, type, row) {
								return'<button id="buttonEdit">Editar</button>'
							}
						},
						{
							data : 'Borrar',
							render : function(data, type, row) {
								return '<button id="buttonDelete">Borrar</button>'
							}
						},
				]
			});


	var table = $('#example').DataTable()
	$(document).on('click', '#buttonEdit', function(event) {
		var data = table.row($(this).parents("tr")).data();
		event.preventDefault()
		window.location.href="./tipoatraccionactualizar?id="+data.Id
	
		console.log(data);
		
	//	window.location.replace("usuario_editar?id=" + data.Id);
		
	});
	var table = $('#example').DataTable()
	$(document).on('click', '#buttonDelete', function(event) {
		var data = table.row($(this).parents("tr")).data();
		
		
		var txt;
		var r = confirm("Esta seguro de eliminar?");
		if (r == true) {
			event.preventDefault()
			window.location.href="./TipoAtraccionBaja?id="+data.Id
		} else {
		  txt = "You pressed Cancel!";
		}
		
		
	
		console.log(data.Id);
		
	//	window.location.replace("usuario_editar?id=" + data.Id);
		
	});
	
	
	
		
</script>






<jsp:include page="layout/footer.jsp"></jsp:include>