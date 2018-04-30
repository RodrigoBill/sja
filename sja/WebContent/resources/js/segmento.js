$(document).ready(function () {
	$('#saveSeg').submit(function () {
		$.ajax({
			type: "POST",
			url: "saveSegmento",
			data: $(this).serialize(),
			success: function(data){
				$('#tabelaSegmento').prepend('<tr><td>' + data +' </td></tr>');
			}
		}).done(function(){
			
		}).fail(function(){
			console.log("Erro Ajax")
		})
	});
})

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}