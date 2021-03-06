package com.jumia.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.jumia.daos")
@EntityScan("com.jumia.entities")
public class PersistenceConfiguration {

}
