# sampleApp
This is a sample application for movie search. This uses h2 in memory db for storing data and angular for UI and 
REST Services are implemented using Spring.
## Pre requisites
-Java 8+
-maven 3+
-node js
-npm
-angular cli
## Setup
1. Navigate to moviedbsearch directory and do a maven clean install
  mvn clean install
2. navigate to the newly created target directory adn run the movie dbsearch jar file
  java -jar moviedbsearch-0.0.1.jar
3. navigate to moviedbloadbalancer directory and do a clean install
  mvn clean install
4 navigate to the newly created target directory in moviedbloadbalancer directory and run the moviedbloadbalancer jar file
  java -jar  moviedbloadbalancer-0.0.1.jar
5. navigate to moviedbloadbalancerclient directory and do a clean install
  mvn clean install
6. navigate to the newly created target directory in moviedbloadbalancerclient directory and run the moviedbloadbalancerclient jar file
  java -jar  moviedbloadbalancerclient-0.0.1.jar 
7. navigate to moviedb-angular-ui and run npm install
    npm install
8. Once install completes run the ui application
    npm run local
9. The application can be accessed at http://localhost:4200

