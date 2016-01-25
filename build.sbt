name := "phantom-dsl-example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

organization := "org.zouzias"

resolvers ++= Seq(
  "Confluent" at "http://packages.confluent.io/maven/",
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
  "Twitter Repository"               at "http://maven.twttr.com",
  Resolver.bintrayRepo("websudos", "oss-releases")
)

val PhantomVersion = "1.21.2"


libraryDependencies ++= {
  Seq(
    "com.typesafe"                   % "config"                  % "1.2.1",
    "com.websudos"                   %% "phantom-dsl"            % PhantomVersion,
    "com.websudos"                   %% "phantom-testkit"        % "1.12.2" % "test, provided"
  )
}

assemblyMergeStrategy in assembly := {
  case "META-INF/io.netty.versions.properties" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

