import sbt._
import sbt.Keys._
import Dependency._

lazy val scalikedb = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "scalikedb",
    fork in run := true,
    libraryDependencies ++= Seq(
      filters,
      guice,
      jdbc,
      evolutions,
      "org.scalatestplus.play" %% "scalatestplus-play"           % "4.0.1" % Test,
    ) ++ dbModule
      ++ Seq(
      "com.dripower"           %% "play-circe"                   % "2611.0"
    )
  )

name := "scalikedb"

version := "0.1"

scalaVersion := "2.12.9"
