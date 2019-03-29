var mymap = L.map('mapid').setView([35.102232, -92.501387],13);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibHJmbHJmIiwiYSI6ImNqdG94bWQwdTQ4Mng0Ym11YW52MWZ5bnEifQ.lZEH9-1FD4H2KYhVZDIe4Q', {
maxZoom: 15,
attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
  '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
  'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
id: 'mapbox.streets'
}).addTo(mymap);

L.marker([35.102232, -92.501387]).addTo(mymap).on('click', onClick);

L.circle([35.102232, -92.501387], {
color: 'blue',
fillColor: '#f03',
fillOpacity: 0.5,
radius: 100
}).addTo(mymap);

L.polygon([
[35.102232, -92.501387]
]).addTo(mymap);

function onClick(e) {
    //alert(this.getLatLng());
    window.location.href = "/testdb";
}