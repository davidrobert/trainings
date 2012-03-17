<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
	<div>${mensagem}</div>
	<ul>
		<li><a href="/hibernate/gerarBase">Gerar 1 milhao de registros</a></li>
		<li><a href="/hibernate/relatorio/hibernate-puro">200.000 registros sem Cursor (Hibernate)</a></li>
		<li><a href="/hibernate/relatorio/hibernate-cursor">200.000 registros com Cursor (Hibernate)</a></li>
		<li><a href="/hibernate/relatorio/jdbc">200.000 registros com Cursor (JDBC)</a></li>
		<li><a href="/hibernate/aumentarValorTransacoes/batch">Aumentar 10% dos valores das transacoes (batch update)</a></li>
		<li><a href="/hibernate/aumentarValorTransacoes/puro">Aumentar 10% dos valores das transacoes (objeto por objeto)</a></li>
		<li>
			<a href="/hibernate/registrosDe2011">Mostrar registros de 2011</a>
			<br/>
			Para habilitar o cache, descomente as linhas:
			<ul>
				<li>No arquivo Transacao.java: <pre>@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)</pre></li>
				<li>No arquivo RegistrosDe2011:<pre>criteria.setCacheable(true);</pre></li>
			</ul>
		</li>
	</ul>
</body>
</html>