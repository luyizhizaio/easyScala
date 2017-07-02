name := "scala_sth"

version := "1.0"

scalaVersion := "2.10.5"



libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.1"// withSources() exclude("org.slf4j" , "slf4j-api" )

libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.1"// withSources() exclude("org.slf4j" , "slf4j-api" )

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.1" withSources()
    