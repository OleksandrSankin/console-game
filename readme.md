##How to build

mvn clean package

##How to run

java -jar ./target/console-game-1.0-SNAPSHOT-jar-with-dependencies.jar

##How to build and run

mvn clean package && java -jar ./target/console-game-1.0-SNAPSHOT-jar-with-dependencies.jar

##How to build and run it in debug mode

mvn clean package && java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:5005 -jar ./target/console-game-1.0-SNAPSHOT-jar-with-dependencies.jar
