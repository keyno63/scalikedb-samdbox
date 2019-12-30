import sbt._
import sbt.Keys._

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
    ) ++ Seq(
      "org.scalikejdbc"        %% "scalikejdbc"                  % scalikejdbcVersion,
      "org.scalikejdbc"        %% "scalikejdbc-config"           % scalikejdbcVersion,
      "org.scalikejdbc"        %% "scalikejdbc-jsr310"           % scalikejdbcVersion,
      "org.scalikejdbc"        %% "scalikejdbc-play-initializer" % "2.7.1-scalikejdbc-3.3",
      "org.scalatestplus.play" %% "scalatestplus-play"           % "4.0.1" % Test,
      "com.h2database"         %  "h2"                           % "1.4.192",
      "com.dripower"           %% "play-circe"                   % "2611.0",
      // https://mvnrepository.com/artifact/org.postgresql/postgresql
      "org.postgresql" % "postgresql" % "42.2.8",
      // https://mvnrepository.com/artifact/mysql/mysql-connector-java
      "mysql" % "mysql-connector-java" % "8.0.18"
    )
  )

name := "scalikedb"

version := "0.1"

scalaVersion := "2.12.9"

val scalikejdbcVersion = "2.5.2"