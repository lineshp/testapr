<!DOCTYPE html>
<html>
  <head>
  <script data-ad-client="ca-pub-2016868213060325" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
      var map;
      var caseInfo ="";
      function initMap() {
    	  var myLatlng = {lat: -25.363, lng: 131.044};
    	   map = new google.maps.Map(
    	            document.getElementById('map'), {zoom: 4, center: myLatlng});
        
        var infoWindow = new google.maps.InfoWindow(
                {content: 'Click the map to get Lat/Lng!', position: myLatlng});
            infoWindow.open(map);

            // Configure the click listener.
            map.addListener('click', function(mapsMouseEvent) {
              // Close the current InfoWindow.
              infoWindow.close();
              var country;
              // Create a new InfoWindow.
              infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
              
              //****************
               var geocoder = new google.maps.Geocoder;
      			geocoder.geocode({'location': mapsMouseEvent.latLng}, function(results, status) {
          if (status === 'OK') {
            if (results[0]) {
            	country = getCountry(results[0].address_components);
            	fetchData(country, infoWindow);
            	// infoWindow.setContent(caseInfo);
                 infoWindow.open(map);
            } else {
              alert('No results found');
            }
          } else {
            alert('Geocoder failed due to: ' + status);
          }
        });
      //**********************
             
            // fetchData(mapsMouseEvent.latLng.lat().toString(), mapsMouseEvent.latLng.lng().toString());
            // infoWindow.setContent(mapsMouseEvent.latLng.lat().toString() +" AND "+ mapsMouseEvent.latLng.lng().toString());
             
            });
      }
     
      
      function getCountry(addrComponents) {
    	    for (var i = 0; i < addrComponents.length; i++) {
    	        if (addrComponents[i].types[0] == "country") {
    	            return addrComponents[i].short_name;
    	        }
    	        if (addrComponents[i].types.length == 2) {
    	            if (addrComponents[i].types[0] == "political") {
    	                return addrComponents[i].short_name;
    	            }
    	        }
    	    }
    	    return false;
    	}
      
      function fetchData(country, infoWindow) {
    	  //totalCount = "2100";
    	  
    	     $.ajax({
                 url: '/countryInfo',
                 type: 'GET',
                 data : { countryName: country },
                 cache: false,
                 dataType : 'json',
                 success: function(rsp){
                    // caseInfo = JSON.stringify(rsp);
                    caseInfo = '<div><p><b>'+rsp.country+'</b></p> <p>Confirmed cases: '+rsp.confirmed+'</p><p style="color:red">Number of Deaths: '+rsp.deaths+'</p>'+
                    '<p style="color:green">Recovered: '+rsp.recovered+'</p></div>';
                     infoWindow.setContent(caseInfo);
                 }
         });
      }
      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCR46YpOlaAx9zfNnk44fEBpRq488Ld7kU&callback=initMap"
    async defer></script>
  </body>
</html>