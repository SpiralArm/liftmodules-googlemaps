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

/**
 * Usage:
 * <span class="lift:YOURSNIPPET.markers"></span> or your javascript
 * 
 * 
 * <div class="lift:GoogleMaps.mapJs"></div>
 *
 *
 */
class GoogleMaps {

  private val jsPath = "%s/%s/js/maps.js".format(S.contextPath, LiftRules.resourceServerPath)

  val mapId = "map_canvas"

  private val scriptTags = """<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3.4&sensor=false&language=en"></script><script type="text/javascript" src="%s"></script> """.format(jsPath)
     
 
  def mapJs = <head_merge>{Unparsed(scriptTags)}</head_merge>

  //We only support pixels at the moment. 
  def map = {
    val w = S.attr("w").map(a ⇒ a.toInt).openOr(341)
    val h = S.attr("h").map(a ⇒ a.toInt).openOr(256)
    val style = "width:%spx; height:%spx;".format(w, h)

    <div id={ mapId } style={ style }></div>
  }

}

 