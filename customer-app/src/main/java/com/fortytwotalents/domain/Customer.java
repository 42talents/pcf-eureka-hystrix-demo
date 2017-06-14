package com.fortytwotalents.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private String firstName;
	private String lastName;
}