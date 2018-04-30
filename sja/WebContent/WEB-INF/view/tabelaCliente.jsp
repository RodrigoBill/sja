<table id="tableCliente" class="table tr">
	<thead>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>Remover</th>
		</tr>
	</thead>
	<c:forEach items="${contatos}" var="contato">
		<tr>
			<td>${contato.id}</td>
			<td>${contato.nome}</td>
			<td><a href="removeCli?${contato.id}" id="removeCli">Remover</a></td>
		</tr>
	</c:forEach>

</table>