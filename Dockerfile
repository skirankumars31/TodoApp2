FROM airhacks/glassfish

# TODO - Use the wildfly docker container

COPY ./target/TodoApp.war ${DEPLOYMENT_DIR}
