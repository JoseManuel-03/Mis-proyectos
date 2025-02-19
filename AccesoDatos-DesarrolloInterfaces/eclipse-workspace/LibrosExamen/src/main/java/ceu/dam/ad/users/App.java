package ceu.dam.ad.users;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.users.test.Test;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(App.class, args);
		Test ej3 = context.getBean(Test.class);
		ej3.test();
	}
}
