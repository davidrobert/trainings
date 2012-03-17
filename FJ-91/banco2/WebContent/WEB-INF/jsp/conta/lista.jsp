<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<h1>Lista contas</h1>
	
	<form>
		<select name="ano">
			<option value="2011">2011</option>
			<option value="2010">2010</option>
			<option value="2009">2009</option>
			<option value="2008">2008</option>
		</select>
		<input type="submit">
	</form>
	
	<c:if test="${not empty iterable}">
	<table border="1">
		<thead>
			<tr>
				<th>Número</th>
				<th>Titular</th>
				<th>Saldo atual</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${iterable}" var="conta">
				<tr>
					<td>${conta.numero}</td>
					<td>${conta.titular.nome}</td>
					<td>${conta.saldo}</td>
					<td><a href="visualiza?numero=${conta.numero}">Ir para conta</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	
	<c:if test="${empty iterable}">
		<em>Não há contas adicionadas.</em>
	</c:if>
	
	<p><a href="formulario">Nova conta</a></p>
</html>