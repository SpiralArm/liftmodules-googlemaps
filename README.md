# google maps Lift Module

Starting point for adding a google map with markers. 

## Using this module

1. Add the following repository to your SBT project file:

    For SBT 0.11:

        resolvers += "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

    For SBT 0.7:

        lazy val liftModulesRelease = "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

2. Include this dependency:

         "net.liftmodules" %% "google-maps" % (liftVersion+"-0.10")    

3. In your application's Boot.boot code:

          bootstrap.liftmodules.googlemaps.init

4. OTHER_STUFF




TODO 

1. find out how to wrapper JS so we don't pollute the global name space. Perhaps look at lift.ajax or something similar 
