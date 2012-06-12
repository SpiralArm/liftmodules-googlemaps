/*
   Copyright 2012 Spiral Arm Ltd

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.package bootstrap.liftmodules
*/
package net.liftmodules.googlemaps
package snippet

import scala.xml._
import net.liftweb.http.{ LiftRules, S }
import net.liftweb.common.Loggable

/**
 * Usage:
 * <div  id="mapCanvas" class="lift:GoogleMaps.map?w=512&h=512&z=17&d=true"></div>
 * 
 * default lat/lng are taken from elements within the page with the id lat and lng.
 *
 */
class GoogleMaps extends Loggable {

  

  private def scriptTags(zoomLevel:Int,draggable:Boolean) = """<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3.4&sensor=false&language=en"></script>
<script type="text/javascript">
  function loadMap() {
   var dlat = $("#lat").val();
   var dlng = $("#lng").val();
   var markers = [{"lat":dlat,"lng":dlng}];    
   var myOptions = {center: new google.maps.LatLng(dlat,dlng),zoom :%s,mapTypeId : google.maps.MapTypeId.ROADMAP};
   var map = new google.maps.Map(document.getElementById(mapId), myOptions);
   for (i = 0; i < markers.length; i++) {
      var marker = new google.maps.Marker({map: map,draggable:%s,position:new google.maps.LatLng(dlat,dlng) });
      google.maps.event.addListener(marker, 'mouseup', function() { markerCallback(marker);});
   }
}
$(window).load(function(){ loadMap();});
</script> """.format(zoomLevel,draggable)
     

  //We only support pixels at the moment. 
  def map = {
     val mapId = "map_canvas"    
     val zoomLevel   = S.attr("z").map(a ⇒ a.toInt).openOr(17)
     val draggable   = S.attr("d").map(a ⇒ a.toBoolean).openOr(true)
     val width  = S.attr("w").map(a ⇒ a.toInt).openOr(341)
     val height = S.attr("h").map(a ⇒ a.toInt).openOr(256)
     <head_merge>{Unparsed(scriptTags(zoomLevel,draggable))}</head_merge>     
     <div id={ mapId } style={ "width:%spx; height:%spx;".format(width, height) }></div>  
  } 
  
  

}

 