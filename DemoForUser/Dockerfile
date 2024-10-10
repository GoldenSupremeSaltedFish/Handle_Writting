# 第一步：构建Spring Boot应用
FROM maven:3.8.6-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 第二步：构建最终镜像
FROM openjdk:19-jre-slim
WORKDIR /app

# 复制构建的jar文件
COPY --from=builder /app/target/your-springboot-app.jar app.jar

# 安装MySQL客户端
RUN apt-get update && apt-get install -y mysql-client

# 设置环境变量
ENV MYSQL_ROOT_PASSWORD="0000"
ENV MYSQL_DATABASE=Humphrey
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD="0000"

# 使用docker-entrypoint.sh启动
COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh

# 暴露Spring Boot应用端口
EXPOSE 8080

# 启动Spring Boot应用
ENTRYPOINT ["sh", "/usr/local/bin/docker-entrypoint.sh"]
#需要在此处修改路径，并且添加sh文件确保docker可以正常运行
