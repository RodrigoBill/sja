$(document).ready(function(){
	$('#saveCli').submit(function () {
		$.ajax({
			type: "POST",
			url: "saveCliente",
			data: $(this).serialize(),
			success: function(data){
				$('#tableCliente').prepend('<tr><td>' + data +' </td></tr>');
			}
		}).done(function(){
			
		}).fail(function(){
			console.log("Erro Ajax")
		})
	});
})
$(document).ready(function(){
	$('#removeCli').onclick(function (id) {
		$.ajax({
			type: "POST",
			url: "removeCliente",
			data: $('#tabelaCliente').serialize(),
			success: function(){
				
			}
		}).done(function(){
			
		}).fail(function(){
			console.log("Erro Ajax")
		})
	});
	
	clearInput();
})

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}