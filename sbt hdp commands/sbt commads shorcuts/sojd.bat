cls
sbt "set offline:=true" clean compile test jacoco:cover -jvm-debug 10000
