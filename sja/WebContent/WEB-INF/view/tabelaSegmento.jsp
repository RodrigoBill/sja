<table class="table tr">
	<thead>
		<tr>
			<th>SEGMENTO</th>
			<th>DATA_SEGMENTO</th>
			<th>ORIGEM</th>
			<th>DESTINO</th>
			<th>VOO</th>
			<th>CIA</th>
			<th>CLASSE</th>
			<th>HORA_CHEGADA</th>
			<th>HORA_SAIDA</th>
			<th>LOCALIZADOR</th>
			<th>REMOVER</th>
		</tr>
	</thead>
	<c:forEach items="${segmentos}" var="segmento">
		<tr>
			<td>${segmento.segmento}</td>
			<td><fmt:formatDate value="${segmento.dataSegmento.time}"
					pattern="dd/MM/yyyy" /></td>
			<td>${segmento.origem}</td>
			<td>${segmento.destino}</td>
			<td>${segmento.voo}</td>
			<td>${segmento.cia}</td>
			<td>${segmento.classe}</td>
			<td><fmt:formatDate value="${segmento.horaChegada.time}"
					pattern="dd/MM/yyyy" /></td>
			<td><fmt:formatDate value="${segmento.horaSaida.time}"
					pattern="dd/MM/yyyy" /></td>
			<td>${segmento.localizador}</td>
			<td><a href="removeSegmento?segmento=${segmento.segmento}">Remover</a></td>
		</tr>
	</c:forEach>
</table>