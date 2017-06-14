package com.fortytwotalents.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fortytwotalents.domain.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class SimpleRestClient {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "findCustomersFallback")
	public List<Customer> findCustomers() {
		Customer[] forNow = restTemplate.getForObject("//customer-service/customers", Customer[].class);
		return Arrays.asList(forNow);
	}

	public List<Customer> findCustomersFallback() {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("Jane", "Doe"));
		return list;
	}

	@HystrixCommand(fallbackMethod = "findCustomerByIdFallback")
	public Customer findCustomerById(String id) {
		return restTemplate.getForObject("//customer-service/customers/{id}", Customer.class, id);
	}

	public Customer findCustomerByIdFallback(String id) {
		return new Customer("Jane", "Doe");
	}
}
