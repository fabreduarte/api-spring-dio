package diospringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DioSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioSpringSecurityApplication.class, args);
		System.out.println("Api Security Rodando");
	}

}
