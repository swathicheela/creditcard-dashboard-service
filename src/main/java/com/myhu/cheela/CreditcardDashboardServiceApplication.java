package com.myhu.cheela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@SpringBootApplication
public class CreditcardDashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardDashboardServiceApplication.class, args);
	}

}
