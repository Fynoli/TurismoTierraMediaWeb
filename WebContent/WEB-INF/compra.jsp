<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
	<h1 class="title has-text-centered">Compra tus atracciones</h1>
</div>
<table id="example" class="display table">
	<thead class="thead">
		<tr>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Descripcion</th>
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
	var data = <c:out value="${atracciones}" escapeXml="false"/>;

	$('#example').DataTable({
		data : data,
		columnDefs: [
		    { orderable: false, targets: 0 }
		  ],
		columns : [			    
			{
			data : 'Nombre',
			orderable: false
		}, {
			data : 'Tipo',
			orderable: false
		}, {
			data : 'Descripcion',
			orderable: false
		}, {
			data : 'Costo',
			orderable: false,
			render : function(data, type, row) {
				return data + ' Monedas';
			}
		}, {
			data : 'Tiempo',
			orderable: false,
			render : function(data, type, row) {
				return data + ' Hs';
			}
		} ]
	});
</script>




<jsp:include page="layout/footer.jsp"></jsp:include>