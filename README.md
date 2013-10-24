# Google Maps Lift Module

Starting point for adding a Google map with markers.

## Using this module

1. Include this dependency:

       // For Lift 2.6 (Scala 2.9 and 2.10):
       "net.liftmodules" %% "google-maps_2.6" % "0.13"

       // For Lift 2.5 (Scala 2.9 and 2.10):
       "net.liftmodules" %% "google-maps_2.5" % "0.13"

2. In your application's `Boot.boot`:

       bootstrap.liftmodules.googlemaps.init

# Usage

This module adds a snippet you can use like this:

     <div data-lift="GoogleMaps.map?w=512&h=512&z=17&d=true"></div>

This will include a Google Map with an ID of `#map_canvas`.

The parameters are:

* `w` is the width of the map in pixels (default: 341)
* `h` is the height of the map in pixels (default: 256)
* `z` is the zoom level (default: 17)
* `d` is the draggable flag (default: true)

See [the Google MapOptions reference](https://developers.google.com/maps/documentation/javascript/reference#MapOptions) for more information.

The map centre will be taken from IDs on the page with names of `#lat"` and `#lng`.

