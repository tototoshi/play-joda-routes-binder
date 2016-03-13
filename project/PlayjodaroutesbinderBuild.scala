import sbt._
import sbt.Keys._

object PlayjodaroutesbinderBuild extends Build {

  lazy val playjodaroutesbinder = Project(
    id = "play-joda-routes-binder",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "play-joda-routes-binder",
      organization := "com.github.tototoshi",
      version := "1.1.0-SNAPSHOT",
      crossScalaVersions := Seq("2.11.8", "2.10.5"),
      scalaVersion := "2.11.8",
      scalacOptions ++= Seq("-feature", "-deprecation"),
      resolvers ++= Seq(
        "typesafe" at "http://repo.typesafe.com/typesafe/releases"
      ),
      libraryDependencies ++= Seq(
        "com.typesafe.play" %% "play" % "2.4.0" % "provided",
        "com.typesafe.play" %% "play-test" % "2.4.0" % "test",
        "org.scalatest" %% "scalatest" % "2.2.4" % "test"
      )
    ) ++ publishingSettings
  )

  val publishingSettings = Seq(
    publishMavenStyle := true,
    publishTo <<= version { (v: String) => _publishTo(v) },
    publishArtifact in Test := false,
    pomExtra := _pomExtra
  )

  def _publishTo(v: String) = {
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }

  val _pomExtra =
    <url>http://github.com/tototoshi/play-joda-routes-binder</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:tototoshi/play-joda-routes-binder.git</url>
      <connection>scm:git:git@github.com:tototoshi/play-joda-routes-binder.git</connection>
    </scm>
    <developers>
      <developer>
        <id>tototoshi</id>
        <name>Toshiyuki Takahashi</name>
        <url>http://tototoshi.github.com</url>
      </developer>
    </developers>


}
