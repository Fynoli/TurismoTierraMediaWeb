<jsp:include page="layout/header.jsp"></jsp:include>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="section">
        <h1 class="title has-text-centered">compra tus atracciones</h1>
    </div>
    <table id="example" class="display table is-hoverable">
        <thead class="thead">
            <tr>
                <th>nombre</th>
                <th>Tipo</th>
                <th>Descripción</th>
                <th>Costo</th>
                <th>Tiempo</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
var data = <c:out value="${atracciones}"/>



var dataTest =[['Mordor','Aventura','null','25','3.0'], ['Moria','Aventura','null','10','2.0'], ['Bosque Negro','Aventura','null','3','4.0']]
	$('#example').DataTable( {
	    data: dataTest
	} );
</script>


	
 
<jsp:include page="layout/footer.jsp"></jsp:include>