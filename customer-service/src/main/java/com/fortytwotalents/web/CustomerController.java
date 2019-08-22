package com.fortytwotalents.web;

import com.fortytwotalents.domain.Customer;
import com.fortytwotalents.repository.CustomerRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostConstruct
    public void createSomeData() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }

    @GetMapping(path = "/")
    public String index() {
        return "redirect:/customers";
    }

    @GetMapping(path = "/customers")
    public @ResponseBody
    List<Customer> findCustomers() {
        return repository.findAll();
    }

    @GetMapping(path = "/customers/{id}")
    public @ResponseBody
    Customer findCustomerById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

}
