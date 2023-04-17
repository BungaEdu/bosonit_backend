package com.example.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@PostConstruct
	public void primerMensaje () {
		System.out.println("Hola desde clase inicial");
	}

	public void segundoMensaje () {
		System.out.println("Hola desde clase secundaria");
	}

	public void tercerMensaje (String mensaje) {
		System.out.println(mensaje);
	}

	@Override
	public void run(String... args) throws Exception {
		segundoMensaje();
		tercerMensaje("Prueba1MensajePorPantalla");
	}

	/*Los mensajes se muestran primero el postconstruc y después
	dependiendo del orden de ejecución que le ponga en el run
	al sobreescribirlo
	 */

}
