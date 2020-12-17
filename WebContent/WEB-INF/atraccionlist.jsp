<jsp:include page="admin_panel.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="container column is-9 has-text-right">
    <a class="button is-link" href="atraccioncrear">Crear una nueva</a>

    <table id="example" class="display table">
        <thead class="thead">
        <tr>
            <th>Nombre</th>
            <th>Tipo de Atracci�n</th>
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
</div>
</section>
<script
        src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
    var data = <c:out value="${atracciones}" escapeXml="false"/>;

    $('#example').DataTable(
            {data : data,
                order : [],
                columns : [
                    {data : 'Nombre',},
                    {data : 'Tipo',},

                    {data : 'Costo',
                        render : function(data, type, row) {
                            return '<img width="20" height="20" align="left" src="https://i.ibb.co/gWZdQbP/MonedaME.png">'+data;
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
        window.location.href="./atraccionactualizar?id="+data.Id
        console.log(data);
    });
    
    var table = $('#example').DataTable()
    $(document).on('click', '#buttonEliminar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./atraccionbaja?id="+data.Id
        console.log(data);
    });
    
    var table = $('#example').DataTable()
    $(document).on('click', '#buttonLevantar', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./atraccionaltalogica?id="+data.Id
        console.log(data);
    });

</script>






<jsp:include page="layout/footer.jsp"></jsp:include>