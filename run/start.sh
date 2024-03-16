#./mvnw clean install -T80 &&
./mvnw package &&
docker-compose -f run/docker-compose.yml up

