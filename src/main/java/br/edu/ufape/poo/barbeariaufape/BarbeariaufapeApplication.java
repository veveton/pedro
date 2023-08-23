package br.edu.ufape.poo.barbeariaufape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.edu.ufape.poo.barbeariaufape.negocio.basica")
@SpringBootApplication
public class BarbeariaufapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaufapeApplication.class, args);
	}

}
