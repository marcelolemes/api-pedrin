docker-compose -f run/docker-compose.yml down
docker network prune --force
docker container prune --force
./mvnw clean

