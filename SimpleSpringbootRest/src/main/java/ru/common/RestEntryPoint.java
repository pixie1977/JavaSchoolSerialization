package ru.common;

@SpringBootApplication
@RestController
public class RestEntryPoint
{
	static final String regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{6,}";

	public static void main(String[] args)
	{
		SpringApplication.run(RestEntryPoint.class, args);
	}

	@GetMapping("/checkPassword")
	@CheckPasswordAnnotation(regexp)
	public String hello(String request) {
		return "Свой сериализуемый объект";
	}
}
