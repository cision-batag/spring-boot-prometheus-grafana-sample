# spring-boot-prometheus-grafana-sample

This is a sample for monitoring spring boot web application
by using [Prometheus](https://prometheus.io/) and [Grafana](https://grafana.com/).

## How to run

You must install docker (via Rancher Desktop),
and docker-compose, and execute the following command:

```bash
docker-compose up -d
``` 

Three applications are going to start.

Application                 | URL
--------------------------- |----------------------
Spring Boot Web Application | http://localhost:8080
Prometheus                  | http://localhost:9090
Grafana                     | http://localhost:3000
InfluxDB                    | http://localhost:8086

Prometheus monitors Spring Boot Application.
Grafana visualizes prometheus data source.

InfluxDB is added to check compatibility with Grafana 8.

# Set up Prometheus data source

You can login to Grafana by `admin/admin`.
You set up prometheus data source as follows.

Item           | Value
-------------- | -----
Type           | Prometheus
URL            | http://prometheus:9090

# Set up Prometheus data source

You can login to Grafana by `admin/admin`.
You set up prometheus data source as follows.

Item           | Value
-------------- | -----
Type           | InfluxDB
URL            | http://influxdb:8086
Database       | _internal
User/password  | admin/admin

# Set up graph

Refer to [Prometheus documenatation](https://prometheus.io/docs/introduction/overview/)
and [Grafana documentation](http://docs.grafana.org/). 

# JMeter

JMeter is used to call endpoints to generate test data for `TEST_SOURCE` metrics.
