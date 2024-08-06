package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return ("Satyam");
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		return new Person("Shivam", 25, new Address("Mohali", "Punjab"));
	}
	
//	What if one bean is depending on other beans??
//	Two ways to tackle this =>
	
//	First Way through method calls
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
//	Second way by passing the values as parameters.
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
//		Here we are doing auto wiring, to create one bean we are injecting other beans
//		Basically we are sending other beans in the parameters.
		return new Person(name, age, address2);
	}
	
	@Bean
	public Person person4Parameters(String name, int age, @Qualifier("UserAddressPreference") Address address) {
		return new Person(name ,age, address);
	}
	
	@Bean(name = "address1")
	@Primary
	public Address address() {
		return new Address("SpiceGardenLayout", "Bangalore");
	}
	
	@Bean(name = "address2")
	@Qualifier("UserAddressPreference")
	public Address address3() {
		return new Address("Shardanagar Road", "Lakhimpur Kheri");
	}

}
