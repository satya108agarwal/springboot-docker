# Creating Docker Images using cloud native build packs

## Introduction to Cloud Native Buildpacks
Cloud Native Buildpacks use a more granular approach to layering, which is based on analyzing the application's dependencies and breaking them down into smaller layers. Each layer is optimized for caching and reuse, which allows for faster updates and smaller image sizes. Cloud Native Buildpacks create multiple types of layers:


## Prerequisites

Before you start, make sure you have the following prerequisites installed:

- Java 17 or later
- Gradle 7.0 or later
- Docker installed and running
- Pack Cli Installed
- Access to registry which has cloud native build packs 

## Docker layers

### Build layers: 
These layers contain the build-time dependencies, such as compilers and build tools, which are not needed in the final image.

### Cache layers: 
These layers contain the application dependencies that are required at runtime. They are cached and reused across multiple builds to speed up the build process.

### Launch layers: 
These layers contain the runtime dependencies, such as the application server and libraries, which are required to run the application.

## Pros:

Automates the build process: Cloud Native Buildpacks automate the process of building container images, making it easier for developers to create and deploy applications without having to manually configure a Dockerfile or build script.

### Faster build times: 
Cloud Native Buildpacks can be faster than traditional Docker builds because they reuse buildpacks across different applications and builds. This means that common dependencies are only downloaded once and reused in subsequent builds.

### Optimized for Cloud-Native environments: 
Cloud Native Buildpacks are designed specifically for cloud-native environments, which means that they can integrate seamlessly with container orchestration platforms like Kubernetes.

### Improved security:
Cloud Native Buildpacks use a layered approach to building images, which means that only the necessary dependencies are included in each layer, reducing the attack surface for potential security threats.

### Flexibility:
Cloud Native Buildpacks are language-agnostic, which means they can be used for building container images for applications written in various programming languages.

## Cons:

### Limited customization: 
Unlike traditional Dockerfiles, Cloud Native Buildpacks have a limited set of configurable options, which can be a challenge for developers who need more control over the build process.

### Compatibility with some platforms:
While Cloud Native Buildpacks are designed to work with Kubernetes and other cloud-native platforms, they may not be fully compatible with some legacy systems.


## Implementation Steps

```shell

pack build <image_name> --builder paketo-buildpacks/builder:latest --env BP_JVM_VERSION=17 --path <app_directory> 

```
Replace <image_name> with the name you want to give to the Docker image, <app_directory> with the path to the root directory of your Spring Boot application code.

This command will use the latest version of the Paketo builder, set the JVM version to 17, and publish the Docker image to the local Docker daemon.

For example
```shell
pack build springboot-docker --env BP_JVM_VERSION=17 --path .
pack build springboot-docker --builder paketo-buildpacks/builder:latest --buildpack packeto-buildpacks/native-image --env BP_JVM_VERSION=17 --path .
```
# Command to launch the application
```shell
docker run -p 8080:8080 springboot-docker
```

```shell
 pack config default-builder paketobuildpacks/builder:tiny
pack build springboot-docker --env BP_JVM_VERSION=17 --path .
```
