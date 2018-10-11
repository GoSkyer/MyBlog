#server
server:
  port: 9001

spring:
  application:
    name: blog-service
  datasource:
      druid:
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost/blog?characterEncoding=utf-8
        username: root
        password: root

eureka:
  instance:
    instance-id: blog-service
    prefer-ip-address: true
  client:
    register-with-eureka: true
    fetch-registry: false
    service-url:
      defaultZone: http://127.0.0.1:9000/eureka/

pagehelper:
  helperDialect: mysql
  reasonable: true
  supportMethodsArguments: true
  params: count=countSql
