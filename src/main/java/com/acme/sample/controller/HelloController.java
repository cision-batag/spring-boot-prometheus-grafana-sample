package com.acme.sample.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final String METRIC_NAME = "TEST_SOURCE";
    private static final String TEST_API_COMPONENT = "test.api";

    private static Counter testApiSuccessfulResponses = Metrics.counter(METRIC_NAME,
            "SERVICE_NAME", TEST_API_COMPONENT,
            "RESULT", "response_success");
    private static Counter testApiErrors = Metrics.counter(METRIC_NAME,
            "SERVICE_NAME", TEST_API_COMPONENT,
            "RESULT", "response_errors");

    @GetMapping("/hello")
    public String sayHello() {
        testApiSuccessfulResponses.increment();
        return "hello";
    }

    @GetMapping("/error")
    public String sayError() {
        testApiErrors.increment();
        return "error";
    }
}
