FROM mozilla/sbt as build

COPY ./app /tmp/app
COPY ./project /tmp/project
COPY ./conf /tmp/conf
COPY ./build.sbt /tmp/build.sbt

RUN sbt universal:packageZipTarball

VOLUME /data/images
FROM openjdk:oraclelinux8
ARG USERNAME=1
ARG GROUP=1

RUN useradd -g $GROUP $USERNAME

WORKDIR /home/$USERNAME

COPY --from=build /tmp /home/$USERNAME

ENTRYPOINT ["java", "-Dplay.http.secret.key=head -c 32 /dev/urandom | base64"]

