#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:3.5.2:create \
        -DprojectGroupId=org.agoncal.course.quarkus.orm \
        -DprojectArtifactId=customer \
        -DpackageName="org.agoncal.quarkus.jpa" \
        -Dextensions="jdbc-mariadb, hibernate-orm"