<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
	<h1 class="title has-text-centered">Usuarios disponibles</h1>
</div>
<table id="example" class="display table">
	<thead class="thead">
		<tr>
			<th>Nombre</th>
			<th>Preferencia</th>
			<th>Presupuesto</th>
			<th>Tiempo Disponible</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	var data = <c:out value="${usuarios}" escapeXml="false"/>;

	$('#example').DataTable({
		data : data,
		order: [],
		columns : [			    
			{data : 'Nombre',}, 
			{data : 'Preferencia',}, 
			{data : 'Presupuesto', render : function(data, type, row) {return data + ' <img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">';}}, 
			{data : 'Tiempo Disponible', render : function(data, type, row) {return data + ' Hs';}}
		]
	});
</script>




<jsp:include page="layout/footer.jsp"></jsp:include>