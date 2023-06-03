# Use an official AdoptOpenJDK 17 runtime as a parent image
FROM gradle:7.3.3-jdk17 as build

# Create a non-root user
RUN addgroup --system myuser && adduser --system myuser --ingroup myuser

# Set the working directory to /workspace/app
WORKDIR /workspace/app

# Change the ownership of the copied files
RUN chown -R myuser:myuser /workspace/app

# Copy only the necessary files
COPY . /workspace/app

# Download dependencies and build application
RUN ./gradlew --no-daemon clean build --stacktrace

# Use a specific version for the final image
FROM openjdk:17-jdk-slim

# Create a non-root user
RUN addgroup --system myapp && adduser --system myapp --ingroup myapp

# Create the /app directory and change its ownership
RUN mkdir /app && chown -R myapp:myapp /app

# Create the /mnt/data directory and change its ownership
RUN mkdir /mnt/data && chown -R myapp:myapp /mnt/data

WORKDIR /app

# Copy only the necessary files
COPY --from=build --chown=myapp:myapp /workspace/app/build/libs/springboot-docker-0.0.1-SNAPSHOT.jar /app

# Expose the application port
EXPOSE 8080

# Mount the /mnt/data directory with read and write access to user myapp
VOLUME /mnt/data
RUN chown -R myapp:myapp /mnt/data

# Run as a non-privileged user
USER myapp

# Define the command to run the application when the container starts
CMD ["java", "-jar", "/app/springboot-docker-0.0.1-SNAPSHOT.jar"]
