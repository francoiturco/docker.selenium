FROM openjdk:19-jdk-slim

# Workspace
WORKDIR /usr/share/udemy

# ADD .jars under the target location from host into this image.
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs  

# ADD suite files
ADD book-flight-module.xml              book-flight-module.xml
ADD search-module.xml                   search-module.xml

# Variables: BROWSER, HUB_HOST and MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST $MODULE