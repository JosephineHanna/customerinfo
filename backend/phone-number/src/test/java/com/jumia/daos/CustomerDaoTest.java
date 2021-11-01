package com.jumia.daos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jumia.entities.Customer;

@DataJpaTest
public class CustomerDaoTest {

  @Autowired
  private CustomerDao customerDao;

  @BeforeEach
  public void setUp() {
    Customer customer1 = new Customer(1, "(212) 698054317", "Yosaf Karrouch", "Morocco", "Valid");
    Customer customer2 = new Customer(2, "(258) 8237476181", "Chou", "Mozambique", "Not Valid");
    List<Customer> customers = Arrays.asList(customer1, customer2);

    customerDao.saveAll(customers);
  }

  @Test
  public void testFindAll() {
    List<Customer> customers = customerDao.findAll();
    assertEquals(2, customers.size());
  }

  @AfterEach
  public void clearDB() {
    customerDao.deleteAll();
  }
}
