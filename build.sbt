name := "phantom-dsl-example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

organization := "org.zouzias"

resolvers ++= Seq(
  "Confluent" at "http://packages.confluent.io/maven/"
)

val phantom = "2.1.3"
val util = "0.28.3"

libraryDependencies ++= {
  Seq(
    "com.typesafe" % "config" % "1.2.1",
    "com.outworkers" %% "phantom-dsl" % phantom,
    "com.outworkers" %% "util-testing" % util
  )
}

assemblyMergeStrategy in assembly := {
  case "META-INF/io.netty.versions.properties" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

