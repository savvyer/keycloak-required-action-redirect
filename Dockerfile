# Use an openjdk image as the base image
FROM maven

# Set the working directory in the container to /app
WORKDIR /app

# Copy the current folder contents into the container at /app
COPY pom.xml /app/
COPY src /app/src

# Build and install the project using Maven
RUN mvn -B clean verify

CMD cp -R ./target/* ./output
