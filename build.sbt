name := "untitled1"

version := "1.0"

scalaVersion := "2.11.7"
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7"
enablePlugins(GatlingPlugin)
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.6" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.0"
libraryDependencies +=  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2"
