<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de produtos</title>
</head>
<body>
	<h1>Lista de produtos</h1>
	
	<f:view>
		<h:dataTable value="#{produtoHandler.produtos}" var="p" border="1">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome"/>
				</f:facet>
				<h:outputText value="#{p.nome}"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Preço"/>
				</f:facet>
				<h:outputText value="#{p.preco}"/>
			</h:column>
		</h:dataTable>
		<h:form>
			<h:commandLink action="ok" value="Adicionar produto"/>
		</h:form>
	</f:view>
	
</body>
</html>