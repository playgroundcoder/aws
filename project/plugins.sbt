// Assembly plugin
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")
// Needed for scalatest, scalactic
//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")
// Check scala source coding style
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "1.0.0")
// Check java source coding style
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.1.1")
// Scala code coverage plugin
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.4")
