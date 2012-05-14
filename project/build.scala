import sbt._
import Keys._

object build extends Build {
  val sbtXjc = Project(
    id = "sbt-onejar",
    base = file("."),
    settings = Defaults.defaultSettings ++ ScriptedPlugin.scriptedSettings ++ Seq[Project.Setting[_]](
      organization := "com.github.retronym",
      version := "0.8-THIB",
      sbtPlugin := true,
      scalacOptions in Compile ++= Seq("-deprecation"),
      publishTo := Some(Resolver.sftp(
        "iliaz",
        "scala.iliaz.com"
      ) as ("scala_iliaz_com", Path.userHome / ".ssh" / "id_rsa")),
      publishMavenStyle := true
    )
  )
}
