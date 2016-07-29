name := "crawler_akka"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-actor" % "2.4.8",
"com.typesafe.akka" %% "akka-agent" % "2.4.8",
"com.typesafe.akka" %% "akka-camel" % "2.4.8",
"com.typesafe.akka" %% "akka-cluster" % "2.4.8",
"com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.8",
"com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.8",
"com.typesafe.akka" %% "akka-cluster-tools" % "2.4.8",
"com.typesafe.akka" %% "akka-contrib" % "2.4.8",
"com.typesafe.akka" %% "akka-http-core" % "2.4.8",
"com.typesafe.akka" %% "akka-http-testkit" % "2.4.8",
"com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.8",
"com.typesafe.akka" %% "akka-osgi" % "2.4.8",
"com.typesafe.akka" %% "akka-persistence" % "2.4.8",
"com.typesafe.akka" %% "akka-persistence-tck" % "2.4.8",
"com.typesafe.akka" %% "akka-remote" % "2.4.8",
"com.typesafe.akka" %% "akka-slf4j" % "2.4.8",
"com.typesafe.akka" %% "akka-stream" % "2.4.8",
"com.typesafe.akka" %% "akka-stream-testkit" % "2.4.8",
"com.typesafe.akka" %% "akka-testkit" % "2.4.8",
"com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-typed-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-http-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-http-jackson-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-http-xml-experimental" % "2.4.8",
"com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.8"
)
libraryDependencies += "org.avaje.ebeanorm" % "avaje-ebeanorm" % "7.20.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"
val crawler_akka = (project in file(".")).enablePlugins(PhantomJs)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "2.4.15" % "test",
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.1.0"
)

javaOptions ++= PhantomJs.setup(baseDirectory.value)
// https://mvnrepository.com/artifact/com.github.klieber/phantomjs-maven-core
libraryDependencies += "com.github.klieber" % "phantomjs-maven-core" % "0.7"


