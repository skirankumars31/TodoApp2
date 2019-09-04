# Build
mvn clean package && docker build -t no.kiran/TodoApp .

# RUN

docker rm -f TodoApp || true && docker run -d -p 8080:8080 -p 4848:4848 --name TodoApp no.kiran/TodoApp 