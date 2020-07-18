name := """Gregory Smith Website"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
    .enablePlugins(PlayScala)
    .settings(
        name := "Gregory Smith Website",
        version := "2.8.x",
        scalaVersion := "2.11.12",
        libraryDependencies ++= Seq(
          jdbc,
          cache,
          ws,
          "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
          "io.getquill" %% "quill-jdbc" % "3.2.0"
          //"com.typesafe.play" %% "play-mailer" % "7.0.1",
          //"com.typesafe.play" %% "play-mailer-guice" % "7.0.1"
          //,"org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % "test"
        )
    )
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )
