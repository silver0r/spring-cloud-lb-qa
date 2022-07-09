package com.silver0r.apigateway.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

@LoadBalancerClients(defaultConfiguration = {LoadBalancerClientConfiguration.class})
@LoadBalancerClient(value = "api", configuration = APILoadBalancerConfig.class)
@Configuration
public class APIGatewayConfig {
}
