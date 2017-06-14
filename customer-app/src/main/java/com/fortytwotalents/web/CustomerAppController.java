package com.fortytwotalents.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fortytwotalents.client.SimpleRestClient;
import com.fortytwotalents.domain.Customer;

@Controller
public class CustomerAppController {

	@Autowired
	private SimpleRestClient restClient;

	@GetMapping(path = "/")
	public String index() {
		return "redirect:/customers";
	}

	@GetMapping(path = "/customers")
	public @ResponseBody List<Customer> findCustomers() {
		return restClient.findCustomers();
	}

	@GetMapping(path = "/customers/{id}")
	public @ResponseBody Customer findCustomerById(@PathVariable String id) {
		return restClient.findCustomerById(id);
	}

}
