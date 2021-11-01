package com.jumia.services;

import java.util.List;

import com.jumia.entities.Customer;

public interface CustomerService {

  List<Customer> findAll();
}
