<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo produto</title>
</head>
<body>
	<h1>Novo produto</h1>
	
	<f:view>
		<h:messages/>
		<h:form>
			Nome: <h:inputText value="#{produtoHandler.produto.nome}"/><br>
			Preço: <h:inputText value="#{produtoHandler.produto.preco}"/><br>
			
			<h:commandButton value="Salvar" action="#{produtoHandler.adiciona}"/>
		</h:form>
	</f:view>
	
</body>
</html>