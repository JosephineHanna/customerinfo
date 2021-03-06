package com.jumia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.daos.CustomerDao;
import com.jumia.entities.Customer;
import com.jumia.enums.CountryCode;
import com.jumia.enums.CountryCodeRegex;
import com.jumia.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  @Override
  public List<Customer> findAll() {
    List<Customer> customerList = customerDao.findAll();
    for (Customer customer : customerList) {
      setCountry(customer);
      isValidPhoneNumer(customer);
    }
    return customerDao.findAll();
  }

  private void setCountry(Customer customer) {
    String phone = customer.getPhone();
    String code = phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));
    CountryCode countryCode = CountryCode.getEnumByValue(code);
    customer.setCountry(countryCode.name().toLowerCase());
  }

  private void isValidPhoneNumer(Customer customer) {
    String country = customer.getCountry();
    String regex = CountryCodeRegex.valueOf(country.toUpperCase()).getRegex();
    String state = customer.getPhone().matches(regex) ? "Valid" : "Not Valid";
    customer.setState(state);
  }

}
