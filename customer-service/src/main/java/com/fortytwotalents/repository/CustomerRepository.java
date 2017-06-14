package com.fortytwotalents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortytwotalents.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}