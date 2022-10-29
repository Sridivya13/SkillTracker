package com.skillTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@EnableAutoConfiguration
public class SkillTrackerApplication {


	public static void main(String[] args) {
		SpringApplication.run(SkillTrackerApplication.class, args);
	}


}
