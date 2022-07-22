lazy val root = project
  .in(file("."))
  .settings(
    name := "fibonacci-sbt",
    organization := "pl.tomaszgigiel",
    version := "1000-SNAPSHOT",
    scalaVersion := "3.1.2",
    scalacOptions := Seq(
      "-indent",
      "-new-syntax",
      "-explain"),
    licenses := List("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.7.0",
      "org.typelevel" %% "cats-effect" % "3.4-389-3862cf0",
      "org.apache.commons" % "commons-collections4" % "4.4",
      "commons-io" % "commons-io" % "2.11.0",
      "org.apache.commons" % "commons-lang3" % "3.12.0",
      "org.tpolecat" %% "doobie-core" % "1.0.0-RC2",
      "org.tpolecat" %% "doobie-h2" % "1.0.0-RC2",
      "org.tpolecat" %% "doobie-hikari" % "1.0.0-RC2",
      "org.tpolecat" %% "doobie-scalatest" % "1.0.0-RC1" % Test,
      "org.freemarker" % "freemarker" % "2.3.31",
      "org.openjdk.jmh" % "jmh-core" % "1.35",
      "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.35",
      "org.junit.jupiter" % "junit-jupiter" % "5.8.2" % Test,
      "org.apache.logging.log4j" % "log4j-core" % "2.18.0",
      "org.apache.logging.log4j" % "log4j-api" % "2.18.0",
      "ch.qos.logback" % "logback-classic" % "1.2.11",
      "org.projectlombok" % "lombok" % "1.18.22" % Provided,
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
      "org.scalatest" %% "scalatest" % "3.2.11" % Test,
      "edu.stanford.nlp" % "stanford-corenlp" % "4.4.0",
      "com.typesafe" % "config" % "1.4.2",
      "org.zeroturnaround" % "zt-zip" % "1.15"
    ),
    Compile / mainClass := Some("pl.tomaszgigiel.fibonacci.ScalaApp"),
    assembly / assemblyJarName := s"${name.value}-uberjar.jar",
    assembly / assemblyMergeStrategy := {
      case PathList(ps@_*) if ps.last == "module-info.class" => MergeStrategy.discard
      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    }
  )
