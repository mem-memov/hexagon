ThisBuild / organization := "net.mem-memov"
ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file(".")).settings(
  name := "hexagon",
  resolvers += "Sonatype Repository for net.mem-memov" at "https://s01.oss.sonatype.org/content/repositories/snapshots",
  libraryDependencies ++= Seq(
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.3.12",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.3.12",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.3.12",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,


    "net.mem-memov" %% "bingjvm" % "0.0.0+16-368859c9-SNAPSHOT"
  )
)
