# Creating a Docker Image with Spring Boot and Gradle

This cook book recipe will guide you through the steps to create a Docker image of a Spring Boot application using Gradle and the `com.google.cloud.tools.jib` plugin. The `jib` plugin provides an easy way to build optimized Docker images without requiring a Dockerfile.

## Prerequisites

Before you start, make sure you have the following prerequisites installed:

- Java 17 or later
- Gradle 7.0 or later
- Docker installed and running

## Introduction to Jib Plugin 

Jib Gradle Plugin is a plugin for Gradle, a popular build automation tool for Java applications. Jib Gradle Plugin provides a simple and efficient way to build container images for Java applications, without requiring a Dockerfile or any knowledge of Docker.

With Jib Gradle Plugin, developers can easily build and deploy container images to a container registry, such as Docker Hub or Google Container Registry. Jib Gradle Plugin uses a layered approach to containerization, which allows for fast and efficient updates, and provides reproducible builds that can be consistently built across different environments and machines.

Jib Gradle Plugin supports a variety of container platforms, including Docker and Kubernetes, and allows for customizing container properties such as entry points, labels, and environment variables. Jib Gradle Plugin also provides built-in support for common Java frameworks and libraries, such as Spring Boot and Maven.

Overall, Jib Gradle Plugin simplifies the containerization process for Java developers, and provides a fast and efficient way to build and deploy container images for Java applications.

## Docker Layers
Jib Gradle Plugin uses a layered approach to containerization. Each layer is built and stored separately in the container registry, which allows for faster and more efficient updates. Jib Gradle Plugin creates two types of layers:

### Application layers:
These layers contain the application code and its dependencies. They are created dynamically during the build process, based on the application's Gradle dependencies.

### Base image layers: 
These layers contain the base image and any additional dependencies that are required for the container runtime environment. They are cached and reused across multiple builds to speed up the build process.

Jib Gradle Plugin also supports configuring layer properties, such as layer names, labels, and entry points, to provide greater control over the final Docker image.

## Create a Spring Boot Application

Create a new Spring Boot application using the [Spring Initializr](https://start.spring.io/). Select the following options:

- Project type: **Gradle Project**
- Language: **Java**
- Spring Boot version: **3.0.5**
- Group: **com.vmw.rpm**
- Artifact: **springboot-docker**
- Packaging: **Jar**
- Java version: **17**

Download the generated project and extract the files.

## Configure the `jib` Plugin

In the `build.gradle` file of your project, add the `jib` plugin to the `plugins` block:

```groovy
plugins {
    id 'com.google.cloud.tools.jib' version '3.2.0'
}
```
Then, configure the jib plugin by adding the following block to the build.gradle file:

```groovy
jib {
    from {
        image = 'adoptopenjdk:11-jre-hotspot'
    }
    to {
        image = 'your-registry/your-repo'
        tags = ['latest']
    }
}

```
In the from block, specify the base image for your Docker image. In this example, we are using the AdoptOpenJDK JRE 17 image. You can replace this with any other base image that you want to use.

In the to block, specify the name of the Docker image that you want to create. Replace your-registry and your-repo with the name of your Docker registry and repository.

## Build and Push the Docker Image
To build the Docker image, run the following command:

```shell
./gradlew jibDockerBuild
```

This will build a Docker image of your Spring Boot application