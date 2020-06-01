function AjaxCall(url, data, type) {
        return $.ajax({
            url: url,
            type: type ? type : 'GET',
            data: data,
            contentType: 'application/json'
        });
    }

function fillDropdownCategorie(dropdownId){
    $('#' + dropdownId + ' option').remove();
    AjaxCall('/categorie/all', null).done(function (response) {
       var s = '<option value="-1">Maak een keuze</option>';
               for (var i = 0; i < response.length; i++) {
                   s += '<option value="' + response[i].id + '">' + response[i].naamCategorie + '</option>';
               }
               $("#"+ dropdownId).html(s);
       }).fail(function (error) {
            alert(error.StatusText);
        });
}

function fillActivitiesAll(){
    AjaxCall('/activiteit_ophalen', null).done(function (response) {
        var s;
               for (var i = 0; i < response.length; i++) {
                   console.log(response[i].id);
                   s+='<li>'+
                   '<button class="accordion-control">' + response[i].id + '</button>'+
                   '<div class="accordion-panel">test</div>' +
                   '</li>'
               }
               $("#activiteiten").html(s);
       }).fail(function (error) {
            alert(error.StatusText);
        });
}