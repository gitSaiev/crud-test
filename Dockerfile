#
ARG BUILD_HOME=/crud-test

#
# Gradle image for the build stage.
#
FROM gradle:jdk17 as build-image

#
# Set the working directory.
#
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

#
# Copy the Gradle config, source code, and static analysis config
# into the build container.
#
COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src

#
# Build the application.
#
RUN gradle --no-daemon build

#
# Java image for the application to run in.
#
FROM openjdk:18

#
# Copy the jar file in and name it app.jar.
#
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/build/libs/crud-test-1.0.jar app.jar

#
# The command to run when the container starts.
#
ENTRYPOINT java -jar app.jar