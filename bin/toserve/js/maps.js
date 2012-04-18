/**
   Expect: 
   1. variable mapId defining the map element Id.
   2. array of marker objects 
   3. callback function for mouse up if a marker is dragged. 
   4. boolean variable defining if markers should be draggable or not.

*/
   function loadMap() {
   
   var myOptions = {
      zoom : 16,
      mapTypeId : google.maps.MapTypeId.ROADMAP
   };

   console.log("map id ", mapId)
   var map = new google.maps.Map(document.getElementById(mapId), myOptions);
   
   for (i = 0; i < markers.length; i++) {

      console.log("marker",markers[i]);

      var marker = new google.maps.Marker({map: map,draggable:draggable,position:new google.maps.LatLng(markers[i].lat,markers[i].lng) });
    
      google.maps.event.addListener(marker, 'mouseup', function() { markerCallback(marker);});
   }

}

$(window).load(function(){ loadMap();});


      