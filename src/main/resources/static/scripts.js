var request = new XMLHttpRequest()
request.open('GET', 'http://localhost:8888/categorie/all', true)
request.onload = function() {
  // Begin accessing JSON data here
  var data = JSON.parse(this.response)

  var element = document.getElementById("categorie");


  if (request.status >= 200 && request.status < 400) {
    data.forEach(categorie => {
      var option = document.createElement("option");
      option.value = categorie.id;
      option.text = categorie.naamCategorie;
      element.add(option);
    })
  } else {
    console.log('error')
  }
}

request.send()