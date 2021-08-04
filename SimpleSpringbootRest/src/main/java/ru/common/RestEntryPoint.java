package ru.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestEntryPoint
{
	public static void main(String[] args)
	{
		SpringApplication.run(RestEntryPoint.class, args);
	}

	@GetMapping("/hello")
	public String hello(String request) {
		return "Свой сериализуемый объект";
	}
}
