# Spring cloud config

## Config server can source the properties from 2 sources:
* Local file system (profile = native) 
* External source control

In our case it is github (profile = native).
There are other sources like bitbucket, which are supported as well.

## Spring Boot Actuator:
Spring boot actuator [production ready features](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-enabling).

You can choose to manage and monitor your application by using `HTTP endpoints` or with `JMX`.
`Auditing, health, and metrics gathering` can also be automatically applied to your application.

## Configuration file location:
> CONFIG_FILE_LOCATION=C:/Users/muku3/OneDrive/Desktop/config

### User `@RefreshScope`:
1. Look into `AppConfig` class.
1. Make changes to configuration used by config server.
2. To pick new change made to the configuration file, we need to execute:<br>
   Refresh properties `<HOST>:<PORT>/actuator/refresh`
3. Now application should pick new changes.

