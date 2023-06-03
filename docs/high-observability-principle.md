# [High Observability](https://kubernetes.io/blog/2018/03/principles-of-container-app-design/#runtime)

Every container must implement all necessary APIs to help the platform observe and manage the application in the best way possible.

## Application

Application should expose endpoints to expose its runtime properties
Spring Boot is using [Actuator library](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/) to aid the reporting of application's runtime properties

## Platform 

Should help developers and platform operators to monitor application runtime properties
This functionality is platform specific, in general, [Grafana](https://grafana.com/) and [Prometheus](https://prometheus.io/) can be used to harvest application runtime data.
