# 使用OpenJDK 19作为基础镜像
FROM openjdk:19-jdk-alpine

# 设置工作目录
WORKDIR /app

# 复制pom.xml和maven的设置文件到工作目录
COPY pom.xml /app
COPY src/main/resources/mapper/mapper.xml /app/src/main/resources/mapper/mapper.xml

# 复制项目的源代码到工作目录
COPY src /app/src

# 使用Maven构建项目
RUN apk add --no-cache maven && mvn -f /app/pom.xml clean package

# 暴露应用运行的端口（假设Spring Boot应用运行在8080端口）
EXPOSE 8080

# 运行生成的jar文件
CMD ["java", "-jar", "/app/target/你的应用名.jar"]
