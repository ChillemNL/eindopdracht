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

function fillListActivities(ulId, categorieId="-1"){
    //categorieId = categorieId || "-1";
    var url ='';
    if (categorieId == "-1"){
        url='/activiteit_ophalen';
    } else {
        url='/activieit_ophalen_per_categorie/' + categorieId;
    }
    AjaxCall(url, null).done(function (response) {
        $(ulId).children().remove();
        var s ="";
               for (var i = 0; i < response.length; i++) {
                   console.log(response[i].id);
                   s+='<li>'+
                   '<button class="accordion-control">' + response[i].naamActiviteit + ' - ' + response[i].naamOrganisatie +'</button>'+
                   '<div class="accordion-panel"><button value="'+ response[i].id +'" class="accButton">Aanpassen</button>'+
                   '<button value="'+ response[i].id +'" class="accButton" style="background-color: red;border-color: red;color: white;">Verwijderen</button>'+
                   '</div>' +
                   '</li>'
               }
               $(ulId).html(s);
       }).fail(function (error) {
            alert(error.StatusText);
        });
}