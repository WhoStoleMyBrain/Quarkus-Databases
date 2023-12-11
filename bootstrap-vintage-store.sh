#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:3.5.2:create \
        -DprojectGroupId=org.agoncal.course.quarkus.orm \
        -DprojectArtifactId=vintage-store \
        -DpackageName="org.agoncal.quarkus.panache" \
        -Dextensions="jdbc-postgresql, hibernate-orm-panache"