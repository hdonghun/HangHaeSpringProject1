package com.example.firstproject;

import com.example.firstproject.repository.PostsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
//@EnableJpaRepositories(basePackages = {"com.example.firstproject.repository"})
public class FirstprojectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FirstprojectApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}


	}


