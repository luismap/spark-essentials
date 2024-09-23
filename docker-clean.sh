#!/bin/bash
# docker rm -f $(docker ps -aq)

#remove container postgresql container
docker ps -a | grep postgres_spark | awk '{print $1}' | xargs docker container rm

#remove volume
docker volume rm docker_local_pg_spark_data