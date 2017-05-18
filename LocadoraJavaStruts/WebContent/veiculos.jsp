<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle de Veiculos</title>

<style type="text/css">
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


	<h3>Veiculos Cadastrados</h3>

	
<form action="">
		Marca:<br />
		<input type="text" name="marca" value=""><br />
		Tipo:<br />
		<input type="radio" name="tipo" value="Carro" checked> Carro<br />
		<input type="radio" name="tipo" value="Onibus"> Onibus<br /><br />
		<input type="submit" value="Pesquisar">
	</form><br /><br />
	
	
	<table>
		<tr>
			<th>Tipo</th>
			<th>Marca</th>
			<th>Placa</th>
		</tr>
		<c:forEach items="${listaVeiculos}" var="veiculo">
			<tr>
				<td>${veiculo.tipo}</td>
				<td>${veiculo.marca}</td>
				<td>${veiculo.placa}</td>
			</tr>
		</c:forEach>
	</table>
	


	<p>
		<a href="cadastrar_veiculo.html">Cadastrar</a>
	</p>
	<p>
		<a href="index.html">Voltar</a>
	</p>

</body>
</html>
