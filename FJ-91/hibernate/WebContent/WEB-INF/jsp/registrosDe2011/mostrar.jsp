<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<body>
		<h1>Lista de transacoes do ano de 2011</h1>
		<ul>
		<c:forEach items="${transacoes}" var="t">
			<li><fmt:formatDate value="${t.data.time}" pattern="dd/MM/yyyy"/> - ${t.tipoDeTransacao} - ${t.valor}</li>
		</c:forEach>
		</ul>
	</body>
</html>