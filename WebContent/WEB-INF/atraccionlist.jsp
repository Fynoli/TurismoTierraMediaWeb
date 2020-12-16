<jsp:include page="layout/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="section">
    <h1 class="title has-text-centered">Listado de Atracciones</h1>
</div>
<table id="example" class="display table">
    <thead class="thead">
    <tr>
        <th>Nombre</th>
        <th>Tipo de Atraccion</th>
        <th>Costo</th>
        <th>Tiempo</th>
        <th>Cupo</th>
        <th>Accion</th>
        <th>Boton</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

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
                    {data : 'Accion',
                        render : function(data, type, row) {
                            return '<a href="atraccionbaja">Eliminar</a>'
                        }
                    },
                    {data : 'Boton',
                        render : function(data, type, row) {
                            return '<button id="button">Editar</button>'
                        }
                    }, ]
            });

    var table = $('#example').DataTable()
    $(document).on('click', '#button', function(event) {
        var data = table.row($(this).parents("tr")).data();
        event.preventDefault()
        window.location.href="./atraccionactualizar?id="+data.Id


        console.log(data);

        //	window.location.replace("usuario_editar?id=" + data.Id);

    });

</script>






<jsp:include page="layout/footer.jsp"></jsp:include>