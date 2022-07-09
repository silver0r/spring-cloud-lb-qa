package com.silver0r.apigateway.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.CompletionContext;
import org.springframework.cloud.client.loadbalancer.LoadBalancerLifecycle;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class APILoadBalancerConfig implements LoadBalancerLifecycle {
	@Bean
	public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(
		Environment environment,
		LoadBalancerClientFactory loadBalancerClientFactory
	) {
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
		return new RoundRobinLoadBalancer(
			loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
	}

	@Override
	public void onStart(Request request) {
		log.info("## onStart - request: {}", request);
	}

	@Override
	public void onStartRequest(Request request, Response lbResponse) {
		log.info("## onStartRequest - request: {}, lbResponse: {}", request, lbResponse);

		// TODO want to send serviceInstance ID (in lbResponse) and custom value on request header
	}

	@Override
	public void onComplete(CompletionContext completionContext) {
		log.info("## onComplete - completionContext: {}", completionContext);
	}
}
