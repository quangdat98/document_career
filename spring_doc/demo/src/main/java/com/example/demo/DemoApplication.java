package com.example.demo;

import com.example.demo.beandemo.BeanPrototype;
import com.example.demo.beandemo.BeanSingleton;
import com.example.demo.eventHandling.OrderService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

/*	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("--------- Singleton ---------");
		BeanSingleton singleton1 = context.getBean(BeanSingleton.class);
		BeanSingleton singleton2 = context.getBean(BeanSingleton.class);
		System.out.println("Singleton instance: " + (singleton1 == singleton2)); //true

		System.out.println("--------- Prototype ---------");
		BeanPrototype prototype1 = context.getBean(BeanPrototype.class);
		BeanPrototype prototype2 = context.getBean(BeanPrototype.class);
		System.out.println("Prototype khác instance: " + (prototype1 != prototype2)); //true


	}*/
public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
}
	private final OrderService orderService;

	public DemoApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void run(String... args) throws Exception {
		orderService.createOrder("123");
	}
}
