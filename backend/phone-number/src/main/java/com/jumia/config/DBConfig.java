package com.jumia.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

  private static final String PASSWORD = "spring.datasource.password";

  private static final String USER = "spring.datasource.username";

  private static final String URL = "spring.datasource.url";

  private static final String DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getProperty(DRIVER_CLASS_NAME));
    dataSource.setUrl(environment.getProperty(URL));
    dataSource.setUsername(environment.getProperty(USER));
    dataSource.setPassword(environment.getProperty(PASSWORD));
    return dataSource;
  }
}
