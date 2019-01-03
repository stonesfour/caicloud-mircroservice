# 版本信息
FROM primetoninc/jdk:1.8
MAINTAINER stonesfour "sunshilei@caicloud.io"


# change path to your repo dir
COPY ./caicloud-provider/target/caicloud-provider-0.0.1-SNAPSHOT.jar  /caicloud-provider.jar

EXPOSE 8080

CMD ["java", "-jar", "/caicloud-provider.jar"]
