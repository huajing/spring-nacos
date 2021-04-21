# nacos 使用

### 1.加入Jar
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-alibaba-nacos-discovery</artifactId>
        <version>0.2.1.RELEASE</version>
    </dependency>

### 2.加入启动注释
@EnableDiscoveryClient

### 3.配置地址
    spring:
      cloud:
        nacos:
          discovery:
            server-addr: 127.0.0.1:8848
      application:
        name: nacos-zuul #不指定无法注册到nacos上