val playVersion = "2.6.0"

val scalaVersion_2_11 = "2.11.8"
val scalaVersion_2_12 = "2.12.2"

lazy val `play-joda-routes-binder` = project
  .in(file("."))
  .settings(publishSettings)
  .settings(
    name := "play-joda-routes-binder",
    organization := "com.github.tototoshi",
    version := "1.2.0",
    scalaVersion := scalaVersion_2_12,
    crossScalaVersions := Seq(scalaVersion_2_12, scalaVersion_2_11),
    scalacOptions ++= Seq("-feature", "-deprecation"),
    resolvers ++= Seq(
      "typesafe" at "http://repo.typesafe.com/typesafe/releases"
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % playVersion % "provided",
      "com.typesafe.play" %% "play-test" % playVersion % "test",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )

val publishSettings = Seq(
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
  <url>https://github.com/tototoshi/play-joda-routes-binder</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
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
      <url>https://tototoshi.github.io</url>
    </developer>
  </developers>

