<jsp:include page="layout/header.jsp"></jsp:include>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <ul>
 Hola antonio
 <c:forEach items="${atracciones}" var="atraccion" >
 <li><c:out value="${atraccion.getNombre()}"></c:out>
 </c:forEach>
 </ul>
	
 
<jsp:include page="layout/footer.jsp"></jsp:include>