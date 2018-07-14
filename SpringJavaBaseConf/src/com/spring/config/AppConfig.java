package com.spring.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.bean.Address;
import com.spring.bean.Person;

@Configuration
public class AppConfig {
	@Bean(name = "person", autowire = Autowire.BY_TYPE)
	public Person getPersonInstance() {
		Person p = new Person();
		p.setName("Basant");
		return p;
	}

	@Bean(name = "address")
	public Address getAddressInstance() {
		Address a = new Address();
		a.setCity("Hydrabad");
		a.setState("Telengana");
		return a;
	}
}
