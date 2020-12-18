<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
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
				<th>Descripci�n</th>
				<th>Costo</th>
				<th>Tiempo</th>
				<th>Cupo</th>
				<th>Compra</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<div class="has-text-centered section">
	<a href="itinerariousuario" class="button is-success">Ver Itinerario</a>
</div>

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
												+ ' <img width="20" height="20" align="right" src="https://i.ibb.co/gWZdQbP/MonedaME.png">';
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
									"defaultContent" : '<button class="button is-link" id="buttonComprar">Comprar</button>'
								} ]
					});
	
	var table = $('#example').DataTable()
	$(document).on('click', '#buttonComprar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault();
        
        
        var hidenform=document.createElement('div');
        hidenform.innerHTML='<form action="realizarcompra" class="is-invisible" id="cp" name="compra" method="post"><input type="text" name="idProducto" value="'+data.Id+'" /><input type="text" name="tipoProducto" value="'+data.Tipo+'" /></form>';
        var ex=document.getElementById("example");
        ex.appendChild(hidenform);
        document.getElementById("cp").submit();
        
        console.log(data);
    });
	

</script>




<jsp:include page="layout/footer.jsp"></jsp:include>