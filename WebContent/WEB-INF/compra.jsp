<jsp:include page="layout/header.jsp"></jsp:include>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <ul>
 <c:forEach items="${atracciones}" var="atraccion" >
 <li><c:out value="${atraccion.getNombre()}"></c:out>
 <c:out value="${atraccion.getCosto()}"></c:out>
 <c:out value="${atraccion.getTiempo()}"></c:out></li>
 </c:forEach>
 </ul>
	
 
<jsp:include page="layout/footer.jsp"></jsp:include>