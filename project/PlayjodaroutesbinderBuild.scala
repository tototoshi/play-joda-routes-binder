import sbt._
import sbt.Keys._

object PlayjodaroutesbinderBuild extends Build {

  lazy val playjodaroutesbinder = Project(
    id = "play-joda-routes-binder",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "play-joda-routes-binder",
      organization := "com.github.tototoshi",
      version := "0.1.0",
      scalaVersion := "2.10.0",
      scalacOptions ++= Seq("-feature", "-deprecation"),
      resolvers ++= Seq(
        "typesafe" at "http://repo.typesafe.com/typesafe/releases"
      ),
      libraryDependencies ++= Seq(
        "play" %% "play" % "2.1.0" % "provided",
        "play" %% "play-test" % "2.1.0" % "test",
        "org.scalatest" %% "scalatest" % "1.9.1" % "test"
      )
    )
  )
}
