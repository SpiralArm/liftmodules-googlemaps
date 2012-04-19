function loadMap() {
   
   var myOptions = {center: new google.maps.LatLng(markers[0].lat,markers[0].lng),zoom : 16,mapTypeId : google.maps.MapTypeId.ROADMAP};

   console.log("map id ", mapId);
   
   var map = new google.maps.Map(document.getElementById(mapId), myOptions);
   
   for (i = 0; i < markers.length; i++) {

      console.log("marker",markers[i]);

      var marker = new google.maps.Marker({map: map,draggable:draggable,position:new google.maps.LatLng(markers[i].lat,markers[i].lng) });
    
      google.maps.event.addListener(marker, 'mouseup', function() { markerCallback(marker);});
   }

}
console.log("call loadMap");
$(window).load(function(){ loadMap();});
