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

val dbModule = Seq(
  "org.scalikejdbc"        %% "scalikejdbc"                  % scalikejdbcVersion,
  "org.scalikejdbc"        %% "scalikejdbc-config"           % scalikejdbcVersion,
  "org.scalikejdbc"        %% "scalikejdbc-jsr310"           % scalikejdbcVersion,
  "org.scalikejdbc"        %% "scalikejdbc-play-initializer" % "2.7.1-scalikejdbc-3.3",
  "org.scalatestplus.play" %% "scalatestplus-play"           % "4.0.1" % Test,
  "com.h2database"         %  "h2"                           % "1.4.192",
  // https://mvnrepository.com/artifact/org.postgresql/postgresql
  "org.postgresql" % "postgresql" % postgresVersion,
  // https://mvnrepository.com/artifact/mysql/mysql-connector-java
  "mysql" % "mysql-connector-java" % mysqlVersion
)
