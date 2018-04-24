$(document).ready(function () {

    $('#saveContact').submit(function (e) {

        $.post('/sja/contato/save', $(this).serialize(), function(contato) {
            $('#contactTableResponse').last().append(
                '<tr>' +
                	'<td>' + contato.id + '</td>' +
                    '<td>' + contato.nome + '</td>' +
                '</tr>'
            );
        });

        clearInputs();

        e.preventDefault();
    });

});

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}