<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="section">
    <h1 class="title has-text-centered">Listado de Promociones</h1>
</div>
<div>
<a class="button is-link" href="altadepromo">Crear una nueva</a>
</div>
<table id="example" class="display table">
    <thead class="thead">
    <tr>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Costo</th>
        <th>Tiempo</th>
        <th>Cupo</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<script
        src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
    var data = <c:out value="${promociones}" escapeXml="false"/>;

    $('#example').DataTable(
            {data : data,
                order : [],
                columns : [
                    {data : 'Nombre',},
                    {data : 'Descripcion',},

                    {data : 'Costo',
                        render : function(data, type, row) {
                            return data
                                + ' <img width="20" height="20" src="https://i.ibb.co/gWZdQbP/MonedaME.png">';
                        }
                    },
                    {data : 'Tiempo',
                        render : function(data, type, row) {
                            return data + ' Hs';
                        }
                    },
                    {data : 'Cupo',},
                    {data : 'Editar',
                        render : function(data, type, row) {
                            return '<button id="buttonEditar">Editar</button>'
                        }
                    },
                    {data : 'Activo',
                        render : function(data, type, row) {
                            if(data==1){
                            	return '<button id="buttonEliminar">Eliminar</button>'
                            }
                            else{
                            	return '<button id="buttonLevantar">Levantar</button>'
                            }
                        }
                    }, ]
            });

    var table = $('#example').DataTable()
    $(document).on('click', '#buttonEditar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./cambiodepromo?id="+data.Id
        console.log(data);
    });
    
    $(document).on('click', '#buttonEliminar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./bajadepromo?id="+data.Id
        console.log(data);
    });
    
    $(document).on('click', '#buttonLevantar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./altalogicapromo?id="+data.Id
        console.log(data);
    });

</script>






<jsp:include page="layout/footer.jsp"></jsp:include>