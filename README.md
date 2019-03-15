# Microservices with Spring Boot and Spring Cloud

Demo work for microservices, cloud ready with Spring Cloud

What it has:
- Established Communication between Microservices
- Centralized Microservice Configuration with Spring Cloud Config Server
- Using Spring Cloud Bus to exchange messages about Configuration updates
- Simplified communication with other Microservices using Feign REST Client
- Implemented client side load balancing with Ribbon
- Implemented dynamic scaling using Eureka Naming Server and Ribbon
- Implemented API Gateway with Zuul
- Implemented Distributed tracing with Spring Cloud Sleuth and Zipkin
- Implemented Fault Tolerance with Zipkin


## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
|  |  |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |


## URLs

|     Application       |     URL          |
| ------------- | ------------- |
| Limits Service | http://localhost:8080/limits POST -> http://localhost:8080/actuator/refresh|
|Spring Cloud Config Server| http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev |
|  Currency Converter Service - Direct Call| http://localhost:8100/currency-converter/from/USD/to/TRY/quantity/10|
|  Currency Converter Service - Feign| http://localhost:8100/currency-converter-feign/from/EUR/to/TRY/quantity/10000|
| Currency Exchange Service | http://localhost:8000/currency-exchange/from/EUR/to/TRY http://localhost:8001/currency-exchange/from/USD/to/TRY|
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/TRY http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/TRY/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/refresh |
