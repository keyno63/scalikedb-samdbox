import sbt.librarymanagement.CrossVersion
import sbt._

object Dependency {
  val scalikejdbcVersion = "2.5.2"
  val postgresVersion = "42.2.8"
  val mysqlVersion = "8.0.18"

  val dbModule: Seq[ModuleID] = Seq(
    "org.scalikejdbc"        %% "scalikejdbc",
    "org.scalikejdbc"        %% "scalikejdbc-config",
    "org.scalikejdbc"        %% "scalikejdbc-jsr310"
  ).map(_ % scalikejdbcVersion) ++ Seq(
    "org.scalikejdbc"        %% "scalikejdbc-play-initializer" % "2.7.1-scalikejdbc-3.3",
    "org.scalatestplus.play" %% "scalatestplus-play"           % "4.0.1" % Test,
    "com.h2database"         %  "h2"                           % "1.4.192",
    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    "org.postgresql" % "postgresql" % postgresVersion,
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    "mysql" % "mysql-connector-java" % mysqlVersion
  )

}
