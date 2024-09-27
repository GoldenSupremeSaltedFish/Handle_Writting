### Here is a way to start in docker

```

docker run -e REDIS_HOST=your_redis_host \
           -e REDIS_PASSWORD=your_redis_password \
           -e DB_HOST=your_db_host \
           -e DATABASENAME=your_database_name \
           -e DBUSERNAME=your_db_username \
           -e PASSWORD=your_db_password \
           -p 8080:8080 your_docker_image


```

