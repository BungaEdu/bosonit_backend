package com.example.block7crudvalidation_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan
@EnableFeignClients
@EnableDiscoveryClient
//Esta etiqueta me resuleve problemas de compatibilidad entre cloud y spring boot 3.0
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class Block7CrudValidationV2Application {

	/* RECORDATORIO:
	- Has dejado comentado la parte de las validaciones de nombre para que te sirvan las pruebas y no te salte error 422
	- En el fetch de codeopen.io tienes que poner:
		+ en el add: 'http://localhost:8080/person'
		+ en el getall: 'http://localhost:8080/person/getall'
	 */

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationV2Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/person/**").allowedOrigins("https://cdpn.io").allowedMethods("*");
			}
		};
	}

}