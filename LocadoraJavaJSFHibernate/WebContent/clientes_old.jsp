<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora JAVA</title>

<style type="text/css">
table, th, td {
	border: 1px solid black;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>

</head>
<body>

	<h3>Clientes Cadastrados</h3>

	
	<form action="clientes">
	  Nome:<br />
	  <input type="text" name="nome" value=""><br />
	  CPF:<br />
	  <input type="text" name="cpf" value=""><br /><br />
	  <input type="submit" value="Pesquisar">
	</form><br /><br />
	
	<table>
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${listaClientes}" var="cliente">
			<tr>
				<td>${cliente.nome}</td>
				<td>${cliente.cpf}</td>
				<td>${cliente.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p><a href="cadastrar_cliente.html">Cadastrar</a></p>
  <p><a href="index.html">Voltar</a></p>



</body>
</html>