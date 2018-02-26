lazy val akkaHttpVersion = "10.0.11"
lazy val akkaVersion = "2.5.10"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.addmeaning",
      scalaVersion := "2.11.12"
    )),
    name := "Sparkathon Docker Hello",
    version := "1.0",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion
    ),
    dockerBaseImage := "openjdk:jre-alpine",
    dockerRepository := Some("addmeaning"), //your Docker login here
    dockerExposedPorts := Seq(8080)
  ).enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)

