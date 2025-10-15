package br.com.fiap.Inclusao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.Inclusao.model")
public class InclusaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(InclusaoApplication.class, args);
	}
}

