import sbt._
import sbt.Keys._

object ScalacommonBuild extends Build {

  lazy val scalacommon = Project(
    id = "scala-common",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-common",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
}
