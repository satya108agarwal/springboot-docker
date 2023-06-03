# Building Container images using Dockerfile

This cook book recipe will guide you through the steps to create a Docker image of a Spring Boot application using Dockerfile


## Building the Docker Image


Clone the Git repository that contains the Dockerfile and the Spring Boot application code:

```shell
git clone <repository_url>
```

### Change the directory to the root of the project:

```bash
cd springboot-docker
```

### Build the Docker image using the following command:

```bash
docker build -t <image_name>:<tag> .

```
Replace <image_name> with the name you want to give to the Docker image and <tag> with a version number or tag.

### Example:

```shell
docker build -t myapp:1.0 .
```

## Running the Docker Image
### To run the Docker image, use the following command:

```bash
docker run -p <host_port>:<container_port> <image_name>:<tag>
```

Replace <host_port> with the port number on your host machine that you want to map to the container port, <container_port> with the port number on which the Spring Boot application is listening inside the container, <image_name> with the name of the Docker image you built in the previous step, and <tag> with the tag you specified.

Example:
```shell
docker run -p 8080:8080 myapp:1.0
```

This will start the container and expose the Spring Boot application at http://localhost:8080 on your host machine.

Notes:

```bash
docker build -t springboot-dockerfile .
docker run -p 8080:8080 springboot-dockerfile

```