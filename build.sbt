name := "google-maps"

organization := "net.liftmodules"

version := "0.13-SNAPSHOT"

liftVersion <<= liftVersion ?? "2.5-SNAPSHOT"

liftEdition <<= liftVersion apply { _.substring(0,3) }

name <<= (name, liftEdition) { (n, e) =>  n + "_" + e }

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.10.0", "2.9.1","2.9.2")

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers += "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies <++= liftVersion { v =>
  Seq("net.liftweb" %% "lift-webkit"  % v % "provided" )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq( "javax.servlet" % "servlet-api" % "2.5" % "provided->default" )

publishTo <<= version { _.endsWith("SNAPSHOT") match {
        case true  => Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
        case false => Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
  }
 }

// For local deployment:

credentials += Credentials( file("sonatype.credentials") )

// For the build server:

credentials += Credentials( file("/private/liftmodules/sonatype.credentials") )

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
        <url>https://github.com/SpiralArm/liftmodules-googlemaps</url>
        <licenses>
            <license>
              <name>Apache 2.0 License</name>
              <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
              <distribution>repo</distribution>
            </license>
         </licenses>
         <scm>
            <url>git@github.com:SpiralArm/liftmodules-googlemaps.git</url>
            <connection>scm:git:git@github.com:SpiralArm/liftmodules-googlemaps.git</connection>
         </scm>
         <developers>
            <developer>
              <id>d6y</id>
              <name>Richard Dallaway</name>
              <url>https://github.com/d6y</url>
            </developer>
            <developer>
              <id>jonoabroad</id>
              <name>Jonathan Ferguson</name>
              <url>https://github.com/jonoabroad</url>
            </developer>
         </developers>
 )